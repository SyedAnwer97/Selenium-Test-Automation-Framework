package com.gpn.test;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.gpn.pages.AlfaDOCKCustomerLoginPage;

import utils.DataProviderUtils;

public final class LoginTest extends BaseTest {

	private LoginTest() {}

	@Test(enabled = true)
	public void alfaDOCKLoginTest(Map<String, String> data) throws Exception {
		String pageTitle =new AlfaDOCKCustomerLoginPage().selectLangauge("English").enterCustomerUsername(data.get("customerName"))
		.enterCustomerPassword(data.get("customerPassword")).clickLoginButton().enterUsername(data.get("username"))
		.enterUserPassword(data.get("userPassword")).clickLogin().clickAlfaDOCKLogoutButton().clickUserLogout().pageTitle();
		Assertions.assertThat(pageTitle).isEqualTo("Company Login");
	}
}
