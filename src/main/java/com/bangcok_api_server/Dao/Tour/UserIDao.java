package com.bangcok_api_server.Dao.Tour;

public interface UserIDao {
	public void joinUser(String id, String pw, String name);
	public void loginUser(String id, String pw);
}
