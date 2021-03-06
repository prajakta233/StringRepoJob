package PragatiTraining.StringProject;

import org.testng.annotations.DataProvider;
//import org.testng.annotations.Optional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;

public class StringConcatData {


	Concatination ca;
	String Result;
	String s1="Prajakta";
	String s2="Phadatare";
	
	@BeforeGroups("RegressionTest")
	public void InitGroup() {
		System.out.println("I am in Before Group");
		 ca=new Concatination();
		
	}
	
	@BeforeClass
	public void Init() {
		 System.out.println("I am in Before class");
		 ca=new Concatination();
		
	}
	
	@BeforeMethod
	public void ReinitialiseResultVar() {
		System.out.println("I am in Before Method");
		
	}
		

	@Test(priority=1, dataProvider="ProvidePositiveStringValues" ,groups= {"RegressionTest"})
	
	public void TestConcatinationWithPositiveValues(String s1,String s2,String ExceptedResult) {
		Result=ca.Concatination(s1,s2);
		Assert.assertEquals(Result, ExceptedResult,"Multiplication does not work with positive values");
		
		
	}
	
	@DataProvider
	public Object[][] ProvidePositiveStringValues() {

        
		Object[][] SetOfValues=new Object[3][3];
		//This is SET 1
		SetOfValues[0][0]="Hello";
		SetOfValues[0][1]="I am Prajakta";
		SetOfValues[0][2]="Hello I am Prajakta";
		
		//This is SET 2
		SetOfValues[1][0]="Recentely Joined";
		SetOfValues[1][1]="In QK";
		SetOfValues[1][2]="Recentely Joined In QK";
		
		//This is SET 3
		SetOfValues[2][0]="Recently Pragati taining started";
		SetOfValues[2][1]="Today is Assessment on uni testing";
		SetOfValues[2][2]="Recently Pragati taining started Today is Assessment on uni testing";
		

		return SetOfValues;
			
	}
	
	
	  @AfterClass
	     public void Teardown() {
	    	 System.out.println("I am in After Class");
	    	 ca=null;
	    	 
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
				
			Files.copy(Paths.get("C:\\Users\\ASUS\\CalculatorAPI\\StringConcatination\\test-output\\emailable-report.html"), Paths.get("./"+RequestName+"/Result.html"), StandardCopyOption.REPLACE_EXISTING);
			}
			catch(IOException ex) {
				System.out.println("Problem occuring during process");
			}
			
		}
		
}

	

