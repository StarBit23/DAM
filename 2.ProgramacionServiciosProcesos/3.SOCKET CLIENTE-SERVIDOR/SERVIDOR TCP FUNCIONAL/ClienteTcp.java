/**
 * Versión echo con TCP para el cliente pero 
 * @author: Santiago Rodenas Herráiz
 * @version: 5/12/2021
 * @param: Acepta el puerto e ip del servidor
 * 
 */


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTcp {
    public static final Scanner ioS = new Scanner(System.in);
    
    public static void main(String[] args) {
        args = new String[2];
        args[0] = "3000";
        args[1] = "localhost";
        int numPuertoServidor = Integer.parseInt(args[0]);
        String hostServidor = args[1];

        Socket socketComunicacion;
        InetAddress ipServidor;
        String rLine;
        
        try{
            //Creamos el socket del servidor.
                socketComunicacion = new Socket(hostServidor, numPuertoServidor);
                ipServidor=socketComunicacion.getInetAddress();
                System.out.println("Cliente conectado con servidor"+ipServidor.getHostAddress());

                Scanner br = new Scanner (socketComunicacion.getInputStream());
                PrintWriter pw = new PrintWriter(socketComunicacion.getOutputStream());
                System.out.print(">");

                while ((rLine = ioS.nextLine()).length() > 0){  
                    pw.println(rLine);
                    pw.flush();
                    System.out.println("Ya he mandado al socket");
                    System.out.println("Respuesta: "+ br.nextLine());
                    System.out.print(">");       
                }


        }  
        catch (UnknownHostException ex){
            System.out.printf("Servidor desconocido %s%n", hostServidor);
            ex.printStackTrace();
            System.exit(2);
        } 
        catch (IOException e){
            System.out.println("Error en flujo de E/S");
            e.printStackTrace();
            System.exit(1);
        }
       
     }   //fin main
}  //fin clase
