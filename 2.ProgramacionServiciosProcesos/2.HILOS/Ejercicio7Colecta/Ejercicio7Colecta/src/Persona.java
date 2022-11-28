public class Persona extends Thread{
    public String nombrePersona;
    public int dineroRecogido;
    final Colecta colecta;

    public Persona(String nombrePersona, int dineroRecogido, Colecta colecta) {
        this.nombrePersona = nombrePersona;
        this.dineroRecogido = dineroRecogido;
        this.colecta = colecta;
    }

    @Override
    public void run(){

    }
}
