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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gaura
 */
@WebServlet(name = "sorted", urlPatterns = {"/sorted"})
public class sorted extends HttpServlet {
    
String sortedBy="";
List<ServiceResults> temp = new ArrayList<ServiceResults>();    
List<ServiceResults> Servicedata = new ArrayList<ServiceResults>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sortedBy = request.getParameter("sortby");
        //Mysql JDBC Connection
        try{
            Servicedata.clear();
            Class.forName("com.mysql.jdbc.Driver");
            Connection serviceConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/service?characterEncoding=latin1&useConfigs=maxPerformance", "root", "Gaurav2318");
            Statement myquery = serviceConnection.createStatement();
            ResultSet myresult= myquery.executeQuery("select lowest_price,rating,name from providers");
            
            while(myresult.next())
            {
                ServiceResults sr = new ServiceResults();
                sr.setLowest_price(myresult.getString("lowest_price"));
                sr.setRating(myresult.getString("rating"));
                sr.setName(myresult.getString("name"));
                Servicedata.add(sr);
            }
            
            System.out.println("length: "+Servicedata.size());
            //Sorting by price
            if(sortedBy.equals("lowest_price")){
                Collections.sort(Servicedata, new Sortbyprice());
            }
            //sorting by rating
            else
                Collections.sort(Servicedata, new Sortbyrating());
            
            request.setAttribute("data",Servicedata);
            
            RequestDispatcher rd= request.getRequestDispatcher("display.jsp");
            rd.forward(request, response);
            
        }
        catch (Exception e)
        {
        e.printStackTrace();
        }
        
    }     

}


 class Sortbyprice implements Comparator<ServiceResults> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(ServiceResults a, ServiceResults b) 
    { 
       
        return Integer.parseInt(a.getLowest_price()) - Integer.parseInt(b.getLowest_price()); 
    }
 }


 class Sortbyrating implements Comparator<ServiceResults> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(ServiceResults a, ServiceResults b) 
    { 
        
        return Integer.parseInt(a.getRating()) - Integer.parseInt(b.getRating()); 
    }
 }