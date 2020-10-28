package bg.sofia.uni.fmi.mjt.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChatClient {
	
	private static final int SERVER_PORT = 2020;
    private static final String SERVER_HOST = "localhost";
    private static final int BUFFER_SIZE = 1024;
    private static final String DISCONNECT_COMMAND = "disconnect";
    private static final String IOEXCEPTION_MESSAGE = "A problem occured with the chat client.";
    private ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
    
    public static ChatClient startNewChatClient() {
    	return new ChatClient();
    }
	
    public void start() {

        try (SocketChannel socketChannel = SocketChannel.open();
             Scanner scanner = new Scanner(System.in)) {

            socketChannel.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT));

            System.out.println("Connected to chat server.");

            boolean running = true;
            while (running) {
                System.out.print("=> ");
                String message = scanner.nextLine(); 

                buffer.clear();
                buffer.put(message.getBytes());
                buffer.flip();
                socketChannel.write(buffer);

                buffer.clear();
                socketChannel.read(buffer);
                buffer.flip();
                String reply = new String(buffer.array(), 0, buffer.limit());
                System.out.println(reply);
                if (message.equals(DISCONNECT_COMMAND)) {
                	running = false;
                    continue;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(IOEXCEPTION_MESSAGE, e);
        }
    }
    

}
