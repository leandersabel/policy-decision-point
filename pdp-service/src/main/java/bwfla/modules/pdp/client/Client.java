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



import bwfla.modules.pdp.util.Helper;
import bwfla.modules.pdp.xacml.PolicyDecisionPoint;

public class Client {

	public static void main(String[] args) {
		PolicyDecisionPoint pdp = new PolicyDecisionPoint();

		String request = Helper.loadContentFromFile("example-request.xml");
		String response = pdp.evaluate(request);

		if (response.contains("Denied"))
			System.out.println("Access Denied");
		else if (response.contains("Granted"))
			System.out.println("Access Granted");
		else if (request.contains("Not Applicable"))
			System.out.println("No rule applicable");
		else
			System.out.println("Unknown response type");
	}
}
