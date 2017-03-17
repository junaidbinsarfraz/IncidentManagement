package com.incidentmanagement.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.incidentmanagement.dao.IncidentDao;
import com.incidentmanagement.dao.IncidentDaoImpl;
import com.incidentmanagement.model.Incident;
import com.incidentmanagement.model.User;

@ManagedBean(name = "homeBean")
@ViewScoped
public class HomeBean implements Serializable {
	
	private IncidentDao incidentDao = new IncidentDaoImpl();
	private List<Incident> incidents = new ArrayList<Incident>();
	private Incident incident = new Incident();
	private Boolean isIncidentLieAuProcessusDoctroiDeCredit = Boolean.TRUE;
	private List<Incident> filteredIncidents;
	
	// Put all drop down values here
	
	/*private Map<String, List<String>> simpleDropDowns = new HashMap<>();
	private Map<String, Map<String, Map<String, List<String>>>> specialDropDowns = new HashMap<>();*/
	
	/*@ManagedProperty("#{applicationBean}")
    private ApplicationBean container;*/
	
	public Boolean getIsIncidentLieAuProcessusDoctroiDeCredit() {
		return isIncidentLieAuProcessusDoctroiDeCredit;
	}

	public void setIsIncidentLieAuProcessusDoctroiDeCredit(Boolean isIncidentLieAuProcessusDoctroiDeCredit) {
		this.isIncidentLieAuProcessusDoctroiDeCredit = isIncidentLieAuProcessusDoctroiDeCredit;
	}

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = (User) context.getExternalContext().getSessionMap().get("user");
		
		if(user == null) {
//			return "login?faces-redirect=true";
		} else {
			incident.setServiceCode(user.getServiceCode());
			incident.setUserId(user.getUserId());
		}
		
		/*simpleDropDowns = container.getSimpleDropDowns();
		specialDropDowns = container.getSpecialDropDowns();*/
	}
	
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public String save() {
		
		this.incident.setIncidentLieAuProcessusDoctroiDeCredit(this.isIncidentLieAuProcessusDoctroiDeCredit ? "y" : "n");
		
		Boolean result = incidentDao.save(incident);
		
		if(Boolean.FALSE.equals(result)) {
			FacesContext.getCurrentInstance().addMessage("invalid",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Unable to save incident.", ""));
			return null;
		}
		
		return "index?faces-redirect=true";
	}

	public List<Incident> getIncidents() {
		
		// Get Latest
		incidents = incidentDao.getAll();
		
		return incidents;
	}

	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}

	public List<Incident> getFilteredIncidents() {
		return filteredIncidents;
	}

	public void setFilteredIncidents(List<Incident> filteredIncidents) {
		this.filteredIncidents = filteredIncidents;
	}
	
}
