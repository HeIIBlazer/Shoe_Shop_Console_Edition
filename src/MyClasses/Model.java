
package MyClasses;

import java.io.Serializable;
import java.util.Arrays;


public class Model implements Serializable {
    private String ShoeName;
    private String ShoeMaker;
    private float ShoePrice;
    private ShoeSize[] ShoeSize;

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

    public ShoeSize[] getShoeSize() {
        return ShoeSize;
    }

    public void setShoeSize(ShoeSize[] ShoeSize) {
        this.ShoeSize = ShoeSize;
    }


    @Override
    public String toString() {
        return "Model{" + "ShoeName=" + ShoeName + ", ShoeMaker=" + ShoeMaker + ", ShoePrice=" + ShoePrice + ", ShoeSize=" + Arrays.toString(ShoeSize) + '}';
    }



    }



    
    





