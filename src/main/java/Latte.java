import java.util.List;

public class Latte extends Coffee{

    private static int stockLevel = 30;

    public void makeCoffee(){
        setAvailableSize(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        setBasePrice(2.55);
    }

}
