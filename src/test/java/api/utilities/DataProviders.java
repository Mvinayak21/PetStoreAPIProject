package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws Exception
	{
		String path = System.getProperty("user.dir")+"//TestData//UserData1.xlsx";
		XLUtility xlutility = new XLUtility(path);
		
		int rownum = xlutility.getRowCount("Sheet1");
		int colCount = xlutility.getCellCount("Sheet1",rownum);
		
		String apiData[][]=new String[rownum][colCount];
		
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				apiData[i-1][j]=xlutility.getCellData("Sheet1",i,j);
			}
		}
		
		//System.out.println(apiData);
		return apiData;
		
	}
	
	@DataProvider(name="userName")
	public String[] getUserNames() throws Exception
	{
		String path = System.getProperty("user.dir")+"//TestData//Userdata1.xlsx";
		XLUtility xlutility = new XLUtility(path);
		
		int rownum = xlutility.getRowCount("Sheet1");
		//int colCount = xlutility.getCellCount("Sheet1",rownum);
		
		String apiData[] = new String[rownum];
		
		
		for(int k=1;k<rownum;k++)
		{
			apiData[k-1]=xlutility.getCellData("Sheet1",k,1);
		}
		
		return apiData;
	}

}
