package bg.sofia.uni.fmi.mjt.chat;

public class Server {
	
	public static void main(String[] args) {
		
		ChatServer server = ChatServer.startNewChatServer();
		server.start();
		
	}

}
