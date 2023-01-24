package com.makowska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing list of invoices.
 */
@XmlRootElement(name = "invoices")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceList {
    @XmlElement(name = "invoice")
    private List<Invoice> list;

    public InvoiceList(){
        list = new ArrayList<>();
    }

    /**
     * Method is responsible for adding invoice to the list.
     * @param invoice
     */
    public void add(Invoice invoice){
        list.add(invoice);
    }

    public int getSize(){
        return list.size();
    }

    /**
     * Method is responsible for getting invoice from the list.
     * @param i - index of the invoice
     */
    public Invoice invoiceByIndex(int i){
        return list.get(i);
    }

    /**
     * Method is responsible for checking if given (with its number) invoice exists in the list.
     * @param invoiceNumber
     * @return
     */
    public boolean checkIfInvoiceExists(String invoiceNumber){
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getInvoiceNumber().equals(invoiceNumber)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method is responsible for adding single item to the list od invoices (checks if appropriate invoice exists)., if not creates a new one
     * @param item
     */
    public void addItem(Item item){
        if(checkIfInvoiceExists(item.getInvoiceNumber())){
            for (int i = 0; i < list.size(); i++){
                if(list.get(i).getInvoiceNumber().equals(item.getInvoiceNumber())){
                    list.get(i).addItem(item);
                }
            }
        } else {
            Invoice invoice = new Invoice(item);
            list.add(invoice);
        }
    }

    public Invoice[] getList() {
        return list.toArray(new Invoice[list.size()]);
    }
}
