package jptv20footwearshop_vassiljev;

import Facade.AllCashFacade;
import Facade.ClientFacade;
import Facade.ModelFacade;
import Facade.PurchasedFacade;
import java.util.Scanner;
import entity.Client;
import entity.Purchased;
import entity.Model;
import entity.AllCash;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.omg.CORBA.ORB.init;

public class Shop {
   private Scanner scanner = new Scanner(System.in);
   private AllCashFacade allCashFacade;
   private ClientFacade clientFacade;
   private ModelFacade modelFacade;
   private PurchasedFacade purchasedFacade;
   Calendar calendar = Calendar.getInstance();
   Date date = calendar.getTime();
   String[] monthsNames = {"���", "���", "���", "���", "���", "���", "���", "���", "���", "���", "���", "���"};
   int numberModel=0;
   int numberClient=0;
   float Gain = 0;
   AllCash cash =new AllCash();
public Shop() {
    init();
    }
private void init(){
    allCashFacade = new AllCashFacade(AllCash.class);
    clientFacade = new ClientFacade (Client.class);
    modelFacade = new ModelFacade (Model.class);
    purchasedFacade =new PurchasedFacade (Purchased.class);
}
   public void run(){
    String repeat ="r";
        do{ 
            System.out.println("--------------------------------------");
            System.out.println("0: ����� �� ���������");
            System.out.println("1: ���� ���������� ����������");
            System.out.println("2: �������� ���������� �� ������������");
            System.out.println("3: �������� ������ ������������");
            System.out.println("4: ���������� � �����������");
            System.out.println("5: ���� ���������� �� ������ �����");
            System.out.println("6: �������� ���������� �� ������ �����");
            System.out.println("7: ���������� �� ������ �����");
            System.out.println("8: ������� �����");
            System.out.println("9: ������� ���������� ������� �� ��� �����");
            System.out.println("10: ������� ���������� ������� �� ������������ �����");
            System.out.print("�������� ����� ������: ");
            int task = scanner.nextInt(); scanner.nextLine();
            List<AllCash> allcash = allCashFacade.findAll();
            for (int i = 0; i < allcash.size(); i++) {
                Gain=allcash.get(i).getAllMoney();
             }
            
            switch(task){

                case 0:
                    repeat="q";
                    System.out.println("����� �� ������!!!!!!");
                    break;
                case 1:
                    addClient();                  
                    break;
                case 2:
                    changeClientInfo();
                    break;
                case 3:
                    addMoneyClient();
                    break;
                case 4:
                    printListClients();
                    break;
                case 5:
                    addModel();
                    break;
                case 6:
                    changeModelsInfo();
                case 7:
                    printListModels();
                    break;
                case 8:
                    addPurchased();
                    break;
                case 9:
                    printAllCash();
                break;
                case 10:
                    allCashForMonth();
                break;
                default:
                    System.out.println("������� ����� �� ������!!!");
            }
     }while("r".equals(repeat));   
    }
   
   
  private void addClient(){
      System.out.println("----���� ���������� � �������----");
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
      clientFacade.create(client);
}
  
  private void changeClientInfo(){
      System.out.println("----��������� ���������� �� �������----");
      printListClients();
      System.out.print("������� ����� �������: ");
      long nomer= scanner.nextLong();
      Client clients = clientFacade.find(nomer);
          if(nomer==clients.getId()){
              System.out.println("1: ����� �����");
              System.out.println("2: ����� �������");
              System.out.println("3: ����� ������� ����");
              System.out.println("4: ����� ������ ��������");
              System.out.print("�������� ����� ������: ");
              int task1= scanner.nextInt();scanner.nextLine();
              System.out.println(" ");
              switch(task1){
                  case 1:
                      System.out.print("������� ����� ���: ");
                      clients.setFirstName(scanner.nextLine());
                      clientFacade.edit(clients);
                      System.out.println(" ");
                      System.out.println("��� �������� ��: " + clients.getFirstName());
                      break;
                  case 2:
                      System.out.print("������� ����� �������: ");
                      clients.setSecondName(scanner.nextLine());
                      clientFacade.edit(clients);
                      System.out.println("");
                      System.out.println("������� �������� ��: " + clients.getSecondName());
                      break;
                  case 3:
                      System.out.print("������� ����� ������ ���: ");
                      clients.setClientNumber(scanner.nextLong());scanner.nextLine();
                      clientFacade.edit(clients);
                      System.out.println("");
                      System.out.println("������ ��� ������� ��: " + clients.getClientNumber());
                      break;
                  case 4:
                      System.out.println("������� ����� ����� ��������: ");
                      clients.setPhone(scanner.nextLine());
                      clientFacade.edit(clients);
                      System.out.println("");
                      System.out.println("����� �������� ������� ��: " + clients.getPhone());
                      break;
              }
              
          }
         
      }
      

