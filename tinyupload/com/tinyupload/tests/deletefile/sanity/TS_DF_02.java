package com.tinyupload.tests.deletefile.sanity;

import com.tinyupload.tests.Navigator;

public class TS_DF_02 extends Navigator{
	public void test() {
		System.out.println("Test Case ID: TS_DF_02");
		System.out.println("Test Case Summary: Verify the URL structure of file deletion on file Deleltion Page\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			return;
		}
		if(!this.verifyResultContains(this.deleteFilePage.getPageURL(), "del_id")) {
			System.out.println("Test Case Fail\n");
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}
