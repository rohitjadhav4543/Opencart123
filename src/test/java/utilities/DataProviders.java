package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Excel_Demo_opencart.xlsx" ;	//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);	// creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String [totalrows][totalcols];	//created two dimentional array which can store xl data
	
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);	//1,0
			}
			
		}
	return	loginData;	//returning two dimentional array 
	
	}
	//	DataProvider 2
	
	//	DataProvider 3
	
	//	DataProvider 4
	
	//remember data provider methods should be in same class
	
	
	
	
	
	
	
	
	
	
	
}