  private void addMoneyClient(){
      System.out.println("----���������� ����� ������� �� ���� ----");
        System.out.println(1+1); printListClients();
        System.out.print("�������� ������ ��� �������: ");
        long nomer =scanner.nextLong();
        Client clients = clientFacade.find(nomer);
            if(nomer == clients.getId()){
                System.out.println("������� ����� ������� ������ �������� �������: ");
                float newCash= scanner.nextFloat();
                newCash=newCash+ clients.getMoney();
                clients.setMoney(newCash);
                System.out.println(clients.getMoney()+" �� ����� � "+ clients.getFirstName());
                clientFacade.edit(clients);
               
        }
  }
  
  private void printListClients(){
    System.out.println("----������ ��������----");
    List<Client> clients = clientFacade.findAll();
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
      modelFacade.create(model);;
  }
  private void changeModelsInfo(){
      System.out.println("----��������� ���������� �� ������ �����----");
      printListModels();
      System.out.print("������� ID �����: ");
      long nomer= scanner.nextLong();
      Model models = modelFacade.find(nomer);
          if(nomer==models.getId()){
              System.out.println("1: ����� �������� �������������");
              System.out.println("2: ����� �������� ������");
              System.out.println("3: ����� ��������� ������");
              System.out.println("4: ����� ������� ������");
              System.out.print("�������� ����� ������: ");
              int task1= scanner.nextInt();scanner.nextLine();
              System.out.println("");
              switch(task1){
                  case 1:
                      System.out.print("������� ������ �������������: ");
                      models.setShoeMaker(scanner.nextLine());
                      modelFacade.edit(models);
                      System.out.println("");
                      System.out.println("������������� ������ ��: " + models.getShoeMaker());
                      break;
                  case 2:
                      System.out.print("������� ����� �������� ������: ");
                      models.setShoeName(scanner.nextLine());
                      modelFacade.edit(models);
                      System.out.println("");
                      System.out.println("�������� ������ ������� ��: " + models.getShoeName());
                      break;
                  case 3:
                      System.out.print("������� ����� ���������: ");
                      models.setShoePrice(scanner.nextFloat());scanner.nextLine();
                      modelFacade.edit(models);
                      System.out.println("");
                      System.out.println("���� ������ �������� ��: " + models.getShoePrice());
                      break;
                  case 4:
                      System.out.println("������� ����� ������ ������: ");
                      models.setShoeSize(scanner.nextFloat());scanner.nextLine();
                      modelFacade.edit(models);
                      System.out.println("");
                      System.out.println("������ ������� ��: " + models.getShoeSize());
                      break;
              }
          }
         
      }
  
  private void printListModels(){
    System.out.println("----C����� �����----");
    List<Model> models = modelFacade.findAll();
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
      Purchased purchased1= new Purchased();
      List<Model> models = modelFacade.findAll();
      List<Client> clients = clientFacade.findAll();
        
        printListClients();
        System.out.println("������� ����� ����������");
        numberClient=scanner.nextInt();scanner.nextLine();
        
        printListModels();
        System.out.println("����� ���� ����� �� �� ������ ����������?: ");
        numberModel=scanner.nextInt();scanner.nextLine();
        purchased1.setModels(models.get((int) numberModel-1));
        purchased1.setClient(clients.get((int)numberClient-1)); 
        purchased1.setPurchasedDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        if(purchased1.getClient().getMoney()>=purchased1.getModels().getShoePrice()){
            clients.get(numberClient-1).setMoney(clients.get(numberClient-1).getMoney()-models.get(numberModel-1).getShoePrice());
            Gain+=models.get(numberModel-1).getShoePrice();
            cash.setAllMoney(Gain);
            AllCash();
            purchasedFacade.create(purchased1);
            /*purchased.add(purchased1);
            keeper.savePurchased(purchased);
            keeper.saveClient(clients);*/
            
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
            allCashFacade.create(cash);
        
       }
    private void printAllCash(){
        List<AllCash> allcash = allCashFacade.findAll();
        for (int i = 0; i < allcash.size(); i++) {
        System.out.println("������� ���������: "+ allcash.get(i).getAllMoney());
            break;
            }
    }
    private void allCashForMonth(){
        System.out.println("----����� ������� �� ��������� �����---");
        System.out.print("�������� ����� � ���� �����: ");
        int month = scanner.nextInt();
        float Moneysss=0;
        List<Purchased> purchased = purchasedFacade.findAll();
        for (int i = 0; i < purchased.size(); i++) {
            if(purchased.get(i).getPurchasedDate().getMonth()+1==month){
               Moneysss+= purchased.get(i).getModels().getShoePrice();
                
            }
        }
        if (Moneysss != 0){
            System.out.println("������� �������� �� " + monthsNames[month-1]+": "+Moneysss);
        }else{
            System.out.println("������ �� ����!");
        }
    }
    }