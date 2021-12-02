import java.math.BigDecimal;
import java.util.List;

public class Cappuccino extends Coffee{

    public Cappuccino() {
        super(new BigDecimal("2.75"), 30, List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
    }

}
