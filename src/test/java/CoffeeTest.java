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

    private Croissant croissant;
    private BasketService service;

    @BeforeEach
    public void setUp() {
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
        service.addProduct(latte);
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
        service.addProduct(cappuccino);
        BigDecimal expected = new BigDecimal("3.35");
        assertEquals(expected, service.basket.getTotalBasketPrice());
    }

    @Test
    void testDoubleEspressoPrice() {
        var espresso = new Espresso(Size.DOUBLE);
        service.addProduct(espresso);
        BigDecimal expected = new BigDecimal("2.20");
        assertEquals(expected, service.basket.getTotalBasketPrice());
    }

    @Test
    void testSmallLatteAndMediumCappuccinoPrice() {
        var latte = new Latte(Size.SMALL);
        var cappuccino = new Cappuccino(Size.MEDIUM);
        service.addProduct(latte);
        service.addProduct(cappuccino);
        BigDecimal expected = new BigDecimal("5.60");
        assertEquals(expected, service.basket.getTotalBasketPrice());
    }

    @Test
    void testLargeLatteAndDoubleEspressoPrice() {
        var latte = new Latte(Size.LARGE);
        var espresso = new Espresso(Size.DOUBLE);
        service.addProduct(latte);
        service.addProduct(espresso);
        BigDecimal expected = new BigDecimal("5.35");
//        assertThat(basket.getTotalBasketPrice(), compareEquals(expected));
        assertEquals(expected, service.basket.getTotalBasketPrice());
    }

    @Test
    void testCappuccinoAndCroissantPrice() {
        var cappuccino = new Cappuccino(Size.MEDIUM);
        service.addProduct(cappuccino);
        service.addProduct(croissant);
        BigDecimal expected = new BigDecimal("4.85");
        assertEquals(expected, service.basket.getTotalBasketPrice());
    }

    @Test
    void testRemovalOfProductFromBasket() {
        var latte = new Latte(Size.LARGE);
        service.addProduct(latte);
        service.removeProduct(latte);
        assertEquals(0, service.basket.getContents().size());
    }

    @Test
    void testAdditionRemovalOfDifferentSizeProductFromBasket() {
        var largeLatte = new Latte(Size.LARGE);
        var smallLatte = new Latte(Size.SMALL);
        service.addProduct(smallLatte);
        service.addProduct(largeLatte);
        service.removeProduct(largeLatte);
        BigDecimal expected = new BigDecimal("2.55");
        assertEquals(1, service.basket.getContents().size());
        assertEquals(expected, service.basket.getTotalBasketPrice());
    }

    @Test
    void testRemovalOnEmptyBasket() {
        var espresso = new Espresso(Size.SINGLE);
        assertThrows(RuntimeException.class, () -> {
                service.removeProduct(espresso);
        });
        assertEquals(0, service.basket.getContents().size());
    }

    @Test
    void testAdditionOfMultipleQuantity() {
        var latte = new Latte(Size.SMALL);
        service.addProduct(latte, 3);
        assertEquals(3, service.basket.getContents().size());
        BigDecimal expected = new BigDecimal("2.55").multiply(BigDecimal.valueOf(3));
        assertEquals(expected, service.basket.getTotalBasketPrice());
    }

    @Test
    void testAdditionOfMultipleQuantityAndRemoval() {
        var latteS = new Latte(Size.SMALL);
        var latteM = new Latte(Size.MEDIUM);
        service.addProduct(latteS, 10);
        service.addProduct(latteM, 3);
        service.removeProduct(latteM);
        service.removeProduct(latteS, 4);
        assertEquals(8, service.basket.getContents().size());
        BigDecimal a = new BigDecimal("2.55").multiply(BigDecimal.valueOf(6));
        BigDecimal b = new BigDecimal("2.85").multiply(BigDecimal.valueOf(2));
        BigDecimal expected = a.add(b);
        assertEquals(expected, service.basket.getTotalBasketPrice());
    }

    @Test
    void testStockLevelDepletionOnCheckout() {
        var latte = new Latte(Size.SMALL);
        int originalStock = latte.getStockLevel();
        int quantity = 3;
        service.addProduct(latte, quantity);
        service.checkout();
        int expected = originalStock - quantity;
        assertEquals(expected, latte.getStockLevel());
    }

    @Test
    void testStockLevelDepletionOnCheckoutOfDifferentProducts() {
        var latte = new Latte(Size.SMALL);
        var espresso = new Espresso(Size.DOUBLE);
        var cappuccino = new Cappuccino(Size.MEDIUM);
        int originalLatteStock = latte.getStockLevel();
        int originalCapStock = cappuccino.getStockLevel();
        int originalEspStock = espresso.getStockLevel();
        int quantity = 3;
        service.addProduct(latte, quantity);
        service.addProduct(cappuccino);
        service.addProduct(espresso);
        service.checkout();
        assertEquals(originalLatteStock - quantity, latte.getStockLevel());
        assertEquals(originalCapStock - 1, cappuccino.getStockLevel());
        assertEquals(originalEspStock - 1, espresso.getStockLevel());
    }


}

