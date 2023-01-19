import java.io.IOException;
import java.net.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ClienteChat {
    private static final int MAXBYTES = 1000;
    private static String  HOST = "localhost";
    private static int PORT = 3000;
    private static String condicion = "S";
    private static Boolean condicionFinal=false;
    private static String nombreCliente="";
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("NOMBRE CLIENTE");
        nombreCliente = sc.nextLine();
        do {
            try {
                
                String aMandar = "";
                
                montarEstructura(aMandar,nombreCliente);

                //1
                InetAddress ipServidor = InetAddress.getByName(HOST);
                DatagramSocket socketCliente = new DatagramSocket();
                
                //MENSAJE
                byte[] bufferEscritura = new byte[MAXBYTES];
                bufferEscritura = aMandar.getBytes();
                DatagramPacket pE = new DatagramPacket(bufferEscritura, bufferEscritura.length,ipServidor,PORT);
                socketCliente.send(pE);
                System.out.println("MENSAJE ENVIADO A SERVIDOR");
    
    
                //4
                byte[] bufferLectura = new byte[MAXBYTES];
                DatagramPacket pR = new DatagramPacket(bufferLectura, MAXBYTES);
                socketCliente.receive(pR);
                String lineaRecibida = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
                LocalTime ahora = LocalTime.now();
                System.out.println(ahora+"||"+"res: "+lineaRecibida);
                System.out.println("///////////////////////////////////////////");
                System.out.println("MAS MENSAJES? S o N");
                condicion = sc.nextLine();
                switch (condicion) {
                    case "S":break;
                    case "N": condicionFinal=true; break;
                    default:condicionFinal=true;break;
                }
    
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (condicionFinal==false);
            
        
        
    }


    private static String montarEstructura(String aMandar, String nombreCliente) {
        Scanner sc = new Scanner(System.in);
        System.out.println("DIME MENSAJE A MANDAR");
        aMandar = sc.nextLine();
        String saludo = "@"+aMandar+"#"+nombreCliente+"@";
        return saludo;
    }


}