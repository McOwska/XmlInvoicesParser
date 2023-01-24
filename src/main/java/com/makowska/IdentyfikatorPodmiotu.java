package com.makowska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "tns:Podmiot1")
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentyfikatorPodmiotu {
    @XmlElement(name = "etd:NIP")
    public static String NIP = "6762484560";
    @XmlElement(name = "etd:PelnaNazwa")
    public static String PelnaNazwa = "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
}
