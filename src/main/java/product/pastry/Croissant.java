package product.pastry;

import java.math.BigDecimal;

public class Croissant implements Pastry{

    private BigDecimal basePrice = new BigDecimal("1.80");
    private int stockLevel = 15;

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
        return BigDecimal.ZERO;
    }
}
