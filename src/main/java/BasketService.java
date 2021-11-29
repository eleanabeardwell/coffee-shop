import java.util.ArrayList;
import java.util.List;

public class BasketService {

    private final List<Product> runningContents = new ArrayList<>();

    public void addProduct(Basket basket, Coffee coffee, Size size) {
        if(checkSize(coffee, size)) {
            coffee.setSize(size);
            addCoffeeToBasket(basket, coffee);
        } else {
            System.err.println("Not a valid size");
        }
    }

    private void addCoffeeToBasket(Basket basket, Coffee coffee) {
        calculatePrice(coffee);
        basket.setTotalBasketPrice(basket.getTotalBasketPrice() + calculatePrice(coffee));
        runningContents.add(coffee);
        basket.setContents(runningContents);
    }

    public boolean checkSize(Coffee coffee, Size size) {
        return coffee.getAvailableSize().contains(size);
    }

    public double calculatePrice(Coffee coffee) {

        switch(coffee.getSize()) {
            case MEDIUM: return coffee.getBasePrice() + 0.30;
            case LARGE: return coffee.getBasePrice() + 0.60;
            case DOUBLE: return coffee.getBasePrice() * 2;
            default: return coffee.getBasePrice();
        }
    }



}
