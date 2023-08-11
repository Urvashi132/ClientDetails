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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClientDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientDetail
 * @generated
 */
public class ClientDetailWrapper
	extends BaseModelWrapper<ClientDetail>
	implements ClientDetail, ModelWrapper<ClientDetail> {

	public ClientDetailWrapper(ClientDetail clientDetail) {
		super(clientDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("clientId", getClientId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("confirmEmail", getConfirmEmail());
		attributes.put("age", getAge());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("aadharCard", getAadharCard());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String confirmEmail = (String)attributes.get("confirmEmail");

		if (confirmEmail != null) {
			setConfirmEmail(confirmEmail);
		}

		String age = (String)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String phoneNo = (String)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
		}

		String aadharCard = (String)attributes.get("aadharCard");

		if (aadharCard != null) {
			setAadharCard(aadharCard);
		}
	}

	/**
	 * Returns the aadhar card of this client detail.
	 *
	 * @return the aadhar card of this client detail
	 */
	@Override
	public String getAadharCard() {
		return model.getAadharCard();
	}

	/**
	 * Returns the age of this client detail.
	 *
	 * @return the age of this client detail
	 */
	@Override
	public String getAge() {
		return model.getAge();
	}

	/**
	 * Returns the client ID of this client detail.
	 *
	 * @return the client ID of this client detail
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the company ID of this client detail.
	 *
	 * @return the company ID of this client detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the confirm email of this client detail.
	 *
	 * @return the confirm email of this client detail
	 */
	@Override
	public String getConfirmEmail() {
		return model.getConfirmEmail();
	}

	/**
	 * Returns the create date of this client detail.
	 *
	 * @return the create date of this client detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this client detail.
	 *
	 * @return the email of this client detail
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this client detail.
	 *
	 * @return the group ID of this client detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this client detail.
	 *
	 * @return the modified date of this client detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this client detail.
	 *
	 * @return the name of this client detail
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the phone no of this client detail.
	 *
	 * @return the phone no of this client detail
	 */
	@Override
	public String getPhoneNo() {
		return model.getPhoneNo();
	}

	/**
	 * Returns the primary key of this client detail.
	 *
	 * @return the primary key of this client detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this client detail.
	 *
	 * @return the user ID of this client detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this client detail.
	 *
	 * @return the user name of this client detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this client detail.
	 *
	 * @return the user uuid of this client detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this client detail.
	 *
	 * @return the uuid of this client detail
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the aadhar card of this client detail.
	 *
	 * @param aadharCard the aadhar card of this client detail
	 */
	@Override
	public void setAadharCard(String aadharCard) {
		model.setAadharCard(aadharCard);
	}

	/**
	 * Sets the age of this client detail.
	 *
	 * @param age the age of this client detail
	 */
	@Override
	public void setAge(String age) {
		model.setAge(age);
	}

	/**
	 * Sets the client ID of this client detail.
	 *
	 * @param clientId the client ID of this client detail
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the company ID of this client detail.
	 *
	 * @param companyId the company ID of this client detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the confirm email of this client detail.
	 *
	 * @param confirmEmail the confirm email of this client detail
	 */
	@Override
	public void setConfirmEmail(String confirmEmail) {
		model.setConfirmEmail(confirmEmail);
	}

	/**
	 * Sets the create date of this client detail.
	 *
	 * @param createDate the create date of this client detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this client detail.
	 *
	 * @param email the email of this client detail
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this client detail.
	 *
	 * @param groupId the group ID of this client detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this client detail.
	 *
	 * @param modifiedDate the modified date of this client detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this client detail.
	 *
	 * @param name the name of this client detail
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the phone no of this client detail.
	 *
	 * @param phoneNo the phone no of this client detail
	 */
	@Override
	public void setPhoneNo(String phoneNo) {
		model.setPhoneNo(phoneNo);
	}

	/**
	 * Sets the primary key of this client detail.
	 *
	 * @param primaryKey the primary key of this client detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this client detail.
	 *
	 * @param userId the user ID of this client detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this client detail.
	 *
	 * @param userName the user name of this client detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this client detail.
	 *
	 * @param userUuid the user uuid of this client detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this client detail.
	 *
	 * @param uuid the uuid of this client detail
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ClientDetailWrapper wrap(ClientDetail clientDetail) {
		return new ClientDetailWrapper(clientDetail);
	}

}