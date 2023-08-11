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

import com.adj.exception.NoSuchClientDetailException;
import com.adj.model.ClientDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the client detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientDetailUtil
 * @generated
 */
@ProviderType
public interface ClientDetailPersistence extends BasePersistence<ClientDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClientDetailUtil} to access the client detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the client details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching client details
	 */
	public java.util.List<ClientDetail> findByUuid(String uuid);

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
	public java.util.List<ClientDetail> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ClientDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public java.util.List<ClientDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the client details before and after the current client detail in the ordered set where uuid = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public ClientDetail[] findByUuid_PrevAndNext(
			long clientId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Removes all the client details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of client details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching client details
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the client detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchClientDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchClientDetailException;

	/**
	 * Returns the client detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the client detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the client detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the client detail that was removed
	 */
	public ClientDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchClientDetailException;

	/**
	 * Returns the number of client details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching client details
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the client details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching client details
	 */
	public java.util.List<ClientDetail> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ClientDetail> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ClientDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public java.util.List<ClientDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public ClientDetail[] findByUuid_C_PrevAndNext(
			long clientId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Removes all the client details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of client details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching client details
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the client details where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching client details
	 */
	public java.util.List<ClientDetail> findByName(String name);

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
	public java.util.List<ClientDetail> findByName(
		String name, int start, int end);

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
	public java.util.List<ClientDetail> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public java.util.List<ClientDetail> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the first client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the last client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the last client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the client details before and after the current client detail in the ordered set where name = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public ClientDetail[] findByName_PrevAndNext(
			long clientId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Removes all the client details where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of client details where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching client details
	 */
	public int countByName(String name);

	/**
	 * Returns all the client details where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching client details
	 */
	public java.util.List<ClientDetail> findByEmail(String email);

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
	public java.util.List<ClientDetail> findByEmail(
		String email, int start, int end);

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
	public java.util.List<ClientDetail> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public java.util.List<ClientDetail> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByEmail_First(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the first client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByEmail_First(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the last client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByEmail_Last(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the last client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByEmail_Last(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the client details before and after the current client detail in the ordered set where email = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public ClientDetail[] findByEmail_PrevAndNext(
			long clientId, String email,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Removes all the client details where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public void removeByEmail(String email);

	/**
	 * Returns the number of client details where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching client details
	 */
	public int countByEmail(String email);

	/**
	 * Returns all the client details where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @return the matching client details
	 */
	public java.util.List<ClientDetail> findByConfirmEmail(String confirmEmail);

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
	public java.util.List<ClientDetail> findByConfirmEmail(
		String confirmEmail, int start, int end);

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
	public java.util.List<ClientDetail> findByConfirmEmail(
		String confirmEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public java.util.List<ClientDetail> findByConfirmEmail(
		String confirmEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByConfirmEmail_First(
			String confirmEmail,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the first client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByConfirmEmail_First(
		String confirmEmail,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the last client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByConfirmEmail_Last(
			String confirmEmail,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the last client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByConfirmEmail_Last(
		String confirmEmail,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the client details before and after the current client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public ClientDetail[] findByConfirmEmail_PrevAndNext(
			long clientId, String confirmEmail,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Removes all the client details where confirmEmail = &#63; from the database.
	 *
	 * @param confirmEmail the confirm email
	 */
	public void removeByConfirmEmail(String confirmEmail);

	/**
	 * Returns the number of client details where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @return the number of matching client details
	 */
	public int countByConfirmEmail(String confirmEmail);

	/**
	 * Returns all the client details where age = &#63;.
	 *
	 * @param age the age
	 * @return the matching client details
	 */
	public java.util.List<ClientDetail> findByAge(String age);

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
	public java.util.List<ClientDetail> findByAge(
		String age, int start, int end);

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
	public java.util.List<ClientDetail> findByAge(
		String age, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public java.util.List<ClientDetail> findByAge(
		String age, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByAge_First(
			String age,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the first client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByAge_First(
		String age,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the last client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByAge_Last(
			String age,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the last client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByAge_Last(
		String age,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the client details before and after the current client detail in the ordered set where age = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public ClientDetail[] findByAge_PrevAndNext(
			long clientId, String age,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Removes all the client details where age = &#63; from the database.
	 *
	 * @param age the age
	 */
	public void removeByAge(String age);

	/**
	 * Returns the number of client details where age = &#63;.
	 *
	 * @param age the age
	 * @return the number of matching client details
	 */
	public int countByAge(String age);

	/**
	 * Returns all the client details where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @return the matching client details
	 */
	public java.util.List<ClientDetail> findByPhoneNo(String phoneNo);

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
	public java.util.List<ClientDetail> findByPhoneNo(
		String phoneNo, int start, int end);

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
	public java.util.List<ClientDetail> findByPhoneNo(
		String phoneNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public java.util.List<ClientDetail> findByPhoneNo(
		String phoneNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByPhoneNo_First(
			String phoneNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the first client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByPhoneNo_First(
		String phoneNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the last client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByPhoneNo_Last(
			String phoneNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the last client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByPhoneNo_Last(
		String phoneNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the client details before and after the current client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public ClientDetail[] findByPhoneNo_PrevAndNext(
			long clientId, String phoneNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Removes all the client details where phoneNo = &#63; from the database.
	 *
	 * @param phoneNo the phone no
	 */
	public void removeByPhoneNo(String phoneNo);

	/**
	 * Returns the number of client details where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @return the number of matching client details
	 */
	public int countByPhoneNo(String phoneNo);

	/**
	 * Returns all the client details where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @return the matching client details
	 */
	public java.util.List<ClientDetail> findByAadharCard(String aadharCard);

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
	public java.util.List<ClientDetail> findByAadharCard(
		String aadharCard, int start, int end);

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
	public java.util.List<ClientDetail> findByAadharCard(
		String aadharCard, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public java.util.List<ClientDetail> findByAadharCard(
		String aadharCard, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByAadharCard_First(
			String aadharCard,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the first client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByAadharCard_First(
		String aadharCard,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the last client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	public ClientDetail findByAadharCard_Last(
			String aadharCard,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Returns the last client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public ClientDetail fetchByAadharCard_Last(
		String aadharCard,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

	/**
	 * Returns the client details before and after the current client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param clientId the primary key of the current client detail
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public ClientDetail[] findByAadharCard_PrevAndNext(
			long clientId, String aadharCard,
			com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
				orderByComparator)
		throws NoSuchClientDetailException;

	/**
	 * Removes all the client details where aadharCard = &#63; from the database.
	 *
	 * @param aadharCard the aadhar card
	 */
	public void removeByAadharCard(String aadharCard);

	/**
	 * Returns the number of client details where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @return the number of matching client details
	 */
	public int countByAadharCard(String aadharCard);

	/**
	 * Caches the client detail in the entity cache if it is enabled.
	 *
	 * @param clientDetail the client detail
	 */
	public void cacheResult(ClientDetail clientDetail);

	/**
	 * Caches the client details in the entity cache if it is enabled.
	 *
	 * @param clientDetails the client details
	 */
	public void cacheResult(java.util.List<ClientDetail> clientDetails);

	/**
	 * Creates a new client detail with the primary key. Does not add the client detail to the database.
	 *
	 * @param clientId the primary key for the new client detail
	 * @return the new client detail
	 */
	public ClientDetail create(long clientId);

	/**
	 * Removes the client detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail that was removed
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public ClientDetail remove(long clientId)
		throws NoSuchClientDetailException;

	public ClientDetail updateImpl(ClientDetail clientDetail);

	/**
	 * Returns the client detail with the primary key or throws a <code>NoSuchClientDetailException</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	public ClientDetail findByPrimaryKey(long clientId)
		throws NoSuchClientDetailException;

	/**
	 * Returns the client detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail, or <code>null</code> if a client detail with the primary key could not be found
	 */
	public ClientDetail fetchByPrimaryKey(long clientId);

	/**
	 * Returns all the client details.
	 *
	 * @return the client details
	 */
	public java.util.List<ClientDetail> findAll();

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
	public java.util.List<ClientDetail> findAll(int start, int end);

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
	public java.util.List<ClientDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator);

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
	public java.util.List<ClientDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the client details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of client details.
	 *
	 * @return the number of client details
	 */
	public int countAll();

}