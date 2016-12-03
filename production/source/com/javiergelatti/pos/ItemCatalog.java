package com.javiergelatti.pos;

import java.util.Optional;

public class ItemCatalog {
    private String barcode;
    private double price = -1;

    public void addItem(String barcode, double price) {
        this.barcode = barcode;
        this.price = price;
    }

    public Optional<Double> getItemPriceFor(String barcode) {
        return price == -1 ? Optional.empty() : Optional.of(price);
    }
}
