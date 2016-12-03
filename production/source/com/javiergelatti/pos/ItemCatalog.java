package com.javiergelatti.pos;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemCatalog {
    private Map<String, Double> prices = new HashMap<>();

    public void addItem(String barcode, double price) {
        prices.put(barcode, price);
    }

    public Optional<Double> getItemPriceFor(String barcode) {
        return Optional.ofNullable(prices.get(barcode));
    }
}
