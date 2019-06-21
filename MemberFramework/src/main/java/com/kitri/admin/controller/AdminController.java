package com.kitri.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.admin.model.service.AdminService;
import com.kitri.admin.model.service.AdminServiceImpl;
import com.kitri.member.model.service.MemberService;
import com.kitri.member.util.MoveUrl;
import com.kitri.member.util.SiteConstance;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/mvmemberlist.kitri", method = RequestMethod.GET)
	public String memberlist() {
		return "admin/member/memberlist";
	}
	
	@RequestMapping("/memberlist.kitri")
	@ResponseBody
	public String memberlist(@RequestParam Map<String, String> map) {
		String json = adminService.getMemberList(map);
		return json;
	}
}
