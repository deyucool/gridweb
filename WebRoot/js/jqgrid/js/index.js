$(function(){
	pageInit();
});
function pageInit(){
	$("#list2").jqGrid(
			{
				url : 'comAction',
				postData :{'service':"CommonService",'method':"doGridMsg",'F_BY01':"dadadada"},
				datatype : "json",
				colNames : [ '序号', '口令', '用户名'],
				colModel : [ 
					{name : 'id',index : 'id',width : 200}, 
                    {name : 'password',index : 'password',width : 300}, 
                    {name : 'username',index : 'username',width : 300}
				           ],
				//rowNum : 10,
				//rowList : [ 10, 20, 30 ],
				sortname : 'id',
				sortorder : "desc",
				mtype : "post",
				viewrecords : true,
				loadonce : true,
				width:1000,
				onSelectRow : function(id) {

			        },
				caption : "JSONExample"
			});
	
	$("#bedata").click(function() {
		var ids = $("#list2").jqGrid('getDataIDs');  
	    var rowid = Math.max.apply(Math,ids);  
	    newrowid = rowid+1;  
	    var dataRow = {    
	        id: newrowid+"",  
	        password:"1111",  
	        username:"1111",    
	    };      
	    $("#list2").jqGrid("addRowData", newrowid, dataRow, "last");
	    
	    $("#list2").jqGrid('editRow', "1");
	  });
	
	$("#deldata").click(function() {
		
		var selectedId = $("#list2").jqGrid("getGridParam","selrow");	
	     if(!selectedId){
	    	 
	     }else{          
	        $("#list2").jqGrid("delRowData", selectedId);     
	     } 	     
	  });
	
	$("#savedata").click(function() {
		var data = $("#list2").jqGrid("getRowData");
		console.log($("#list2").jqGrid("getRowData"));
		$.ajax({
	        url      : "comAction",
	        data     : {service:"CommonService", method:"gridSaveService",F_BY01:JSON.stringify(data)},
	        type     : "POST",
	        dataType : "json",
	        async    : true,
	        success  : function( data ) {
	        	console.log(data);
	        }
	   });
	     
	  });
	
}