package com.jnb.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jnb.modal.ApiResponseModal;
import com.jnb.modal.UserBean;
import com.jnb.service.ILoginService;

@RestController
@RequestMapping("openapi")
public class UserAPIController {

	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = "getUserByIdAndPassword", method = RequestMethod.POST)
	public ResponseEntity<?> getUserByIdAndPassword(HttpServletRequest request) {
		UserBean userBean = new UserBean();
		String message = "Id/Password/Domain Name entered is incorrect..";
		int statusCode = 500;
		HttpHeaders responseHeaders = new HttpHeaders();
		ApiResponseModal model = new ApiResponseModal();

		try {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");

			userBean = loginService.checkLogin(userId, password);

			if (userBean != null) {
				message = "success";
				statusCode = 200;
			}
		} catch (Exception e) {

		}
		model.setData(userBean);
		model.setMessage(message);
		model.setStatusCode(statusCode);

		return new ResponseEntity<>(model, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public ResponseEntity<?> changePassword(HttpServletRequest request) {

		int userPk = Integer.parseInt(request.getParameter("userPk"));

		String newPassword = request.getParameter("newPassword");

		loginService.changePasswordByUserPk(userPk, newPassword);

		String message = "Password changed successfully.";
		int statusCode = 200;

		HttpHeaders responseHeaders = new HttpHeaders();
		ApiResponseModal model = new ApiResponseModal();

		model.setData("");
		model.setMessage(message);
		model.setStatusCode(statusCode);

		return new ResponseEntity<>(model, responseHeaders, HttpStatus.OK);
	}

}
