package com.tinyupload.tests.reportfile.smoke;

import com.tinyupload.tests.Navigator;

public class TS_FR_NF_01 extends Navigator  {
	public void test() {
		System.out.println("Test Case ID: TS_FR_NF_01");
		System.out.println("Verify the Report Rage Exists \n");
		System.out.println("Detailed Steps: \n");
		if(!this.navigateToReportAndCopyrightPage()) {
			return;
		}
		System.out.println("Test Case Pass\n");
		this.tearDown();
	}
}