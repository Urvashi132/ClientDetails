
package com.adjecti.portlet;

import com.adj.model.ClientDetail;
import com.adj.service.ClientDetailLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=com_adjecti_ClientDetailPortlet",
		"mvc.command.name=/edit-detail" }, service = MVCRenderCommand.class)
public class UploadClient implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			System.out.println("a");
			Long clientId = ParamUtil.getLong(renderRequest, "clientId");
			System.out.println("clientId  " + clientId);
			ClientDetail detail = ClientDetailLocalServiceUtil.getClientDetail(clientId);
			renderRequest.setAttribute("clientDetail", detail);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/edit-detail.jsp";
	}

}
