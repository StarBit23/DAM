package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ServidorExamen {
    private static final int MAXBYTES = 1000;
    private static int PORT = 3000;
    private static int bucleActivo=1;
    private static String mensajeFinalServidor;
    public static void main(String[] args) throws SocketException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket socketServidor = new DatagramSocket(PORT);

        //CREAR COCHES DEFAULT
        ArrayList<String[]> listaCoches = new ArrayList<String[]>();
        String coche1[] = {"1","mercedes","2000"};
        listaCoches.add(coche1);
        String coche2[] = {"2","alfa","2200"};
        listaCoches.add(coche2);
        String coche3[] = {"3","audi","2500"};
        listaCoches.add(coche3);
        String coche4[] = {"4","bmw","3000"};
        listaCoches.add(coche4);
        String coche5[] = {"5","cupra","1700"};
        listaCoches.add(coche5);

        int id = 6;
        
        do {
            try {
                //RECIBIR MENSAJE
                byte[] bufferLectura = new byte[MAXBYTES];
                DatagramPacket pR = new DatagramPacket(bufferLectura,MAXBYTES);
                socketServidor.receive(pR);
                String lineaRecibida1 = new String (pR.getData(), 0, pR.getLength(),"UTF-8");
                
                //SPLIT
                String mensajeFinal[] = lineaRecibida1.split(" ");

                

                //METODO post nombre, cilindrada
                if (mensajeFinal[0].equals("post")) {
                    String cocheNuevo[] = {String.valueOf(id),mensajeFinal[1], mensajeFinal[2]};
                    listaCoches.add(cocheNuevo);
                    mensajeFinalServidor="Nuevo coche añadido correctamente";
                    System.out.println(mensajeFinalServidor);
                    id++;
                };

                //METODO get ?
                String insertarId="";
                ArrayList<String> listaId = new ArrayList<String>();
                String[] insertarId2;
                if ((mensajeFinal[0].equals("get")) && (mensajeFinal[1].equals("?"))) {
                    System.out.println("MOSTRANDO LISTADO DE COCHES:");
                    for (String i[] : listaCoches) {
                        insertarId = Arrays.toString(i);
                        insertarId2 = insertarId.split(", ");
                        listaId.add(insertarId2[0].replace("[", ""));
                    }
                    System.out.println(listaId);
                    mensajeFinalServidor=listaId.toString();
                }

                //METODO get id
                if ((mensajeFinal[0].equals("get")) && (!mensajeFinal[1].equals("?"))) {
                    System.out.println("MOSTRANDO COCHE ELEGIDO:");
                    for (String i[] : listaCoches) {
                        insertarId = Arrays.toString(i);
                        insertarId2 = insertarId.split(", ");
                        //System.out.println(insertarId2[0]);
                        if (insertarId2[0].replace("[", "").equals(mensajeFinal[1])) {
                            System.out.println(insertarId);
                            mensajeFinalServidor=insertarId;
                            break;
                        }
                    }
                }

                //METODO put id, nombre, cilindrada
                // int idEditar;
                // if ((mensajeFinal[0].equals("put"))) {
                //     //System.out.println(mensajeFinal[1]);
                //     idEditar = Integer.parseInt(mensajeFinal[1]);
                //     listaCoches.set(idEditar-1, mensajeFinal[2], mensajeFinal[3]);
                //     mensajeFinalServidor="Coche editado correctamente";
                // }

                //METODO delete id
                int idEliminar=0;
                if ((mensajeFinal[0].equals("delete")) && (!mensajeFinal[1].equals("?"))) {
                    //System.out.println(mensajeFinal[1]);
                    idEliminar = Integer.parseInt(mensajeFinal[1]);
                    
                    listaCoches.remove(idEliminar-1);
                    mensajeFinalServidor="Coche eliminado correctamente";
                }
                
                //ENVIAR MENSAJE A CLIENTE
                InetAddress ipCliente = pR.getAddress();
                int puertoOrigenCliente = pR.getPort();
                byte[] bufferEscritura = new byte[MAXBYTES];
                bufferEscritura = mensajeFinalServidor.getBytes();

                DatagramPacket pE = new DatagramPacket(bufferEscritura, bufferEscritura.length, ipCliente,puertoOrigenCliente);
                socketServidor.send(pE);
                System.out.println("MENSAJE ENVIADO A CLIENTE");
                
            } catch (Exception e) {
                throw new RuntimeException(e);
            } 
        } while (bucleActivo==1);

    }
   
}