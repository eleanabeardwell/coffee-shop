import java.util.List;

public class BasketService {

    public void addProduct(Basket basket, Coffee coffee, Size size) {
        if(checkSize(coffee, size)) {
            coffee.setSize(size);
            calculatePrice(coffee);
            basket.setTotalBasketPrice(basket.getTotalBasketPrice() + calculatePrice(coffee));
        } else {
            System.out.println("Not a valid size, setting to default M");
            coffee.setSize(Size.MEDIUM);
            calculatePrice(coffee);
            basket.setTotalBasketPrice(basket.getTotalBasketPrice() + calculatePrice(coffee));
        }

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
