import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> contents = new ArrayList<>();
    private double totalBasketPrice;

    public List<Product> getContents() {
        return contents;
    }

    public double getTotalBasketPrice() {
        for(Product product: contents) {
            if (product instanceof Coffee) {
                totalBasketPrice += product.getBasePrice() + ((Coffee) product).getSize().getAdditionalCost();
            } else totalBasketPrice += product.getBasePrice();
        }
        return totalBasketPrice;
    }

    public void addContents(Product p) {
        contents.add(p);
    }
}
