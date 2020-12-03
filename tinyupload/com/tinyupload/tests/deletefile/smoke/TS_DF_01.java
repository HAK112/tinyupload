package com.tinyupload.tests.deletefile.smoke;

import com.tinyupload.tests.Navigator;

public class TS_DF_01 extends Navigator  {

	public void test() {
		System.out.println("Test Case ID: TS_DF_01");
		System.out.println("Test Case Summary: Verify that Webpage Exists for Deletion of the File\n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToDeletePage()) {
			System.out.println("Test Case Fail\n");
			return;
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}