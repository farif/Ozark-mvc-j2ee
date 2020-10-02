package edu.uiowa.ozarksafe;

import com.oracle.ozark.core.Models;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.google.common.html.HtmlEscapers;
import com.google.common.escape.Escaper;

@Controller
@Path("XSS")
public class XSSController {

	@Inject
	Models models;

	@GET
	public String greetings(@QueryParam("name") String name) {
		//Escaping characters input to mitigate XSS
		Escaper escaper = HtmlEscapers.htmlEscaper();
		String sanitized_name = escaper.escape(name);
		
		this.models.put("text", "Hi " + sanitized_name);
		return "/WEB-INF/jsp/xss.jsp";
	}

}