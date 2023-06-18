import java.io.*;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Recurso {
    public Usuario usuario;
    ArrayList<Usuario> lista = new ArrayList<Usuario>();
    public boolean isLoged=false;
    public String listadoUsuariosEmail;
    public String usuarioFile;

    public void fillList(){
        //lista.add(new Usuario("root","root", "root"));
    }

    public synchronized String getLista(){
        return lista.toString();
    }

    public synchronized void addUser(String nombreUsuario, String emailUsuario, String passUsuario){
        //Usuario newUsuario = new Usuario("guille","guille@gmail.com","guille");
        lista.add(new Usuario(nombreUsuario, emailUsuario, passUsuario));
        System.out.println(lista);
    }

    public synchronized boolean logUser(String nombreUsuario, String passUsuario){
        
        lista.forEach(usuario ->{
            if (nombreUsuario.equals(usuario.getNombreUsuario()) && passUsuario.equals(usuario.getPassUsuario())) {
                System.out.println("Usuario "+ usuario.getNombreUsuario() +" logeado correctamente");
                isLoged=true;
            }
        });
        return isLoged;
    }

    public synchronized String getListaByEmail(String emailUsuario){
        lista.forEach(usuario -> {
            if (emailUsuario.equals(usuario.getEmailUsuario())) {
                listadoUsuariosEmail="nombre:"+usuario.getNombreUsuario()+", email:"+usuario.getEmailUsuario() + ", pass:"+ usuario.getPassUsuario();
            }else{
                listadoUsuariosEmail="Email no encontrado";
            }
        });
        return listadoUsuariosEmail;
    }

    public String createHashMD5(String fileName) throws IOException {
        lista.forEach(usuario -> {
            if (fileName.equals(usuario.getNombreUsuario())) {
                //String nombre = usuario.getNombreUsuario();
                usuarioFile="nombre:"+usuario.getNombreUsuario()+", email:"+usuario.getEmailUsuario() + ", pass:"+ usuario.getPassUsuario();
            }else{
                usuarioFile="null";
            }
        });

    if (usuarioFile =="null") {
        return "";
    }
    File file = new File(fileName + ".dat");
    file.createNewFile();

    if (usuarioFile !="null") {
        FileWriter writer = new FileWriter(file);
        writer.write(usuarioFile);
        writer.close();
    }
    
    try (FileInputStream fis = new FileInputStream(file)) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] buffer = new byte[8192];
        int bytesRead;
        
        while ((bytesRead = fis.read(buffer)) != -1) {
            md.update(buffer, 0, bytesRead);
        }
        
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return "";
}


}
