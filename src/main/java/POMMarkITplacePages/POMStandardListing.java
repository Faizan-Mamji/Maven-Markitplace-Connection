package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import POMMain.AllPOMS;

public class POMStandardListing {

	public static WebDriver driver;
	// Logger logg= Logger.getLogger(POMStandardListing.class);
	static final Logger logg = LogManager.getLogger(POMStandardListing.class);
	String StandardPageTitle = "Standard Products - MarkITplace";
	String EmptyText = "There are no products or standard categories available.";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public POMStandardListing(WebDriver driver) {
		POMStandardListing.driver = driver;
	}

	// Declare POM of StandardListing Page

	public void Navigate_Standard_Listing_Verify_Left_Navigation_AddToCart() {

		try {
			logg.info("Standard Listing testcase starts");
			AllPOMS.StandardList_StandardNavClick().click();
			TimeUnit.SECONDS.sleep(20);
			logg.info("Standard Listing page open successfully");
			assertEquals(driver.getTitle(), StandardPageTitle);
			TimeUnit.SECONDS.sleep(5);
			logg.info("Standard Listing assertion passed successfully");
			String StandardPageSource = driver.getPageSource();
			TimeUnit.SECONDS.sleep(2);
			logg.info("Get Complete Page Source");
			if (StandardPageSource.contains(EmptyText)) {
				logg.info("There is no data on standard listing page");
				logg.info("*********************** Standard Listing TestCase Passed ***********************");
			}

			else {
				AllPOMS.StandardList_LeftNavClick().click();
				TimeUnit.SECONDS.sleep(15);
				logg.info("Left Navigation page opens successfully");
				String Btngettext = AllPOMS.StandardList_AddToCartBtn().getText();
				if (Btngettext.contains("Add to Cart")) {
					logg.info("Add To Cart text found on button");
					AllPOMS.StandardList_AddToCartBtn().click();
					TimeUnit.SECONDS.sleep(30);
					logg.info("Add To Cart Modal Open Successfully");
					AllPOMS.StandardList_AddToCartModalClose().click();
					TimeUnit.SECONDS.sleep(2);
					logg.info("Add To Cart Modal Close Successfully");
					logg.info("*********************** Standard Listing TestCase Passed ***********************");
				}

				else {
					logg.info("View Detail text found on button");
					AllPOMS.StandardList_AddToCartBtn().click();
					logg.info("View Detail button click successfully");
					TimeUnit.SECONDS.sleep(20);
					AllPOMS.StandardList_StandardNavClick().click();
					TimeUnit.SECONDS.sleep(20);
					logg.info("Standard Listing page open successfully");
					assertEquals(driver.getTitle(), StandardPageTitle);
					TimeUnit.SECONDS.sleep(5);
					logg.info("Standard Listing assertion passed successfully");
					logg.info("*********************** Standard Listing TestCase Passed ***********************");
				}
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMStandardListing - Exception!!! - There must be some issue on standard listing page while doing add to cart or opens the page"
							+ ex.getMessage());
			Assert.fail("Failed in class - POMStandardListing");
		}
	}
}
