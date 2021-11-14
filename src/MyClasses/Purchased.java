package MyClasses;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Purchased implements Serializable  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Client client;
    private Model models;
    private float moneys;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Model getModels() {
        return models;
    }

    public void setModels(Model models) {
        this.models = models;

    }

    public float getMoneys() {
        return moneys;
    }

    public void setMoneys(float moneys) {
        this.moneys = moneys;
    }

    @Override
    public String toString() {
        return "Purchased{" + "client=" + client + ", models=" + models + ", moneys=" + moneys + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    }
    
    

