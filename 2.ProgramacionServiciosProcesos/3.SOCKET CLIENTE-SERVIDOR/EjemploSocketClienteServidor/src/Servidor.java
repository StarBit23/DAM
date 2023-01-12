import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
    private static final int MAXBYTES = 1000;
    private static String  HOST = "localhost";
    private static int PORT = 3000;
    private static String  MENSAJE2 = "Soy JoselitoServidor, ¡gracias por tu mensaje PepitoCliente!";
    public static void main(String[] args) {
        try {
            //2.RECIBIR
            DatagramSocket socketServidor = new DatagramSocket(PORT);
            byte[] bufferLectura = new byte[MAXBYTES];
            DatagramPacket pR = new DatagramPacket(bufferLectura,MAXBYTES);
            socketServidor.receive(pR);

            String lineaRecibida = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
            System.out.println("SERVIDOR: "+lineaRecibida);
            //socketServidor.close();
            
            //3.ENVIAR
            InetAddress ipCliente = pR.getAddress();
            int puertoOrigenCliente = pR.getPort();
            byte[] bufferEscritura = new byte[MAXBYTES];
            bufferEscritura = MENSAJE2.getBytes();
            DatagramPacket pEE = new DatagramPacket(bufferEscritura, bufferEscritura.length, ipCliente,puertoOrigenCliente);
            socketServidor.send(pEE);

            
            //DatagramSocket socketEnviarServidor = new DatagramSocket();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}