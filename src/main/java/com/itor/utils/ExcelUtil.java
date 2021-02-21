package com.itor.utils;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

public class ExcelUtil {

    private static Workbook wb = null;

    public static void export(List<?> data, String dstPath) {
        System.out.println(data);
        Workbook wb = new XSSFWorkbook();

        File parent = new File(dstPath);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        File file = new File(parent, "workbook.xlsx");
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (OutputStream fileOut = new FileOutputStream(file)) {
            fill(data, wb, "sheet");
            wb.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fill(List<?> data, Workbook wb, String sheetName) {
        //        String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]");
        String safeName = WorkbookUtil.createSafeSheetName("sheetName");
        Sheet sheet = wb.createSheet(safeName);

        Row head = sheet.createRow(0);

        CreationHelper createHelper = wb.getCreationHelper();

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/mm/dd hh:mm:ss"));

        for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
            Row row = sheet.createRow(rowIndex + 1);
            Object o = data.get(rowIndex);
            Class<?> aClass = o.getClass();
            System.out.println(aClass);
            Field[] declaredFields = aClass.getDeclaredFields();
            for (int cellIndex = 0; cellIndex < declaredFields.length; cellIndex++) {
                Cell cell = row.createCell(cellIndex);
                Field field = declaredFields[cellIndex];
                field.setAccessible(true);
                Class<?> type = field.getType();
                String name = field.getName();
                if (rowIndex == 0) {
                    Cell headCell = head.createCell(cellIndex);
                    headCell.setCellValue(name);
                }
                try {
                    Object value = field.get(o);
                    if (type == String.class) {
                        cell.setCellValue(createHelper.createRichTextString((String) value));
                    }
                    if (type == Integer.class) {
                        cell.setCellValue(Integer.valueOf(String.valueOf(value)));
                    }
                    if (type == Long.class) {
                        cell.setCellValue(Double.valueOf(String.valueOf(value)));
                    }
                    if (type == Date.class) {
                        cell.setCellValue((Date) value);
                        cell.setCellStyle(cellStyle);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
