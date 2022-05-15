package org.electro_grid.com;

import org.electro_grid.model.*;


//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Facility")
public class FacilityService
{
	Facility facilityObj = new Facility();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	public String readItems()
	{
		return facilityObj.readFacility();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 	//To specify the input type as form data
	@Produces(MediaType.TEXT_PLAIN)		//To produce a status message as a output
	
	public String insertFacility(@FormParam("serviceName") String serviceName,
					@FormParam("serviceType") String serviceType,
					@FormParam("unitCost") String unitCost,
					@FormParam("maxUnit") String maxUnit,
					@FormParam("addCost") String addCost)
	{
		String output = facilityObj.insertFacility(serviceName, serviceType, unitCost, maxUnit, addCost);
		return output;
	}
	
	/*
	 * @PUT
	 * 
	 * @Path("/")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.TEXT_PLAIN)
	 */
	
	/*
	 * public String updateFacility(String facilityData) { //Convert the input
	 * string to a JSON object JsonObject facilityObject = new
	 * JsonParser().parse(facilityData).getAsJsonObject();
	 * 
	 * //Read the values from the JSON object String serviceId =
	 * facilityObject.get("serviceId").getAsString(); String serviceName =
	 * facilityObject.get("serviceName").getAsString(); String serviceType =
	 * facilityObject.get("serviceType").getAsString(); String unitCost =
	 * facilityObject.get("unitCost").getAsString(); String maxUnit =
	 * facilityObject.get("maxUnit").getAsString(); String addCost =
	 * facilityObject.get("addCost").getAsString(); String output =
	 * facilityObj.updateFacility(serviceId, serviceName, serviceType, unitCost,
	 * maxUnit, addCost);
	 * 
	 * return output; }
	 */
	
	/*
	 * @DELETE
	 * 
	 * @Path("/")
	 * 
	 * @Consumes(MediaType.APPLICATION_XML)
	 * 
	 * @Produces(MediaType.TEXT_PLAIN)
	 * 
	 * public String deleteFacility(String facilityData) { //Convert the input
	 * string to an XML document Document doc = Jsoup.parse(facilityData, "",
	 * Parser.xmlParser());
	 * 
	 * //Read the value from the element <serviceId> String serviceId =
	 * doc.select("serviceId").text(); String output =
	 * facilityObj.deleteFacility(serviceId);
	 * 
	 * return output; } }
	 */
}