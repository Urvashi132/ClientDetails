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

import com.adj.contact.model.Contact;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Contact. This utility wraps
 * <code>com.adj.contact.service.impl.ContactServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ContactService
 * @generated
 */
public class ContactServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adj.contact.service.impl.ContactServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Contact addContact(
			long groupId, String name, String telephone, String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addContact(
			groupId, name, telephone, email, serviceContext);
	}

	public static Contact deleteContact(long contactId) throws PortalException {
		return getService().deleteContact(contactId);
	}

	public static List<Contact> getAllContact() throws PortalException {
		return getService().getAllContact();
	}

	public static Contact getByContactId(long contactId)
		throws PortalException {

		return getService().getByContactId(contactId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Contact updateContact(
			long contactId, String name, String telephone, String email)
		throws PortalException {

		return getService().updateContact(contactId, name, telephone, email);
	}

	public static ContactService getService() {
		return _service;
	}

	private static volatile ContactService _service;

}