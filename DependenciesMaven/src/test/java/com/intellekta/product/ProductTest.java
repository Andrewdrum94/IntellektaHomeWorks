package com.intellekta.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductTest {

    private Product product;

    @BeforeEach
    public void initialOfProduct() {
        product = new Product("Milk", 25, 5);
    }

    @Test
    public void productAvailableCurrentWorkTest() {
        Assertions.assertTrue(product.productAvailable());
    }

    @Test
    public void productOutOfStockTest() {
        product.setProductCount(0);
        Assertions.assertFalse(product.productAvailable());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 12.5})
    public void setProductPriceCurrentWorkTest(double price) {
        product.setProductPrice(price);
        Assertions.assertEquals(price, product.getProductPrice());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -25.2})
    public void setProductPriceWithNegativeValue(double price) {
        product.setProductPrice(price);
        Assertions.assertNotEquals(price, product.getProductPrice());
    }
}
