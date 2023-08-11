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

package com.adj.model.impl;

import com.adj.model.ClientDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClientDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClientDetailCacheModel
	implements CacheModel<ClientDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClientDetailCacheModel)) {
			return false;
		}

		ClientDetailCacheModel clientDetailCacheModel =
			(ClientDetailCacheModel)object;

		if (clientId == clientDetailCacheModel.clientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", confirmEmail=");
		sb.append(confirmEmail);
		sb.append(", age=");
		sb.append(age);
		sb.append(", phoneNo=");
		sb.append(phoneNo);
		sb.append(", aadharCard=");
		sb.append(aadharCard);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClientDetail toEntityModel() {
		ClientDetailImpl clientDetailImpl = new ClientDetailImpl();

		if (uuid == null) {
			clientDetailImpl.setUuid("");
		}
		else {
			clientDetailImpl.setUuid(uuid);
		}

		clientDetailImpl.setClientId(clientId);
		clientDetailImpl.setGroupId(groupId);
		clientDetailImpl.setCompanyId(companyId);
		clientDetailImpl.setUserId(userId);

		if (userName == null) {
			clientDetailImpl.setUserName("");
		}
		else {
			clientDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			clientDetailImpl.setCreateDate(null);
		}
		else {
			clientDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			clientDetailImpl.setModifiedDate(null);
		}
		else {
			clientDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			clientDetailImpl.setName("");
		}
		else {
			clientDetailImpl.setName(name);
		}

		if (email == null) {
			clientDetailImpl.setEmail("");
		}
		else {
			clientDetailImpl.setEmail(email);
		}

		if (confirmEmail == null) {
			clientDetailImpl.setConfirmEmail("");
		}
		else {
			clientDetailImpl.setConfirmEmail(confirmEmail);
		}

		if (age == null) {
			clientDetailImpl.setAge("");
		}
		else {
			clientDetailImpl.setAge(age);
		}

		if (phoneNo == null) {
			clientDetailImpl.setPhoneNo("");
		}
		else {
			clientDetailImpl.setPhoneNo(phoneNo);
		}

		if (aadharCard == null) {
			clientDetailImpl.setAadharCard("");
		}
		else {
			clientDetailImpl.setAadharCard(aadharCard);
		}

		clientDetailImpl.resetOriginalValues();

		return clientDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		clientId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		confirmEmail = objectInput.readUTF();
		age = objectInput.readUTF();
		phoneNo = objectInput.readUTF();
		aadharCard = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(clientId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (confirmEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(confirmEmail);
		}

		if (age == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(age);
		}

		if (phoneNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNo);
		}

		if (aadharCard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadharCard);
		}
	}

	public String uuid;
	public long clientId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String email;
	public String confirmEmail;
	public String age;
	public String phoneNo;
	public String aadharCard;

}