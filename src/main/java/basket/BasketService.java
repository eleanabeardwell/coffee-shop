package basket;

import product.Product;

public class BasketService {

    public void addProduct(Basket basket, Product product, int quantity) {
        for(int i = 0; i < quantity; i++) {
            basket.addContents(product);
        }
    }

    public void addProduct(Basket basket, Product product) {
            basket.addContents(product);
    }

    public void removeProduct(Basket basket, Product product) {
        basket.removeContents(product);
    }

    public void removeProduct(Basket basket, Product product, int quantity) {
        for(int i = 0; i < quantity; i++) {
            basket.removeContents(product);
        }
    }

    public void checkout(Basket basket) {
        for(Product product: basket.getContents()) {
            product.depleteStockLevel();
        }
        ReceiptService.getReceipt(basket);
    }

}
