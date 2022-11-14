public class Interbloqueo {
    String numCuenta="";
    int saldo=0;

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Interbloqueo{" +
                "numCuenta='" + numCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
