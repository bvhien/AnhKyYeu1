/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.*;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * REST Web Service
 *
 * @author BVHIEN
 */
@Path("Login")
public class LoginResource {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SessionFactory sf;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of Service.LoginResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    @Path("/CheckThongTin")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String CheckThongTin(@Context HttpServletRequest requestContext, String strJson) throws JSONException, UnsupportedEncodingException {
        requestContext.setCharacterEncoding("UTF-8");
        strJson = new String(Base64.base64Decode(strJson.getBytes()));
        JSONObject jsonObject = new JSONObject(strJson);
        System.out.println("JSONLOGIN:"+jsonObject);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        JSONArray arrUser = new JSONArray();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            String sql = "select user from " + Tbluser.class.getName() + " user where user.userName = :userName and user.userPass = :userPass";
            Query query_tblUser = session.createQuery(sql);
            query_tblUser.setParameter("userName", jsonObject.getString("UserName"));
            query_tblUser.setParameter("userPass", Constants.getInstanceMd5(jsonObject.getString("PassWord")));
            List<Tbluser> tbluser = query_tblUser.list();
            System.out.println("tbluser:"+tbluser.isEmpty());
            if (!tbluser.isEmpty()) {
                for (Tbluser user : tbluser) {
                JSONObject jsonUser = new JSONObject();
                jsonUser.put("Id", user.getUserId());
                jsonUser.put("UserName", user.getUserName());
                jsonUser.put("UserFullName", user.getUserFullname());
                arrUser.put(jsonUser);
            }
                jsonReturn.put("errorCode", "SUCCESS");
                jsonReturn.put("errorMessages", "Thanh Cong");
                jsonReturn.put("InfoLogin", arrUser);
            }else{
                jsonReturn.put("errorCode", "ERRORLOGIN");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();
    }
}
