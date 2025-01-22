package exam.demo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Solicitari")
public class Solicitare{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public String locatieSolicitare;

    @OneToMany(mappedBy = "solicitare",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Serviciu> listaServicii;

    private String stare;

    public Solicitare(int id, Client client, String locatieSolicitare, List<Serviciu> listaServicii, String stare) {
        this.id = id;
        this.client = client;
        this.locatieSolicitare = locatieSolicitare;
        this.listaServicii = listaServicii;
        this.stare = stare;
    }

    public void adaugaServiciu(Serviciu serviciu){
        this.listaServicii.add(serviciu);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getLocatieSolicitare() {
        return locatieSolicitare;
    }

    public void setLocatieSolicitare(String locatieSolicitare) {
        this.locatieSolicitare = locatieSolicitare;
    }

    public List<Serviciu> getListaServicii() {
        return listaServicii;
    }

    public String getStare() {
        return stare;
    }

    public void setStare(String stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
        return "Solicitare{" +
                "id=" + id +
                ", client=" + client +
                ", locatieSolicitare='" + locatieSolicitare + '\'' +
                ", listaServicii=" + listaServicii +
                ", stare='" + stare + '\'' +
                '}';
    }

    //CRUD Active Record
}
