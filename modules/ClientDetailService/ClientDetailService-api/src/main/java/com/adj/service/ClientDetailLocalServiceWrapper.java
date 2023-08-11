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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ClientDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClientDetailLocalService
 * @generated
 */
public class ClientDetailLocalServiceWrapper
	implements ClientDetailLocalService,
			   ServiceWrapper<ClientDetailLocalService> {

	public ClientDetailLocalServiceWrapper(
		ClientDetailLocalService clientDetailLocalService) {

		_clientDetailLocalService = clientDetailLocalService;
	}

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
	@Override
	public com.adj.model.ClientDetail addClientDetail(
		com.adj.model.ClientDetail clientDetail) {

		return _clientDetailLocalService.addClientDetail(clientDetail);
	}

	/**
	 * Creates a new client detail with the primary key. Does not add the client detail to the database.
	 *
	 * @param clientId the primary key for the new client detail
	 * @return the new client detail
	 */
	@Override
	public com.adj.model.ClientDetail createClientDetail(long clientId) {
		return _clientDetailLocalService.createClientDetail(clientId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientDetailLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.adj.model.ClientDetail deleteClientDetail(
		com.adj.model.ClientDetail clientDetail) {

		return _clientDetailLocalService.deleteClientDetail(clientDetail);
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
	@Override
	public com.adj.model.ClientDetail deleteClientDetail(long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientDetailLocalService.deleteClientDetail(clientId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientDetailLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clientDetailLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _clientDetailLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _clientDetailLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _clientDetailLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _clientDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _clientDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adj.model.ClientDetail fetchClientDetail(long clientId) {
		return _clientDetailLocalService.fetchClientDetail(clientId);
	}

	/**
	 * Returns the client detail matching the UUID and group.
	 *
	 * @param uuid the client detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching client detail, or <code>null</code> if a matching client detail could not be found
	 */
	@Override
	public com.adj.model.ClientDetail fetchClientDetailByUuidAndGroupId(
		String uuid, long groupId) {

		return _clientDetailLocalService.fetchClientDetailByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _clientDetailLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the client detail with the primary key.
	 *
	 * @param clientId the primary key of the client detail
	 * @return the client detail
	 * @throws PortalException if a client detail with the primary key could not be found
	 */
	@Override
	public com.adj.model.ClientDetail getClientDetail(long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientDetailLocalService.getClientDetail(clientId);
	}

	/**
	 * Returns the client detail matching the UUID and group.
	 *
	 * @param uuid the client detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching client detail
	 * @throws PortalException if a matching client detail could not be found
	 */
	@Override
	public com.adj.model.ClientDetail getClientDetailByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientDetailLocalService.getClientDetailByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.adj.model.ClientDetail> getClientDetails(
		int start, int end) {

		return _clientDetailLocalService.getClientDetails(start, end);
	}

	/**
	 * Returns all the client details matching the UUID and company.
	 *
	 * @param uuid the UUID of the client details
	 * @param companyId the primary key of the company
	 * @return the matching client details, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adj.model.ClientDetail>
		getClientDetailsByUuidAndCompanyId(String uuid, long companyId) {

		return _clientDetailLocalService.getClientDetailsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.adj.model.ClientDetail>
		getClientDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adj.model.ClientDetail> orderByComparator) {

		return _clientDetailLocalService.getClientDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of client details.
	 *
	 * @return the number of client details
	 */
	@Override
	public int getClientDetailsCount() {
		return _clientDetailLocalService.getClientDetailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _clientDetailLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _clientDetailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clientDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientDetailLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.adj.model.ClientDetail updateClientDetail(
		com.adj.model.ClientDetail clientDetail) {

		return _clientDetailLocalService.updateClientDetail(clientDetail);
	}

	@Override
	public ClientDetailLocalService getWrappedService() {
		return _clientDetailLocalService;
	}

	@Override
	public void setWrappedService(
		ClientDetailLocalService clientDetailLocalService) {

		_clientDetailLocalService = clientDetailLocalService;
	}

	private ClientDetailLocalService _clientDetailLocalService;

}