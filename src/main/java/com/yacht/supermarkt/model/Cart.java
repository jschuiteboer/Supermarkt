package com.yacht.supermarkt.model;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private List<Product> contents;
}
