package com.tinyupload.tests.deletefile.smoke;

import com.tinyupload.tests.Navigator;

public class TS_DF_18 extends Navigator {
	public void test() {
		System.out.println("Test Case ID: TS_DF_18");
		System.out.println("Test Case Summary: Verify the Extension of the File on Delete File Page\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			return;
		}
		if(!this.verifyResultEquals(this.deleteFilePage.getFileNameToBeDeleted(), this.fileName)) {
			System.out.println("Test Case Fail\n");
				
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}
