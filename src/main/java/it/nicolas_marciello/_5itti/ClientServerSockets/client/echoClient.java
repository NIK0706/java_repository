package it.nicolas_marciello._5itti.ClientServerSockets.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class echoClient {
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void startConnection(String ip, int port) throws IOException {
		clientSocket = new Socket(ip, port);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}

	public void sendMsg(String msg){
		if(out != null){
			out.println(msg);
		}
	}

	public String receiveMsg() throws IOException {
		if(in == null){
			return null;
		}else{
			String response = in.readLine();
			return response;
		}
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	// Chiusura delle risorse con controllo di nullità (NllPointerException)
	public void stopConnection() {
		try{
			if(in != null){ in.close();}
		}catch(IOException ignored){}
		if(out != null){ out.close();}
		try{
			if(clientSocket != null){ clientSocket.close();}
		}catch(IOException ignored){}
	}
}
