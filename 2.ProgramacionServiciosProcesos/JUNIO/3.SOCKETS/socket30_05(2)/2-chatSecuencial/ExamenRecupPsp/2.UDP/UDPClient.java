import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    private static final int MAXBYTES = 1000;
    private static String  HOST = "localhost";
    private static int PORT = 8500;

    //yyyy año, MM mes, dd dia, HH hora, mm minuto, ss segundo, a dia/tarde
    //puede ponerse por separado y con caracteres especiales entre medias
    
    public static void main(String[] args) {
        try {
            //creo datagrama de envio
            DatagramSocket socket = new DatagramSocket();
            InetAddress ipServidor = InetAddress.getByName(HOST);
            int puertoServidor = PORT;

            Scanner scanner = new Scanner(System.in);
            String lectura;
            
            do {
                //ENVIO
                //recojo entrada del teclado
                System.out.print("-fecha> ");
                lectura = scanner.nextLine();
                
                //envio el mensaje al servidor
                byte[] bufferEscritura = new byte[MAXBYTES];
                bufferEscritura = lectura.getBytes();
                DatagramPacket datagramEnvio = new DatagramPacket(bufferEscritura, bufferEscritura.length, ipServidor, puertoServidor);
                socket.send(datagramEnvio);

                //RECIBO
                //creo datagrama de recibo
                byte[] bufferLectura = new byte[MAXBYTES];
                DatagramPacket datagramRespuesta = new DatagramPacket(bufferLectura, bufferLectura.length);
                socket.receive(datagramRespuesta);
                
                String respuestaFinal = new String(datagramRespuesta.getData()).trim();
                System.out.println("Respuesta: " + respuestaFinal);
            } while (!lectura.isEmpty());
            
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
