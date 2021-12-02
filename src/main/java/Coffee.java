import java.math.BigDecimal;
import java.util.List;

public abstract class Coffee extends Product{
    private Size size;
    private List<Size> availableSizes;

    protected Coffee(BigDecimal basePrice, int stockLevel, List<Size> availableSizes) {
        super(basePrice, stockLevel);
        this.availableSizes = availableSizes;
    }

    public void setSize(Size s) {
        size = s;
    }

    public Size getSize() {
        return size;
    }

    public List<Size> getAvailableSizes() {
        return availableSizes;
    }

}
