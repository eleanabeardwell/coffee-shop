import java.math.BigDecimal;
import java.util.List;

public class Latte extends Coffee{

    public Latte() {
        super(new BigDecimal("2.55"), 30, List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
    }

}
