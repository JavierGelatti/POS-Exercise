package com.javiergelatti.pos.test;

import com.javiergelatti.pos.Display;
import com.javiergelatti.pos.ItemCatalog;
import com.javiergelatti.pos.PointOfSale;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScanProductTest implements Display {

    private final ItemCatalog catalog = new ItemCatalog();
    private final Display display = this;
    private final PointOfSale pointOfSale = new PointOfSale(catalog, display);

    private String lastTextShown;

    @Test
    public void itemNotFound() throws Exception {
        pointOfSale.onBarcode("Not found");

        assertEquals("Item not found", shownText());
    }

    @Test
    public void itemFound() throws Exception {
        catalog.addItem("123", 11.50);

        pointOfSale.onBarcode("123");

        assertEquals("$ 11.50", shownText());
    }

    @Test
    public void manyItems() throws Exception {
        catalog.addItem("123", 11.50);
        catalog.addItem("124", 25.30);

        pointOfSale.onBarcode("123");

        assertEquals("$ 11.50", shownText());
    }

    private String shownText() {
        return lastTextShown;
    }

    @Override
    public void showText(String text) {
        lastTextShown = text;
    }
}
