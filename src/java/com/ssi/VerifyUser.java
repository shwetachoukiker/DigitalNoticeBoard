/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //reading the request coming from client
        String userid=request.getParameter("uid");
        String password=request.getParameter("pw");
        String utype=request.getParameter("utype");
        String save=request.getParameter("save");
        
        //processing the request
        String msg="";
        if(utype.equals("admin")){
            if(userid.equals("admin") && password.equals("indore")){
               response.sendRedirect("adminhome.jsp");
            }else{
                msg="Invalid Admin Account";
            }
        }else if(utype.equals("hod")){
            msg="Trying To Login As HOD";
        }else if(utype.equals("student")){
            msg="Trying To Login As Student";
        }
            
        //provide the response to client
       
        PrintWriter out=response.getWriter();
        out.println("Thanks For Visiting Us");
        out.println("Xyz");
        out.println(msg);
        out.close();
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
