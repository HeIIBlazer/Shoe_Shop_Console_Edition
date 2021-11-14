
package tools;

import Interfaces.Keeping;
import MyClasses.AllCash;
import MyClasses.Client;
import MyClasses.Model;
import MyClasses.Purchased;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaverToFile implements Keeping{

    @Override
    public void saveModel(List<Model> models) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
    try{
        fos = new FileOutputStream("models");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(models);
        oos.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "��� ����� models", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }
    

    @Override
    public List<Model> loadModels() {
        List<Model> models= new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("models");
            ois= new ObjectInputStream(fis);
            models = (List<Model>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "���� models ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� models", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "������ Model �� ����������", ex);
        }
        return models;
    
    }

    @Override
    public void saveClient(List<Client> clients) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
    try{
        fos = new FileOutputStream("clients");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(clients);
        oos.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "��� ����� clients", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }

    @Override
    public List<Client> loadClients() {
        List<Client> clients= new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("clients");
            ois= new ObjectInputStream(fis);
            clients = (List<Client>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "���� clients ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� clients", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "������ Client �� ����������", ex);
        }
        return clients;
    }

    @Override
    public void savePurchased(List<Purchased> purchased) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
    try{
        fos = new FileOutputStream("purchased");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(purchased);
        oos.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "��� ����� purchased", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }

    @Override
    public List<Purchased> loadHistories() {
        List<Purchased> purchased= new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("purchased");
            ois= new ObjectInputStream(fis);
            purchased = (List<Purchased>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "���� purchased ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� purchased", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "������ Purchased �� ����������", ex);
        }
        return purchased;
    }

    @Override
    public void saveAllCash(AllCash allcash) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
    try{
        fos = new FileOutputStream("allcash");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(allcash);
        oos.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "��� ����� allcash", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }

    @Override
    public AllCash loadAllCash() {
        AllCash allcash= new AllCash();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("allcash");
            ois= new ObjectInputStream(fis);
            allcash = (AllCash) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "���� allcash ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� allcash", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "������ AllCash �� ����������", ex);
        }
        return allcash;
    }

  /*  @Override
    public void saveShoeSize(List<ShoeSize> shoesize) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("authors");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(shoesize);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "��� ����� shoesize", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ �����", ex);
        }
    }
   

    @Override
    public List<ShoeSize> loadShoeSize() {
        List<ShoeSize> shoesize = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("shoesize");
            ois = new ObjectInputStream(fis);
            shoesize = (List<ShoeSize>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "���� shoesize ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "O����� ���������� ����� shoesize", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "������ ShoeSize �� ����������", ex);
        }
        
        return shoesize;
    }*/


    
}
