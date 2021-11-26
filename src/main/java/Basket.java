import java.util.List;

public class Basket {
    private List<Product> contents;
    private double totalBasketPrice;

    public List<Product> getContents() {
        return contents;
    }

    public double getTotalBasketPrice() {
        return totalBasketPrice;
    }

    public void setContents(List<Product> c) {
        contents = c;
    }

    public void setTotalBasketPrice(double p) {
        totalBasketPrice = p;
    }
}
