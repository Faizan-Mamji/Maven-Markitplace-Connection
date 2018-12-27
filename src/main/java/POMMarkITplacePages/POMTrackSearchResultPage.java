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

public class POMTrackSearchResultPage {

	public static WebDriver driver;
	String TrackSearchResultPageTitle = "Search Result - MarkITplace";
	String OrderLoadMoreBtnClass = "btn load-more-link order-load-more";
	String QuotesLoadMoreBtnClass = "btn load-more-link quote-load-more";
	String AssetsLoadMoreBtnClass = "btn load-more-link asset-load-more";
	String ShipmentsLoadMoreBtnClass = "btn load-more-link asset-load-more";
	Logger logg = LogManager.getLogger(POMTrackSearchResultPage.class);

	public static void main(String[] args) {

	}

	public POMTrackSearchResultPage(WebDriver driver) {
		POMTrackSearchResultPage.driver = driver;
	}

	public void TrackSearchResultPage_Function() {
		SoftAssert sf =new SoftAssert();
		try {
			sf.assertEquals(driver.getTitle(), TrackSearchResultPageTitle);
			logg.info("Track Search Result Assertion verified");
			TimeUnit.SECONDS.sleep(2);
			String OrdersCheckCountText = AllPOMS.TrackSearch_CheckTotalCount().getText();
			logg.info("Get Count Of Orders Tab");
			TimeUnit.SECONDS.sleep(2);
			if (OrdersCheckCountText.contains("0 result matching")) {
				logg.info("Enter in condition here count is 0 in orders tab");
				AllPOMS.TrackSearch_BtnQuotes().click();
				TimeUnit.SECONDS.sleep(3);
				logg.info("Navigate to quotes tab");
				String QuotesCheckCountText = AllPOMS.TrackSearch_CheckTotalCount().getText();
				logg.info("Get Count Of Quotes Tab");
				if (QuotesCheckCountText.contains("0 result matching")) {
					logg.info("Enter in condition here count is 0 in quotes tab");
					AllPOMS.TrackSearch_BtnAssets().click();
					TimeUnit.SECONDS.sleep(2);
					logg.info("Navigate to assets tab");
					String AssetsCheckCountText = AllPOMS.TrackSearch_CheckTotalCount().getText();
					logg.info("Get Count Of Assets Tab");
					if (AssetsCheckCountText.contains("0 result matching")) {
						logg.info("Enter in condition here count is 0 in assets tab");
						AllPOMS.TrackSearch_BtnShipments().click();
						TimeUnit.SECONDS.sleep(2);
						logg.info("Navigate to shipments tab");
						String ShipmentsCheckCountText = AllPOMS.TrackSearch_CheckTotalCount().getText();
						logg.info("Get Count Of Shipments Tab");
						if (ShipmentsCheckCountText.contains("0 result matching")) {
							logg.info("Enter in condition here count is 0 in shipments tab");
							TimeUnit.SECONDS.sleep(2);
							logg.info("All Tabs Have 0 record");
						}

						else {
							String ShipmentsLoadBtnClass = AllPOMS.TrackSearch_LoadMoreBtn().getAttribute("class");
							if (ShipmentsLoadBtnClass.contains(ShipmentsLoadMoreBtnClass)) {
								AllPOMS.TrackSearch_LoadMoreBtn().click();
								TimeUnit.SECONDS.sleep(25);
								logg.info("Click on load more button in shipments tab");
								logg.info(
										"*********************** Track Search Result TestCase Passed ***********************");
							}
						}
					}

					else {
						String AssetsLoadBtnClass = AllPOMS.TrackSearch_LoadMoreBtn().getAttribute("class");
						if (AssetsLoadBtnClass.contains(AssetsLoadMoreBtnClass)) {
							AllPOMS.TrackSearch_LoadMoreBtn().click();
							TimeUnit.SECONDS.sleep(25);
							logg.info("Click on load more button in assets tab");
							logg.info(
									"*********************** Track Search Result TestCase Passed ***********************");
						}
					}
				}

				else {
					String QuotesLoadBtnClass = AllPOMS.TrackSearch_LoadMoreBtn().getAttribute("class");
					if (QuotesLoadBtnClass.contains(QuotesLoadMoreBtnClass)) {
						AllPOMS.TrackSearch_LoadMoreBtn().click();
						TimeUnit.SECONDS.sleep(25);
						logg.info("Click on load more button in quotes tab");
						logg.info(
								"*********************** Track Search Result TestCase Passed ***********************");
					}
				}
			}

			else {
				String OrdersLoadBtnClass = AllPOMS.TrackSearch_LoadMoreBtn().getAttribute("class");
				if (OrdersLoadBtnClass.contains(OrderLoadMoreBtnClass)) {
					AllPOMS.TrackSearch_LoadMoreBtn().click();
					TimeUnit.SECONDS.sleep(25);
					logg.info("Click on load more button in orders tab");
					logg.info("*********************** Track Search Result TestCase Passed ***********************");
				}
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMTrackSearchSearchPage - Exception!!! - There is some issue on Track Search Result Page while click on load more button or may be driver issue "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMTrackSearchResultPage");
		}
	}
}
