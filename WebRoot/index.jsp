<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath%>js/jqgrid/jqgrid/css/ui.jqgrid.css" />
<link rel="stylesheet" href="<%=basePath%>js/jqgrid/jqgrid/css/css/cupertino/jquery-ui-1.8.16.custom.css" />
<script type="text/javascript" src="<%=basePath%>js/jqgrid/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqgrid/jqgrid/js/jquery.jqGrid.src.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jqgrid/js/index.js"></script>
</head>
<body>
<table id="list2"></table> 
<div id="pager2"></div>
<input type="button" id="bedata" value="add" />
<input type="button" id="deldata" value="del" />
<input type="button" id="savedata" value="save" />
<script type="text/javascript">
$(function(){
	
	/* $.ajax({
        url      : "BaseServlet",
        data     : {service:"CommonService", method:"doGridMsg",F_BY01:"dadadada"},
        type     : "GET",
        dataType : "json",
        async    : true,
        success  : function( data ) {
        	console.log(data);
        }
   }); */
});

</script>
</body>
</html>