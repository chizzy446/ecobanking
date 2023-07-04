package com.EcoBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


import com.EcoBanking.pageObjests.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void LoginTest() throws IOException
	{
	 logger.info("URL is opened");
	 
	 LoginPage lp=new LoginPage(driver);
	 
	 lp.SetUserName(username);
	 logger.info("Entered username");
	 
	 lp.Setpassword(password);
	 logger.info("Entered password");
	 
	 lp.clickSubmit();
	 
	 if(driver.getTitle().equals("guru99 Bank Manager HomePage"))
	 {
	   Assert.assertTrue(true);	 
	   logger.info("Login test passed");
	 }
	 else
	 {
		 captureScreen(driver,"LoginTest");
		 Assert.assertTrue(false);
		 logger.info("Login test failed");
		 }
	
	}
	
}
