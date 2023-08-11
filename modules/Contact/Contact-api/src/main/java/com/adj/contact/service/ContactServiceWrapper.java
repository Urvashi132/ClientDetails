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

package com.adj.contact.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContactService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactService
 * @generated
 */
public class ContactServiceWrapper
	implements ContactService, ServiceWrapper<ContactService> {

	public ContactServiceWrapper(ContactService contactService) {
		_contactService = contactService;
	}

	@Override
	public com.adj.contact.model.Contact addContact(
			long groupId, String name, String telephone, String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.addContact(
			groupId, name, telephone, email, serviceContext);
	}

	@Override
	public com.adj.contact.model.Contact deleteContact(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.deleteContact(contactId);
	}

	@Override
	public java.util.List<com.adj.contact.model.Contact> getAllContact()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getAllContact();
	}

	@Override
	public com.adj.contact.model.Contact getByContactId(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getByContactId(contactId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactService.getOSGiServiceIdentifier();
	}

	@Override
	public com.adj.contact.model.Contact updateContact(
			long contactId, String name, String telephone, String email)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.updateContact(contactId, name, telephone, email);
	}

	@Override
	public ContactService getWrappedService() {
		return _contactService;
	}

	@Override
	public void setWrappedService(ContactService contactService) {
		_contactService = contactService;
	}

	private ContactService _contactService;

}