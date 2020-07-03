package com.ecommerce.OnlineShopping.Exception;

import com.ecommerce.OnlineShopping.domain.Product;

public class OutOfStockException extends Exception{
    private static final String DEFAULT_MESSAGE = "Not enough products in stock";

    public OutOfStockException() {
        super(DEFAULT_MESSAGE);
    }

    public OutOfStockException (Product product) {
        super(String.format("Not enough %s products in stock.", product.getProdname()));
    }
}
