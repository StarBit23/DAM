import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cliente {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int serverPort = 3000;
        String serverHost = "localhost";
        Socket comSocket;
        InetAddress serverIp;
        String rLine;
        String wLine;

        boolean bucleActivo=true;
        try {
             comSocket = new Socket(serverHost, serverPort);
             serverIp = comSocket.getInetAddress();
             System.out.println("Conexion establecida con servidor " + serverIp.getHostAddress());
             Scanner br = new Scanner(comSocket.getInputStream());
            
             PrintWriter pw = new PrintWriter(comSocket.getOutputStream());
             System.out.print(">");

             while ((rLine = sc.nextLine()).length() > 0 || bucleActivo==true) {
                pw.println(rLine);
                pw.flush();
                
                wLine = br.nextLine();
                System.out.println("> "+wLine);
            
                System.out.print(">");
              }
            
            
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (NoSuchElementException ex){
            System.out.println("Desconectado del servidor");
        }
    
  }
}