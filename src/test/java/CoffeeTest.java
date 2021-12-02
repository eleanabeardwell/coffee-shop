import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoffeeTest {

    private Latte latte;
    private Cappuccino cappuccino;
    private Espresso espresso;
    private Basket basket;
    private Croissant croissant;
    private BasketService service;

    @BeforeEach
    public void setUp() {
        latte = new Latte();
        cappuccino = new Cappuccino();
        espresso = new Espresso();
        basket = new Basket();
        croissant = new Croissant();
        service = new BasketService();
    }

    @Test
    void testSmallLattePrice() {
        BigDecimal expected = new BigDecimal("2.55");
        BigDecimal actual = latte.getBasePrice();

        assertEquals(expected, actual);
    }


    @Test
    void testSmallCappuccinoPrice() {
        BigDecimal expected = new BigDecimal("2.75");
        BigDecimal actual = cappuccino.getBasePrice();

        assertEquals(expected, actual);
    }

    @Test
    void testSingleEspressoPrice() {
        BigDecimal expected = new BigDecimal("1.10");
        BigDecimal actual = espresso.getBasePrice();

        assertEquals(expected, actual);
    }

    @Test
    void testValidLatteSize() {
        service.addProduct(basket, latte, Size.LARGE);
        assertEquals(Size.LARGE, latte.getSize());
    }

    @Test
    void testInvalidLatteSize() {
        service.addProduct(basket, latte, Size.SINGLE);
        assertTrue(basket.getContents().isEmpty());
    }

    @Test
    void testLargeCappuccinoPrice() {
        service.addProduct(basket, cappuccino, Size.LARGE);
        BigDecimal expected = new BigDecimal("3.35");
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testDoubleEspressoPrice() {
        service.addProduct(basket, espresso, Size.DOUBLE);
        BigDecimal expected = new BigDecimal("2.20");
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testSmallLatteAndMediumCappuccinoPrice() {
        service.addProduct(basket, latte, Size.SMALL);
        service.addProduct(basket, cappuccino, Size.MEDIUM);
        BigDecimal expected = new BigDecimal("5.60");
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testLargeLatteAndDoubleEspressoPrice() {
        service.addProduct(basket, latte, Size.LARGE);
        service.addProduct(basket, espresso, Size.DOUBLE);
        BigDecimal expected = new BigDecimal("5.35");
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testCappuccinoAndCroissantPrice() {
        service.addProduct(basket, cappuccino, Size.MEDIUM);
        service.addProduct(basket, croissant);
        BigDecimal expected = new BigDecimal("4.85");
        assertEquals(expected, basket.getTotalBasketPrice());
    }

}

