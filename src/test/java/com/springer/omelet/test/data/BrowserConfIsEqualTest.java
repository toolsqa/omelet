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
package com.springer.omelet.test.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springer.omelet.data.DriverConfigurations;
import com.springer.omelet.data.driverconf.BrowserConfR;
import com.springer.omelet.data.driverconf.IBrowserConf;

public class BrowserConfIsEqualTest {

	private HashMap<String, String> browserConfValues1;
	private HashMap<String, String> browserConfValues2;
	List<IBrowserConf> browserConfList = new ArrayList<IBrowserConf>();
	
	@BeforeMethod
	public void setup(){
		browserConfValues1 = null;
		browserConfValues2 = null;
		browserConfValues1 = new HashMap<String, String>();
		browserConfValues2 = new HashMap<String, String>();
	}

	@Test(enabled = true, description = "same browser -->remote flag off-->filtering using set and List")
	public void checkBrowserConfEquality_RemoteFlagOFF() {
		browserConfValues1.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				new String("firefox"));
		browserConfValues1.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "false");

		browserConfValues2.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				new String("firefox"));
		browserConfValues2.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "false");
		IBrowserConf obj1 = new BrowserConfR(browserConfValues1);
		IBrowserConf obj2 = new BrowserConfR(browserConfValues2);

		browserConfList.add(obj1);
		browserConfList.add(obj2);
		Assert.assertEquals(browserConfList.size(), 2);
		Set<IBrowserConf> s = new HashSet<IBrowserConf>(browserConfList);
		List<IBrowserConf> newList = new ArrayList<IBrowserConf>(s);
		Assert.assertEquals(obj1, obj2);
		Assert.assertEquals(s.size(), 1);
		Assert.assertEquals(newList.size(), 1);
	}

	@Test(description = "Remote Flag on and required values equal", enabled = true)
	public void remoteFlagOn() {
		browserConfValues1.clear();
		browserConfValues2.clear();

		browserConfValues1.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"firefox");
		browserConfValues1.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.browserVersion.toString(), "11");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.os.toString(), "Windows");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.osVersion.toString(), "XP");

		browserConfValues2.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"firefox");
		browserConfValues2.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.browserVersion.toString(), "11");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.os.toString(), "Windows");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.osVersion.toString(), "XP");

		BrowserConfR obj1 = new BrowserConfR(browserConfValues1);
		BrowserConfR obj2 = new BrowserConfR(browserConfValues2);
		Assert.assertEquals(obj1, obj2);
	}

	@Test(description = "Remote Flag on and required values equal and not required not equal", enabled = true)
	public void remoteFlagOn_2() {
		browserConfValues1.clear();
		browserConfValues2.clear();

		browserConfValues1.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"firefox");
		browserConfValues1.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "false");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.browserVersion.toString(), "11");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.os.toString(), "Windows");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.osVersion.toString(), "XP");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(),
				"true");

		browserConfValues2.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"firefox");
		browserConfValues2.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "false");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.browserVersion.toString(), "11");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.os.toString(), "Windows");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.osVersion.toString(), "XP");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(),
				"false");

		BrowserConfR obj1 = new BrowserConfR(browserConfValues1);
		BrowserConfR obj2 = new BrowserConfR(browserConfValues2);
		Assert.assertEquals(obj1, obj2);
		Assert.assertEquals(obj1.hashCode(), obj2.hashCode());
	}

	@Test(description = "Remote Flag on and required values not equal and not required not equal")
	public void remoteFlagOn_3() {
		browserConfValues1.clear();
		browserConfValues2.clear();

		browserConfValues1.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"firefox");
		browserConfValues1.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "false");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.browserVersion.toString(), "11");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.os.toString(), "Mac");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.osVersion.toString(), "XP");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(),
				"true");

		browserConfValues2.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"firefox");
		browserConfValues2.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "false");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.browserVersion.toString(), "11");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.os.toString(), "Windows");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.osVersion.toString(), "XP");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(),
				"false");

		BrowserConfR obj1 = new BrowserConfR(browserConfValues1);
		BrowserConfR obj2 = new BrowserConfR(browserConfValues2);
		List<IBrowserConf> testL = new ArrayList<IBrowserConf>();
		testL.add(obj1);
		testL.add(obj2);
		Assert.assertEquals(testL.size(), 2);
		Set<IBrowserConf> s = new HashSet<IBrowserConf>(testL);
		Assert.assertEquals(s.size(), 2);
		Assert.assertNotEquals(obj1, obj2);
		Assert.assertNotEquals(obj1.hashCode(), obj2.hashCode());
	}

	@Test(description = "remote Flag on ->bsswitch off-->browser equals")
	public void remoteFlag_4() {
		browserConfValues1.clear();
		browserConfValues2.clear();

		browserConfValues1.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"firefox");
		browserConfValues1.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "false");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "false");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.browserVersion.toString(), "11");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.os.toString(), "Mac");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.osVersion.toString(), "XP");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(),
				"true");

		browserConfValues2.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"firefox");
		browserConfValues2.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "false");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "false");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.browserVersion.toString(), "11");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.os.toString(), "Windows");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.osVersion.toString(), "XP");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(),
				"false");

		BrowserConfR obj1 = new BrowserConfR(browserConfValues1);
		BrowserConfR obj2 = new BrowserConfR(browserConfValues2);
		Assert.assertEquals(obj1, obj2);
		Assert.assertEquals(obj1.hashCode(), obj2.hashCode());
	}
	
	@Test(description = "remote Flag on -> bsswitch on -> mobile on -> devices not equals -> browser equals")
	public void remoteBsMobileOnDevicesNotEqualsBrowserEquals() {
		browserConfValues1.clear();
		browserConfValues2.clear();

		browserConfValues1.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"iPhone");
		browserConfValues1.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.platform.toString(), "MAC");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.device.toString(), "iPhone 5S");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(),
				"true");

		browserConfValues2.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"iPhone");
		browserConfValues2.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.platform.toString(), "MAC");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.device.toString(), "iPhone 5C");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(), "true");

		BrowserConfR obj1 = new BrowserConfR(browserConfValues1);
		BrowserConfR obj2 = new BrowserConfR(browserConfValues2);
		Assert.assertNotEquals(obj1, obj2);
	}
	
	@Test(description = "remote Flag on -> bsswitch on -> mobile on -> devices equals -> browser equals")
	public void remoteBsMobileOnDevicesEqualsBrowserEquals() {
		browserConfValues1.clear();
		browserConfValues2.clear();

		browserConfValues1.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"iPhone");
		browserConfValues1.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "true");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.platform.toString(), "MAC");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.device.toString(), "iPhone 5S");
		browserConfValues1.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(), "true");

		browserConfValues2.put(DriverConfigurations.LocalEnvironmentConfig.browserName.toString(),
				"iPhone");
		browserConfValues2.put(DriverConfigurations.FrameworkConfig.remoteFlag.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bsSwitch.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.mobileTest.toString(), "true");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.platform.toString(), "MAC");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.device.toString(), "iPhone 5S");
		browserConfValues2.put(DriverConfigurations.BrowserStackConfig.bs_localTesting.toString(), "true");

		BrowserConfR obj1 = new BrowserConfR(browserConfValues1);
		BrowserConfR obj2 = new BrowserConfR(browserConfValues2);
		Assert.assertEquals(obj1, obj2);
	}
}