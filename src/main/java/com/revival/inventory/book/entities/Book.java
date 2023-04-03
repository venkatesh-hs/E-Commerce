package com.revival.inventory.book.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;

@Data
@Entity
@Table(name = "_book")
public class Book {

    @Id
    @GeneratedValue
    private BigInteger id;

    private String name;

    private BigInteger price;

    private String image;

}
