package edureka.Final_Assignment_2020;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
    public static WebDriver driver;
    Properties ps;
    
    public WebDriver invokeBrowser() throws IOException {
    	FileInputStream fs = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\Utilities\\data.properties");
    	ps = new Properties();
    	ps.load(fs);
    	String browserType = ps.getProperty("browser");
    	
    	if(browserType.toLowerCase().equals("chrome")) {
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}else if(browserType.toLowerCase().equals("firefox")) {
    		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
    		driver = new FirefoxDriver();
    	}else if(browserType.toLowerCase().equals("firefox")) {
    		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
    		driver = new InternetExplorerDriver();
    	}else {
    		System.out.println("invalid browser type");
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	return driver;
    	
    }
    
    public void emailFunc() throws EmailException {
		System.out.println("Email start");
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(System.getProperty("user.dir") + "\\TestReports\\PDFReports.pdf");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("testresultsattachment");
		attachment.setName("testresult.pdf");

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.setAuthenticator(new DefaultAuthenticator("Your email address", "Your password"));
		email.setSSLOnConnect(true);
		email.setFrom("email here");// enter from email address
		email.setSubject("Testresults");
		email.setMsg("Selenium 3.0 Test Results");
		email.addTo("youremailhere");// enter to email address
		email.attach(attachment);
		email.send();
		System.out.println("Test results email sent successfully");

	}

	// Method for taking screenshot whenever a screenshot method is called


public void captureScreenshot(WebDriver driver,String resulttext,String methodname){
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		String destination = System.getProperty("user.dir") + "//" + "ScreenShots" + "//" + timestamp()
				+resulttext+ methodname+ "screenshot.png";
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

	// screenshot file name --
	public static String timestamp() {

		return new SimpleDateFormat("MM-dd HH-mm-ss").format(new Date());

	}
    
}
