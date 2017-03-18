package com.incidentmanagement.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.incidentmanagement.dao.IncidentDao;
import com.incidentmanagement.dao.IncidentDaoImpl;
import com.incidentmanagement.model.Incident;
import com.incidentmanagement.model.User;
import com.incidentmanagement.util.Constants;

@ManagedBean(name = "homeBean")
@ViewScoped
public class HomeBean implements Serializable {
	
	private IncidentDao incidentDao = new IncidentDaoImpl();
	private List<Incident> incidents = new ArrayList<Incident>();
	private Incident incident = new Incident();
	private Boolean isIncidentLieAuProcessusDoctroiDeCredit = Boolean.TRUE;
	private List<Incident> filteredIncidents;
	
	// Simple Dropdowns
	private Map<String, String> akDropdown = new HashMap<>();
	private Map<String, String> alDropdown = new HashMap<>();
	private Map<String, String> amDropdown = new HashMap<>();
	private Map<String, String> avDropdown = new HashMap<>();
	private Map<String, String> awDropdown = new HashMap<>();
	private Map<String, String> axDropdown = new HashMap<>();
	private Map<String, String> ayDropdown = new HashMap<>();
	
	// Special Dropdowns
	private Map<String, String> anDropdown = new HashMap<>();
	private Map<String, String> aoDropdown = new HashMap<>();
	private Map<String, String> arDropdown = new HashMap<>();
	private Map<String, String> auDropdown = new HashMap<>();
	
