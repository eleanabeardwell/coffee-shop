import java.math.BigDecimal;
import java.util.List;

public class Latte implements Coffee {

    private final List<Size> availableSizes = List.of(Size.SMALL, Size.MEDIUM, Size.LARGE);
    private Size size;
    private BigDecimal basePrice = new BigDecimal("2.55");
    private int stockLevel = 30;

    public Latte(Size size) {
        setSize(size);
    }

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
