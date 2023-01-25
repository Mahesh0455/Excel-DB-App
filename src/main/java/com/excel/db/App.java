package com.excel.db;

import java.io.IOException;
import java.sql.SQLException;

import com.excel.db.excel.Excel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException
    {
    	
    	Excel excel=new Excel();
    	excel.getCount();
    	
    	//System.out.println("Hello World");
        
    }
}