	/*@ManagedProperty("#{applicationBean}")
    private ApplicationBean applicationBean;*/
	
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
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
//			return "login?faces-redirect=true";
		} else {
			incident.setServiceCode(user.getServiceCode());
			incident.setUserId(user.getUserId());
		}
		
		ApplicationBean applicationBean = (ApplicationBean) context.getExternalContext().getApplicationMap().get("applicationBean"); //(ApplicationBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "applicationBean");// getApplication().evaluateExpressionGet(context, "#{applicationBean}", ApplicationBean.class);
		
		// Simple Drop Down
		
		akDropdown = applicationBean.getSimpleDropDowns().get(Constants.DECISION_ADMISSION_REJECT);
		alDropdown = applicationBean.getSimpleDropDowns().get(Constants.STATUS_DE_INCIDENT);
		amDropdown = applicationBean.getSimpleDropDowns().get(Constants.TYPE_DE_REFERENCE_EXTERNE);
		avDropdown = applicationBean.getSimpleDropDowns().get(Constants.CODE_ETAT_ACTUAEL_DU_PERT_SUR);
		awDropdown = applicationBean.getSimpleDropDowns().get(Constants.ETATE_DE_LA_PERTE);
		axDropdown = applicationBean.getSimpleDropDowns().get(Constants.CLASSIFICATION_DE_LA_PERTE);
		ayDropdown = applicationBean.getSimpleDropDowns().get(Constants.NOTATION_DE_LA_PERTE_EN_REPUTATION);
		
		
		// Special Drop Down
		
		List<String> myList = new ArrayList<>(applicationBean.getSpecialDropDowns().keySet());
		anDropdown = myList.stream().collect(Collectors.toMap(x -> x.toString(), x -> x.toString()));
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
	
	public String cancel() {
		// Cleanup ths stuff
		return "index?faces-redirect=true";
	}

	
	public String logout() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("user", null);
		
		return "login?faces-redirect=true";
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

	public Map<String, String> getAkDropdown() {
		return akDropdown;
	}

	public void setAkDropdown(Map<String, String> akDropdown) {
		this.akDropdown = akDropdown;
	}

	public Map<String, String> getAlDropdown() {
		return alDropdown;
	}

	public void setAlDropdown(Map<String, String> alDropdown) {
		this.alDropdown = alDropdown;
	}

	public Map<String, String> getAmDropdown() {
		return amDropdown;
	}

	public void setAmDropdown(Map<String, String> amDropdown) {
		this.amDropdown = amDropdown;
	}

	public Map<String, String> getAvDropdown() {
		return avDropdown;
	}

	public void setAvDropdown(Map<String, String> avDropdown) {
		this.avDropdown = avDropdown;
	}

	public Map<String, String> getAwDropdown() {
		return awDropdown;
	}

	public void setAwDropdown(Map<String, String> awDropdown) {
		this.awDropdown = awDropdown;
	}

	public Map<String, String> getAxDropdown() {
		return axDropdown;
	}

	public void setAxDropdown(Map<String, String> axDropdown) {
		this.axDropdown = axDropdown;
	}

	public Map<String, String> getAyDropdown() {
		return ayDropdown;
	}

	public void setAyDropdown(Map<String, String> ayDropdown) {
		this.ayDropdown = ayDropdown;
	}

	public Map<String, String> getAnDropdown() {
		return anDropdown;
	}

	public void setAnDropdown(Map<String, String> anDropdown) {
		this.anDropdown = anDropdown;
	}

	public Map<String, String> getAoDropdown() {
		return aoDropdown;
	}

	public void setAoDropdown(Map<String, String> aoDropdown) {
		this.aoDropdown = aoDropdown;
	}

	public Map<String, String> getArDropdown() {
		return arDropdown;
	}

	public void setArDropdown(Map<String, String> arDropdown) {
		this.arDropdown = arDropdown;
	}

	public Map<String, String> getAuDropdown() {
		return auDropdown;
	}

	public void setAuDropdown(Map<String, String> auDropdown) {
		this.auDropdown = auDropdown;
	}

	public void onFirstDDChange() {
		if(this.incident.getComiteDeBaleN1() == null || this.incident.getComiteDeBaleN1().isEmpty()) {
			// Reset All three
			this.aoDropdown = new HashMap<>();
			this.arDropdown = new HashMap<>();
			this.auDropdown = new HashMap<>();
			
			this.incident.setComiteDeBaleN2("");
			this.incident.setBaseSectorielleGoldN3("");
			this.incident.setTypologieDesIncidentsLies("");
			return;
		}
		
		// Set first child and reset others
		FacesContext context = FacesContext.getCurrentInstance();
		ApplicationBean applicationBean = (ApplicationBean) context.getExternalContext().getApplicationMap().get("applicationBean");
		
		this.aoDropdown = (new ArrayList<>(applicationBean.getSpecialDropDowns().
				// Get children level
				get(this.incident.getComiteDeBaleN1()).keySet())).
				// Convert to Map<String, String>
				stream().collect(Collectors.toMap(x -> x.toString(), x -> x.toString()));
		
		this.arDropdown = new HashMap<>();
		this.auDropdown = new HashMap<>();
		
		this.incident.setComiteDeBaleN2("");
		this.incident.setBaseSectorielleGoldN3("");
		this.incident.setTypologieDesIncidentsLies("");
		
	}
	
	public void onSecondDDChange() {
		if(this.incident.getComiteDeBaleN2() == null || this.incident.getComiteDeBaleN2().isEmpty()) {
			// Reset All three
			this.arDropdown = new HashMap<>();
			this.auDropdown = new HashMap<>();
			
			this.incident.setBaseSectorielleGoldN3("");
			this.incident.setTypologieDesIncidentsLies("");
			return;
		}
		
		// Set first child and reset others
		FacesContext context = FacesContext.getCurrentInstance();
		ApplicationBean applicationBean = (ApplicationBean) context.getExternalContext().getApplicationMap().get("applicationBean"); //(ApplicationBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "applicationBean");// getApplication().evaluateExpressionGet(context, "#{applicationBean}", ApplicationBean.class);
		
		this.arDropdown = (new ArrayList<>(applicationBean.getSpecialDropDowns().
				// Get children level
				get(this.incident.getComiteDeBaleN1()).get(this.incident.getComiteDeBaleN2()).keySet())).
				// Convert to Map<String, String>
				stream().collect(Collectors.toMap(x -> x.toString(), x -> x.toString()));
		
		this.auDropdown = new HashMap<>();
		
		this.incident.setBaseSectorielleGoldN3("");
		this.incident.setTypologieDesIncidentsLies("");
		
	}
	
	public void onThirdDDChange() {
		if(this.incident.getBaseSectorielleGoldN3() == null || this.incident.getBaseSectorielleGoldN3().isEmpty()) {
			// Reset All three
			this.auDropdown = new HashMap<>();
			
			this.incident.setTypologieDesIncidentsLies("");
			return;
		}
		
		// Set first child and reset others
		FacesContext context = FacesContext.getCurrentInstance();
		ApplicationBean applicationBean = (ApplicationBean) context.getExternalContext().getApplicationMap().get("applicationBean"); //(ApplicationBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "applicationBean");// getApplication().evaluateExpressionGet(context, "#{applicationBean}", ApplicationBean.class);
		
		this.arDropdown = (new ArrayList<>(applicationBean.getSpecialDropDowns().
				// Get children level
				get(this.incident.getComiteDeBaleN1()).get(this.incident.getComiteDeBaleN2()).keySet())).
				// Convert to Map<String, String>
				stream().collect(Collectors.toMap(x -> x.toString(), x -> x.toString()));
		
		this.auDropdown = applicationBean.getSpecialDropDowns().
				get(this.incident.getComiteDeBaleN1()).get(this.incident.getComiteDeBaleN2()).get(this.incident.getBaseSectorielleGoldN3());
		
		this.incident.setTypologieDesIncidentsLies("");
		
	}
	
}
