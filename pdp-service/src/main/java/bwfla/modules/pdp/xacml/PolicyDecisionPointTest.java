/* 
 * Copyright (c) 2014 Leander Sabel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bwfla.modules.pdp.xacml;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import bwfla.modules.pdp.util.Helper;

public class PolicyDecisionPointTest {
	
	PolicyDecisionPoint pdp;
	
	@Before
	public void initialize() {
		pdp = new PolicyDecisionPoint();
	}

	@Test
	public void testPDP() {
		String request = Helper.loadContentFromFile("example-request.xml");
		String response = pdp.evaluate(request);
		Assert.assertEquals(true, response.contains("<Decision>Deny</Decision>"));
		Assert.assertEquals(true, response.contains("StatusCode Value=\"urn:oasis:names:tc:xacml:1.0:status:ok\"/>"));
	}

}
