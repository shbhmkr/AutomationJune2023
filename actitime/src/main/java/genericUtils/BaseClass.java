package genericUtils;

import org.testng.*;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomRepository.HomePage;
import pomRepository.LoginPage;

public class BaseClass {

	//Declaring WebDriver
	public WebDriver driver;
	//Creating an object of UtilData class
	public UtilData util=new UtilData();
	
	@BeforeSuite
	public void bsConfig() {
		System.out.println("Data base connection established");
		System.out.println("===========");
	}
	
	
	
	@BeforeTest
	public void btConfig() {
		System.out.println("Paralle execution achieved");
	}
	
	@BeforeClass
	public void bcConfig() throws EncryptedDocumentException, IOException {
		//fetching url from excel sheet
		String url=util.fetchDataFromExcel("Sheet2", 1, 0);
		
		//Launching the browser
		 driver=new EdgeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Browser is launched ");
        //Navigate to the url
        driver.get(url);
		System.out.println("The url has been navigated ");
	}
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException {
		
		//Fetching username and password from excel sheet
		String username=util.fetchDataFromExcel("Sheet2", 1, 1);
		String password=util.fetchDataFromExcel("Sheet2", 1, 2);
		
		//Login to the application
		LoginPage login=new LoginPage(driver);
	        login.loginAction(username,password);
		System.out.println("Logged in to the application");
	}
	
	@AfterMethod
	public void afConfig() {
		
		//Logout from the application
		HomePage home=new HomePage(driver);
	        home.logoutAction();
		System.out.println("Logged out of the application");
	}
	
	@AfterClass
	public void acConfig() {
		
		//closing the browser
		driver.quit();
		System.out.println("close the browser");
	}
	
	
	@AfterTest
	public void atConfig() {
		System.out.println("Parallel execution stopped ");
	}
	
	@AfterSuite
	public void asConfig() {
		System.out.println("Data base connection is closed");
	}
	
	
	
	//we don't write @Test in base class, base class is only used to write pre and post conditions
	
	/*@Test
	public void demo() {
		System.out.println("compose");
	}
	
	@Test
	public void demo1() {
		System.out.println("compose");
		System.out.println("Delete");
	}*/
	
}
