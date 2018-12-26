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

public class POMCartPage {

	public static WebDriver driver;
	static final Logger logg = LogManager.getLogger(POMCartPage.class);
	String CheckoutPageTitle = "Checkout - MarkITplace";
	String CartPageTitle = "Cart - MarkITplace";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public POMCartPage(WebDriver driver) {
		POMCartPage.driver = driver;
	}

	

	public void Navigate_Cart_Page_Check_Functionality() {
		SoftAssert sf= new SoftAssert();
		try {
			logg.info("CartPage TestCase Starts Here");
			AllPOMS.CartPage_CartIcon().click();
			TimeUnit.MILLISECONDS.sleep(15000);
			logg.info("CartPage Opens Successfully");
			sf.assertEquals(driver.getTitle(),CartPageTitle);
			logg.info("CartPage Assertion Verified");
			AllPOMS.CartPage_CartPageQtyBox().clear();
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("Clear Qty Textbox Successfully");
			AllPOMS.CartPage_CartPageQtyBox().sendKeys("3");
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("Qty entered Successfully in textbox");
			AllPOMS.CartPage_CartEditQtyUpdate().click();
			TimeUnit.MILLISECONDS.sleep(5000);
			logg.info("Price updated successfully against which the qty updated");
			TimeUnit.MILLISECONDS.sleep(2000);			
			AllPOMS.CartPage_ProceedCheckout().click();
			logg.info("Proceed To Checkout button click successfully");
			TimeUnit.MILLISECONDS.sleep(10000);
			sf.assertEquals(driver.getTitle(), CheckoutPageTitle);
			logg.info("Assertion passed of checkout page title");
			logg.info("*********************** Cart Page TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info(
					"POMCartPage - Exception!!! - There is some issue while update the qty of the product or may be a driver issue "
							+ ex.getMessage());
			
			Assert.fail("Failed in class - POMCartPage");
		}
	}

}
