package it.nicolas_marciello._5itti.ClientServerSockets.client;

import java.io.IOException;
import java.util.Scanner;

public class mainClient {
	static echoClient client;
	public static void main(String[] args) {
		client = new echoClient();
		String serverIP = "192.168.1.58";
		int port = 5656;

		try {
			String response, inputString;
			client.startConnection(serverIP, port);

			// Prima comunicazione di prova con il server
			response = communicate("Ciao dal client!");
			formatResponse(response);

			// Ciclo di comunicazione con il server (fino a quando non si invia "ESC")
			while(!"ESC".equals(inputString = input())){
				response = communicate(inputString);
				formatResponse(response);
			}
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

	// Comunica con il server inviando un messaggio e ricevendo la risposta
	public static String communicate(String msgToSend) throws IOException {
		client.sendMsg(msgToSend);
		return client.receiveMsg();
	}

	// Formatta e stampa la risposta ricevuta dal server
	public static void formatResponse(String response){
		System.out.println("(S: " + ((client.getClientSocket().getInetAddress()).toString()).replace("/", "") + ") > " + response);
	}
}
