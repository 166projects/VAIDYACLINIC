package com.mphasis.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.bo.LeaveBo;
import com.mphasis.training.entities.Leave;
import com.mphasis.training.entities.Member;

@RestController
@RequestMapping("/reporter")
public class ReporterController {

	@Autowired
	LeaveBo leaveBo;

	@RequestMapping(value = "/approveLeave", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void approveLeave(@RequestBody Leave leave) {
		leaveBo.approveLeave(leave);
	}

	@RequestMapping(value = "/denyLeave", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void denyLeave(@RequestBody Leave leave) {
		leaveBo.denyLeave(leave);
	}
	
	@RequestMapping(value = "/leaves", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Leave> getAllLeaves() {
		return leaveBo.getLeaves();

	}

	

}
