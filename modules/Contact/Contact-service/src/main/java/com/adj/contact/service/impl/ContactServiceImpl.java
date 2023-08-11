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

package com.adj.contact.service.impl;

import com.adj.contact.model.Contact;
import com.adj.contact.service.base.ContactServiceBaseImpl;
import com.adj.contact.service.persistence.ContactPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the contact remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adj.contact.service.ContactService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=contact",
		"json.web.service.context.path=Contact" }, service = AopService.class)
public class ContactServiceImpl extends ContactServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.adj.contact.service.ContactServiceUtil</code> to access the contact
	 * remote service.
	 */

	public Contact addContact(long groupId, String name, String telephone, String email, ServiceContext serviceContext)
			throws PortalException {
		return contactLocalService.addContact(groupId, name, telephone, email, serviceContext);
	}

	public Contact updateContact(long contactId, String name, String telephone, String email) throws PortalException {
		return contactLocalService.updateContact(contactId, name, telephone, email);

	}

	public Contact deleteContact(long contactId) throws PortalException {
		return contactLocalService.deleteContact(contactId);
	}

	public Contact getByContactId(long contactId) throws PortalException {
		return contactLocalService.getByContactId(contactId);
	}

	public List<Contact> getAllContact() throws PortalException {
		return contactLocalService.getAllContact();
	}

}