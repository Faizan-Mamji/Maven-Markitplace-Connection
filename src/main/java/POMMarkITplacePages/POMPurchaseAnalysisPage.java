package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POMMain.AllPOMS;

public class POMPurchaseAnalysisPage {

	public static WebDriver driver;
	String PurchasePageTitle = "Purchase Analysis - MarkITplace";
	Logger logg = LogManager.getLogger(POMPurchaseAnalysisPage.class);

	public static void main(String[] args) {
	}

	public POMPurchaseAnalysisPage(WebDriver driver) {
		POMPurchaseAnalysisPage.driver = driver;
	}

	public void OpenPurchase_Analysis_Email() {
		SoftAssert sf =new SoftAssert();
		try {
			logg.info("Purchase Analysis testcase starts here");
			AllPOMS.Purchase_purchasenavclick().click();
			TimeUnit.SECONDS.sleep(4);
			sf.assertEquals(PurchasePageTitle, driver.getTitle());
			logg.info("Purchase Analysis page Assertion Verified successfully");
			logg.info("Purchase Analysis page opens successfully");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.Purchase_EmailIconClick().click();
			logg.info("Email Modal opens successfully");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.Purchase_EmailAddress().sendKeys("faizan.mamji@arpatech.com");
			logg.info("Email address entered successfully in textbox");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.Purchase_EmailSendBtn().click();
			TimeUnit.SECONDS.sleep(50);
			logg.info("Email sent successfully on a given emailaddress");
			logg.info("*********************** Purchase Analysis TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info(
					"POMPurchaseAnalysisPage - Exception!!! - Must have issue on purchase analysis page while email or opens the page - OpenPurchase_Analysis_Email "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMPurchaseAnalysisPage");
		}
	}
}
