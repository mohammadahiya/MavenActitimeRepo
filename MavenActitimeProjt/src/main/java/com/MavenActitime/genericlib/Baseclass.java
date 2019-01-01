package com.MavenActitime.genericlib;

import java.io.File;

import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.MavenActitime.objrepository.Login;
import com.MavenActitime.objrepository.Home;

public class Baseclass {
	public static WebDriver driver;
	public Filelib flib=new Filelib();
@BeforeSuite
public void ConfigBS()
{
	System.out.println("Launch the suite");
}
@BeforeClass
public void ConfigBC() throws Throwable 
{
System.out.println("Launch the browser");
Properties pobj=flib.getpropertyobject();
String Browsername=pobj.getProperty("browser");
if(Browsername.equals("firefox"))
{
driver=new FirefoxDriver();	
}
else if(Browsername.equals("chrome"))
{
System.setProperty("WebDriver.chrome.driver", "/MavenActitimeProjt/src/main/resources/chromedriver.exe");
driver=new ChromeDriver();
}
else if(Browsername.equals("ie"))
{
System.setProperty("WebDriver.ie.driver", "/MavenActitimeProjt/src/main/resources/IEDriverServer.exe");
driver=new InternetExplorerDriver();
}

}
@BeforeMethod
public void ConfigBM() throws Throwable
{
	System.out.println("Login");
	Properties pobj=flib.getpropertyobject();
	driver.get(pobj.getProperty("url"));
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	Login lp=PageFactory.initElements(driver, Login.class);
	lp.logintoapp(pobj.getProperty("username"), pobj.getProperty("password"));
	
}
@AfterMethod
public void ConfigAM()
{
	System.out.println("logout");
	Home hm=PageFactory.initElements(driver, Home.class);
	hm.logout();
	
}
@AfterClass
public void ConfigAC()
{
	System.out.println("close the browser");
	driver.close();	
}
@AfterSuite
public void ConfigAS() throws Throwable
{
	System.out.println("Logout suite");
	//EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	String cdate=new Date().toString().replace(" ", "_").replace(":","_");
	System.out.println(cdate);
	File dstfie=new File(".//backup "+ cdate +"_result.html");
	File src=new File("D:\\Automation\\CRMacttimeFramework\\test-output\\emailable-report.html");
	FileUtils.copyFile(src, dstfie);
	
}
}

