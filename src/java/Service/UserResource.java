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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import org.apache.tomcat.util.buf.UDecoder;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("User")
public class UserResource {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SessionFactory sf;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of Service.UserResource
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
     * PUT method for updating or creating an instance of UserResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    @Path("/LayThongTin")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public String getInitData(@Context HttpServletRequest requestContext) throws JSONException {
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select user.userId,user.userName,user.userFullname,user.userBirthday,"
                + "user.userMobilephone,user.userEmail,"
                + "(select para.paraContent from " + Tblparameter.class.getName() + " para where para.paraValue = 'PERMISSION' and para.paraStatus = '1' and para.paraCode = user.userPermission) as userPermission,"
                + "(select para.paraContent from " + Tblparameter.class.getName() + " para where para.paraValue = 'TRANG_THAI' and para.paraStatus = '1' and para.paraCode = user.userStatus) as userStatus,"
                + "user.userCreatedDate,user.userEditedDate"
                + " from " + Tbluser.class.getName() + " user";
        Query query_tblUser = session.createQuery(sql);
        List<Object[]> tbluser = query_tblUser.list();
        JSONArray arrUser = new JSONArray();
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            for (Object[] user : tbluser) {
                JSONObject jsonUser = new JSONObject();
                jsonUser.put("Id", user[0]);
                jsonUser.put("UserName", user[1]);
                jsonUser.put("UserFullName", user[2]);
                jsonUser.put("UserBirthday", user[3]);
                jsonUser.put("UserMobilePhone", user[4]);
                jsonUser.put("UserEmail", user[5]);
                jsonUser.put("UserPermission", user[6]);
                jsonUser.put("UserStatus", user[7]);
                jsonUser.put("userCreatedDate", user[8] != null ? sdf.format(user[8]) : null);
                jsonUser.put("userEditedDate", user[9] != null ? sdf.format(user[9]) : null);
                arrUser.put(jsonUser);
            }

            //---------Lấy danh sách trạng thái kích hoạt
            String SqlTrangThai = "select para from " + Tblparameter.class.getName() + " para where para.paraStatus ='1' and para.paraValue = 'TRANG_THAI'";
            Query query_tblParameter = session.createQuery(SqlTrangThai);
            List<Tblparameter> listTrangThai = query_tblParameter.list();
            JSONArray arrTrangThai = new JSONArray();
            try {
                for (Tblparameter para : listTrangThai) {
                    JSONObject jsonPara = new JSONObject();
                    jsonPara.put("MaThamSo", para.getParaCode());
                    jsonPara.put("DienGiai", para.getParaContent());
                    arrTrangThai.put(jsonPara);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            //----Lấy danh sách quyền
            
            String SqlPermiss = "select para from " + Tblparameter.class.getName() + " para where para.paraStatus ='1' and para.paraValue = 'PERMISSION'";
            Query query_tblPermiss = session.createQuery(SqlPermiss);
            List<Tblparameter> listPermiss = query_tblPermiss.list();
            JSONArray arrPermiss = new JSONArray();
            try {
                for (Tblparameter Permiss : listPermiss) {
                    JSONObject jsonPermiss = new JSONObject();
                    jsonPermiss.put("MaThamSo", Permiss.getParaCode());
                    jsonPermiss.put("DienGiai", Permiss.getParaContent());
                    arrPermiss.put(jsonPermiss);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            jsonReturn.put("TableUser", arrUser);
            jsonReturn.put("TrangThai",arrTrangThai);
            jsonReturn.put("Permiss", arrPermiss);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return ServiceUtils.Encoder(jsonReturn.toString());
    }

    //---------Thêm mới User
    @Path("/ThemUser")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String ThemUser(@Context HttpServletRequest requestContext, String strJson) throws JSONException, UnsupportedEncodingException {
        requestContext.setCharacterEncoding("UTF-8");
        String data = ServiceUtils.Decoder(strJson);
        JSONObject json = new JSONObject(data);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Date date = new Date();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            Tbluser user = new Tbluser();
            user.setUserName(json.has("UserName") ? json.getString("UserName") : null);
            user.setUserPass(json.has("UserPass") ? Constants.greatMD5(json.getString("UserPass")) : null);
            user.setUserFullname(json.has("UserFullName") ? json.getString("UserFullName") : null);
            user.setUserBirthday(json.has("UserBirthday") ? json.getString("UserBirthday") : null);
            user.setUserMobilephone(json.has("UserMobilePhone") ? json.get("UserMobilePhone").toString() : null);
            user.setUserEmail(json.has("UserEmail") ? json.getString("UserEmail") : null);
            user.setUserPermission(json.has("UserPermission") ? Short.parseShort(json.getString("UserPermission")) : null);
            user.setUserStatus(json.has("UserStatus") ? json.getString("UserStatus") : null);
            user.setUserCreatedDate(date);
            session.save(user);
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();
    }
}
