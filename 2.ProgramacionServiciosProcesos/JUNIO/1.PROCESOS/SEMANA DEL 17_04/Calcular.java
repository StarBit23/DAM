import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calcular {
   public static void main(String[] args) {
      if(args.length < 3) {
         System.out.println("Se deben especificar dos operandos y un simbolo.");
         System.exit(0);
      }
      //pasarle argumentos
      String operando1 = args[0];
      String simbolo = args[1];
      String operando2= args[2];
      boolean error = false;
      int solucion=0;

      String expre = "(\\d+)(\\+|-|\\*|/)(\\d+)";
      Pattern pat = Pattern.compile(expre);
      
      String input = operando1 + simbolo + operando2;
      Matcher mat = pat.matcher(input);

      //si encuentra el patrón
      if (mat.find()) {
        //System.out.println("Operando1: " + mat.group(1));
        //System.out.println("Operacion: " + mat.group(2));
        //System.out.println("Operando2: " + mat.group(3));

        switch (mat.group(2)) {
            case "+":
                solucion = (Integer.parseInt(mat.group(1))) + (Integer.parseInt(mat.group(3)));
                break;
        
            case "-":
            solucion = (Integer.parseInt(mat.group(1))) - (Integer.parseInt(mat.group(3)));
            break;

            case "*":
            solucion = (Integer.parseInt(mat.group(1))) * (Integer.parseInt(mat.group(3)));
            break;

            case ":":
            try {
               solucion = (Integer.parseInt(mat.group(1))) / (Integer.parseInt(mat.group(3)));
            } catch (ArithmeticException e) {
               System.out.println("Error haciendo la division: " + e);
               error=true;
               System.exit(-1);
            }
            
            break;

            default:
                break;
        }
        //mostrar solucion si no da error
        if (!error) {
         System.out.println("La solucion es " + solucion);
        }
        //return solucion;

      } else {
         System.out.println("Introduce bien los datos (operando1 simbolo operando2)");
      }
      //return 0;
   }
}
