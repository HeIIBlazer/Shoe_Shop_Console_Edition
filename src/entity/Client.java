package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Long ClientNumber;
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
        return "Client{" + "ClientNumber=" + ClientNumber + ", FirstName=" + FirstName + ", SecondName=" + SecondName + ", Phone=" + Phone + ", Money=" + Money + '}';
    }



    public Long getClientNumber() {
        return ClientNumber;
    }

    public void setClientNumber(Long ClientNumber) {
        this.ClientNumber = ClientNumber;
    }
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    
}
