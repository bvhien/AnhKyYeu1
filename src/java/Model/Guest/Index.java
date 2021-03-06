/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Guest;

import Service.Constants;
import Service.ServiceUtils;
import com.mchange.util.Base64Encoder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String type = request.getParameter("type");
        if (type.equals("LayThongTin")) {
            @SuppressWarnings("UnusedAssignment")
            JSONObject json = new JSONObject();
            String strjson = ServiceUtils.callService(Constants.fileName + "/Index/LayThongTin", "GET", null);
            json = new JSONObject(ServiceUtils.Decoder(strjson));
            writer.write(json.toString());
        } else if (type.equalsIgnoreCase("LayThongTinAlbum")) {
            @SuppressWarnings("UnusedAssignment")
            JSONObject json = new JSONObject();
            String strjson = ServiceUtils.callService(Constants.fileName + "/Index/LayThongTinAlbum", "GET", null);
            json = new JSONObject(ServiceUtils.Decoder(strjson));
            writer.write(json.toString());
        } else if (type.equalsIgnoreCase("LayThongTinImage")) {
            @SuppressWarnings("UnusedAssignment")
            String data = request.getParameter("data");
            JSONObject json = new JSONObject();
            String strjson = ServiceUtils.callService(Constants.fileName + "/Index/LayThongTinImage/", "POST", data);
            json = new JSONObject(ServiceUtils.Decoder(strjson));
            writer.write(json.toString());
        } else if (type.equalsIgnoreCase("LayThongTinArticle")) {
            @SuppressWarnings("UnusedAssignment")
            String data = request.getParameter("data");
            JSONObject json = new JSONObject();
            String strjson = ServiceUtils.callService(Constants.fileName + "/Index/LayThongTinArticle/", "POST", data);
            json = new JSONObject(ServiceUtils.Decoder(strjson));
            writer.write(json.toString());
        } else if (type.equalsIgnoreCase("LayDanhSachArticle")) {
            @SuppressWarnings("UnusedAssignment")
            String data = request.getParameter("data");
            JSONObject json = new JSONObject();
            String strjson = ServiceUtils.callService(Constants.fileName + "/Index/LayDanhSachArticle/", "POST", data);
            json = new JSONObject(ServiceUtils.Decoder(strjson));
            writer.write(json.toString());
        }else if(type.equalsIgnoreCase("Search")){
            @SuppressWarnings("UnusedAssignment")
            String data = request.getParameter("data");
            JSONObject json = new JSONObject();
            String strjson = ServiceUtils.callService(Constants.fileName + "/Index/Search/", "POST", data);
            json = new JSONObject(ServiceUtils.Decoder(strjson));
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
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
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
