import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void run() throws UnknownHostException, IOException {
        int port = 8010;

        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);
        // to send data to the server by wrtiting to the output stream
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
        // receive data from server
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello form the client");
        String line = fromSocket.readLine();
        System.out.println("Response from the server is : " + line);

        toSocket.close();
        fromSocket.close();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
