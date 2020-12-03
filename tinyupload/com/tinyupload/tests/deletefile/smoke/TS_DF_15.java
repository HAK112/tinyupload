package com.tinyupload.tests.deletefile.smoke;

import com.tinyupload.tests.Navigator;

public class TS_DF_15 extends Navigator {
	public void test() {
		System.out.println("Test Case ID: TS_DF_15");
		System.out.println("Test Case Summary: Verify that After Deletion of the File, the Page is Redirected to a New Page\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			return;
		}
		this.deleteFilePage.clickDeleteFileButton();
		if(!this.verifyResultEquals(this.fileDeletedPage.getHeadingText(), "Delete file")) {
			System.out.println("Test Case Fail\n");
				
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
		
	}
}
