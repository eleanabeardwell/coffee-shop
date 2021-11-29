import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoffeeTest {

    private Latte latte;
    private Cappuccino cappuccino;
    private Espresso espresso;
    private Basket basket;
    private BasketService service;

    @BeforeEach
    public void setUp() {
        latte = new Latte();
        cappuccino = new Cappuccino();
        espresso = new Espresso();
        basket = new Basket();
        service = new BasketService();
    }

    @Test
    void testSmallLattePrice() {
        double expected = 2.55;
        latte.makeCoffee();
        double actual = latte.getBasePrice();

        assertEquals(expected, actual);
    }


    @Test
    void testSmallCappuccinoPrice() {
        double expected = 2.75;
        cappuccino.makeCoffee();
        double actual = cappuccino.getBasePrice();


        assertEquals(expected, actual);
    }

    @Test
    void testSingleEspressoPrice() {
        double expected = 1.10;
        espresso.makeCoffee();
        double actual = espresso.getBasePrice();

        assertEquals(expected, actual);
    }

    @Test
    void testValidLatteSize() {
        latte.makeCoffee();
        service.addProduct(basket, latte, Size.LARGE);
        assertEquals(Size.LARGE, latte.getSize());
    }

    @Test
    void testInvalidLatteSize() {
        latte.makeCoffee();
        service.addProduct(basket, latte, Size.SINGLE);
        assertTrue(basket.getContents().isEmpty());
    }

    @Test
    void testLargeCappuccinoPrice() {
        cappuccino.makeCoffee();
        service.addProduct(basket, cappuccino, Size.LARGE);
        double expected = 3.35;
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testDoubleEspressoPrice() {
        espresso.makeCoffee();
        service.addProduct(basket, espresso, Size.DOUBLE);
        double expected = 2.20;
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testSmallLatteAndMediumCappuccinoPrice() {
        latte.makeCoffee();
        cappuccino.makeCoffee();
        service.addProduct(basket, latte, Size.SMALL);
        service.addProduct(basket, cappuccino, Size.MEDIUM);
        double expected = 5.60;
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testLargeLatteAndDoubleEspressoPrice() {
        latte.makeCoffee();
        espresso.makeCoffee();
        service.addProduct(basket, latte, Size.LARGE);
        service.addProduct(basket, espresso, Size.DOUBLE);
        double expected = 5.35;
        assertEquals(expected, basket.getTotalBasketPrice());
    }

}

