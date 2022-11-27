public class Puente {
    private int cochesPasando = 0;
    private int pesoCochesPuente = 0;

    public int getCochesPasando(){
        return cochesPasando;
    }
    synchronized public boolean sePermitePaso(Coche coche){
        if (coche.peso+ pesoCochesPuente <=5000 && cochesPasando<3){
            cochesPasando++;
            pesoCochesPuente +=coche.peso;
            return true;
        } else return false;
    }
    synchronized public void finalizarPaso(Coche coche){
        cochesPasando--;
        pesoCochesPuente -=coche.peso;
    }
}
