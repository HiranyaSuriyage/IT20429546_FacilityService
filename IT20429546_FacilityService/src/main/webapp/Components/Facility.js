$(document).ready(function()
{

	$("#alertSuccess").hide();
	$("#alertError").hide();
});


$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------

	
	 $("#alertSuccess").text("");
 	 $("#alertSuccess").hide();
 	 $("#alertError").text("");
 	 $("#alertError").hide();
 	 
 	 
   	// Form validation-------------------
  	
	var status = validateItemForm();
	if (status != true)
	{
		 $("#alertError").text(status);
 		 $("#alertError").show();
 		 
         return;
    }
 
	// If valid------------------------
	
	
	var type = ($("#hidServiceIDSave").val() == "") ? "POST" : "PUT";

	 $.ajax(
 	 {
 		url : "FacilityAPI",
 		type : type,
 		data : $("#formFacility").serialize(),
 		dataType : "text",
	    complete : function(response, status)
        {
   
      			onItemSaveComplete(response.responseText, status);
	    }
	    
     });
     
});
function onItemSaveComplete(response, status)
{
	if (status == "success")
	{
		 var resultSet = JSON.parse(response);
		 
	 	 if (resultSet.status.trim() == "success")
		 {
 				$("#alertSuccess").text("Successfully saved.");
		    	$("#alertSuccess").show();
 				$("#divFacilityGrid").html(resultSet.data);
 			
 	 	  } else if (resultSet.status.trim() == "error")
 	 	  {
 	 
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
		  }
		  
    } else if (status == "error")
    {
 			$("#alertError").text("Error while saving.");
 			$("#alertError").show();
 			
 	} else
 	{
 			$("#alertError").text("Unknown error while saving..");
 			$("#alertError").show();
    } 

 	$("#hidServiceIDSave").val("");
	 $("#formFacility")[0].reset();
}
$(document).on("click", ".btnUpdate", function(event)
{
		var id = event.target.id;
		$("#hidServiceIDSave").val(id.substring(0, id.length-1));
 		$("#serviceName").val($(this).closest("tr").find('td:eq(0)').text());
 		$("#serviceType").val($(this).closest("tr").find('td:eq(1)').text());
 		$("#unitCost").val($(this).closest("tr").find('td:eq(2)').text());
 		$("#maxUnit").val($(this).closest("tr").find('td:eq(3)').text());
 		$("#addCost").val($(this).closest("tr").find('td:eq(4)').text());
});
$(document).on("click", ".btnRemove", function(event)
{
	 $.ajax(
 	{
 		url : "FacilityAPI",
 		type : "DELETE",
	    data : "serviceId=" + $(this).data("serviceId"),
 		dataType : "text",
 		complete : function(response, status)
		{
			 onItemDeleteComplete(response.responseText, status);
 		}
	 });
});



function onItemDeleteComplete(response, status)
{
	if (status == "success")
    {
 			var resultSet = JSON.parse(response);
 			
		   if (resultSet.status.trim() == "success")
 		   {
 		   
 				$("#alertSuccess").text("Successfully deleted.");
 				$("#alertSuccess").show();
 				
			    $("#divFacilityGrid").html(resultSet.data);
			    
			    setTimeout( (function(){alert(43)}, 1000));
 			} else if (resultSet.status.trim() == "error")
 			{
				 $("#alertError").text(resultSet.data);
 				 $("#alertError").show();
		    }
 	} else if (status == "error")
    {
		 $("#alertError").text("Error while deleting.");
 		 $("#alertError").show();
    } else
    {
 		$("#alertError").text("Unknown error while deleting..");
 		$("#alertError").show();
 	}
}
function validateItemForm()
{
	// SERVICE NAME
	if ($("#serviceName").val().trim() == "")
 	{
		 return "Insert facility service Name.";
    }
    
    
	// SERVICE TYPE
	if ($("#serviceType").val().trim() == "")
    {
		 return "Insert facility service Type.";
 	} 
 	

	// UNIT COST-------------------------------
	if ($("#unitCost").val().trim() == "")
    {
 		return "Insert facility service Unit Cost.";
 	}
 	
 	
	
	// MAX UNIT------------------------
	if ($("#maxUnit").val().trim() == "")
   {
		 return "Insert facility service Maximum Cost.";
   }
   
   
   // ADD COST-------------------------------
	if ($("#addCost").val().trim() == "")
    {
 		return "Insert facility service Additional Cost.";
 	}
   return true;
}
