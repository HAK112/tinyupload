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

import com.utility.FileHandler;

public class HomePageTinyUpload {
	WebDriver driver;
	FileHandler file;
	
	//Choose File Button
	@FindBy(name="uploaded_file")
	WebElement chooseFileButton;
	
	//Upload File Button
	@FindBy(xpath="//img[@alt='Upload']")
	WebElement uploadFileButton;
	
	//Page Result Verification for you have landed or not
	String homePagePageExpectedResult;
	
	//Constructor
	public HomePageTinyUpload(WebDriver driver) {
		this.driver = driver;
		file = new FileHandler(driver);
		PageFactory.initElements(driver, this);
	}	
	
	//Page Result Verification getter
	public String getExpectedPageResult() {
		return homePagePageExpectedResult;
	}
	
	//Page Result Verification setter
	public void setExpectedPageResult(String expectedResult) {
		homePagePageExpectedResult = expectedResult;
	}
	
	//Uses the filehandler class to choose the file and then clicks the Upload Button
	public void clickUploadButtonAndUploadFile(String filetoUpload) {
		isLoaded(chooseFileButton);
		file.uploadFile(chooseFileButton,filetoUpload);
	}
	
	//Clicks the upload file button
	public void clickUploadFile() {
		uploadFileButton.click();
		System.out.println("Upload File Button Clicked");
	}

	//Return the Title of the Page
	public String getPageTitle() {
		return driver.getTitle();
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
