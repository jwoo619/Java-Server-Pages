package com.javalec.ex.dao;

import javax.activation.DataSource;
import javax.naming.InitialContext;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

public class BDao {
	
	DataSource dataSource;
	
	public BDao(){
		
		try {
			Context context = (Context) new InitialContext();
			dataSource = (DataSource) ((InitialContext) context).lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

}
