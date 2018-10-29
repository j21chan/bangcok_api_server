// DB에서 사용자의 방한횟수를 고려한 관광지 타입내용을 가져오는 Class

package com.bangcok_api_server.user_profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountContent {
	public static int[] CountContent(int x) {
		
		// input : 사용자가 입력한 방한횟수
		// output : 방한횟수에 따른 관광지 타입별 점수를 저장한 배열
		
		String url = "jdbc:mysql://127.0.0.1/bangcoktest?useSSL=false&user=root&password=99189918";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	    int[] Content = new int[7]; // 관광지 타입별 점수를 저장할 배열 선언 및 초기화
		String count = ""; // DB에 저장되어 있는 칼럼 이름을 저장할 문자열 선언 및 초기화
		
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement();
			
			// if문을 통해 사용자의 방한횟수에 따라 칼럼명에 맞도록 문자열 대입
			if(x == 1) {
				count = "1회";
			} else if (x == 2) {
				count = "2회";
			} else if (x == 3) {
				count = "3회";
			} else
				count = "4회 이상";
			
			// DB에서 해당되는 칼럼을 찾아 모든 값을 가져오는 쿼리문
			String query = "select * from content_by_count where count = '" + count + "'";
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