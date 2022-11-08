package clientemarshalling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@XmlRootElement(name = "resenna")
@XmlAccessorType (XmlAccessType.FIELD)
public class Resenna {
    private int nota;
    private String opinion;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Resenna(int nota, String opinion) {
        this.nota = nota;
        this.opinion = opinion;
    }

    public Resenna() {
    }
}
