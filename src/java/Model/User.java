/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Service.Constants;
import Service.ServiceUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.buf.UDecoder;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "User", urlPatterns = {"/User"})
public class User extends HttpServlet {

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
            throws ServletException, IOException, JSONException {
        JSONObject json = new JSONObject();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String type = request.getParameter("type");
        if (type.equals("LayThongTin")) {
            @SuppressWarnings("UnusedAssignment")
            String strjson = ServiceUtils.callService(Constants.fileName + "/User/LayThongTin", "GET", null);
            json = new JSONObject(ServiceUtils.Decoder(strjson));
            writer.write(json.toString());
        } else if (type.equals("LuuThongTin")) {
            String data = request.getParameter("data");
            String strjson = ServiceUtils.callService(Constants.fileName + "/User/ThemUser", "POST", data);
            System.out.println("jsonnnnnnnnnnn:"+strjson);
            json = new JSONObject(strjson);
            writer.write(json.toString());
        }else if (type.equals("XoaUser")) {
            String data = request.getParameter("data");
            String strjson = ServiceUtils.callService(Constants.fileName + "/User/XoaUser", "POST", data);
            json = new JSONObject(strjson);
            writer.write(json.toString());
        }else if(type.equals("ShowPopupSua")){
            String data = request.getParameter("data");
            String strjson = ServiceUtils.callService(Constants.fileName + "/User/ShowPopupSua", "POST", data);
            json = new JSONObject(ServiceUtils.Decoder(strjson));
            writer.write(json.toString());
        }else if(type.equals("SuaUser")){
            String data = request.getParameter("data");
            String strjson = ServiceUtils.callService(Constants.fileName + "/User/SuaUser", "POST", data);
            json = new JSONObject(strjson);
            writer.write(json.toString());
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
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
