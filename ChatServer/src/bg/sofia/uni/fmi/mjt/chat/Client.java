package bg.sofia.uni.fmi.mjt.chat;

public class Client {
	
	public static void main(String[] args) {
		
		ChatClient client = ChatClient.startNewChatClient();
		client.start();
		
	}

}
