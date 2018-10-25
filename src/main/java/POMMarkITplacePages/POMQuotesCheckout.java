package POMMarkITplacePages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import DriverMainPackage.MainDriverClass;

public class POMQuotesCheckout {

	public static WebDriver driver;
	private Logger logg = LogManager.getLogger(POMQuotesCheckout.class);
	Random rnd = new Random();
	int RandomPO = rnd.nextInt(99999);
	String GetUrl;
	String CompleteURL = "shop/favorites";
	String QuoteCheckoutPageTitle = "Checkout - MarkITplace";
	String BillingHeadingText = "Select billing address";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public POMQuotesCheckout(WebDriver driver) {
		POMQuotesCheckout.driver = driver;
	}

	// POM declaration

	By FavSelectAll = By.xpath("//div[@class='left']//div[@class='select-all-col']");
	By BtnAddSelectedToCart = By.xpath("(//div[@class='left']//a)[1]");
	By ModalBtnCreateQuote = By.xpath("(//div[@class='modal-content']//div[@class='pull-left cart-modal-btns']//a)[1]");
	By SelectPaymentMethod = By.xpath("//div[@class='step-subsection ccf-box']//div[@class='row']");
	By SelectBillingAddress = By.xpath("//div[@class='step-subsection last']");
	By SelectBillingArrow = By.xpath("//div[@class='predictive-dropdown-arrow']");
	By SelectBillingDrpSelected = By.xpath("(//div[@class='predictive-quickfind-container']//ul//li)[1]");
	By SaveBtn = By.xpath("//a[contains(text(),'Save & Continue')]");
	By SelectAddress = By.xpath("(//div[@class='multiselect-address']//ul//li)[1]");
	By UseThisAddressBtn = By.xpath("//a[contains(text(),'Use This Address')]");
	By CustomMessage = By.xpath("(//div[@class='fourcolumns']//div//label)[1]");
	By TotalLineItems = By.id("standardLineFields");

	public void CompleteQuoteCheckout_Process() {
		MainDriverClass ObjMain = new MainDriverClass();
		SoftAssert sf = new SoftAssert();

		try {
			logg.info("Quotes Confirmation TestCase Starts Here!");
			GetUrl = ObjMain.getConfigValue("MainUrl");
			logg.info("Get URL Value " + GetUrl);
			driver.navigate().to(GetUrl + CompleteURL);
			TimeUnit.SECONDS.sleep(20);
			logg.info("Favorites page opens successfully");
			driver.findElement(FavSelectAll).click();
			logg.info("Products selected Successfully");
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(BtnAddSelectedToCart).click();
			logg.info("Add Selected To Cart Button clicked successfully");
			TimeUnit.SECONDS.sleep(20);
			driver.findElement(ModalBtnCreateQuote).click();
			logg.info("Create Quote Button clicked successfully");
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(driver.getTitle(), QuoteCheckoutPageTitle);
			logg.info("Quote Checkout Page Assertion Verified");

			// Quotes Checkout Page code starts here

			// Quotes Step 1

			WebElement FieldsStep1 = driver.findElement(SelectPaymentMethod);
			List<WebElement> ListTextFields = FieldsStep1.findElements(By.tagName("input"));
			TimeUnit.SECONDS.sleep(3);
			int CountTextBox = ListTextFields.size();
			System.out.println("The count is " + CountTextBox);
			WebElement DropdownFieldsStep1 = driver.findElement(SelectPaymentMethod);
			List<WebElement> ListDrpFields = DropdownFieldsStep1.findElements(By.tagName("select"));
			TimeUnit.SECONDS.sleep(3);
			int CountDropdown = ListDrpFields.size();
			System.out.println("The count is " + CountDropdown);

			if (CountTextBox > 0) {
				for (int i = 1; i <= CountTextBox; i++) {
					driver.findElement(By.xpath("(//input[@type='text'])[" + i + "]"))
							.sendKeys(String.valueOf(RandomPO));
					logg.info("Value enter in textbox " + i);
					TimeUnit.SECONDS.sleep(1);
				}
			}

			if (CountDropdown > 0) {
				for (int j = 1; j <= CountDropdown; j++) {
					driver.findElement(By.xpath("(//select[@class='native-drop native-drop-checkout'])[" + j + "]"))
							.click();
					logg.info("Value selected for Dropdown " + j);
					TimeUnit.SECONDS.sleep(1);

				}
			}

			String BillingGetText = driver.findElement(SelectBillingAddress).getText();

			if (BillingGetText.contains(BillingHeadingText)) {
				driver.findElement(SelectBillingArrow).click();
				logg.info("Select Billing address dropdown opens successfully");
				driver.findElement(SelectBillingDrpSelected).click();
				logg.info("Billing address dropdown value selected successfully");
				driver.findElement(SaveBtn).click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");
			}

			else {
				driver.findElement(SaveBtn).click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");
			}

			// Quotes Step 2

			logg.info("Now selection of address on checkout page");
			driver.findElement(SelectAddress).click();
			TimeUnit.SECONDS.sleep(2);
			logg.info("Address selects successfully");
			driver.findElement(UseThisAddressBtn).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Use this button click successfully");
			WebElement Step2LineItems = driver.findElement(TotalLineItems);
			logg.info("Proceed to List ProductsLineItems");
			TimeUnit.SECONDS.sleep(1);
			List<WebElement> ProductsLineItems = Step2LineItems.findElements(By.className(".cart-item-container.clearfix"));
			logg.info("Passed from List ProductsLineItems");
			int countProductsLineItems = ProductsLineItems.size();

			if (countProductsLineItems > 0) {
				String GetCustomText = driver.findElement(CustomMessage).getText();
				logg.info("Get some label text i.e " + GetCustomText);
				
			}

		}

		catch (Exception ex) {
			logg.info(
					"POMQuotesConfirmation - There is not some issue during add to cart or may be on quote checkout page. "
							+ ex.getMessage());
		}
	}
}
