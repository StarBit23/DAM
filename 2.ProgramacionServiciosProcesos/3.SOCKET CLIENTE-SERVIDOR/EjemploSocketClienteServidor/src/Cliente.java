import java.io.IOException;
import java.net.*;

public class Cliente {
    private static final int MAXBYTES = 1000;
    private static String  HOST = "192.168.17.162";
    private static int PORT = 3000;
    //private static int PORT2 = 300;
    private static String  MENSAJE = "Soy PepitoCliente, ¿como vas JoselitoServidor?";

    public static void main(String[] args) {
        try {
            //1.ENVIAR
            InetAddress ipServidor = InetAddress.getByName(HOST);
            DatagramSocket socketCliente = new DatagramSocket();
            byte[] bufferEscritura = new byte[MAXBYTES];
            bufferEscritura = MENSAJE.getBytes();
            DatagramPacket pE = new DatagramPacket(bufferEscritura, bufferEscritura.length,ipServidor,PORT);
            socketCliente.send(pE);
            //socketCliente.close();

            //4.RECIBIR
            //DatagramSocket socketRecibirCliente = new DatagramSocket(PORT);
            byte[] bufferLectura = new byte[MAXBYTES];
            DatagramPacket pR = new DatagramPacket(bufferLectura,MAXBYTES);
            socketCliente.receive(pR);

            String lineaRecibida = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
            System.out.println("CLIENTE: "+lineaRecibida);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}