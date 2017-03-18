package com.incidentmanagement.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.incidentmanagement.util.JsonUtil;

@ManagedBean(eager = true, name = "applicationBean")
@ApplicationScoped
public class ApplicationBean {

	private Map<String, Map<String, String>> simpleDropDowns = new HashMap<>();
	private Map<String, Map<String, Map<String, Map<String, String>>>> specialDropDowns = new HashMap<>();
	
	public ApplicationBean() {
		// Initialize both objects
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("../resources/json.json");
		simpleDropDowns = JsonUtil.parseSimpleDropDowns(resourceAsStream);
		resourceAsStream = getClass().getClassLoader().getResourceAsStream("../resources/json.json");
		specialDropDowns = JsonUtil.parseRecursiveDropDowns(resourceAsStream);
	}
	
	public Map<String, Map<String, String>> getSimpleDropDowns() {
		return simpleDropDowns;
	}

	public void setSimpleDropDowns(Map<String, Map<String, String>> simpleDropDowns) {
		this.simpleDropDowns = simpleDropDowns;
	}

	public Map<String, Map<String, Map<String, Map<String, String>>>> getSpecialDropDowns() {
		return specialDropDowns;
	}

	public void setSpecialDropDowns(Map<String, Map<String, Map<String, Map<String, String>>>> specialDropDowns) {
		this.specialDropDowns = specialDropDowns;
	}
	
}
