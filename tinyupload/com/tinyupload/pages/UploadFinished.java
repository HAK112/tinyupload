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

public class UploadFinished {
	WebDriver driver;

	//Link to download page
	@FindBy(xpath = "//a[contains(text(),'file_id')]")
	WebElement fileDownloadLink;
	
	//Link to delete page
	@FindBy(xpath = "//a[contains(text(),'del_id')]")
	WebElement fileDeleteLink;

	//Page Result Verification for you have landed or not
	String uploadFinishedPageExpectedResult;
	String deleteFileLink;
	String downloadFileLink;
	
	//Constructor
	public UploadFinished(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void setDeleteFileLink() {
		deleteFileLink = getURLDeleteLink();
	}
	
	public void setDownloadFileLink() {
		deleteFileLink = getURLDownloadLink();
	}
	
	public String getDeleteFileLink() {
		return deleteFileLink;
	}
	
	public String getDownloadFileLink() {
		return deleteFileLink;
	}

	//Page Result Verification getter
	public String getExpectedPageResult() {
		return uploadFinishedPageExpectedResult;
	}
	
	//Page Result Verification setter
	public void setExpectedPageResult(String expectedResult) {
		uploadFinishedPageExpectedResult = expectedResult;
	}
	
	//Clicking the link to access the download page
	public void clickDownloadLink() {
		isLoaded(fileDownloadLink);
		System.out.println("Clicking the Download Link");
		fileDownloadLink.click();
		System.out.println("You are now accessing the Download Page");
	}
	
	//Getting the download link url
	public String getURLDownloadLink() {
		isLoaded(fileDownloadLink);
		return fileDownloadLink.getAttribute("href");
}
	
	public String getURLDeleteLink() {
		isLoaded(fileDownloadLink);
		return fileDownloadLink.getAttribute("href");
}
	//Clicking the delete link url
	public void clickDeleteLink() {
		isLoaded(fileDeleteLink);
		System.out.println("Clicking the Delete Link");
		fileDeleteLink.click();
		System.out.println("You are now accessing the Delete Page");
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
