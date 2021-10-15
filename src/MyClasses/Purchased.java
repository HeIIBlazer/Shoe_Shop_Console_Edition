package MyClasses;

import java.util.Date;

public class Purchased {
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
    

    }
    
    

