package edureka.Final_Assignment_2020;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import edureka.Final_Assignmnet_2020_Pages.flightFinderFinalPage;
import edureka.Final_Assignmnet_2020_Pages.flightFinderPage;
import edureka.Final_Assignmnet_2020_Pages.loggedInPage;



public class bookFlightTest extends Base {

	@BeforeMethod
	public void initializeBrowser() throws IOException {
		driver = invokeBrowser();

	}

	@Test
	@Parameters({ "username", "password" })
	public void roundTripFlight(String username, String password) {
		driver.get(ps.getProperty("URL"));
		signInAction sign = new signInAction();
		sign.signIn(driver, username, password);

		loggedInPage lp = new loggedInPage(driver);
		String actual = lp.signOffElement().getText();
		Assert.assertEquals(actual, "SIGN-OFF", "User sign in unsucessfull");
		lp.flightLink().click();

		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:",
				"User is naviagated to Flight Finder page");

		flightFinderPage ffp = new flightFinderPage(driver);
		ffp.continueButtonElement().click();

		flightFinderFinalPage finalp = new flightFinderFinalPage(driver);

		Assert.assertEquals(finalp.finalPageMessage().getText(), "After flight finder - No Seats Avaialble  ",
				"User could not reach No seats available page");// check No Seats Available text in the final page

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
