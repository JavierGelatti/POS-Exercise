package com.javiergelatti.pos;

import java.util.Locale;

public class PointOfSale {

    private ItemCatalog catalog;
    private Display display;

    public PointOfSale(ItemCatalog catalog, Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.showText("Scanning error: empty barcode");
        } else {
            display.showText(catalog.getItemPriceFor(barcode)
                    .map(price -> String.format(Locale.US, "$ %.2f", price))
                    .orElse("Item not found for code " + barcode));
        }
    }

}
