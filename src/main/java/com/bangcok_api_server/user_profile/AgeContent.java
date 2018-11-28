// DB에서 사용자의 나이를 고려한 관광지 타입내용을 가져오는 Class

package com.bangcok_api_server.user_profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AgeContent {
	// input : 사용자가 입력한 나이
	// output : 나이에 따른 관광지 타입별 점수를 저장한 배열
	
	public static int[] AgeContent(int x) {
		
		String url = "jdbc:mysql://localhost:3306/bangcoktest?userSSL=false&characterEncoding=UTF-8&serverTimezone=UTC&user=root&password=526526526";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	    int[] Content = new int[7]; // 관광지 타입별 점수를 저장할 배열 선언 및 초기화
		String age = ""; // DB에 저장되어 있는 칼럼 이름을 저장할 문자열 선언 및 초기화
		
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement();
			
			// if문을 통해 사용자의 나이에 따라 칼럼명에 맞도록 문자열 대입
			if(x < 20) {
				age = "10대";
			} else if (x >= 20 && x < 30) {
				age = "20대";
			} else if (x >= 30 && x < 40) {
				age = "30대";
			} else if (x >= 40 && x < 50) {
				age = "40대";
			} else if (x >= 50 && x < 60) {
				age = "50대";
			} else
				age = "60대 이상";
			
			// DB에서 해당되는 칼럼을 찾아 모든 값을 가져오는 쿼리문
			String query = "select * from content_by_age where age = '" + age + "'";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				
				// 사례수/tour/food/shopping/culture/festival/reports 순서대로 배열에 저장
				Content[0] = rs.getInt("cases");
				Content[1] = rs.getInt("tour");
				Content[2] = rs.getInt("food");
				Content[3] = rs.getInt("shopping");
				Content[4] = rs.getInt("culture");
				Content[5] = rs.getInt("festival");
				Content[6] = rs.getInt("reports");
			}

		}
		
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			if(conn!=null) try {conn.close();} catch(SQLException se) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException se) {}
			if(rs!=null) try {rs.close();} catch(SQLException se) {}
		}
		
		return Content; // 배열을 리턴
	}
}
