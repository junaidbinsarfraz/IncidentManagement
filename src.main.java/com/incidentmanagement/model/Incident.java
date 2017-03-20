package com.incidentmanagement.model;

import java.io.Serializable;
import java.util.Date;

public class Incident implements Serializable {

	private Integer autoId;
	private Date dateOverture;
	private String userId;
	private String serviceCode;
	private Date dateDeIncident;
	private String etatDeIncident;
	private String incidentAssignee;
	private Date prochaineDateDeSuivi;
	private Date memoPourProchaineDateDeSuivi;
	private String typeDeReferenceExterne;
	private String comiteDeBaleN1;
	private String comiteDeBaleN2;
	private String baseSectorielleGoldN3;
	private String incidentLieAuProcessusDoctroiDeCredit;
	private String typologieDesIncidentsLies;
	private String prenomNomDuClient;
	private Date dateDeDecaissement;
	private String montantDebloqueUsd;
	private String descriptionDelncident;
	private String joursArrieresDuPret;
	private String codeEtatActuelDuPret;
	private String descriptionDelncident1;
	private String etatDeLaPerte;
	private String classificationDeLaPerte;
	private String montantBrut;
	private String recouvrementNet;
	private String notationDeLaPerteEnReputation;
	private String agences;
	private String uniteOraganisationnelleConcernee;
	private String processusConcerne;
	private String procedureInstructionConernees;

