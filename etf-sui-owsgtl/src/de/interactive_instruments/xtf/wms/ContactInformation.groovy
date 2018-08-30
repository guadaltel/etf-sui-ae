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

public class ContactInformation{
	
	private String contactPerson;
	
	private String contactOrganization;
	
	private String contactPosition;
	
	private ContactAddress contactAddress;
	
	private String contactVoiceTelephone;
	
	private String contactFacsimileTelephone;
	
	private String contactElectronicMailAddress;
	
	public ContactInformation(XmlHolder xml) {
		contactPerson = xml.getNodeValue("/*/*:ContactPersonPrimary/*:ContactPerson");
		contactOrganization = xml.getNodeValue("/*/*:ContactPersonPrimary/*:ContactOrganization");
		contactPosition = xml.getNodeValue("/*/*:ContactPosition");
		String contactAddressString = xml.getNodeValue("/*/*:contactAddress");
		XmlHolder contactAddressXml = new XmlHolder(contactAddressString);
		contactAddress = new ContactAddress(xml);
		contactVoiceTelephone = xml.getNodeValue("/*/*:contactVoiceTelephone");
		contactFacsimileTelephone = xml.getNodeValue("/*/*:contactFacsimileTelephone");
		contactElectronicMailAddress = xml.getNodeValue("/*/*:contactElectronicMailAddress");
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public String getContactOrganization() {
		return contactOrganization;
	}

	public String getContactPosition() {
		return contactPosition;
	}

	public ContactAddress getContactAddress() {
		return contactAddress;
	}

	public String getContactVoiceTelephone() {
		return contactVoiceTelephone;
	}

	public String getContactFacsimileTelephone() {
		return contactFacsimileTelephone;
	}

	public String getContactElectronicMailAddress() {
		return contactElectronicMailAddress;
	}
	
}