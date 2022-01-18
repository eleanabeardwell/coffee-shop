package product.coffee;

import product.coffee.Coffee;

import java.math.BigDecimal;
import java.util.List;

public class Espresso implements Coffee {

    private final List<Size> availableSizes = List.of(Size.SINGLE, Size.DOUBLE);
    private Size size;
    private BigDecimal basePrice = new BigDecimal("1.10");
    private static int stockLevel = 50;

    public Espresso(Size size) {setSize(size);}


    @Override
    public void setSize(Size size) {
        checkSize(size);
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public List<Size> getAvailableSizes() {
        return availableSizes;
    }

    @Override
    public String getProductName() {
        return "Espresso";
    }

    @Override
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    @Override
    public int getStockLevel() {
        return stockLevel;
    }

    @Override
    public void setStockLevel(int s) {
        stockLevel = s;
    }

    @Override
    public void depleteStockLevel() {
        --stockLevel;
    }

    @Override
    public BigDecimal getAdditionalCost() {
        return size.getAdditionalCost();
    }
}
