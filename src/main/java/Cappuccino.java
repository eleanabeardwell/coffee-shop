import java.util.List;

public class Cappuccino extends Coffee{

    public void makeCoffee(){
        setAvailableSize(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        setBasePrice(2.75);
    }

}
