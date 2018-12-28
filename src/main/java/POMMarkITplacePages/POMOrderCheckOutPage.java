package POMMarkITplacePages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POMMain.AllPOMS;

public class POMOrderCheckOutPage {

	public static WebDriver driver;
	static final Logger logg = LogManager.getLogger(POMOrderCheckOutPage.class);
	Random rnd = new Random();
	int PO = rnd.nextInt(999999);
	String CheckBillingAddressText = "Select billing address";
	String OrderConfirmationTitle = "Order Confirmation - MarkITplace";
	String CheckoutPageTitle = "Checkout - MarkITplace";
	String CheckOutErrorMessage = "Oops! Your order could not be processed at this time. Your Account Team is ready to help or try again.";
	// String OrderConfirmationTitle = "Order Confirmation - MarkITplace";

	public static void main(String[] args) {
	}

	public POMOrderCheckOutPage(WebDriver driver) {
		POMOrderCheckOutPage.driver = driver;
	}

	// Declare Checkout Page POM

	

	public void CompleteCheckout_Process() {
		Random rnd = new Random();
		int Randomvalue = rnd.nextInt(986522) + 3;
		SoftAssert sf = new SoftAssert();
		Actions action = new Actions(driver);

		try {
			// Start Checkout Step 1
			//driver.navigate().to("http://markitplace-qa.arpatech.com/shop/cart/checkout");
			logg.info("CheckOut TestCase Starts Here");
			WebElement checkoutstep1 = AllPOMS.OrderCheckout_SelectPaymentBox();
			List<WebElement> textboxelem = checkoutstep1.findElements(By.tagName("input"));
			int TextBoxcount = textboxelem.size();
			logg.info("Total textbox appears for Select Payment Method is " + TextBoxcount);
			List<WebElement> dropdownelement = checkoutstep1.findElements(By.tagName("select"));
			int drpcount = dropdownelement.size();
			logg.info("Total dropdown appears for Select Payment Method is " + drpcount);
			List<WebElement> TextAreaelement = checkoutstep1.findElements(By.tagName("textarea"));
			int TextAreaCount = TextAreaelement.size();
			logg.info("Total textarea appears for Select Payment Method is " + TextAreaCount);

			if (TextBoxcount > 0) {
				for (int i = 1; i <= TextBoxcount; i++) {
					driver.findElement(By.xpath("(//input[@type='text'])[" + i + "]"))
							.sendKeys(String.valueOf(Randomvalue));
					TimeUnit.SECONDS.sleep(3);
				}
			}

			if (drpcount > 0) {
				for (int d = 1; d <= drpcount; d++) {
					driver.findElement(By.xpath("(//select[@class='native-drop native-drop-checkout'])[" + d + "]"))
							.click();
					logg.info("Dropdown Opens Successfully!");
					TimeUnit.SECONDS.sleep(2);
					driver.findElement(
							By.xpath("(//select[@class='native-drop native-drop-checkout'])[" + d + "]//option[1]"))
							.click();
				}
			}

			if (TextAreaCount > 0) {
				for (int n = 1; n <= TextAreaCount; n++) {
					driver.findElement(By.xpath("(//div[@class='step-subsection ccf-box']//textarea)[" + n + "]"))
							.sendKeys("TextArea " + n);
					logg.info("Value enters in textarea " + n);
					TimeUnit.SECONDS.sleep(1);
				}
			}

			String BillingAddressText = AllPOMS.OrderCheckout_CheckBillingAddress().getText();

			if (BillingAddressText.contains(CheckBillingAddressText)) {
				AllPOMS.OrderCheckout_OpenBillingAddressDropdown().click();
				logg.info("Select Billing address dropdown opens successfully");
				AllPOMS.OrderCheckout_SelectBillingAddressValue().click();
				logg.info("Billing address dropdown value selected successfully");
				AllPOMS.OrderCheckout_SaveBtn().click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");
			}

			else {
				AllPOMS.OrderCheckout_SaveBtn().click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");
			}

			// End Checkout Step 1

			// Start checkout step 2

			logg.info("Now selection of address on checkout page");
			AllPOMS.OrderCheckout_SelectAddress().click();
			TimeUnit.SECONDS.sleep(2);
			logg.info("Address selects successfully");
			AllPOMS.OrderCheckout_UseThisAddressBtn().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Use this button click successfully");
			WebElement LineItemProducts = AllPOMS.OrderCheckout_TotalLItem();
			List<WebElement> TotalLineItems = LineItemProducts
					.findElements(By.xpath("//div[@class='cart-item clearfix']"));
			logg.info("Get Order LineCount");
			int CountTotalLineItems = TotalLineItems.size();

			if (CountTotalLineItems > 0) {
				WebElement CheckLabelAttribute = AllPOMS.OrderCheckout_CustomMessage();
				List<WebElement> CountLabel = CheckLabelAttribute.findElements(By.tagName("label"));
				int counttest = CountLabel.size();

				if (counttest > 0) {
					// logg.info("Get some label text i.e " + GetCustomText);

					String GetCustomText = AllPOMS.OrderCheckout_CustomLabelMessage().getText();

					if (GetCustomText != "") {
						WebElement CustomFields = AllPOMS.OrderCheckout_CustomBox();
						List<WebElement> CustomDropdown = CustomFields.findElements(By.tagName("select"));
						int TotalDropdownCount = CustomDropdown.size();
						logg.info("Total count of custom dropdown is " + TotalDropdownCount);
						List<WebElement> CustomTextArea = CustomFields.findElements(By.tagName("textarea"));
						int TotalTextAreaCount = CustomTextArea.size();
						logg.info("Total count of custom TextArea is " + TotalTextAreaCount);

						// System.out.println(TotalCount);

						if (TotalDropdownCount > 0) {
							for (int j = 1; j <= TotalDropdownCount; j++) {
								driver.findElement(
										By.xpath("(//select[@class='native-drop native-drop-checkout'])[" + j + "]"))
										.click();
								logg.info("Custom Dropdown opens");
								driver.findElement(By.xpath(
										"(//select[@class='native-drop native-drop-checkout'])[" + j + "]//option[1]"))
										.click();
								logg.info("Custom Dropdown value selected " + j);

							}
						}

						if (TotalTextAreaCount > 0) {
							for (int k = 1; k <= TotalTextAreaCount; k++) {
								driver.findElement(
										By.xpath("(//div[@class='custom-field-container']//textarea)[" + k + "]"))
										.sendKeys("TextArea " + k);
								logg.info("Custom text enters in TextArea " + k);
							}
						}
					}
				}

				AllPOMS.OrderCheckout_SaveBtn().click();
				TimeUnit.SECONDS.sleep(4);
				logg.info("Save & Continue Button Click successfully");

				// End Checkout Step 2

				// Step 3 of Checkout process
				AllPOMS.OrderCheckout_Attention().clear();
				AllPOMS.OrderCheckout_Attention().sendKeys("Faizan Mamji");
				TimeUnit.SECONDS.sleep(2);
				logg.info("Enter text in attention textbox");
				AllPOMS.OrderCheckout_SendEmailConfirmation().clear();
				TimeUnit.SECONDS.sleep(2);
				AllPOMS.OrderCheckout_SendEmailConfirmation().sendKeys("faizan.mamji@arpatech.com");
				TimeUnit.SECONDS.sleep(2);
				logg.info("Enter text in Email textbox");
				logg.info("Email entered successfully in textbox");
				AllPOMS.OrderCheckout_SaveBtn().click();
				TimeUnit.SECONDS.sleep(12);
				logg.info("Save & Continue Button Click successfully");

				// Step 4 of Checkout process
				AllPOMS.OrderCheckout_PlaceOrderBtn().click();
				TimeUnit.SECONDS.sleep(50);
				logg.info("Place Holder Button Click successfully!");

				String TitleVerification = driver.getTitle();
				if (TitleVerification.equalsIgnoreCase(OrderConfirmationTitle)) {
					sf.assertEquals(TitleVerification, OrderConfirmationTitle);
					logg.info("Order Confirmation Page assertion verified successfully!");
					logg.info("Order Confirmation Page Opens successfully!");
					logg.info("*********************** Order Checkout TestCase Passed ***********************");

				}

				else {
					String errormessage = AllPOMS.OrderCheckout_ErrorOopsBox().getText();
					if (errormessage.equalsIgnoreCase(CheckOutErrorMessage)) {
						AllPOMS.OrderCheckout_ErrorCloseBtn().click();
						TimeUnit.MILLISECONDS.sleep(2000);
						logg.info("Oops box close on checkout page!");
						AllPOMS.OrderCheckout_ClickLogoImage().click();
						logg.info("Navigate to Home page!");
						logg.info(
								"*********************** Order Checkout Not Done Due To Api Issue As It Opens Oops Modal ***********************");
					}
				}
			}
		}

		catch (

		Exception ex) {
			logg.info(
					"POMCheckOutPage - Exception!!! - There is some issue while doing checkout or may be it shouldn't navigate to order confirmation page "
							+ ex.getMessage());

			Assert.fail("Failed in class - POMCheckOutPage");
		}

	}

}
