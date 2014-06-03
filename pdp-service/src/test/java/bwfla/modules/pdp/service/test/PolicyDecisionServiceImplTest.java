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

package bwfla.modules.pdp.service.test;


import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bwfla.modules.pdp.service.PolicyDecisionService;

public class PolicyDecisionServiceImplTest {

	private PolicyDecisionService port;

	@Before
	public void initalize() throws MalformedURLException {
		
		QName qname = new QName("http://bw-fla.uni-freiburg.de/", "PolicyDecisionService");
		URL wsdl = new URL("http://localhost:8080/pdp-service/PolicyDecisionService?wsdl");

		Service service = Service.create(wsdl, qname);
		port = service.getPort(PolicyDecisionService.class);
	}
	
	@Test
	public void testSayHi() {
		String response = port.sayHi("Bob");
		Assert.assertEquals("Hi Bob!", response);
		
	}

}
