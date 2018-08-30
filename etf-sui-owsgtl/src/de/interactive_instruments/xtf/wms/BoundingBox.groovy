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

public class BoundingBox{
	
	private String CRS;
	
	private double minX;
	
	private double minY;
	
	private double maxX;
	
	private double maxY;
	
	public BoundingBox(XmlHolder xml) {
		CRS = xml.getNodeValue("/*/*:BoundingBox@CRS");
		minX = Double.valueOf(xml.getNodeValue("/*/*:BoundingBox@minx"));
		minY = Double.valueOf(xml.getNodeValue("/*/*:BoundingBox@miny"));
		maxX = Double.valueOf(xml.getNodeValue("/*/*:BoundingBox@maxx"));
		maxY = Double.valueOf(xml.getNodeValue("/*/*:BoundingBox@maxy"));
	}
	
	public BoundingBox(String CRS, double minX, double minY, double maxX, double maxY) {
		this.CRS = CRS;
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public String getCRS() {
		return CRS;
	}

	public double getMinX() {
		return minX;
	}

	public double getMinY() {
		return minY;
	}

	public double getMaxX() {
		return maxX;
	}

	public double getMaxY() {
		return maxY;
	}
	
}