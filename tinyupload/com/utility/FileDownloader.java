package com.utility;

import java.io.File;
import java.io.IOException;

public class FileDownloader {
    String sourceLocation; 
    String downloadLocation = System.getProperty("user.dir")+"//resource//downloads//";
    String wgetToolLocation = System.getProperty("user.dir")+"//resource//tool//wget.exe";
    String wget_command = "cmd /c "+wgetToolLocation+" -P D: --no-check-certificate " + sourceLocation;
    
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
            System.out.println("Download Complete");
            } 
    	catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public boolean fileExists(String fileLocation) {
		File f = new File(fileLocation);
		if(!f.exists() && f.isDirectory()) { 
			return false;
		}
		return true;
	}
}
