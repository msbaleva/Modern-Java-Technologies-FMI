package bg.sofia.uni.fmi.mjt.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ChatServer {

	private static final String SERVER_HOST = "localhost";
	public static final int SERVER_PORT = 2020;
	private static final int BUFFER_SIZE = 1024;
	private static final int SLEEP_MILLIS = 500;
	
	private static final String NICK_COMMAND = "nick";
	private static final String SEND_COMMAND = "send";
	private static final String SEND_ALL_COMMAND = "send-all";
	private static final String LIST_USERS_COMMAND = "list-users";
	private static final String DISCONNECT_COMMAND = "disconnect";
	
	private static final String ACTIVE_USERS_MESSAGE = "Active users: ";
	private static final String BUFFER_ERROR_MESSAGE = "Problem reading from buffer";
	private static final String DATE_FORMAT = "[yyyy-MM-dd HH:mm:ss]";
	private static final String DISCONNECTED_MESSAGE = "Disconnected from server";
	private static final String INVALID_COMMAND_MESSAGE = "Invalid command.";
	private static final String IOEXCEPTION_MESSAGE = "A problem occured with the chat server.";
	private static final String NICKNAME_TAKEN_MESSAGE = "Nickname is already taken.";
	private static final String USER_NOT_ACTIVE_MESSAGE = "User is not active";
	private static final String WAITING_USERS_MESSAGE = "Waiting for users to log.";
	
	private ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
	private Map<String, SocketChannel> activeUsersByNicknames = new HashMap<>();

	public static ChatServer startNewChatServer() {
		return new ChatServer();
	}

	private String findUsernameBySocketChannel(SocketChannel socketChannel) {
		for (String user : activeUsersByNicknames.keySet()) {
			if (activeUsersByNicknames.get(user).equals(socketChannel)) {
				return user;
			}
		}

		return null;
	}

	private void sendToChannel(String message, SocketChannel userChannelRecipient) {
		buffer.clear();
		buffer.put(message.getBytes());
		System.out.println(message);
		buffer.flip();
		try {
			userChannelRecipient.write(buffer);
		} catch (IOException e) {
			throw new RuntimeException(BUFFER_ERROR_MESSAGE, e);
		}
	}

	private String getCurrentTimeStamp() {
		return new SimpleDateFormat(DATE_FORMAT).format(new Date());
	}

	private void executeNick(String nickname, SocketChannel socketChannel) {
		String message = nickname + " is now online.";
		if (activeUsersByNicknames.get(nickname) == null) {
			activeUsersByNicknames.put(nickname, socketChannel);
		} else {
			message = NICKNAME_TAKEN_MESSAGE;
		}

		sendToChannel(message, socketChannel);

	}

	private void executeSend(String userRecipient, String readMessage, SocketChannel userChannelSender) {
		SocketChannel userChannelRecipient = activeUsersByNicknames.get(userRecipient);
		if (!userChannelSender.equals(userChannelRecipient)) {
			String userSender = findUsernameBySocketChannel(userChannelSender);
			if (userChannelRecipient == null) {
				sendToChannel(new String("User [" + userRecipient + "] seems to be offline"), userChannelSender);
			} else {
				int offset = SEND_COMMAND.length() + 1 + userRecipient.length() + 1;
				sendToChannel(
						new String(getCurrentTimeStamp() + " " + userSender + ": " + readMessage.substring(offset)),
						userChannelRecipient);
			}
		}

	}

	private void executeSendAll(String readMessage, SocketChannel userChannelSender) {
		int offset = SEND_ALL_COMMAND.length() + 1;
		String userSender = findUsernameBySocketChannel(userChannelSender);
		String message = new String(getCurrentTimeStamp() + " " + userSender + ": " + readMessage.substring(offset));
		System.out.println(message);
		buffer.clear();
		buffer.put(message.getBytes());
		for (String userRecipient : activeUsersByNicknames.keySet()) {
			SocketChannel userChannelRecipient = activeUsersByNicknames.get(userRecipient);
			if (!userChannelSender.equals(userChannelRecipient)) {
				buffer.flip();
				try {
					userChannelRecipient.write(buffer);
				} catch (IOException e) {
					throw new RuntimeException(BUFFER_ERROR_MESSAGE, e);
				}
			}
		}
	}

	private void executeListUsers(SocketChannel socketChannel) {
		String activeUsers = activeUsersByNicknames.keySet().stream().collect(Collectors.joining(", "));
		sendToChannel(ACTIVE_USERS_MESSAGE + activeUsers, socketChannel);
	}

	private void executeDisconnect(SocketChannel socketChannel) {
		for (String user : activeUsersByNicknames.keySet()) {
			if (activeUsersByNicknames.get(user).equals(socketChannel)) {
				activeUsersByNicknames.remove(user);
				sendToChannel(DISCONNECTED_MESSAGE, socketChannel);
				break;
			}
		}

	}

	public Map<String, SocketChannel> getActiveUsers() {
		return activeUsersByNicknames;
	}

	public void start() {
		try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

			serverSocketChannel.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
			serverSocketChannel.configureBlocking(false);

			Selector selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

			boolean running = true;
			while (running) {
				int readyChannels = selector.select();
				if (readyChannels == 0) {
					System.out.println(WAITING_USERS_MESSAGE);
					try {
						Thread.sleep(SLEEP_MILLIS);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					continue;
				}

				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

				while (keyIterator.hasNext()) {
					SelectionKey key = keyIterator.next();
					if (key.isReadable()) {
						SocketChannel userChannel = (SocketChannel) key.channel();

						buffer.clear();
						int read = userChannel.read(buffer);
						if (read <= 0) {
							//System.out.println("nothing to read, will close channel");
							userChannel.close();
							break;
						}

						buffer.flip();
						String readMessage = new String(buffer.array(), 0, buffer.limit());
						String[] message = readMessage.split(" ");
						String command = message[0];

						if (command.equals(NICK_COMMAND)) {
							executeNick(message[1], userChannel);

						} else if (!activeUsersByNicknames.containsValue(userChannel)) {
							sendToChannel(USER_NOT_ACTIVE_MESSAGE, userChannel);

						} else if (command.equals(SEND_COMMAND)) {
							executeSend(message[1], readMessage, userChannel);

						} else if (command.equals(SEND_ALL_COMMAND)) {
							executeSendAll(readMessage, userChannel);

						} else if (command.equals(LIST_USERS_COMMAND)) {
							executeListUsers(userChannel);

						} else if (command.equals(DISCONNECT_COMMAND)) {
							executeDisconnect(userChannel);

						} else {
							sendToChannel(INVALID_COMMAND_MESSAGE, userChannel);

						}

					} else if (key.isAcceptable()) {
						ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();
						SocketChannel accept = socketChannel.accept();
						accept.configureBlocking(false);
						accept.register(selector, SelectionKey.OP_READ);
					}

					keyIterator.remove();
				}

			}

		} catch (IOException e) {
			throw new RuntimeException(IOEXCEPTION_MESSAGE, e);
		}
	}

}
