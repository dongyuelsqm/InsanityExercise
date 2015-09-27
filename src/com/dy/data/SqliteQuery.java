package com.dy.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongy on 2015/9/21.
 */
public class SqliteQuery {
    private static Connection conn = null;
    private static Statement statement = null;
    private static ResultSet rs;
    public static String selectWebSiteFromDb(String webName) throws SQLException, ClassNotFoundException {
        try {
            executeSQL("select webSite from webInfo where webInfo.webName='" + webName+"'");
            return exactMsgFromResultSet().get(0);
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            closeResource();
        }
    }

    public static List<String> queryPracticePlan() throws ClassNotFoundException, SQLException {
        try {
            executeSQL("select webInfo.webName from webInfo,DateClassTable where DateClassTable.ClassID = webInfo.ClassID order by DateClassTable.Date");
            return exactMsgFromResultSet();
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            closeResource();
        }
    }

    private static void executeSQL(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection(getUrl());
        statement = conn.createStatement();
        rs = statement.executeQuery(sql);
    }

    private static List<String> exactMsgFromResultSet() throws SQLException {
        List<String> classNames = new ArrayList<String>();
        while (rs.next()){
            classNames.add(rs.getString(1));
        }
        return classNames;
    }

    private static void initDbMsg() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection(getUrl());
        statement = conn.createStatement();
    }

    static String getUrl() {return "jdbc:sqlite:data\\aa.db";}

    private static void closeResource() {
        closeResultSet();
        closeStatement();
        closeConnection();
    }

    private static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void closeStatement(){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeResultSet(){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
