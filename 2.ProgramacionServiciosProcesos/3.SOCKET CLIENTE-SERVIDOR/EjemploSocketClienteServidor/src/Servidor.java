import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
    private static final int MAXBYTES = 1000;
    private static int PORT = 3000;
    private static String  MENSAJE = "Soy JoselitoServidor, ¡gracias por tu mensaje PepitoCliente!";
    public static void main(String[] args) {
        try {
            DatagramSocket socketServidor = new DatagramSocket(PORT);
            byte[] bufferLectura = new byte[MAXBYTES];
            DatagramPacket pE = new DatagramPacket(bufferLectura,MAXBYTES);
            socketServidor.receive(pE);

            String lineaRecibida = new String (pE.getData(), 0, pE.getLength(),"UTF-8");
            System.out.println(lineaRecibida);
            InetAddress ipCliente = pE.getAddress();
            int puertoOrigenCliente = pE.getPort();
            byte[] bufferEscritura = new byte[MAXBYTES];
            bufferEscritura = "OK".getBytes();

            DatagramPacket pR = new DatagramPacket(bufferEscritura, bufferEscritura.length, ipCliente,PORT);
            socketServidor.send(pE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}