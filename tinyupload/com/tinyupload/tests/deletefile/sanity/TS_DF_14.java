package com.tinyupload.tests.deletefile.sanity;

import com.tinyupload.tests.Navigator;

public class TS_DF_14 extends Navigator{
	public void test() {
		System.out.println("Test Case ID: TS_DF_14");
		System.out.println("Test Case Summary: Verify that Delete File message is shown before deleting the File on File Deletion Page\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			return;
		}
		if(!this.verifyResultContains(this.deleteFilePage.getDeletePageHeader(), "Delete File")) {
			System.out.println("Test Case Fail\n");
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}
