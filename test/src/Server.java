// import statements
import java.net.*;
import java.io.*;
public class Server
{
    //initializing input stream and socket
    private DataInputStream inStream = null;
    private Socket skt = null;
    private ServerSocket srvr = null;
    // constructor of the class Server
    public Server(int port)
    {
        // Starting the server and waiting for a client
        try
        {
            srvr = new ServerSocket(port);
            System.out.println("Server starts");
            System.out.println("Waiting for a client to connect ... ");
            skt = srvr.accept(); // waiting for  a client to send connection request
            System.out.println("Connected with a Client!! ");
            // Receiving input messages from the client using socket
            inStream = new DataInputStream( skt.getInputStream() );
            String str = ""; // variable for reading messages sent by the client
            // Untill "Finish" is sent by the client,
            // keep reading messages
            while (!str.equals("Finish"))
            {
                try
                {
                    // reading from the underlying stream
                    str = inStream.readUTF();
                    // printing the read message on the console
                    System.out.println( str );
                }
                // For handling errors
                catch(IOException io)
                {
                    System.out.println( io );
                }
            }
            // closing the established connection
            skt.close();
            inStream.close();
            System.out.println(" Connection Closed!! ");
        }
        // handling errors
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String argvs[])
    {
        // creating an object of the class ServerSide
        Server server = new Server(6666);
    }
}