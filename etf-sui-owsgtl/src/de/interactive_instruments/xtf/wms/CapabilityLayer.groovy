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

public class CapabilityLayer{
	
	private String title;
	
	private String[] CRSArray;
	
	private EX_GeographicBoundingBox EX_GeographicBoundingBox;
	
	private BoundingBox[] boundingBoxArray;
	
	private Layer[] layerArray;

	public CapabilityLayer(XmlHolder xml){
		title = xml.getNodeValue("/*/*:Title");
		CRSArray = xml.getNodeValues("/*/*/*:CRS");
		String EX_GeographicBoundingBoxString = xml.getNodeValues("/*/*:EX_GeographicBoundingBox")
		XmlHolder EX_GeographicBoundingBoxXml = new XmlHolder(EX_GeographicBoundingBoxString);
		EX_GeographicBoundingBox = new EX_GeographicBoundingBox(EX_GeographicBoundingBoxXml);
		String[] boundingBoxStringArray = xml.getNodeValues("/*/*:BoundingBox");
		boundingBoxArray = new BoundingBox[boundingBoxStringArray.length];
		for(String bbString : boundingBoxStringArray) {
			XmlHolder bbxml = new XmlHolder(bbString);
			boundingBoxArray[boundingBoxArray.length] = new BoundingBox(bbxml);
		}
		String[] layerStringArray = xml.getNodeValues("/*/*:Layer/Layer");
		layerArray = new Layer[layerStringArray.length];
		for(String layerString : layerStringArray) {
			XmlHolder layerxml = new XmlHolder(layerString);
			layerArray[layerArray.length] = new Layer(layerxml);
		}
		
	}
	
	public String getTitle() {
		return title;
	}

	public String[] getCRSArray() {
		return CRSArray;
	}

	public EX_GeographicBoundingBox getEX_GeographicBoundingBox() {
		return EX_GeographicBoundingBox;
	}

	public BoundingBox[] getBoundingBoxArray() {
		return boundingBoxArray;
	}

	public Layer[] getLayerArray() {
		return layerArray;
	}
	
}