package com.mphasis.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.bo.LoginBo;
import com.mphasis.training.bo.MemberBo;
import com.mphasis.training.entities.Member;

@RestController
@RequestMapping("/LoginSignup")
public class LoginSignupController {
	@Autowired
	LoginBo loginBo;

	@Autowired
	MemberBo memberBo;

	@RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Member login(@PathVariable(value = "email") String email,
			@PathVariable(value = "password") String password) {
		System.out.println("login called");
		return loginBo.LoginImpl(email, password);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertMember(@RequestBody Member member) {
		memberBo.insertMember(member);
	}

}
