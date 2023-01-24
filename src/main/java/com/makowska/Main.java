//mvn clean verify sonar:sonar -Dsonar.projectKey=XmlGenerator -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_cbe80eb3944111bff1ab97c3f9d4776feb185eba
//mvn clean verify sonar:sonar -Dsonar.projectKey=XMLParser -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_14a40e0c11128146ab3835d9feef4555c825693b

package com.makowska;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("java:S106")
public class Main {

    public static void main(String [] args) throws JAXBException, IOException {


        ItemList allItems = new ItemList();
        InvoiceList allInvoices = new InvoiceList();
        CsvReader csvReader = new CsvReader();
        csvReader.readCsvFile("src/faktury-sprzedazowe-test-short-2023.csv", allItems);
        System.out.println("Number of items: " + allItems.getSize());
        InvoiceList invoiceList = new InvoiceList();
        addItemsToInvoiceList(allItems, invoiceList);
        System.out.println("Number of invoices: " + invoiceList.getSize());

        FakturaWierszList fakturaWierszList = new FakturaWierszList();
        for (Item item : allItems.getList()) {
            fakturaWierszList.addItem(new FakturaWiersz(item));
        }
        System.out.println("Number of items: " + FakturaWiersz.number);
        System.out.println("Length of list: " + fakturaWierszList.list.size());

        ArrayList<Faktura> fakturaList = new ArrayList<>();
        for (Invoice invoice : invoiceList.getList()) {
            fakturaList.add(new Faktura(invoice));
        }

        Podmiot podmiot1 = new Podmiot();
        Naglowek naglowek = new Naglowek();
        Output output = new Output(fakturaWierszList, podmiot1, naglowek, fakturaList);


        Marshal.marshalingOutput("src/OUT.xml", output);

    }

    /**
     * Method responsible for adding all given items to the invoice list.
     * @param allItems
     * @param allInvoices
     */
    public static void addItemsToInvoiceList(ItemList allItems, InvoiceList allInvoices){
        for(int i = 0; i< allItems.getSize(); i++){
            allInvoices.addItem(allItems.itemByIndex(i));
        }
    }

    public static void addItemsToFakturaWierszList(ItemList allItems, FakturaWierszList allFakturaWiersz){
        for(int i = 0; i< allItems.getSize(); i++){
            allFakturaWiersz.addItem(new FakturaWiersz(allItems.itemByIndex(i)));
        }
    }

}
