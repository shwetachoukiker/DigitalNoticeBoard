package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class SaveNoticeImg extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String title="",msg="";
        byte imgdata[]=null;
        
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        try{
        List<FileItem> items=upload.parseRequest(new ServletRequestContext(request));
        
        for(FileItem item:items){
            String name=item.getFieldName();
            if(name.equals("title")){
                title=item.getString();
            }else if(name.equals("message")){
                msg=item.getString();
            }else if(name.equals("img")){
                imgdata=item.get();
            }
        }
         
        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("hodid");
        java.util.Date dt=new java.util.Date();
        long ts=dt.getTime();
        java.sql.Date postDate=new java.sql.Date(ts);
          Connection con=Connector.connect();
            PreparedStatement ps1=con.prepareStatement("select max(noticeid) from imgnotices");
            ResultSet rs=ps1.executeQuery();
            rs.next();
            int lastId=rs.getInt(1);
            int newId=5001;
            if(lastId!=0){
                newId=lastId+1;
            }
            PreparedStatement ps2=con.prepareStatement("insert into imgnotices values(?,?,?,?,?,?)");
            ps2.setInt(1, newId);
            ps2.setString(2,title);
            ps2.setString(3,msg);
            ps2.setString(4,id);
            ps2.setDate(5, postDate);
            ps2.setBytes(6, imgdata);
            ps2.executeUpdate();
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Notice Posted Successfully</h3>");
            out.println("<h4><a href=postnoticeimg.jsp>Post-More</a></h4>");
            out.println("<h4><a href=facultyhome.jsp>Home</a></h4>");
            con.close();
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
