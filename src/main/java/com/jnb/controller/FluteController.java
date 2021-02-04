package com.jnb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jnb.modal.RoleBean;
import com.jnb.service.IAdminService;
import com.jnb.service.ILoginService;

@Controller
public class FluteController {
@Autowired
IAdminService adminService;
@Autowired
ILoginService loginService;

@RequestMapping(value = "productList", method = RequestMethod.GET)
public String productList(Model model, HttpSession session) {

	model.addAttribute("roleList", adminService.roleList());

	return "flute/productList";
}

@RequestMapping(value = "addProduct", method = RequestMethod.GET)
public String addRole(Model model, @RequestParam(required = false) Integer pk, HttpSession session) {

	if (pk != null && pk != 0) {
		model.addAttribute("roleBean", adminService.roleByPk(pk));
	} else {
		model.addAttribute("roleBean", new RoleBean());
	}
	model.addAttribute("menuList", adminService.menuList());

	return "admin/addRole";
}
}
