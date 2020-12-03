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

public class FileUploadProgress {
	WebDriver driver;
	
	//Header of file upload progress page
	@FindBy(xpath = "//strong[text()='File upload finished']")
	WebElement fileUploadFinishedHeader;
	
	//Close button of file upload progress page
	@FindBy(xpath = "//a[text()='Close']")
	WebElement close;
	
	//Page Result Verification for you have landed or not
	String fileUploadProgressPageExpectedResult;
	
	//Constructor
	public FileUploadProgress(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	////Page Result Verification getter
	public String getExpectedPageResult() {
		return fileUploadProgressPageExpectedResult;
	}
	
	//Page Result Verification setter
	public void setExpectedPageResult(String expectedResult) {
		fileUploadProgressPageExpectedResult = expectedResult;
	}
	
	//Getting the text of the header of file upload progress page
	public String getFileUploadFinishedText() {
		isLoaded(fileUploadFinishedHeader);
		return fileUploadFinishedHeader.getText();
	}
	
	//Clicking to close the newly opened window 
	public void closePage(String winHandleBefore) {
		close.click();
		driver.switchTo().window(winHandleBefore);
		System.out.println("Closing the new window and going back to the main window\n");
	}
	
	//Accessing the required frame which has all the required elements
    public void shiftFrame(int i) {
    	driver.switchTo().frame(i);
    }
        
    //Shifting the focus from the orignal window to the new window 
    public void shiftFocus() {
    	for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
    	System.out.println("Focussing on the new Opened Window");
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