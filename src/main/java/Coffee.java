import java.util.List;

public class Coffee extends Product{
    public Size size;
    public List<Size> availableSize;

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

}
