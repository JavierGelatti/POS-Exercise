package com.javiergelatti.pos;

import java.util.Locale;

public class PointOfSale {

    private ItemCatalog catalog;
    private String lastTextShown;

    public PointOfSale(ItemCatalog catalog) {
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        lastTextShown = catalog.getItemPriceFor(barcode)
                .map(price -> String.format(Locale.US, "$ %.2f", price))
                .orElse("Item not found");
    }

    public String lastTextShown() {
        return lastTextShown;
    }
}
