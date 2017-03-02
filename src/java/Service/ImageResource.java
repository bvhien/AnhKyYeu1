/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Tblalbum;
import Entities.Tblcategory;
import Entities.Tblimage;
import Entities.Tblparameter;
import static Service.ThamSoResource.sdf;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
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
@Path("Image")
public class ImageResource {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SessionFactory sf;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ImageResource
     */
    public ImageResource() {
    }

    /**
     * Retrieves representation of an instance of Service.ImageResource
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
     * PUT method for updating or creating an instance of ImageResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    //====Lay Thong tin Khoa va Album
    @Path("/LayThongTin")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public String getInitData(@Context HttpServletRequest requestContext) throws JSONException {
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        JSONObject jsonReturn = new JSONObject();

        //=====Lay danh sach Khoa
        String sqlCategory = "select cate from " + Tblcategory.class.getName() + " cate";
        Query query_tblCategory = session.createQuery(sqlCategory);
        List<Tblcategory> tblcate = query_tblCategory.list();
        JSONArray arrCategory = new JSONArray();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            for (Tblcategory cate : tblcate) {
                JSONObject jsonCate = new JSONObject();
                jsonCate.put("CategoryId", cate.getCategoryId());
                jsonCate.put("CategoryName", cate.getCategoryName());
                arrCategory.put(jsonCate);
            }
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            jsonReturn.put("Category", arrCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceUtils.Encoder(jsonReturn.toString());
    }

    //======Lay danh sach Album
    @Path("/LayDSAlbum/{idCategory}")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public String LayDSAlbum(@Context HttpServletRequest requestContext, @PathParam("idCategory") String idCategory) throws JSONException, UnsupportedEncodingException {
        requestContext.setCharacterEncoding("UTF-8");
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        String sqlAlbum = "select album from " + Tblalbum.class.getName() + " album where album.albumCategoryId = " + idCategory+"and album.albumStatus = '0'";
        Query query_tblAlbum = session.createQuery(sqlAlbum);
        List<Tblalbum> tblalbum = query_tblAlbum.list();
        JSONArray arrAlbum = new JSONArray();
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            for (Tblalbum album : tblalbum) {
                JSONObject jsonAlbum = new JSONObject();
                jsonAlbum.put("AlbumId", album.getAlbumId());
                jsonAlbum.put("AlbumName", album.getAlbumTitle());
                arrAlbum.put(jsonAlbum);
            }
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            jsonReturn.put("Album", arrAlbum);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return ServiceUtils.Encoder(jsonReturn.toString());
    }

    //======Lay Anh theo Album
    @Path("/LuuAnh/{idCategory}/{idAlbum}")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String LuuAnh(@Context HttpServletRequest requestContext, @PathParam("idCategory") String idCategory, @PathParam("idAlbum") String idAlbum, String strdata) throws JSONException, UnsupportedEncodingException, IOException {
        requestContext.setCharacterEncoding("UTF-8");
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Date date = new Date();
        String data = ServiceUtils.Decoder(strdata);
        System.out.println("DataImage:"+data);
        JSONArray arrjson = new JSONArray(data);
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            for (int i = 0; i < arrjson.length(); i++) {
                Tblimage image = new Tblimage();
                image.setImageUrl(Constants.UploadImage(arrjson.getString(i)));
                image.setImageCategoryId(Integer.parseInt(idCategory));
                image.setImageAlbumId(Integer.parseInt(idAlbum));
                image.setImageCreatedDate(date);
                session.save(image);
            }
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();
    }
    
    //======Lay danh sach Image
    @Path("/LayDSImage/{AlbumId}")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public String LayDSImage(@Context HttpServletRequest requestContext, @PathParam("AlbumId") String AlbumId) throws JSONException, UnsupportedEncodingException {
        requestContext.setCharacterEncoding("UTF-8");
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        String sqlImage = "select image from " + Tblimage.class.getName() + " image where image.imageAlbumId = " + AlbumId;
        Query query_tblImage = session.createQuery(sqlImage);
        List<Tblimage> tblimage = query_tblImage.list();
        JSONArray arrImage = new JSONArray();
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            for (Tblimage image : tblimage) {
                JSONObject jsonImage = new JSONObject();
                jsonImage.put("imageId", image.getImageId());
                jsonImage.put("imageUrl", image.getImageUrl());
                arrImage.put(jsonImage);
            }
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            jsonReturn.put("AlbumImage", arrImage);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return (jsonReturn.toString());
    }
    
    //==Xóa 1 bản ghi trong Image
    @Path("/DeleteImage/{imageId}/{imageUrl}")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public String DeleteImage(@Context HttpServletRequest requestContext,@PathParam("imageId") String imageId,@PathParam("imageUrl") String imageUrl) throws JSONException, UnsupportedEncodingException {
        requestContext.setCharacterEncoding("UTF-8");
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            Tblimage image = new Tblimage();
            if (Constants.DeleteImage(imageUrl)) {
                image.setImageId(Integer.parseInt(imageId));
                session.delete(image);
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
}
