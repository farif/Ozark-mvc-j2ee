package edu.uiowa.ozarkvuln;

import com.oracle.ozark.core.Models;

import javax.inject.Inject;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.BeanParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Path("cmdinject")
public class CmdInjectController {

	@GET
	public String getForm() {
		return "/WEB-INF/jsp/cmdinject.jsp";
	}

	@POST
	public String postForm(@BeanParam User user) {

		boolean status = send_mail(user.getName(), user.getEmail());

		if (status) {
			return "/WEB-INF/jsp/success.jsp";
		}

		return "/WEB-INF/jsp/fail.jsp";

	}

	private boolean send_mail(String user_name, String to_email) {

		StringBuffer output = new StringBuffer();
		String mail_cmd = "echo " + user_name + " | mail -s BINGO ";

		mail_cmd += to_email;

		String[] cmd_exec = { "/bin/sh", "-c", mail_cmd, };

		try {
			Process p = Runtime.getRuntime().exec(cmd_exec);
			int return_code = p.waitFor();

			String line = "";

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		return true;
	}

}