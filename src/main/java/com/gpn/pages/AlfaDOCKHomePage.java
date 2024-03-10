package com.gpn.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;

public final class AlfaDOCKHomePage extends ActionEngine {
	
	private final By iconLogout = By.xpath("//i[@class='fa fa-sign-out fa-2x']");
	
	public AlfaDOCKUserLoginPage clickAlfaDOCKLogoutButton() {
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
		jsClick(iconLogout);
		return new AlfaDOCKUserLoginPage();
	}

}
