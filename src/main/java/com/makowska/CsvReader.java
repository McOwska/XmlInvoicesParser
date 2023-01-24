package com.makowska;

import java.io.BufferedReader;
import java.io.FileReader;




/**
 * Class responsible for reading data from CSV file.
 */

@SuppressWarnings("java:S106")
public class CsvReader {
    CsvReader() {
    }

    /**
     * Method is responsible for reading CSV file to the given ItemList object.
     * @param list - ItemList object
     *                    to which the data from the CSV file will be added
     * @param path - path to the CSV file
     */
    public static void readCsvFile(String path, ItemList list) {
        BufferedReader reader = null;
        String line = "";
        try{
            reader = new BufferedReader(new FileReader(path));

            while((line = reader.readLine()) != null){
                if(Item.counter == 0){
                    Item.header = line.split("\t");
                    Item.counter++;
                }else{
                    String[] item = line.split("\t");
                    if(item.length == 15){
                        list.add(new Item(item));
                    }
                }

            }

        }
        catch(Exception e){
            Thread.currentThread().interrupt();
        }
        finally {
            try{
                if (reader != null) {
                    reader.close();
                }
            }
            catch(Exception e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
