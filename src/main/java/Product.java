import java.util.List;

public abstract class Product {

    private double basePrice;
    private int stockLevel;
    private List<Size> availableSizes;

    public Product(double basePrice, int stockLevel, List<Size> availableSizes) {
        this.basePrice = basePrice;
        this.stockLevel = stockLevel;
        this.availableSizes = availableSizes;
    }

    public double getBasePrice() {
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

    public List<Size> getAvailableSizes() {
        return availableSizes;
    }

}
