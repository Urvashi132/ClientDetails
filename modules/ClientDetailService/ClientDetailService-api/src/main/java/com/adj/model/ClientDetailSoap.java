/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.adj.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adj.service.http.ClientDetailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ClientDetailSoap implements Serializable {

	public static ClientDetailSoap toSoapModel(ClientDetail model) {
		ClientDetailSoap soapModel = new ClientDetailSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setClientId(model.getClientId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setConfirmEmail(model.getConfirmEmail());
		soapModel.setAge(model.getAge());
		soapModel.setPhoneNo(model.getPhoneNo());
		soapModel.setAadharCard(model.getAadharCard());

		return soapModel;
	}

	public static ClientDetailSoap[] toSoapModels(ClientDetail[] models) {
		ClientDetailSoap[] soapModels = new ClientDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClientDetailSoap[][] toSoapModels(ClientDetail[][] models) {
		ClientDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClientDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClientDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClientDetailSoap[] toSoapModels(List<ClientDetail> models) {
		List<ClientDetailSoap> soapModels = new ArrayList<ClientDetailSoap>(
			models.size());

		for (ClientDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClientDetailSoap[soapModels.size()]);
	}

	public ClientDetailSoap() {
	}

	public long getPrimaryKey() {
		return _clientId;
	}

	public void setPrimaryKey(long pk) {
		setClientId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getConfirmEmail() {
		return _confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		_confirmEmail = confirmEmail;
	}

	public String getAge() {
		return _age;
	}

	public void setAge(String age) {
		_age = age;
	}

	public String getPhoneNo() {
		return _phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		_phoneNo = phoneNo;
	}

	public String getAadharCard() {
		return _aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		_aadharCard = aadharCard;
	}

	private String _uuid;
	private long _clientId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _email;
	private String _confirmEmail;
	private String _age;
	private String _phoneNo;
	private String _aadharCard;

}