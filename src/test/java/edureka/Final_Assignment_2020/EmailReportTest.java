package edureka.Final_Assignment_2020;

import org.apache.commons.mail.EmailException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class EmailReportTest extends Base{
	
	@AfterSuite
	public void EmailReports() {
		EmailReportTest emailSend = new EmailReportTest();
		try {
			emailSend.emailFunc();
		}catch(EmailException e) {
			e.printStackTrace();
		}
	}

}
