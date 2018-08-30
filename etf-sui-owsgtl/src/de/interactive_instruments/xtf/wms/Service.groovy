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

public class Service{
	
	private String name;
	private String title;
	private String abstract_;
	private String[] keywordListArray;
	private String onlineResource;
	private ContactInformation contactInformation;
	private String fees;
	private String accessConstraints;
	private double maxWidth;
	private double maxHeigth;
	
	public void setService(XmlHolder serviceXML) {
		name = serviceXML.getNodeValue("/*/*:Name");
		title = serviceXML.getNodeValue("/*/*:Title");
		abstract_ = serviceXML.getNodeValue("/*/*:Abstract");
		keywordListArray = serviceXML.getNodeValues("/*/*:KeywordList/*:Keyword");
		onlineResource = serviceXML.getNodeValue("/*:OnlineResource@href");
		String contactInformationString = serviceXML.getNodeValues("/*/*:KeywordList/*:contactInformation");
		XmlHolder contactInformationXml = new XmlHolder(contactInformationString);
		contactInformation = new ContactInformation(contactInformationXml);
		fees = serviceXML.getNodeValue("/*/*:Fees");
		accessConstraints = serviceXML.getNodeValue("/*/*:AccessConstraints");
		maxWidth = Double.valueOf(serviceXML.getNodeValue("/*/*:MaxWidth"));
		maxHeigth = Double.valueOf(serviceXML.getNodeValue("/*/*:MaxHeight"));
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getAbstract_() {
		return abstract_;
	}

	public String[] getKeywordListArray() {
		return keywordListArray;
	}

	public String getOnlineResource() {
		return onlineResource;
	}

	public ContactInformation getContactInformation() {
		return contactInformation;
	}

	public String getFees() {
		return fees;
	}

	public String getAccessConstraints() {
		return accessConstraints;
	}

	public double getMaxWidth() {
		return maxWidth;
	}

	public double getMaxHeigth() {
		return maxHeigth;
	}
	
	
}