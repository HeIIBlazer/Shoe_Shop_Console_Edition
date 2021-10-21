
package jptv20footwearshop_vassiljev;

import Interfaces.Keeping;
import java.util.Scanner;
import MyClasses.Client;
import MyClasses.Purchased;
import MyClasses.Model;
import MyClasses.ShoeSize;
import java.util.Arrays;
import tools.SaveToFile;
public class Shop {
   private Scanner scanner = new Scanner(System.in);
   private Client[] clients= new Client[10];
   private Model[] models=new Model[10];
   private Purchased[] purchased=new Purchased[10];
   private Keeping keeper= new SaveToFile();
public Shop() {
    clients =keeper.loadClients();
    models=keeper.loadModels();
    purchased=keeper.loadHistories();
    }
   
   float allCash=0;
   public void run(){
    String repeat ="r";
        do{ 
            System.out.println("--------------------------------------");
            System.out.println("0: ����� �� ���������");
            System.out.println("1: ���� ���������� ����������");
            System.out.println("2: ���������� � �����������");
            System.out.println("3: ���� ���������� � ��������");
            System.out.println("4: ���������� � ���������");
            System.out.println("5: ������� �����");
            System.out.println("6: ������� ���������� ������� �� ��� ������");
            System.out.print("�������� ����� ������: ");
            int task = scanner.nextInt(); scanner.nextLine();
            
            switch(task){

                case 0:
                    repeat="q";
                    System.out.println("����� �� ������!!!!!!");
                    break;
                case 1:
                    System.out.println("--------���� ���������� � ����������----------");
                    for (int i = 0; i < clients.length; i++) {
                        if(clients[i]==null){
                        clients[i]= addClient();
                        keeper.saveClient(clients);
                        break;    
                        }
                    }
                    break;
                case 2:
                    System.out.println("-------------������ �����������-------------");
                    for (int i = 0; i < clients.length; i++) {
                        if(clients[i]!=null)
                            System.out.println(clients[i].toString());
                    }
                break;
                case 3:
                    System.out.println("-------------���� ���������� �� ������----------------");
                    for (int i = 0; i < models.length; i++) {
                        if(models[i]==null){
                            models[i]=addModel();
                            keeper.saveModel(models);
                            break;
                        }
                    }
                break;
                case 4:
                    System.out.println("-------------C����� �����-------------");
                    for (int i = 0; i < models.length; i++) {
                        if(models[i]!=null){
                            System.out.println(models[i].toString());
                        }
                        }
                break;
                case 5:
                    System.out.println("-------------------������� �����------------");
                        for (int i = 0; i < purchased.length; i++) {  
                        if(purchased[i]==null){
                            purchased[i]=addPurchased();
                            keeper.savePurchased(purchased);
                            break;
                        }
                        }
                break;
                case 6:
                    System.out.println("---------������� ������� ���������------------");
                    System.out.println(allCash);
                    break;
          
                default:
                    System.out.println("������� ����� �� ������!!!");
            }
     }while("r".equals(repeat));   
    }
  private Client addClient(){
      Client client=new Client();
      System.out.println("������� ��� �������: ");
      client.setFirstName(scanner.nextLine());
      System.out.println("������� ������� ������: ");
      client.setSecondName(scanner.nextLine());
      System.out.println("������� ����� ��������: ");
      client.setPhone(scanner.nextLine());
      System.out.println("������� ����� �������: ");
      client.setMoney(scanner.nextFloat());
      return client;
  }
  private Model addModel(){
      Model model= new Model();
      System.out.println("������� �������� ����� : ");
      model.setShoeName(scanner.nextLine());
      System.out.println("������� ��� �������� �������������: ");
      model.setShoeMaker(scanner.nextLine());
      System.out.println("������� ���� �����: ");
      model.setShoePrice(scanner.nextFloat());
      System.out.println("������� �������� ��� ���� �����?: ");
      int kolvo=scanner.nextInt();
      ShoeSize[] shoeSize = new ShoeSize[kolvo];
      for (int i = 0; i < kolvo; i++) {
          ShoeSize size= new ShoeSize();
          System.out.println("������� ������ �����: ");
          
          size.setShoeSize(scanner.nextInt());scanner.nextLine();
          shoeSize[i]=size;
      }
      model.setShoeSize(shoeSize);
      
      return model;
  }
  private Purchased addPurchased(){
      Purchased purchased1= new Purchased();
        System.out.println("--������ �����������--");
        for (int i = 0; i < clients.length; i++) {
            if(clients[i]!= null){
                System.out.println(i+1+": "+clients[i].toString());
            }
        }
        System.out.println("������� ����� ����������");
        int numberClient=scanner.nextInt();scanner.nextLine();
        System.out.println("--������ �����--");
        for (int i = 0; i < models.length; i++) {
            if(models[i]!=null){
                System.out.println(i+1+": "+models[i].toString());
            }
        }
        System.out.println("����� ���� ����� �� �� ������ ����������?: ");
        int numberModel=scanner.nextInt();scanner.nextLine();
        System.out.println("������� ���� ����");
        for (int i = 0; i < models.length; i++) {
            if(models[i]!=null){
                System.out.println(i+1+": "+Arrays.toString(models[numberModel-1].getShoeSize()));
            }
        }
        System.out.println("����� ������ ��� ����������?: ");
        
        purchased1.setModels(models[numberModel-1]);
        purchased1.setClient(clients[numberClient-1]);       
        if(purchased1.getClient().getMoney()>=purchased1.getModels().getShoePrice()){
            clients[numberClient-1].setMoney(clients[numberClient-1].getMoney()-models[numberModel-1].getShoePrice());
            allCash+=models[numberModel-1].getShoePrice();
        }
        else{
            System.out.println("����� ���� ���!!!!!!");                      
    }
       
      return purchased1;
    }
  }

