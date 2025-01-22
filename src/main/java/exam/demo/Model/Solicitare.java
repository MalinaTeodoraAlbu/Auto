package exam.demo.Model;

import exam.demo.State.*;
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

    @Enumerated(EnumType.STRING)
    private StareSolicitare stare;

    public Solicitare() {

    }

    public Solicitare(int id, Client client, String locatieSolicitare, List<Serviciu> listaServicii) {
        this.id = id;
        this.client = client;
        this.locatieSolicitare = locatieSolicitare;
        this.listaServicii = listaServicii;
        this.stare = StareSolicitare.SOLICITARE_TRIMISA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setListaServicii(List<Serviciu> listaServicii) {
        this.listaServicii = listaServicii;
    }

    public void setStare(StareSolicitare stare) {
        this.stare = stare;
    }

    public StareSolicitare getStare() {
        return stare;
    }

}
