import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;
/*
*Hilo que intercambia información con su cliente
*/

public class ServerThread extends Thread{
    private final Socket socketComunicacion;
    private final Recurso recurso;
    
    public ServerThread(Socket socketComunicacion, Recurso recurso) {
        this.socketComunicacion = socketComunicacion;
        this.recurso = recurso;
    }
    
    boolean isLoged;

    @Override
    public void run(){
        super.run();
        InetAddress ipCliente;

        try{
            recurso.fillList();
            Scanner sc = new Scanner (socketComunicacion.getInputStream());
            PrintWriter pw = new PrintWriter(socketComunicacion.getOutputStream());
            String lineaRecibida;

            while ((lineaRecibida = sc.nextLine()) != null  &&  lineaRecibida.length() > 0){
                ipCliente = socketComunicacion.getInetAddress();
                System.out.println("Recibo desde "+ ipCliente.getHostAddress() +" por puerto "+ socketComunicacion.getPort() +"> " + lineaRecibida);
                
                String[] split = lineaRecibida.split(" ");


                //REG nombreUsuario emailUsuario passUsuario
                if (split[0].equals("reg")) {
                    System.out.println("Registrarse");
                    String nombreUsuario = split[1];
                    String emailUsuario = split[2];
                    String passUsuario = split[3];
                    //añado nuevoUsuario a la lista
                    recurso.addUser(nombreUsuario, emailUsuario, passUsuario);
                    
                    String lineaEnviar1="USUARIO "+ nombreUsuario +" REGISTRADO";
                    pw.println(lineaEnviar1);
                }


                //LOG nombreUsuario passUsuario
                if (split[0].equals("log")) {
                    System.out.println("Logearse");
                    
                    if (recurso.logUser(split[1], split[2])==true) {
                        pw.println("USUARIO "+ split[1] +" CORRECTO");
                        isLoged=true;
                    }else{
                        String lineaEnviar1="USUARIO O CONTRASEÑA INCORRECTO";
                        pw.println(lineaEnviar1);
                    }
                }


                //DATU emailUsuario
                if (split[0].equals("datu") && isLoged==true){
                    String emailUser=split[1];
                    pw.println(recurso.getListaByEmail(emailUser));

                }if (split[0].equals("datu") && isLoged==false){
                    System.out.println("NO ESTAS LOGEADO");
                    pw.println("NO ESTAS LOGEADO");
                }


                //LIST
                if (split[0].equals("list")) {
                    System.out.println("Listado");
                    String lineaEnviar1 = recurso.getLista();
                    pw.println(lineaEnviar1);
                }

                //HASHMD5


                pw.flush();                 
            }

        //Catch de posibles errores
        }
        catch(IOException e){
            System.out.println("Error flujo I/O");
            e.printStackTrace();
        }
        catch (NoSuchElementException e){
            System.out.println("El Cliente ha cerrado su conexión....");
            if (socketComunicacion!=null)
                try{
                    System.out.printf("Socket servidor cerrado");
                     socketComunicacion.close();
                }catch (IOException ex){
                    System.out.println("Error flujo I/O al cerrar el socket servidor");
                    ex.printStackTrace();
                }
          
        }
    }
}