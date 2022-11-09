package clientemarshalling;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "prestamos")
@XmlAccessorType (XmlAccessType.FIELD)
public class Prestamos {
    @XmlElement(name = "prestamo")
    private List<Prestamo> listaPrestamos = null;

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> prestamos) {
        this.listaPrestamos = prestamos;
    }

    public void addPrestamo(Prestamo prestamo){
        this.listaPrestamos.add(prestamo);
    }

    public int getSize() {
        return listaPrestamos.size();
    }

    public Prestamos() {
        this.listaPrestamos = new ArrayList<Prestamo>();
    }

    @Override
    public String toString() {
        return "Prestamos{" +
                "listaPrestamos=" + listaPrestamos +
                '}';
    }
}
