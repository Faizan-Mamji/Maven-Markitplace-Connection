package POMMarkITplacePages;

import org.apache.logging.log4j.Logger;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import POMMain.AllPOMS;

public class POMStandardDetail {

	public static WebDriver driver;
	static final Logger logg = LogManager.getLogger(POMStandardDetail.class);
	String EmptyText = "There are no products or standard categories available.";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public POMStandardDetail(WebDriver driver) {
		POMStandardDetail.driver = driver;
	}

	public void Navigate_SDP_From_StandardListing() {

		// PropertyConfigurator.configure("log4j.properties");
		try {
			logg.info("Standard Detail TestCase Starts here");
			String StandardPageSource = driver.getPageSource();
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("Get Complete Page Source");
			if (StandardPageSource.contains(EmptyText)) {
				logg.info("There is no data on standard listing page");
				logg.info("*********************** SDP TestCase Passed ***********************");
			}

			else {
				AllPOMS.StandardDet_StandardViewAllLinkClick().click();
				TimeUnit.MILLISECONDS.sleep(15000);
				logg.info("Standard Detail Page Opens Successfully");
				logg.info("*********************** SDP TestCase Passed ***********************");
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMStandardDetail - Exception!!! - There must be some issue on standard detail page while loading the page"
							+ ex.getMessage());
			
			Assert.fail("Failed in class - POMStandardDetail");
		}
	}
}
