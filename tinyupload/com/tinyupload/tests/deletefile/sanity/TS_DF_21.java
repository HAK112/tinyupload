package com.tinyupload.tests.deletefile.sanity;

import com.tinyupload.tests.Navigator;

public class TS_DF_21 extends Navigator{
	public void test() {
		System.out.println("Test Case ID: TS_DF_21");
		System.out.println("Test Case Summary: Verify if the File is not Deleted if the User Quits the Tab while deleting the File\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			return;
		}
		deleteFilePage.clickDeleteFileButton();
		driver.close();
		driver.get(uploadFinishedPage.getDownloadFileLink());		
		if(!this.verifyResultContains(downloadFilePage.getDownloadFileHeader(), "File Download")) {
			System.out.println("Test Case Fail\n");
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}
