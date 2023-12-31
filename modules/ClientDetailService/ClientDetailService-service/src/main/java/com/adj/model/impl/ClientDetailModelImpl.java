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
import com.adj.model.ClientDetailModel;
import com.adj.model.ClientDetailSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ClientDetail service. Represents a row in the &quot;ClientDetail_ClientDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ClientDetailModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ClientDetailImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientDetailImpl
 * @generated
 */
@JSON(strict = true)
public class ClientDetailModelImpl
	extends BaseModelImpl<ClientDetail> implements ClientDetailModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a client detail model instance should use the <code>ClientDetail</code> interface instead.
	 */
	public static final String TABLE_NAME = "ClientDetail_ClientDetail";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"clientId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"email", Types.VARCHAR},
		{"confirmEmail", Types.VARCHAR}, {"age", Types.VARCHAR},
		{"phoneNo", Types.VARCHAR}, {"aadharCard", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("clientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("confirmEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("age", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phoneNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("aadharCard", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ClientDetail_ClientDetail (uuid_ VARCHAR(75) null,clientId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,email VARCHAR(75) null,confirmEmail VARCHAR(75) null,age VARCHAR(75) null,phoneNo VARCHAR(75) null,aadharCard VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table ClientDetail_ClientDetail";

	public static final String ORDER_BY_JPQL =
		" ORDER BY clientDetail.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ClientDetail_ClientDetail.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AADHARCARD_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AGE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CONFIRMEMAIL_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMAIL_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PHONENO_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 256L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static ClientDetail toModel(ClientDetailSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ClientDetail model = new ClientDetailImpl();

		model.setUuid(soapModel.getUuid());
		model.setClientId(soapModel.getClientId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setEmail(soapModel.getEmail());
		model.setConfirmEmail(soapModel.getConfirmEmail());
		model.setAge(soapModel.getAge());
		model.setPhoneNo(soapModel.getPhoneNo());
		model.setAadharCard(soapModel.getAadharCard());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<ClientDetail> toModels(ClientDetailSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ClientDetail> models = new ArrayList<ClientDetail>(
			soapModels.length);

		for (ClientDetailSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ClientDetailModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _clientId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClientId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _clientId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ClientDetail.class;
	}

	@Override
	public String getModelClassName() {
		return ClientDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ClientDetail, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ClientDetail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ClientDetail, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ClientDetail)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ClientDetail, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ClientDetail, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ClientDetail)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ClientDetail, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ClientDetail, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ClientDetail>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ClientDetail.class.getClassLoader(), ClientDetail.class,
			ModelWrapper.class);

		try {
			Constructor<ClientDetail> constructor =
				(Constructor<ClientDetail>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<ClientDetail, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ClientDetail, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ClientDetail, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ClientDetail, Object>>();
		Map<String, BiConsumer<ClientDetail, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ClientDetail, ?>>();

		attributeGetterFunctions.put("uuid", ClientDetail::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<ClientDetail, String>)ClientDetail::setUuid);
		attributeGetterFunctions.put("clientId", ClientDetail::getClientId);
		attributeSetterBiConsumers.put(
			"clientId",
			(BiConsumer<ClientDetail, Long>)ClientDetail::setClientId);
		attributeGetterFunctions.put("groupId", ClientDetail::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ClientDetail, Long>)ClientDetail::setGroupId);
		attributeGetterFunctions.put("companyId", ClientDetail::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ClientDetail, Long>)ClientDetail::setCompanyId);
		attributeGetterFunctions.put("userId", ClientDetail::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<ClientDetail, Long>)ClientDetail::setUserId);
		attributeGetterFunctions.put("userName", ClientDetail::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ClientDetail, String>)ClientDetail::setUserName);
		attributeGetterFunctions.put("createDate", ClientDetail::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ClientDetail, Date>)ClientDetail::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ClientDetail::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ClientDetail, Date>)ClientDetail::setModifiedDate);
		attributeGetterFunctions.put("name", ClientDetail::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<ClientDetail, String>)ClientDetail::setName);
		attributeGetterFunctions.put("email", ClientDetail::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<ClientDetail, String>)ClientDetail::setEmail);
		attributeGetterFunctions.put(
			"confirmEmail", ClientDetail::getConfirmEmail);
		attributeSetterBiConsumers.put(
			"confirmEmail",
			(BiConsumer<ClientDetail, String>)ClientDetail::setConfirmEmail);
		attributeGetterFunctions.put("age", ClientDetail::getAge);
		attributeSetterBiConsumers.put(
			"age", (BiConsumer<ClientDetail, String>)ClientDetail::setAge);
		attributeGetterFunctions.put("phoneNo", ClientDetail::getPhoneNo);
		attributeSetterBiConsumers.put(
			"phoneNo",
			(BiConsumer<ClientDetail, String>)ClientDetail::setPhoneNo);
		attributeGetterFunctions.put("aadharCard", ClientDetail::getAadharCard);
		attributeSetterBiConsumers.put(
			"aadharCard",
			(BiConsumer<ClientDetail, String>)ClientDetail::setAadharCard);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getClientId() {
		return _clientId;
	}

	@Override
	public void setClientId(long clientId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_clientId = clientId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalEmail() {
		return getColumnOriginalValue("email");
	}

	@JSON
	@Override
	public String getConfirmEmail() {
		if (_confirmEmail == null) {
			return "";
		}
		else {
			return _confirmEmail;
		}
	}

	@Override
	public void setConfirmEmail(String confirmEmail) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_confirmEmail = confirmEmail;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalConfirmEmail() {
		return getColumnOriginalValue("confirmEmail");
	}

	@JSON
	@Override
	public String getAge() {
		if (_age == null) {
			return "";
		}
		else {
			return _age;
		}
	}

	@Override
	public void setAge(String age) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_age = age;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalAge() {
		return getColumnOriginalValue("age");
	}

	@JSON
	@Override
	public String getPhoneNo() {
		if (_phoneNo == null) {
			return "";
		}
		else {
			return _phoneNo;
		}
	}

	@Override
	public void setPhoneNo(String phoneNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phoneNo = phoneNo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPhoneNo() {
		return getColumnOriginalValue("phoneNo");
	}

	@JSON
	@Override
	public String getAadharCard() {
		if (_aadharCard == null) {
			return "";
		}
		else {
			return _aadharCard;
		}
	}

	@Override
	public void setAadharCard(String aadharCard) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_aadharCard = aadharCard;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalAadharCard() {
		return getColumnOriginalValue("aadharCard");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ClientDetail.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ClientDetail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ClientDetail toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ClientDetail>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ClientDetailImpl clientDetailImpl = new ClientDetailImpl();

		clientDetailImpl.setUuid(getUuid());
		clientDetailImpl.setClientId(getClientId());
		clientDetailImpl.setGroupId(getGroupId());
		clientDetailImpl.setCompanyId(getCompanyId());
		clientDetailImpl.setUserId(getUserId());
		clientDetailImpl.setUserName(getUserName());
		clientDetailImpl.setCreateDate(getCreateDate());
		clientDetailImpl.setModifiedDate(getModifiedDate());
		clientDetailImpl.setName(getName());
		clientDetailImpl.setEmail(getEmail());
		clientDetailImpl.setConfirmEmail(getConfirmEmail());
		clientDetailImpl.setAge(getAge());
		clientDetailImpl.setPhoneNo(getPhoneNo());
		clientDetailImpl.setAadharCard(getAadharCard());

		clientDetailImpl.resetOriginalValues();

		return clientDetailImpl;
	}

	@Override
	public int compareTo(ClientDetail clientDetail) {
		int value = 0;

		value = getName().compareTo(clientDetail.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClientDetail)) {
			return false;
		}

		ClientDetail clientDetail = (ClientDetail)object;

		long primaryKey = clientDetail.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ClientDetail> toCacheModel() {
		ClientDetailCacheModel clientDetailCacheModel =
			new ClientDetailCacheModel();

		clientDetailCacheModel.uuid = getUuid();

		String uuid = clientDetailCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			clientDetailCacheModel.uuid = null;
		}

		clientDetailCacheModel.clientId = getClientId();

		clientDetailCacheModel.groupId = getGroupId();

		clientDetailCacheModel.companyId = getCompanyId();

		clientDetailCacheModel.userId = getUserId();

		clientDetailCacheModel.userName = getUserName();

		String userName = clientDetailCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			clientDetailCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			clientDetailCacheModel.createDate = createDate.getTime();
		}
		else {
			clientDetailCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			clientDetailCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			clientDetailCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		clientDetailCacheModel.name = getName();

		String name = clientDetailCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			clientDetailCacheModel.name = null;
		}

		clientDetailCacheModel.email = getEmail();

		String email = clientDetailCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			clientDetailCacheModel.email = null;
		}

		clientDetailCacheModel.confirmEmail = getConfirmEmail();

		String confirmEmail = clientDetailCacheModel.confirmEmail;

		if ((confirmEmail != null) && (confirmEmail.length() == 0)) {
			clientDetailCacheModel.confirmEmail = null;
		}

		clientDetailCacheModel.age = getAge();

		String age = clientDetailCacheModel.age;

		if ((age != null) && (age.length() == 0)) {
			clientDetailCacheModel.age = null;
		}

		clientDetailCacheModel.phoneNo = getPhoneNo();

		String phoneNo = clientDetailCacheModel.phoneNo;

		if ((phoneNo != null) && (phoneNo.length() == 0)) {
			clientDetailCacheModel.phoneNo = null;
		}

		clientDetailCacheModel.aadharCard = getAadharCard();

		String aadharCard = clientDetailCacheModel.aadharCard;

		if ((aadharCard != null) && (aadharCard.length() == 0)) {
			clientDetailCacheModel.aadharCard = null;
		}

		return clientDetailCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ClientDetail, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ClientDetail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ClientDetail, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ClientDetail)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ClientDetail, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ClientDetail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ClientDetail, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ClientDetail)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ClientDetail>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _clientId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _email;
	private String _confirmEmail;
	private String _age;
	private String _phoneNo;
	private String _aadharCard;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ClientDetail, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ClientDetail)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("clientId", _clientId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("confirmEmail", _confirmEmail);
		_columnOriginalValues.put("age", _age);
		_columnOriginalValues.put("phoneNo", _phoneNo);
		_columnOriginalValues.put("aadharCard", _aadharCard);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("clientId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("name", 256L);

		columnBitmasks.put("email", 512L);

		columnBitmasks.put("confirmEmail", 1024L);

		columnBitmasks.put("age", 2048L);

		columnBitmasks.put("phoneNo", 4096L);

		columnBitmasks.put("aadharCard", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ClientDetail _escapedModel;

}