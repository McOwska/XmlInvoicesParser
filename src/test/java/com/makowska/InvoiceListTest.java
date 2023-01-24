package com.makowska;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public final class InvoiceListTest {
    @Test
    public void constructorTest() {
        InvoiceList invoiceList = new InvoiceList();
        assertEquals(0, invoiceList.getSize());
    }

    @Test
    public void addTest() {
        InvoiceList invoiceList = new InvoiceList();
        Invoice invoice = new Invoice();
        invoiceList.add(invoice);
        assertEquals(1, invoiceList.getSize());
        assertEquals(invoiceList.invoiceByIndex(0), invoice);
    }

    @Test
    public void invoiceByIndexTest() {
        InvoiceList invoiceList = new InvoiceList();
        Invoice invoice = new Invoice();
        invoiceList.add(invoice);
        assertEquals(invoiceList.invoiceByIndex(0), invoice);
    }

    @Test
    public void checkIfInvoiceExistsExpectedTrue() throws ParseException {
        String [] newItem = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};
        Item item = new Item(newItem);
        InvoiceList invoiceList = new InvoiceList();
        Invoice invoice = new Invoice(item);
        invoiceList.add(invoice);
        assertTrue(invoiceList.checkIfInvoiceExists(item.getInvoiceNumber()));
    }

    @Test
    public void checkIfInvoiceExistsExpectedFalse() throws ParseException {
        String [] newItem1 = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};
        Item item = new Item(newItem1);

        String [] newItem2 = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber2", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł",  "800,00 zł", "800,00 zł"};
        Item item2 = new Item(newItem2);

        InvoiceList invoiceList = new InvoiceList();
        Invoice invoice = new Invoice(item);
        invoiceList.add(invoice);
        assertFalse(invoiceList.checkIfInvoiceExists(item2.getInvoiceNumber()));
    }

    @Test
    public void addItemTest() throws ParseException {
        String [] newItem1 = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};
        Item item = new Item(newItem1);

        String [] newItem2 = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber2", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};
        Item item2 = new Item(newItem2);

        InvoiceList invoiceList = new InvoiceList();
        Invoice invoice = new Invoice(item);
        invoiceList.add(invoice);
        invoiceList.addItem(item2);
        assertEquals(2, invoiceList.getSize());
    }

    @Test
    public void addItemTest2() throws ParseException {
        String [] newItem1 = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};
        Item item = new Item(newItem1);

        String [] newItem2 = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};

        Item item2 = new Item(newItem2);
        InvoiceList invoiceList = new InvoiceList();
        Invoice invoice = new Invoice(item);
        invoiceList.add(invoice);
        invoiceList.addItem(item2);
        assertEquals(1, invoiceList.getSize());
    }



}