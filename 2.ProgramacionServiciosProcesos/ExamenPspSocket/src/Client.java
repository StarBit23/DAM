import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int serverPort = 5000;
        String serverHost = "localhost";
        Socket comSocket;
        InetAddress serverIp;
        String rLine;
        String wLine;
        try {
            comSocket = new Socket(serverHost, serverPort);
            serverIp = comSocket.getInetAddress();
            System.out.println("Conexion establecida con servidor " + serverIp.getHostAddress());
            System.out.println("Conectado con servidor (help para ver la ayuda)");
            Scanner br = new Scanner(comSocket.getInputStream());
            PrintWriter pw = new PrintWriter(comSocket.getOutputStream());
            System.out.print(">");

            while ((rLine = sc.nextLine()).length() > 0) {
                pw.println(rLine);
                pw.flush();
                while ((wLine = br.nextLine()).length() >0 ){

                    System.out.println("shell-cliente> "+wLine);
                }

                System.out.print(">");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (NoSuchElementException ex){
            System.out.println("Desconectado del servidor");
        }
    }
}
