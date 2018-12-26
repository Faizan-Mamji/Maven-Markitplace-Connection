package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POMMain.AllPOMS;

public class POMFavoritesPage {

	public static WebDriver driver;
	// Logger logg=Logger.getLogger(POMFavoritesPage.class);
	static final Logger logg = LogManager.getLogger(POMFavoritesPage.class);
	String FavoritesPageTitle = "Favorites - MarkITplace";
	String ShopPageTitle = "Shop - MarkITplace";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public POMFavoritesPage(WebDriver driver) {
		POMFavoritesPage.driver = driver;
	}

	// POM Favorites Page Declaration

	

	public void Favorites_Page_TestFunctionality() throws InterruptedException {
		// PropertyConfigurator.configure("log4j.properties");
		SoftAssert sf =new SoftAssert();
		try {
			logg.info("Favorites TestCase Starts Here");
			AllPOMS.Fav_FavoritesLinkText().click();
			TimeUnit.MILLISECONDS.sleep(15000);
			logg.info("Favorites page opens successfully");
			sf.assertEquals(FavoritesPageTitle, driver.getTitle());
			logg.info("Favorites assertion passed successfully");
			AllPOMS.Fav_SelectAllCheckbox().click();
			TimeUnit.MILLISECONDS.sleep(4000);
			logg.info("SelectAll checkbox select all favorites products on the page");
			AllPOMS.Fav_AddSelectedToCart().click();
			TimeUnit.MILLISECONDS.sleep(20000);
			logg.info("Products added to cart");
			AllPOMS.Fav_FavoritesModalClose().click();
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("Add to cart modal close successfully");
			AllPOMS.Fav_ShopNavClick().click();
			logg.info("Shop Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), ShopPageTitle);
			logg.info("Shop Page assertion passed successfully");
			logg.info("*********************** Favorites TestCase Passed ***********************");
		}

		catch (Exception ex)

		{
			logg.info(
					"POMFavoritesPage - Exception!!! - There must be some issue on favorites page while doing add to cart"
							+ ex.getMessage());
			
			Assert.fail("Failed in class - POMFavoritesPage");
		}
	}
}
