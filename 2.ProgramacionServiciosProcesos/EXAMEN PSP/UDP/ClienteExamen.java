package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClienteExamen {
    private static final int MAXBYTES = 1000;
    private static String  HOST = "localhost";
    private static int PORT = 3000;
    private static String condicion = "S";
    private static Boolean condicionFinal=false;
    private static String nombreCliente="";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                //CREAR MENSAJE
                String aMandar = "";
                System.out.println("ESCRIBE TU MENSAJE (intro para salir)");
                aMandar = sc.nextLine();
                String mensajeFinal = aMandar;

                //ENVIAR MENSAJE
                InetAddress ipServidor = InetAddress.getByName(HOST);
                DatagramSocket socketCliente = new DatagramSocket();
                
                byte[] bufferEscritura = new byte[MAXBYTES];
                bufferEscritura = mensajeFinal.getBytes();
                DatagramPacket pE = new DatagramPacket(bufferEscritura, bufferEscritura.length,ipServidor,PORT);
                if(mensajeFinal.equals("")) {
                    condicionFinal=true;
                    break;
                }
                socketCliente.send(pE);
                System.out.println(mensajeFinal);
                System.out.println("MENSAJE ENVIADO A SERVIDOR");
                

                //RECIBIR MENSAJE
                byte[] bufferLectura = new byte[MAXBYTES];
                DatagramPacket pR = new DatagramPacket(bufferLectura, MAXBYTES);
                socketCliente.receive(pR);

                String lineaRecibida = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
                System.out.println("res: "+lineaRecibida);

                //SI HAGO GET ?
                String mensajeFinal2[] = mensajeFinal.split(" ");
                if (mensajeFinal2[0].equals("post")) {
                    System.out.println(lineaRecibida);
                };

                System.out.println(" ");
    
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (condicionFinal==false);
        
    }

    


}
    
