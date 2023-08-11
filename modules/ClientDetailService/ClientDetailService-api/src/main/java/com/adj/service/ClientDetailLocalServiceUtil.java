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

package com.adj.service;

import com.adj.model.ClientDetail;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ClientDetail. This utility wraps
 * <code>com.adj.service.impl.ClientDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClientDetailLocalService
 * @generated
 */
public class ClientDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adj.service.impl.ClientDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the client detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientDetail the client detail
	 * @return the client detail that was added
	 */
	public static ClientDetail addClientDetail(ClientDetail clientDetail) {
		return getService().addClientDetail(clientDetail);
	}

	/**
	 * Creates a new client detail with the primary key. Does not add the client detail to the database.
	 *
	 * @param clientId the primary key for the new client detail
	 * @return the new client detail
	 */
	public static ClientDetail createClientDetail(long clientId) {
		return getService().createClientDetail(clientId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the client detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientDetail the client detail
	 * @return the client detail that was removed
	 */
	public static ClientDetail deleteClientDetail(ClientDetail clientDetail) {
		return getService().deleteClientDetail(clientDetail);
	}

	/**
	 * Deletes the client detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail that was removed
	 * @throws PortalException if a client detail with the primary key could not be found
	 */
	public static ClientDetail deleteClientDetail(long clientId)
		throws PortalException {

		return getService().deleteClientDetail(clientId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.model.impl.ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.model.impl.ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ClientDetail fetchClientDetail(long clientId) {
		return getService().fetchClientDetail(clientId);
	}

	/**
	 * Returns the client detail matching the UUID and group.
	 *
	 * @param uuid the client detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	public static ClientDetail fetchClientDetailByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchClientDetailByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the client detail with the primary key.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail
	 * @throws PortalException if a client detail with the primary key could not be found
	 */
	public static ClientDetail getClientDetail(long clientId)
		throws PortalException {

		return getService().getClientDetail(clientId);
	}

	/**
	 * Returns the client detail matching the UUID and group.
	 *
	 * @param uuid the client detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching client detail
	 * @throws PortalException if a matching client detail could not be found
	 */
	public static ClientDetail getClientDetailByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getClientDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the client details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.model.impl.ClientDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @return the range of client details
	 */
	public static List<ClientDetail> getClientDetails(int start, int end) {
		return getService().getClientDetails(start, end);
	}

	/**
	 * Returns all the client details matching the UUID and company.
	 *
	 * @param uuid the UUID of the client details
	 * @param companyId the primary key of the company
	 * @return the matching client details, or an empty list if no matches were found
	 */
	public static List<ClientDetail> getClientDetailsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getClientDetailsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of client details matching the UUID and company.
	 *
	 * @param uuid the UUID of the client details
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of client details
	 * @param end the upper bound of the range of client details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching client details, or an empty list if no matches were found
	 */
	public static List<ClientDetail> getClientDetailsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ClientDetail> orderByComparator) {

		return getService().getClientDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of client details.
	 *
	 * @return the number of client details
	 */
	public static int getClientDetailsCount() {
		return getService().getClientDetailsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the client detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientDetail the client detail
	 * @return the client detail that was updated
	 */
	public static ClientDetail updateClientDetail(ClientDetail clientDetail) {
		return getService().updateClientDetail(clientDetail);
	}

	public static ClientDetailLocalService getService() {
		return _service;
	}

	private static volatile ClientDetailLocalService _service;

}