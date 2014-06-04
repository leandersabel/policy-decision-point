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

package bwfla.modules.pdp.client;



import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import bwfla.modules.pdp.service.PolicyDecisionService;
import bwfla.modules.pdp.util.Helper;

public class Client {

	public static void main(String[] args) throws MalformedURLException {

		QName qname = new QName("http://bw-fla.uni-freiburg.de/", "PolicyDecisionService");
		URL wsdl = new URL("http://localhost:8080/pdp-service/PolicyDecisionService?wsdl");

		Service service = Service.create(wsdl, qname);
		PolicyDecisionService port = service.getPort(PolicyDecisionService.class);
		
		String request = Helper.loadContentFromFile("example-request.xml");
		
		String response = port.evaluate(request);
		System.out.println(response);

		if (response.contains("Deny"))
			System.out.println("Access Denied");
		else if (response.contains("Permit"))
			System.out.println("Access Granted");
		else if (response.contains("NotApplicable"))
			System.out.println("No rule applicable");
		else
			System.out.println("Unknown response type");
	}
}
