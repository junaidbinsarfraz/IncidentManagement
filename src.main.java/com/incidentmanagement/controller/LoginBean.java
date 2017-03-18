package com.incidentmanagement.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.incidentmanagement.dao.LoginDao;
import com.incidentmanagement.dao.LoginDaoImpl;
import com.incidentmanagement.model.User;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void test() {
		System.out.println("Test");
	}

	public String login() {
		LoginDao loginDao = new LoginDaoImpl();

		User user = loginDao.login(this.user.getUserId(), this.user.getPassword());

		if (user == null) {
			FacesContext.getCurrentInstance().addMessage("invalid",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid userId or password", ""));
			return "";
		}
		
		this.user = user;
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("user", user);

		return "index?faces-redirect=true";
	}

}
