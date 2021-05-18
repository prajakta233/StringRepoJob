package PragatiTraining.StringProject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class StringConcat {

	Concatination ca;
	String Result;
	//String s1="Prajakta";
	//String s2="Phadatare";
	

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
		
	@Test(priority=1 , groups= {"RegressionTest"})
	public void TestConcatinationWithTwoString() {
		String Result=ca.Concatination("Prajakta","Phadatare");
		Assert.assertEquals(Result, "Prajakta Phadatare","String concatination  does not work with two string");
		
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
		
		public void CopyResultFile(String StringName) {
			try {
				
			Files.copy(Paths.get("C:\\Users\\ASUS\\CalculatorAPI\\StringConcatination\\test-output\\emailable-report.html"), Paths.get("./"+StringName+"/Result.html"), StandardCopyOption.REPLACE_EXISTING);
			}
			catch(IOException ex) {
				System.out.println("Problem occuring during process");
			}
			
		}
}


