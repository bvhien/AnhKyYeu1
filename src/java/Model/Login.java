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
import javax.servlet.http.HttpSession;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author BVHIEN
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        response.setContentType("application/json");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        PrintWriter writer = response.getWriter();
        String type = request.getParameter("type");
        if (type.equals("CheckLogin")) {
            if (session.getAttribute("InfoLogin") != null) {
                JSONObject json = new JSONObject(session.getAttribute("InfoLogin").toString());
                System.out.println("session.getAttribute(\"InfoLogin\"):" + json.toString());
                writer.write(json.toString());
            } else {
                JSONObject json = new JSONObject("{\"Url\":\"Login.jsp\",\"errorCode\":\"ERRORLOGIN\"}");
                writer.write(json.toString());
            }
        } else if (type.equals("CheckThongTin")) {
            String data = request.getParameter("data");
            data = new String(Base64.base64Encode(data.getBytes()));
            @SuppressWarnings("UnusedAssignment")
            JSONObject json = new JSONObject();
            String strjson = ServiceUtils.callService(Constants.fileName + "/Login/CheckThongTin", "POST", data);
            json = new JSONObject(strjson);
            session.setAttribute("InfoLogin", json.toString());
            writer.write(json.toString());
        } else if (type.equals("DangXuat")) {
            session.invalidate();
            JSONObject json = new JSONObject("{\"Url\":\"Login.jsp\",\"errorCode\":\"ERRORLOGIN\"}");
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
