// import statements
import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{

    //initializing input stream and socket
    private ExecutorService executorService = null;
    private ServerSocket serverSocket = null;

    // constructor of the class Server
    public Server(int port)
    {
        // Starting the server and waiting for a client
        try
        {
            serverSocket = new ServerSocket(port);
            System.out.println("Server starts");
            System.out.println("Waiting for a client to connect ... ");

            // Initialise the executor.
            executorService = Executors.newCachedThreadPool();

            while( true )
            {
                System.out.println("Connected with a Client!! ");
                Socket client = serverSocket.accept();
                executorService.submit( new KKClientHandler(client) );
            }

            System.out.println(" Connection Closed!! ");
        }
        // handling errors
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String[] argvs)
    {
        // creating an object of the class ServerSide
        Server server = new Server(9999);
    }
}