public class Cuba{
  
    public static final double TOTAL_LITROS_FRIA= 60.0;
    public static final double TOTAL_LIBROS_CALIENTE = 30.0; 
    /*
     * Podemos utilizar dos objetos Integer, que representa un lock de cada 
     * depósito, o de tipo Object y atributos que contengan su valor en cantidad de litros.
     * Es más conveniente un sólo atributo por depósito.
     */
    private  Object depositoFria = new Object();
    private  Object depositoCaliente =  new Object();


    private  double cantiDepositoFria = TOTAL_LITROS_FRIA;
    private  double cantiDepositoCaliente =  TOTAL_LIBROS_CALIENTE;
    /*
     * Sólo sincronizo el depósito del agua fría
     */
    public double getCantiAguaFria(){
        synchronized(depositoFria){
            return cantiDepositoFria;
        }
    }

    public double getCantiAguaCaliente(){
        synchronized(depositoCaliente){
            return cantiDepositoCaliente;
        }
    }

    public boolean esVacioDepositoFria(){
        synchronized(depositoFria){
            return (cantiDepositoFria == 0);
        }
    }

    public boolean esVacioDepositoCaliente(){
        synchronized(depositoCaliente){
            return (cantiDepositoCaliente== 0);
        }
    }

      /*
     * Resta la cantidad y devuelve cuanto queda.
     */
    public boolean restaLitrosDepositoFria(double cantidad){
        synchronized(depositoFria){
            if (cantidad <= cantiDepositoFria){
                cantiDepositoFria -= cantidad;
                return true;
            }
            return false;
        }
    }

    /*
     * Resta la cantidad y devuelve cuanto queda
     */
    public boolean restaLitrosDepositoCaliente(double cantidad){
        synchronized(depositoCaliente){
            if (cantidad <= cantiDepositoCaliente){
                cantiDepositoCaliente -= cantidad;
                return true;
            }
            return false;
        }
    }
}