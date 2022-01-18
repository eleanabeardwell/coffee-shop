import basket.Basket;
import basket.BasketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import product.coffee.Cappuccino;
import product.coffee.Espresso;
import product.coffee.Latte;
import product.coffee.Size;
import product.pastry.Croissant;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoffeeTest {

    private Basket basket;
    private Croissant croissant;
    private BasketService service;

    @BeforeEach
    public void setUp() {
        basket = new Basket();
        croissant = new Croissant();
        service = new BasketService();
    }

    @Test
    void testSmallLattePrice() {
        var latte = new Latte(Size.SMALL);
        BigDecimal expected = new BigDecimal("2.55");
        BigDecimal actual = latte.getBasePrice();

        assertEquals(expected, actual);
    }


    @Test
    void testSmallCappuccinoPrice() {
        var cappuccino = new Cappuccino(Size.SMALL);
        BigDecimal expected = new BigDecimal("2.75");
        BigDecimal actual = cappuccino.getBasePrice();

        assertEquals(expected, actual);
    }

    @Test
    void testSingleEspressoPrice() {
        var espresso = new Espresso(Size.SINGLE);
        BigDecimal expected = new BigDecimal("1.10");
        BigDecimal actual = espresso.getBasePrice();

        assertEquals(expected, actual);
    }

    @Test
    void testValidLatteSize() {
        var latte = new Latte(Size.LARGE);
        service.addProduct(basket, latte);
        assertEquals(Size.LARGE, latte.getSize());
    }

    @Test
    void testInvalidLatteSize() {
        assertThrows(RuntimeException.class,
                     () -> {
                         var latte = new Latte(Size.SINGLE);
                     });
    }

    @Test
    void testLargeCappuccinoPrice() {
        var cappuccino = new Cappuccino(Size.LARGE);
        service.addProduct(basket, cappuccino);
        BigDecimal expected = new BigDecimal("3.35");
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testDoubleEspressoPrice() {
        var espresso = new Espresso(Size.DOUBLE);
        service.addProduct(basket, espresso);
        BigDecimal expected = new BigDecimal("2.20");
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testSmallLatteAndMediumCappuccinoPrice() {
        var latte = new Latte(Size.SMALL);
        var cappuccino = new Cappuccino(Size.MEDIUM);
        service.addProduct(basket, latte);
        service.addProduct(basket, cappuccino);
        BigDecimal expected = new BigDecimal("5.60");
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testLargeLatteAndDoubleEspressoPrice() {
        var latte = new Latte(Size.LARGE);
        var espresso = new Espresso(Size.DOUBLE);
        service.addProduct(basket, latte);
        service.addProduct(basket, espresso);
        BigDecimal expected = new BigDecimal("5.35");
//        assertThat(basket.getTotalBasketPrice(), compareEquals(expected));
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testCappuccinoAndCroissantPrice() {
        var cappuccino = new Cappuccino(Size.MEDIUM);
        service.addProduct(basket, cappuccino);
        service.addProduct(basket, croissant);
        BigDecimal expected = new BigDecimal("4.85");
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testRemovalOfProductFromBasket() {
        var latte = new Latte(Size.LARGE);
        service.addProduct(basket, latte);
        service.removeProduct(basket, latte);
        assertEquals(basket.getContents().size(), 0);
    }

    @Test
    void testAdditionRemovalOfDifferentSizeProductFromBasket() {
        var largeLatte = new Latte(Size.LARGE);
        var smallLatte = new Latte(Size.SMALL);
        service.addProduct(basket, smallLatte);
        service.addProduct(basket, largeLatte);
        service.removeProduct(basket, largeLatte);
        BigDecimal expected = new BigDecimal("2.55");
        assertEquals(1, basket.getContents().size());
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testRemovalOnEmptyBasket() {
        var espresso = new Espresso(Size.SINGLE);
        assertThrows(RuntimeException.class, () -> {
                service.removeProduct(basket, espresso);
        });
        assertEquals(basket.getContents().size(), 0);
    }

    @Test
    void testAdditionOfMultipleQuantity() {
        var latte = new Latte(Size.SMALL);
        service.addProduct(basket, latte, 3);
        assertEquals(3, basket.getContents().size());
        BigDecimal expected = new BigDecimal("2.55").multiply(BigDecimal.valueOf(3));
        assertEquals(expected, basket.getTotalBasketPrice());
    }

    @Test
    void testAdditionOfMultipleQuantityAndRemoval() {
        var latteS = new Latte(Size.SMALL);
        var latteM = new Latte(Size.MEDIUM);
        service.addProduct(basket, latteS, 10);
        service.addProduct(basket, latteM, 3);
        service.removeProduct(basket, latteM);
        service.removeProduct(basket, latteS, 4);
        assertEquals(8, basket.getContents().size());
        BigDecimal a = new BigDecimal("2.55").multiply(BigDecimal.valueOf(6));
        BigDecimal b = new BigDecimal("2.85").multiply(BigDecimal.valueOf(2));
        BigDecimal expected = a.add(b);
        assertEquals(expected, basket.getTotalBasketPrice());
    }


}

