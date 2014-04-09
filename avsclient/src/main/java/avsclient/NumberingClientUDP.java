package avsclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NumberingClientUDP {

	public static final int PORT = 6666;
	public static final String HOST = "141.45.194.214";

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		byte[] buffer = new byte[256];
		InetAddress adress = InetAddress.getByName(HOST);
		for (int i = 0; i < 10; i++) {
			int z = (int) (Math.random() * 100);
			String timeAndNumber = generateTimestamp() + " mit Zahl " + z;
			buffer = timeAndNumber.getBytes();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
					adress, PORT);
			socket.send(packet);
			System.out.println("Gesendet wurde: " + timeAndNumber);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		socket.close();

	}

	public static String generateTimestamp() {
		Date time = Calendar.getInstance().getTime();
		SimpleDateFormat simpleDate = new SimpleDateFormat();
		return simpleDate.format(time).toString();
	}

}
