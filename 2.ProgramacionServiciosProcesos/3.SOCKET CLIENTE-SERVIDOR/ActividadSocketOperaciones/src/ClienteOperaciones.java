import java.io.IOException;
import java.net.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ClienteOperaciones {
    private static final int MAXBYTES = 1000;
    private static String  HOST = "localhost";
    private static int PORT = 3000;
    private static String  operando1 = "";
    private static String  operacion = "";
    private static String  operando2 = "";
    private static String condicion = "S";
    private static Boolean condicionFinal=false;

    public static void main(String[] args) {
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("DIME OPERANDO1");
                operando1 = sc.nextLine();
                System.out.println("DIME OPERACION");
                operacion = sc.nextLine();
                System.out.println("DIME OPERANDO2");
                operando2 = sc.nextLine();
                //1
                InetAddress ipServidor = InetAddress.getByName(HOST);
                DatagramSocket socketCliente = new DatagramSocket();
                String aMandar = operando1 + "," + operacion + "," + operando2;
                //OPERANDO1
                byte[] bufferEscritura = new byte[MAXBYTES];
                bufferEscritura = aMandar.getBytes();
                DatagramPacket pE = new DatagramPacket(bufferEscritura, bufferEscritura.length,ipServidor,PORT);
                socketCliente.send(pE);
                System.out.println("operacion ENVIADO A SERVIDOR");
    
                //4
                byte[] bufferLectura = new byte[MAXBYTES];
                DatagramPacket pR = new DatagramPacket(bufferLectura, MAXBYTES);
                socketCliente.receive(pR);
                String lineaRecibida = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
                LocalTime ahora = LocalTime.now();
                System.out.println(ahora+"||"+"res: "+lineaRecibida+"\n");

                System.out.println("///////////////////////////////////////////");

                System.out.println("QUIERES HACER MAS CUENTAS? S o N");
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


}