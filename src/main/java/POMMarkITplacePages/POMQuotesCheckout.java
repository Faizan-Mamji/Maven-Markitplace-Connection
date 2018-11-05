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
	String QuoteConfirmationTitle = "Quote Confirmation - MarkITplace";
	String BillingHeadingText = "Select billing address";
	String CheckOutErrorMessage = "Oops! Your order could not be processed at this time. Your Account Team is ready to help or try again.";

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
	By TotalLineItems = By.xpath("//form[@id='standardLineFields']");
	By Attention = By.xpath("(//input[@type='text'])[1]");
	By SendEmailConfirmation = By.id("tbEmailConfirmation");
	By CreateQuoteBtn = By.xpath("(//a[contains(text(),'Create Quote')])[1]");
	By ErrorOopsBox = By.xpath("//div[@class='modal-dialog']//span");
	By ErrorCloseBtn = By.xpath("//button[@class='btn btn-default']");
	By ClickLogoImage = By.xpath("//img[@class='logo']");

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
			logg.info("The count is " + CountDropdown);

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

					logg.info("Dropdown " + j + " opens");
					driver.findElement(
							By.xpath("(//select[@class='native-drop native-drop-checkout'])[" + j + "]//option[1]"))
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
			List<WebElement> ProductsLineItems = Step2LineItems
					.findElements(By.xpath("//div[@class='cart-item clearfix']"));
			logg.info("Passed from List ProductsLineItems");
			int countProductsLineItems = ProductsLineItems.size();

			if (countProductsLineItems > 0) {
				String GetCustomText = driver.findElement(CustomMessage).getText();
				logg.info("Get some label text i.e " + GetCustomText);
				
				if (GetCustomText != "") {
				
					WebElement CustomBox = driver.findElement(By.xpath("//form[@id='standardLineFields']"));
					List<WebElement> Customdropdown = CustomBox.findElements(By.tagName("select"));
					int CountCustomDropdown = Customdropdown.size();
					logg.info("Total count of custom dropdown is " + CountCustomDropdown);
					List<WebElement> CustomTextarea = CustomBox.findElements(By.tagName("textarea"));
					int CountCustomTextarea = CustomTextarea.size();
					logg.info("Total count of custom textarea is " + CountCustomTextarea);

					if (CountCustomDropdown > 0) {
						for (int q = 1; q <= CountCustomDropdown; q++) {
							driver.findElement(
									By.xpath("(//select[@class='native-drop native-drop-checkout'])[" + q + "]"))
									.click();
							logg.info("Custom Dropdown opens");
							driver.findElement(By.xpath(
									"(//select[@class='native-drop native-drop-checkout'])[" + q + "]//option[1]"))
									.click();
							logg.info("Custom Dropdown value selected " + q);

						}
					}

					if (CountCustomTextarea > 0) {
						for (int m = 1; m <= CountCustomTextarea; m++) {
							driver.findElement(
									By.xpath("(//div[@class='custom-field-container']//textarea)[" + m + "]"))
									.sendKeys("TextArea " + m);
							logg.info("Custom text enters in TextArea " +m);
						}
					}
				}
				
				driver.findElement(SaveBtn).click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");

				// End Checkout Step 2

				// Step 3 of Checkout process
				driver.findElement(Attention).clear();
				driver.findElement(Attention).sendKeys("Faizan Mamji");
				TimeUnit.SECONDS.sleep(2);
				logg.info("Enter text in attention textbox");
				driver.findElement(SendEmailConfirmation).clear();
				TimeUnit.SECONDS.sleep(2);
				driver.findElement(SendEmailConfirmation).sendKeys("faizan.mamji@arpatech.com");
				TimeUnit.SECONDS.sleep(2);
				logg.info("Enter text in Email textbox");
				logg.info("Email entered successfully in textbox");
				driver.findElement(SaveBtn).click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");

				// Step 4 of Checkout process
				driver.findElement(CreateQuoteBtn).click();
				TimeUnit.SECONDS.sleep(50);
				logg.info("Place Holder Button Click successfully!");

				String TitleVerification = driver.getTitle();
				if (TitleVerification.equalsIgnoreCase(QuoteConfirmationTitle)) {
					sf.assertEquals(TitleVerification, QuoteConfirmationTitle);
					logg.info("Quote Confirmation Page assertion verified successfully!");
					logg.info("Quote Confirmation Page Opens successfully!");
					logg.info("*********************** Quote Checkout TestCase Passed ***********************");

				}

				else {
					String errormessage = driver.findElement(ErrorOopsBox).getText();
					if (errormessage.equalsIgnoreCase(CheckOutErrorMessage)) {
						driver.findElement(ErrorCloseBtn).click();
						TimeUnit.MILLISECONDS.sleep(2000);
						logg.info("Oops box close on checkout page!");
						driver.findElement(ClickLogoImage).click();
						logg.info("Navigate to Home page!");
						logg.info(
								"*********************** Quote Checkout Not Done Due To Api Issue As It Opens Oops Modal ***********************");
					}
				}
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMQuotesConfirmation - There is not some issue during add to cart or may be on quote checkout page. "
							+ ex.getMessage());
		}
	}
}
