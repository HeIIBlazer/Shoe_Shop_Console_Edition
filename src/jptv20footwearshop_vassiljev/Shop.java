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
            System.out.println("0: Выход из программы");
            System.out.println("1: Ввод Информация покупателе");
            System.out.println("2: Добавить деньги пользователю");
            System.out.println("3: Информация о покупателях");
            System.out.println("4: Ввод информации об модели обуви");
            System.out.println("5: Информация об модели обуви");
            System.out.println("6: Покупка обуви");
            System.out.println("7: Сколько зараболтал магазин за все время");
            System.out.print("Выберети номер задачи: ");
            int task = scanner.nextInt(); scanner.nextLine();
            
            switch(task){

                case 0:
                    repeat="q";
                    System.out.println("ДАВАЙ ДО ЗАВТРА!!!!!!");
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
                    System.out.println("Введите номер из списка!!!");
            }
     }while("r".equals(repeat));   
    }
  private void addClient(){
      System.out.println("----Ввод информации о покупателе----");
      Client client=new Client();
      System.out.print("Введите личный код клиента: ");
      client.setClientNumber(scanner.nextLong());scanner.nextLine();
      System.out.print("Введите имя клиента: ");
      client.setFirstName(scanner.nextLine());
      System.out.print("Введите фамилию клинта: ");
      client.setSecondName(scanner.nextLine());
      System.out.print("Введите номер телефона: ");
      client.setPhone(scanner.nextLine());
      System.out.print("Введите сумму клиента: ");
      client.setMoney(scanner.nextFloat());
      clients.add(client);
      keeper.saveClient(clients);
}
  private void addMoneyClient(){
      System.out.println("----Добавление денег клиенту на счет ----");
        System.out.println(1+1);printListClients();
        System.out.println("Выберите личный код клиента: ");
        long nomer =scanner.nextLong();

        for (int i = 0; i < clients.size(); i++) {
            if(nomer == clients.get(i).getClientNumber()){
                System.out.println("Введите сумму которую хотите добавить клиенту: ");
                float newCash= scanner.nextFloat();
                newCash=newCash+ clients.get(i).getMoney();
                clients.get(i).setMoney(newCash);
                System.out.println(clients.get(i).getMoney()+" На счету у "+ clients.get(i).getFirstName());
                keeper.saveClient(clients);
                break;
                
          
    
        }
  }
  }
  private void printListClients(){
    System.out.println("----Список клиентов----");
    for (int i = 0; i < clients.size(); i++) {
        if(clients.get(i)!=null){
            System.out.println(i+1+". Личный код:" + clients.get(i).getClientNumber());
            System.out.println("   Имя: "+clients.get(i).getFirstName());
            System.out.println("   Фамилия: "+clients.get(i).getSecondName());
            System.out.println("   Сумма: "+clients.get(i).getMoney());
            System.out.println(" ");
        }
    }
  }
  private void addModel(){
      System.out.println("----Ввод информации об модели обуви----");
      Model model= new Model();
      System.out.print("Введите название обуви : ");
      model.setShoeName(scanner.nextLine());
      System.out.print("Введите имя компании производителя: ");
      model.setShoeMaker(scanner.nextLine());
      System.out.print("Введите цену обуви: ");
      model.setShoePrice(scanner.nextFloat());
      System.out.print("Введите размер обуви: ");
      model.setShoeSize(scanner.nextFloat());scanner.nextLine();
      models.add(model);
      keeper.saveModel(models);
  }
  private void printListModels(){
    System.out.println("----Cписок обуви----");
        for (int i = 0; i < models.size(); i++) {
            if(models.get(i)!=null){
                System.out.println(i+1+". Производитель: "+models.get(i).getShoeMaker());
                System.out.println("   Модель: " +models.get(i).getShoeName());
                System.out.println("   Стоимость: "+models.get(i).getShoePrice());
                System.out.println(" ");
            }
        }
  }
  private void addPurchased(){
      System.out.println("----Покупка обуви----");
       for (int i = 0; i < allcash.size(); i++) {
            allCash=allcash.get(i).getAllMoney();
       }
      Purchased purchased1= new Purchased();
        System.out.println("--Список покупателей--");
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i)!= null){
                System.out.println(i+1+": "+clients.get(i).toString());
            }
        }
        System.out.println("Введите номер покупателя");
        numberClient=scanner.nextInt();scanner.nextLine();
        System.out.println("--Список обуви--");
        for (int i = 0; i < models.size(); i++) {
            if(models.get(i)!=null){
                System.out.println(i+1+": "+models.get(i).toString());
            }
        }
        System.out.println("Какую пару обуви вы бы хотели приобрести?: ");
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
            System.out.println("ДЕНЕГ МАЛО ЧЕЛ!!!!!!"); 
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
        System.out.println("Магазин заработал: "+ allcash.get(i).getAllMoney());
            break;
            }
    }
    }