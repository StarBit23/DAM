package clientemarshalling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@XmlRootElement(name = "prestamo")
@XmlAccessorType (XmlAccessType.FIELD)

public class Prestamo {
    private String idPrestamo;
    private String fechaPrestamo;;

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Prestamo(String idPrestamo, String fechaPrestamo) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Prestamo() {
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo='" + idPrestamo + '\'' +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                '}';
    }
}
