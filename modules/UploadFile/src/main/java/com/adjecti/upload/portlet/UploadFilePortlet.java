package com.adjecti.upload.portlet;

import com.adjecti.upload.constants.UploadFilePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adjecti-1
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UploadFile", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + UploadFilePortletKeys.UPLOADFILE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UploadFilePortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("do view ");
		super.doView(renderRequest, renderResponse);
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		System.out.println("hello..");
		String resourceId = resourceRequest.getResourceID();
		if (resourceId != null && resourceId.equals("UPLOAD_FILE")) {
			super.serveResource(resourceRequest, resourceResponse);
		}
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File file = uploadPortletRequest.getFile("myFile");
		String fileName = uploadPortletRequest.getFileName("myFile");
		String uploadDirectory = "C:/Urvashi_Temp";
		LocalDateTime time = LocalDateTime.now();
		System.out.println("time" + time);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss.SSS");

		String format = time.format(formatter);
		String timeDate = String.valueOf(format);

		File currentFile = new File(uploadDirectory);
		if (currentFile.exists()) {
			File newFile = new File(uploadDirectory + "/" + timeDate + fileName);
			OutputStream outputStream = new FileOutputStream(newFile);
			InputStream inputStream = new FileInputStream(file);

			byte[] buff = new byte[inputStream.available()];
			inputStream.read(buff);
			outputStream.write(buff);
			inputStream.close();
			outputStream.close();
			System.out.println("done");
		} else {
			System.out.println("not found ");
		}

	}

	public void file(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		System.out.println("uploadFile");

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile("myFile");
		String fileName = uploadPortletRequest.getFileName("myFile");
		String uploadDirectory = "C:/Urvashi_Temp";
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss.SSS");

		String format = time.format(formatter);
		String timeDate = String.valueOf(format);

		File currentFile = new File(uploadDirectory);
		if (currentFile.exists()) {
			File newFile = new File(uploadDirectory + "/" + timeDate + fileName);
			OutputStream outputStream = new FileOutputStream(newFile);
			InputStream inputStream = new FileInputStream(file);

			byte[] buff = new byte[inputStream.available()];
			inputStream.read(buff);
			outputStream.write(buff);
			inputStream.close();
			outputStream.close();
		} else {
			System.out.println("not found ");
		}
	}
}