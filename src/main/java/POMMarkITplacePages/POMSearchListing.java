package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POMMain.AllPOMS;

public class POMSearchListing {

	public static WebDriver driver;
	// Logger logg=Logger.getLogger(POMSearchListing.class);
	static final Logger logg = LogManager.getLogger(POMSearchListing.class);

	// Variable Declaration
	String SearchPageTitle = "Printers - MarkITplace";
	String FavoritesPageTitle = "Favorites - MarkITplace";
	String favoritestext = "Added to Favorites";
	String CartPagetext;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Constructor Declaration

	public POMSearchListing(WebDriver driver) {
		POMSearchListing.driver = driver;
	}

	
	public void OpenSearchPage_AddToCart_And_Verifyproducts_On_FavoritesPage() throws InterruptedException {
		SoftAssert sf =new SoftAssert();
		WebDriverWait wt =new WebDriverWait(driver, 20);
		try {
			logg.info("SearchListing TestCase Starts");
			AllPOMS.txt_search().sendKeys("printers");
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("Printers text enters in textbox");
			AllPOMS.txt_search().sendKeys(Keys.ENTER);
			TimeUnit.MILLISECONDS.sleep(18000);
			logg.info("Printers Search ListingPage Opens");
			sf.assertEquals(SearchPageTitle, driver.getTitle());
			logg.info("Assertion Passed For SearchListing Page");
			String SearchlistingUrl = driver.getCurrentUrl();
			TimeUnit.MILLISECONDS.sleep(2000);
			String LinkCheck = AllPOMS.link_AddToFavorite().getAttribute("class");
			TimeUnit.MILLISECONDS.sleep(2000);
			if (LinkCheck.equalsIgnoreCase("")) {
				logg.info("Add To Favorites Get class = null");

				// Here Navigate to cart page and to delete the all products from cart

				logg.info("Click on cart icon");
				AllPOMS.Page_CartIcon().click();
				TimeUnit.MILLISECONDS.sleep(10000);
				logg.info("Cart Page Opens successfully");
				CartPagetext = AllPOMS.Page_CheckCartText().getText();

				// Check Condition on cart page if products exist or not

				if (CartPagetext.equalsIgnoreCase("Your cart is empty")) {
					logg.info("Get Cart Empty so navigate to search listing page");
					driver.navigate().to(SearchlistingUrl);
					TimeUnit.MILLISECONDS.sleep(18000);
					logg.info("Products Listing Page Opens");
					sf.assertEquals(SearchPageTitle, driver.getTitle());
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("SearchListing assert Verified");
					logg.info("Click on Add To Cart Button");
					wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.btn_AddToCart()));
					AllPOMS.btn_AddToCart().click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Product Added To Cart successfully");
					wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.Modal_CloseAddToCart()));
					AllPOMS.Modal_CloseAddToCart().click();
					TimeUnit.MILLISECONDS.sleep(5000);
					logg.info("Add To Cart Modal Closed");
					AllPOMS.link_AddToFavorite().click();
					TimeUnit.MILLISECONDS.sleep(10000);
					logg.info("Product Added To Favorites");
					logg.info("*********************** SearchListing TestCase Passed ***********************");
				}

				else {
					logg.info("Products exist in cart so removing first");
					AllPOMS.Page_CartRemoveAll().click();
					logg.info("Click on Remove All button and modal opens successfully");
					TimeUnit.MILLISECONDS.sleep(3000);
					AllPOMS.Page_CartRemoveModal().click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Click on Yes Button in modal and all products deleted from cart");

					// Here Navigate to Search Listing page again

					logg.info("Now Navigate to Search listing from Cart Page");
					driver.navigate().to(SearchlistingUrl);
					TimeUnit.MILLISECONDS.sleep(18000);
					logg.info("Products Listing Page Opens");
					sf.assertEquals(SearchPageTitle, driver.getTitle());
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("SearchListing assert Verified");
					logg.info("Click on Add To Cart Button");
					wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.btn_AddToCart()));
					AllPOMS.btn_AddToCart().click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Product Added To Cart successfully");
					wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.Modal_CloseAddToCart()));
					AllPOMS.Modal_CloseAddToCart().click();
					TimeUnit.MILLISECONDS.sleep(5000);
					logg.info("Add To Cart Modal Closed");
					AllPOMS.link_AddToFavorite().click();
					TimeUnit.MILLISECONDS.sleep(10000);
					logg.info("Product Added To Favorites");
					logg.info("*********************** SearchListing TestCase Passed ***********************");
				}
			}

			// Cart Conditions Ends Here

			// This else is of search listing added to favorites

			else {
				logg.info("Add To Favorites Get class = Disable");
				AllPOMS.Link_FavoriteText().click();
				TimeUnit.MILLISECONDS.sleep(18000);
				logg.info("Favorites Page Opens Successfully");
				sf.assertEquals(FavoritesPageTitle, driver.getTitle());
				logg.info("Favorites Page Validation Passed");
				AllPOMS.Chkbox_Favorite().click();
				TimeUnit.MILLISECONDS.sleep(2000);
				AllPOMS.btn_DelFavorite().click();
				TimeUnit.MILLISECONDS.sleep(2000);
				logg.info("Delete popup opened");
				AllPOMS.btn_ModalDelFavorite().click();
				TimeUnit.MILLISECONDS.sleep(15000);
				logg.info("Products Deleted From Favorites");
				TimeUnit.MILLISECONDS.sleep(3000);

				// Here Navigate to cart page and to checking the products exist in cart or not

				logg.info("Click on cart icon");
				AllPOMS.Page_CartIcon().click();
				TimeUnit.MILLISECONDS.sleep(10000);
				logg.info("Cart Page Opens successfully");
				CartPagetext = AllPOMS.Page_CheckCartText().getText();

				// Checking here whether products exist in cart or not

				if (CartPagetext.equalsIgnoreCase("Your cart is empty")) {
					logg.info("Now Navigate to Search listing from Cart Page as cart page is empty");
					driver.navigate().to(SearchlistingUrl);
					TimeUnit.MILLISECONDS.sleep(18000);
					logg.info("Products Listing Page Opens");
					sf.assertEquals(SearchPageTitle, driver.getTitle());
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("SearchListing assert Verified");
					wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.btn_AddToCart()));
					AllPOMS.btn_AddToCart().click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Product Added To Cart successfully");
					wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.Modal_CloseAddToCart()));
					AllPOMS.Modal_CloseAddToCart().click();
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("Add To Cart Modal Close");
					AllPOMS.link_AddToFavorite().click();
					TimeUnit.MILLISECONDS.sleep(10000);
					logg.info("Products Added To Favorites");
					logg.info("*********************** SearchListing TestCase Passed ***********************");
				}

				else {
					logg.info("As products exist in cart so deleting products from cart");
					AllPOMS.Page_CartRemoveAll().click();
					logg.info("Click on Remove All button and modal opens successfully");
					TimeUnit.MILLISECONDS.sleep(3000);
					AllPOMS.Page_CartRemoveModal().click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Click on Yes Button in modal and all products deleted from cart");

					// Navigate again to listing page for add to cart and add to favorite the
					// product

					logg.info("Now Navigate to Search listing from Cart Page");
					driver.navigate().to(SearchlistingUrl);
					TimeUnit.MILLISECONDS.sleep(18000);
					logg.info("Products Listing Page Opens");
					sf.assertEquals(SearchPageTitle, driver.getTitle());
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("SearchListing assert Verified");
					wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.btn_AddToCart()));
					AllPOMS.btn_AddToCart().click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Product Added To Cart successfully");
					wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.Modal_CloseAddToCart()));
					AllPOMS.Modal_CloseAddToCart().click();
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("Add To Cart Modal Close");
					AllPOMS.link_AddToFavorite().click();
					TimeUnit.MILLISECONDS.sleep(10000);
					logg.info("Products Added To Favorites");
					logg.info("*********************** SearchListing TestCase Passed ***********************");
				}
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMSearchListing - Exception!!! - There is some issue on search listing page while loading, add to cart or add to favorite the product and can be found on page: POMSearchListing - "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMSearchListing");
			
		}
	}
}
