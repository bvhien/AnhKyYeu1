package Service;

import Entities.Tblparameter;
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

@Path("ThamSo")
public class ThamSoResource {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SessionFactory sf;
    @Context
    private UriInfo context;

    public ThamSoResource() {
    }

    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

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
        String sql = "select para from " + Tblparameter.class.getName() + " para";
        Query query_tblParameter = session.createQuery(sql);
        List<Tblparameter> tblts = query_tblParameter.list();
        JSONArray arrThamSo = new JSONArray();
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            for (Tblparameter para : tblts) {
                JSONObject jsonPara = new JSONObject();
                jsonPara.put("Id", para.getParaId());
                jsonPara.put("MaThamSo", para.getParaCode());
                jsonPara.put("DienGiai", para.getParaContent());
                jsonPara.put("NgayTao", para.getParaCreatDate() != null ? sdf.format(para.getParaCreatDate()) : null);
                jsonPara.put("NgaySua", para.getParaEditDate() != null ? sdf.format(para.getParaEditDate()) : null);
                jsonPara.put("TrangThai", para.getParaStatus());
                jsonPara.put("TenThamSo", para.getParaValue());
                arrThamSo.put(jsonPara);
            }
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            jsonReturn.put("ThamSo", arrThamSo);
            System.out.println("jsonreturn:" + jsonReturn.toString());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return ServiceUtils.Encoder(jsonReturn.toString());
    }

    @Path("/ThemThamSo")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String create(@Context HttpServletRequest requestContext, String strJson) throws JSONException, UnsupportedEncodingException {
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
            Tblparameter para = new Tblparameter();
            para.setParaCode(json.has("MaThamSo") ? json.getString("MaThamSo") : null);
            para.setParaValue(json.has("TenThamSo") ? json.getString("TenThamSo") : null);
            para.setParaContent(json.has("DienGiai") ? json.getString("DienGiai") : null);
            para.setParaStatus(json.has("TrangThai") ? json.getString("TrangThai") : null);
            para.setParaIsdelete("0");
            para.setParaCreatDate(date);
            session.save(para);
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();
    }

    @Path("/XoaThamSo")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String XoaThamSo(@Context HttpServletRequest requestContext, String strJson) throws JSONException, UnsupportedEncodingException {
        requestContext.setCharacterEncoding("UTF-8");
        strJson = ServiceUtils.Decoder(strJson);
        JSONObject json = new JSONObject(strJson);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Date date = new Date();
        System.out.println("json" + strJson);
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            Tblparameter para = new Tblparameter();
            para.setParaId(json.has("Id") ? json.getInt("Id") : null);
            session.delete(para);
            transaction.commit();
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();
    }

    @Path("/XoaNhieuThamSo")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String XoaNhieuThamSo(@Context HttpServletRequest requestContext, String strJson) throws JSONException, UnsupportedEncodingException {
        requestContext.setCharacterEncoding("UTF-8");
        strJson = ServiceUtils.Decoder(strJson);
        JSONArray arrjson = new JSONArray(strJson);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Date date = new Date();
        System.out.println("json" + strJson);
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            for (int i = 0; i < arrjson.length(); i++) {
                Tblparameter para = new Tblparameter();
                para.setParaId(arrjson.getJSONObject(i).has("Id") ? arrjson.getJSONObject(i).getInt("Id") : null);
                session.delete(para);
            }
            transaction.commit();
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();
    }

    
    //Cập Nhật
    @Path("/CapNhat")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String CapNhat(@Context HttpServletRequest requestContext, String strJson) throws JSONException, UnsupportedEncodingException {
        requestContext.setCharacterEncoding("UTF-8");
        strJson = ServiceUtils.Decoder(strJson);
        System.out.println("strdata:" + strJson);
        JSONObject json = new JSONObject(strJson);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Date date = new Date();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            Tblparameter para = new Tblparameter();
            para.setParaId(json.getInt("Id"));
            para.setParaCode(json.has("MaThamSo") ? json.getString("MaThamSo") : null);
            para.setParaValue(json.has("TenThamSo") ? json.getString("TenThamSo") : null);
            para.setParaContent(json.has("DienGiai") ? json.getString("DienGiai") : null);
            para.setParaStatus(json.has("TrangThai") ? json.getString("TrangThai") : null);
            para.setParaIsdelete("0");
            para.setParaCreatDate(json.has("NgayTao") ? sdf.parse(json.getString("NgayTao")) : null);
            para.setParaEditDate(date);
            session.update(para);
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
