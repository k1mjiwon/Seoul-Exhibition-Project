package com.pjt.ex22.exhibit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.pjt.ex22.exhibit.*;

@Repository
public class ExhibitDao implements IExhibitDao {

	
	private JdbcTemplate template;

	
	@Autowired
	public ExhibitDao(ComboPooledDataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Exhibit> ExhibitAllSelect() {
		// TODO Auto-generated method stub
		List<Exhibit> exList = null;
		String sql = "select * from exhibition";
		
		try {
			exList = template.query(sql, new RowMapper<Exhibit>() {
				@Override
				public Exhibit mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Exhibit ex = new Exhibit();

					ex.setLatClick(rs.getString("latclick"));
					ex.setLngClick(rs.getString("lngclick"));
					ex.setAddress(rs.getString("address"));
					ex.setName(rs.getString("name"));
					ex.setSubject(rs.getString("subject"));
					ex.setPeriodDate(rs.getString("perioddate"));
					ex.setPeriodTime(rs.getString("periodtime"));
					ex.setDayOff(rs.getString("dayoff"));
					ex.setFare(rs.getString("fare"));
					ex.setFarePlace(rs.getString("fareplace"));
					ex.setWebsite(rs.getString("website"));
					ex.setPhone(rs.getString("phone"));
					ex.setMetro(rs.getString("metro"));
					ex.setThumbnail(rs.getString("thumbnail"));
					
					return ex;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return exList;
	}

//	@Override
//	public Exhibit existEx(Exhibit exhibit) {
//		String sql = "select count(name) from tbl_p where name = ?";
//		int result = template.queryForInt(sql, exhibit.getName());
//		if (result == 0) return null; // 조회된 결과가 없습니다.
//		else {
//			return ExhibitSelect(exhibit);
//		}
//	}
	
	@Override
	public Exhibit ExhibitSelect(Exhibit exhibit) {
		List<Exhibit> exList = null;
			String sql = "select * from exhibition where name = ?";
			exList = template.query(sql, new RowMapper<Exhibit>() {
				@Override
				public Exhibit mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Exhibit ex = new Exhibit();

					ex.setLatClick(rs.getString("latclick"));
					ex.setLngClick(rs.getString("lngclick"));
					ex.setAddress(rs.getString("address"));
					ex.setName(rs.getString("name"));
					ex.setSubject(rs.getString("subject"));
					ex.setPeriodDate(rs.getString("perioddate"));
					ex.setPeriodTime(rs.getString("periodtime"));
					ex.setDayOff(rs.getString("dayoff"));
					ex.setFare(rs.getString("fare"));
					ex.setFarePlace(rs.getString("fareplace"));
					ex.setWebsite(rs.getString("website"));
					ex.setPhone(rs.getString("phone"));
					ex.setMetro(rs.getString("metro"));
					ex.setThumbnail(rs.getString("thumbnail"));
					
					return ex;
				}
			}, exhibit.getName());
		
		if (exList.isEmpty()) return null;
		return exList.get(0);
	}
}
