package com.tinyupload.tests.deletefile.sanity;

import com.tinyupload.tests.Navigator;

public class TS_DF_17 extends Navigator{
		
	public void test() {
		System.out.println("Test Case ID: TS_DF_17");
		System.out.println("Test Case Summary: Verify the Name of the File on Delete File Page\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			return;
		}
		if(!this.verifyResultContains(this.deleteFilePage.getFileNameToBeDeleted(), this.fileName)) {
			System.out.println("Test Case Fail\n");
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}
