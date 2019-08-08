package com.mphasis.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.training.bo.ClinicBo;
import com.mphasis.training.bo.LocationBo;
import com.mphasis.training.dao.LocationDao;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Location;



@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	ClinicBo clinicBo;
	@Autowired
	LocationBo locationBo;

	@RequestMapping(value = "/clinics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Clinic> getAll() {
		return clinicBo.getClinics();

	}
	@RequestMapping(value = "/clinicAdd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addClinic(@RequestBody Clinic clinic) {

		System.out.println("inside controller");
		clinicBo.insertClinic(clinic);
	}
	@RequestMapping(value = "/locationAdd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addLocation(@RequestBody Location location) {

		locationBo.insertLocation(location);
	}
	@RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getAllLocation() {
		return locationBo.getLocation();

	}
	
	
	


}
