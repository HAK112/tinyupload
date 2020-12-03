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

public class DeleteFile {
	WebDriver driver;
	
	//Delete Button Webelement
	@FindBy(xpath = "//img[@alt='Delete']")
	WebElement deleteFileButton;
	
	//Delete Page Header
	@FindBy(xpath = "//h3[contains(text(),'Delete file')]")
	WebElement deleteFileHeader;
	
	//Delete Page Downlload File WebElement
	@FindBy(xpath = "//a[starts-with(@href,'download.php')]")
	WebElement fileToBeDeletedElement;
		
	//Page Result Verification for you have landed or not
	String deletePageExpectedResult;
	
	//Constructor
	public DeleteFile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Getting Page URL for Delete Page
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	//Getting File name of the file to be deleted
	public String getFileNameToBeDeleted() {
		return fileToBeDeletedElement.getText();
	}
	
	//Page Result Verification getter
	public String getExpectedPageResultVerification() {
		return deletePageExpectedResult;
	}
	
	//Page Result Verification setter
	public void setExpectedPageResultVerification(String expectedResult) {
		deletePageExpectedResult = expectedResult;
	}
	
	//Getting Page header of Delete Page
	public String getDeletePageHeader() {
		isLoaded(deleteFileHeader);
		return deleteFileHeader.getText();
	}
	
	//Getting download link to download the file
	public String getDownloadFileLink() {
		return fileToBeDeletedElement.getAttribute("href");
	}
		
	//Clicking the delete button to delete the file
	public void clickDeleteFileButton() {
		isLoaded(deleteFileButton);
		deleteFileButton.click();
		System.out.println("Delete File Button Clicked");
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
