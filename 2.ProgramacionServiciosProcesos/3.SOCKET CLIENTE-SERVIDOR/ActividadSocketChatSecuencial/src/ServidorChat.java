import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServidorChat {
    private static final int MAXBYTES = 1000;
    private static int PORT = 3000;
    private static int bucleActivo=1;
    private static String nombreServidor;
    private static String mensajeServidor;
    private static String mensajeFinalServidor;
    private static Boolean esVerdad;
    public static void main(String[] args) throws SocketException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket socketServidor = new DatagramSocket(PORT);
        esVerdad=false;
        do {
            try {
                //2
                //RECIBIR MENSAJEFINAL
                byte[] bufferLectura = new byte[MAXBYTES];
                DatagramPacket pR = new DatagramPacket(bufferLectura,MAXBYTES);
                socketServidor.receive(pR);
                String lineaRecibida1 = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
                
                //COMPROBAR MENSAJEFINAL
                Boolean matarServer=patronSaludo(lineaRecibida1);
                if (matarServer) {
                    System.out.println("RECIBIDO: "+lineaRecibida1);
                    if ((lineaRecibida1.equals("@hola#.@")) || (lineaRecibida1.equals("@hola# @"))) {
                        mensajeServidor=".";
                        mensajeFinalServidor = "@hola#"+mensajeServidor+"@";
                        esVerdad=true;
                    }
                }else{
                    System.out.println("PATRON ERRONEO");
                    mensajeServidor=".";
                    mensajeFinalServidor = "@hola#"+mensajeServidor+"@";
                    esVerdad=true;
                }
                

                //ESCRIBIR MENSAJESERVIDOR
                if (esVerdad==false) {
                    System.out.println("ESCRIBE TU MENSAJE");
                    mensajeServidor = sc.nextLine();
                    mensajeFinalServidor = "@hola#"+mensajeServidor+"@";
                }
                
    
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
    private static boolean patronSaludo(String lineaRecibida1) {
        Pattern patSaludo = Pattern.compile("@hola#(.+)@");
                Matcher m = patSaludo.matcher(lineaRecibida1);
                if (m.find()) {
                    nombreServidor = m.group(1);
                    //System.out.println(lineaRecibida1);
                    return true;
                }else
                    return false;
    }
}