package com.pjt.ex22.exhibit.service;

import java.util.List;

import com.pjt.ex22.exhibit.Exhibit;

public interface IExhibitService {
	List<Exhibit> exhibitAllSearch();
	Exhibit exhibitSearch(Exhibit exhibit);
//	Exhibit existEx(Exhibit exhibit);
}
