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

public class StudentAccountCreation extends HttpServlet {

    Connection con; PreparedStatement ps;
    
    public void init(){
        try{
            String qr="insert into students values(?,?,?,?,?,'pending')";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/noticedata", "root", "root");
            ps=con.prepareStatement(qr);
        }catch(Exception e){e.printStackTrace();}
    }
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){e.printStackTrace();}
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        
        String uid=request.getParameter("uid");
        String pw=request.getParameter("pw");
        String nm=request.getParameter("name");
        String br=request.getParameter("branch");
        String sem=request.getParameter("sem");
        try{
        
            ps.setString(1, uid);
            ps.setString(2, pw);
            ps.setString(3, nm);
            ps.setString(4, br);
            ps.setInt(5, Integer.parseInt(sem));
            ps.executeUpdate();
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Account Created</h3>");
            out.println("<h4>After Verification Your Account Will Be Activated</h4>");
            out.println("<a href=index.jsp>Home</a><br>");
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
