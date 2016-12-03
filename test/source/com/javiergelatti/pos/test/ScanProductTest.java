package com.javiergelatti.pos.test;

import com.javiergelatti.pos.ItemCatalog;
import com.javiergelatti.pos.PointOfSale;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScanProductTest {
    @Test
    public void itemNotFound() throws Exception {
        PointOfSale pointOfSale = new PointOfSale(new ItemCatalog());

        pointOfSale.onBarcode("Not found");

        String shownText = pointOfSale.lastTextShown();
        assertEquals("Item not found", shownText);
    }

    @Test
    public void itemFound() throws Exception {
        ItemCatalog catalog = new ItemCatalog();
        catalog.addItem("123", 11.50);
        PointOfSale pointOfSale = new PointOfSale(catalog);

        pointOfSale.onBarcode("123");

        String shownText = pointOfSale.lastTextShown();
        assertEquals("$ 11.50", shownText);
    }
}
