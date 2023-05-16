package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        boolean error = false;
        Scanner sc = new Scanner(System.in);
        Thread hilo1 = Thread.currentThread();
        System.out.println("¿Prioridad del hilo?\n1. MAXIMA | 2. MEDIA | 3. MINIMA");
        String prioridad = sc.nextLine();

        switch (prioridad) {
            case "1":
                hilo1.setPriority(Thread.MAX_PRIORITY);
                break;
        
            case "2":
                hilo1.setPriority(Thread.NORM_PRIORITY);
                break;

            case "3":
                hilo1.setPriority(Thread.MIN_PRIORITY);
                break;

            default:
                
                error = true;
                break;
        }

        //hilo1.setPriority(Thread.MAX_PRIORITY);
        if (!error) {
            switch (hilo1.getPriority()) {
                case 10:
                    System.out.println("Mi prioridad es MÁXIMA");
                    break;
            
                case 5:
                    System.out.println("Mi prioridad es MEDIA");
                    break;
    
                case 1:
                    System.out.println("Mi prioridad es MÍNIMA");
                    break;
    
                default:
                System.out.println("Error, se desconoce prioridad del hilo1");
                    break;
            }
        } else {
            System.out.println("Error, introduce una opción correcta");
        }
        
    }
}
