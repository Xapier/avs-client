package avsclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NumberingClient {
	
	public static final int PORT = 6666;
	public static final String HOST = "141.45.193.85"; 

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(HOST, PORT);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		for (int i = 0 ; i < 10; i++ ) {
		int z = (int) (Math.random()*100);
		String time = generateTimestamp(); 
		out.println(time + z);
		System.out.println("Gesendet wurde: " + z + " am " + time);
		System.out.println("Der Server antwortet: " + in.readLine());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		out.close();
		in.close();
		socket.close();

	}
	
	public static String generateTimestamp() {
		Date time = Calendar.getInstance().getTime();
		SimpleDateFormat simpleDate = new SimpleDateFormat();
		return simpleDate.format(time).toString();
		}

}
