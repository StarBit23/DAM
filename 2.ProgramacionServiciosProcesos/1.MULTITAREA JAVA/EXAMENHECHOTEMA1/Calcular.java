import com.sun.tools.javac.Main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * javac Calcular.java
 * jar -cf calcular.jar .\Calcular.class
 * javac PruebaCalcular.java
 * java PruebaCalcular
 **/
public class Calcular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String oper = sc.nextLine();
        sc.close();
        Pattern exp = Pattern.compile("(\\d+)([+]|[-]|[*]|[:])(\\d+)");
        Matcher mat = exp.matcher(oper);
        if (mat.find()) {
            System.out.println("La operacion introducida es:  " + mat.group(1) + mat.group(2) + mat.group(3));
        }
        int x = Integer.parseInt(mat.group(1));
        int y = Integer.parseInt(mat.group(3));

        switch (mat.group(2)) {
            case "+":
                System.out.println(x + y);
                break;
            case "*":
                System.out.println(x * y);
                break;
            case "-":
                System.out.println(x - y);
                break;
            case ":":
                if (y == 0) {
                    System.out.println("No se puede dividir entre 0");
                } else {
                    System.out.println(x / y);
                }
                break;
        }
    }
}
