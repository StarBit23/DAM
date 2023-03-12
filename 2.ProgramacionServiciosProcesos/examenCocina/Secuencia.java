class Secuencia{
    static private int numSecuencia = 0;

     synchronized static public int dameId(){
         return numSecuencia++;
     }
 }//fin Secuencia