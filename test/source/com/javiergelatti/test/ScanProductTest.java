package com.javiergelatti.test;

import com.javiergelatti.pos.PointOfSale;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScanProductTest {
    @Test
    public void itemNotFound() throws Exception {
        PointOfSale pointOfSale = new PointOfSale();

        pointOfSale.onBarcode("Not found");

        String shownText = pointOfSale.lastTextShown();
        assertEquals("Item not found", shownText);
    }
}
