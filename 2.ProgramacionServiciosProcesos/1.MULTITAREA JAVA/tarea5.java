import java.io.IOException;


public class tarea5 {

public static void main(String[] args) {
    
        try 
        {
            Process p = Runtime.getRuntime().exec("gedit");

        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
    }  
}

