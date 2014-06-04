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

package bwfla.modules.pdp.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import bwfla.modules.pdp.util.Helper;
import lombok.NoArgsConstructor;

@ManagedBean
@SessionScoped
@NoArgsConstructor
public class AdminBean implements Serializable {

	private static final long serialVersionUID = 1562903612278037854L;

	private String policy;

	public void savePolicy() {
		Helper.writeContentToFile("policies/example-policy.xml", policy);
		System.out.println("Set policy to " + policy);
	}

	public String getPolicy() {
		policy = Helper.loadContentFromFile("policies/example-policy.xml");
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

}
