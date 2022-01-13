package product;

import java.math.BigDecimal;

public interface Product {

    BigDecimal getBasePrice();

    int getStockLevel();

    void setStockLevel(int s);

    void depleteStockLevel();

    BigDecimal getAdditionalCost();

}
