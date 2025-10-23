package it.nicolas_marciello.AS25_26.ClientServerSockets.server.multipleRecipients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class echoServer implements Runnable {
	private static ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	@Override
	public void run(){
		System.out.println("Thread created for client: " + ((clientSocket.getInetAddress()).toString()).replace("/", ""));
		try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			sendMsg("Ciao dal server!");
			System.out.println("(C: " + ((clientSocket.getInetAddress()).toString()).replace("/", "") + ") > " + receiveMsg());
		} catch (IOException ignored) {}
	}

	public void stopConnection() throws IOException{
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}

	public void sendMsg(String msg){
		out.println(msg);
	}

	public String receiveMsg() throws IOException {
		String response = in.readLine();
		return response;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Server avviato");
		echoServer server = new echoServer();
		echoServer.serverSocket = new ServerSocket(5656); // Il server rimane in ascolto sulla porta 5656
		while(true){ // Ciclo infinito per accettare connessioni multiple
			// Il server accetta una connessione ed avvia un thread per gestirla
			server.clientSocket = serverSocket.accept();
			server.run();
		}
	}
}