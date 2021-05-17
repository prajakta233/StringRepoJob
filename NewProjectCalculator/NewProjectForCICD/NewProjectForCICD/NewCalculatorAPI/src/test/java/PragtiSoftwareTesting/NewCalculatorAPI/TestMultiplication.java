package PragtiSoftwareTesting.NewCalculatorAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;


public class TestMultiplication {
	
	
	CalculatorAPI cal;
	int Result;
	
	@BeforeClass
	public void Init()
	{
		cal=new CalculatorAPI();
	}
	
	@BeforeMethod
	public void ReinitializeResult() {
		Result=0;		
	}
	
	@Test(priority=1, dataProvider="ProvidePositiveIntegerValues" ,groups= {"RegressionTest"})
	
	public void TestMultiplicationWithPositiveValues(int number1, int number2, int ExceptedResult) {
		Result=cal.Multilication(number1,number2);
		Assert.assertEquals(Result, ExceptedResult,"Multiplication does not work with positive values");
		
		
	}
	
	@DataProvider
	public Object[][] ProvidePositiveIntegerValues() {

        
		Object[][] SetOfValues=new Object[4][3];
		//This is SET 1
		SetOfValues[0][0]=1;
		SetOfValues[0][1]=2;
		SetOfValues[0][2]=2;
		
		//This is SET 2
		SetOfValues[1][0]=3;
		SetOfValues[1][1]=4;
		SetOfValues[1][2]=12;
		
		//This is SET 3
		SetOfValues[2][0]=5;
		SetOfValues[2][1]=6;
		SetOfValues[2][2]=30;
		
		//This is SET 4
		SetOfValues[3][0]=2;
		SetOfValues[3][1]=5;
		SetOfValues[3][2]=10;
		
		return SetOfValues;
			
	}
	
	@BeforeSuite
	@Parameters({"RequestID"})
	public void CreateResultFolder(String RequestID) {
		try {
			System.out.println("In Before Suite");
		    Files.createDirectory(Paths.get("./"+RequestID));
		}
		catch(IOException ex) {
			System.out.println("Problem in craeting reasult Directory");
		}
	}
	
	@Parameters({"RequestID"})
	@AfterSuite
	
	public void CopyResultFile(String RequestName) {
		try {
			
		Files.copy(Paths.get("C:\\Users\\ASUS\\CalculatorAPI\\CalculatorAPI\\target\\surefire-reports\\emailable-report.html"), Paths.get("./"+RequestName+"/Result.html"), StandardCopyOption.REPLACE_EXISTING);
		}
		catch(IOException ex) {
			System.out.println("Problem occuring during process");
		}
		
	}
	

}
