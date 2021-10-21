
package Interfaces;

import MyClasses.Client;
import MyClasses.Model;
import MyClasses.Purchased;


public interface Keeping {

    public  void saveModel(Model[] models);
    public Model[] loadModels();
    public  void saveClient(Client[] clients);
    public Client[] loadClients();
    public  void savePurchased(Purchased[] purchased);
    public Purchased[] loadHistories();
}
