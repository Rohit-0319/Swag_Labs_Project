package com.SwagLabs.Pages;



import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SwagLabs.utility.LoggerUtil;

public class AddToCart {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath= "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
	WebElement Tshirt;
	
	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
	WebElement jacket;
	
	
	public AddToCart(WebDriver driver, WebDriverWait wait) {
		this.driver= driver;
		this.wait= wait;
		PageFactory.initElements(driver, this);
	}
	
	//For log4j2 logs 
	Logger log = LoggerUtil.getLogger(AddToCart.class);
	
	
	public void addcart() {
		
	wait.until(ExpectedConditions.visibilityOf(Tshirt));
	log.info("Clicking on Tshirt");
	Tshirt.click();
	
	wait.until(ExpectedConditions.visibilityOf(jacket));
	log.info("Clicking on jacket");
	jacket.click();
	
	}
	
	
	public String CartCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	
	public String CartTitleCheck() {
		return driver.getTitle();
	}
	
	
}
