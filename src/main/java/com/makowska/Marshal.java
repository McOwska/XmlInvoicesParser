package com.makowska;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Class responsible for marshalling list of instances of Item class to the XML file.
 */
@SuppressWarnings("java:S106")
public class Marshal {
    Marshal() {
    }
    /**
     * Method responsible for marshalling given ItemList object to XML file.
     * @throws JAXBException
     */
    public static void marshaling(ItemList itemList, InvoiceList invoiceList, String filePath1, String filePath2) throws JAXBException {

        JAXBContext jaxbContexInvoices = JAXBContext.newInstance(InvoiceList.class);
        Marshaller jaxbMarshallerInvoices = jaxbContexInvoices.createMarshaller();
        jaxbMarshallerInvoices.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshallerInvoices.marshal(invoiceList, new File(filePath1));

        JAXBContext jaxbContexItems = JAXBContext.newInstance(ItemList.class);
        Marshaller jaxbMarshallerItems = jaxbContexItems.createMarshaller();
        jaxbMarshallerItems.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshallerItems.marshal(itemList, new File(filePath2));

    }

    public static void marshalingOutput(String outputPath, Output output) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Output.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(output, new File(outputPath));

    }
}
