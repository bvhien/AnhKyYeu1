/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.*;
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
@Path("Article")
public class ArticleResource {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SessionFactory sf;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ArticleResource
     */
    public ArticleResource() {
    }

    /**
     * Retrieves representation of an instance of Service.ArticleResource
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
     * PUT method for updating or creating an instance of ArticleResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    @Path("/GetArticle")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public String GetArticle(@Context HttpServletRequest requestContext) throws JSONException {
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select se from " + Tblsection.class.getName() + " se where se.sectionId not in (16)";
        Query query_tblSection = session.createQuery(sql);
        List<Tblsection> tblse = query_tblSection.list();
        JSONArray arrSection = new JSONArray();
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        try {
            for (Tblsection section : tblse) {
                JSONObject jsonSec = new JSONObject();
                jsonSec.put("sectionId", section.getSectionId());
                jsonSec.put("sectionName", section.getSectionName());
                arrSection.put(jsonSec);
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

            //--- Danh sach Bai viet
            String SqlArticle = "select article.articleId,article.articleTitle as Title,article.articleSummary ,\n"
                    + "(select se.sectionName from " + Tblsection.class.getName() + " as se where se.sectionId = article.articleSectionId ) as sectionName,article.articleSectionId,\n"
                    + "article.articleStatus, (select para.paraContent from " + Tblparameter.class.getName() + " as para where para.paraCode = article.articleStatus and para.paraValue ='TRANG_THAI' and para.paraStatus ='1') as articleStatus, \n"
                    + "article.articleContent,article.articleImage,article.articleOrderNo from " + Tblarticle.class.getName() + " as article";
            Query query_tblArticle = session.createQuery(SqlArticle);
            List<Object[]> listArticle = query_tblArticle.list();
            JSONArray arrArticle = new JSONArray();
            try {
                for (Object[] article : listArticle) {
                    JSONObject jsonArticle = new JSONObject();
                    jsonArticle.put("articleId", article[0]);
                    jsonArticle.put("Title", article[1]);
                    jsonArticle.put("Summary", article[2]);
                    jsonArticle.put("sectionName", article[3]);
                    jsonArticle.put("Section", article[4]);
                    jsonArticle.put("Status", article[5]);
                    jsonArticle.put("articleStatus", article[6]);
                    jsonArticle.put("Content", article[7]);
                    jsonArticle.put("Image", article[8]);
                    jsonArticle.put("OrderNo", article[9]);
                    arrArticle.put(jsonArticle);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            jsonReturn.put("section", arrSection);
            jsonReturn.put("TrangThai", arrTrangThai);
            jsonReturn.put("Article", arrArticle);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return ServiceUtils.Encoder(jsonReturn.toString());
    }

    //Thêm mới
    @Path("/ThemArticle")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String ThemArticle(@Context HttpServletRequest requestContext, String strdata) throws JSONException, UnsupportedEncodingException, IOException {
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
        String ImageName = Constants.UploadImage(json.getString("Image"));
        try {
            Tblarticle article = new Tblarticle();
            article.setArticleSectionId(json.has("Section") ? json.getInt("Section") : null);
            article.setArticleImage(ImageName != null ? ImageName : null);
            article.setArticleStatus(json.has("Status") ? json.getString("Status") : null);
            article.setArticleTitle(json.has("Title") ? json.getString("Title") : null);
            article.setArticleContent(json.has("Content") ? json.getString("Content") : null);
            article.setArticleSummary(json.has("Summary") ? json.getString("Summary") : null);
            article.setArticleOrderNo(json.has("OrderNo") ? json.getInt("OrderNo") : null);
            session.save(article);
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();

    }
    
    //Thêm mới
    @Path("/SuaArticle")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String SuaArticle(@Context HttpServletRequest requestContext, String strdata) throws JSONException, UnsupportedEncodingException, IOException {
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
        boolean ImageNameNew = false;
        if (json.has("AnhTieuDeMoi") && json.getString("AnhTieuDeMoi") != null) {
            ImageNameNew = Constants.DeleteImage(json.getString("Image"));
        }
        try {
            Tblarticle article = new Tblarticle();
            article.setArticleId(json.getInt("articleId"));
            article.setArticleSectionId(json.has("Section") ? json.getInt("Section") : null);
            if (ImageNameNew) {
                String ImageName = Constants.UploadImage(json.getString("AnhTieuDeMoi"));
                article.setArticleImage(ImageName != null ? ImageName : null);
            } else {
                article.setArticleImage(json.getString("Image") != null ? json.getString("Image") : null);
            }
            article.setArticleStatus(json.has("Status") ? json.getString("Status") : null);
            article.setArticleTitle(json.has("Title") ? json.getString("Title") : null);
            article.setArticleContent(json.has("Content") ? json.getString("Content") : null);
            article.setArticleSummary(json.has("Summary") ? json.getString("Summary") : null);
            article.setArticleOrderNo(json.has("OrderNo") ? json.getInt("OrderNo") : null);
            session.update(article);
            jsonReturn.put("errorCode", "SUCCESS");
            jsonReturn.put("errorMessages", "Thanh Cong");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return jsonReturn.toString();

    }
    
    @Path("/XoaArticle")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String XoaArticle(@Context HttpServletRequest requestContext, String strJson) throws JSONException, UnsupportedEncodingException {
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
                Tblarticle ar = new Tblarticle();
                if (Constants.DeleteImage(arrjson.getJSONObject(i).getString("Image"))) {
                    ar.setArticleId(arrjson.getJSONObject(i).has("articleId") ? arrjson.getJSONObject(i).getInt("articleId") : null);
                    session.delete(ar);
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
