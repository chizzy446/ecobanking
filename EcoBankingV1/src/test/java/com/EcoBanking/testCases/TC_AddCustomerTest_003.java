package com.EcoBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.EcoBanking.pageObjests.AddCustomerPage;
import com.EcoBanking.pageObjests.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.SetUserName(username);
		logger.info("user name is provided");
		lp.SetPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		//this are the data
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details...");
		addcust.custName("Chizzy");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1990"); //Since it take a lot of time to input the data here, i passed Thread.sleep(3000) below so that it will make it to be fast 
		Thread.sleep(3000);
		addcust.custaddress("Paderborn");
		addcust.custcity("Paderborn");
		addcust.custstate("NRW");
		addcust.custpinno("2345789");
		addcust.custtelephoneno("336889066");
		
		String email=randomeString()+"gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("dgdghd");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		//To validate if the page are present or no
		
		logger.info("validation started...");
		
		boolean res=driver.getPageSource().contains("Customer Registration Successfully!!!"); // this return true or false
        if(res==true)
        {
        	Assert.assertTrue(true);
        	logger.info("test case passed...");
        }
        else
        {
        	captureScreen(driver,"addNewCustomer");
        	Assert.assertTrue(false);
        	logger.info("test case failed...");
        }
	}	
	
}
