import java.util.List;

public class Espresso extends Coffee{

    Espresso(Size size) {
        setAvailableSize(List.of(Size.SINGLE, Size.DOUBLE));
        setPrice(1.10);
        setSize(size);
    }

}
