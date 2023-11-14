package com.revival.inventory.book.entities;

import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Getter
public class BookItem extends Book {

    private BigInteger quantity;

    @Builder
    public BookItem(BigInteger id, String title, BigInteger price, String imagePath, BigInteger quantity) {
        super(id, title, price, imagePath);
        this.quantity = quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }
}
