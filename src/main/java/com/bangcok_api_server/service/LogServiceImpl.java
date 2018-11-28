package com.bangcok_api_server.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bangcok_api_server.persistence.LogDAO;

@Service
public class LogServiceImpl implements LogService {
	
	@Inject
	LogDAO dao;
	
	@Override
	public void insertTourismLog(List<Object> log) {
		dao.insertTourismLog(log);
	}
}
