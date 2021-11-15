package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Purchased implements Serializable  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Client client;
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Model models;
    private float moneys;
    @Temporal(TemporalType.TIMESTAMP)
    private Date PurchasedDate;

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
        return "Purchased{" + "id=" + id + ", client=" + client + ", models=" + models + ", moneys=" + moneys + ", PurchasedDate=" + PurchasedDate + '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchasedDate() {
        return PurchasedDate;
    }

    public void setPurchasedDate(Date PurchasedDate) {
        this.PurchasedDate = PurchasedDate;
    }
    

    }
    
    

