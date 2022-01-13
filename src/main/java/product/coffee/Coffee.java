package product.coffee;

import product.Product;

import java.util.List;

public interface Coffee extends Product {

    void setSize(Size s);

    Size getSize();

    List<Size> getAvailableSizes();

    public default void checkSize(Size size) {
        if (getAvailableSizes().contains(size)) {
            return;
        }
        throw new RuntimeException("Invalid size");

    }

}
