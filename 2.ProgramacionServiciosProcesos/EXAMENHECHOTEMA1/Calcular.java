import java.util.Scanner;

public class Calcular {
    public static void main(String[] args) {
        System.out.println("Elige una opcion");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        Scanner sc = new Scanner(System.in);
        int operacion = sc.nextInt();
        switch (operacion) {
            case 1:
                System.out.println("Valor 1");
                int valorSuma1 = sc.nextInt();
                System.out.println("Valor 2");
                int valorSuma2 = sc.nextInt();
                int resultadoSuma = valorSuma1 + valorSuma2;
                System.out.println("El resultado vale "+ resultadoSuma);
            break;
        
            case 2:
                System.out.println("Valor 1");
                int valorResta1 = sc.nextInt();
                System.out.println("Valor 2");
                int valorResta2 = sc.nextInt();
                int resultadoResta = valorResta1 - valorResta2;
                System.out.println("El resultado vale "+ resultadoResta);
            break;

            case 3:
                System.out.println("Valor 1");
                int valorMult1 = sc.nextInt();
                System.out.println("Valor 2");
                int valorMult2 = sc.nextInt();
                int resultadoMult = valorMult1 * valorMult2;
                System.out.println("El resultado vale "+ resultadoMult);
            break;

            case 4:
                System.out.println("Valor 1");
                int valorDiv1 = sc.nextInt();
                System.out.println("Valor 2");
                int valorDiv2 = sc.nextInt();
                int resultadoDiv = valorDiv1 / valorDiv2;
                System.out.println("El resultado vale "+ resultadoDiv);
            break;

            default:
            System.out.println("Opción inexistente. Error de cojones");
            break;
        }
    }
}

