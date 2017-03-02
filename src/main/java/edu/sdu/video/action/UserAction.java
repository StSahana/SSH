package edu.sdu.video.action;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

import edu.sdu.video.service.UserService;


@Controller
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserAction.class);
	@Autowired
	UserService userService;
	
	public String getUser(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out=null;
		try {
			out= response.getWriter();
			out.write(JSON.toJSONString(userService.getUser()));
		} catch (Exception e) {
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			log.error(trace);
		} finally {
			out.flush();
			out.close();
		}
		
		return null;
	}
	
	public String getTest(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out=null;
		try {
			out= response.getWriter();
			out.write("xxxxxxxxx");
		} catch (Exception e) {
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			log.error(trace);
		} finally {
			out.flush();
			out.close();
		}
		
		return null;
	}
	
	
}
