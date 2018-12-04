/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lokesh
 */
public class controller_to_save_information extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String time = request.getParameter("time_elapsed");
            String category = request.getParameter("category");
            String work = request.getParameter("working_on");
            int total_seconds = Integer.parseInt(time) / 10;
            int hours = (total_seconds / 3600);
            int minutes = ((total_seconds / 60) % 60);
            int seconds = total_seconds % 60;
            String time_format = hours + ":" + minutes + ":" + seconds;
            String date = (new java.util.Date()).toLocaleString();
            String date1=date.substring(0,12);
            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "root");

                PreparedStatement psmt = con.prepareStatement("insert into time_information(working_on,category,time,date) values(?,?,?,?)");

                psmt.setString(1, work);
                psmt.setString(2, category);
                psmt.setString(3, time_format);
                psmt.setString(4, date1);

                int s = psmt.executeUpdate();

                if (s > 0) {
                    response.sendRedirect("index.jsp");
                }
                con.close();
                psmt.close();

            } catch (Exception ex) {
                out.println(ex);

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
