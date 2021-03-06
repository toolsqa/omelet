/*******************************************************************************
 *
 * 	Copyright 2014 Springer Science+Business Media Deutschland GmbH
 * 	
 * 	Licensed under the Apache License, Version 2.0 (the "License");
 * 	you may not use this file except in compliance with the License.
 * 	You may obtain a copy of the License at
 * 	
 * 	    http://www.apache.org/licenses/LICENSE-2.0
 * 	
 * 	Unless required by applicable law or agreed to in writing, software
 * 	distributed under the License is distributed on an "AS IS" BASIS,
 * 	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 	See the License for the specific language governing permissions and
 * 	limitations under the License.
 *******************************************************************************/
package com.springer.omelet.test.browserup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springer.omelet.driver.Driver;

public class BeforeAndAfterMethodPresentTest {

	private String sessionID;

	@BeforeMethod
	public void setupBrowser() {
		WebDriver driver = Driver.getDriver();
		sessionID = ((RemoteWebDriver) driver).getSessionId().toString();
	}

	@Test
	public void verifySameBrowser() {
		Assert.assertEquals(((RemoteWebDriver) Driver.getDriver())
				.getSessionId().toString(), sessionID);
	}

	@AfterMethod
	public void verifySameBrowserInAfterMethod() {
		Assert.assertEquals(((RemoteWebDriver) Driver.getDriver())
				.getSessionId().toString(), sessionID);
	}

}
