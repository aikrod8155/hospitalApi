package hos.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import hos.service.DataService;

public class HosInitServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7433482476235130745L;
	private static final String CONTEXT_INIT="hos.init";
	
	public void init() throws ServletException{
		System.out.println("fuck your self");
		ServletContext servletContext  =this.getServletContext();
		WebApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		DataService dataService =(DataService)applicationContext.getBean("DataService");
		if(servletContext.getAttribute(CONTEXT_INIT)==null) {
			dataService.init();
			servletContext.setAttribute(CONTEXT_INIT, true);
		}
	}
}
