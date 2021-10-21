
package tools;

import Interfaces.Keeping;
import MyClasses.Client;
import MyClasses.Model;
import MyClasses.Purchased;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaveToFile implements Keeping{

    @Override
    public void saveModel(Model[] models) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
    try{
        fos = new FileOutputStream("models");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(models);
        oos.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "��� ����� models", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }
    

    @Override
    public Model[] loadModels() {
        Model[] models= new Model[10];
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("models");
            ois= new ObjectInputStream(fis);
            models = (Model[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "���� models ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� models", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "������ Model �� ����������", ex);
        }
        return models;
    
    }

    @Override
    public void saveClient(Client[] clients) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
    try{
        fos = new FileOutputStream("clients");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(clients);
        oos.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "��� ����� clients", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }

    @Override
    public Client[] loadClients() {
        Client[] clients= new Client[10];
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("clients");
            ois= new ObjectInputStream(fis);
            clients = (Client[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "���� clients ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� clients", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "������ Client �� ����������", ex);
        }
        return clients;
    }

    @Override
    public void savePurchased(Purchased[] purchased) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
    try{
        fos = new FileOutputStream("purchased");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(purchased);
        oos.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "��� ����� purchased", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }

    @Override
    public Purchased[] loadHistories() {
        Purchased[] purchased= new Purchased[10];
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("purchased");
            ois= new ObjectInputStream(fis);
            purchased = (Purchased[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "���� purchased ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� purchased", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "������ Purchased �� ����������", ex);
        }
        return purchased;
    }
    
}
