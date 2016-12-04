package com.javiergelatti.pos.test;

import com.javiergelatti.pos.Display;
import com.javiergelatti.pos.ItemCatalog;
import com.javiergelatti.pos.PointOfSale;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SellOneItemTest implements Display {

    private final ItemCatalog catalog = new ItemCatalog();
    private final Display display = this;
    private final PointOfSale pointOfSale = new PointOfSale(catalog, display);

    private String lastTextShown;

    @Test
    public void itemNotFound() throws Exception {
        pointOfSale.onBarcode("123");

        assertEquals("Item not found for code 123", lastTextShown);
    }

    @Test
    public void itemFound() throws Exception {
        catalog.addItem("123", 11.50);

        pointOfSale.onBarcode("123");

        assertEquals("$ 11.50", lastTextShown);
    }

    @Test
    public void manyItems() throws Exception {
        catalog.addItem("124", 25.30);
        catalog.addItem("123", 11.50);

        pointOfSale.onBarcode("124");

        assertEquals("$ 25.30", lastTextShown);
    }

    @Test
    public void emtpyBarcode() throws Exception {
        pointOfSale.onBarcode("");

        assertEquals("Scanning error: empty barcode", lastTextShown);
    }

    @Test
    public void blankBarcode() throws Exception {
        pointOfSale.onBarcode(" \n \t ");

        assertEquals("Scanning error: empty barcode", lastTextShown);
    }

    @Override
    public void showText(String text) {
        lastTextShown = text;
    }
}
