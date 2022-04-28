// import statements
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client
{
    // initializing socket and input output streams
    private Socket            kkSocket = null;
    private PrintWriter   socketOutput = null;
    private BufferedReader socketInput = null;
    // constructor to create a socket with given IP and port address
    public Client(String address, int port)
    {
        // Establishing connection with server
        try
        {
            // Try and create the socket. This assumes the server is running on the same machine, "locaslhost".
            kkSocket = new Socket( address, port );

            // Chain a writing stream
            socketOutput = new PrintWriter(kkSocket.getOutputStream(), true);

            // Chain a reading stream
            socketInput = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));

            System.out.println("Connection Established!! ");
            System.out.println("input \"Finish\" to terminate the connection. ");

        }
        catch(UnknownHostException uh) {
            System.out.println(uh);
        }
        catch(IOException io) {
            System.out.println(io);
        }

        // Chain a reader from the keyboard.
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in) );


        String fromServer;
        String fromUser;

        // Read from server
        try
        {
            while( (fromServer=socketInput.readLine())!=null )
            {
                // Output server string
                System.out.println( "Server: " + fromServer );
                if( fromServer.equals("Bye.") ) break;

                // Read from user and output to Server
                fromUser = stdIn.readLine(); // this should be CLA
                if( fromUser!=null )
                {
                    // Output client string
                    System.out.println( "Client: " + fromUser );

                    // Output to server
                    socketOutput.println(fromUser);
                }
            }
            // Close every IO and socket
            socketOutput.close();
            socketInput.close();
            stdIn.close();
            kkSocket.close();
        }
        catch (IOException e) {
            System.err.println("I/O exception\n");
            System.exit(1);
        }

    }
    public static void main(String[] argvs) {
        // creating object of class Client
        Client client = new Client("localhost", 9999);
    }
}