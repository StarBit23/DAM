import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EchoServer {
    private static final int MAXBYTES=1400;
    private static final String CODTEXTO="UTF-8";
    public static void main(String[] args)  {
        args = new String[1];
        args[0] = "3000";
        int numPuertoServidor, numPuertoCliente;
        DatagramPacket paqueteUdp;
        InetAddress ipCliente;
        
        if (args.length < 1){
            System.out.println("Error, debes pasar el puerto");
            System.exit(1);
        }

        numPuertoServidor = Integer.parseInt(args[0]);
        
        //creamos el socket asociado al puerto. Se pone a la escucha.
        try (DatagramSocket socket = new DatagramSocket(numPuertoServidor)){
            while(true){
                System.out.println("Esperando algún datagrama");
                byte[] bufferEntrada = new byte[MAXBYTES];  //creamos el buffer
                paqueteUdp = new DatagramPacket(bufferEntrada, bufferEntrada.length);
                socket.receive(paqueteUdp); //recivimos un datagrama paqueteUdp
                //SACAMOS LOS DATOS DEL PAQUETE, DESPLAZAMIENTO 0, TAMAÑO A LEER Y CODIFICACIÓN
                String lineaRecibida = new String(paqueteUdp.getData(), 0, paqueteUdp.getLength(),CODTEXTO);
                ipCliente = paqueteUdp.getAddress(); //sacamos la ip del cliente.
                numPuertoCliente = paqueteUdp.getPort();//sacamos el puerto origen del cliente
                
                //Calcular cuantos dias han pasado
                String[] diaMes = lineaRecibida.split("/");
                String dia = diaMes[0];
                String mes = diaMes[1];

                LocalDate fechaActual = LocalDate.of(LocalDate.now().getYear(), Integer.parseInt(mes), Integer.parseInt(dia));
                LocalDate primerEnero = LocalDate.of(LocalDate.now().getYear(), 1, 1);
                long diasTranscurridos = ChronoUnit.DAYS.between(primerEnero, fechaActual);
                
                String lineaReplicar="#"+diasTranscurridos+"#";  //modicamos la respuesta con dos #

                //ahora debemos mandar la respuesta en un nuevo datagrama al Cliente
                //preparamos otro buffer para enviar, 
                //podría el mismo por el que hemos recibido, pero utilizamos otro.
                byte []bufferSalida = new byte[MAXBYTES]; 
                bufferSalida = lineaReplicar.getBytes();  //ponemos en el buffer el mensaje a mandar
                //Creamos el datagrama con los datos, la longitud, la ip del cliente y su puerto
                paqueteUdp = new DatagramPacket(bufferSalida, bufferSalida.length, ipCliente, numPuertoCliente);
                //Ahora debemos enviarlo a nuestro socket.
                socket.send(paqueteUdp);
            } //fin del while
        }//fin del try
        catch(SocketException e){
            System.out.println("Error en el socket servidor");
        }catch(IOException e){
            System.out.println("Error en E/S");
        }
    }
}
