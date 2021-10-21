
package MyClasses;

import java.io.Serializable;



public class ShoeSize implements Serializable {
   private int ShoeSize;

    public int getShoeSize() {
        return ShoeSize;
    }

    public void setShoeSize(int ShoeSize) {
        this.ShoeSize = ShoeSize;
    }

    @Override
    public String toString() {
        return "ShoeSize{" + "ShoeSize=" + ShoeSize + '}';
    }


   
}
