package com.bangcok_api_server.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bangcok_api_server.domain.TrendTourismVO;
import com.bangcok_api_server.persistence.TrendTourismDAO;

@Service
public class TrendTourismServiceImpl implements TrendTourismService {
	
	@Inject
	TrendTourismDAO dao;
		
	@Override
	public List<TrendTourismVO> listTrendTourism() {
		return dao.listTrendTourism();
	}

}
