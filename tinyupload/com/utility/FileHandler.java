package com.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileHandler {
	
	WebDriver driver;
	String sourceLocation; 
    String downloadLocation = System.getProperty("user.dir")+"//resource//downloads//";
    String wgetToolLocation = System.getProperty("user.dir")+"//resource//tool//wget.exe";
    String wget_command = "cmd /c "+wgetToolLocation+" -P D: --no-check-certificate " + sourceLocation;
    String baseFileUploadURL = System.getProperty("user.dir")+"//resource//uploads//";
    
    public void setDownloadLink(String downloadLink) {
    	sourceLocation = downloadLink;    	
    	System.out.println("File Download Location: "+sourceLocation);
    }
    
    public String getDownloadLocation() {
    	return downloadLocation;
    }
    
    public void startDownload() {
    	System.out.println("Download Started");
    	try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
            } 
    	catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
    }
	public FileHandler(WebDriver driver) {
		this.driver = driver;
	}
	
	//Setting The Location of the File
	public void setFileLocation(String fileName) {
		baseFileUploadURL = baseFileUploadURL + fileName;
		System.out.println("File Location Set: "+baseFileUploadURL);
	}
	
	//Uploading the File
	public void uploadFile(WebElement fileUploadButton, String fileName) {
		setFileLocation(fileName);
		System.out.println("Following File Sent To Upload: "+baseFileUploadURL);
		fileUploadButton.sendKeys(baseFileUploadURL);
	}
	
	public boolean fileExists(String fileLocation) {
		File f = new File(fileLocation);
		if(!f.exists() && f.isDirectory()) { 
			return false;
		}
		return true;
	}
}