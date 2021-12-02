import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> contents = new ArrayList<>();
    private BigDecimal totalBasketPrice = new BigDecimal("0");

    public List<Product> getContents() {
        return contents;
    }

    public BigDecimal getTotalBasketPrice() {
        for(Product product: contents) {
            if (product instanceof Coffee) {
                BigDecimal coffeePrice = product.getBasePrice().add(((Coffee) product).getSize().getAdditionalCost());
                totalBasketPrice = totalBasketPrice.add(coffeePrice);

            } else totalBasketPrice = totalBasketPrice.add(product.getBasePrice());
        }
        return totalBasketPrice;
    }

    public void addContents(Product p) {
        contents.add(p);
    }
}
