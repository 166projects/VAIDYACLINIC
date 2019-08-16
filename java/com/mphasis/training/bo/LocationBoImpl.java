package com.mphasis.training.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.LocationDao;
import com.mphasis.training.entities.Location;

@Service
public class LocationBoImpl implements LocationBo {

	@Autowired
	LocationDao locationDao;
	
	public void insertLocation(Location location) {
		locationDao.insertLocation(location);
	}

	public void updateLocation(Location location) {
		
		locationDao.updateLocation(location);
	}

	public void deleteLocation(int lid) {

		locationDao.deleteLocation(lid);
	}

	public List<Location> getLocation() {
		return locationDao.getLocation();
	}

}
