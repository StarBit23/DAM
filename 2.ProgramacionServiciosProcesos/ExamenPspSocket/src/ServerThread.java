import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ServerThread extends Thread {
    private final Socket comSocket;
    private final Recurso recurso;

    public ServerThread(Socket comSocket, Recurso recurso) {
        this.comSocket = comSocket;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        super.run();
        InetAddress clientIp;

        try {
            Scanner sc = new Scanner(comSocket.getInputStream());
            PrintWriter pw = new PrintWriter(comSocket.getOutputStream());
            String readLine;

            while ((readLine = sc.nextLine()) != null && readLine.length() > 0) {
                clientIp = comSocket.getInetAddress();
                System.out.println(clientIp.getHostAddress() + " en puerto " + comSocket.getPort() + "> " + readLine);
                String[] split = readLine.split(" ");
                if (split[0].equals("help")){
                    pw.println("get list                            -muestra la lista de coches");
                    pw.println("get id `id`                         -muestra el vehiculo con ese ID");
                    pw.println("delete `id`                         -elimina coche por id");
                    pw.println("put `id` `modelo` `cilindrada`      -modifica los datos del coche con la id proporcionada");
                    pw.println("post `modelo `cilindrada`           -crea un nuevo coche con los datos proporcionados");
                    pw.println("exit                                -termina la conexion con el servidor");
                    pw.println("");
                }

                recurso.addNum();
                System.out.println("Numero de conexiones " + recurso.getNum());
                if (split.length > 1) {
                    switch (split[0]) {
                        case "get": {
                            if (split[1].equals("list")) {
                                pw.println("Lista de coches");
                                String list = recurso.getLista();
                                pw.println(list);

                                break;
                            } else if (split[1].equals("id")) {
                                if (split.length < 3) {
                                    pw.println("Introduce el id del coche");
                                    pw.println("");
                                    break;
                                } else {
                                    pw.println("Buscar coche con id -> " + split[2]);
                                    String coche = recurso.getById(Integer.parseInt(split[2]));
                                    pw.println(coche);
                                    pw.println("");
                                    break;
                                }

                            } else if (split[1].equals("?")) {
                                pw.println(recurso.getAllById());
                                pw.println("");
                                break;
                            }
                            {
                                pw.println("No se reconoce el argumento");
                                pw.println("");
                                break;
                            }
                        }

                        case "post": {
                            if (split.length == 3) {
                                recurso.addCoche(split[1], Integer.parseInt(split[2]));
                                pw.println("Coche guardado correctamente");
                                pw.println("");
                                break;
                            } else {
                                pw.println("Argumentos no validos");
                                pw.println("");
                                break;
                            }
                        }

                        case "put": {
                            if (split.length > 4){
                                pw.println("Sobran argumentos");
                                pw.println("");
                                break;
                            } else {
                                pw.println("Se va a actualizar el nombre y la cilindrada del vehiculo en la posicion " + split[1] );
                                recurso.putCoche(Integer.parseInt(split[1]),split[2],Integer.parseInt(split[3]));
                            }
                            pw.println("Coche modificado correctamente");
                            pw.println("");

                            break;
                        }

                        case "delete": {
                            if (split.length < 2) {
                                pw.println("Se necesita el ID del vehiculo");
                                pw.println("");
                                break;
                            } else if (split.length > 2) {
                                pw.println("Demasiados argumentos");
                                pw.println("");
                                break;
                            } else {
                                recurso.deleteCoche(Integer.parseInt(split[1]));
                                pw.println("Coche eliminado correctamente");
                                pw.println("");
                                break;
                            }
                        }

                        default: {
                            pw.println("Comando no reconocido");
                            pw.println("");
                            break;
                        }
                    }
                } else {
                    pw.println("Introduce un argumento valido");
                    pw.println("");

                }
                pw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            System.out.println("El cliente ha cerrado su conexion");
            if (comSocket != null) {
                try {
                    System.out.println("Socket multihilo cerrado");
                    comSocket.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el socket");
                    ex.printStackTrace();
                }
            }
        }
    }
}