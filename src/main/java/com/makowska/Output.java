package com.makowska;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "tns:JPK")
@XmlAccessorType(XmlAccessType.FIELD)
public class Output {
    @XmlAttribute(name = "xmlns:tns")
    private String xmlns = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/";
    @XmlAttribute(name = "xmlns:xsi")
    private String xmlns2 = "http://www.w3.org/2001/XMLSchema-instance";
    @XmlAttribute(name = "xmlns:etd")
    private String xmlns3 = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/";
    @XmlAttribute(name = "xmlns:xsd")
    private String xmlns4 = "http://www.w3.org/2001/XMLSchema";
    @XmlAttribute(name = "xmlns:msxsl")
    private String xmlns5 = "urn:schemas-microsoft-com:xslt";
    @XmlAttribute(name = "xsi:usr")
    private String xsi = "urn:the-xml-files:xslt";
    @XmlAttribute(name = "xsi:schemaLocation")
    private String xsi2 = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/ https://www.gov.pl/attachment/1abeab45-4e71-4616-b8d5-6b71699e86f8";

    @XmlElement(name = "tns:Naglowek")
    Naglowek Naglowek = new Naglowek();

    @XmlElement(name = "tns:Podmiot1")
    Podmiot Podmiot1 = new Podmiot();

    @XmlElement(name = "tns:Faktura")
    ArrayList<Faktura> Faktury = new ArrayList<>();
    @XmlElement(name = "tns:FakturaCtrl")
    FakturaCtrl FakturaCtrl = new FakturaCtrl();

    @XmlElement(name = "tns:FakturaWiersz")
    ArrayList<FakturaWiersz> FakturaWiersz = new ArrayList<>();
    @XmlElement(name = "tns:FakturaWierszCtrl")
    FakturaWierszCtrl FakturaWierszCtrl = new FakturaWierszCtrl();
    public Output() {
    }
    Output(FakturaWierszList FakturaWierszList, Podmiot Podmiot1, Naglowek Naglowek, ArrayList<Faktura> Faktury) {

        this.Podmiot1 = Podmiot1;
        this.Naglowek = Naglowek;
        this.FakturaWierszCtrl = new FakturaWierszCtrl();
        for(int i = 0; i < FakturaWierszList.list.size(); i++){
            FakturaWiersz.add(FakturaWierszList.list.get(i));
        }
        this.Faktury = Faktury;
    }
}
