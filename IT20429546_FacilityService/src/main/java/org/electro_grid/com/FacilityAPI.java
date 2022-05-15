package org.electro_grid.com;
import org.electro_grid.model.Facility;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/FacilityAPI")
public class FacilityAPI extends HttpServlet{
	
	private static final long serialVersionUID =1L;
	Facility facilityObj = new Facility();
	
	public FacilityAPI()
	{
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
			System.out.println("requets recieved");
			String output = facilityObj.insertFacility(request.getParameter("serviceName"),
			request.getParameter("serviceType"),
			request.getParameter("unitCost"),
			request.getParameter("maxUnit"),
			request.getParameter("addCost"));
			 
			response.getWriter().write(output);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
			 Map paras = getParasMap(request);
			 
			 String output = facilityObj.updateFacility(Integer.parseInt(paras.get("hidServiceIDSave").toString()),
			 paras.get("serviceName").toString(),paras.get("serviceType").toString(),paras.get("unitCost").toString(),paras.get("maxUnit").toString(),paras.get("addCost").toString());
			 
			response.getWriter().write(output);
	} 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			 Map paras = getParasMap(request);
			 
			 //String output = facilityObj.deleteFacility(paras.get("serviceId").toString());
			 String output = facilityObj.deleteFacility(Integer.parseInt(paras.get("serviceId").toString()));
			 //System.out.println(paras.get("serviceID").toString());
			 response.getWriter().write(output);
	}
	private static Map getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		
		try
		{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			
			String[] params = queryString.split("&");
			for (String param : params)
			{ 
	
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
	 }
	catch (Exception e)
	 {
	 }
	return map;
	}
}