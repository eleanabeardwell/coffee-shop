import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoffeeTest {

    private Latte smallLatte;
    private Latte mediumLatte;
    private Cappuccino smallCappuccino;
    private Cappuccino largeCappuccino;
    private Espresso doubleEspresso;

    @BeforeEach
    public void setUp() {
        smallLatte = new Latte(Size.SMALL);
        mediumLatte = new Latte(Size.MEDIUM);
        smallCappuccino = new Cappuccino(Size.SMALL);
        largeCappuccino = new Cappuccino(Size.LARGE);
        doubleEspresso = new Espresso(Size.DOUBLE);
    }

    @Test
    void testValidSize() {
        assertTrue(smallLatte.checkSize());
    }

    @Test
    void testInvalidSize() {
        Latte invalid = new Latte(Size.SINGLE);

        assertFalse(invalid.checkSize());
    }

    @Test
    void testSmallLattePrice() {
        double expected = 2.95;
        double actual = smallLatte.calculatePrice();

        assertEquals(expected, actual);
    }

     @Test
     void testMediumLattePrice() {
         double expected = 3.25;
         double actual = mediumLatte.calculatePrice();

         assertEquals(expected, actual);
     }

    @Test
    void testSmallCappuccinoPrice() {
        double expected = 3.15;
        double actual = smallCappuccino.calculatePrice();

        assertEquals(expected, actual);
    }

    @Test
    void testLargeCappuccinoPrice() {
        double expected = 3.75;
        double actual = largeCappuccino.calculatePrice();

        assertEquals(expected, actual);
    }

    @Test
    void testDoubleEspressoPrice() {
        double expected = 2.20;
        double actual = doubleEspresso.calculatePrice();

        assertEquals(expected, actual);
    }

}

