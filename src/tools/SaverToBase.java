
package tools;

import Interfaces.Keeping;
import MyClasses.AllCash;
import MyClasses.Client;
import MyClasses.Model;
import MyClasses.Purchased;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class SaverToBase implements Keeping {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyFOotPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    @Override
    public void saveModel(List<Model> models) {
            tx.begin();
            for (int i = 0; i < models.size(); i++) {
                if(models.get(i).getId() == null){
                    em.persist(models.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Model> loadModels() {
           List<Model> models=null;
        try {
            models = em.createQuery("SELECT model FROM Model model")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return models;
    }

    @Override
    public void saveClient(List<Client> clients) {
        tx.begin();
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getId() == null){
                em.persist(clients.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Client> loadClients() {
        List<Client> clients=null;
        try {
            clients = em.createQuery("SELECT client FROM Client client")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return clients;
    }

    @Override
    public void savePurchased(List<Purchased> purchased) {
        tx.begin();
        for (int i = 0; i < purchased.size(); i++) {
            if(purchased.get(i).getId() == null){
                em.persist(purchased.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Purchased> loadHistories() {
        List<Purchased> purchased=null;
        try {
            purchased = em.createQuery("SELECT purchased FROM Purchased purchased")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return purchased;
    }

    @Override
    public void saveAllCash(AllCash allcash) {
        tx.begin();
        em.persist(allcash);
        tx.commit();
    }

    @Override
    public AllCash loadAllCash() {
        AllCash allcash=null;
        try {
            allcash = (AllCash) em.createQuery("SELECT allcash FROM AllCash allcash");
                
        } catch (Exception e) {
            return new AllCash();
        }
        return allcash;
    }

    
}