package com.incidentmanagement.dao;

import java.util.List;

import com.incidentmanagement.model.Incident;

public interface IncidentDao {

	public Boolean save(Incident incident);
	
	public List<Incident> getAll();
	
}
