package edureka.Final_Assignmnet_2020_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flightFinderFinalPage {
	
	WebDriver driver;
	public flightFinderFinalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table/tbody/tr/td/p/font/b/font[1]")
	WebElement message;
	
	
	public WebElement finalPageMessage() {
		return message;
	}

}
