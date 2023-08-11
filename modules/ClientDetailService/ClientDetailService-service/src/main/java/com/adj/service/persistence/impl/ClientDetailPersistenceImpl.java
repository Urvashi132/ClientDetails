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

package com.adj.service.persistence.impl;

import com.adj.exception.NoSuchClientDetailException;
import com.adj.model.ClientDetail;
import com.adj.model.impl.ClientDetailImpl;
import com.adj.model.impl.ClientDetailModelImpl;
import com.adj.service.persistence.ClientDetailPersistence;
import com.adj.service.persistence.impl.constants.ClientDetailPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the client detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClientDetailPersistence.class)
public class ClientDetailPersistenceImpl
	extends BasePersistenceImpl<ClientDetail>
	implements ClientDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClientDetailUtil</code> to access the client detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClientDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the client details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching client details
	 */
	@Override
	public List<ClientDetail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientDetail> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ClientDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ClientDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ClientDetail> list = null;

		if (useFinderCache) {
			list = (List<ClientDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientDetail clientDetail : list) {
					if (!uuid.equals(clientDetail.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ClientDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByUuid_First(
			String uuid, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByUuid_First(uuid, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByUuid_First(
		String uuid, OrderByComparator<ClientDetail> orderByComparator) {

		List<ClientDetail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByUuid_Last(
			String uuid, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByUuid_Last(uuid, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByUuid_Last(
		String uuid, OrderByComparator<ClientDetail> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ClientDetail> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientDetail[] findByUuid_PrevAndNext(
			long clientId, String uuid,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		uuid = Objects.toString(uuid, "");

		ClientDetail clientDetail = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			ClientDetail[] array = new ClientDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, clientDetail, uuid, orderByComparator, true);

			array[1] = clientDetail;

			array[2] = getByUuid_PrevAndNext(
				session, clientDetail, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientDetail getByUuid_PrevAndNext(
		Session session, ClientDetail clientDetail, String uuid,
		OrderByComparator<ClientDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clientDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the client details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ClientDetail clientDetail :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clientDetail);
		}
	}

	/**
	 * Returns the number of client details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching client details
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"clientDetail.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(clientDetail.uuid IS NULL OR clientDetail.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the client detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchClientDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByUUID_G(uuid, groupId);

		if (clientDetail == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchClientDetailException(sb.toString());
		}

		return clientDetail;
	}

	/**
	 * Returns the client detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the client detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof ClientDetail) {
			ClientDetail clientDetail = (ClientDetail)result;

			if (!Objects.equals(uuid, clientDetail.getUuid()) ||
				(groupId != clientDetail.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<ClientDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ClientDetail clientDetail = list.get(0);

					result = clientDetail;

					cacheResult(clientDetail);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ClientDetail)result;
		}
	}

	/**
	 * Removes the client detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the client detail that was removed
	 */
	@Override
	public ClientDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = findByUUID_G(uuid, groupId);

		return remove(clientDetail);
	}

	/**
	 * Returns the number of client details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching client details
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CLIENTDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"clientDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(clientDetail.uuid IS NULL OR clientDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"clientDetail.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the client details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching client details
	 */
	@Override
	public List<ClientDetail> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<ClientDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ClientDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ClientDetail> list = null;

		if (useFinderCache) {
			list = (List<ClientDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientDetail clientDetail : list) {
					if (!uuid.equals(clientDetail.getUuid()) ||
						(companyId != clientDetail.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<ClientDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public ClientDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the first client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ClientDetail> orderByComparator) {

		List<ClientDetail> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the last client detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ClientDetail> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ClientDetail> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientDetail[] findByUuid_C_PrevAndNext(
			long clientId, String uuid, long companyId,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		uuid = Objects.toString(uuid, "");

		ClientDetail clientDetail = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			ClientDetail[] array = new ClientDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, clientDetail, uuid, companyId, orderByComparator,
				true);

			array[1] = clientDetail;

			array[2] = getByUuid_C_PrevAndNext(
				session, clientDetail, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientDetail getByUuid_C_PrevAndNext(
		Session session, ClientDetail clientDetail, String uuid, long companyId,
		OrderByComparator<ClientDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clientDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the client details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ClientDetail clientDetail :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(clientDetail);
		}
	}

	/**
	 * Returns the number of client details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching client details
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CLIENTDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"clientDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(clientDetail.uuid IS NULL OR clientDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"clientDetail.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the client details where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching client details
	 */
	@Override
	public List<ClientDetail> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientDetail> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
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
	@Override
	public List<ClientDetail> findByName(
		String name, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
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
	@Override
	public List<ClientDetail> findByName(
		String name, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<ClientDetail> list = null;

		if (useFinderCache) {
			list = (List<ClientDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientDetail clientDetail : list) {
					if (!name.equals(clientDetail.getName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<ClientDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByName_First(
			String name, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByName_First(name, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the first client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByName_First(
		String name, OrderByComparator<ClientDetail> orderByComparator) {

		List<ClientDetail> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByName_Last(
			String name, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByName_Last(name, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the last client detail in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByName_Last(
		String name, OrderByComparator<ClientDetail> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ClientDetail> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientDetail[] findByName_PrevAndNext(
			long clientId, String name,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		name = Objects.toString(name, "");

		ClientDetail clientDetail = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			ClientDetail[] array = new ClientDetailImpl[3];

			array[0] = getByName_PrevAndNext(
				session, clientDetail, name, orderByComparator, true);

			array[1] = clientDetail;

			array[2] = getByName_PrevAndNext(
				session, clientDetail, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientDetail getByName_PrevAndNext(
		Session session, ClientDetail clientDetail, String name,
		OrderByComparator<ClientDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clientDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the client details where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (ClientDetail clientDetail :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clientDetail);
		}
	}

	/**
	 * Returns the number of client details where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching client details
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTDETAIL_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"clientDetail.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(clientDetail.name IS NULL OR clientDetail.name = '')";

	private FinderPath _finderPathWithPaginationFindByEmail;
	private FinderPath _finderPathWithoutPaginationFindByEmail;
	private FinderPath _finderPathCountByEmail;

	/**
	 * Returns all the client details where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching client details
	 */
	@Override
	public List<ClientDetail> findByEmail(String email) {
		return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientDetail> findByEmail(String email, int start, int end) {
		return findByEmail(email, start, end, null);
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
	@Override
	public List<ClientDetail> findByEmail(
		String email, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return findByEmail(email, start, end, orderByComparator, true);
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
	@Override
	public List<ClientDetail> findByEmail(
		String email, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		email = Objects.toString(email, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmail;
				finderArgs = new Object[] {email};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmail;
			finderArgs = new Object[] {email, start, end, orderByComparator};
		}

		List<ClientDetail> list = null;

		if (useFinderCache) {
			list = (List<ClientDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientDetail clientDetail : list) {
					if (!email.equals(clientDetail.getEmail())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				list = (List<ClientDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByEmail_First(
			String email, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByEmail_First(
			email, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the first client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByEmail_First(
		String email, OrderByComparator<ClientDetail> orderByComparator) {

		List<ClientDetail> list = findByEmail(email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByEmail_Last(
			String email, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByEmail_Last(email, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the last client detail in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByEmail_Last(
		String email, OrderByComparator<ClientDetail> orderByComparator) {

		int count = countByEmail(email);

		if (count == 0) {
			return null;
		}

		List<ClientDetail> list = findByEmail(
			email, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientDetail[] findByEmail_PrevAndNext(
			long clientId, String email,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		email = Objects.toString(email, "");

		ClientDetail clientDetail = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			ClientDetail[] array = new ClientDetailImpl[3];

			array[0] = getByEmail_PrevAndNext(
				session, clientDetail, email, orderByComparator, true);

			array[1] = clientDetail;

			array[2] = getByEmail_PrevAndNext(
				session, clientDetail, email, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientDetail getByEmail_PrevAndNext(
		Session session, ClientDetail clientDetail, String email,
		OrderByComparator<ClientDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

		boolean bindEmail = false;

		if (email.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmail) {
			queryPos.add(email);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clientDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the client details where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByEmail(String email) {
		for (ClientDetail clientDetail :
				findByEmail(
					email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clientDetail);
		}
	}

	/**
	 * Returns the number of client details where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching client details
	 */
	@Override
	public int countByEmail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTDETAIL_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"clientDetail.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(clientDetail.email IS NULL OR clientDetail.email = '')";

	private FinderPath _finderPathWithPaginationFindByConfirmEmail;
	private FinderPath _finderPathWithoutPaginationFindByConfirmEmail;
	private FinderPath _finderPathCountByConfirmEmail;

	/**
	 * Returns all the client details where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @return the matching client details
	 */
	@Override
	public List<ClientDetail> findByConfirmEmail(String confirmEmail) {
		return findByConfirmEmail(
			confirmEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientDetail> findByConfirmEmail(
		String confirmEmail, int start, int end) {

		return findByConfirmEmail(confirmEmail, start, end, null);
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
	@Override
	public List<ClientDetail> findByConfirmEmail(
		String confirmEmail, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return findByConfirmEmail(
			confirmEmail, start, end, orderByComparator, true);
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
	@Override
	public List<ClientDetail> findByConfirmEmail(
		String confirmEmail, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		confirmEmail = Objects.toString(confirmEmail, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByConfirmEmail;
				finderArgs = new Object[] {confirmEmail};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByConfirmEmail;
			finderArgs = new Object[] {
				confirmEmail, start, end, orderByComparator
			};
		}

		List<ClientDetail> list = null;

		if (useFinderCache) {
			list = (List<ClientDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientDetail clientDetail : list) {
					if (!confirmEmail.equals(clientDetail.getConfirmEmail())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

			boolean bindConfirmEmail = false;

			if (confirmEmail.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONFIRMEMAIL_CONFIRMEMAIL_3);
			}
			else {
				bindConfirmEmail = true;

				sb.append(_FINDER_COLUMN_CONFIRMEMAIL_CONFIRMEMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConfirmEmail) {
					queryPos.add(confirmEmail);
				}

				list = (List<ClientDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByConfirmEmail_First(
			String confirmEmail,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByConfirmEmail_First(
			confirmEmail, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("confirmEmail=");
		sb.append(confirmEmail);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the first client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByConfirmEmail_First(
		String confirmEmail,
		OrderByComparator<ClientDetail> orderByComparator) {

		List<ClientDetail> list = findByConfirmEmail(
			confirmEmail, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByConfirmEmail_Last(
			String confirmEmail,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByConfirmEmail_Last(
			confirmEmail, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("confirmEmail=");
		sb.append(confirmEmail);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the last client detail in the ordered set where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByConfirmEmail_Last(
		String confirmEmail,
		OrderByComparator<ClientDetail> orderByComparator) {

		int count = countByConfirmEmail(confirmEmail);

		if (count == 0) {
			return null;
		}

		List<ClientDetail> list = findByConfirmEmail(
			confirmEmail, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientDetail[] findByConfirmEmail_PrevAndNext(
			long clientId, String confirmEmail,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		confirmEmail = Objects.toString(confirmEmail, "");

		ClientDetail clientDetail = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			ClientDetail[] array = new ClientDetailImpl[3];

			array[0] = getByConfirmEmail_PrevAndNext(
				session, clientDetail, confirmEmail, orderByComparator, true);

			array[1] = clientDetail;

			array[2] = getByConfirmEmail_PrevAndNext(
				session, clientDetail, confirmEmail, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientDetail getByConfirmEmail_PrevAndNext(
		Session session, ClientDetail clientDetail, String confirmEmail,
		OrderByComparator<ClientDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

		boolean bindConfirmEmail = false;

		if (confirmEmail.isEmpty()) {
			sb.append(_FINDER_COLUMN_CONFIRMEMAIL_CONFIRMEMAIL_3);
		}
		else {
			bindConfirmEmail = true;

			sb.append(_FINDER_COLUMN_CONFIRMEMAIL_CONFIRMEMAIL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindConfirmEmail) {
			queryPos.add(confirmEmail);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clientDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the client details where confirmEmail = &#63; from the database.
	 *
	 * @param confirmEmail the confirm email
	 */
	@Override
	public void removeByConfirmEmail(String confirmEmail) {
		for (ClientDetail clientDetail :
				findByConfirmEmail(
					confirmEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clientDetail);
		}
	}

	/**
	 * Returns the number of client details where confirmEmail = &#63;.
	 *
	 * @param confirmEmail the confirm email
	 * @return the number of matching client details
	 */
	@Override
	public int countByConfirmEmail(String confirmEmail) {
		confirmEmail = Objects.toString(confirmEmail, "");

		FinderPath finderPath = _finderPathCountByConfirmEmail;

		Object[] finderArgs = new Object[] {confirmEmail};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTDETAIL_WHERE);

			boolean bindConfirmEmail = false;

			if (confirmEmail.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONFIRMEMAIL_CONFIRMEMAIL_3);
			}
			else {
				bindConfirmEmail = true;

				sb.append(_FINDER_COLUMN_CONFIRMEMAIL_CONFIRMEMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConfirmEmail) {
					queryPos.add(confirmEmail);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONFIRMEMAIL_CONFIRMEMAIL_2 =
		"clientDetail.confirmEmail = ?";

	private static final String _FINDER_COLUMN_CONFIRMEMAIL_CONFIRMEMAIL_3 =
		"(clientDetail.confirmEmail IS NULL OR clientDetail.confirmEmail = '')";

	private FinderPath _finderPathWithPaginationFindByAge;
	private FinderPath _finderPathWithoutPaginationFindByAge;
	private FinderPath _finderPathCountByAge;

	/**
	 * Returns all the client details where age = &#63;.
	 *
	 * @param age the age
	 * @return the matching client details
	 */
	@Override
	public List<ClientDetail> findByAge(String age) {
		return findByAge(age, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientDetail> findByAge(String age, int start, int end) {
		return findByAge(age, start, end, null);
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
	@Override
	public List<ClientDetail> findByAge(
		String age, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return findByAge(age, start, end, orderByComparator, true);
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
	@Override
	public List<ClientDetail> findByAge(
		String age, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		age = Objects.toString(age, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAge;
				finderArgs = new Object[] {age};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAge;
			finderArgs = new Object[] {age, start, end, orderByComparator};
		}

		List<ClientDetail> list = null;

		if (useFinderCache) {
			list = (List<ClientDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientDetail clientDetail : list) {
					if (!age.equals(clientDetail.getAge())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

			boolean bindAge = false;

			if (age.isEmpty()) {
				sb.append(_FINDER_COLUMN_AGE_AGE_3);
			}
			else {
				bindAge = true;

				sb.append(_FINDER_COLUMN_AGE_AGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAge) {
					queryPos.add(age);
				}

				list = (List<ClientDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByAge_First(
			String age, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByAge_First(age, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("age=");
		sb.append(age);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the first client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByAge_First(
		String age, OrderByComparator<ClientDetail> orderByComparator) {

		List<ClientDetail> list = findByAge(age, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByAge_Last(
			String age, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByAge_Last(age, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("age=");
		sb.append(age);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the last client detail in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByAge_Last(
		String age, OrderByComparator<ClientDetail> orderByComparator) {

		int count = countByAge(age);

		if (count == 0) {
			return null;
		}

		List<ClientDetail> list = findByAge(
			age, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientDetail[] findByAge_PrevAndNext(
			long clientId, String age,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		age = Objects.toString(age, "");

		ClientDetail clientDetail = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			ClientDetail[] array = new ClientDetailImpl[3];

			array[0] = getByAge_PrevAndNext(
				session, clientDetail, age, orderByComparator, true);

			array[1] = clientDetail;

			array[2] = getByAge_PrevAndNext(
				session, clientDetail, age, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientDetail getByAge_PrevAndNext(
		Session session, ClientDetail clientDetail, String age,
		OrderByComparator<ClientDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

		boolean bindAge = false;

		if (age.isEmpty()) {
			sb.append(_FINDER_COLUMN_AGE_AGE_3);
		}
		else {
			bindAge = true;

			sb.append(_FINDER_COLUMN_AGE_AGE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAge) {
			queryPos.add(age);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clientDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the client details where age = &#63; from the database.
	 *
	 * @param age the age
	 */
	@Override
	public void removeByAge(String age) {
		for (ClientDetail clientDetail :
				findByAge(age, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clientDetail);
		}
	}

	/**
	 * Returns the number of client details where age = &#63;.
	 *
	 * @param age the age
	 * @return the number of matching client details
	 */
	@Override
	public int countByAge(String age) {
		age = Objects.toString(age, "");

		FinderPath finderPath = _finderPathCountByAge;

		Object[] finderArgs = new Object[] {age};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTDETAIL_WHERE);

			boolean bindAge = false;

			if (age.isEmpty()) {
				sb.append(_FINDER_COLUMN_AGE_AGE_3);
			}
			else {
				bindAge = true;

				sb.append(_FINDER_COLUMN_AGE_AGE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAge) {
					queryPos.add(age);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_AGE_AGE_2 =
		"clientDetail.age = ?";

	private static final String _FINDER_COLUMN_AGE_AGE_3 =
		"(clientDetail.age IS NULL OR clientDetail.age = '')";

	private FinderPath _finderPathWithPaginationFindByPhoneNo;
	private FinderPath _finderPathWithoutPaginationFindByPhoneNo;
	private FinderPath _finderPathCountByPhoneNo;

	/**
	 * Returns all the client details where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @return the matching client details
	 */
	@Override
	public List<ClientDetail> findByPhoneNo(String phoneNo) {
		return findByPhoneNo(
			phoneNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientDetail> findByPhoneNo(
		String phoneNo, int start, int end) {

		return findByPhoneNo(phoneNo, start, end, null);
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
	@Override
	public List<ClientDetail> findByPhoneNo(
		String phoneNo, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return findByPhoneNo(phoneNo, start, end, orderByComparator, true);
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
	@Override
	public List<ClientDetail> findByPhoneNo(
		String phoneNo, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		phoneNo = Objects.toString(phoneNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPhoneNo;
				finderArgs = new Object[] {phoneNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPhoneNo;
			finderArgs = new Object[] {phoneNo, start, end, orderByComparator};
		}

		List<ClientDetail> list = null;

		if (useFinderCache) {
			list = (List<ClientDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientDetail clientDetail : list) {
					if (!phoneNo.equals(clientDetail.getPhoneNo())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

			boolean bindPhoneNo = false;

			if (phoneNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_PHONENO_PHONENO_3);
			}
			else {
				bindPhoneNo = true;

				sb.append(_FINDER_COLUMN_PHONENO_PHONENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPhoneNo) {
					queryPos.add(phoneNo);
				}

				list = (List<ClientDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByPhoneNo_First(
			String phoneNo, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByPhoneNo_First(
			phoneNo, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phoneNo=");
		sb.append(phoneNo);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the first client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByPhoneNo_First(
		String phoneNo, OrderByComparator<ClientDetail> orderByComparator) {

		List<ClientDetail> list = findByPhoneNo(
			phoneNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByPhoneNo_Last(
			String phoneNo, OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByPhoneNo_Last(
			phoneNo, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phoneNo=");
		sb.append(phoneNo);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the last client detail in the ordered set where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByPhoneNo_Last(
		String phoneNo, OrderByComparator<ClientDetail> orderByComparator) {

		int count = countByPhoneNo(phoneNo);

		if (count == 0) {
			return null;
		}

		List<ClientDetail> list = findByPhoneNo(
			phoneNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientDetail[] findByPhoneNo_PrevAndNext(
			long clientId, String phoneNo,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		phoneNo = Objects.toString(phoneNo, "");

		ClientDetail clientDetail = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			ClientDetail[] array = new ClientDetailImpl[3];

			array[0] = getByPhoneNo_PrevAndNext(
				session, clientDetail, phoneNo, orderByComparator, true);

			array[1] = clientDetail;

			array[2] = getByPhoneNo_PrevAndNext(
				session, clientDetail, phoneNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientDetail getByPhoneNo_PrevAndNext(
		Session session, ClientDetail clientDetail, String phoneNo,
		OrderByComparator<ClientDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

		boolean bindPhoneNo = false;

		if (phoneNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_PHONENO_PHONENO_3);
		}
		else {
			bindPhoneNo = true;

			sb.append(_FINDER_COLUMN_PHONENO_PHONENO_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPhoneNo) {
			queryPos.add(phoneNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clientDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the client details where phoneNo = &#63; from the database.
	 *
	 * @param phoneNo the phone no
	 */
	@Override
	public void removeByPhoneNo(String phoneNo) {
		for (ClientDetail clientDetail :
				findByPhoneNo(
					phoneNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clientDetail);
		}
	}

	/**
	 * Returns the number of client details where phoneNo = &#63;.
	 *
	 * @param phoneNo the phone no
	 * @return the number of matching client details
	 */
	@Override
	public int countByPhoneNo(String phoneNo) {
		phoneNo = Objects.toString(phoneNo, "");

		FinderPath finderPath = _finderPathCountByPhoneNo;

		Object[] finderArgs = new Object[] {phoneNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTDETAIL_WHERE);

			boolean bindPhoneNo = false;

			if (phoneNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_PHONENO_PHONENO_3);
			}
			else {
				bindPhoneNo = true;

				sb.append(_FINDER_COLUMN_PHONENO_PHONENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPhoneNo) {
					queryPos.add(phoneNo);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PHONENO_PHONENO_2 =
		"clientDetail.phoneNo = ?";

	private static final String _FINDER_COLUMN_PHONENO_PHONENO_3 =
		"(clientDetail.phoneNo IS NULL OR clientDetail.phoneNo = '')";

	private FinderPath _finderPathWithPaginationFindByAadharCard;
	private FinderPath _finderPathWithoutPaginationFindByAadharCard;
	private FinderPath _finderPathCountByAadharCard;

	/**
	 * Returns all the client details where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @return the matching client details
	 */
	@Override
	public List<ClientDetail> findByAadharCard(String aadharCard) {
		return findByAadharCard(
			aadharCard, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientDetail> findByAadharCard(
		String aadharCard, int start, int end) {

		return findByAadharCard(aadharCard, start, end, null);
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
	@Override
	public List<ClientDetail> findByAadharCard(
		String aadharCard, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return findByAadharCard(
			aadharCard, start, end, orderByComparator, true);
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
	@Override
	public List<ClientDetail> findByAadharCard(
		String aadharCard, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		aadharCard = Objects.toString(aadharCard, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAadharCard;
				finderArgs = new Object[] {aadharCard};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAadharCard;
			finderArgs = new Object[] {
				aadharCard, start, end, orderByComparator
			};
		}

		List<ClientDetail> list = null;

		if (useFinderCache) {
			list = (List<ClientDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientDetail clientDetail : list) {
					if (!aadharCard.equals(clientDetail.getAadharCard())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

			boolean bindAadharCard = false;

			if (aadharCard.isEmpty()) {
				sb.append(_FINDER_COLUMN_AADHARCARD_AADHARCARD_3);
			}
			else {
				bindAadharCard = true;

				sb.append(_FINDER_COLUMN_AADHARCARD_AADHARCARD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAadharCard) {
					queryPos.add(aadharCard);
				}

				list = (List<ClientDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByAadharCard_First(
			String aadharCard,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByAadharCard_First(
			aadharCard, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("aadharCard=");
		sb.append(aadharCard);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the first client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByAadharCard_First(
		String aadharCard, OrderByComparator<ClientDetail> orderByComparator) {

		List<ClientDetail> list = findByAadharCard(
			aadharCard, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail
	 * @throws NoSuchClientDetailException if a matching client detail could not be found
	 */
	@Override
	public ClientDetail findByAadharCard_Last(
			String aadharCard,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByAadharCard_Last(
			aadharCard, orderByComparator);

		if (clientDetail != null) {
			return clientDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("aadharCard=");
		sb.append(aadharCard);

		sb.append("}");

		throw new NoSuchClientDetailException(sb.toString());
	}

	/**
	 * Returns the last client detail in the ordered set where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public ClientDetail fetchByAadharCard_Last(
		String aadharCard, OrderByComparator<ClientDetail> orderByComparator) {

		int count = countByAadharCard(aadharCard);

		if (count == 0) {
			return null;
		}

		List<ClientDetail> list = findByAadharCard(
			aadharCard, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientDetail[] findByAadharCard_PrevAndNext(
			long clientId, String aadharCard,
			OrderByComparator<ClientDetail> orderByComparator)
		throws NoSuchClientDetailException {

		aadharCard = Objects.toString(aadharCard, "");

		ClientDetail clientDetail = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			ClientDetail[] array = new ClientDetailImpl[3];

			array[0] = getByAadharCard_PrevAndNext(
				session, clientDetail, aadharCard, orderByComparator, true);

			array[1] = clientDetail;

			array[2] = getByAadharCard_PrevAndNext(
				session, clientDetail, aadharCard, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientDetail getByAadharCard_PrevAndNext(
		Session session, ClientDetail clientDetail, String aadharCard,
		OrderByComparator<ClientDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENTDETAIL_WHERE);

		boolean bindAadharCard = false;

		if (aadharCard.isEmpty()) {
			sb.append(_FINDER_COLUMN_AADHARCARD_AADHARCARD_3);
		}
		else {
			bindAadharCard = true;

			sb.append(_FINDER_COLUMN_AADHARCARD_AADHARCARD_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClientDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAadharCard) {
			queryPos.add(aadharCard);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clientDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the client details where aadharCard = &#63; from the database.
	 *
	 * @param aadharCard the aadhar card
	 */
	@Override
	public void removeByAadharCard(String aadharCard) {
		for (ClientDetail clientDetail :
				findByAadharCard(
					aadharCard, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clientDetail);
		}
	}

	/**
	 * Returns the number of client details where aadharCard = &#63;.
	 *
	 * @param aadharCard the aadhar card
	 * @return the number of matching client details
	 */
	@Override
	public int countByAadharCard(String aadharCard) {
		aadharCard = Objects.toString(aadharCard, "");

		FinderPath finderPath = _finderPathCountByAadharCard;

		Object[] finderArgs = new Object[] {aadharCard};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTDETAIL_WHERE);

			boolean bindAadharCard = false;

			if (aadharCard.isEmpty()) {
				sb.append(_FINDER_COLUMN_AADHARCARD_AADHARCARD_3);
			}
			else {
				bindAadharCard = true;

				sb.append(_FINDER_COLUMN_AADHARCARD_AADHARCARD_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAadharCard) {
					queryPos.add(aadharCard);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_AADHARCARD_AADHARCARD_2 =
		"clientDetail.aadharCard = ?";

	private static final String _FINDER_COLUMN_AADHARCARD_AADHARCARD_3 =
		"(clientDetail.aadharCard IS NULL OR clientDetail.aadharCard = '')";

	public ClientDetailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ClientDetail.class);

		setModelImplClass(ClientDetailImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the client detail in the entity cache if it is enabled.
	 *
	 * @param clientDetail the client detail
	 */
	@Override
	public void cacheResult(ClientDetail clientDetail) {
		entityCache.putResult(
			ClientDetailImpl.class, clientDetail.getPrimaryKey(), clientDetail);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {clientDetail.getUuid(), clientDetail.getGroupId()},
			clientDetail);
	}

	/**
	 * Caches the client details in the entity cache if it is enabled.
	 *
	 * @param clientDetails the client details
	 */
	@Override
	public void cacheResult(List<ClientDetail> clientDetails) {
		for (ClientDetail clientDetail : clientDetails) {
			if (entityCache.getResult(
					ClientDetailImpl.class, clientDetail.getPrimaryKey()) ==
						null) {

				cacheResult(clientDetail);
			}
		}
	}

	/**
	 * Clears the cache for all client details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClientDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the client detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClientDetail clientDetail) {
		entityCache.removeResult(ClientDetailImpl.class, clientDetail);
	}

	@Override
	public void clearCache(List<ClientDetail> clientDetails) {
		for (ClientDetail clientDetail : clientDetails) {
			entityCache.removeResult(ClientDetailImpl.class, clientDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ClientDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ClientDetailModelImpl clientDetailModelImpl) {

		Object[] args = new Object[] {
			clientDetailModelImpl.getUuid(), clientDetailModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, clientDetailModelImpl, false);
	}

	/**
	 * Creates a new client detail with the primary key. Does not add the client detail to the database.
	 *
	 * @param clientId the primary key for the new client detail
	 * @return the new client detail
	 */
	@Override
	public ClientDetail create(long clientId) {
		ClientDetail clientDetail = new ClientDetailImpl();

		clientDetail.setNew(true);
		clientDetail.setPrimaryKey(clientId);

		String uuid = PortalUUIDUtil.generate();

		clientDetail.setUuid(uuid);

		clientDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return clientDetail;
	}

	/**
	 * Removes the client detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail that was removed
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	@Override
	public ClientDetail remove(long clientId)
		throws NoSuchClientDetailException {

		return remove((Serializable)clientId);
	}

	/**
	 * Removes the client detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the client detail
	 * @return the client detail that was removed
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	@Override
	public ClientDetail remove(Serializable primaryKey)
		throws NoSuchClientDetailException {

		Session session = null;

		try {
			session = openSession();

			ClientDetail clientDetail = (ClientDetail)session.get(
				ClientDetailImpl.class, primaryKey);

			if (clientDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClientDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clientDetail);
		}
		catch (NoSuchClientDetailException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ClientDetail removeImpl(ClientDetail clientDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clientDetail)) {
				clientDetail = (ClientDetail)session.get(
					ClientDetailImpl.class, clientDetail.getPrimaryKeyObj());
			}

			if (clientDetail != null) {
				session.delete(clientDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (clientDetail != null) {
			clearCache(clientDetail);
		}

		return clientDetail;
	}

	@Override
	public ClientDetail updateImpl(ClientDetail clientDetail) {
		boolean isNew = clientDetail.isNew();

		if (!(clientDetail instanceof ClientDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clientDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					clientDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clientDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ClientDetail implementation " +
					clientDetail.getClass());
		}

		ClientDetailModelImpl clientDetailModelImpl =
			(ClientDetailModelImpl)clientDetail;

		if (Validator.isNull(clientDetail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			clientDetail.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (clientDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				clientDetail.setCreateDate(date);
			}
			else {
				clientDetail.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!clientDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				clientDetail.setModifiedDate(date);
			}
			else {
				clientDetail.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(clientDetail);
			}
			else {
				clientDetail = (ClientDetail)session.merge(clientDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ClientDetailImpl.class, clientDetailModelImpl, false, true);

		cacheUniqueFindersCache(clientDetailModelImpl);

		if (isNew) {
			clientDetail.setNew(false);
		}

		clientDetail.resetOriginalValues();

		return clientDetail;
	}

	/**
	 * Returns the client detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the client detail
	 * @return the client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	@Override
	public ClientDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClientDetailException {

		ClientDetail clientDetail = fetchByPrimaryKey(primaryKey);

		if (clientDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClientDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clientDetail;
	}

	/**
	 * Returns the client detail with the primary key or throws a <code>NoSuchClientDetailException</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail
	 * @throws NoSuchClientDetailException if a client detail with the primary key could not be found
	 */
	@Override
	public ClientDetail findByPrimaryKey(long clientId)
		throws NoSuchClientDetailException {

		return findByPrimaryKey((Serializable)clientId);
	}

	/**
	 * Returns the client detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail, or <code>null</code> if a client detail with the primary key could not be found
	 */
	@Override
	public ClientDetail fetchByPrimaryKey(long clientId) {
		return fetchByPrimaryKey((Serializable)clientId);
	}

	/**
	 * Returns all the client details.
	 *
	 * @return the client details
	 */
	@Override
	public List<ClientDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientDetail> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ClientDetail> findAll(
		int start, int end, OrderByComparator<ClientDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ClientDetail> findAll(
		int start, int end, OrderByComparator<ClientDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ClientDetail> list = null;

		if (useFinderCache) {
			list = (List<ClientDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLIENTDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTDETAIL;

				sql = sql.concat(ClientDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClientDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the client details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClientDetail clientDetail : findAll()) {
			remove(clientDetail);
		}
	}

	/**
	 * Returns the number of client details.
	 *
	 * @return the number of client details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLIENTDETAIL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "clientId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLIENTDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClientDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the client detail persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ClientDetailModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ClientDetail.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathWithPaginationFindByEmail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"email"}, true);

		_finderPathWithoutPaginationFindByEmail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByEmail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

		_finderPathWithPaginationFindByConfirmEmail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConfirmEmail",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"confirmEmail"}, true);

		_finderPathWithoutPaginationFindByConfirmEmail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConfirmEmail",
			new String[] {String.class.getName()},
			new String[] {"confirmEmail"}, true);

		_finderPathCountByConfirmEmail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConfirmEmail",
			new String[] {String.class.getName()},
			new String[] {"confirmEmail"}, false);

		_finderPathWithPaginationFindByAge = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAge",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"age"}, true);

		_finderPathWithoutPaginationFindByAge = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAge",
			new String[] {String.class.getName()}, new String[] {"age"}, true);

		_finderPathCountByAge = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAge",
			new String[] {String.class.getName()}, new String[] {"age"}, false);

		_finderPathWithPaginationFindByPhoneNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPhoneNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"phoneNo"}, true);

		_finderPathWithoutPaginationFindByPhoneNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhoneNo",
			new String[] {String.class.getName()}, new String[] {"phoneNo"},
			true);

		_finderPathCountByPhoneNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhoneNo",
			new String[] {String.class.getName()}, new String[] {"phoneNo"},
			false);

		_finderPathWithPaginationFindByAadharCard = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAadharCard",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"aadharCard"}, true);

		_finderPathWithoutPaginationFindByAadharCard = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAadharCard",
			new String[] {String.class.getName()}, new String[] {"aadharCard"},
			true);

		_finderPathCountByAadharCard = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAadharCard",
			new String[] {String.class.getName()}, new String[] {"aadharCard"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ClientDetailImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = ClientDetailPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ClientDetailPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ClientDetailPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CLIENTDETAIL =
		"SELECT clientDetail FROM ClientDetail clientDetail";

	private static final String _SQL_SELECT_CLIENTDETAIL_WHERE =
		"SELECT clientDetail FROM ClientDetail clientDetail WHERE ";

	private static final String _SQL_COUNT_CLIENTDETAIL =
		"SELECT COUNT(clientDetail) FROM ClientDetail clientDetail";

	private static final String _SQL_COUNT_CLIENTDETAIL_WHERE =
		"SELECT COUNT(clientDetail) FROM ClientDetail clientDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clientDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClientDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ClientDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClientDetailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class ClientDetailModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			ClientDetailModelImpl clientDetailModelImpl =
				(ClientDetailModelImpl)baseModel;

			long columnBitmask = clientDetailModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(clientDetailModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						clientDetailModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(clientDetailModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ClientDetailModelImpl clientDetailModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = clientDetailModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = clientDetailModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= ClientDetailModelImpl.getColumnBitmask(
				"name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}