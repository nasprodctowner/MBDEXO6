package message.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity

@Table(name = "test.TAUX")
public class ConversionTauxEntity implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id ;
    private String monnaieA, monnaieB;
    private float taux;

    public ConversionTauxEntity(String monnaieA, String monnaieB, float taux) {
        this.monnaieA = monnaieA;
        this.monnaieB = monnaieB;
        this.taux = taux;
    }

    public ConversionTauxEntity() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonnaieA() {
        return monnaieA;
    }

    public void setMonnaieA(String monnaieA) {
        this.monnaieA = monnaieA;
    }

    public String getMonnaieB() {
        return monnaieB;
    }

    public void setMonnaieB(String monnaieB) {
        this.monnaieB = monnaieB;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

}
