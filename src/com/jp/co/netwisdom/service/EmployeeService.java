package com.jp.co.netwisdom.service;

import java.sql.SQLException;
import java.util.List;

import com.jp.co.netwisdom.dao.EmployeeDao;
import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.interfaces.QueryIF;

public class EmployeeService {
	
	public List<EmployeeEntity> queryEmployees () 
		throws SQLException {
		QueryIF queryBean = new EmployeeDao();
		return queryBean.queryAllEmployee();
	}
	
}
