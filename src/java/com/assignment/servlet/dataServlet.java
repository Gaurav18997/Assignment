package com.assignment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "dataServlet", urlPatterns = {"/dataServlet"})
public class dataServlet extends HttpServlet {
String serviceName="";
List<ServiceResults> Servicedata = new ArrayList<ServiceResults>();// Storing data as POJO    

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Fetching value of query from form
        serviceName = request.getParameter("service");
        System.out.print(serviceName);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection serviceConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/service?characterEncoding=latin1&useConfigs=maxPerformance", "root", "Gaurav2318");
            
            Statement myquery = serviceConnection.createStatement();
            
            ResultSet myresult = myquery.executeQuery("select * from providers where name = \"" + serviceName + "\"");
            
            //If query exists in DB, then fetching all records from DB
            if(myresult.next())
            {
                ServiceResults sr = new ServiceResults();
                sr.setName(myresult.getString("name"));
                sr.setRating(myresult.getString("rating"));
                sr.setMax_speed(myresult.getString("max_speed"));
                sr.setDescription(myresult.getString("description"));
                sr.setContact_no(myresult.getString("contact_no"));
                sr.setEmail(myresult.getString("email"));
                sr.setImage(myresult.getString("image"));
                sr.setUrl(myresult.getString("url"));
                
                Servicedata.add(sr);
            
      }
            //else supplying "Invalid Input" to all fields
            else
            {
            ServiceResults sr = new ServiceResults();
                sr.setName("Invalid Input");
                sr.setRating("Invalid Input");
                sr.setMax_speed("Invalid Input");
                sr.setDescription("Invalid Input");
                sr.setContact_no("Invalid Input");
                sr.setEmail("Invalid Input");
                sr.setImage("Invalid Input");
                sr.setUrl("Invalid Input");
                
                Servicedata.add(sr);
            }
            request.setAttribute("data",Servicedata);
            
            RequestDispatcher rd= request.getRequestDispatcher("displayRecord.jsp");
            rd.forward(request, response);
            
        }
        catch (Exception e)
        {
        e.printStackTrace();
        }
    }

    

}
