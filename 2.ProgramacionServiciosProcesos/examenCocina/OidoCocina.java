public class OidoCocina {
    public static final int NUM_PLANTILLA = 6;
    public static void main(String[] args) {
        Cuba cuba = new Cuba();
        Cocinero [] plantilla = new Cocinero[6];

        /*Creamos los cocineros */
        for (int i=0; i<NUM_PLANTILLA; i++){
            plantilla[i] = new Cocinero("Cocinero" + i, cuba);
            plantilla[i].start();
       
        } 
       // System.out.println ("Todos los cocineros están en cocina");

        for (Cocinero cocinero : plantilla) {
            try{
                cocinero.join();
            }catch(InterruptedException e){}
        }
           
    }
}
 