package com.hsl.ecargo.common.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * datebase util
 * @author hushenglang
 * @date 2015年9月7日 下午9:46:16
 * 
 */
public final class DBUtil {
	private static final Logger log = Logger.getLogger(DBUtil.class);
	/**
	 * close all database resources
	 * @param objs
	 */
	public static void closeResources(Object... objs) {
		for (Object obj : objs) {
			if (obj instanceof Connection)
				close((Connection) obj);
			if (obj instanceof Statement)
				close((Statement) obj);
			if (obj instanceof ResultSet)
				close((ResultSet) obj);
		}
	}
	
	private static void close(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("close db resources error occured!", e);
			}
	}

	private static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				log.error("close db resources error occured!", e);
			}
	}

	private static void close(Statement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				log.error("close db resources error occured!", e);
			}
	}

}
