package com.mphasis.training.controller;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	public void update() {
}
	@Autowired
	DoctorBo doctorBo;
	@RequestMapping(value = "/doctors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Doctor> getAll() {
		return doctorBo.getDoctors();

	}
	
	@RequestMapping(value = "/doctors/{clinic}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Doctor> getDocbyClinic(@RequestBody Clinic clinic) {
		return doctorBo.getDoctorByClinic(clinic);
	}
	@RequestMapping(value = "/delete/{dId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteDoctor(@PathVariable("dId") int did) {
		doctorBo.deleteDoctor(did);
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertDoctor(@RequestBody Doctor doctor) {
		doctorBo.insertDoctor(doctor);
	}
	
	
	
}
