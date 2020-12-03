package com.tinyupload.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tinyupload.pages.DeleteFile;
import com.tinyupload.pages.DownloadFile;
import com.tinyupload.pages.FileDeleted;
import com.tinyupload.pages.FileUploadProgress;
import com.tinyupload.pages.HomePageTinyUpload;
import com.tinyupload.pages.ReportAndCopyright;
import com.tinyupload.pages.UploadFinished;
import com.tinyupload.tests.deletefile.sanity.TS_DF_02;
import com.tinyupload.tests.deletefile.sanity.TS_DF_14;
import com.tinyupload.tests.deletefile.sanity.TS_DF_16;
import com.tinyupload.tests.deletefile.sanity.TS_DF_17;
import com.tinyupload.tests.deletefile.sanity.TS_DF_21;
import com.tinyupload.tests.deletefile.smoke.TS_DF_01;
import com.tinyupload.tests.deletefile.smoke.TS_DF_11;
import com.tinyupload.tests.deletefile.smoke.TS_DF_12;
import com.tinyupload.tests.deletefile.smoke.TS_DF_15;
import com.tinyupload.tests.deletefile.smoke.TS_DF_18;
import com.tinyupload.tests.reportfile.smoke.TS_FR_NF_01;

public class Navigator {
	
	//Variables Declaration
	//Protected elements can be accessed by the class child
	
	//for shifting focus from one window to another window
	String orignalFocus = "";
	String driverPath = "resource//drivers//chromedriver.exe//";
	
	protected String fileName = "logo.png";
	protected String webSiteUrl = "http://tinyupload.com/";
    
	protected WebDriver driver;
    
	//Object Creation for pages
    protected HomePageTinyUpload homePage;
    protected FileUploadProgress fileUploadProgressPage;
    protected UploadFinished uploadFinishedPage;
    protected DownloadFile downloadFilePage;
    protected ReportAndCopyright reportAndCopyrightPage;
    protected DeleteFile deleteFilePage;
    protected FileDeleted fileDeletedPage;
    
