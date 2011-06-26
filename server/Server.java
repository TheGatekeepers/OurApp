import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("Server start");

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(1337);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 1337.");
			System.exit(1);
		}

		Socket socket = null;
		try {
			socket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String inputLine, outputLine;

		System.out.println("Server start loop");
		while ((inputLine = in.readLine()) != null) {
			 System.out.println("[" + inputLine + "]");
			 if (inputLine.equals("Bye."))
				break;
		}
		System.out.println("Server end loop");

		out.close();
		in.close();
		socket.close();
		serverSocket.close();

		System.out.println("Server end");
	}
}
