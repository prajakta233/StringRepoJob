package PragtiSoftwareTesting.NewCalculatorAPI;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestingSubstractionTestCases {
	CalculatorAPI cal;
	int Result;
	
	@BeforeClass
	public void Init() {
		cal=new CalculatorAPI();
		
	}
	@BeforeMethod
	public void ReInitialise() {
		Result=0;		
	}
	@Test(priority=1 ,groups= {"RegressionTest"})

	public void TestingSubstractionWithPositiveNumber() {
		int Result=cal.Substraction(30,20);
		Assert.assertEquals(Result,10,"Substration does not work with positive numbers");
	}
	
	@Test(priority=2)
	
	public void TestingSubstractionWithOnePositiveNumber() {
		int Result=cal.Substraction(30,-20);
		Assert.assertEquals(Result,50,"Substration does not work with one positive numbers");
	}
	@AfterClass

	public void Teardown() {
		cal=null;
	}

}
