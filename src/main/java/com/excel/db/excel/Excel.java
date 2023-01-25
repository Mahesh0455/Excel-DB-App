package com.excel.db.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excel.db.database.DbConnection;

import java.util.ArrayList;
import java.util.Iterator;


public class Excel {
	

	public void getCount() throws IOException, SQLException {
		
		File file=new File("C:\\Users\\MPawar\\Desktop\\mahesh\\learnings\\java\\git_projects\\Excel-DB-App\\files","table_data.xlsx");
		
		FileInputStream fis=new FileInputStream(file);
		//FileOutputStream fos=new FileOutputStream(file);
		
		DbConnection dbcon=new DbConnection();
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheetAt(0);
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		if (sheet!=null && sheet.getSheetName().equalsIgnoreCase("Table_Data")) {
			
			Iterator<Row> rowIterator = sheet.rowIterator();
			
			while(rowIterator.hasNext()) {
				Row row=rowIterator.next();
				Iterator<Cell> cellIterator=row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell=(Cell) cellIterator.next();
					if(cell.getRowIndex()==0) {
						continue;
					}else {
						String tablename=cell.getStringCellValue();
						
						int count=dbcon.getRowCount(tablename);
						
						System.out.println(tablename+"> "+	count);
						
						//list.add(count);
						
						
					}
					
					
					
					
				}
				System.out.println("");
				}
			}
		
		}
		
		
		
	}


