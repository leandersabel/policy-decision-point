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

package bwfla.modules.pdp.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.common.io.CharStreams;

import lombok.NonNull;
import lombok.extern.log4j.Log4j;

@Log4j
public class Helper {
	
	/**
	 * Load a file from a local folder
	 * 
	 * @param path
	 *          The file's path e.g. "example/example-policy.xml"
	 * @return the file's content in a string
	 */
	public static String loadContentFromFile(@NonNull String path) {
		try (InputStream requestIn = Helper.class.getClassLoader().getResourceAsStream(path)) {
			if (requestIn == null)
				throw new IOException();

			return CharStreams.toString(new InputStreamReader(requestIn, "UTF-8"));
		}
		catch (IOException e) {
			log.error("Could not file from path: " + path, e);
			return null;
		}
	}

}
