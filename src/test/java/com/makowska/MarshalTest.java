package com.makowska;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.makowska.Main.addItemsToInvoiceList;

public final class MarshalTest {
    @Test
    public void marshalingTest() throws JAXBException {
        ItemList list = new ItemList();
        InvoiceList invoiceList = new InvoiceList();
        Marshal.marshaling(list, invoiceList, "src/faktury-test-output-1.xml", "src/faktury-test-output-2.xml");
        Assert.assertEquals(0, list.getSize());
    }

    public static long filesCompareByLine(Path path1, Path path2) throws IOException {
        try (BufferedReader bf1 = Files.newBufferedReader(path1);
             BufferedReader bf2 = Files.newBufferedReader(path2)) {

            long lineNumber = 1;
            String line1 = "", line2 = "";
            for(int i=0; i<100; i++){
                line1 = bf1.readLine();
                line2 = bf2.readLine();
                if (line2 == null || !line1.equals(line2)) {
                    return lineNumber;
                }
                lineNumber++;
            }
            if (bf2.readLine() == null) {
                return -1;
            }
            else {
                return lineNumber;
            }
        }
    }
}