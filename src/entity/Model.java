
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ShoeName;
    private String ShoeMaker;
    private float ShoePrice;
    private float ShoeSize;
    

    public String getShoeName() {
        return ShoeName;
    }

    public void setShoeName(String ShoeName) {
        this.ShoeName = ShoeName;
    }

    public String getShoeMaker() {
        return ShoeMaker;
    }

    public void setShoeMaker(String ShoeMaker) {
        this.ShoeMaker = ShoeMaker;
    }

    public float getShoePrice() {
        return ShoePrice;
    }

    public void setShoePrice(float ShoePrice) {
        this.ShoePrice = ShoePrice;
    }

    @Override
    public String toString() {
        return "Model{" + "id=" + id + ", ShoeName=" + ShoeName + ", ShoeMaker=" + ShoeMaker + ", ShoePrice=" + ShoePrice + ", ShoeSize=" + ShoeSize + '}';
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getShoeSize() {
        return ShoeSize;
    }

    public void setShoeSize(float ShoeSize) {
        this.ShoeSize = ShoeSize;
    }


    





    }



    
    





