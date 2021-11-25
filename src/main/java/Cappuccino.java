import java.util.List;

public class Cappuccino extends Coffee{

    Cappuccino(Size size) {
        setAvailableSize(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        setPrice(3.15);
        setSize(size);
    }

}
