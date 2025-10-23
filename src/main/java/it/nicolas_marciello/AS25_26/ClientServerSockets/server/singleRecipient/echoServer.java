package it.nicolas_marciello.AS25_26.ClientServerSockets.server.singleRecipient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class echoServer {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void startServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}

	public void stop(){
		try{
			if(in != null){ in.close();}
		}catch(IOException ignored){}
		if(out != null){ out.close();}
		try{
			if(clientSocket != null){ clientSocket.close();}
		}catch(IOException ignored){}
		try{
			if(serverSocket != null){ serverSocket.close();}
		}catch(IOException ignored){}
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

	public static void main(String[] args) throws IOException {
		echoServer server = new echoServer();
		server.startServer(5656);
		try {
			System.out.println(((server.clientSocket.getInetAddress()).toString()).replace("/", "") + " connected.");
			server.sendMsg("Sussy");
			System.out.println(server.receiveMsg());
		} catch (IOException e) {
			e.getMessage();
		} finally {
			server.stop();
		}
	}
}