package clientemarshalling;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bibliotecas")
@XmlAccessorType (XmlAccessType.FIELD)
public class Bibliotecas {
    @XmlElement(name = "biblioteca")
    private List<Biblioteca> listaBibliotecas = null;

    public List<Biblioteca> getListaBibliotecas() {
        return listaBibliotecas;
    }

    public void setListaBibliotecas(List<Biblioteca> bibliotecas) {
        this.listaBibliotecas = bibliotecas;
    }

    public void addBiblioteca(Biblioteca biblioteca){
        this.listaBibliotecas.add(biblioteca);
    }

    public int getSize() {
        return listaBibliotecas.size();
    }

    public Bibliotecas() {
        this.listaBibliotecas = new ArrayList<Biblioteca>();
    }
}
