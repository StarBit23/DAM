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
            System.out.println("Iniciando servidor UDP");
            
            byte[] buffer = new byte[MAXBYTES];
            
            while (true) {
                DatagramPacket datagramRespuesta = new DatagramPacket(buffer, buffer.length);
                socket.receive(datagramRespuesta);
                
                String dateFormat = new String(datagramRespuesta.getData()).trim();
                System.out.println("Recibido: " + dateFormat);
                
                String response;
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                    response = sdf.format(new Date());
                } catch (IllegalArgumentException e) {
                    response = "ERR " + dateFormat;
                }
                
                InetAddress clientAddress = datagramRespuesta.getAddress();
                int clientPort = datagramRespuesta.getPort();
                byte[] responseData = response.getBytes();
                DatagramPacket datagramEnvio = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                socket.send(datagramEnvio);
                
                buffer = new byte[MAXBYTES];
                
                System.out.println("Respuesta enviada al cliente: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
