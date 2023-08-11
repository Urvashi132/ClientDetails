<%@ include file="init.jsp"%>

<portlet:actionURL name="editDetail" var="editDetailURL" />

<aui:form action="<%=editDetailURL%>" method="post" name="fm">

	<aui:container>
		<aui:input name="clientId" value="${clientDetail.clientId }"></aui:input>
		<aui:input name="name" value="${clientDetail.name }">
			<aui:validator name="required" />
			<aui:validator name="alpha"></aui:validator>
		</aui:input>
		<aui:input name="email" id="email" value="${clientDetail.email }">
			<aui:validator name="required" />
			<aui:validator name="custom"
				errorMessage="please try again example: example@liferay.com">
				function(val){
					var regex=new RegExp(/@liferay\.com$/i);
					return regex.test(val);
				}
			</aui:validator>
		</aui:input>
		<aui:input name="confirmEmail" label="Confirm Email" value="${clientDetail.confirmEmail }">
			<aui:validator name="equalTo">'#<portlet:namespace />email'</aui:validator>
		</aui:input>
		<aui:input name="age" type="date" id="age" value="${clientDetail.age }">
		</aui:input>

		<aui:input name="phoneNo" label="Phone Number" value="${clientDetail.phoneNo }">
			<aui:validator name="minLength">10</aui:validator>
			<aui:validator name="maxLength">10</aui:validator>
		</aui:input>
		<aui:input name="aadharCard" label="Aadhar Card" value="${clientDetail.aadharCard }">
			<aui:validator name="minLength">12</aui:validator>
			<aui:validator name="maxLength">12</aui:validator>
			<aui:validator name="custom">
			function(val){
				var regex=new RegExp(/^[2-9][0-9]*$/);
				return regex.test(val);
			}
		</aui:validator>
		</aui:input>

		<aui:button type="submit" />

	</aui:container>
</aui:form>