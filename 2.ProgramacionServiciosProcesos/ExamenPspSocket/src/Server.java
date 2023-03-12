import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Recurso recurso = new Recurso();
        int serverPort = 5000;
        ServerSocket serverSocket;
        Socket comSocket = null;
        InetAddress clientIp;
        int clientPort;
        recurso.fillList();
        try {
            serverSocket = new ServerSocket(serverPort);

            while (true) {
                comSocket = serverSocket.accept();
                clientIp = comSocket.getInetAddress();
                clientPort = comSocket.getPort();
                System.out.println("Conexion con ip " + clientIp + " en el puerto " + clientPort);

                ServerThread serverThread = new ServerThread(comSocket,recurso);
                serverThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}