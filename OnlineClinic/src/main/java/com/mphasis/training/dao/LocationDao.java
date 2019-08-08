package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Location;

public interface LocationDao {
	public void insertLocation(Location location);
	public void updateLocation(Location location);
	public void deleteLocation(int lid);
	public List<Location> getLocation();
}
