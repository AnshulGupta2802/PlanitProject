package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactPageTests extends CommonMethods {
	
	@BeforeTest
	public void initialSetup() {
		browserSetup();
	}
	
	@Test(description = "Verify that mandatory fields error messages are displayed when click on Submit button")
	public void verifyMandatoryFieldsErrorMessages() {
		click("contactPage_XPATH");
		click("submitButton_XPATH");
		Assert.assertTrue(isDisplayed("//span[@id='forename-err']", "Forename error message is displayed successfully"));
		Assert.assertTrue(isDisplayed("//span[@id='email-err']", "Email error message is displayed successfully"));
		Assert.assertTrue(isDisplayed("//span[@id='message-err']", "Message error message is displayed successfully"));
		input("forename_ID","ABCD");
		input("email_ID","ABCD@gmail.com");
		input("message_ID","testing");
		Assert.assertFalse(isDisplayed("//span[@id='forename-err']", "Forename error message is not displayed"));
		Assert.assertFalse(isDisplayed("//span[@id='email-err']", "Email error message is not displayed"));
		Assert.assertFalse(isDisplayed("//span[@id='message-err'']", "Message error message is not displayed"));
	}


	@Test(description = "Verify the successful submission of Contact page")
	public void verifySuccessfulSumbmission() throws InterruptedException {
		click("contactPage_XPATH");
		input("forename_ID","testforename");
		input("email_ID","test@email.com");
		input("message_ID","testMessage");
		click("submitButton_XPATH");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(isDisplayed("//div[@class='alert alert-success']", "Success Message"));
		click("back_XPATH");
	}

	@Test(description = "Verify the errors on entering invalid data in Contact page")
	public void verifyErrorsOnInvalidData() throws InterruptedException {
		click("contactPage_XPATH");
		input("forename_ID", "123");
		input("email_ID", "123");
		input("message_ID", "%^&");
		Assert.assertTrue(isDisplayed("//*[@class='alert alert-error ng-scope']", "Error Notification - Header"));
		Assert.assertTrue(isDisplayed("//span[@id='email-err']", "Email Error - Alert"));
	}

	}
