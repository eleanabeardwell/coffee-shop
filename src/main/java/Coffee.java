import java.util.List;

public abstract class Coffee extends Product{
    private Size size;

    public Coffee(double basePrice, int stockLevel, List<Size> availableSizes) {
        super(basePrice, stockLevel, availableSizes);
    }

    public void setSize(Size s) {
        size = s;
    }

    public Size getSize() {
        return size;
    }

}
