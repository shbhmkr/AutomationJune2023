package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//1. Constructor initialization (if not given will give null pointer exception)
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//2.FindBy: identification and declaration of elements
	@FindBy(id="username")
	public WebElement usernameTextfield;
	
	@FindBy(name="pwd")
	public WebElement passwordTextfield;
	
	@FindBy(xpath="//div[text()='Login ']")
	public WebElement loginButton;
	
	//3.Business logics/generics method
	public void loginAction(String username,String password) {
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginButton.click();
	}
	
	
	
}
