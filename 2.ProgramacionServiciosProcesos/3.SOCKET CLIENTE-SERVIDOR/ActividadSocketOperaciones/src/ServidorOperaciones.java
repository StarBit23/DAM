import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorOperaciones {
    private static final int MAXBYTES = 1000;
    private static int PORT = 3000;
    private static int bucleActivo=1;
    public static void main(String[] args) throws SocketException {
        DatagramSocket socketServidor = new DatagramSocket(PORT);
        do {
            try {
                //2
                //RECIBIR OPERANDO1
                
                byte[] bufferLectura = new byte[MAXBYTES];
                DatagramPacket pR = new DatagramPacket(bufferLectura,MAXBYTES);
                socketServidor.receive(pR);
                String lineaRecibida1 = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
                //System.out.println("RECIBIDO: "+lineaRecibida1);
    
                String[] parts = lineaRecibida1.split(",");
                String operacion1 = parts[0];
                String operando = parts[1];
                String operacion2 = parts[2];
    
                int operacionInt1 = Integer.parseInt(operacion1);
                int operacionInt2 = Integer.parseInt(operacion2);
                int solucion = 0;
                String solucionFinal="";
                try {
                    switch(operando){
                        case "+": solucion =operacionInt1+operacionInt2;break;
                        case "-": solucion =operacionInt1-operacionInt2;break;
                        case "*": solucion =operacionInt1*operacionInt2;break;
                        case "/": solucion =operacionInt1/operacionInt2;break;
                    }
                    solucionFinal=Integer.toString(solucion);
                } catch (ArithmeticException e) {
                    System.out.println("No se puede dividir entre cero, tonto");
                    solucionFinal = "err";
                }
    
                //3
                InetAddress ipCliente = pR.getAddress();
                int puertoOrigenCliente = pR.getPort();
                byte[] bufferEscritura = new byte[MAXBYTES];
                bufferEscritura = solucionFinal.getBytes();
    
                DatagramPacket pE = new DatagramPacket(bufferEscritura, bufferEscritura.length, ipCliente,puertoOrigenCliente);
                socketServidor.send(pE);
                System.out.println(solucionFinal+" ENVIADO A CLIENTE");
    
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (bucleActivo==1);
        

    }
}