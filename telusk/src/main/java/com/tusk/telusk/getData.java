/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tusk.telusk;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;

public class getData extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
      res.setContentType("text/html");
      PrintWriter out = res.getWriter();
      try
      {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/student","root","");
          Statement stmt = con.createStatement();
          ResultSet rs =stmt.executeQuery("select name,age,max(stud_marks) from tbl_student group by city_name");
          String user="";
          while (rs.next())
          {
              user=rs.getString(1)+ " : " +rs.getInt(2)+ " : " +rs.getInt(3)+ " : " +rs.getString(4);
              out.println(user);

          }
          stmt.close();
          con.close();
      }
      catch(Exception e)
      {
          out.println("Error : " +e.getMessage());
      }
      
    }

}




