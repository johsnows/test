package com.hpe.online.dao.impl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hpe.online.dao.IAdminDao;
import com.hpe.online.pojo.Admin;
import com.hpe.online.util.DButil;

public class AdminDaoImpl implements IAdminDao {

	@Override
	public Admin select(String username, String password) {
		// TODO Auto-generated method stub\
	
			String sql="select * from admin where aid=? and apwd= ?";
			Object[] params={username, password};
			return  DButil.getObject(sql, params, Admin.class);
			
	}
	
	

}
