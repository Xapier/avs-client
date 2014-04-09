package avsclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NumberingClientTCP {
	
	public static final int PORT = 6666;
	public static final String HOST = "141.45.194.214"; 

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(HOST, PORT);
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		int z = (int) (Math.random()*100);
		writer.println(z);
		System.out.println("Gesendet wurde: " + z);
		System.out.println("Empfangen wurde : " + reader.readLine());
		writer.close();
		reader.close();
		socket.close();

	}
	


}
