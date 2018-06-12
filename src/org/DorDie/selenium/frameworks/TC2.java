package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 
{
	
	@Test(priority=2,dependsOnMethods="tc2")
	public void tc1()
	{
		System.out.println("TC1 starts");
	}
	
	@Test(priority=1)
	public void tc2()
	{
		System.out.println("TC2 starts");
		Assert.fail();
	}

}
