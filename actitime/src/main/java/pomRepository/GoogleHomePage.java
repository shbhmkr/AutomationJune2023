package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
	
	public GoogleHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);    //here this refers GoogleHomepage
		
	}

	
	@FindBy(name="q")
	public WebElement textBox;
}






//since it is a blueprint or repository where we will store all thing ,so will not execute it so no main method here
//annotation is used to transfer meta data means taking data from somewhere and placing is somewhere