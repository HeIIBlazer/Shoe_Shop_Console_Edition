
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AllCash implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    float AllMoney;

    public float getAllMoney() {
        return AllMoney;
    }

    public void setAllMoney(float AllMoney) {
        this.AllMoney = AllMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AllCash{" + "AllMoney=" + AllMoney + '}';
    }
    
}
