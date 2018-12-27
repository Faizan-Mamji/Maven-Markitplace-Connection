package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POMMain.AllPOMS;

public class POMReportsPage {

	public static WebDriver driver;
	Logger logg = LogManager.getLogger(POMReportsPage.class);
	String AssetPageTitle = "Assets Report - MarkITplace";
	String DaysPageTitle = "Days To Ship Report - MarkITplace";
	String ExpirationPageTitle = "Expiration Report - MarkITplace";
	String InventoryPageTitle = "Inventory Report - MarkITplace";
	String InvoicesPageTitle = "Invoices Report - MarkITplace";
	String InvoiceLinePageTitle = "Invoice Line Report - MarkITplace";
	String LicensePageTitle = "Licenses Report - MarkITplace";
	String OrdersPageTitle = "Orders Report - MarkITplace";
	String OrderLinePageTitle = "Order Line Report - MarkITplace";
	String QuotesPageTitle = "Quotes Report - MarkITplace";
	String ReceivingLogPageTitle = "Receiving Log Report - MarkITplace";
	String ShipmentsPageTitle = "Shipments Report - MarkITplace";
	String StandardPageTitle = "Standards Report - MarkITplace";
	String WarrantiesPageTitle = "Warranties Report - MarkITplace";
	String EmptyPageText = "Records not found";

	public static void main(String[] args) {
	}

	public POMReportsPage(WebDriver driver) {
		POMReportsPage.driver = driver;
	}

	public void AssetPage_Functionality() {

		Actions Ac = new Actions(driver);
		SoftAssert sf = new SoftAssert();
		try {
			logg.info("Reports testcase starts here");
			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_AssetsNavLink().click();
			// TimeUnit.SECONDS.sleep(6);
			sf.assertEquals(AssetPageTitle, driver.getTitle());
			logg.info("Assets Report Assertion Verified successfully");
			logg.info("Assets Report page opens successfully");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.Reports_EmailIconClick().click();
			logg.info("Email Modal opens successfully");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.Reports_EmailAddress().sendKeys("faizan.mamji@arpatech.com");
			logg.info("Email address entered successfully in textbox");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.Reports_EmailSendBtn().click();
			TimeUnit.SECONDS.sleep(50);
			logg.info("Email sent successfully on a given emailaddress");
			logg.info("*********************** Reports TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info(
					"POMReportsPage - Exception!!! - Must have issue on Assets Report page while email or opens the page - AssetPage_Functionality "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMReportsPage");
		}
	}

	public void AllReportsPage_Functionality() {
		Actions Ac = new Actions(driver);
		SoftAssert sf = new SoftAssert();

		try {
			logg.info("All Remaining Reports pages testcase starts here");
			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_DaysShipNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(DaysPageTitle, driver.getTitle());
			logg.info("Days To Ship Report Assertion Verified successfully");
			logg.info("Days To Ship Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_ExpirationNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(ExpirationPageTitle, driver.getTitle());
			logg.info("Expiration Report Assertion Verified successfully");
			logg.info("Expiration Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_InventoryNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(InventoryPageTitle, driver.getTitle());
			logg.info("Inventory Report Assertion Verified successfully");
			logg.info("Inventory Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_InvoicesNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(InvoicesPageTitle, driver.getTitle());
			logg.info("Invoice Report Assertion Verified successfully");
			logg.info("Invoice Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_InvoiceLineNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(InvoiceLinePageTitle, driver.getTitle());
			logg.info("Invoice Line Report Assertion Verified successfully");
			logg.info("Invoice Line Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_LicensesNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(LicensePageTitle, driver.getTitle());
			logg.info("Licenses Report Assertion Verified successfully");
			logg.info("Licenses Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_OrdersNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(OrdersPageTitle, driver.getTitle());
			logg.info("Orders Report Assertion Verified successfully");
			logg.info("Orders Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_OrderLineNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(OrderLinePageTitle, driver.getTitle());
			logg.info("OrderLine Report Assertion Verified successfully");
			logg.info("OrderLine Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_QuotesNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(QuotesPageTitle, driver.getTitle());
			logg.info("Quotes Report Assertion Verified successfully");
			logg.info("Quotes Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_ReceivingLogNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(ReceivingLogPageTitle, driver.getTitle());
			logg.info("Receiving Log Report Assertion Verified successfully");
			logg.info("Receiving Log Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_ShipmentsNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(ShipmentsPageTitle, driver.getTitle());
			logg.info("Shipment Report Assertion Verified successfully");
			logg.info("Shipment Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_StandardsNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(StandardPageTitle, driver.getTitle());
			logg.info("Standard Report Assertion Verified successfully");
			logg.info("Standard Report page opens successfully");

			Ac.moveToElement(AllPOMS.Reports_ReportsNav()).perform();
			logg.info("Reports hover opens successfully");
			AllPOMS.Reports_WarrantiesNavLink().click();
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(WarrantiesPageTitle, driver.getTitle());
			logg.info("Warranties Report Assertion Verified successfully");
			logg.info("Warranties Report page opens successfully");
		}

		catch (Exception ex) {

			logg.info("POMReportsPage - Exception!!! - There is some issue while opening the other reports "
					+ ex.getMessage());

			Assert.fail("Failed in class - POMReportsPage");
		}
	}
}
