package com.example.exemploandroid;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class ClienteDao extends BaseDaoImpl<Cliente, Integer> {

	public ClienteDao(ConnectionSource connectionSource) throws SQLException {
		super(Cliente.class);
		setConnectionSource(connectionSource);
		initialize();
	}
}
