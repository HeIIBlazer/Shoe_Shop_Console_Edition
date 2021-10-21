package MyClasses;

import java.io.Serializable;

public class Client implements Serializable  {
    String FirstName;
    String SecondName;
    String Phone;
    float Money;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    
    }

    public float getMoney() {
        return Money;
    }

    public void setMoney(float Money) {
        this.Money = Money;
    }

    @Override
    public String toString() {
        return "Client{" + "FirstName=" + FirstName + ", SecondName=" + SecondName + ", Phone=" + Phone + ", Money=" + Money + '}';
    }


    
}
