package POMMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllPOMS {

	public static WebDriver driver;

	// Login Page POMS

	public AllPOMS(WebDriver driver) {
		AllPOMS.driver = driver;
	}

	public static WebElement txt_Login() {

		By login_email = By.name("username");
		return driver.findElement(login_email);
	}

	public static WebElement txt_Password() {

		By login_password = By.name("password");
		return driver.findElement(login_password);
	}

	public static WebElement txt_SubmitBtn() {

		By submit_login = By.xpath("//input[@type='submit']");
		return driver.findElement(submit_login);
	}

	// Search Listing Page POM

	public static WebElement txt_search() {

		By SearchBox = By.id("x_main-search");
		return driver.findElement(SearchBox);
	}

	public static WebElement btn_AddToCart() {

		By AddToCartBtn = By.xpath("(//a[@class='add_to_cart btn btn-primary'])[1]");
		return driver.findElement(AddToCartBtn);
	}

	public static WebElement link_AddToFavorite() {

		By AddToFavoriteslinkbtn = By.xpath("(//div[@class='compare-container clearfix']/a)[1]");
		return driver.findElement(AddToFavoriteslinkbtn);
	}

	public static WebElement Chkbox_Favorite() {

		By FavoritesCheckBoxSelectAll = By.xpath("//div[@class='left']//span[@class='control__indicator']");
		return driver.findElement(FavoritesCheckBoxSelectAll);
	}

	public static WebElement btn_DelFavorite() {

		By FavoritesDeleteBtn = By.xpath("//div[@class='btn-col']/a[@class='btn']");
		return driver.findElement(FavoritesDeleteBtn);
	}

	public static WebElement btn_ModalDelFavorite() {

		By FavoritesModalDelBtn = By.xpath("(//div[@class='btn-container clearfix']/button)[1]");
		return driver.findElement(FavoritesModalDelBtn);
	}

	public static WebElement Link_AddedToFavoriteBtn() {

		By AddedToFavoriteslinkbtn = By.xpath("(//a[@class='linkdisable tt-wrapper'])[1]");
		return driver.findElement(AddedToFavoriteslinkbtn);
	}

	public static WebElement FavoriteDelCondition() {

		By FavoritesDelConditionCheck = By.xpath("//a[contains(text(),'Delete')]");
		return driver.findElement(FavoritesDelConditionCheck);
	}

	public static WebElement Modal_CloseAddToCart() {

		By AddToCartModalClose = By.xpath("(//div[@class='modal-content']/button[@title='Close (Esc)'])[3]");
		return driver.findElement(AddToCartModalClose);
	}

	public static WebElement Link_FavoriteText() {

		By FavoritesLinkText = By.linkText("Favorites");
		return driver.findElement(FavoritesLinkText);
	}

	public static WebElement Page_CartIcon() {

		By CartIcon = By.xpath("//div[@class='shopping-cart']//a");
		return driver.findElement(CartIcon);
	}

	public static WebElement Page_CartRemoveAll() {

		By CartRemoveAll = By.xpath("(//div[@class='cart-footer']//a)[1]");
		return driver.findElement(CartRemoveAll);
	}

	public static WebElement Page_CartRemoveModal() {

		By CartRemoveModal = By.xpath("//button[@class='btn btn-primary remove-all-item']");
		return driver.findElement(CartRemoveModal);
	}

	public static WebElement Page_CheckCartText() {

		By CheckCartText = By.xpath("//div[@class='cart-header lower-shadow-medium-down fivelayer']//h2");
		return driver.findElement(CheckCartText);
	}

	// PDP Page POM

	public static WebElement SL_ProductImage() {

		By productimageclick = By.xpath(
				"(//div[@class='product-list-grid clearfix print-product-list grid']//a[@class='image-link'])[1]");
		return driver.findElement(productimageclick);
	}

	public static WebElement PDP_EmailIcon() {

		By EmailIconClick = By.xpath("(//span[@class='product-list-actions']/a)[1]");
		return driver.findElement(EmailIconClick);
	}

	public static WebElement PDP_EmailAddress() {

		By EmailAddress = By.id("email_addresses");
		return driver.findElement(EmailAddress);
	}

	public static WebElement PDP_EmailSendBtn() {

		By EmailSendBtn = By.xpath("//button[@class='btn btn-primary']");
		return driver.findElement(EmailSendBtn);
	}

	// Favorites Page POM

	public static WebElement Fav_SelectAllCheckbox() {

		By SelectAllCheckbox = By.xpath("//div[@class='left']//span[@class='control__indicator']");
		return driver.findElement(SelectAllCheckbox);
	}

	public static WebElement Fav_AddSelectedToCart() {

		By AddSelectedToCart = By.id("addAllToCart");
		return driver.findElement(AddSelectedToCart);
	}

	public static WebElement Fav_FavoritesModalClose() {

		By FavoritesModalClose = By.xpath("(//button[@title='Close (Esc)'])[5]");
		return driver.findElement(FavoritesModalClose);
	}

	public static WebElement Fav_FavoritesDeleteBtn() {

		By FavoritesDeleteBtn = By.xpath("//div[@class='btn-col']/a[@class='btn']");
		return driver.findElement(FavoritesDeleteBtn);
	}

	public static WebElement Fav_FavoritesModalDelBtn() {

		By FavoritesModalDelBtn = By.xpath("(//div[@class='btn-container clearfix']/button)[1]");
		return driver.findElement(FavoritesModalDelBtn);
	}

	public static WebElement Fav_FavoritesLinkText() {

		By FavoritesLinkText = By.linkText("Favorites");
		return driver.findElement(FavoritesLinkText);
	}

	public static WebElement Fav_ShopNavClick() {

		By ShopNavClick = By.xpath("(//div[@class='homepage-nav-item-container']//a)[1]");
		return driver.findElement(ShopNavClick);
	}

	// Standard Listing Page POM

	public static WebElement StandardList_StandardNavClick() {

		By StandardNavClick = By.xpath("(//a[contains(text(),'Standards Catalog')])[2]");
		return driver.findElement(StandardNavClick);
	}

	public static WebElement StandardList_LeftNavClick() {

		By LeftNavClick = By.xpath("(//div[@class='product-menu-nav standards']//a)[1]");
		return driver.findElement(LeftNavClick);
	}

	public static WebElement StandardList_AddToCartBtn() {

		By AddToCartBtn = By.xpath("(//div[@class='cart-container clearfix']//a)[1]");
		return driver.findElement(AddToCartBtn);
	}

	public static WebElement StandardList_AddToCartModalClose() {

		By AddToCartModalClose = By.xpath("(//div[@class='modal-content']//button[@title='Close (Esc)'])[3]");
		return driver.findElement(AddToCartModalClose);
	}

	// Standard Detail Page POM

	public static WebElement StandardDet_StandardViewAllLinkClick() {

		By StandardViewAllLinkClick = By.xpath("(//a[contains(text(),'View all')])[1]");
		return driver.findElement(StandardViewAllLinkClick);
	}

	// Cart Page POM

	public static WebElement CartPage_CartIcon() {

		By CartIcon = By.xpath("//div[@class='shopping-cart']//a");
		return driver.findElement(CartIcon);
	}

	public static WebElement CartPage_CartPageQtyBox() {

		By CartPageQtyBox = By.xpath("(//div[@class='qty']//input)[1]");
		return driver.findElement(CartPageQtyBox);
	}

	public static WebElement CartPage_CartEditQtyUpdate() {

		By CartEditQtyUpdate = By.xpath("(//a[@class='edit-qty'])[2]");
		return driver.findElement(CartEditQtyUpdate);
	}

	public static WebElement CartPage_ProceedCheckout() {

		By ProceedCheckout = By.xpath("(//div[@class='sticky-rightbox-fixed']//a)[1]");
		return driver.findElement(ProceedCheckout);
	}

	// Order Checkout Page POM

	public static WebElement OrderCheckout_SelectPaymentBox() {

		By SelectPaymentBox = By.xpath("//div[@class='step-subsection ccf-box']//div[@class='row']");
		return driver.findElement(SelectPaymentBox);
	}

	public static WebElement OrderCheckout_CheckBillingAddress() {

		By CheckBillingAddress = By.xpath("//div[@class='step-subsection last']");
		return driver.findElement(CheckBillingAddress);
	}

	public static WebElement OrderCheckout_OpenBillingAddressDropdown() {

		By OpenBillingAddressDropdown = By.xpath("//div[@class='predictive-dropdown-arrow']");
		return driver.findElement(OpenBillingAddressDropdown);
	}

	public static WebElement OrderCheckout_SelectBillingAddressValue() {

		By SelectBillingAddressValue = By.xpath("//div[@class='predictive-quickfind-container']//li[1]");
		return driver.findElement(SelectBillingAddressValue);
	}

	public static WebElement OrderCheckout_SaveBtn() {

		By SaveBtn = By.xpath("//a[contains(text(),'Save & Continue')]");
		return driver.findElement(SaveBtn);
	}

	public static WebElement OrderCheckout_SelectAddress() {

		By SelectAddress = By.xpath("(//div[@class='multiselect-address']//ul//li)[1]");
		return driver.findElement(SelectAddress);
	}

	public static WebElement OrderCheckout_UseThisAddressBtn() {

		By UseThisAddressBtn = By.xpath("//a[contains(text(),'Use This Address')]");
		return driver.findElement(UseThisAddressBtn);
	}

	public static WebElement OrderCheckout_TotalLItem() {

		By TotalLItem = By.xpath("//form[@id='standardLineFields']");
		return driver.findElement(TotalLItem);
	}

	public static WebElement OrderCheckout_CustomMessage() {

		By CustomMessage = By.xpath("(//div[@class='fourcolumns']//div)[1]");
		return driver.findElement(CustomMessage);
	}

	public static WebElement OrderCheckout_CustomBox() {

		By CustomBox = By.xpath("//form[@id='standardLineFields']");
		return driver.findElement(CustomBox);
	}

	public static WebElement OrderCheckout_CustomLabelMessage() {

		By CustomLabelMessage = By.xpath("(//div[@class='fourcolumns']//div//label)[1]");
		return driver.findElement(CustomLabelMessage);
	}

	public static WebElement OrderCheckout_Attention() {

		By Attention = By.xpath("(//input[@type='text'])[1]");
		return driver.findElement(Attention);
	}

	public static WebElement OrderCheckout_SendEmailConfirmation() {

		By SendEmailConfirmation = By.id("tbEmailConfirmation");
		return driver.findElement(SendEmailConfirmation);
	}

	public static WebElement OrderCheckout_PlaceOrderBtn() {

		By PlaceOrderBtn = By.xpath("(//a[contains(text(),'Place Order')])[1]");
		return driver.findElement(PlaceOrderBtn);
	}

	public static WebElement OrderCheckout_ErrorOopsBox() {

		By ErrorOopsBox = By.xpath("//div[@class='modal-dialog']//span");
		return driver.findElement(ErrorOopsBox);
	}

	public static WebElement OrderCheckout_ErrorCloseBtn() {

		By ErrorCloseBtn = By.xpath("//button[@class='btn btn-default']");
		return driver.findElement(ErrorCloseBtn);
	}

	public static WebElement OrderCheckout_ClickLogoImage() {

		By ClickLogoImage = By.xpath("//img[@class='logo']");
		return driver.findElement(ClickLogoImage);
	}

	// Quote Checkout POM

	public static WebElement QuotesCheckout_FavSelectAll() {

		By FavSelectAll = By.xpath("//div[@class='left']//div[@class='select-all-col']");
		return driver.findElement(FavSelectAll);
	}

	public static WebElement QuotesCheckout_BtnAddSelectedToCart() {

		By BtnAddSelectedToCart = By.xpath("(//div[@class='left']//a)[1]");
		return driver.findElement(BtnAddSelectedToCart);
	}

	public static WebElement QuotesCheckout_ModalBtnCreateQuote() {

		By ModalBtnCreateQuote = By
				.xpath("(//div[@class='modal-content']//div[@class='pull-left cart-modal-btns']//a)[1]");
		return driver.findElement(ModalBtnCreateQuote);
	}

	public static WebElement QuotesCheckout_SelectPaymentMethod() {

		By SelectPaymentMethod = By.xpath("//div[@class='step-subsection ccf-box']//div[@class='row']");
		return driver.findElement(SelectPaymentMethod);
	}

	public static WebElement QuotesCheckout_SelectBillingAddress() {

		By SelectBillingAddress = By.xpath("//div[@class='step-subsection last']");
		return driver.findElement(SelectBillingAddress);
	}

	public static WebElement QuotesCheckout_SelectBillingArrow() {

		By SelectBillingArrow = By.xpath("//div[@class='predictive-dropdown-arrow']");
		return driver.findElement(SelectBillingArrow);
	}

	public static WebElement QuotesCheckout_SelectBillingDrpSelected() {

		By SelectBillingDrpSelected = By.xpath("(//div[@class='predictive-quickfind-container']//ul//li)[1]");
		return driver.findElement(SelectBillingDrpSelected);
	}

	public static WebElement QuotesCheckout_SaveBtn() {

		By SaveBtn = By.xpath("//a[contains(text(),'Save & Continue')]");
		return driver.findElement(SaveBtn);
	}

	public static WebElement QuotesCheckout_SelectAddress() {

		By SelectAddress = By.xpath("(//div[@class='multiselect-address']//ul//li)[1]");
		return driver.findElement(SelectAddress);
	}

	public static WebElement QuotesCheckout_UseThisAddressBtn() {

		By UseThisAddressBtn = By.xpath("//a[contains(text(),'Use This Address')]");
		return driver.findElement(UseThisAddressBtn);
	}

	public static WebElement QuotesCheckout_CustomMessage() {

		By CustomMessage = By.xpath("(//div[@class='fourcolumns']//div)[1]");
		return driver.findElement(CustomMessage);
	}

	public static WebElement QuotesCheckout_CustomLabelMessage() {

		By CustomLabelMessage = By.xpath("(//div[@class='fourcolumns']//div//label)[1]");
		return driver.findElement(CustomLabelMessage);
	}

	public static WebElement QuotesCheckout_TotalLineItems() {

		By TotalLineItems = By.xpath("//form[@id='standardLineFields']");
		return driver.findElement(TotalLineItems);
	}

	public static WebElement QuotesCheckout_Attention() {

		By Attention = By.xpath("(//input[@type='text'])[1]");
		return driver.findElement(Attention);
	}

	public static WebElement QuotesCheckout_SendEmailConfirmation() {

		By SendEmailConfirmation = By.id("tbEmailConfirmation");
		return driver.findElement(SendEmailConfirmation);
	}

	public static WebElement QuotesCheckout_CreateQuoteBtn() {

		By CreateQuoteBtn = By.xpath("(//a[contains(text(),'Create Quote')])[1]");
		return driver.findElement(CreateQuoteBtn);
	}

	public static WebElement QuotesCheckout_ErrorOopsBox() {

		By ErrorOopsBox = By.xpath("//div[@class='modal-dialog']//span");
		return driver.findElement(ErrorOopsBox);
	}

	public static WebElement QuotesCheckout_ErrorCloseBtn() {

		By ErrorCloseBtn = By.xpath("//button[@class='btn btn-default']");
		return driver.findElement(ErrorCloseBtn);
	}

	public static WebElement QuotesCheckout_ClickLogoImage() {

		By ClickLogoImage = By.xpath("//img[@class='logo']");
		return driver.findElement(ClickLogoImage);
	}

	public static WebElement QuotesCheckout_CustomTextBoxes() {

		By CustomTextBoxes = By.xpath("//form[@id='standardLineFields']");
		return driver.findElement(CustomTextBoxes);
	}

	// Track Dashboard Page POM

	public static WebElement TrackDashboard_TrackNavClick() {

		By TrackNavClick = By.xpath("(//div[@class='homepage-nav-item-container']//a)[2]");
		return driver.findElement(TrackNavClick);
	}

	public static WebElement TrackDashboard_BtnBuyItemsAgain() {

		By BtnBuyItemsAgain = By.xpath("(//div[@class='accordion-content clearfix active']//a)[2]");
		return driver.findElement(BtnBuyItemsAgain);
	}

	public static WebElement TrackDashboard_QuickFinderSearch() {

		By QuickFinderSearch = By.xpath("//input[@class='quick-search']");
		return driver.findElement(QuickFinderSearch);
	}

	public static WebElement TrackDashboard_CloseBtnAddToCart() {

		By CloseBtnAddToCart = By.xpath("(//div[@class='modal-content']//button[@title='Close (Esc)'])[6]");
		return driver.findElement(CloseBtnAddToCart);
	}

	// Track Search Result Page POM

	public static WebElement TrackSearch_LoadMoreBtn() {

		By LoadMoreBtn = By.xpath("//div[@class='row order-footer-controls']//button");
		return driver.findElement(LoadMoreBtn);
	}

	public static WebElement TrackSearch_BtnQuotes() {

		By BtnQuotes = By.xpath("(//Section[@id='order-top']//span)[2]");
		return driver.findElement(BtnQuotes);
	}

	public static WebElement TrackSearch_BtnAssets() {

		By BtnAssets = By.xpath("(//Section[@id='order-top']//span)[3]");
		return driver.findElement(BtnAssets);
	}

	public static WebElement TrackSearch_BtnShipments() {

		By BtnShipments = By.xpath("(//Section[@id='order-top']//span)[4]");
		return driver.findElement(BtnShipments);
	}

	public static WebElement TrackSearch_CheckTotalCount() {

		By CheckTotalCount = By.xpath("//div[@class='search-matching-container']//p");
		return driver.findElement(CheckTotalCount);
	}

	// Calendars Page POM

	public static WebElement Calendars_CalendarDetailView() {

		By CalendarDetailView = By.xpath("//span[contains(text(),'Detail view')]");
		return driver.findElement(CalendarDetailView);
	}

	public static WebElement Calendars_CalendarNavClick() {

		By CalendarNavClick = By.xpath("(//ul[@class='section-nav-item-container track']//a)[1]");
		return driver.findElement(CalendarNavClick);
	}

	// Purchase Analysis Page POM

	public static WebElement Purchase_purchasenavclick() {

		By purchasenavclick = By.xpath("(//ul[@class='section-nav-item-container track']//a)[5]");
		return driver.findElement(purchasenavclick);
	}

	public static WebElement Purchase_EmailIconClick() {

		By EmailIconClick = By.xpath("(//span[@class='product-list-actions']/a)[2]");
		return driver.findElement(EmailIconClick);
	}

	public static WebElement Purchase_EmailAddress() {

		By EmailAddress = By.id("email_addresses");
		return driver.findElement(EmailAddress);
	}

	public static WebElement Purchase_EmailSendBtn() {

		By EmailSendBtn = By.xpath("//button[@class='btn btn-primary']");
		return driver.findElement(EmailSendBtn);
	}

	// Saved Report Page POM

	public static WebElement SavedReport_LinkSavedReport() {

		By LinkSavedReport = By.linkText("Saved Reports");
		return driver.findElement(LinkSavedReport);
	}

	public static WebElement SavedReport_ScheduleModal() {

		By ScheduleModal = By.xpath("(//a[@class='saved-calendar'])[1]");
		return driver.findElement(ScheduleModal);
	}

	public static WebElement SavedReport_ScheduleEmailAddress() {

		By ScheduleEmailAddress = By.xpath("(//input[@name='email'])[1]");
		return driver.findElement(ScheduleEmailAddress);
	}

	public static WebElement SavedReport_BtnScheduleReport() {

		By BtnScheduleReport = By.xpath("(//button[@class='btn btn-primary'])[1]");
		return driver.findElement(BtnScheduleReport);
	}

	// Order Listing Page POM

	public static WebElement Orders_OrdersNavClick() {

		By OrdersNavClick = By.xpath("(//ul[@class='section-nav-item-container track']//a)[3]");
		return driver.findElement(OrdersNavClick);
	}

	public static WebElement Orders_BtnLoadMore() {

		By BtnLoadMore = By.id("load-more-link");
		return driver.findElement(BtnLoadMore);
	}

	public static WebElement Orders_OrderBuyItemAgain() {

		By OrderBuyItemAgain = By.xpath("(//div[@class='action-area clearfix']//a)[1]");
		return driver.findElement(OrderBuyItemAgain);
	}

	public static WebElement Orders_CartModalClose() {

		By CartModalClose = By.xpath("(//div[@class='modal-content']/button[@title='Close (Esc)'])[1]");
		return driver.findElement(CartModalClose);
	}

	public static WebElement Orders_OrdersTimePeriod() {

		By OrdersTimePeriod = By.xpath("//select[@title='Select Time Period']");
		return driver.findElement(OrdersTimePeriod);
	}

	// Quotes Listing Page POM

	public static WebElement Quotes_QuotesNavClick() {

		By QuotesNavClick = By.xpath("(//ul[@class='section-nav-item-container track']//a)[4]");
		return driver.findElement(QuotesNavClick);
	}

	public static WebElement Quotes_BtnLoadMore() {

		By BtnLoadMore = By.id("load-more-link");
		return driver.findElement(BtnLoadMore);
	}

	public static WebElement Quotes_QuotesTimePeriod() {

		By QuotesTimePeriod = By.xpath("//select[@title='Select Time Period']");
		return driver.findElement(QuotesTimePeriod);
	}

	// All Reports POM

	public static WebElement Reports_ReportsNav() {

		By ReportsNav = By.xpath("(//ul[@class='section-nav-item-container track']//a)[2]");
		return driver.findElement(ReportsNav);
	}

	public static WebElement Reports_AssetsNavLink() {

		By AssetsNavLink = By.linkText("Assets");
		return driver.findElement(AssetsNavLink);
	}

	public static WebElement Reports_DaysShipNavLink() {

		By DaysShipNavLink = By.linkText("Days to Ship");
		return driver.findElement(DaysShipNavLink);
	}

	public static WebElement Reports_ExpirationNavLink() {

		By ExpirationNavLink = By.linkText("Expiration");
		return driver.findElement(ExpirationNavLink);
	}

	public static WebElement Reports_InventoryNavLink() {

		By InventoryNavLink = By.linkText("Inventory");
		return driver.findElement(InventoryNavLink);
	}

	public static WebElement Reports_InvoicesNavLink() {

		By InvoicesNavLink = By.linkText("Invoices");
		return driver.findElement(InvoicesNavLink);
	}

	public static WebElement Reports_InvoiceLineNavLink() {

		By InvoicesNavLink = By.linkText("Invoice Line");
		return driver.findElement(InvoicesNavLink);
	}

	public static WebElement Reports_LicensesNavLink() {

		By LicensesNavLink = By.linkText("Licenses");
		return driver.findElement(LicensesNavLink);
	}

	public static WebElement Reports_OrdersNavLink() {

		By OrdersNavLink = By.xpath("(//div[@data-submenu-id='reports']//a)[8]");
		return driver.findElement(OrdersNavLink);
	}

	public static WebElement Reports_OrderLineNavLink() {

		By OrderLineNavLink = By.linkText("Order Line");
		return driver.findElement(OrderLineNavLink);
	}

	public static WebElement Reports_QuotesNavLink() {

		By QuotesNavLink = By.xpath("(//div[@data-submenu-id='reports']//a)[10]");
		return driver.findElement(QuotesNavLink);
	}

	public static WebElement Reports_ReceivingLogNavLink() {

		By ReceivingLogNavLink = By.linkText("Receiving Log");
		return driver.findElement(ReceivingLogNavLink);
	}

	public static WebElement Reports_ShipmentsNavLink() {

		By ShipmentsNavLink = By.linkText("Shipments");
		return driver.findElement(ShipmentsNavLink);
	}

	public static WebElement Reports_StandardsNavLink() {

		By StandardsNavLink = By.linkText("Standards");
		return driver.findElement(StandardsNavLink);
	}

	public static WebElement Reports_WarrantiesNavLink() {

		By WarrantiesNavLink = By.linkText("Warranties");
		return driver.findElement(WarrantiesNavLink);
	}

	public static WebElement Reports_EmailIconClick() {

		By EmailIconClick = By.xpath("(//span[@class='product-list-actions']//a)[1]");
		return driver.findElement(EmailIconClick);
	}

	public static WebElement Reports_EmailAddress() {

		By EmailAddress = By.id("email_addresses");
		return driver.findElement(EmailAddress);
	}

	public static WebElement Reports_EmailSendBtn() {

		By EmailSendBtn = By
				.xpath("//div[@class='white-popup popup-small zoom-anim-dialog mfp-show email-modal']//button[1]");
		return driver.findElement(EmailSendBtn);
	}

	// All Footers Page

	public static WebElement Footers_HoverTopMyAccount() {

		By HoverTopMyAccount = By.xpath("//a[@class='clearfix']");
		return driver.findElement(HoverTopMyAccount);
	}

	public static WebElement Footers_MyProfile() {

		By MyProfile = By.xpath("(//div[@class='account-menu']//a)[1]");
		return driver.findElement(MyProfile);
	}

	public static WebElement Footers_ShippingAddress() {

		By ShippingAddress = By.xpath("(//div[@class='account-menu']//a)[2]");
		return driver.findElement(ShippingAddress);
	}

	public static WebElement Footers_FooterAllproducts() {

		By FooterAllproducts = By.xpath("(//div[@class='footer-top-right clearfix']//a)[3]");
		return driver.findElement(FooterAllproducts);
	}

	public static WebElement Footers_FooterResources() {

		By FooterResources = By.xpath("(//div[@class='footer-top-right clearfix']//a)[4]");
		return driver.findElement(FooterResources);
	}

	public static WebElement Footers_FooterSpecialOffers() {

		By FooterSpecialOffers = By.xpath("(//div[@class='footer-top-right clearfix']//a)[5]");
		return driver.findElement(FooterSpecialOffers);
	}

	public static WebElement Footers_FooterAboutUs() {

		By FooterAboutUs = By.xpath("(//div[@class='footer-top-right clearfix']//a)[13]");
		return driver.findElement(FooterAboutUs);
	}

	public static WebElement Footers_FooterContactUs() {

		By FooterContactUs = By.xpath("(//div[@class='footer-top-right clearfix']//a)[14]");
		return driver.findElement(FooterContactUs);
	}

	public static WebElement Footers_FooterCustomerSupport() {

		By FooterCustomerSupport = By.xpath("(//div[@class='footer-top-right clearfix']//a)[15]");
		return driver.findElement(FooterCustomerSupport);
	}

	public static WebElement Footers_FooterTermsOfSale() {

		By FooterTermsOfSale = By.xpath("(//div[@class='footer-top-right clearfix']//a)[16]");
		return driver.findElement(FooterTermsOfSale);
	}

	public static WebElement Footers_FooterPrivacyPolicy() {

		By FooterPrivacyPolicy = By.xpath("(//div[@class='footer-top-right clearfix']//a)[17]");
		return driver.findElement(FooterPrivacyPolicy);
	}

	public static WebElement Footers_FooterAccessibility() {

		By FooterAccessibility = By.xpath("(//div[@class='footer-top-right clearfix']//a)[18]");
		return driver.findElement(FooterAccessibility);
	}

	public static WebElement Footers_FooterHelp() {

		By FooterHelp = By.xpath("(//div[@class='footer-top-right clearfix']//a)[19]");
		return driver.findElement(FooterHelp);
	}
}
