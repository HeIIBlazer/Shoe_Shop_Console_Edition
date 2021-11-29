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
   String[] monthsNames = {"янв", "фев", "мар", "апр", "май", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
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
            System.out.println("0: Выход из программы");
            System.out.println("1: Ввод Информация покупателе");
            System.out.println("2: Изменить информацию об пользователе");
            System.out.println("3: Добавить деньги пользователю");
            System.out.println("4: Информация о покупателях");
            System.out.println("5: Ввод информации об модели обуви");
            System.out.println("6: Изменить информацию об модели обуви");
            System.out.println("7: Информация об модели обуви");
            System.out.println("8: Покупка обуви");
            System.out.println("9: Сколько зараболтал магазин за все время");
            System.out.println("10: Сколько зараболтал магазин за определенный месяц");
            System.out.print("Выберети номер задачи: ");
            int task = scanner.nextInt(); scanner.nextLine();
            List<AllCash> allcash = allCashFacade.findAll();
            for (int i = 0; i < allcash.size(); i++) {
                Gain=allcash.get(i).getAllMoney();
             }
            
            switch(task){

                case 0:
                    repeat="q";
                    System.out.println("ДАВАЙ ДО ЗАВТРА!!!!!!");
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
                    System.out.println("Введите номер из списка!!!");
            }
     }while("r".equals(repeat));   
    }
   
   
  private void addClient(){
      System.out.println("----Ввод информации о клиенте----");
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
      clientFacade.create(client);
}
  
  private void changeClientInfo(){
      System.out.println("----Изменение информации об клиенте----");
      printListClients();
      System.out.print("Введите Номер клиента: ");
      long nomer= scanner.nextLong();
      Client clients = clientFacade.find(nomer);
          if(nomer==clients.getId()){
              System.out.println("1: Смена имени");
              System.out.println("2: Смена фамилии");
              System.out.println("3: Смена личного кода");
              System.out.println("4: Смена номера телефона");
              System.out.print("Выберете номер задачи: ");
              int task1= scanner.nextInt();scanner.nextLine();
              System.out.println(" ");
              switch(task1){
                  case 1:
                      System.out.print("Введите новое имя: ");
                      clients.setFirstName(scanner.nextLine());
                      clientFacade.edit(clients);
                      System.out.println(" ");
                      System.out.println("Имя изменено на: " + clients.getFirstName());
                      break;
                  case 2:
                      System.out.print("Введите новую фамилию: ");
                      clients.setSecondName(scanner.nextLine());
                      clientFacade.edit(clients);
                      System.out.println("");
                      System.out.println("Фамилия изменена на: " + clients.getSecondName());
                      break;
                  case 3:
                      System.out.print("Введите новый личный код: ");
                      clients.setClientNumber(scanner.nextLong());scanner.nextLine();
                      clientFacade.edit(clients);
                      System.out.println("");
                      System.out.println("Личный код изменен на: " + clients.getClientNumber());
                      break;
                  case 4:
                      System.out.println("Введите новый номер телефона: ");
                      clients.setPhone(scanner.nextLine());
                      clientFacade.edit(clients);
                      System.out.println("");
                      System.out.println("Номер телефона изменен на: " + clients.getPhone());
                      break;
              }
              
          }
         
      }
      

  private void addMoneyClient(){
      System.out.println("----Добавление денег клиенту на счет ----");
        System.out.println(1+1); printListClients();
        System.out.print("Выберите личный код клиента: ");
        long nomer =scanner.nextLong();
        Client clients = clientFacade.find(nomer);
            if(nomer == clients.getId()){
                System.out.println("Введите сумму которую хотите добавить клиенту: ");
                float newCash= scanner.nextFloat();
                newCash=newCash+ clients.getMoney();
                clients.setMoney(newCash);
                System.out.println(clients.getMoney()+" На счету у "+ clients.getFirstName());
                clientFacade.edit(clients);
               
        }
  }
  
  private void printListClients(){
    System.out.println("----Список клиентов----");
    List<Client> clients = clientFacade.findAll();
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
      modelFacade.create(model);;
  }
  private void changeModelsInfo(){
      System.out.println("----Изменение информации об модели обуви----");
      printListModels();
      System.out.print("Введите ID обуви: ");
      long nomer= scanner.nextLong();
      Model models = modelFacade.find(nomer);
          if(nomer==models.getId()){
              System.out.println("1: Смена компании производителя");
              System.out.println("2: Смена названия модели");
              System.out.println("3: Смена стоймости модели");
              System.out.println("4: Смена размера модели");
              System.out.print("Выберете номер задачи: ");
              int task1= scanner.nextInt();scanner.nextLine();
              System.out.println("");
              switch(task1){
                  case 1:
                      System.out.print("Введите нового производителя: ");
                      models.setShoeMaker(scanner.nextLine());
                      modelFacade.edit(models);
                      System.out.println("");
                      System.out.println("Производитель сменен на: " + models.getShoeMaker());
                      break;
                  case 2:
                      System.out.print("Введите новое название модели: ");
                      models.setShoeName(scanner.nextLine());
                      modelFacade.edit(models);
                      System.out.println("");
                      System.out.println("Название модели изменен на: " + models.getShoeName());
                      break;
                  case 3:
                      System.out.print("Введите новую стоймость: ");
                      models.setShoePrice(scanner.nextFloat());scanner.nextLine();
                      modelFacade.edit(models);
                      System.out.println("");
                      System.out.println("Цена модели изменена на: " + models.getShoePrice());
                      break;
                  case 4:
                      System.out.println("Введите новый размер модели: ");
                      models.setShoeSize(scanner.nextFloat());scanner.nextLine();
                      modelFacade.edit(models);
                      System.out.println("");
                      System.out.println("Размер изменен на: " + models.getShoeSize());
                      break;
              }
          }
         
      }
  
  private void printListModels(){
    System.out.println("----Cписок обуви----");
    List<Model> models = modelFacade.findAll();
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
      Purchased purchased1= new Purchased();
      List<Model> models = modelFacade.findAll();
      List<Client> clients = clientFacade.findAll();
        
        printListClients();
        System.out.println("Введите номер покупателя");
        numberClient=scanner.nextInt();scanner.nextLine();
        
        printListModels();
        System.out.println("Какую пару обуви вы бы хотели приобрести?: ");
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
            System.out.println("ДЕНЕГ МАЛО ЧЕЛ!!!!!!"); 
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
        System.out.println("Магазин заработал: "+ allcash.get(i).getAllMoney());
            break;
            }
    }
    private void allCashForMonth(){
        System.out.println("----Вывод прибыли за выбранный месяц---");
        System.out.print("Выберите месяц в виде числа: ");
        int month = scanner.nextInt();
        float Moneysss=0;
        List<Purchased> purchased = purchasedFacade.findAll();
        for (int i = 0; i < purchased.size(); i++) {
            if(purchased.get(i).getPurchasedDate().getMonth()+1==month){
               Moneysss+= purchased.get(i).getModels().getShoePrice();
                
            }
        }
        if (Moneysss != 0){
            System.out.println("Прибыль магазина за " + monthsNames[month-1]+": "+Moneysss);
        }else{
            System.out.println("Дохода не было!");
        }
    }
    }