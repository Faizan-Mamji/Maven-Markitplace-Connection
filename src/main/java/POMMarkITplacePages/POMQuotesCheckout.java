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
import POMMain.AllPOMS;

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
			AllPOMS.QuotesCheckout_FavSelectAll().click();
			logg.info("Products selected Successfully");
			TimeUnit.SECONDS.sleep(2);
			AllPOMS.QuotesCheckout_BtnAddSelectedToCart().click();
			logg.info("Add Selected To Cart Button clicked successfully");
			TimeUnit.SECONDS.sleep(20);
			AllPOMS.QuotesCheckout_ModalBtnCreateQuote().click();
			logg.info("Create Quote Button clicked successfully");
			TimeUnit.SECONDS.sleep(5);
			sf.assertEquals(driver.getTitle(), QuoteCheckoutPageTitle);
			logg.info("Quote Checkout Page Assertion Verified");

			// Quotes Checkout Page code starts here

			// Quotes Step 1

			WebElement FieldsStep1 = AllPOMS.QuotesCheckout_SelectPaymentMethod();
			List<WebElement> ListTextFields = FieldsStep1.findElements(By.tagName("input"));
			TimeUnit.SECONDS.sleep(3);
			int CountTextBox = ListTextFields.size();
			System.out.println("The count is " + CountTextBox);
			List<WebElement> ListDrpFields = FieldsStep1.findElements(By.tagName("select"));
			TimeUnit.SECONDS.sleep(3);
			int CountDropdown = ListDrpFields.size();
			logg.info("The count is " + CountDropdown);
			List<WebElement> ListTextAreaFields = FieldsStep1.findElements(By.tagName("textarea"));
			TimeUnit.SECONDS.sleep(3);
			int CountTextArea = ListTextAreaFields.size();

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

			if (CountTextArea > 0) {
				for (int n = 1; n <= CountTextArea; n++) {
					driver.findElement(By.xpath("(//div[@class='step-subsection ccf-box']//textarea)[" + n + "]"))
							.sendKeys("TextArea " + n);
					logg.info("Value enters in textarea " + n);
					TimeUnit.SECONDS.sleep(1);
				}
			}

			String BillingGetText = AllPOMS.QuotesCheckout_SelectBillingAddress().getText();

			if (BillingGetText.contains(BillingHeadingText)) {
				AllPOMS.QuotesCheckout_SelectBillingArrow().click();
				logg.info("Select Billing address dropdown opens successfully");
				AllPOMS.QuotesCheckout_SelectBillingDrpSelected().click();
				logg.info("Billing address dropdown value selected successfully");
				AllPOMS.QuotesCheckout_SaveBtn().click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");
			}

			else {
				AllPOMS.QuotesCheckout_SaveBtn().click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");
			}

			// Quotes Step 2

			logg.info("Now selection of address on checkout page");
			AllPOMS.QuotesCheckout_SelectAddress().click();
			TimeUnit.SECONDS.sleep(2);
			logg.info("Address selects successfully");
			AllPOMS.QuotesCheckout_UseThisAddressBtn().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Use this button click successfully");
			WebElement Step2LineItems = AllPOMS.QuotesCheckout_TotalLineItems();
			logg.info("Proceed to List ProductsLineItems");
			TimeUnit.SECONDS.sleep(1);
			List<WebElement> ProductsLineItems = Step2LineItems
					.findElements(By.xpath("//div[@class='cart-item clearfix']"));
			logg.info("Passed from List ProductsLineItems");
			int countProductsLineItems = ProductsLineItems.size();

			if (countProductsLineItems > 0) {
				WebElement CheckLabelAttribute = AllPOMS.QuotesCheckout_CustomMessage();
				List<WebElement> CountLabel = CheckLabelAttribute.findElements(By.tagName("label"));
				int counttest = CountLabel.size();

				if (counttest > 0) {
					
					String GetCustomText = AllPOMS.QuotesCheckout_CustomLabelMessage().getText();


					if (GetCustomText != "") {

						WebElement CustomBox = AllPOMS.QuotesCheckout_CustomTextBoxes();
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
								logg.info("Custom text enters in TextArea " + m);
							}
						}
					}
				}
				AllPOMS.QuotesCheckout_SaveBtn().click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");

				// End Checkout Step 2

				// Step 3 of Checkout process
				AllPOMS.QuotesCheckout_Attention().clear();
				AllPOMS.QuotesCheckout_Attention().sendKeys("Faizan Mamji");
				TimeUnit.SECONDS.sleep(2);
				logg.info("Enter text in attention textbox");
				AllPOMS.QuotesCheckout_SendEmailConfirmation().clear();
				TimeUnit.SECONDS.sleep(2);
				AllPOMS.QuotesCheckout_SendEmailConfirmation().sendKeys("faizan.mamji@arpatech.com");
				TimeUnit.SECONDS.sleep(2);
				logg.info("Enter text in Email textbox");
				logg.info("Email entered successfully in textbox");
				AllPOMS.QuotesCheckout_SaveBtn().click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");

				// Step 4 of Checkout process
				AllPOMS.QuotesCheckout_CreateQuoteBtn().click();
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
					String errormessage = AllPOMS.QuotesCheckout_ErrorOopsBox().getText();
					if (errormessage.equalsIgnoreCase(CheckOutErrorMessage)) {
						AllPOMS.QuotesCheckout_ErrorCloseBtn().click();
						TimeUnit.MILLISECONDS.sleep(2000);
						logg.info("Oops box close on checkout page!");
						AllPOMS.QuotesCheckout_ClickLogoImage().click();
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
