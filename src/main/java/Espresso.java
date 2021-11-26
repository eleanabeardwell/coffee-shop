import java.util.List;

public class Espresso extends Coffee{

    public void makeCoffee(){
        setAvailableSize(List.of(Size.SINGLE, Size.DOUBLE));
        setBasePrice(1.10);
    }

}
