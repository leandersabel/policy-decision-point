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

import java.io.IOException;
import java.net.URL;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import lombok.NonNull;
import lombok.extern.log4j.Log4j;

import org.wso2.balana.Balana;
import org.wso2.balana.PDP;
import org.wso2.balana.finder.impl.FileBasedPolicyFinderModule;

import bwfla.modules.pdp.service.PolicyDecisionPointLocal;

@Log4j
@Startup
@Singleton
public class PolicyDecisionPoint implements PolicyDecisionPointLocal {

	private Balana balana;
	public PDP pdp;

	/**
	 * Create a new PDP. This is called by JavaEE because of the @Startup
	 * annotation.
	 * 
	 * @throws IOException
	 */
	public PolicyDecisionPoint() {
		log.info("# ---------------------------------- #");
		log.info("# Initializing Policy Decision Point #");
		log.info("# ---------------------------------- #");

		balana = initBalana();
		pdp = new PDP(balana.getPdpConfig());

		// String response = pdp.evaluate(Helper.loadExampleRequest());

		// log.info(response);
	}
	
	@Override
	public String evaluate(@NonNull String request) {
		balana = initBalana();
		pdp = new PDP(balana.getPdpConfig());
		
		return pdp.evaluate(request);
	}

	/**
	 * Initialize Balana with the correct policies folder
	 * 
	 * @return
	 */
	private Balana initBalana() {
		// --- Setup folder for XACML policies
		// ------------------------------------------------------------------------
		URL policies = getClass().getClassLoader().getResource("policies");
		System.setProperty(FileBasedPolicyFinderModule.POLICY_DIR_PROPERTY, policies.getFile());
		log.info("Using policies found in: " + policies.getFile());

		// Warn user about spaces in the filename
		if (policies.getFile().contains("%20") || policies.getFile().contains(" ")) {
			log.warn("The path to the policies contains spaces. This may cause problems.");
		}

		return Balana.getInstance();
	}

}
