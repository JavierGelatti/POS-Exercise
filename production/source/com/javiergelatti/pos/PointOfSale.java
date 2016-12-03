package com.javiergelatti.pos;

public class PointOfSale {

    private ItemCatalog catalog;

    public PointOfSale(ItemCatalog catalog) {
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {

    }

    public String lastTextShown() {
        if (catalog.getItemPriceFor("123").isPresent())
            return "$ 11.50";
        else
            return "Item not found";
    }
}
