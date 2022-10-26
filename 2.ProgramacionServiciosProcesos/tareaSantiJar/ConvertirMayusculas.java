package tareaSantiJar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConvertirMayusculas {
    public static void main(String[] args) {
        System.out.println("Introduce texto");
       Scanner sc = new Scanner(System.in);
        String linea = sc.nextLine();
        System.out.println(linea.toUpperCase());
        sc.close();
    }
}
