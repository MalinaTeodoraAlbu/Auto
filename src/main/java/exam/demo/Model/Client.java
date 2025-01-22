package exam.demo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Clienti")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nume;
    private String adresa;
    private String telefon;

    @OneToMany(mappedBy = "client",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Solicitare> listaSolicitari;

    public Client() {
    }

    public Client(int id, String nume, String adresa, String telefon) {
        this.id= id;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }

    public List<Solicitare> getListaSolicitari() {
        return listaSolicitari;
    }

    public void setListaSolicitari(List<Solicitare> listaSolicitari) {
        this.listaSolicitari = listaSolicitari;
    }
}
