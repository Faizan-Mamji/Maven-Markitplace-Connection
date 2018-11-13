package POMMarkITplacePages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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

	// POM Of Step 1 (Select Payment Method)
	By SelectPaymentBox = By.xpath("//div[@class='step-subsection ccf-box']//div[@class='row']");
	By CheckBillingAddress = By.xpath("//div[@class='step-subsection last']");
	By OpenBillingAddressDropdown = By.xpath("//div[@class='predictive-dropdown-arrow']");
	By SelectBillingAddressValue = By.xpath("//div[@class='predictive-quickfind-container']//li[1]");
	// By OpenChekoutDropdown = By.xpath("(//select[@class='native-drop
	// native-drop-checkout'])");
	By SelectCheckoutValue = By.xpath("");

	By SaveBtn = By.xpath("//a[contains(text(),'Save & Continue')]");

	// POM Of Step 2 (Shipping Information)
	By SelectAddress = By.xpath("(//div[@class='multiselect-address']//ul//li)[1]");
	By UseThisAddressBtn = By.xpath("//a[contains(text(),'Use This Address')]");
	By TotalLItem = By.xpath("//form[@id='standardLineFields']");
	By CustomMessage = By.xpath("(//div[@class='fourcolumns']//div//label)[1]");
	By CustomBox = By.xpath("//form[@id='standardLineFields']");

	// POM Of Step 3 (Notes for Recipient and Confirmations)

	By Attention = By.xpath("(//input[@type='text'])[1]");
	By SendEmailConfirmation = By.id("tbEmailConfirmation");

	// POM Of Step 4 (Review Order Details)

	By PlaceOrderBtn = By.xpath("(//a[contains(text(),'Place Order')])[1]");

	// POM Of Error box on checkout

	By ErrorOopsBox = By.xpath("//div[@class='modal-dialog']//span");
	By ErrorCloseBtn = By.xpath("//button[@class='btn btn-default']");
	By ClickLogoImage = By.xpath("//img[@class='logo']");

	/*
	 * public void CompleteCheckout_Process() throws InterruptedException {
	 * SoftAssert sf =new SoftAssert(); try { // Step 1 of Checkout process
	 * logg.info("CheckOut TestCase Starts Here");
	 * driver.findElement(POTextBox).sendKeys(String.valueOf(PO));
	 * TimeUnit.MILLISECONDS.sleep(1000);
	 * logg.info("PO number enters successfully");
	 * //driver.findElement(ReferenceTextBox).sendKeys("Test");
	 * //TimeUnit.MILLISECONDS.sleep(1000);
	 * //logg.info("Reference text enters successfully");
	 * driver.findElement(ProjectTextBox).sendKeys("Test");
	 * TimeUnit.MILLISECONDS.sleep(1000);
	 * logg.info("Project text enters successfully");
	 * driver.findElement(CostCenterTextBox).sendKeys("Test");
	 * TimeUnit.MILLISECONDS.sleep(1000);
	 * logg.info("CostCenter text enters successfully"); String BillingAddressText =
	 * driver.findElement(CheckBillingAddress).getText();
	 * 
	 * if (BillingAddressText.contains(CheckBillingAddressText)) {
	 * driver.findElement(OpenBillingAddressDropdown).click();
	 * logg.info("Select Billing address dropdown opens successfully");
	 * driver.findElement(SelectBillingAddressValue).click();
	 * logg.info("Billing address dropdown value selected successfully");
	 * driver.findElement(SaveBtn).click(); TimeUnit.MILLISECONDS.sleep(4000);
	 * logg.info("Save & Continue Button Click successfully"); } else {
	 * driver.findElement(SaveBtn).click(); TimeUnit.MILLISECONDS.sleep(4000);
	 * logg.info("Save & Continue Button Click successfully"); } // Step 2 of
	 * Checkout process logg.info("Now selection of address on checkout page");
	 * driver.findElement(SelectAddress).click(); TimeUnit.MILLISECONDS.sleep(2000);
	 * logg.info("Address selects successfully");
	 * driver.findElement(UseThisAddressBtn).click();
	 * TimeUnit.MILLISECONDS.sleep(3000);
	 * logg.info("Use this button click successfully");
	 * driver.findElement(SaveBtn).click(); TimeUnit.MILLISECONDS.sleep(4000);
	 * logg.info("Save & Continue Button Click successfully");
	 * 
	 * // Step 3 of Checkout process
	 * driver.findElement(SendEmailConfirmation).clear();
	 * TimeUnit.MILLISECONDS.sleep(2000);
	 * driver.findElement(SendEmailConfirmation).sendKeys(
	 * "faizan.mamji@arpatech.com"); TimeUnit.MILLISECONDS.sleep(2000);
	 * logg.info("Email entered successfully in textbox");
	 * driver.findElement(SaveBtn).click(); TimeUnit.MILLISECONDS.sleep(4000);
	 * logg.info("Save & Continue Button Click successfully");
	 * 
	 * // Step 4 of Checkout process driver.findElement(PlaceOrderBtn).click();
	 * TimeUnit.MILLISECONDS.sleep(50000);
	 * logg.info("Place Holder Button Click successfully!");
	 * 
	 * String TitleVerification = driver.getTitle();
	 * if(TitleVerification.equalsIgnoreCase(OrderConfirmationTitle)) {
	 * sf.assertEquals(TitleVerification, OrderConfirmationTitle);
	 * logg.info("Order Confirmation Page assertion verified successfully!");
	 * logg.info("Order Confirmation Page Opens successfully!"); logg.
	 * info("*********************** Checkout TestCase Passed ***********************"
	 * );
	 * 
	 * }
	 * 
	 * else { String errormessage = driver.findElement(ErrorOopsBox).getText(); if
	 * (errormessage.equalsIgnoreCase(CheckOutErrorMessage)) {
	 * driver.findElement(ErrorCloseBtn).click(); TimeUnit.MILLISECONDS.sleep(2000);
	 * logg.info("Oops box close on checkout page!");
	 * driver.findElement(ClickLogoImage).click();
	 * logg.info("Navigate to Home page!"); logg.
	 * info("*********************** Checkout Not Done Due To Api Issue As It Opens Oops Modal ***********************"
	 * ); }
	 * 
	 * } }
	 * 
	 * catch (Exception ex) { logg.info(
	 * "POMCheckOutPage - Exception!!! - There is some issue while doing checkout or may be it shouldn't navigate to order confirmation page "
	 * + ex.getMessage());
	 * 
	 * Assert.fail("Failed in class - POMCheckOutPage"); } }
	 */

	public void CompleteCheckout_Process() {
		Random rnd = new Random();
		int Randomvalue = rnd.nextInt(986522) + 3;
		SoftAssert sf = new SoftAssert();
		Actions action = new Actions(driver);

		try {
			// Start Checkout Step 1
			// driver.navigate().to("http://markitplace-qa.arpatech.com/shop/cart/checkout");
			logg.info("CheckOut TestCase Starts Here");
			WebElement checkoutstep1 = driver.findElement(SelectPaymentBox);
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

			String BillingAddressText = driver.findElement(CheckBillingAddress).getText();

			if (BillingAddressText.contains(CheckBillingAddressText)) {
				driver.findElement(OpenBillingAddressDropdown).click();
				logg.info("Select Billing address dropdown opens successfully");
				driver.findElement(SelectBillingAddressValue).click();
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

			// End Checkout Step 1

			// Start checkout step 2

			logg.info("Now selection of address on checkout page");
			driver.findElement(SelectAddress).click();
			TimeUnit.SECONDS.sleep(2);
			logg.info("Address selects successfully");
			driver.findElement(UseThisAddressBtn).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Use this button click successfully");
			WebElement LineItemProducts = driver.findElement(TotalLItem);
			List<WebElement> TotalLineItems = LineItemProducts
					.findElements(By.xpath("//div[@class='cart-item clearfix']"));
			logg.info("Get Order LineCount");
			int CountTotalLineItems = TotalLineItems.size();

			if (CountTotalLineItems > 0) {
				String GetCustomText = driver.findElement(CustomMessage).getText();
				logg.info("Get some label text i.e " + GetCustomText);

				if (GetCustomText != "") {
					WebElement CustomFields = driver.findElement(CustomBox);
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
				driver.findElement(PlaceOrderBtn).click();
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
					String errormessage = driver.findElement(ErrorOopsBox).getText();
					if (errormessage.equalsIgnoreCase(CheckOutErrorMessage)) {
						driver.findElement(ErrorCloseBtn).click();
						TimeUnit.MILLISECONDS.sleep(2000);
						logg.info("Oops box close on checkout page!");
						driver.findElement(ClickLogoImage).click();
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
