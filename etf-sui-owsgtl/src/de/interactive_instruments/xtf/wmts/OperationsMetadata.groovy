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
package de.interactive_instruments.xtf.wmts

import com.eviware.soapui.support.XmlHolder
import de.interactive_instruments.xtf.Bbox
import de.interactive_instruments.xtf.ProjectHelper
import de.interactive_instruments.xtf.TransferableRequestParameter

import javax.xml.bind.Unmarshaller
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient

public class OperationsMetadata{
	
	private OperationGetCapabilities operationGetCapabilities;
	
	private OperationGetTile operationGetTile;
	
	private GetExtendedCapabilities extendedCapabilities;
	
	public void setOperationsMetadata(XmlHolder xml) {
		String operationGetCapabilitiesString = xml.getNodeValue("/*/*:Operation[@name = 'GetCapabilities']");
		XmlHolder operationGetCapabilitiestXml = new XmlHolder(operationGetCapabilitiesString);
		operationGetCapabilities = new OperationGetCapabilities(operationGetCapabilitiestXml);
		
		String operationGetTileString = xml.getNodeValue("/*/*:Operation[@name = 'GetTile']");
		XmlHolder operationGetTileXml = new XmlHolder(operationGetTileString);
		operationGetTile = new OperationGetTile(operationGetTileXml);
		
		String extendedCapabilitiesString = xml.getNodeValue("/*/*:Operation[@name = 'GetExtendedCapabilities']");
		XmlHolder extendedCapabilitiesXml = new XmlHolder(extendedCapabilitiesString);
		extendedCapabilities = new GetExtendedCapabilities(extendedCapabilitiesXml);
	}

	public OperationGetCapabilities getOperationGetCapabilities() {
		return operationGetCapabilities;
	}

	public OperationGetTile getOperationGetTile() {
		return operationGetTile;
	}

	public GetExtendedCapabilities getExtendedCapabilities() {
		return extendedCapabilities;
	}
	
}