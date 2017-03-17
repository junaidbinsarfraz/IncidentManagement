package com.incidentmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.incidentmanagement.model.Incident;
import com.incidentmanagement.util.HibernateUtil;

public class IncidentDaoImpl implements IncidentDao {

	@Override
	public Boolean save(Incident incident) {

		try {
			
			incident.setAutoId(getLastIncidentAutoId() + 1);

			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			session.save(incident);
			session.getTransaction().commit();
			
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}

	private Integer getLastIncidentAutoId() {
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			Criteria c = session.createCriteria(Incident.class);
			c.addOrder(Order.desc("autoId"));
			c.setMaxResults(1);
			
			Incident incident = (Incident) c.uniqueResult();
			
			if(incident == null) {
				session.close();
				return 0;
			}
			
			session.close();
			
			return incident.getAutoId();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Incident> getAll() {
		
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			Criteria c = session.createCriteria(Incident.class);
			
			return c.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<Incident>();
	}

}
