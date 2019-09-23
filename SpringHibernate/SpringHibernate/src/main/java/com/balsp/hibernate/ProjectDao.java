package com.balsp.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ProjectDao {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
  
    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    Session session = factory.openSession();  
    Transaction t = session.beginTransaction();
	
	public boolean saveProject(Project p) {
		session.save(p);  
	    t.commit();  
	    System.out.println("successfully saved");    
	    factory.close();  
	    session.close();
	    return true;
	}
	
	public List<Project> getProjects(){
		List<Project> projects = session.createQuery("FROM Project").list();
		return projects;
	}
}
