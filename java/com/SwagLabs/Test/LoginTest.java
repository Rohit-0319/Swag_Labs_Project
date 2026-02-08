package com.SwagLabs.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SwagLabs.Base.BaseClass;
import com.SwagLabs.utility.ExcelUtility;

public class LoginTest extends BaseClass {

	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException {
		String excelPathFromConfig = props.getProperty("ExcelFilePath");
	    return ExcelUtility.excelData(excelPathFromConfig);
	}
	

	@Test
	public void titlechk() {
		String actualTitle = login.LoginTitleCheck();
		Assert.assertEquals(actualTitle, props.getProperty("LoginTitle"));
	}

	@Test(dataProvider = "loginData")
	public void loginWithUser(String username, String password) {
		
		login.loging(username, password);
		logout.logouts();
	}

}
