package com.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DB_Utils {

    // adding static field so we can access in all static methods
    private static  Connection conn;
    private static  Statement stmt;
    private  static ResultSet resultSet;

    /**
     * a static method to create connection
     * with valid url and username password
     * */
    public static void createDBConnectionLibrary(){

        String connectionStr, username, password;

     connectionStr = ConfigurationReader.getProperty("Library2.database.url");
         username = ConfigurationReader.getProperty("Library2.database.username");
         password= ConfigurationReader.getProperty("Library2.database.password");

        try {
            conn = DriverManager.getConnection(connectionStr,username,password);
            System.out.println("CONNECTION SUCCESSFUL!!");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED!! "+ e.getMessage() );
        }

    }

    /**
     * method to create connection
     * @param connectionStr String to connect to DB
     * @param username String username
     * @param password String password
     */
    public static void createDBConnection(String connectionStr, String username, String password){


        try {
            conn = DriverManager.getConnection(connectionStr,username,password);
            System.out.println("CONNECTION SUCCESSFUL!!");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED!! "+ e.getMessage() );
        }

    }


    public static void createDBConnection(String env){
        String connectionStr = ConfigurationReader.getProperty(env+".database.url");
        String username = ConfigurationReader.getProperty(env+".database.username");
        String password= ConfigurationReader.getProperty(env+".database.password");

        try {
            conn = DriverManager.getConnection(connectionStr,username,password);
            System.out.println("CONNECTION SUCCESSFUL!!");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED!! "+ e.getMessage() );
        }

    }

    /**
     * a static method to get the ResultSet object
     * with valid connection by executing query
     * @param query that we want to execute to get the expected resultSet
     * @return ResultSet object that contain the result just in cases needed outside the class
     */
    public static ResultSet runQuery(String query){
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = stmt.executeQuery(query);
                return resultSet;
            } catch (SQLException e) {
                System.out.println("Error while getting resultSet " + e.getMessage());
            }

            return resultSet;
    }

    /**
     * cleaning up the resources
     */
    public static void destroy(){
            try {
                if(resultSet != null) { resultSet.close(); }
                if(stmt != null) { stmt.close(); }
                if(conn != null) { conn.close(); }

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    /**
     * Get the row count of the resultSet
     * @return the row number of the resultset given
     */
    public static int getRowCount(){
        int rowCount = 0;

        try {
            resultSet.last();
            rowCount = resultSet.getRow();
            resultSet.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ROW COUNT "+e.getMessage());
        }

        return rowCount;

    }

    /**
     * Get the column count
     *
     * @return count of column the result set have
     */
    public static int getColumnCount(){

        int columnCount=0;

        try {
            columnCount = resultSet.getMetaData().getColumnCount();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE COUNTING THE COLUMN COUNT "+e.getMessage());
        }

        return columnCount;
    }

    /**
     * a method that return all column names as List<String>
     */
    public static List<String> getAllColumnNames(){
        List<String> columns = new ArrayList<>();

        try {
            for (int i = 1; i <= getColumnCount(); i++) {
                columns.add(resultSet.getMetaData().getColumnName(i));
            }

        } catch (SQLException e) {
            System.out.println("UNABLE TO GET COLUMN NAMES!!" + e.getMessage());
        }

        return columns;
    }

    /**
     * Create a method that return all row data as a List<String>
     * @param rowNum Row number you want to get the data
     * @return the row data as List object
     */
    public static List<String> getRowDataAsList(int rowNum){

        List<String> rowDataList = new ArrayList<>();

        try {
            resultSet.absolute(rowNum);
            for (int i = 1; i <= getColumnCount() ; i++) {
                String cellValue = resultSet.getString(i);
                rowDataList.add(cellValue);
            }
            resultSet.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDataList;
    }

    /**
     * Create a method to return the cell value at certain row certain column
     *
     * @param rowNum row number
     * @param columnNum column number
     * @return Cell value as String
     */
    public static String getCellData(int rowNum, int columnNum){
        if(rowNum>getRowCount()||columnNum>getColumnCount()||rowNum<=0||columnNum<=0){
            throw new RuntimeException("Invalid Data:" +
                    " -> Number of rows:"+ getRowCount()+ "-> Number of columns "+ getColumnCount() );
        }
            String cellData = "";
        try {
            resultSet.absolute(rowNum);
            cellData = resultSet.getString(columnNum);
            resultSet.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ColumnDataAtRow " + e.getMessage());
        }

        return cellData;
    }

    /**
     * Create a method to return the cell value at certain row certain column
     *
     * @param rowNum row number
     * @param columnName column name
     * @return Cell value as String at specified row numeber and column number
     */
    public static String getCellData(int rowNum, String columnName){
        columnName = columnName.toUpperCase();
        if(rowNum>getRowCount()||!getAllColumnNames().contains(columnName) ||rowNum<=0){
            throw new RuntimeException("Invalid Data:" +
                    " -> Number of rows: "+ getRowCount()+ "\t-> Column Names: "+ getAllColumnNames() );
        }
        String cellData = "";
        try {
            resultSet.absolute(rowNum);
            cellData = resultSet.getString(columnName);
            resultSet.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ColumnDataAtRow " + e.getMessage());

        }

        return cellData;
    }

    /**
     * return value of all cells in that column
     *
     * @param columnNum the column number you want to get the list out of
     * @return value of all cells in that column as a List<String>
     */
    public static  List<String> getAllColumnDataAsList(int columnNum){
        List<String> columnDataList = new ArrayList<>();

       /* //keeps going back to beforeFirst because of getCellValue
       for (int rowNum = 1; rowNum < getRowCount() ; rowNum++) {
            columnDataList.add(  getCellValue(rowNum, columnNum)  );
        }*/
        // try catch will be faster as it does not have to go back to before first

        try {
            resultSet.beforeFirst();
            while(resultSet.next()){
                columnDataList.add(resultSet.getString(columnNum));
            }
            resultSet.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ONE COLUMN DATA AS LIST " + e.getMessage() );
        }


        return columnDataList;
    }

    /**
     * return value of all cells in that column
     *
     * @param columnName the column number you want to get the list out of
     * @return value of all cells in that column as a List<String>
     */
    public static  List<String> getAllColumnDataAsList(String columnName){
        List<String> columnDataList = new ArrayList<>();

        try {
            resultSet.beforeFirst();
            while(resultSet.next()){
                columnDataList.add(resultSet.getString(columnName));
            }
            resultSet.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ONE COLUMN DATA AS LIST " + e.getMessage() );
        }
        return columnDataList;
    }

    /**
     * A method that display all the result set data on console
     */
    public static void displayAllData(){

        try {

            for (String each: getAllColumnNames()) {
                System.out.printf("%-25s", each);

            }
            
            System.out.println();
            resultSet.beforeFirst();

            while (resultSet.next()) {

                for (int colNum = 1; colNum <= getColumnCount(); colNum++) {
                    //System.out.print(rs.getString(colNum) + "\t");
                    //  for making it pretty
                    System.out.printf("%-25s", resultSet.getString(colNum));
                }
                System.out.println();
            }
            resultSet.beforeFirst();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE PRINTING WHOLE TABLE " + e.getMessage());
        }
    }

    /**
     * A method that return the row data along with column name as Map object
     * @param rowNum row number you want to get the data
     * @return Map object -- column name as key and cell value as value
     */
    public static Map<String, String> getRowMap(int rowNum){
        Map<String, String> rowMap = new LinkedHashMap<>();

        try {
            resultSet.absolute(rowNum);
            for (int columnNumber = 1; columnNumber <= getColumnCount() ; columnNumber++) {
                    String columnName = resultSet.getMetaData().getColumnLabel(columnNumber);
                    String cellValue = resultSet.getString(columnNumber);
                    rowMap.put(columnName , cellValue);
                }

            resultSet.beforeFirst();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE CREATING getRowDataAsMap " + e.getMessage());
        }


        return rowMap;

    }

    /**
     * Getting entire resultSet data as List of Map object
     *
     * @return List< Map<String,String> > that represent all row data
     */
    public static List<Map<String,String>> getAllDataAsListOfMap(){
        List<Map<String,String>> tableMap = new ArrayList<>();
        for (int rowNum = 1; rowNum <= getRowCount(); rowNum++) {
            tableMap.add(   getRowMap(rowNum)    );
        }

        return tableMap;

    }

    /**
     *
     * @return Getting the first row first column data
     *
     */
    public static String getFirstData(){

        return  getCellData(1,1) ;

    }


}
