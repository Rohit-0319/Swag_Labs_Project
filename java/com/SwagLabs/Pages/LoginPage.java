package com.SwagLabs.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SwagLabs.utility.LoggerUtil;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(name = "user-name")
	WebElement Uid_WE;

	@FindBy(name = "password")
	WebElement Password_WE;

	@FindBy(name = "login-button")
	WebElement loginBtn_WE;

	@FindBy(name = "btnReset")
	WebElement Reset_Btn_WE;

	@FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
	WebElement threeDot;

	@FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
	WebElement LogoutBtn;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public String LoginTitleCheck() {
		return driver.getTitle();
	}

	Logger log = LoggerUtil.getLogger(LoginPage.class);
	
	public void loging(String userId, String password) {

		Uid_WE.clear();
		log.info("Entering username");
		Uid_WE.sendKeys(userId);
		Password_WE.clear();
		log.info("Entering password");
		Password_WE.sendKeys(password);
		log.info("Clicking login button");
		loginBtn_WE.click();

	}
}
