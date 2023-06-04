package chatSecuencial;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ServidorChat {
    private static final int MAXBYTES = 1000;
    private static int PORT = 3000;
    private static int bucleActivo=1;
    private static String nombreServidor;
    private static String mensajeServidor;
    private static String mensajeFinalServidor;
    public static void main(String[] args) throws SocketException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket socketServidor = new DatagramSocket(PORT);

        System.out.println("Nombre? (ej: Pepe)");
        String nombre=sc.nextLine();

        System.out.println("Apellidos? (ej: Garcia Lozano)");
        String apellidos=sc.nextLine();

        System.out.println("Edad? (ej: 21)");
        String edad=sc.nextLine()+" annos";
        do {
            try {
                //2
                //RECIBIR MENSAJEFINAL
                byte[] bufferLectura = new byte[MAXBYTES];
                DatagramPacket pR = new DatagramPacket(bufferLectura,MAXBYTES);
                socketServidor.receive(pR);
                String lineaRecibida1 = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
                
                //COMPROBAR MENSAJEFINAL                
                System.out.println("RECIBIDO: "+lineaRecibida1);
                mensajeServidor=".";
                mensajeFinalServidor = mensajeServidor;
                

                //ESCRIBIR MENSAJESERVIDOR
                System.out.println("ESCRIBE TU MENSAJE");
                switch (lineaRecibida1) {
                    case "1":
                    mensajeServidor=nombre;
                    break;
                
                    case "2":
                    mensajeServidor=apellidos;
                    break;

                    case "3":
                    mensajeServidor=edad;
                    break;

                    default:
                    break;
                }
                mensajeFinalServidor = mensajeServidor;
                
                //3
                InetAddress ipCliente = pR.getAddress();
                int puertoOrigenCliente = pR.getPort();
                byte[] bufferEscritura = new byte[MAXBYTES];
                bufferEscritura = mensajeFinalServidor.getBytes();
    
                DatagramPacket pE = new DatagramPacket(bufferEscritura, bufferEscritura.length, ipCliente,puertoOrigenCliente);
                socketServidor.send(pE);
                System.out.println(mensajeFinalServidor+" ENVIADO A CLIENTE");
    
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (bucleActivo==1);
        

    }
    
}
