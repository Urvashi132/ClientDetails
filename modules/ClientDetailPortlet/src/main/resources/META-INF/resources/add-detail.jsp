<%@ include file="init.jsp"%>

<portlet:actionURL name="addDetail" var="addDetailURL" />

<aui:form action="<%=addDetailURL%>" method="post" name="fm">

	<aui:container>
		<aui:input name="name">
			<aui:validator name="required" />
			<aui:validator name="alpha"></aui:validator>
		</aui:input>
		<aui:input name="email" id="email">
			<aui:validator name="required" />
			<aui:validator name="custom"
				errorMessage="please try again example: example@liferay.com">
				function(val){
					var regex=new RegExp(/@liferay\.com$/i);
					return regex.test(val);
				}
			</aui:validator>
		</aui:input>
		<aui:input name="confirmEmail" label="Confirm Email">
			<aui:validator name="equalTo">'#<portlet:namespace />email'</aui:validator>
		</aui:input>
		<aui:input name="age" type="date" id="age">
		</aui:input>

		<aui:input name="phoneNo" label="Phone Number">
			<aui:validator name="minLength">10</aui:validator>
			<aui:validator name="maxLength">10</aui:validator>
		</aui:input>
		<aui:input name="aadharCard" label="Aadhar Card">
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
