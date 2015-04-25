<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
</head>
<body>
<h1>Hello from JSP</h1>
<script>
	$(function()
			{
		var site={
		//name:"Aaaaddddd1",
		latitude:"yaaaaadau",
		longitude:"dadlsaaa",
			};
			//removeSite(28);
			//createSite(site);
			updateSite(30,site);
			});
	
	function removeSite(id)
	{
		$.ajax(
		{
			url: "/Site/rest/api/site/"+id,
			type: "delete",
			dataType: "json",
			contentType: "application/json",
			success: function(response) {
				console.log(response);
			},
			error: function(response) {
				console.log(response);
			}
		});
	}

	
	function updateSite(id, site)
	{
		$.ajax(
		{
			url: "/Site/rest/api/site/"+id,
			data: JSON.stringify(site),
			type: "put",
			dataType: "json",
			contentType: "application/json",

			success: function(response) {
				console.log(response);
			},
			error: function(response) {
				console.log(response);
			}
		});
	}
	
	
	
	function createSite(site)
	{
	$.ajax({
		url:"/Site/rest/api/site",
		type:"post",
		contentType:"application/json;charset=utf-8",
		dataType:"json",
		data:JSON.stringify(site),
		
		success:function(response){
			console.log("yahoo");
		},
		error: function(response) {
			console.log(response);
		}
	});
}
	
	
</script>


</body>
</html>