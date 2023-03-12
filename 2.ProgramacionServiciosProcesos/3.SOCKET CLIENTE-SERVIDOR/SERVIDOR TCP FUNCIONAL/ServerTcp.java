import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.management.RuntimeErrorException;


public class ServerTcp {
 public static void main(String[] args) {
    args = new String[1];
    args[0] = "3000";
    int numPuertoServidor = Integer.parseInt(args[0]);
    int numPuertoCliente;

    ServerSocket serverSocket;
    Socket socketComunicacion;
    InetAddress ipCliente;

    try {
      serverSocket = new ServerSocket(numPuertoServidor);

      while(true){
         socketComunicacion = serverSocket.accept();
         ipCliente = socketComunicacion.getInetAddress();
         numPuertoCliente = socketComunicacion.getPort();
         System.out.println("Conexion establecida con la ip "+ ipCliente +" en el puerto "+ numPuertoCliente);

         //Creamos un nuevo hilo por cada cliente que quiera usar el servidor
         ServerTcpThread serverThread = new ServerTcpThread(socketComunicacion);
         serverThread.start();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
 }    
}
