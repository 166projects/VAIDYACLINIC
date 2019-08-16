package com.mphasis.training.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.SpecializationDao;
import com.mphasis.training.entities.Specialization;

@Service
public class SpecializationBoImpl implements SpecializationBo {
	@Autowired
	SpecializationDao specializationDao;

	public void insertSpecialization(Specialization specialization) {
		specializationDao.insertSpecialization(specialization);
	}

	public void updateSpecialization(Specialization specialization) {
		specializationDao.updateSpecialization(specialization);
	}

}
