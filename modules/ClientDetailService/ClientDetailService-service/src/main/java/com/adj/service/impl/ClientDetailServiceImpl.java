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
import com.adj.service.ClientDetailLocalService;
import com.adj.service.ClientDetailLocalServiceUtil;
import com.adj.service.base.ClientDetailServiceBaseImpl;
import com.adj.service.persistence.ClientDetailPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.ServiceContext;

import javax.ws.rs.client.Client;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the client detail remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adj.service.ClientDetailService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientDetailServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=clientdetail",
		"json.web.service.context.path=ClientDetail"
	},
	service = AopService.class
)
public class ClientDetailServiceImpl extends ClientDetailServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.adj.service.ClientDetailServiceUtil</code> to access the client detail remote service.
	 */

	
}