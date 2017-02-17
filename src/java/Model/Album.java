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
import org.json.*;

@WebServlet(name = "Album", urlPatterns = {"/Album"})
public class Album extends HttpServlet {

    @SuppressWarnings("null")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JSONException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        PrintWriter writer = response.getWriter();
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        if (type.equals("LayThongTin")) {
            @SuppressWarnings("UnusedAssignment")
            String strjson = ServiceUtils.callService(Constants.fileName + "/Album/GetAlbum", "GET", null);
            System.out.println("strJson:" + strjson);
            json = new JSONObject(ServiceUtils.Decoder(strjson));
            writer.write(json.toString());
        } else if (type.equals("LuuThongTin")) {
            String data = request.getParameter("data");
            String strjson = ServiceUtils.callService(Constants.fileName + "/Album/ThemAlbum", "POST", data);
            json = new JSONObject(strjson);
            writer.write(json.toString());
        }else if(type.equals("CapNhat")){
            String data = request.getParameter("data");
            String strjson = ServiceUtils.callService(Constants.fileName + "/Album/CapNhatAlbum", "POST", data);
            json = new JSONObject(strjson);
            writer.write(json.toString());
        }else if(type.equals("XoaBanGhi")){
            String data = request.getParameter("data");
            String strjson = ServiceUtils.callService(Constants.fileName + "/Album/XoaAlbum", "POST", data);
            json = new JSONObject(strjson);
            writer.write(json.toString());
        }else if (type.equals("XoaNhieuAlbum")) {
            String data = request.getParameter("data");
            @SuppressWarnings("UnusedAssignment")
            String strjson = ServiceUtils.callService(Constants.fileName + "/Album/XoaNhieuAlbum", "POST", data);
            json = new JSONObject(strjson);
            writer.write(json.toString());
        } 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(Album.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(Album.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
