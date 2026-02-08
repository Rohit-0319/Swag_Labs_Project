package com.SwagLabs.Test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SwagLabs.Base.BaseClass;

public class E2E_CheckoutTest extends BaseClass {



	@BeforeMethod
	public void ensureUserIsLoggedI() {

		login.loging("standard_user", "secret_sauce");
	}

	@AfterMethod
	public void cleanup() {
		logout.logouts();
	}

	@Test
	public void e2eCheckoutFlowTest() {

		addtocart.addcart();

		String CartActualTitle = addtocart.CartTitleCheck();
		Assert.assertEquals(CartActualTitle, props.getProperty("ExpectedCartTitle"));

		String cartActualUrl = addtocart.CartCurrentUrl();
		Assert.assertEquals(cartActualUrl, props.getProperty("ExpectedCartUrl"));

		checkout.completeCheckout();
		String ActualOrderConfirmationText = checkout.getConfirmationText();
		Assert.assertEquals(ActualOrderConfirmationText, props.getProperty("orderConfirmationText"));

	}

}
