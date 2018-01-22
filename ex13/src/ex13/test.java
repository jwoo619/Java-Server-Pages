package ex13;

import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;

import java.sql.*;

import javax.sql.*;

import javax.naming.*;



public class  test {

	public static void main(String[] args) {
		try {

			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
			Connection conn = source.getConnection();
			System.out.println("연결성");


		}catch(Exception e) {
		System.out.println("fail");
		}

	}
}

