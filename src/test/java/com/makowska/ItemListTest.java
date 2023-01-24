package com.makowska;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public final class ItemListTest {
    @Test
    public void constructorTest() {
        ItemList itemList = new ItemList();
        Assert.assertEquals(0, itemList.getSize());
    }

    @Test
    public void addTest() throws ParseException {
        ItemList itemList = new ItemList();
        String [] newItem1 = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};
        Item item = new Item(newItem1);

         itemList.add(item);
        Assert.assertEquals(1, itemList.getSize());
        Assert.assertEquals(itemList.itemByIndex(0), item);
    }

    @Test
    public void invoiceByIndexTest() throws ParseException {
        ItemList itemList = new ItemList();
        String [] newItem1 = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};
        Item item = new Item(newItem1);

        itemList.add(item);
        Assert.assertEquals(itemList.itemByIndex(0), item);
    }

}