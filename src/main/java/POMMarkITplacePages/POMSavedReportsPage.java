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

public class POMSavedReportsPage {

	public static WebDriver driver;
	String SavedReportTitle = "Saved Reports - MarkITplace";
	Logger logg = LogManager.getLogger(POMSavedReportsPage.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public POMSavedReportsPage(WebDriver driver) {
		POMSavedReportsPage.driver = driver;
	}

	public void OpenSavedReport_ScheduleModal() {
		SoftAssert sf =new SoftAssert();
		try {
			logg.info("Saved Reports testcase starts here");
			AllPOMS.SavedReport_LinkSavedReport().click();
			TimeUnit.SECONDS.sleep(4);
			sf.assertEquals(SavedReportTitle, driver.getTitle());
			logg.info("Saved Report page Assertion Verified successfully");
			logg.info("Saved Report page opens successfully");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.SavedReport_ScheduleModal().click();
			logg.info("Schedule Modal opens successfully");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.SavedReport_ScheduleEmailAddress().clear();
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.SavedReport_ScheduleEmailAddress().sendKeys("faizan.mamji@arpatech.com");
			logg.info("Email address entered successfully in textbox");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.SavedReport_BtnScheduleReport().click();
			TimeUnit.SECONDS.sleep(30);
			logg.info("Schedule modal closed successfully");
			logg.info("*********************** Saved Report TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info(
					"POMSavedReportsPage - Exception!!! - Must have issue on Saved report page while email or opens the modal or page - OpenSavedReport_ScheduleModal "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMSavedReportsPage");
		}
	}
}
