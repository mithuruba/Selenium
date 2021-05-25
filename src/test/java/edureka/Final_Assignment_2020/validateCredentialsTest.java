package edureka.Final_Assignment_2020;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import edureka.Final_Assignmnet_2020_Pages.loggedInPage;


public class validateCredentialsTest extends Base {
	
	@BeforeMethod
	   public void initializeBrowser() throws IOException {
		 driver = invokeBrowser();
		   
	   }
		
	    @Test(dataProvider = "loginData")
	    public void loginTest(String username,String password)
	    {
	       driver.get(ps.getProperty("URL"));
	       signInAction sign = new signInAction();
	       sign.signIn(driver,username,password);
	       	       
	       loggedInPage lp = new loggedInPage(driver);
	       String actual=lp.signOffElement().getText();
	       Assert.assertEquals(actual, "SIGN-OFF", "User sign in unsucessfull");	      
	       
	    }
	    
	    @DataProvider
	    public Object[][] loginData() {
	    	Object[][] object = new Object[3][2];
	    	object[0][0] = "mit@";
	    	object[0][1] = "pas123";
	    	object[1][0] = "ro+";
	    	object[1][1] = "jo*";
	    	object[2][0] = "never";
	    	object[2][1] = "mind";
	    	return object;
	    	
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	    	driver.close();
	    }

}
