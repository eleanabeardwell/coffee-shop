package basket;

import product.Product;

public class BasketService {

    public void addProduct(Basket basket, Product product) {
            basket.addContents(product);
    }

    public void removeProduct(Basket basket, Product product) {
        basket.removeContents(product);
    }

}
