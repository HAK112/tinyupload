package com.tinyupload.pages;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class DownloadFile {
	WebDriver driver;

	//Link to the report page
	@FindBy(xpath = "//a[contains(text(),'Report abuse or copyright infringement')]")
	WebElement reportLink;
	
	//Download page header
	@FindBy(xpath = "//h3[contains(text(),'Download file')]")
	WebElement downloadFileHeading;
	
	//Page Result Verification for you have landed or not
	String downloadFilePageExpectedResult;
	
	//Constructor
	public DownloadFile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Page Result Verification getter
	public String getExpectedPageResult() {
		return downloadFilePageExpectedResult;
	}
	
	//Page Result Verification setter
	public void setExpectedPageResult(String expectedResult) {
		downloadFilePageExpectedResult = expectedResult;
	}
	
	//Getting the page header
	public String getDownloadFileHeader() {
		isLoaded(downloadFileHeading);
		return downloadFileHeading.getText();
	}
	
	//clicking the link To access the report page 
	public void clickReportButton() {
		isLoaded(reportLink);
		System.out.println("Clicking on Report Button");
		reportLink.click();		
		System.out.println("You are now accessing the Report and Copyright Infringement Page");		
	}	
	
	//To check the element exists or not and using Fluent Wait to check for 30 sec max at the intervals of 1 sec
	@SuppressWarnings("deprecation")
	public void isLoaded(WebElement element) throws Error {
		new FluentWait<WebDriver>(driver)
		.withTimeout(30, TimeUnit.SECONDS)
		.pollingEvery(1, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				return element != null && element.isDisplayed();
			}
		});
	}
}
