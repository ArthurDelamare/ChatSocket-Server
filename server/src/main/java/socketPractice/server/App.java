package socketPractice.server;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ServerSocketListener serverSocketListener = new ServerSocketListener();
        Thread threadServer = new Thread(serverSocketListener);
        threadServer.start();
    }
}
