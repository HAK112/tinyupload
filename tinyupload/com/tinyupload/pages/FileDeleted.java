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

public class FileDeleted {
	WebDriver driver;
	
	//Deleted File Heading webelement
	@FindBy(xpath = "//h3[contains(text(),'Delete file')]")
	WebElement deletedFileHeading;
	
	//Page Result Verification for you have landed or not
	String fileDeletedPageExpectedResult;
	
	//Constructor
	public FileDeleted(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}

	//Page Result Verification getter
	public String getExpectedPageResult() {
		return fileDeletedPageExpectedResult;
	}
	
	//Page Result Verification setter
	public void setExpectedPageResult(String expectedResult) {
		fileDeletedPageExpectedResult = expectedResult;
	}
	
	//Getting the header text for verification
	public String getHeadingText() {
		return deletedFileHeading.getText();
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
