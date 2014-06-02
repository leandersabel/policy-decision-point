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

package bwfla.modules.pdp.service;

import javax.jws.WebService;

@WebService(serviceName = "PolicyDecisionService", endpointInterface = "bwfla.modules.pdp.service.PolicyDecisionService", targetNamespace = "http://bw-fla.uni-freiburg.de/")
public class PolicyDecisionServiceImpl implements PolicyDecisionService {

	/**
	 * @WebMethod to test the availability of the web service.
	 * @param name
	 *          of the person to greet
	 * @returns a greeting String
	 */
	@Override
	public String sayHi(String name) {
		return "Hi " + name + "!";
	}

}
