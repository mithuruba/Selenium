package edureka.Final_Assignmnet_2020_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flightFinderPage {
	
	WebDriver driver;
	public flightFinderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='findFlights']")
	WebElement continueButton;
	
	
	public WebElement continueButtonElement() {
		return continueButton;
	}
	
	
}
