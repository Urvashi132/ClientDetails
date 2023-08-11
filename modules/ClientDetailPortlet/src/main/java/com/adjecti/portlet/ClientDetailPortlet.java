package com.adjecti.portlet;

import com.adj.model.ClientDetail;
import com.adj.service.ClientDetailLocalService;
import com.adj.service.ClientDetailLocalServiceUtil;
import com.adjecti.constants.ClientDetailPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adjecti-1
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ClientDetail", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ClientDetailPortletKeys.CLIENTDETAIL, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ClientDetailPortlet extends MVCPortlet {


	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("do view called");
		List<ClientDetail> clientDetails = ClientDetailLocalServiceUtil.getClientDetails(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("detailList", clientDetails);
		super.doView(renderRequest, renderResponse);
	}

	

	public void addDetail(ActionRequest request, ActionResponse response) throws ParseException {
		System.out.println("add detail called");
		String name = ParamUtil.getString(request, "name");
		System.out.println("name : " + name);
		String email = ParamUtil.getString(request, "email");
		System.out.println("email : " + email);
		String confirmEmail = ParamUtil.getString(request, "confirmEmail");
		System.out.println("confirmEmail : " + confirmEmail);
		String age = ParamUtil.getString(request, "age");
		System.out.println("age : " + age);
		String phoneNo = ParamUtil.getString(request, "phoneNo");
		System.out.println("phoneNo : " + phoneNo);
		String aadharCard = ParamUtil.getString(request, "aadharCard");
		System.out.println("aadharCard : " + aadharCard);

		ClientDetail detail = ClientDetailLocalServiceUtil.createClientDetail(CounterLocalServiceUtil.increment());
		detail.setName(name);
		detail.setEmail(email);
		detail.setConfirmEmail(confirmEmail);
		detail.setAge(age);
		detail.setPhoneNo(phoneNo);
		detail.setAadharCard(aadharCard);

		ClientDetailLocalServiceUtil.addClientDetail(detail);
	}

	public void deleteDetail(ActionRequest request, ActionResponse response) throws PortalException {
		System.out.println("delete detail called");
		long clientId = ParamUtil.getLong(request, "delId");
		ClientDetailLocalServiceUtil.deleteClientDetail(clientId);
	}
	
	public void editDetail(ActionRequest request, ActionResponse response) throws ParseException, PortalException {
		System.out.println("edit detail called");
		Long clientId = ParamUtil.getLong(request, "clientId");
		System.out.println("clientId  " + clientId);
		String name = ParamUtil.getString(request, "name");
		System.out.println("name : " + name);
		String email = ParamUtil.getString(request, "email");
		System.out.println("email : " + email);
		String confirmEmail = ParamUtil.getString(request, "confirmEmail");
		System.out.println("confirmEmail : " + confirmEmail);
		String age = ParamUtil.getString(request, "age");
		System.out.println("age : " + age);
		String phoneNo = ParamUtil.getString(request, "phoneNo");
		System.out.println("phoneNo : " + phoneNo);
		String aadharCard = ParamUtil.getString(request, "aadharCard");
		System.out.println("aadharCard : " + aadharCard);

		ClientDetail detail = ClientDetailLocalServiceUtil.getClientDetail(clientId);
		detail.setName(name);
		detail.setEmail(email);
		detail.setConfirmEmail(confirmEmail);
		detail.setAge(age);
		detail.setPhoneNo(phoneNo);
		detail.setAadharCard(aadharCard);

		ClientDetailLocalServiceUtil.updateClientDetail(detail);
	}
}