package isun.service;


import isun.banking.entity.BankAccount;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    private static final String FILE_NAME = "../MyFirstExcel.xlsx";

//    public static void main(String[] args) {


    public void save(BankAccount ba) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(FILE_NAME));

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Object[] datatypes = {String.valueOf(ba.getNumber()), ba.getOwner(), String.valueOf(ba.getBalance())};
        int lastRow  = sheet.getPhysicalNumberOfRows();
        Row row = sheet.createRow(lastRow++);
        int colNum = 0;
        for (Object field : datatypes) {
            Cell cell = row.createCell(colNum++);
            if (field instanceof String) {
                cell.setCellValue((String) field);
            } else if (field instanceof Integer) {
                cell.setCellValue((Integer) field);
            }
        }


        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Done");

    }
}


