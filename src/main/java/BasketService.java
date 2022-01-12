public class BasketService {

    public void addProduct(Basket basket, Coffee coffee) {
            basket.addContents(coffee);
    }

    public void addProduct(Basket basket, Pastry pastry) {
        basket.addContents(pastry);
    }

    public void removeProduct(Basket basket, Pastry pastry) {
        basket.removeContents(pastry);
    }

}
