import java.io.IOException;
import java.net.*;

public class Cliente {
    private static final int MAXBYTES = 1000;
    private static String  HOST = "localhost";
    private static int PORT = 3000;
    private static String  MENSAJE = "Soy PepitoCliente, ¿como vas JoselitoServidor?";

    public static void main(String[] args) {
        try {
            InetAddress ipServidor = InetAddress.getByName(HOST);
            DatagramSocket socketCliente = new DatagramSocket();
            byte[] bufferEscritura = new byte[MAXBYTES];
            bufferEscritura = MENSAJE.getBytes();
            DatagramPacket pE = new DatagramPacket(bufferEscritura, bufferEscritura.length,ipServidor,PORT);
            socketCliente.send(pE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}