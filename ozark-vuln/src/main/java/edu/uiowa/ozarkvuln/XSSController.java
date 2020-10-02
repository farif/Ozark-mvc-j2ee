package edu.uiowa.ozarkvuln;

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
		this.models.put("text", "Hi " + name);
		return "/WEB-INF/jsp/xss.jsp";
	}

}