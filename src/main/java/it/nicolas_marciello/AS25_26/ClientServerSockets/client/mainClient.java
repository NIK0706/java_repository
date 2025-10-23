package it.nicolas_marciello.AS25_26.ClientServerSockets.client;

import java.io.IOException;
import java.util.Scanner;

public class mainClient {
	public static void main(String[] args) {
		echoClient client = new echoClient();
		String serverIP = "192.168.1.58";
		int port = 5656;

		try {
			client.startConnection(serverIP, port);
			client.sendMsg("Ciao dal client!");
			// System.out.print("(C)> ");
			// client.sendMsg(input());
			System.out.println("(S: " + ((client.getClientSocket().getInetAddress()).toString()).replace("/", "") + ") > " + client.receiveMsg());
		} catch (IOException e) {
			System.err.println("Errore di connessione: " + e.getMessage());
		}finally {
			System.err.println("Disconnessione dal server.");
			client.stopConnection();
		}
	}

	public static String input(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		return text;
	}
}
