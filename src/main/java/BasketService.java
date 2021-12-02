public class BasketService {

    public void addProduct(Basket basket, Coffee coffee, Size size) {
        if(checkSize(coffee, size)) {
            coffee.setSize(size);
            basket.addContents(coffee);
        } else {
            System.err.println("Not a valid size");
        }
    }

    public void addProduct(Basket basket, Pastry pastry) {
        basket.addContents(pastry);
    }

    public boolean checkSize(Coffee coffee, Size size) {
        return coffee.getAvailableSizes().contains(size);
    }

}
