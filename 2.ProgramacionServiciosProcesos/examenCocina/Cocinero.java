import java.util.Random;

public class Cocinero extends Thread {
    
    public static final int MIN_CANTIDAD_AGUA_POR_PLATO_CL = 25;
    public static final int MAX_CANTIDAD_AGUA_POR_PLATO_CL = 2000;
    public static final String TEXTO_ROJO="\033[31m"; 
    public static final String TEXTO_NEGRO = "\u001B[0m";
    public static final double CONVERSION_LITROS = 1000.0;

    private int id;
    private String nombre;
    private Cuba cubaCompartida;
    private int platosFrios, platosCalientes;
    private double totalAguaFria, totalAguaCaliente;
     

    public Cocinero(String nombre, Cuba depositos){
        id = Secuencia.dameId();
        this.nombre = nombre;
        cubaCompartida = depositos;
        platosFrios = platosCalientes = 0;
        totalAguaFria = totalAguaCaliente = 0.0;
    }


    @Override
    public void run() {
        boolean suficienteAguaFria = true;
        boolean suficienteAguaCaliente = true;
        Random r = new Random();
        int cantidadAgua = 0;
        String msg="";
        

       
       
        /*
         * Mientras no se terminen ambos depósitos, los cocineros cocinan.
         */
        while (suficienteAguaFria || suficienteAguaCaliente){  
          /*Decidimos qué plato realizar (caliente o frio) */
          boolean platoFrio = r.nextBoolean(); 
          /*Sacamos la cantidad que necesitamos para nuestro plato de cocina */
          cantidadAgua = MIN_CANTIDAD_AGUA_POR_PLATO_CL + r.nextInt(MAX_CANTIDAD_AGUA_POR_PLATO_CL - MIN_CANTIDAD_AGUA_POR_PLATO_CL + 1);
          System.out.printf ("--------->El hilo con id %d y de nombre %s entra a cocina para hacer plato con una cantidad de agua de %.2f (l)\n", this.id, this.nombre, cantidadAgua/CONVERSION_LITROS);
          /*Si le ha tocado un plato frío*/
          if (platoFrio) 
          /* Intentamos sacar la cantidad de agua fría que necesitamos. Devolverá true si se ha podido sacar CON LA ACTUALIZACIÓN EN EL DEPÓSITO, en caso contrario no podrá utilizar más la fría. */
            if (suficienteAguaFria  = cubaCompartida.restaLitrosDepositoFria(cantidadAgua/CONVERSION_LITROS)){
              msg = " FRIO y recoge la cantidad de " +  String.format("%.2f",cantidadAgua / CONVERSION_LITROS) + "(l) necesario para su plato. Aun quedan en el deposito Frio " + String.format("%.2f", cubaCompartida.getCantiAguaFria()) + "(l)";
              platosFrios++;
              totalAguaFria+=cantidadAgua /CONVERSION_LITROS;
            }
            else
              System.out.printf("???????(ERR)El hilo con id %d y de nombre %s, NO HA PODIDO REALIZAR SU PLATO FRIO con la cantidad de %.2f,  PORQUE NO QUEDA SUFICIENTES LITROS DE AGUA FRIA\n", this.id, this.nombre,  cantidadAgua / CONVERSION_LITROS);
          else  /*Nos ha tocado hacer un plato caliente */
            /* Intentamos sacar la cantidad de agua caliente que necesitamos. Devuelve tru si se ha podido */
            if (suficienteAguaCaliente  = cubaCompartida.restaLitrosDepositoCaliente(cantidadAgua/CONVERSION_LITROS)){
                msg = " CALIENTE y recoge la cantidad de " +  String.format("%.2f",cantidadAgua / CONVERSION_LITROS) + "(l) necesario para su plato. Aun quedan en el deposito Caliente " + String.format("%.2f", cubaCompartida.getCantiAguaCaliente()) + "(l) ";
                platosCalientes++;
                totalAguaCaliente+=cantidadAgua /CONVERSION_LITROS;
            }
            else
               System.out.printf("???????(ERR)El hilo con id %d y de nombre %s, NO HA PODIDO REALIZAR SU PLATO CALIENTE con la cantidad de %.2f,  PORQUE NO QUEDA SUFICIENTES LITROS DE AGUA CALIENTE\n", this.id, this.nombre, cantidadAgua / CONVERSION_LITROS);

          /* Si hemos realizado algún plato, tenemos que esperar un tiempo para volver a realizar otro. */      
          if (suficienteAguaFria || suficienteAguaCaliente)            
            try{
                System.out.printf ("*********(OK) El hilo con id %d y de nombre %s, HA REALIZADO UN PLATO %s******\n", this.id, this.nombre, msg);
                sleep(1000);
            }catch( InterruptedException e){
                System.out.println("el Cocinero ha muerto");
            }
        }//fin while
        System.out.print(TEXTO_ROJO);
        System.out.printf("<---ESTADISTICA HILO %d: PLATOS FRIOS: %d, PLATOS CALIENTES: %d, CONSUMO A.FRIA: %.2f(l), CONSUMO A.CALIENTE: %.2f(l)\n",this.id, platosFrios, platosCalientes, totalAguaFria, totalAguaCaliente);
        System.out.print(TEXTO_NEGRO);
      }//fin run
}
