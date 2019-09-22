package com.topica.edu.itlab.jdbc.tutorial.entity;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionUtils {
	
	 
	  public static Connection getMyConnection() throws SQLException,
	          ClassNotFoundException {
	      // Sử dụng Oracle.
	      // Bạn có thể thay thế bởi Database nào đó.
	      return MySQLConnUtils.getMySQLConnection();
	  }
	 
	  //
	  // Test Connection ...
	  //
	  public static void main(String[] args) throws SQLException,
	          ClassNotFoundException, NoSuchFieldException, SecurityException {
	 
	      System.out.println("Get connection ... ");
	 
	      // Lấy ra đối tượng Connection kết nối vào database.
	      Connection conn = ConnectionUtils.getMyConnection();
	 
	      System.out.println("Get connection " + conn);
	 
	      System.out.println("Done!");
	      
	      Connection connection = ConnectionUtils.getMyConnection();
	      
	      Statement statement = connection.createStatement();
	   
	      String sqlCl = "select * from class";
	      
	      ResultSet rsCl = statement.executeQuery(sqlCl);
	     
	      Class cClazz = ClassEntity.class;
	      Field[] cfields = cClazz.getDeclaredFields();
	      
	      ArrayList<ClassEntity> listClass = new ArrayList<ClassEntity>();
	      
	      
	      while (rsCl.next()) {
	    	  long idClass = rsCl.getLong("id");
	    	  String nameClass = rsCl.getString("name");
	    	  ClassEntity c = new ClassEntity(idClass, nameClass, null);
	    	  listClass.add(c);
	      }
	    	  
	      String sqlSt = "select * from student";
		      
		  ResultSet rsSt = statement.executeQuery(sqlSt);
		      
		  Class sClazz = StudentEntity.class;
		  Field[] sfields = sClazz.getDeclaredFields();
	    	  
		  while (rsSt.next()) {
			  long idStudent = rsSt.getLong("id");
			  String nameStudent = rsSt.getString("name");
			  StudentEntity s = new StudentEntity(idStudent,nameStudent);
			  
		      System.out.println("---------------------");
		   	  System.out.println(s.toString());
		      }
	    	  connection.close();
	  }
	}


