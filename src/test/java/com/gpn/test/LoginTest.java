package com.gpn.test;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.gpn.pages.AlfaDOCKCustomerLoginPage;

public final class LoginTest extends BaseTest {

	private LoginTest() {}

	@Test(enabled = true)
	public void alfaDOCKLoginTest() throws Exception {
		String pageTitle =new AlfaDOCKCustomerLoginPage().selectLangauge("English").enterCustomerUsername("sch-dev")
		.enterCustomerPassword("sch-dev").clickLoginButton().enterUsername("admin")
		.enterUserPassword("admin").clickLogin().clickAlfaDOCKLogoutButton().clickUserLogout().pageTitle();
		Assertions.assertThat(pageTitle).isEqualTo("Company Login");
	}


}
