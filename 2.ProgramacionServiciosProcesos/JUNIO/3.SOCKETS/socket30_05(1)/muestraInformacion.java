import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class muestraInformacion {
    public static void main(String[] args){
        List<InterfaceAddress> ipsV4;
        try {
            for (Enumeration<NetworkInterface> eth = NetworkInterface.getNetworkInterfaces(); eth.hasMoreElements();) {
                System.out.println("------>   Muestro información de interfaz   <------\n\n");
                //para cada una de las interfaces, mostramos informacioón de cada una de ellas
                muestraInformacionInterface(eth.nextElement());
            }
        } catch (SocketException e) {
            System.out.println("Error: Excepción de socket");
        }
    }

    public static void muestraInformacionInterface(NetworkInterface eth) throws SocketException {
        String nombreInterface;
        String nombre;
        byte [] mac;
        Enumeration<InetAddress> ips;

        System.out.println("Nombre de la interfaz: " + eth.getName());
        System.out.println("Otro nombre de la interfaz: " + eth.getDisplayName());
        if (!eth.getName().equals("lo")) {
            mac = eth.getHardwareAddress();
            if (mac != null) {
                System.out.println("La MAC actual es : ");

                String sb = "";
                for (int i = 0; i < mac.length; i++) {
                    if (i < mac.length - 1) {
                        sb = sb + String.format("%02x%s", mac[i], "-");
                    } else {
                        sb = sb + String.format("%02x%s", mac[i], ":");
                    }
                }
                System.out.println(sb);
                System.out.println("Parámetros de IP: ");

                ips = eth.getInetAddresses();

                for (ips = eth.getInetAddresses(); ips.hasMoreElements();) {
                    InetAddress ip = ips.nextElement();
                    if (!ip.isLoopbackAddress()) {
                        if (ip instanceof Inet4Address) {
                            System.out.println("Dirección IP v4: " + ip.getHostAddress());
                        } else if (ip instanceof Inet6Address) {
                            System.out.println("Dirección IP v6: " + ip.getHostAddress());
                        }
                    }
                }
            } else {
                System.out.println("La interfaz no tiene una dirección MAC asociada.");
            }
        }
    }
}