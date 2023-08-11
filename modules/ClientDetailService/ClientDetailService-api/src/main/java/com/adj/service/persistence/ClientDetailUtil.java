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

package com.adj.service.persistence;

import com.adj.model.ClientDetail;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the client detail service. This utility wraps <code>com.adj.service.persistence.impl.ClientDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientDetailPersistence
 * @generated
 */
public class ClientDetailUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ClientDetail clientDetail) {
		getPersistence().clearCache(clientDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ClientDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClientDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClientDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClientDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClientDetail update(ClientDetail clientDetail) {
		return getPersistence().update(clientDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClientDetail update(
		ClientDetail clientDetail, ServiceContext serviceContext) {

		return getPersistence().update(clientDetail, serviceContext);
	}

	/**
	 * Returns all the client details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching client details
	 */
	public static List<ClientDetail> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the client details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of matching client details
	 */
	public static List<ClientDetail> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the client details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByUuid_First(
			String uuid, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByUuid_First(
		String uuid, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByUuid_Last(
			String uuid, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByUuid_Last(
		String uuid, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the client details before and after the current client detail in the ordered set where uuid = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail[] findByUuid_PrevAndNext(
			long clientId, String uuid,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByUuid_PrevAndNext(
			clientId, uuid, orderByComparator);
	}

	/**
	 * Removes all the client details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of client details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching client details
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the client detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchClientDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByUUID_G(String uuid, long groupId)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the client detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the client detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the client detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the client detail that was removed
	 */
	public static ClientDetail removeByUUID_G(String uuid, long groupId)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of client details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching client details
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the client details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching client details
	 */
	public static List<ClientDetail> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the client details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of matching client details
	 */
	public static List<ClientDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the client details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the client details before and after the current client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail[] findByUuid_C_PrevAndNext(
			long clientId, String uuid, long companyId,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByUuid_C_PrevAndNext(
			clientId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the client details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of client details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching client details
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the client details where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching client details
	 */
	public static List<ClientDetail> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the client details where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of matching client details
	 */
	public static List<ClientDetail> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the client details where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByName(
		String name, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client details where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByName(
		String name, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByName_First(
			String name, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByName_First(
		String name, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByName_Last(
			String name, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByName_Last(
		String name, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the client details before and after the current client detail in the ordered set where name = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail[] findByName_PrevAndNext(
			long clientId, String name,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByName_PrevAndNext(
			clientId, name, orderByComparator);
	}

	/**
	 * Removes all the client details where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of client details where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching client details
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the client details where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching client details
	 */
	public static List<ClientDetail> findByEmail(String email) {
		return getPersistence().findByEmail(email);
	}

	/**
	 * Returns a range of all the client details where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of matching client details
	 */
	public static List<ClientDetail> findByEmail(
		String email, int start, int end) {

		return getPersistence().findByEmail(email, start, end);
	}

	/**
	 * Returns an ordered range of all the client details where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByEmail(
		String email, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client details where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByEmail(
		String email, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByEmail_First(
			String email, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the first client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByEmail_First(
		String email, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByEmail_Last(
			String email, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByEmail_Last(email, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByEmail_Last(
		String email, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByEmail_Last(email, orderByComparator);
	}

	/**
	 * Returns the client details before and after the current client detail in the ordered set where email = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail[] findByEmail_PrevAndNext(
			long clientId, String email,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByEmail_PrevAndNext(
			clientId, email, orderByComparator);
	}

	/**
	 * Removes all the client details where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public static void removeByEmail(String email) {
		getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of client details where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching client details
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Returns all the client details where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @return the matching client details
	 */
	public static List<ClientDetail> findByConfirmEmail(String confirmEmail) {
		return getPersistence().findByConfirmEmail(confirmEmail);
	}

	/**
	 * Returns a range of all the client details where confirmEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param confirmEmail the confirm email
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of matching client details
	 */
	public static List<ClientDetail> findByConfirmEmail(
		String confirmEmail, int start, int end) {

		return getPersistence().findByConfirmEmail(confirmEmail, start, end);
	}

	/**
	 * Returns an ordered range of all the client details where confirmEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param confirmEmail the confirm email
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByConfirmEmail(
		String confirmEmail, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findByConfirmEmail(
			confirmEmail, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client details where confirmEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param confirmEmail the confirm email
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByConfirmEmail(
		String confirmEmail, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByConfirmEmail(
			confirmEmail, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByConfirmEmail_First(
			String confirmEmail,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByConfirmEmail_First(
			confirmEmail, orderByComparator);
	}

	/**
	 * Returns the first client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByConfirmEmail_First(
		String confirmEmail,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByConfirmEmail_First(
			confirmEmail, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByConfirmEmail_Last(
			String confirmEmail,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByConfirmEmail_Last(
			confirmEmail, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByConfirmEmail_Last(
		String confirmEmail,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByConfirmEmail_Last(
			confirmEmail, orderByComparator);
	}

	/**
	 * Returns the client details before and after the current client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail[] findByConfirmEmail_PrevAndNext(
			long clientId, String confirmEmail,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByConfirmEmail_PrevAndNext(
			clientId, confirmEmail, orderByComparator);
	}

	/**
	 * Removes all the client details where confirmEmail = &#63; from the database.
	 *
	 * @param confirmEmail the confirm email
	 */
	public static void removeByConfirmEmail(String confirmEmail) {
		getPersistence().removeByConfirmEmail(confirmEmail);
	}

	/**
	 * Returns the number of client details where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @return the number of matching client details
	 */
	public static int countByConfirmEmail(String confirmEmail) {
		return getPersistence().countByConfirmEmail(confirmEmail);
	}

	/**
	 * Returns all the client details where age = &#63;.
	 *
	 * @param age the age
	 * @return the matching client details
	 */
	public static List<ClientDetail> findByAge(String age) {
		return getPersistence().findByAge(age);
	}

	/**
	 * Returns a range of all the client details where age = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param age the age
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of matching client details
	 */
	public static List<ClientDetail> findByAge(String age, int start, int end) {
		return getPersistence().findByAge(age, start, end);
	}

	/**
	 * Returns an ordered range of all the client details where age = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param age the age
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByAge(
		String age, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findByAge(age, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client details where age = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param age the age
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByAge(
		String age, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAge(
			age, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByAge_First(
			String age, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByAge_First(age, orderByComparator);
	}

	/**
	 * Returns the first client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByAge_First(
		String age, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByAge_First(age, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByAge_Last(
			String age, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByAge_Last(age, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByAge_Last(
		String age, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByAge_Last(age, orderByComparator);
	}

	/**
	 * Returns the client details before and after the current client detail in the ordered set where age = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail[] findByAge_PrevAndNext(
			long clientId, String age,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByAge_PrevAndNext(
			clientId, age, orderByComparator);
	}

	/**
	 * Removes all the client details where age = &#63; from the database.
	 *
	 * @param age the age
	 */
	public static void removeByAge(String age) {
		getPersistence().removeByAge(age);
	}

	/**
	 * Returns the number of client details where age = &#63;.
	 *
	 * @param age the age
	 * @return the number of matching client details
	 */
	public static int countByAge(String age) {
		return getPersistence().countByAge(age);
	}

	/**
	 * Returns all the client details where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @return the matching client details
	 */
	public static List<ClientDetail> findByPhoneNo(String phoneNo) {
		return getPersistence().findByPhoneNo(phoneNo);
	}

	/**
	 * Returns a range of all the client details where phoneNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param phoneNo the phone no
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of matching client details
	 */
	public static List<ClientDetail> findByPhoneNo(
		String phoneNo, int start, int end) {

		return getPersistence().findByPhoneNo(phoneNo, start, end);
	}

	/**
	 * Returns an ordered range of all the client details where phoneNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param phoneNo the phone no
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByPhoneNo(
		String phoneNo, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findByPhoneNo(
			phoneNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client details where phoneNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param phoneNo the phone no
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByPhoneNo(
		String phoneNo, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPhoneNo(
			phoneNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByPhoneNo_First(
			String phoneNo, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByPhoneNo_First(phoneNo, orderByComparator);
	}

	/**
	 * Returns the first client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByPhoneNo_First(
		String phoneNo, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByPhoneNo_First(
			phoneNo, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByPhoneNo_Last(
			String phoneNo, OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByPhoneNo_Last(phoneNo, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByPhoneNo_Last(
		String phoneNo, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByPhoneNo_Last(phoneNo, orderByComparator);
	}

	/**
	 * Returns the client details before and after the current client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail[] findByPhoneNo_PrevAndNext(
			long clientId, String phoneNo,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByPhoneNo_PrevAndNext(
			clientId, phoneNo, orderByComparator);
	}

	/**
	 * Removes all the client details where phoneNo = &#63; from the database.
	 *
	 * @param phoneNo the phone no
	 */
	public static void removeByPhoneNo(String phoneNo) {
		getPersistence().removeByPhoneNo(phoneNo);
	}

	/**
	 * Returns the number of client details where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @return the number of matching client details
	 */
	public static int countByPhoneNo(String phoneNo) {
		return getPersistence().countByPhoneNo(phoneNo);
	}

	/**
	 * Returns all the client details where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @return the matching client details
	 */
	public static List<ClientDetail> findByAadharCard(String aadharCard) {
		return getPersistence().findByAadharCard(aadharCard);
	}

	/**
	 * Returns a range of all the client details where aadharCard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param aadharCard the aadhar card
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of matching client details
	 */
	public static List<ClientDetail> findByAadharCard(
		String aadharCard, int start, int end) {

		return getPersistence().findByAadharCard(aadharCard, start, end);
	}

	/**
	 * Returns an ordered range of all the client details where aadharCard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param aadharCard the aadhar card
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByAadharCard(
		String aadharCard, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findByAadharCard(
			aadharCard, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client details where aadharCard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param aadharCard the aadhar card
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client details
	 */
	public static List<ClientDetail> findByAadharCard(
		String aadharCard, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAadharCard(
			aadharCard, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByAadharCard_First(
			String aadharCard,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByAadharCard_First(
			aadharCard, orderByComparator);
	}

	/**
	 * Returns the first client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByAadharCard_First(
		String aadharCard, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByAadharCard_First(
			aadharCard, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public static ClientDetail findByAadharCard_Last(
			String aadharCard,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByAadharCard_Last(
			aadharCard, orderByComparator);
	}

	/**
	 * Returns the last client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchByAadharCard_Last(
		String aadharCard, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().fetchByAadharCard_Last(
			aadharCard, orderByComparator);
	}

	/**
	 * Returns the client details before and after the current client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail[] findByAadharCard_PrevAndNext(
			long clientId, String aadharCard,
			OrderByComparator<ClientDetail> orderByComparator)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByAadharCard_PrevAndNext(
			clientId, aadharCard, orderByComparator);
	}

	/**
	 * Removes all the client details where aadharCard = &#63; from the database.
	 *
	 * @param aadharCard the aadhar card
	 */
	public static void removeByAadharCard(String aadharCard) {
		getPersistence().removeByAadharCard(aadharCard);
	}

	/**
	 * Returns the number of client details where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @return the number of matching client details
	 */
	public static int countByAadharCard(String aadharCard) {
		return getPersistence().countByAadharCard(aadharCard);
	}

	/**
	 * Caches the client detail in the entity cache if it is enabled.
	 *
	 * @param clientDetail the client detail
	 */
	public static void cacheResult(ClientDetail clientDetail) {
		getPersistence().cacheResult(clientDetail);
	}

	/**
	 * Caches the client details in the entity cache if it is enabled.
	 *
	 * @param clientDetails the client details
	 */
	public static void cacheResult(List<ClientDetail> clientDetails) {
		getPersistence().cacheResult(clientDetails);
	}

	/**
	 * Creates a new client detail with the primary key. Does not add the client detail to the database.
	 *
	 * @param clientId the primary key for the new client detail
	 * @return the new client detail
	 */
	public static ClientDetail create(long clientId) {
		return getPersistence().create(clientId);
	}

	/**
	 * Removes the client detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail that was removed
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail remove(long clientId)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().remove(clientId);
	}

	public static ClientDetail updateImpl(ClientDetail clientDetail) {
		return getPersistence().updateImpl(clientDetail);
	}

	/**
	 * Returns the client detail with the primary key or throws a <code>NoSuchClientDetailException</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public static ClientDetail findByPrimaryKey(long clientId)
		throws com.adj.exception.NoSuchClientDetailException {

		return getPersistence().findByPrimaryKey(clientId);
	}

	/**
	 * Returns the client detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail, or <code>null</code> if a client detail with the primary key could not be found
	 */
	public static ClientDetail fetchByPrimaryKey(long clientId) {
		return getPersistence().fetchByPrimaryKey(clientId);
	}

	/**
	 * Returns all the client details.
	 *
	 * @return the client details
	 */
	public static List<ClientDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the client details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of client details
	 */
	public static List<ClientDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the client details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of client details
	 */
	public static List<ClientDetail> findAll(
		int start, int end, OrderByComparator<ClientDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of client details
	 */
	public static List<ClientDetail> findAll(
		int start, int end, OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the client details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of client details.
	 *
	 * @return the number of client details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClientDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClientDetailPersistence, ClientDetailPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClientDetailPersistence.class);

		ServiceTracker<ClientDetailPersistence, ClientDetailPersistence>
			serviceTracker =
				new ServiceTracker
					<ClientDetailPersistence, ClientDetailPersistence>(
						bundle.getBundleContext(),
						ClientDetailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}