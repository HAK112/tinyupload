package com.tinyupload.tests.deletefile.sanity;

import com.tinyupload.tests.Navigator;
import com.utility.FileDownloader;

public class TS_DF_16 extends Navigator{
	FileDownloader fileDownload;
	
	public TS_DF_16() {
		fileDownload = new FileDownloader();
	}
	
	public void test() {
		System.out.println("Test Case ID: TS_DF_16");
		System.out.println("Test Case Summary: Verify whether Deleting the File while Downloading the File actually stops the downloading or not\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			return;
		}
		fileDownload.setDownloadLink(this.deleteFilePage.getDownloadFileLink());
		fileDownload.startDownload();
		deleteFilePage.clickDeleteFileButton();
		if(!this.verifyResultContains(this.fileDeletedPage.getHeadingText(), "File Deleted")) {
			System.out.println("Test Case Fail\n");
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}
