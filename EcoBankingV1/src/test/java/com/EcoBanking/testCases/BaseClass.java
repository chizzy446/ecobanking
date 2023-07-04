package com.EcoBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import com.EcoBanking.utilities.ReadConfig;



public class BaseClass {

	static ReadConfig readconfig=new ReadConfig();
	
	public static String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public static void setup(String br)
	{
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties.jar");
		
		if(br.equals("chrome"))
		{
		System.setProperty("WebDriver.chrome.driver",readconfig.getChromepath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
		System.setProperty("WebDriver.gecko.driver",readconfig.getFirefoxpath());
		driver=new FirefoxDriver();
		}	
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterClass
	public static void tearDown()
	{
	    driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/"+tname+"png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
			
	}
	
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public String randomeNum()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}
}