package com.makowska;
import org.apache.poi.ss.usermodel.Cell;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Class representing an item.
 */
@SuppressWarnings("java:S106")
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @XmlTransient
    static String[] header;
    @XmlTransient
    static int counter = 0;
    private int id = 0;
    private String name;
    private String adress;
    private String NIP;
    private Date dateOfIssue;
    private Date dateOfSale;
    private String invoiceNumber;
    private String title;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private int taxRate;
    private BigDecimal taxAmount;
    private BigDecimal netPrice;
    private BigDecimal grossPrice;
    private BigDecimal netPriceSum;
    private BigDecimal grossPriceSum;

    /**
     * Constructor for Item class.
     */
    Item(){}
    Item(String[] newItem) throws ParseException {
        this.id = counter;
        counter++;
        this.name = newItem[0];
        this.adress = newItem[1];
        this.NIP = newItem[2];
        this.dateOfIssue = stringToDate(newItem[3]);
        this.dateOfSale = stringToDate(newItem[4]);
        this.invoiceNumber = newItem[5];
        this.title = newItem[6];

        this.quantity = BigDecimal.valueOf(Double.parseDouble(newItem[7].replace(',', '.')))
                .setScale(2, RoundingMode.HALF_UP);
        this.unitPrice = BigDecimal.valueOf(stringToPrice(newItem[8]))
                .setScale(2, RoundingMode.HALF_UP);
        this.taxRate = Integer.parseInt(newItem[9]);
        this.taxAmount = BigDecimal.valueOf(stringToPrice(newItem[10]))
                .setScale(2, RoundingMode.HALF_UP);
        this.netPrice = BigDecimal.valueOf(stringToPrice(newItem[11]))
                .setScale(2, RoundingMode.HALF_UP);
        this.grossPrice = BigDecimal.valueOf(stringToPrice(newItem[12]))
                .setScale(2, RoundingMode.HALF_UP);
        this.netPriceSum = BigDecimal.valueOf(stringToPrice(newItem[13]))
                .setScale(2, RoundingMode.HALF_UP);
        this.grossPriceSum = BigDecimal.valueOf(stringToPrice(newItem[14]))
                .setScale(2, RoundingMode.HALF_UP);
    }
    public Item(Cell [] newItem){
        this.id = counter;
        counter++;
        this.name = newItem[0].getStringCellValue();
        this.adress = newItem[1].getStringCellValue();
        this.NIP = newItem[2].getStringCellValue();
        this.dateOfIssue = newItem[3].getDateCellValue();
        this.dateOfSale = newItem[4].getDateCellValue();
        this.invoiceNumber = newItem[5].getStringCellValue();
        this.title = newItem[6].getStringCellValue();
        this.quantity = BigDecimal.valueOf(newItem[7].getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
        this.unitPrice = BigDecimal.valueOf(newItem[8].getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
        this.taxRate = (int) newItem[9].getNumericCellValue();
        this.taxAmount = BigDecimal.valueOf(newItem[10].getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
        this.netPrice = BigDecimal.valueOf(newItem[11].getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
        this.grossPrice = BigDecimal.valueOf(newItem[12].getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
        this.netPriceSum = BigDecimal.valueOf(newItem[13].getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
        this.grossPriceSum = BigDecimal.valueOf(newItem[14].getNumericCellValue()).setScale(2, RoundingMode.HALF_UP);
    }
    /**
     * Method for converting string to date.
     * @param str
     * @return date
     * @throws ParseException
     */
    public static Date stringToDate(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str);
    }

    /**
     * Method for converting string to double.
     * @param str
     * @return double
     */
    public static double stringToPrice(String str){
        str = str.replace(',', '.');
        StringBuilder newStr = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i)) || str.charAt(i) == '.'){
                newStr.append(str.charAt(i));
            }
        }
        return Double.parseDouble(newStr.toString());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = BigDecimal.valueOf(quantity).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = BigDecimal.valueOf(unitPrice).setScale(2, RoundingMode.HALF_UP);
    }

    public int getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = BigDecimal.valueOf(taxAmount).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = BigDecimal.valueOf(netPrice).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = BigDecimal.valueOf(grossPrice).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getNetPriceSum() {
        return  netPriceSum;
    }

    public void setNetPriceSum(double netPriceSum) {
        this.netPriceSum = BigDecimal.valueOf(netPriceSum).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getGrossPriceSum() {
        return grossPriceSum;
    }

    public void setGrossPriceSum(double grossPriceSum) {
        this.grossPriceSum = BigDecimal.valueOf(grossPriceSum).setScale(2, RoundingMode.HALF_UP);
    }
}
