package chatSecuencial;
import java.io.IOException;
import java.net.*;
import java.time.LocalTime;
import java.util.Scanner;

public class ClienteChat {
    private static final int MAXBYTES = 1000;
    private static String  HOST = "localhost";
    private static int PORT = 3000;
    private static Boolean condicionFinal=false;
    private static String nombreCliente="";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                //ESTRUCTURA MENSAJEFINAL
                String aMandar = "";
                System.out.println("¿Que quieres saber?");
                System.out.println("1- NOMBRE");
                System.out.println("2- APELLIDOS");
                System.out.println("3- EDAD");
                aMandar = sc.nextLine();
                String mensajeFinal = aMandar;

                //1
                InetAddress ipServidor = InetAddress.getByName(HOST);
                DatagramSocket socketCliente = new DatagramSocket();
                
                byte[] bufferEscritura = new byte[MAXBYTES];
                bufferEscritura = mensajeFinal.getBytes();
                DatagramPacket pE = new DatagramPacket(bufferEscritura, bufferEscritura.length,ipServidor,PORT);
                socketCliente.send(pE);
                //System.out.println(mensajeFinal);
                System.out.println("MENSAJE ENVIADO A SERVIDOR");
    
                //4
                byte[] bufferLectura = new byte[MAXBYTES];
                DatagramPacket pR = new DatagramPacket(bufferLectura, MAXBYTES);
                socketCliente.receive(pR);
                String lineaRecibida = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
                LocalTime ahora = LocalTime.now();
                System.out.println(ahora+"||"+"res: "+lineaRecibida);
                
                System.out.println("///////////////////////////////////////////\n");

                
    
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (condicionFinal==false);
        
    }


}