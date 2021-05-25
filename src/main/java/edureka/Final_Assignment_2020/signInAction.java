package edureka.Final_Assignment_2020;

import org.openqa.selenium.WebDriver;

import edureka.Final_Assignmnet_2020_Pages.homePage;



public class signInAction {
	
	WebDriver driver;
	
	public WebDriver signIn(WebDriver driver, String username, String password) {
		homePage hp = new edureka.Final_Assignmnet_2020_Pages.homePage(driver);
		hp.getUserName().sendKeys(username);
		hp.getPassword().sendKeys(password);
		hp.submitButton().click();
		/*if(hp.invalidCredentialError().isDisplayed()) {
			System.out.println("Username and password is incorrect");
		}*/
		return driver;
		
		
	}
	

}
