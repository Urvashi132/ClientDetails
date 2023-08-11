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
import com.adj.contact.service.base.ContactLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adj.contact.service.ContactLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adj.contact.model.Contact", service = AopService.class)
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.adj.contact.service.ContactLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.adj.contact.service.ContactLocalServiceUtil</code>.
	 */

	public Contact addContact(long groupId, String name, String telephone, String email, ServiceContext serviceContext)
			throws PortalException {

		Group group = GroupLocalServiceUtil.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);

		long contactId = counterLocalService.increment(Contact.class.getName());

		Contact contact = createContact(contactId);

		contact.setGroupId(groupId);
		contact.setCompanyId(group.getCompanyId());
		contact.setUserId(userId);
		contact.setUserName(user.getScreenName());
		contact.setCreateDate(new Date());
		contact.setModifiedDate(new Date());

		contact.setName(name);
		contact.setTelephone(telephone);
		contact.setEmail(email);

		return super.addContact(contact);
	}

	public Contact updateContact(long contactId, String name, String telephone, String email) throws PortalException {

		Contact contact = getContact(contactId);

		contact.setModifiedDate(new Date());

		contact.setName(name);
		contact.setTelephone(telephone);
		contact.setEmail(email);

		return super.updateContact(contact);
	}

	public Contact getByContactId(long contactId) throws PortalException {
		return contactLocalService.getContact(contactId);
	}

	public List<Contact> getAllContact() throws PortalException {
		return contactLocalService.getContacts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/*
	 * public Contact deleteContact(long contactId) throws PortalException { return
	 * contactLocalService.deleteContact(contactId);
	 * 
	 * }
	 */

	@Override
	public Contact deleteContact(Contact contact) {
		throw new UnsupportedOperationException("Not Supported Method");
	}

	@Override
	public Contact addContact(Contact contact) {
		throw new UnsupportedOperationException("Not Supported Method");
	}

	@Override
	public Contact updateContact(Contact contact) {
		throw new UnsupportedOperationException("Not Supported Method");
	}

}