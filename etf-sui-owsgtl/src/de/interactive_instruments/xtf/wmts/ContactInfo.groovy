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

public class ContactInfo{
	
	private String deliveryPoint;
	private String city;
	private String administrativeArea;
	private String postalcode;
	private String country;
	private String electronicMailAddress;
	private String phoneVoice;
	private String phoneFacsimile;
	
	public ContactInfo(XmlHolder xml) {
		deliveryPoint = xml.getNodeValue("/*/*:Address/*:DeliveryPoint");
		city = xml.getNodeValue("/*/*:Address/*:City");
		administrativeArea = xml.getNodeValue("/*/*:Address/*:AdministrativeArea");
		postalcode = xml.getNodeValue("/*/*:Address/*:PostalCode");
		country = xml.getNodeValue("/*/*:Address/*:Country");
		electronicMailAddress = xml.getNodeValue("/*/*:Address/*:ElectronicMailAddress");
		phoneVoice = xml.getNodeValue("/*/*:Phone/*:Voice");
		phoneFacsimile = xml.getNodeValue("/*/*:Phone/*:Facsimile");
	}
	
	public String getDeliveryPoint() {
		return deliveryPoint;
	}
	public String getCity() {
		return city;
	}
	public String getAdministrativeArea() {
		return administrativeArea;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public String getCountry() {
		return country;
	}
	public String getElectronicMailAddress() {
		return electronicMailAddress;
	}
	public String getPhoneVoice() {
		return phoneVoice;
	}
	public String getPhoneFacsimile() {
		return phoneFacsimile;
	}
	
	
}