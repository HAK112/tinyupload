package com.tinyupload.tests.deletefile.sanity;

import com.tinyupload.tests.Navigator;

public class TS_DF_15 extends Navigator{
	public void test() {
		System.out.println("Test Case ID: TS_DF_15");
		System.out.println("Test Case Summary: Verify that the File Deletion Message is shown after Deleting the File\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			return;
		}
		this.deleteFilePage.clickDeleteFileButton();
		if(!this.verifyResultContains(this.fileDeletedPage.getHeadingText(), "File Deleted")) {
			System.out.println("Test Case Fail\n");
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}
