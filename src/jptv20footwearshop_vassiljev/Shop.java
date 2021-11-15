package jptv20footwearshop_vassiljev;

import Interfaces.Keeping;
import java.util.Scanner;
import MyClasses.Client;
import MyClasses.Purchased;
import MyClasses.Model;
import java.util.ArrayList;
import java.util.List;
import tools.SaverToFile;
import MyClasses.AllCash;
import tools.SaverToBase;

public class Shop {
   private Scanner scanner = new Scanner(System.in);
   private List<Client> clients= new ArrayList<>();
   private List<Model> models=new ArrayList<>();
   private List<Purchased> purchased=new ArrayList<>();
   private List<AllCash> allcash= new ArrayList<>();
   private Keeping keeper = new SaverToBase(); 
   //private Keeping keeper= new SaverToFile();
   int numberModel=0;
   int numberClient=0;
public Shop() {
    clients =keeper.loadClients();
    models=keeper.loadModels();
    purchased=keeper.loadHistories();
    allcash=keeper.loadAllCash();
    }
   
   float allCash=0;
   public void run(){
    String repeat ="r";
        do{ 
            System.out.println("--------------------------------------");
            System.out.println("0: ����� �� ���������");
            System.out.println("1: ���� ���������� ����������");
            System.out.println("2: �������� ������ ������������");
            System.out.println("3: ���������� � �����������");
            System.out.println("4: ���� ���������� �� ������ �����");
            System.out.println("5: ���������� �� ������ �����");
            System.out.println("6: ������� �����");
            System.out.println("7: ������� ���������� ������� �� ��� �����");
            System.out.print("�������� ����� ������: ");
            int task = scanner.nextInt(); scanner.nextLine();
            
            switch(task){

                case 0:
                    repeat="q";
                    System.out.println("����� �� ������!!!!!!");
                    break;
                case 1:
                    addClient();                  
                    break;
                case 2:
                    addMoneyClient();
                    break;
                case 3:
                    printListClients();
                    break;
                case 4:
                    addModel();
                    break;
                case 5:
                    printListModels();
                    break;
                case 6:
                    addPurchased();
                    break;
                case 7:
                    printAllCash();
                    for (int i = 0; i < purchased.size(); i++) {
                    System.out.println(purchased.get(i));
                    break;
                        
                    }
                    break;
          
                default:
                    System.out.println("������� ����� �� ������!!!");
            }
     }while("r".equals(repeat));   
    }
  private void addClient(){
      System.out.println("----���� ���������� � ����������----");
      Client client=new Client();
      System.out.print("������� ������ ��� �������: ");
      client.setClientNumber(scanner.nextLong());scanner.nextLine();
      System.out.print("������� ��� �������: ");
      client.setFirstName(scanner.nextLine());
      System.out.print("������� ������� ������: ");
      client.setSecondName(scanner.nextLine());
      System.out.print("������� ����� ��������: ");
      client.setPhone(scanner.nextLine());
      System.out.print("������� ����� �������: ");
      client.setMoney(scanner.nextFloat());
      clients.add(client);
      keeper.saveClient(clients);
}
  private void addMoneyClient(){
      System.out.println("----���������� ����� ������� �� ���� ----");
        System.out.println(1+1);printListClients();
        System.out.println("�������� ������ ��� �������: ");
        long nomer =scanner.nextLong();

        for (int i = 0; i < clients.size(); i++) {
            if(nomer == clients.get(i).getClientNumber()){
                System.out.println("������� ����� ������� ������ �������� �������: ");
                float newCash= scanner.nextFloat();
                newCash=newCash+ clients.get(i).getMoney();
                clients.get(i).setMoney(newCash);
                System.out.println(clients.get(i).getMoney()+" �� ����� � "+ clients.get(i).getFirstName());
                keeper.saveClient(clients);
                break;
                
          
    
        }
  }
  }
  private void printListClients(){
    System.out.println("----������ ��������----");
    for (int i = 0; i < clients.size(); i++) {
        if(clients.get(i)!=null){
            System.out.println(i+1+". ������ ���:" + clients.get(i).getClientNumber());
            System.out.println("   ���: "+clients.get(i).getFirstName());
            System.out.println("   �������: "+clients.get(i).getSecondName());
            System.out.println("   �����: "+clients.get(i).getMoney());
            System.out.println(" ");
        }
    }
  }
  private void addModel(){
      System.out.println("----���� ���������� �� ������ �����----");
      Model model= new Model();
      System.out.print("������� �������� ����� : ");
      model.setShoeName(scanner.nextLine());
      System.out.print("������� ��� �������� �������������: ");
      model.setShoeMaker(scanner.nextLine());
      System.out.print("������� ���� �����: ");
      model.setShoePrice(scanner.nextFloat());
      System.out.print("������� ������ �����: ");
      model.setShoeSize(scanner.nextFloat());scanner.nextLine();
      models.add(model);
      keeper.saveModel(models);
  }
  private void printListModels(){
    System.out.println("----C����� �����----");
        for (int i = 0; i < models.size(); i++) {
            if(models.get(i)!=null){
                System.out.println(i+1+". �������������: "+models.get(i).getShoeMaker());
                System.out.println("   ������: " +models.get(i).getShoeName());
                System.out.println("   ���������: "+models.get(i).getShoePrice());
                System.out.println(" ");
            }
        }
  }
  private void addPurchased(){
      System.out.println("----������� �����----");
       for (int i = 0; i < allcash.size(); i++) {
            allCash=allcash.get(i).getAllMoney();
       }
      Purchased purchased1= new Purchased();
        System.out.println("--������ �����������--");
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i)!= null){
                System.out.println(i+1+": "+clients.get(i).toString());
            }
        }
        System.out.println("������� ����� ����������");
        numberClient=scanner.nextInt();scanner.nextLine();
        System.out.println("--������ �����--");
        for (int i = 0; i < models.size(); i++) {
            if(models.get(i)!=null){
                System.out.println(i+1+": "+models.get(i).toString());
            }
        }
        System.out.println("����� ���� ����� �� �� ������ ����������?: ");
        numberModel=scanner.nextInt();scanner.nextLine();
        purchased1.setModels(models.get(numberModel-1));
        purchased1.setClient(clients.get(numberClient-1));       
        if(purchased1.getClient().getMoney()>=purchased1.getModels().getShoePrice()){
            clients.get(numberClient-1).setMoney(clients.get(numberClient-1).getMoney()-models.get(numberModel-1).getShoePrice());
            allCash+=models.get(numberModel-1).getShoePrice();
            AllCash();
            purchased.add(purchased1);
            keeper.savePurchased(purchased);
            keeper.saveClient(clients);
            numberModel=0;
            numberClient=0;
        }
        else{
            System.out.println("����� ���� ���!!!!!!"); 
            numberModel=0;
            numberClient=0;
    }       
        }
    private void  AllCash(){
        for (int i = 0; i < allcash.size(); i++) {
            allcash.get(i).setAllMoney(allCash);
            keeper.saveAllCash(allcash); 
        }
       }
    private void printAllCash(){
        for (int i = 0; i < allcash.size(); i++) {
        System.out.println("������� ���������: "+ allcash.get(i).getAllMoney());
            break;
            }
    }
    }