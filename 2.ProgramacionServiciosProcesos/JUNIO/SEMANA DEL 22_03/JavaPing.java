import java.io.*;
    class JavaPing{
        //ejecutamos el comando ping google.com y lo mostramos usando un bufferedReader
        //si el proceso es nulo se destruye
        public static void main(String[] args) {
            Runtime runTime = Runtime.getRuntime();
            Process process = null;
    
            try {
                process = runTime.exec("ping google.com");
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
    
                for (int i=0; i<10; i++) {
                    System.out.println("Saludos humano"+in.readLine());
                }
            } catch (IOException e) {
                System.out.println("No pudimos correr el ping");
                System.exit(-1);
            }
    
            if (process!=null) {
                process.destroy();
            }
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                System.out.println("No pudimos esperar porque terminó");
            }
    
            System.out.println("Estado de termino: "+process.exitValue());
            System.exit(0);
        }
    }
    
    class proceso2{
        //ejecutamos el comando ping google.com y lo mostramos mediante un bufferedReader
        //este proceso acaba antes de tiempo por destruir al hijo
        public static void main(String[] args) {
            Runtime runTime= Runtime.getRuntime();
            Process process=null;

            try {
                process = runTime.exec("ping google.com");
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

                for (int i=0; i<10; i++) {
                    System.out.println("Saludos humano" + in.readLine());
                }
            } catch (IOException e) {
                System.out.println("No pudimos correr el ping desde nuestra clase");
                System.exit(-1);
            }


            if (process != null) {
                process.destroy();
                System.out.println("Me he cargado el ping...");
            }
            try {
                System.out.println("Ahora esperaré a que acabe mi proceso ping");
                process.waitFor();
                System.out.println("Ya no existe mi proceso ping");
            } catch (InterruptedException e) {
                System.out.println("No pudimos esperar porque terminó");
                System.exit(-1);
            }

            System.out.println("Estado de termino: " + process.exitValue());
            System.exit(0);
        }
    }


