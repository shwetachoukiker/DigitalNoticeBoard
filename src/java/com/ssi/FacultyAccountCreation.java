package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FacultyAccountCreation extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        
        String uid=request.getParameter("uid");
        String pw=request.getParameter("pw");
        String nm=request.getParameter("name");
        String dp=request.getParameter("dept");
        
        String qr="insert into faculties values(?,?,?,?,'activated')";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/noticedata", "root", "root");
            PreparedStatement ps=con.prepareStatement(qr);
            ps.setString(1, uid);
            ps.setString(2, pw);
            ps.setString(3, nm);
            ps.setString(4, dp);
            ps.executeUpdate();
            con.close();
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Account Created</h3>");
            out.println("<a href=adminhome.jsp>Home</a><br>");
            out.println("<a href=HodRegi.jsp>Create-Another</a><br>");
            out.println("</body>");
            out.println("</html>");
                            
        }catch(Exception e){
            out.println(e);
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
