package com.mphasis.training.bo;

import java.util.List;

import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Location;

public interface LocationBo {
	public void insertLocation(Location location);
	public void updateLocation(Location location);
	public void deleteLocation(int lid);
	public List<Location> getLocation();

	
}