	public Integer getAutoId() {
		return autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	public Date getDateOverture() {
		return dateOverture;
	}

	public void setDateOverture(Date dateOverture) {
		this.dateOverture = dateOverture;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Date getDateDeIncident() {
		return dateDeIncident;
	}

	public void setDateDeIncident(Date dateDeIncident) {
		this.dateDeIncident = dateDeIncident;
	}

	public String getEtatDeIncident() {
		return etatDeIncident;
	}

	public void setEtatDeIncident(String etatDeIncident) {
		this.etatDeIncident = etatDeIncident;
	}

	public String getIncidentAssignee() {
		return incidentAssignee;
	}

	public void setIncidentAssignee(String incidentAssignee) {
		this.incidentAssignee = incidentAssignee;
	}

	public Date getProchaineDateDeSuivi() {
		return prochaineDateDeSuivi;
	}

	public void setProchaineDateDeSuivi(Date prochaineDateDeSuivi) {
		this.prochaineDateDeSuivi = prochaineDateDeSuivi;
	}

	public Date getMemoPourProchaineDateDeSuivi() {
		return memoPourProchaineDateDeSuivi;
	}

	public void setMemoPourProchaineDateDeSuivi(Date memoPourProchaineDateDeSuivi) {
		this.memoPourProchaineDateDeSuivi = memoPourProchaineDateDeSuivi;
	}

	public String getTypeDeReferenceExterne() {
		return typeDeReferenceExterne;
	}

	public void setTypeDeReferenceExterne(String typeDeReferenceExterne) {
		this.typeDeReferenceExterne = typeDeReferenceExterne;
	}

	public String getComiteDeBaleN1() {
		return comiteDeBaleN1;
	}

	public void setComiteDeBaleN1(String comiteDeBaleN1) {
		this.comiteDeBaleN1 = comiteDeBaleN1;
	}

	public String getComiteDeBaleN2() {
		return comiteDeBaleN2;
	}

	public void setComiteDeBaleN2(String comiteDeBaleN2) {
		this.comiteDeBaleN2 = comiteDeBaleN2;
	}

	public String getBaseSectorielleGoldN3() {
		return baseSectorielleGoldN3;
	}

	public void setBaseSectorielleGoldN3(String baseSectorielleGoldN3) {
		this.baseSectorielleGoldN3 = baseSectorielleGoldN3;
	}

	public String getIncidentLieAuProcessusDoctroiDeCredit() {
		return incidentLieAuProcessusDoctroiDeCredit;
	}

	public void setIncidentLieAuProcessusDoctroiDeCredit(String incidentLieAuProcessusDoctroiDeCredit) {
		this.incidentLieAuProcessusDoctroiDeCredit = incidentLieAuProcessusDoctroiDeCredit;
	}

	public String getTypologieDesIncidentsLies() {
		return typologieDesIncidentsLies;
	}

	public void setTypologieDesIncidentsLies(String typologieDesIncidentsLies) {
		this.typologieDesIncidentsLies = typologieDesIncidentsLies;
	}

	public String getPrenomNomDuClient() {
		return prenomNomDuClient;
	}

	public void setPrenomNomDuClient(String prenomNomDuClient) {
		this.prenomNomDuClient = prenomNomDuClient;
	}

	public Date getDateDeDecaissement() {
		return dateDeDecaissement;
	}

	public void setDateDeDecaissement(Date dateDeDecaissement) {
		this.dateDeDecaissement = dateDeDecaissement;
	}

	public String getMontantDebloqueUsd() {
		return montantDebloqueUsd;
	}

	public void setMontantDebloqueUsd(String montantDebloqueUsd) {
		this.montantDebloqueUsd = montantDebloqueUsd;
	}

	public String getDescriptionDelncident() {
		return descriptionDelncident;
	}

	public void setDescriptionDelncident(String descriptionDelncident) {
		this.descriptionDelncident = descriptionDelncident;
	}

	public String getJoursArrieresDuPret() {
		return joursArrieresDuPret;
	}

	public void setJoursArrieresDuPret(String joursArrieresDuPret) {
		this.joursArrieresDuPret = joursArrieresDuPret;
	}

	public String getCodeEtatActuelDuPret() {
		return codeEtatActuelDuPret;
	}

	public void setCodeEtatActuelDuPret(String codeEtatActuelDuPret) {
		this.codeEtatActuelDuPret = codeEtatActuelDuPret;
	}

	public String getDescriptionDelncident1() {
		return descriptionDelncident1;
	}

	public void setDescriptionDelncident1(String descriptionDelncident1) {
		this.descriptionDelncident1 = descriptionDelncident1;
	}

	public String getEtatDeLaPerte() {
		return etatDeLaPerte;
	}

	public void setEtatDeLaPerte(String etatDeLaPerte) {
		this.etatDeLaPerte = etatDeLaPerte;
	}

	public String getClassificationDeLaPerte() {
		return classificationDeLaPerte;
	}

	public void setClassificationDeLaPerte(String classificationDeLaPerte) {
		this.classificationDeLaPerte = classificationDeLaPerte;
	}

	public String getMontantBrut() {
		return montantBrut;
	}

	public void setMontantBrut(String montantBrut) {
		this.montantBrut = montantBrut;
	}

	public String getRecouvrementNet() {
		return recouvrementNet;
	}

	public void setRecouvrementNet(String recouvrementNet) {
		this.recouvrementNet = recouvrementNet;
	}

	public String getNotationDeLaPerteEnReputation() {
		return notationDeLaPerteEnReputation;
	}

	public void setNotationDeLaPerteEnReputation(String notationDeLaPerteEnReputation) {
		this.notationDeLaPerteEnReputation = notationDeLaPerteEnReputation;
	}

	public String getAgences() {
		return agences;
	}

	public void setAgences(String agences) {
		this.agences = agences;
	}

	public String getUniteOraganisationnelleConcernee() {
		return uniteOraganisationnelleConcernee;
	}

	public void setUniteOraganisationnelleConcernee(String uniteOraganisationnelleConcernee) {
		this.uniteOraganisationnelleConcernee = uniteOraganisationnelleConcernee;
	}

	public String getProcessusConcerne() {
		return processusConcerne;
	}

	public void setProcessusConcerne(String processusConcerne) {
		this.processusConcerne = processusConcerne;
	}

	public String getProcedureInstructionConernees() {
		return procedureInstructionConernees;
	}

	public void setProcedureInstructionConernees(String procedureInstructionConernees) {
		this.procedureInstructionConernees = procedureInstructionConernees;
	}

}
