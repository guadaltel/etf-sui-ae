/**
 * Copyright 2010-2016 interactive instruments GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.interactive_instruments.xtf.wms

import com.eviware.soapui.support.XmlHolder
import de.interactive_instruments.xtf.Bbox
import de.interactive_instruments.xtf.HttpRequest
import de.interactive_instruments.xtf.ProjectHelper
import de.interactive_instruments.xtf.TransferableRequestParameter

import javax.xml.bind.Unmarshaller
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient

public class GetCapabilitiesRequest extends HttpRequest {
	
	private Map<String, ?> params;
	
	public XmlHolder submit() {
		log.info("Sending request");
		httpLog.info("Sending...");
		return sendRequestGET(params);
	}

	public void setVersion(String version) {
		if (params == null) {
			params = new TreeMap<String, ?>();
		}
		params.put("version", version);
	}

	public void setService(String service) {
		if (params == null) {
			params = new TreeMap<String, ?>();
		}
		params.put("service", service);
	}

	public void setLanguage(String language) {
		if (params == null) {
			params = new TreeMap<String, ?>();
		}
		params.put("language", language);
	}

	public void setFormat(String format) {
		if (params == null) {
			params = new TreeMap<String, ?>();
		}
		params.put("format", format);
	}
	
}