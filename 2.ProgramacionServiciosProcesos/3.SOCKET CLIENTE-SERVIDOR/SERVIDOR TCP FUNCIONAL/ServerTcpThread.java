/*
 * Versión echo con TCP Multihilo pero 
 * @author: Santiago Rodenas Herráiz
 * @version: 5/12/2021
 * @param: Acepta el puerto 
 * 
 */


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;




/*
*Hilo que intercambia información con su cliente
*/

public class ServerTcpThread extends Thread{
    private final Socket socketComunicacion;
    
    public ServerTcpThread(Socket socketComunicacion){
        this.socketComunicacion = socketComunicacion;
    }

    @Override
    public void run(){
        super.run();
        InetAddress ipCliente;

        try{
            Scanner sc = new Scanner (socketComunicacion.getInputStream());
            PrintWriter pw = new PrintWriter(socketComunicacion.getOutputStream());
            String lineaRecibida;

            while ((lineaRecibida = sc.nextLine()) != null  &&  lineaRecibida.length() > 0){
                ipCliente = socketComunicacion.getInetAddress();
                System.out.println("Recibo desde "+ ipCliente.getHostAddress() +" por puerto "+ socketComunicacion.getPort() +">" + lineaRecibida);
                lineaRecibida = "#$"+ lineaRecibida +"$#";
                pw.println(lineaRecibida);  //mandamos la linea recibida modificada
                pw.flush();                 //limpiamos el buffer para que se mande inmediatamente.
            }

        //Catch de errores
        }
        catch(IOException e){
            System.out.println("Error en flujo de E/S");
            e.printStackTrace();
        }
        catch (NoSuchElementException e){
            System.out.println("El Cliente ha cerrado su conexión....");
            if (socketComunicacion!=null)
                try{
                    System.out.printf("Socket servidor Multihilo, cerrado%n");
                     socketComunicacion.close();
                }catch (IOException ex){
                    System.out.println("Error en flujo de E/S al cerrar el Socket una vez desconectado con cliente");
                    ex.printStackTrace();
                }
          //  System.out.println("Hilo finalizado...");
        }
    }
}