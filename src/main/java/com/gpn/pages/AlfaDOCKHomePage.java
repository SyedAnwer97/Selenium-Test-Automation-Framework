package com.gpn.pages;

import org.openqa.selenium.By;

import com.gpn.enums.WaitStrategy;
import com.gpn.factories.ExplicitWaitFactory;

public final class AlfaDOCKHomePage extends ActionEngine {
	
	private final By iconLogout = By.xpath("//i[@class='fa fa-sign-out fa-2x']");
	
	public AlfaDOCKUserLoginPage clickAlfaDOCKLogoutButton() {
		if(ExplicitWaitFactory.performExplictWait(WaitStrategy.TITLECHANGE, "alfaDOCK")) {
		jsClick(iconLogout, WaitStrategy.NONE, "alfaDOCKLogoutButton");
		}
		return new AlfaDOCKUserLoginPage();
	}

}
