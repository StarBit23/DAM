package modelo;

public class Coche {

    private int id;
    private String modelo;
    private int Cilindrada;

    public Coche(int id, String modelo, int cilindrada) {
        this.id = id;
        this.modelo = modelo;
        Cilindrada = cilindrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindrada() {
        return Cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        Cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "modelo.Coche{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", Cilindrada=" + Cilindrada +
                '}';
    }
}
