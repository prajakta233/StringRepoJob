package PragtiSoftwareTesting.NewCalculatorAPI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class AdditionTestCases {
	
	CalculatorAPI obj;
	int Result;
	
	@BeforeGroups("RegressionTest")
	public void InitGroup() {
		System.out.println("I am in Before Group");
		 obj=new CalculatorAPI();
		
	}
	
	@BeforeClass
	public void Init() {
		 System.out.println("I am in Before class");
		 obj=new CalculatorAPI();
		
	}
	@BeforeMethod
	public void ReinitialiseResultVar() {
		System.out.println("I am in Before Method");
		Result=0;
	}
	
	@Test(priority=2 ,groups= {"RegressionTest"})
	public void TestAdditionWithPositiveNumbers() {
		
		System.out.println("I am in 2nd Testcase");
		int Result=obj.Addition(10,20);
		Assert.assertEquals(Result, 30, "Addition does not work with positive numbers");
					
	}
	@Test(priority=1 ,groups= {"RegressionTest"})
     public void TestAdditionWithNegativeNumbers() {
		System.out.println("I am in 1st testcase");
		//Calculator obj=new Calculator();
	    Result=obj.Addition(-10,-20);
		Assert.assertEquals(Result,-30,"Addition does not work with negative numbers");
			
	}
     @Test(priority=4)
     public void TestAdditionWithZeroNumbers() {
    	 System.out.println("I am in 4th testcase");
    	 //Calculator obj=new Calculator();
 		 Result=obj.Addition(0,0);
 		 Assert.assertEquals(Result,0,"Addition does not work with zero numbers ");
 		
   	 }
     @Test(priority=3)
     public void TestAdditionWithPositiveOneNegative()
     {
    	 System.out.println("I am in 3rd testcase");
    	// Calculator obj=new Calculator();
    	 Result=obj.Addition(10, -8);
    	 Assert.assertEquals(Result,2,"Addition does not work with zero numbers ");
  	   	 
     }
     @AfterClass
     public void Teardown() {
    	 System.out.println("I am in After Class");
    	 obj=null;
    	 
     }

	

}