    public Navigator(){
    	System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    public void naviToWebsite() {
    	System.out.println("\nNavigating to: "+webSiteUrl);
    	driver.get(webSiteUrl);
    }
    
    public void tearDown() {
    	driver.quit();
    }
    
    //For shifting the focus from one window to another window
    public String getWinHandle() {
    	return driver.getWindowHandle();
    }    
    
    //Verifier with Contians method
    public boolean verifyResultContains(String actualResult, String expectedResult) {
    	System.out.println("Actual Result: " +actualResult);
    	System.out.println("Expected Result: " +expectedResult);
    	if(!actualResult.contains(expectedResult)) {
    		System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
    		return false;
    	};
    	return true;
    }
    
    //Verifier with Equals Method
    public boolean verifyResultEquals(String actualResult, String expectedResult) {
    	System.out.println("Actual Result: " +actualResult);
    	System.out.println("Expected Result: " +expectedResult);
    	if(!actualResult.equals(expectedResult)) {
    		System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
    		return false;
    	};
    	return true;
    }
    
    //Navigator to Report Page
    public boolean navigateToReportAndCopyrightPage()  {
    	this.naviToWebsite();
    	homePage = new HomePageTinyUpload(driver);
    	fileUploadProgressPage = new FileUploadProgress(driver);
    	uploadFinishedPage = new UploadFinished(driver);
    	deleteFilePage = new DeleteFile(driver);
    	downloadFilePage = new DownloadFile(driver);
    	reportAndCopyrightPage = new ReportAndCopyright(driver);

    	//Verify login page title
    	String loginPageTitle = homePage.getPageTitle();
    	homePage.setExpectedPageResult("TinyUpload.com");
    	if(!verifyResultContains(loginPageTitle, homePage.getExpectedPageResult())) {
    		return false;
    	};
    	System.out.println("You Landed on the Right Page: "+webSiteUrl);
    	System.out.println("\nNavigating to Report and Copyright Page");
    	
    	orignalFocus = this.getWinHandle();
    	
    	homePage.clickUploadButtonAndUploadFile(fileName);
    	homePage.clickUploadFile();
    	
    	fileUploadProgressPage.shiftFocus();
    	System.out.println("Checking for Successfull File Upload");
    	
    	//Comment this later
    	fileUploadProgressPage.shiftFrame(0);
    	
    	//Show Verification of the File Here 
    	fileUploadProgressPage.setExpectedPageResult("File upload finished");
    	if(!verifyResultEquals(fileUploadProgressPage.getFileUploadFinishedText(), fileUploadProgressPage.getExpectedPageResult())) {
    		return false;
     	}
    	System.out.println("File Uploaded Successfully\n");
    	
    	fileUploadProgressPage.closePage(orignalFocus);
    	
    	
    	uploadFinishedPage.clickDownloadLink();
    	
    	downloadFilePage.setExpectedPageResult("Download file");
    	if(!verifyResultEquals(downloadFilePage.getDownloadFileHeader(), downloadFilePage.getExpectedPageResult())){
    		return false;
    	}
    	System.out.println("You are now at File Download Page\n");
    	downloadFilePage.clickReportButton();
    	
    	reportAndCopyrightPage.setExpectedPageResult("Report abuse or copyright infringement");
    	if(!verifyResultEquals(reportAndCopyrightPage.getReportAndCopyrightHeader(), reportAndCopyrightPage.getExpectedPageResult())){
    		return false;
    	}
    	System.out.println("You are now at Report And Copyright Page\n");
    	return true;
    }
    
    
    //Navigating to Delete Page
    public boolean navigateToDeletePage()  {
    	
    	this.naviToWebsite();
    	homePage = new HomePageTinyUpload(driver);
    	fileUploadProgressPage = new FileUploadProgress(driver);
    	uploadFinishedPage = new UploadFinished(driver);
    	deleteFilePage = new DeleteFile(driver);
    	fileDeletedPage = new FileDeleted(driver);

    	//Verify login page title
    	String loginPageTitle = homePage.getPageTitle();
    	homePage.setExpectedPageResult("TinyUpload.com");
    	if(!verifyResultContains(loginPageTitle, homePage.getExpectedPageResult())) {
    		return false;
    	};
    	System.out.println("You Landed on the Right Page: "+webSiteUrl);
    	System.out.println("\nNavigating to Delete Page");
    	
    	orignalFocus = this.getWinHandle();
    	
    	homePage.clickUploadButtonAndUploadFile(fileName);
    	homePage.clickUploadFile();
    	
    	fileUploadProgressPage.shiftFocus();
    	System.out.println("Checking for Successfull File Upload");
    	
    	//Comment this later
    	fileUploadProgressPage.shiftFrame(0);
    	
    	//Show Verification of the File Here 
    	fileUploadProgressPage.setExpectedPageResult("File upload finished");
    	if(!verifyResultEquals(fileUploadProgressPage.getFileUploadFinishedText(), fileUploadProgressPage.getExpectedPageResult())) {
    		return false;
     	}
    	System.out.println("File Uploaded Successfully\n");
    	
    	fileUploadProgressPage.closePage(orignalFocus);
    	
    	uploadFinishedPage.setDeleteFileLink();
    	uploadFinishedPage.setDownloadFileLink();
    	uploadFinishedPage.clickDeleteLink();
    	
    	deleteFilePage.setExpectedPageResultVerification("Delete file");
    	if(!verifyResultEquals(deleteFilePage.getDeletePageHeader(), deleteFilePage.getExpectedPageResultVerification())){
    		return false;
    	}
    	System.out.println("You are now at Delete Page\n");
    	return true;
    	
    }
    
    //Initializing all the Delete File Smoke Test Cases
    private void testDeleteFileSmoke() {
    	TS_DF_01 testCase01 = new TS_DF_01();
    	testCase01.test();
    	TS_DF_11 testCase11 = new TS_DF_11();
    	testCase11.test();
    	TS_DF_12 testCase12 = new TS_DF_12();
    	testCase12.test();
    	TS_DF_15 testCase15 = new TS_DF_15();
    	testCase15.test();
    	TS_DF_18 testCase18 = new TS_DF_18();
    	testCase18.test();
    }
    
    //Initializing all the Delete File Sanity Test Cases
    private void testDeleteFileSanity() {
    	TS_DF_02 testCase02 = new TS_DF_02();
    	testCase02.test();
    	TS_DF_14 testCase14 = new TS_DF_14();
    	testCase14.test();
    	TS_DF_15 testCase15 = new TS_DF_15();
    	testCase15.test();
    	TS_DF_16 testCase16 = new TS_DF_16();
    	testCase16.test();
    	TS_DF_17 testCase17 = new TS_DF_17();
    	testCase17.test();
    	TS_DF_21 testCase21 = new TS_DF_21();
    	testCase21.test();
    	
    }
    
    //Initializing all the Report File Smoke Test Cases
    private void testReportSmoke() {
    	TS_FR_NF_01 testCase01 = new TS_FR_NF_01();
    	testCase01.test();
    }

    public static void main(String[] args) throws Exception {
 	    Navigator nav = new Navigator();
 	  	nav.tearDown();
 	    nav.testDeleteFileSmoke();
 	    nav.testDeleteFileSanity();
 	    nav.testReportSmoke();
	    nav.tearDown();
	}

}
