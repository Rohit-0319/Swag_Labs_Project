package com.SwagLabs.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.SwagLabs.Pages.AddToCart;
import com.SwagLabs.Pages.CheckOut;
import com.SwagLabs.Pages.LogOut;
import com.SwagLabs.Pages.LoginPage;
import com.SwagLabs.utility.LoggerUtil;

public class BaseClass {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected LoginPage login;
	protected AddToCart addtocart;
	protected CheckOut checkout;
	protected LogOut logout;
	protected Properties props;
	protected Logger log = LoggerUtil.getLogger(this.getClass());

	@BeforeClass
	public void setup() throws IOException {

		log.info("Initializing test setup");
		props = new Properties();
//		String configPath = "C:\\Users\\rohit_tdspg61\\eclipse-workspace\\SwagLabs\\src\\test\\resources\\config.Properties";
		String configPath = System.getProperty("user.dir") + "/src/test/resources/config.Properties";
		
		log.info("Loading config properties");
		FileInputStream fins = new FileInputStream(configPath);

		props.load(fins);

		String browser = props.getProperty("browserType");
		log.info("Launching browser");
		switch (browser) {
		case "chrome":

			ChromeOptions options = new ChromeOptions();

			// This code is to disable chrome popup for "change your password".
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-save-password-bubble");
			options.addArguments("--disable-infobars");
			options.setExperimentalOption("prefs",
					Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));

			// Run test cases in incognito
			options.addArguments("--incognito");

			driver = new ChromeDriver(options);
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			throw new RuntimeException("This browser is not supported " + browser);
		}

		driver.get(props.getProperty("url"));
		log.info("Navigated to URL: {}", props.getProperty("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();

		login = new LoginPage(driver, wait);
		logout = new LogOut(driver, wait);
		addtocart = new AddToCart(driver, wait);
		checkout = new CheckOut(driver, wait);

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	
	// Screenshot utility (framework-level)
	public String captureScreenshot(String testName) {

		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String screenshotPath = System.getProperty("user.dir") + "/reports/screenshots/" + testName + "_" + timestamp
				+ ".png";

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File trgt = new File(screenshotPath);
			FileUtils.copyFile(src, trgt);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshotPath;
	}
}
