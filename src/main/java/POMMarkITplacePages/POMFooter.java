package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POMMain.AllPOMS;

public class POMFooter {

	public static WebDriver driver;
	Logger logg = LogManager.getLogger(POMFooter.class);
	String ProfilePageTitle = "My Profile - MarkITplace";
	String ShippingPageTitle = "Shipping Address - MarkITplace";
	String AllProductsPageTitle = "All Products - MarkITplace";
	String ResourcePageTitle = "Resources - MarkITplace";
	String SpecialOfferPageTitle = "Special Offers - MarkITplace";
	String AboutUsPageTitle = "About MarkITPlace - MarkITplace";
	String ContactUsPageTitle = "Contact Us - MarkITplace";
	String CustomerSupportPageTitle = "Customer Support - MarkITplace";
	String TermsOfSalePageTitle = "Terms of Sale - MarkITplace";
	String PrivacyPolicyPageTitle = "Privacy Policy - MarkITplace";
	String AccessibilityPageTitle = "Accessibility Policy - Connection";
	String HelpPageTitle = "Help - MarkITplace";

	public static void main(String[] args) {
	}

	public POMFooter(WebDriver driver) {

		POMFooter.driver = driver;
	}

	public void Navigate_Footer() {
		SoftAssert sf = new SoftAssert();
		Actions Ac = new Actions(driver);
		try {
			logg.info("Footer Testcase starts here");
			String Parent_Window = driver.getWindowHandle();
			logg.info("Main Window stores here");

			Ac.moveToElement(AllPOMS.Footers_HoverTopMyAccount()).perform();
			TimeUnit.SECONDS.sleep(3);
			logg.info("My Account hover opens");
			AllPOMS.Footers_MyProfile().click();
			TimeUnit.SECONDS.sleep(6);
			logg.info("My Profile Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), ProfilePageTitle);
			logg.info("My Profile Assertion Verified Successfully");

			Ac.moveToElement(AllPOMS.Footers_HoverTopMyAccount()).perform();
			TimeUnit.SECONDS.sleep(3);
			logg.info("My Account hover opens");
			AllPOMS.Footers_ShippingAddress().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Shipping Address Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), ShippingPageTitle);
			logg.info("Shipping Assertion Verified Successfully");

			AllPOMS.Footers_FooterAllproducts().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("All Products Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), AllProductsPageTitle);
			logg.info("All Products Assertion Verified Successfully");

			AllPOMS.Footers_FooterResources().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Resource Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), ResourcePageTitle);
			logg.info("Resource Assertion Verified Successfully");

			AllPOMS.Footers_FooterSpecialOffers().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("SpecialOffers Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), SpecialOfferPageTitle);
			logg.info("Special Offers Assertion Verified Successfully");

			AllPOMS.Footers_FooterAboutUs().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("AboutUs Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), AboutUsPageTitle);
			logg.info("AboutUs Assertion Verified Successfully");

			AllPOMS.Footers_FooterContactUs().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("ContactUs Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), ContactUsPageTitle);
			logg.info("ContactUs Assertion Verified Successfully");

			AllPOMS.Footers_FooterCustomerSupport().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Customer Support Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), CustomerSupportPageTitle);
			logg.info("Customer Support Assertion Verified Successfully");

			AllPOMS.Footers_FooterTermsOfSale().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Terms Of Sale Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), TermsOfSalePageTitle);
			logg.info("Terms Of Sale Assertion Verified Successfully");

			AllPOMS.Footers_FooterPrivacyPolicy().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Privacy Policy Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), PrivacyPolicyPageTitle);
			logg.info("Privacy Policy Assertion Verified Successfully");

			AllPOMS.Footers_FooterAccessibility().click();
			TimeUnit.SECONDS.sleep(15);
			logg.info("Accessibility Page Opens Successfully");
			driver.switchTo().window(Parent_Window);
			logg.info("Navigate to parent window again");
			Set<String> AllWindows = driver.getWindowHandles();
			logg.info("Get All windows using getWindowHandles");
			for (String Child : AllWindows) {
				logg.info("Verify conditions here of different tabs");
				if (!Parent_Window.equalsIgnoreCase(Child)) {
					logg.info("Condition passed as child id is different from parent");
					driver.switchTo().window(Child);
					logg.info("Navigate to Child window again");
					sf.assertEquals(driver.getTitle(), AccessibilityPageTitle);
					logg.info("Accessibility assertion verified successfully");
					driver.switchTo().window(Parent_Window);
					logg.info("Navigate to parent window again");
				}
			}

			AllPOMS.Footers_FooterHelp().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Help Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), HelpPageTitle);
			logg.info("Help assertion verified successfully");
			logg.info("*********************** Footer TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info(
					"POMFooter - Exception!!! - There is some issue while navigating to footers Pages or may be a driver issue "
							+ ex.getMessage());
			Assert.fail("Failed Testcase in class - POMFooter");
		}
	}

}
