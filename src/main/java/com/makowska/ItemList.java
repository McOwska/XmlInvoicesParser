package com.makowska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/**
 * Class respresent a list of items.
 */
@SuppressWarnings("java:S106")
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemList {
    @XmlElement(name = "item")
    private List<Item> list;

    public ItemList(){
        list = new ArrayList<>();
    }

    /**
     * Method adds item to the list.
     * @param item - object of Item class
     */
    public void add(Item item){
        list.add(item);
    }

    /**
     * Method returns number of elements in the list
     */
    public int getSize(){
        return list.size();
    }

    /**
     * Method allows access to the item by its index in the list.
     * @param i - invoice's index
     * @return invoice
     */
    public Item itemByIndex(int i){
        return list.get(i);
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
