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
import de.interactive_instruments.xtf.ProjectHelper
import de.interactive_instruments.xtf.TransferableRequestParameter

import javax.xml.bind.Unmarshaller
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient

public class Capability{
	
	private CapabilityRequest request;
	private CapabilityException exception;
	private CapabilityLayer layer;
	
	public void setCapability(XmlHolder capabilityXML) {
		String requestString = capabilityXML.getNodeValues("/*/*:Request");
		XmlHolder requestXml = new XmlHolder(requestString);
		request = new CapabilityRequest(requestXml);
		String exceptionString = capabilityXML.getNodeValues("/*/*:Exception");
		XmlHolder exceptionXml = new XmlHolder(exceptionString);
		exception = new CapabilityException(exceptionXml);
		String layerString = capabilityXML.getNodeValues("/*/*:Layer");
		XmlHolder layerXml = new XmlHolder(layerString);
		layer = new CapabilityLayer(layerXml);
	}

	public CapabilityRequest getRequest() {
		return request;
	}

	public CapabilityException getException() {
		return exception;
	}

	public CapabilityLayer getLayer() {
		return layer;
	}
	
}