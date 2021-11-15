
package Interfaces;

import entity.AllCash;
import entity.Client;
import entity.Model;
import entity.Purchased;

import java.util.List;


public interface Keeping {

    public  void saveModel(List<Model> models);
    public List<Model> loadModels();
    public  void saveClient(List<Client> clients);
    public List<Client> loadClients();
    public  void savePurchased(List<Purchased> purchased);
    public List<Purchased> loadHistories();
    public void saveAllCash (List<AllCash> allcash);
    public List<AllCash> loadAllCash();

}
