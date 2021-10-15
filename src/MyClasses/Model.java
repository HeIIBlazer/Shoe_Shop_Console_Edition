
package MyClasses;

public class Model {
    private String ShoeName;
    private String ShoeMaker;
    private float ShoePrice;

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
        return "Shoes{" + "ShoeName=" + ShoeName + ", ShoeMaker=" + ShoeMaker + ", ShoePrice=" + ShoePrice + '}';
    }  
}
