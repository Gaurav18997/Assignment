/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "displayData", urlPatterns = {"/displayData"})
public class displayData extends HttpServlet {
List<ServiceResults> Servicedata = new ArrayList<ServiceResults>(); //TO store data from POJO to a List   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ResultSet myresult=null;
        try{
            new ServiceResults(null,null);
            //Mysql JDBC Connection
            Servicedata.clear();
            Class.forName("com.mysql.jdbc.Driver");
            Connection serviceConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/service?characterEncoding=latin1&useConfigs=maxPerformance", "root", "Gaurav2318");
            
            Statement myquery = serviceConnection.createStatement();
            
            myresult = myquery.executeQuery("select * from providers");
            
            while(myresult.next())
            {
                Servicedata.add(new ServiceResults(myresult.getString("name"),myresult.getString("lowest_price")));               
      }
            request.setAttribute("data",Servicedata);
           
        }
        catch (Exception e)
        {
        e.printStackTrace();
        }
        
        finally{
        if(myresult!=null){
            try{ 
              myresult.close();
            }catch(Exception ex) { /* */ }
        }
        }
        
        
        request.setAttribute("data", Servicedata);
         String strViewPage = "display.jsp";
     RequestDispatcher dispatcher = request.getRequestDispatcher(strViewPage);
         dispatcher.forward(request, response);
      
   }
    }


