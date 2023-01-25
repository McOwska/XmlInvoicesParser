package com.makowska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import static java.lang.Math.abs;
import static org.apache.commons.math3.util.Precision.round;

/**
 * Class representing invoice with all its items.
 */
@XmlRootElement(name = "invoice")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice {

    private String name;
    private String adress;
    private String NIP;
    private Date dateOfIssue;
    private Date dateOfSale;
    private String invoiceNumber;
    private BigDecimal netPriceSum = new BigDecimal(0);
    private BigDecimal grossPriceSum = new BigDecimal(0);
    private ItemList itemList = new ItemList();

    Invoice(){}
    /**
     * Constructor.
     * @param item - first item to be added to the invoice
     */
    Invoice(Item item){
        this.name = item.getName();
        this.adress = item.getAdress();
        this.NIP = item.getNIP();
        this.dateOfIssue = item.getDateOfIssue();
        this.dateOfSale = item.getDateOfSale();
        this.invoiceNumber = item.getInvoiceNumber();
        this.itemList.add(item);
        this.netPriceSum = this.netPriceSum.add(item.getNetPrice());
        this.grossPriceSum = this.grossPriceSum.add(item.getGrossPrice());
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNetPriceSum() {
        return netPriceSum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getDateOfIssue() {
        return this.dateOfIssue;
    }

    public Date getDateOfSale() {
        return this.dateOfSale;
    }

    public BigDecimal getGrossPriceSum() {
        return this.grossPriceSum;
    }

    public void addItem(Item item) {
        this.itemList.add(item);
        this.netPriceSum = this.netPriceSum.add(item.getNetPrice());
        this.grossPriceSum = this.grossPriceSum.add(item.getGrossPrice());
    }
}
