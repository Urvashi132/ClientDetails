<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="init.jsp"%>


<%
	//the group id of your entity
	Long groupId = scopeGroupId;
	//The name of the current portlet
	String name = portletDisplay.getRootPortletId();
	//The primary key of the resource
	String primKey = portletDisplay.getResourcePK();
	//it must be same as default xml file of action key
	String addId = "CLIENT_ADD";
	//String viewId = "CLIENT_VIEW";
	String deleteId = "CLIENT_DELETE";
	String editId = "CLIENT_EDIT";
%>




<!-- RENDER URL FOR ADD CLIENT DETAILS -->

<portlet:renderURL var="addDetail"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/add-detail.jsp" />
</portlet:renderURL>


<!-- Permission Checker -->
<c:if
	test="<%=permissionChecker.hasPermission(groupId, name, primKey, addId)%>">

	<aui:button id="popupButton" value="Add Client Detail" cssClass="updatebutton" />
</c:if>


<!-- aui script -->
<aui:script use="aui-base">
A.one('#<portlet:namespace />popupButton').on('click',function(event){
Liferay.Util.openWindow({
dialog:{
height:700,
modal: true,
width:700,
destroyOnClose: true
},
title:'Add Client',
uri:'<%=addDetail.toString()%>'
});
});
</aui:script>
<hr>

<!-- VIEW ALL CLIENT DETAILS -->

<aui:container>
	<h3 style="text-align: center;">VIEW ALL CLIENT DETAILS</h3>
	<table class="table table-bordered" style="text-align: center; ">
		<thead>
			<tr>
				<th style="text-align: center;font-size: medium;">Name</th>
				<th style="text-align: center;font-size: medium;">Email</th>
				<th style="text-align: center;font-size: medium;">Confirm Email</th>
				<th style="text-align: center;font-size: medium;">Age</th>
				<th style="text-align: center;font-size: medium;">Phone No</th>
				<th style="text-align: center;font-size: medium;">Aadhar Card</th>
				<th style="text-align: center;font-size: medium;">Action</th>
			</tr>
		</thead>
		<c:forEach var="detail" items="${detailList }">
			<portlet:actionURL name="deleteDetail" var="deleteDetail">
				<portlet:param name="delId" value="${detail.clientId}" />
			</portlet:actionURL>
			<portlet:renderURL var="editDetail">
				<portlet:param name="mvcRenderCommandName" value="/edit-detail" />
				<portlet:param name="clientId" value="${detail.clientId }" />
			</portlet:renderURL>
			<tbody>
				<tr>
					<td>${detail.name }</td>
					<td>${detail.email }</td>
					<td>${detail.confirmEmail }</td>
					<td>${detail.age }</td>
					<td>${detail.phoneNo }</td>
					<td>${detail.aadharCard }</td>
					<td><c:if
							test="<%=permissionChecker.hasPermission(groupId, name, primKey, editId)%>">
							<aui:button href="${editDetail.toString()}" value="Update" />
						</c:if> <c:if
							test="<%=permissionChecker.hasPermission(groupId, name, primKey, deleteId)%>">
							<aui:button href="${deleteDetail}" value="Delete" />
						</c:if></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</aui:container>