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

		By AddToCartModalClose = By.xpath("(//div[@class='modal-content']/button[@title='Close (Esc)'])[2]");
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

		By AddToCartModalClose = By.xpath("(//div[@class='modal-content']//button[@title='Close (Esc)'])[2]");
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

	

	
	
	

}
