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

public class ServiceIdentification{
	
	private String title;
	private String abstract_;
	private String[] keywordListArray;
	private String serviceType;
	private String serviceTypeVersion;
	private String fees;
	private String accessConstraints;
	
	public void setServiceIdentification(XmlHolder xml) {
		title = xml.getNodeValue("/*/*:Title");
		abstract_ = xml.getNodeValue("/*/*:Abstract");
		keywordListArray = xml.getNodeValues("/*:Keywords/*:Keyword");
		serviceType = xml.getNodeValue("/*/*:ServiceType");
		serviceTypeVersion = xml.getNodeValue("/*/*:ServiceTypeVersion");
		fees = xml.getNodeValue("/*/*:Fees");
		accessConstraints = xml.getNodeValue("/*/*:AccessConstraints");
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
	public String getServiceType() {
		return serviceType;
	}
	public String getServiceTypeVersion() {
		return serviceTypeVersion;
	}
	public String getFees() {
		return fees;
	}
	public String getAccessConstraints() {
		return accessConstraints;
	}

}