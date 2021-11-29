
package tools;

import Interfaces.Keeping;
import entity.AllCash;
import entity.Client;
import entity.Model;
import entity.Purchased;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class SaverToBase implements Keeping {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV20MyFootWearShopPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    @Override
    public void saveModel(List<Model> models) {
            tx.begin();
            for (int i = 0; i < models.size(); i++) {
                if(models.get(i).getId() == null){
                    em.persist(models.get(i));
                }else{
                    em.merge(models.get(i));
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
                }else{
                em.merge(clients.get(i));
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
                }else{
                em.merge(purchased.get(i));
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
    public void saveAllCash(List<AllCash> allcash) {
        tx.begin();
        for (int i = 0; i < allcash.size(); i++) {
            if(allcash.get(i).getId() == null){
                em.persist(allcash.get(i));
                }else{
                em.merge(allcash.get(i));
            }
            }
        tx.commit();
    }

    @Override
    public List<AllCash> loadAllCash() {
        List<AllCash> allcash=null;
        try {
            allcash =em.createQuery("SELECT allcash FROM AllCash allcash")
                    .getResultList();
                
        } catch (Exception e) {
            return new ArrayList();
        }
        return allcash;
    }

    
}
