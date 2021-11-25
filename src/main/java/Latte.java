import java.util.List;

public class Latte extends Coffee{

    Latte(Size size) {
        setAvailableSize(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        setSize(size);
        setPrice(2.95);
    }

}
