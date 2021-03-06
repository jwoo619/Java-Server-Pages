package ex12;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MemberDAO {
	
	
	private String url = "jdbc:mysql://localhost:3306/member";
	private String uid = "root";
	private String upw = "1234";
	
	public MemberDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public ArrayList<MemberDTO> memberSelect(){
		
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = (Connection) DriverManager.getConnection(url, uid, upw);
			statement = (Statement) connection.createStatement();
			resultSet = statement.executeQuery("Select * from member;");
			
			while(resultSet.next()){
				String name = resultSet.getString("name");
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String phone1 = resultSet.getString("phone1");
				String phone2 = resultSet.getString("phone2");
				String phone3 = resultSet.getString("phone3");
				String gender = resultSet.getString("gender");
				
				MemberDTO dto = new MemberDTO(name,id,pw,phone1,phone2,phone3,gender);
				dtos.add(dto);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		return dtos;
	}
}
