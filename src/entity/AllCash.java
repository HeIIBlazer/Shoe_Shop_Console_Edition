
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AllCash implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    float AllMoney;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public float getAllMoney() {
        return AllMoney;
    }

    public void setAllMoney(float AllMoney) {
        this.AllMoney = AllMoney;
    }

    @Override
    public String toString() {
        return "AllCash{" + "AllMoney=" + AllMoney + '}';
    }
   
}
