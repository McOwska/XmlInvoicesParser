package com.makowska;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Class is responsible for reading data from XLSX file.
 */
@SuppressWarnings("java:S106")
public class XlsxReader {
    /**
     * Method is responsible for reading CSV file to the given ItemList object.
     * @param list - ItemList object
     *                    to which the data from the CSV file will be added
     * @param path - path to the CSV file
     */
    public void readXlsxFile(String path, ItemList list) {
            try{
                try (FileInputStream file = new FileInputStream(new File(path))) {
                    XSSFWorkbook workbook = new XSSFWorkbook(file);
                    XSSFSheet sheet = workbook.getSheetAt(0);

                    Iterator<Row> rowIterator = sheet.iterator();
                    Row headerRow= rowIterator.next();

                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();

                        Iterator<Cell> cellIterator = row.cellIterator();
                        Cell[] tempRow = new Cell[15];
                        for (int i = 0; i < 15; i++) {
                            Cell cell = cellIterator.next();

                            tempRow[i] = cell;
                        }
                        list.add(new Item(tempRow));
                    }
                }

            } catch (IOException e) {
                Thread.currentThread().interrupt();
            }
        }
}
