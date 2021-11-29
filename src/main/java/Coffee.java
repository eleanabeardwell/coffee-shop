import java.util.List;

public abstract class Coffee extends Product{
    private Size size;
    private List<Size> availableSize;

    public void setSize(Size s) {
        size = s;
    }

    public Size getSize() {
        return size;
    }

    public void setAvailableSize(List<Size> allSizes) {
        availableSize = allSizes;
    }

    public List<Size> getAvailableSize() {
        return availableSize;
    }

    public abstract void makeCoffee();

}
