package com.SwagLabs.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SwagLabs.utility.LoggerUtil;

public class CheckOut {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
	WebElement CartIcon;

	@FindBy(xpath = "//*[@id=\"checkout\"]")
	WebElement checkoutBtn;

	@FindBy(xpath = "//*[@id=\"first-name\"]")
	WebElement FirstName;

	@FindBy(xpath = "//*[@id=\"last-name\"]")
	WebElement LastName;

	@FindBy(xpath = "//*[@id=\"postal-code\"]")
	WebElement PostalCode;

	@FindBy(xpath = "//*[@id=\"continue\"]")
	WebElement ContinueBtn;

	@FindBy(xpath = "//*[@id=\"finish\"]")
	WebElement FinishBtn;

	@FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
	WebElement OrderConfirmation;

	public CheckOut(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	// For log4j2 logs
	Logger log = LoggerUtil.getLogger(CheckOut.class);

	public void completeCheckout() {
		log.info("Clicking on cart Button.");
		CartIcon.click();

		log.info("Clicking on checkout button.");
		checkoutBtn.click();

		log.info("Entering first name.");
		FirstName.clear();
		FirstName.sendKeys("Rohit");

		log.info("Entering last name.");
		LastName.clear();
		LastName.sendKeys("sir");;

		log.info("Entering Postal code.");
		PostalCode.clear();
		PostalCode.sendKeys("789456");;

		log.info("clicking continue Button.");
		ContinueBtn.click();

		log.info("Clicking Finish Button to confirm order.");
		FinishBtn.click();

	}
	
	public String getConfirmationText() {
		return OrderConfirmation.getText();
	}

}
