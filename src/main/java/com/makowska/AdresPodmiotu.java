package com.makowska;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "tns:AdresPodmiotu")

public class AdresPodmiotu {
    @XmlElement(name = "tns:KodKraju")
    private static String KodKraju = "PL";
    @XmlElement(name = "tns:Wojewodztwo")
    private static String Wojewodztwo = "małopolskie";
    @XmlElement(name = "tns:Powiat")
    private static String Powiat = "m. Krakow";
    @XmlElement(name = "tns:Gmina")
    private static String Gmina = "Kraków";
    @XmlElement(name = "tns:Ulica")
    private static String Ulica = "ul. Feliksa Radwańskiego";
    @XmlElement(name = "tns:NrDomu")
    private static int NrDomu = 15;
    @XmlElement(name = "tns:NrLokalu")
    private static int NrLokalu = 1;
    @XmlElement(name = "tns:Miejscowosc")
    private static String Miejscowosc = "Kraków";
    @XmlElement(name = "tns:KodPocztowy")
    private static String KodPocztowy = "30-065";

    public static String getAdress(){
        return Ulica + " " + NrDomu + "/" + NrLokalu + ", " + KodPocztowy + " " + Miejscowosc;
    }

}


