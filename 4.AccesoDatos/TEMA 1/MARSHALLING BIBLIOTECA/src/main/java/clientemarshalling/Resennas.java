package clientemarshalling;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resennas")
@XmlAccessorType (XmlAccessType.FIELD)
public class Resennas {
    @XmlElement(name = "resenna")
    private List<Resenna> listaResennas = null;

    public List<Resenna> getListaResennas() {
        return listaResennas;
    }

    public void setListaResennas(List<Resenna> resennas) {
        this.listaResennas = resennas;
    }

    public void addResenna(Resenna resenna){
        this.listaResennas.add(resenna);
    }

    public int getSize() {
        return listaResennas.size();
    }

    public Resennas() {
        this.listaResennas = new ArrayList<Resenna>();
    }
}
