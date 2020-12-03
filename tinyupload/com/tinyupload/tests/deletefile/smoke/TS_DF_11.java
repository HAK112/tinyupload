package com.tinyupload.tests.deletefile.smoke;

import com.tinyupload.tests.Navigator;

public class TS_DF_11 extends Navigator {

	public void test() {
		System.out.println("Test Case ID: TS_DF_11");
		System.out.println("Test Case Summary: Verify that Download Link is Clickable on the File Uploaded Page on Delete File Page\n");
		System.out.println("Detailed Steps: \n");
		if (!this.navigateToDeletePage()) {
			return;
		}
		
		if(this.deleteFilePage.getDownloadFileLink().isBlank()) {
			System.out.println("Test Case Failed\n");
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}
