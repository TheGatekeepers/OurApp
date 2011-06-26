import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) throws IOException {
		System.out.println("Client start");

		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			//socket = new Socket("localhost", 1337);
			socket = new Socket("50.18.82.15", 50000);
			//socket = new Socket("ec2-50-18-82-15.us-west-1.compute.amazonaws.com", 1337);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to host.");
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String fromServer;
		String fromUser;

		System.out.println("Client start loop");
		while ((fromUser = stdIn.readLine()) != null) {
			out.println(fromUser);
			if (fromUser.equals("Bye."))
				break;
		}
		System.out.println("Client end loop");

		out.close();
		in.close();
		stdIn.close();
		socket.close();

		System.out.println("Client end");
	}
}
