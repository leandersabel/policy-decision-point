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

import javax.ejb.Singleton;
import javax.ejb.Startup;

import lombok.extern.log4j.Log4j;

import org.wso2.balana.Balana;

import bwfla.modules.pdp.service.PolicyDecisionPointLocal;

@Log4j
@Startup
@Singleton
public class PolicyDecisionPoint implements PolicyDecisionPointLocal {

	private Balana balana;

	/**
	 * Create a new PDP. This is called by JavaEE because of the @Startup
	 * annotation.
	 */
	public PolicyDecisionPoint() {
		log.info("Initializing Policy Decision Point");
		log.info("----------------------------------");
	}

}
