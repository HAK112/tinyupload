package com.tinyupload.tests.deletefile.smoke;

import com.tinyupload.tests.Navigator;
import com.utility.FileDownloader;
public class TS_DF_12 extends Navigator {
	FileDownloader fileDownload;
	
	public TS_DF_12() {
		fileDownload = new FileDownloader();
	}
	
	public void test() {
		System.out.println("Test Case ID: TS_DF_12");
		System.out.println("Test Case Summary: Verify that Clicking Download Link Starts Downloading on Delete File Page\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			return;
		}
		fileDownload.setDownloadLink(this.deleteFilePage.getDownloadFileLink());
		fileDownload.startDownload();
		if(!fileDownload.fileExists(fileDownload.getDownloadLocation()+this.fileName)){
			System.out.println("Test Case Fail\n");
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}
