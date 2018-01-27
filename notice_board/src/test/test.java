package test;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class test {
	
	public static void main(String[] args) {
		
		
		try {
			Context init = new InitialContext();
	           
		    DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
		    ds.getConnection();
		    
		    
		    System.out.println("sucess");
		    
		} catch (NamingException e) {
			// TODO: handle exception
			System.out.println("fail");
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("fail");
		}
	}
	 
	
}
