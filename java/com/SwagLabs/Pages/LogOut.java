package com.SwagLabs.Pages;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SwagLabs.utility.LoggerUtil;

public class LogOut {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
	WebElement threeDot;

	@FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
	WebElement LogoutBtn;

	public LogOut(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	Logger log = LoggerUtil.getLogger(LogOut.class);
	
	public void logouts() {

		log.info("Clicking Burger Buttons.");
		threeDot.click();
		wait.until(ExpectedConditions.visibilityOf(LogoutBtn));
		log.info("Clicking Logout options.");
		LogoutBtn.click();
	}

}
