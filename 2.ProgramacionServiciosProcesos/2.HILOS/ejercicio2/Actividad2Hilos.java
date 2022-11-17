public class Actividad2Hilos{
    public static void main(String[] args) {
       Thread hilo1 = Thread.currentThread();
       hilo1.setPriority(Thread.MAX_PRIORITY);
       if(hilo1.getPriority()==10){
        System.out.println("Mi prioridad es MAXIMA");
       }

       hilo1.setPriority(Thread.NORM_PRIORITY);
       if(hilo1.getPriority()==5){
        System.out.println("Mi prioridad es MEDIA");
       }

       hilo1.setPriority(Thread.MIN_PRIORITY);
       if(hilo1.getPriority()==1){
        System.out.println("Mi prioridad es MINIMA");
       }
   }
   
}