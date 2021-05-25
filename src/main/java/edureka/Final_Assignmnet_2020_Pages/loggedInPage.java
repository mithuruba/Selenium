package edureka.Final_Assignmnet_2020_Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loggedInPage {
	
	WebDriver driver;
	public loggedInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]")
	WebElement signOff;
	
	@FindBy(xpath = "//a[contains(text(),'Flights')]")
	WebElement flightOption;
	
	public WebElement signOffElement() {
		return signOff;
	}
	
	public WebElement flightLink() {
		return flightOption;
	}
	
	
}
