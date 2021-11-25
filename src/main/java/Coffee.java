import java.util.List;

public class Coffee extends Product{
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

    public double calculatePrice() {

        switch(size) {
            case MEDIUM: return getPrice() + 0.30;
            case LARGE: return getPrice() + 0.60;
            case DOUBLE: return getPrice() * 2;
            default: return getPrice();
        }
    }

    public boolean checkSize() {
        return availableSize.contains(size);
    }


}
