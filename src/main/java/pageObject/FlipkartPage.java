package pageObject;

import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FlipkartPage {


	public AndroidDriver<AndroidElement> driver;	

	By search=By.id("com.flipkart.android:id/search_widget_textbox");
	By searchProductName=By.id("com.flipkart.android:id/search_autoCompleteTextView");
	By addToCart=By.xpath("//android.widget.TextView[contains(@text,'ADD TO CART')]");
	By goToCart=By.xpath("//android.widget.TextView[contains(@text,'SKIP & GO TO CART')]");

	public FlipkartPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}

	//Search product in Text Box
	public void setSearch(String strSearch) {

		driver.findElement(search).click();
		driver.findElement(searchProductName).sendKeys(strSearch);
		driver.findElement(By.id("com.flipkart.android:id/txt_title")).click();
		System.out.println("Product searched successfully");
	}

	//Add product to the cart
	public void clickAddCart() {

		MobileElement el1 = (MobileElement) driver.findElementByXPath("(//android.view.ViewGroup)[1]");
		el1.click();
		driver.findElement(addToCart).click();
		System.out.println("Product added to cart");
		driver.findElement(goToCart).click();

	}

	//Methods for Flipkart application
	public void FlipkartApplication(String strSearch) {

		this.setSearch(strSearch);
		this.clickAddCart();
	}

}