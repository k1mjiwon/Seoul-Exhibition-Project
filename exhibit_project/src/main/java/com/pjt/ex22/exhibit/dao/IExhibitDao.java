package com.pjt.ex22.exhibit.dao;

import java.util.List;

import com.pjt.ex22.exhibit.Exhibit;

public interface IExhibitDao {
	List<Exhibit> ExhibitAllSelect();
	Exhibit ExhibitSelect(Exhibit exhibit);
//	Exhibit existEx(Exhibit exhibit);	
}
