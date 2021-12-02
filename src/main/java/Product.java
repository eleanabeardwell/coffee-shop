import java.math.BigDecimal;

public abstract class Product {

    private BigDecimal basePrice;
    private int stockLevel;

    protected Product(BigDecimal basePrice, int stockLevel) {
        this.basePrice = basePrice;
        this.stockLevel = stockLevel;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    private void setStockLevel(int s) {
        stockLevel = s;
    }

    public void depleteStockLevel() {
        setStockLevel(--stockLevel);
    }

}
