package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POMMain.AllPOMS;

public class POMOrdersPage {

	public static WebDriver driver;
	Logger logg = LogManager.getLogger(POMOrdersPage.class);
	String OrderPageTitle = "Orders - MarkITplace";
	String EmptyPageText = "No Result Found";

	public static void main(String[] args) {
	}

	public POMOrdersPage(WebDriver driver) {
		POMOrdersPage.driver = driver;
	}

	public void OrdersPage_Functionality() {
		SoftAssert sf = new SoftAssert();
		WebDriverWait wt=new WebDriverWait(driver, 20);
		try {
			logg.info("Orders testcase starts here");
			AllPOMS.Orders_OrdersNavClick().click();
			TimeUnit.SECONDS.sleep(10);
			sf.assertEquals(OrderPageTitle, driver.getTitle());
			logg.info("Orders Page assertion verified Successfully");
			logg.info("Orders Page opened Successfully");
			logg.info("Click On Buy items again button");
			wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.Orders_OrderBuyItemAgain()));
			AllPOMS.Orders_OrderBuyItemAgain().click();
			TimeUnit.SECONDS.sleep(25);
			logg.info("Buy items again modal opens Successfully");
			wt.until(ExpectedConditions.elementToBeClickable(AllPOMS.Orders_CartModalClose()));
			AllPOMS.Orders_CartModalClose().click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Buy items again modal Close Successfully");
			Select DrpOrdersTimePeriod = new Select(AllPOMS.Orders_OrdersTimePeriod());
			DrpOrdersTimePeriod.selectByIndex(5);
			TimeUnit.SECONDS.sleep(20);
			logg.info("Dropdown value changed");
			String GetBtnClass = AllPOMS.Orders_BtnLoadMore().getAttribute("class");
			String CheckOrderData = driver.getPageSource();
			if (CheckOrderData.contains(EmptyPageText)) {
				logg.info("There is no data on orders page");
				logg.info("*********************** Orders Page TestCase Passed ***********************");
			}

			else {

				if (GetBtnClass.contains("btn disabled")) {
					logg.info("Disabled class found!!");
					logg.info("Load More button is disabled as the count is less than 8!");
					logg.info("*********************** Orders TestCase Passed ***********************");
				}

				else {
					logg.info("Button found enabled!");
					logg.info("Click on loadmore button");
					AllPOMS.Orders_BtnLoadMore().click();
					TimeUnit.SECONDS.sleep(20);
					logg.info("Load More button clicks successfully and data loads");
					logg.info("*********************** Orders TestCase Passed ***********************");
				}
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMOrdersPage - Exception!!! - Must have issue on Orders page while doing add to cart or click to loadmore button - OrdersPage_Functionality "
							+ ex.getMessage());

			Assert.fail("Failed in class - POMOrdersPage");
		}
	}
}
