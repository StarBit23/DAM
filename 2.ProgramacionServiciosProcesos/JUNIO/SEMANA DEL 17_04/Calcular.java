import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calcular {
   public static void main(String[] args) {
      if(args.length < 3) {
         System.out.println("Se deben especificar dos operandos y un símbolo.");
         return;
      }
      String operando1 = args[0];
      String simbolo = args[1];
      String operando2= args[2];
      int solucion=0;

      String expre = "(\\d+)(\\+|-|\\*|:)(\\d+)";
      Pattern pat = Pattern.compile(expre);
      String input = operando1 + simbolo + operando2;
      Matcher mat = pat.matcher(input);
      if (mat.find()) {
        System.out.println("Operando 1: " + mat.group(1));
        System.out.println("Operación: " + mat.group(2));
        System.out.println("Operando 2: " + mat.group(3));

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
            solucion = (Integer.parseInt(mat.group(1))) - (Integer.parseInt(mat.group(3)));
            break;

            default:
                break;
        }
      }
   }
}
