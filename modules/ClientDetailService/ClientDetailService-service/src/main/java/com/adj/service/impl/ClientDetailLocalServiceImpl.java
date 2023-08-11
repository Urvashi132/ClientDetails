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

package com.adj.service.impl;

import com.adj.model.ClientDetail;
import com.adj.service.ClientDetailLocalServiceUtil;
import com.adj.service.base.ClientDetailLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the client detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adj.service.ClientDetailLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientDetailLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adj.model.ClientDetail", service = AopService.class)
public class ClientDetailLocalServiceImpl extends ClientDetailLocalServiceBaseImpl {


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.adj.service.ClientDetailLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.adj.service.ClientDetailLocalServiceUtil</code>.
	 */


}