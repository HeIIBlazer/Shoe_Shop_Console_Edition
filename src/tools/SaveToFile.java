
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
        Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Нет файла models", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
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
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Файл models еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "ошибка читавания файла models", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Класса Model не существует", ex);
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
        Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Нет файла clients", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
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
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Файл clients еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "ошибка читавания файла clients", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Класса Client не существует", ex);
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
        Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Нет файла purchased", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
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
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Файл purchased еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "ошибка читавания файла purchased", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Класса Purchased не существует", ex);
        }
        return purchased;
    }
    
}
