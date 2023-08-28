package homeTest;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.BaseClass;


public class ToVerifyHomePageTitleUsingTestNgTest extends BaseClass{

	@Test
    public void toVerifyHomePageTitleUsingTestNgTest() throws EncryptedDocumentException, IOException {
		
		//Fetching home page title from the excel sheet
		
      String homePageTitle=util.fetchDataFromExcel("Sheet2", 1, 3);
      
      //Waiting for the title  
      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains(homePageTitle));
        
        //Fetching the actual title
        String actualHomePageTitle=driver.getTitle();
        
        //Verifying the hompepage
        Assert.assertTrue(actualHomePageTitle.contains(homePageTitle));
       
       
        
       /* wait.until(ExpectedConditions.titleContains("Login"));
        
        String actualLoginPageTitle=driver.getTitle();
        
        Assert.assertTrue(actualLoginPageTitle.contains("Login"));
        */
        
}
}