package exam.demo.Model;

import jakarta.persistence.*;

@Entity
public class Serviciu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descriere;
    private double tarif;

    @ManyToOne(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "solicitare_id")
    private Solicitare solicitare;

    public Serviciu() {
    }

    public Serviciu(int id, String descriere, double tarif) {
        this.id = id;
        this.descriere = descriere;
        this.tarif = tarif;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Serviciu{" +
                "id=" + id +
                ", descriere='" + descriere + '\'' +
                ", tarif=" + tarif +
                '}';
    }

    //CRUD Active Record
}
