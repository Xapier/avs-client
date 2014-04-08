package avsclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NumberingClient {
	
	public static final int PORT = 6666;
	public static final String HOST = "141.45.193.85"; 

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(HOST, PORT);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		int z = (int) (Math.random()*100);
		out.println(z);
		System.out.println("Der Server antwortet: " + in.readLine());
		
		out.close();
		in.close();
		socket.close();

	}

}
