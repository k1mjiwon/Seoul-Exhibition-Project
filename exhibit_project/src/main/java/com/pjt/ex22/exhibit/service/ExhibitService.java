package com.pjt.ex22.exhibit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt.ex22.exhibit.Exhibit;
import com.pjt.ex22.exhibit.dao.ExhibitDao;
@Service
public class ExhibitService implements IExhibitService {
	
	@Autowired
	ExhibitDao dao;
	
	@Override
	public List<Exhibit> exhibitAllSearch() {
		// TODO Auto-generated method stub
		return dao.ExhibitAllSelect();
	}

	@Override
	public Exhibit exhibitSearch(Exhibit exhibit) {
		// TODO Auto-generated method stub
		return dao.ExhibitSelect(exhibit);
	}
	
//	@Override
//	public Exhibit existEx(Exhibit exhibit) {
//		return dao.existEx(exhibit);
//	}

}
