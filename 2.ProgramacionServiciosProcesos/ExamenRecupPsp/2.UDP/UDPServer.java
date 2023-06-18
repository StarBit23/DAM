import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPServer {
    private static final int MAXBYTES = 1000;
    private static int PORT = 8500;
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Servidor inciado");
            
            byte[] buffer = new byte[MAXBYTES];
            
            while (true) {
                //1- RECIBO mensaje de cliente
                DatagramPacket datagramRespuesta = new DatagramPacket(buffer, buffer.length);
                socket.receive(datagramRespuesta);
                String dateFormat = new String(datagramRespuesta.getData()).trim();
                System.out.println("Recibido: " + dateFormat);
                
                //2- uso SimpleDateFormat para generar la respuesta
                String mensajeFinal;
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                    mensajeFinal = sdf.format(new Date());
                } catch (IllegalArgumentException e) {
                    mensajeFinal = "ERR " + dateFormat;
                }

                //3- ENVIO mensaje al cliente
                InetAddress ipCliente = datagramRespuesta.getAddress();
                int puertoCliente = datagramRespuesta.getPort();
                byte[] bufferEscritura = mensajeFinal.getBytes();
                DatagramPacket datagramEnvio = new DatagramPacket(bufferEscritura, bufferEscritura.length, ipCliente, puertoCliente);

                socket.send(datagramEnvio);
                
                System.out.println("Respuesta enviada al cliente: " + mensajeFinal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
