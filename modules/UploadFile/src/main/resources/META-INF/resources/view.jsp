<%@ include file="init.jsp"%>

<h3>
 FILE UPLOAD ACTION URL 
</h3>


<portlet:actionURL name="file" var="uploadFileURL" />

<aui:form action="<%=uploadFileURL%>" method="post" name="fm"
	enctype="multipart/form-data">
	<aui:input name="myFile" type="file" label="My File"></aui:input>
	<aui:button type="submit"></aui:button>
</aui:form>

<hr>
<h3>
 FILE UPLOAD USING AJAX AND RESOURCE URL 
</h3>

<aui:form name="myForm" enctype="multipart/form-data" >
	<aui:input type="file" name="myFile" label="My File"></aui:input>
	<aui:button type="submit" name="btnUploadFile" value="Upload File"></aui:button>
</aui:form>

<aui:script use="aui-base">

AUI().use('aui-base', 'io', 'aui-io-request', function(A){
	var btnUploadFile = A.one("#<portlet:namespace />btnUploadFile");
	btnUploadFile.on("click", uploadFile);
	function uploadFile(event){
            event.preventDefault();
            var myForm = A.one("#<portlet:namespace />myForm");
            var ajaxURL = ("<portlet:resourceURL id='UPLOAD_FILE'></portlet:resourceURL>");
            
            var configs = {
                method:'POST',
               form: {
                    id:myForm,
                   upload:true
                },
					on:{
						complete:function(){
						alert("Uploaded successfully !");
						}
					}
            };
            
            A.io.request(ajaxURL, configs);    
        }
        });
</aui:script>