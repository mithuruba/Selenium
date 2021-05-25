package edureka.Final_Assignmnet_2020_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
	WebDriver driver;
	public homePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By userName = By.name("userName");
	By password = By.name("password");
	By submit = By.xpath("//input[@name='submit']");
	By invalidCredentialError = By.xpath("//span[contains(text(),'Enter your userName and password correct')]");
	
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement submitButton() {
		return driver.findElement(submit);
	}
	
	public WebElement invalidCredentialError() {
		return driver.findElement(invalidCredentialError);
	}
	

}
