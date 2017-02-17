package Service;

import Entities.*;
import Model.HibernateUtil;
import static Service.ThamSoResource.sdf;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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

@Path("Album")
public class AlbumResource {

    private static SessionFactory sf;
    @Context
    private UriInfo context;

    public AlbumResource() {
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

    //----------------------------------------------
    @GET
    @Produces("application/json")
    @Path("/GetAlbum")
    public String getInitData(@Context HttpServletRequest requestContext) throws JSONException {
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select category from " + Tblcategory.class.getName() + " category";
        List<Tblcategory> category = session.createQuery(sql).list();
        JSONArray arrCategory = new JSONArray();
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            for (Tblcategory cate : category) {
                JSONObject jsonCategory = new JSONObject();
                jsonCategory.put("categoryId", cate.getCategoryId());
                jsonCategory.put("categoryName", cate.getCategoryName());
                arrCategory.put(jsonCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //trang thai kich hoat
        String sqlpara = "select para from " + Tblparameter.class.getName() + " para where para.paraStatus ='1' and para.paraValue = 'TRANG_THAI'";
        Query query_tblParameter = session.createQuery(sqlpara);
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
        //-----Danh sach Album--------
        String sqlAlbum = "select album.albumId,album.albumTitle,"
                + "(select para.paraContent from " + Tblparameter.class.getName() + " as para where para.paraCode = album.albumStatus )as albumStatus,"
                + "album.albumImage,album.albumStatus as albumStatus1,"
                + "(select category.categoryName from " + Tblcategory.class.getName() + " as category where category.categoryId = album.albumCategoryId ) as albumCategory,"
                + "album.albumCategoryId as albumCategory1,album.albumNotes,album.albumCreatDate,album.albumEditDate "
                + "from " + Tblalbum.class.getName() + " as album where album.albumStatus ='0'";
        System.out.println("SQL:" + sqlAlbum);
        Query query_tblalbum = session.createQuery(sqlAlbum);
        List<Object[]> listAlbum = query_tblalbum.list();
        JSONArray arrAlbum = new JSONArray();
        try {
            for (Object[] album : listAlbum) {
                JSONObject jsonAlbum = new JSONObject();
                jsonAlbum.put("Id", album[0]);
                jsonAlbum.put("TieuDe", album[1]);
                jsonAlbum.put("TrangThai", album[4]);
                jsonAlbum.put("AnhTieuDe", album[3]);
                jsonAlbum.put("TrangThai1", album[2]);
                jsonAlbum.put("DanhMuc", album[6]);
                jsonAlbum.put("DanhMuc1", album[5]);
                jsonAlbum.put("GhiChu", album[7]);
                jsonAlbum.put("NgayTao", album[8] != null ? sdf.format(album[8]) : null);
                jsonAlbum.put("NgaySua", album[9] != null ? sdf.format(album[9]) : null);
                arrAlbum.put(jsonAlbum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //---------------
        jsonReturn.put("errorCode", "SUCCESS");
        jsonReturn.put("errorMessages", "Thanh Cong");
        jsonReturn.put("Category", arrCategory);
        jsonReturn.put("TrangThai", arrTrangThai);
        jsonReturn.put("TblAlbum", arrAlbum);
        return ServiceUtils.Encoder(jsonReturn.toString());
    }

    //Thêm mới
    @Path("/ThemAlbum")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String ThemAlbum(@Context HttpServletRequest requestContext, String strdata) throws JSONException, UnsupportedEncodingException, IOException {
        requestContext.setCharacterEncoding("UTF-8");
        String data = ServiceUtils.Decoder(strdata);
        JSONObject json = new JSONObject(data);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Date date = new Date();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        System.out.println("json.getString(\"AnhTieuDe\"):" + json.getString("AnhTieuDe"));
        String ImageName = Constants.UploadImage(json.getString("AnhTieuDe"));
        try {
            Tblalbum album = new Tblalbum();
            album.setAlbumCategoryId(json.has("DanhMuc") ? json.getInt("DanhMuc") : null);
            album.setAlbumImage(ImageName != null ? ImageName : null);
            album.setAlbumSectionId(16);
            album.setAlbumTitle(json.has("TieuDe") ? json.getString("TieuDe") : null);
            album.setAlbumStatus(json.has("TrangThai") ? json.getString("TrangThai") : null);
            album.setAlbumCreatDate(date);
            session.save(album);
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();

    }

    //Cập nhật
    @Path("/CapNhatAlbum")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String CapNhatAlbum(@Context HttpServletRequest requestContext, String strdata) throws JSONException, UnsupportedEncodingException, IOException, URISyntaxException {
        requestContext.setCharacterEncoding("UTF-8");
        String data = ServiceUtils.Decoder(strdata);
        JSONObject json = new JSONObject(data);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Date date = new Date();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        System.out.println("json.getString(\"AnhTieuDe\"):" + json.getString("AnhTieuDe"));
        boolean ImageNameNew = false;
        if (json.has("AnhTieuDeMoi") && json.getString("AnhTieuDeMoi") != null) {
            ImageNameNew = Constants.DeleteImage(json.getString("AnhTieuDe"));
        }
        try {
            Tblalbum album = new Tblalbum();
            album.setAlbumId(json.getInt("Id"));
            album.setAlbumCategoryId(json.has("DanhMuc") ? json.getInt("DanhMuc") : null);
            if (ImageNameNew) {
                String ImageName = Constants.UploadImage(json.getString("AnhTieuDeMoi"));
                System.out.println("ImageName:" + ImageName);
                album.setAlbumImage(ImageName != null ? ImageName : null);
            } else {
                album.setAlbumImage(json.getString("AnhTieuDe") != null ? json.getString("AnhTieuDe") : null);
            }
            album.setAlbumSectionId(16);
            album.setAlbumTitle(json.has("TieuDe") ? json.getString("TieuDe") : null);
            album.setAlbumStatus(json.has("TrangThai") ? json.getString("TrangThai") : null);
            album.setAlbumCreatDate(json.has("NgayTao") ? sdf.parse(json.getString("NgayTao")) : null);
            album.setAlbumEditDate(date);
            session.update(album);
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return jsonReturn.toString();

    }

    //==Xóa 1 bản ghi trong Album
    @Path("/XoaAlbum")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String XoaAlbum(@Context HttpServletRequest requestContext, String strJson) throws JSONException, UnsupportedEncodingException {
        requestContext.setCharacterEncoding("UTF-8");
        strJson = ServiceUtils.Decoder(strJson);
        System.out.println("============jsonXoaAlbum:" + strJson);
        JSONObject json = new JSONObject(strJson);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("json" + strJson);
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            Tblalbum al = new Tblalbum();
            if (Constants.DeleteImage(json.getString("AnhTieuDe"))) {
                al.setAlbumId(json.has("Id") ? json.getInt("Id") : null);
                session.delete(al);
                transaction.commit();
                jsonReturn.put("errorCode", "SUCCESS");
                jsonReturn.put("errorMessages", "Thanh Cong");
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();
    }

    @Path("/XoaNhieuAlbum")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String XoaNhieuAlbum(@Context HttpServletRequest requestContext, String strJson) throws JSONException, UnsupportedEncodingException {
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
                Tblalbum al = new Tblalbum();
                if (Constants.DeleteImage(arrjson.getJSONObject(i).getString("AnhTieuDe"))) {
                    al.setAlbumId(arrjson.getJSONObject(i).has("Id") ? arrjson.getJSONObject(i).getInt("Id") : null);
                    session.delete(al);
                }
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
}
