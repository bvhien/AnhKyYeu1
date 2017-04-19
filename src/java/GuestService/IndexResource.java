package GuestService;

import Entities.*;
import Model.HibernateUtil;
import Service.Constants;
import Service.ServiceUtils;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

@Path("Index")
public class IndexResource {

    private static SessionFactory sf;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of IndexResource
     */
    public IndexResource() {
    }

    //----------------------------------------------
    @GET
    @Path("/LayThongTin")
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String getInitData(@Context HttpServletRequest requestContext) throws JSONException {

        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");

        //-----------------
        String sqlAlbumTH = "select album from " + Tblalbum.class.getName() + " album  order by album.albumId";
        Query query_AlbumTH = session.createQuery(sqlAlbumTH);
        query_AlbumTH.setMaxResults(5);
        List<Tblalbum> albumTH = query_AlbumTH.list();
        JSONArray arrAlbumTH = new JSONArray();
        for (Tblalbum al : albumTH) {
            JSONObject jsonAlbumTH = new JSONObject();
            jsonAlbumTH.put("AlbumTitle", al.getAlbumTitle());
            jsonAlbumTH.put("AlbumId", al.getAlbumId());
            jsonAlbumTH.put("AlbumImage", al.getAlbumImage());
            arrAlbumTH.put(jsonAlbumTH);
        }

        //-----------------
        String sqlAlbumCNTT = "select album from " + Tblalbum.class.getName() + " album where album.albumCategoryId = :cntt order by album.albumId";
        Query query_AlbumCNTT = session.createQuery(sqlAlbumCNTT);
        query_AlbumCNTT.setParameter("cntt", 1);
        query_AlbumCNTT.setMaxResults(5);
        List<Tblalbum> albumcntt = query_AlbumCNTT.list();
        JSONArray arrAlbumCntt = new JSONArray();
        for (Tblalbum al : albumcntt) {
            JSONObject jsonAlbumCntt = new JSONObject();
            jsonAlbumCntt.put("AlbumTitle", al.getAlbumTitle());
            jsonAlbumCntt.put("AlbumId", al.getAlbumId());
            jsonAlbumCntt.put("AlbumImage", al.getAlbumImage());
            arrAlbumCntt.put(jsonAlbumCntt);
        }

        //---------------
        String sqlAlbumCK = "select album from " + Tblalbum.class.getName() + " album where album.albumCategoryId = :idck order by album.albumId";
        Query query_AlbumCK = session.createQuery(sqlAlbumCK);
        query_AlbumCK.setParameter("idck", 2);
        query_AlbumCK.setMaxResults(5);
        List<Tblalbum> albumck = query_AlbumCK.list();
        JSONArray arrAlbumCk = new JSONArray();
        for (Tblalbum al : albumck) {
            JSONObject jsonAlbumCk = new JSONObject();
            jsonAlbumCk.put("AlbumTitle", al.getAlbumTitle());
            jsonAlbumCk.put("AlbumId", al.getAlbumId());
            jsonAlbumCk.put("AlbumImage", al.getAlbumImage());
            arrAlbumCk.put(jsonAlbumCk);
        }
        //---------------
        String sqlAlbumKT = "select album from " + Tblalbum.class.getName() + " album where album.albumCategoryId = :idkt order by album.albumId";
        Query query_AlbumKT = session.createQuery(sqlAlbumKT);
        query_AlbumKT.setParameter("idkt", 3);
        query_AlbumKT.setMaxResults(5);
        List<Tblalbum> albumkt = query_AlbumKT.list();
        JSONArray arrAlbumKT = new JSONArray();
        for (Tblalbum al : albumkt) {
            JSONObject jsonAlbumKT = new JSONObject();
            jsonAlbumKT.put("AlbumTitle", al.getAlbumTitle());
            jsonAlbumKT.put("AlbumId", al.getAlbumId());
            jsonAlbumKT.put("AlbumImage", al.getAlbumImage());
            arrAlbumKT.put(jsonAlbumKT);
        }
        //----------------
        String sqlArticle = "select article from " + Tblarticle.class.getName() + " article where article.articleSectionId = :arcategory order by article.articleId";
        Query query_Article = session.createQuery(sqlArticle);
        query_Article.setParameter("arcategory", 15);
        query_Article.setMaxResults(5);
        List<Tblarticle> article = query_Article.list();
        JSONArray arrAriticle = new JSONArray();
        for (Tblarticle ar : article) {
            JSONObject jsonArticle = new JSONObject();
            jsonArticle.put("ArticleId", ar.getArticleId());
            jsonArticle.put("ArticleImage", ar.getArticleImage());
            jsonArticle.put("ArticleTitle", ar.getArticleTitle());
            arrAriticle.put(jsonArticle);
        }

        Query queryArticleVisited = session.createQuery("select article from " + Tblarticle.class.getName() + " article order by article.articleVisited DESC ");
        queryArticleVisited.setMaxResults(6);
        List<Tblarticle> articleVisited = queryArticleVisited.list();
        JSONArray arrArticleVisited = new JSONArray();
        for (Tblarticle articlevisited : articleVisited) {
            JSONObject jsonArticleVisited = new JSONObject();
            jsonArticleVisited.put("ArticleId", articlevisited.getArticleId());
            jsonArticleVisited.put("ArticleImage", articlevisited.getArticleImage());
            jsonArticleVisited.put("ArticleTitle", articlevisited.getArticleTitle());
            arrArticleVisited.put(jsonArticleVisited);
        }
        //--------------------
        String sqlHandbook = "select article from " + Tblarticle.class.getName() + " article where article.articleSectionId = :arhandbook order by article.articleId";
        Query query_Handbook = session.createQuery(sqlHandbook);
        query_Handbook.setParameter("arhandbook", 14);
        query_Handbook.setMaxResults(3);
        List<Tblarticle> handbook = query_Handbook.list();
        JSONArray arrHandbook = new JSONArray();
        for (Tblarticle ar : handbook) {
            JSONObject jsonHandbook = new JSONObject();
            jsonHandbook.put("ArticleId", ar.getArticleId());
            jsonHandbook.put("ArticleImage", ar.getArticleImage());
            jsonHandbook.put("ArticleTitle", ar.getArticleTitle());
            arrHandbook.put(jsonHandbook);
        }
        //------------------
        jsonReturn.put("errorCode", "SUCCESS");
        jsonReturn.put("errorMessages", "Thanh Cong");
        jsonReturn.put("AlbumTH", arrAlbumTH);
        jsonReturn.put("AlbumCntt", arrAlbumCntt);
        jsonReturn.put("AlbumCk", arrAlbumCk);
        jsonReturn.put("AlbumKt", arrAlbumKT);
        jsonReturn.put("Artile", arrAriticle);
        jsonReturn.put("Handbook", arrHandbook);
        jsonReturn.put("ArticleVisited", arrArticleVisited);
        return ServiceUtils.Encoder(jsonReturn.toString());
    }
//Lay thong tin Album

    @GET
    @Path("/LayThongTinAlbum")
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String LayThongTinAlbum(@Context HttpServletRequest requestContext) throws JSONException {

        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");

        //-----------------
        String sqlAlbumTH = "select album from " + Tblalbum.class.getName() + " album  order by album.albumId";
        Query query_AlbumTH = session.createQuery(sqlAlbumTH);
        List<Tblalbum> albumTH = query_AlbumTH.list();
        JSONArray arrAlbumTH = new JSONArray();
        for (Tblalbum al : albumTH) {
            JSONObject jsonAlbumTH = new JSONObject();
            jsonAlbumTH.put("AlbumTitle", al.getAlbumTitle());
            jsonAlbumTH.put("AlbumId", al.getAlbumId());
            jsonAlbumTH.put("AlbumImage", al.getAlbumImage());
            arrAlbumTH.put(jsonAlbumTH);
        }
        //------------------
        jsonReturn.put("errorCode", "SUCCESS");
        jsonReturn.put("errorMessages", "Thanh Cong");
        jsonReturn.put("ListAlbum", arrAlbumTH);
        return ServiceUtils.Encoder(jsonReturn.toString());
    }

//=======Lay danh sach Image
    @Path("/LayThongTinImage")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String LayThongTinImage(@Context HttpServletRequest requestContext, String strdata) throws JSONException, UnsupportedEncodingException, IOException {
        requestContext.setCharacterEncoding("UTF-8");
        System.out.println("strData:" + strdata);
//        String data = ServiceUtils.Decoder(strdata);
//        JSONObject json = new JSONObject(data);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        String Sqlalbum = "select album from " + Tblalbum.class.getName() + " album where album.albumId = " + strdata + "";
        Query query_tblAlbum = session.createQuery(Sqlalbum);
        List<Tblalbum> listAlbum = query_tblAlbum.list();
        JSONArray arrAlbum = new JSONArray();
        try {
            for (Tblalbum al : listAlbum) {
                JSONObject jsonAlbum = new JSONObject();
                jsonAlbum.put("articleName", al.getAlbumTitle());
                arrAlbum.put(jsonAlbum);
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        String SqlImage = "select image from " + Tblimage.class.getName() + " image where imageAlbumId = " + strdata + "";
        Query query_tblImage = session.createQuery(SqlImage);
        List<Tblimage> listImage = query_tblImage.list();
        JSONArray arrImage = new JSONArray();
        try {
            for (Tblimage image : listImage) {
                JSONObject jsonImage = new JSONObject();
                jsonImage.put("ImageUrl", image.getImageUrl());
                arrImage.put(jsonImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        jsonReturn.put("errorCode", "SUCCESS");
        jsonReturn.put("errorMessages", "Thanh Cong");
        jsonReturn.put("TitleAlbum", arrAlbum);
        jsonReturn.put("ListImage", arrImage);
        return ServiceUtils.Encoder(jsonReturn.toString());

    }

    //=======Lay chi tiet bai viet
    @Path("/LayThongTinArticle")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String LayThongTinArticle(@Context HttpServletRequest requestContext, String strdata) throws JSONException, UnsupportedEncodingException, IOException {
        requestContext.setCharacterEncoding("UTF-8");
        System.out.println("strData:" + strdata);
//        String data = ServiceUtils.Decoder(strdata);
//        JSONObject json = new JSONObject(data);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        String SqlgetSectionId = "select article from " + Tblarticle.class.getName() + " article where article.articleId = " + strdata + "";
        Query query_getSectionId = session.createQuery(SqlgetSectionId);
        List<Tblarticle> listgetSectionId = query_getSectionId.list();
        JSONArray arrArticle = new JSONArray();
        JSONObject jsonArticle = new JSONObject();
        int SectionId = 0;
        int Article_Visited = 0;
        try {
            Tblarticle getSection = listgetSectionId.get(0);
            SectionId = getSection.getArticleSectionId();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        //Lay ten Section
        if (SectionId > 0) {
            String SqlGetSectionName = "select section from " + Tblsection.class.getName() + " section where section.sectionId = " + SectionId + "";
            Query query_getSectionName = session.createQuery(SqlGetSectionName);
            List<Tblsection> listGetSectionName = query_getSectionName.list();
            try {
                Tblsection getSectionName = listGetSectionName.get(0);
                jsonArticle.put("SectionName", getSectionName.getSectionName());
            } catch (Exception e) {
            }
        }

        String SqlArticle = "select article from " + Tblarticle.class.getName() + " article where article.articleId = " + strdata + "";
        Query query_tblGetArticle = session.createQuery(SqlArticle);
        List<Tblarticle> listGetArticle = query_tblGetArticle.list();
        try {
            Tblarticle article = listGetArticle.get(0);
            jsonArticle.put("ArticleTitle", article.getArticleTitle());
            jsonArticle.put("ArticleSummary", article.getArticleSummary());
            jsonArticle.put("ArticleContent", article.getArticleContent());
            if (article.getArticleVisited() != null) {
                Article_Visited = article.getArticleVisited();
            }
            Article_Visited++;
            arrArticle.put(jsonArticle);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        Query SQLUpdateVisited = session.createQuery("update " + Tblarticle.class.getName() + " set articleVisited = " + Article_Visited + " where articleId = " + strdata + "");
        int rowExe = SQLUpdateVisited.executeUpdate();
        session.getTransaction().commit();
        jsonReturn.put("errorCode", "SUCCESS");
        jsonReturn.put("errorMessages", "Thanh Cong");
        jsonReturn.put("GetArticle", arrArticle);
        return ServiceUtils.Encoder(jsonReturn.toString());

    }

    //=======Lay danh sach Article
    @Path("/LayDanhSachArticle")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String LayDanhSachArticle(@Context HttpServletRequest requestContext, String strdata) throws JSONException, UnsupportedEncodingException, IOException {
        requestContext.setCharacterEncoding("UTF-8");
        System.out.println("strData:" + strdata);
//        String data = ServiceUtils.Decoder(strdata);
//        JSONObject json = new JSONObject(data);
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");

        //Lay ten Section
        String SqlGetSectionName = "select section from " + Tblsection.class.getName() + " section where section.sectionId = " + strdata + "";
        Query query_getSectionName = session.createQuery(SqlGetSectionName);
        List<Tblsection> listGetSectionName = query_getSectionName.list();
        JSONObject jsonSectionName = new JSONObject();
        try {
            Tblsection getSectionName = listGetSectionName.get(0);
            jsonSectionName.put("SectionName", getSectionName.getSectionName());
        } catch (Exception e) {
        }

        String SqlArticle = "select article from " + Tblarticle.class.getName() + " article where article.articleSectionId = " + strdata + "";
        Query query_tblGetArticle = session.createQuery(SqlArticle);
        List<Tblarticle> listGetArticle = query_tblGetArticle.list();
        JSONArray arrArticle = new JSONArray();
        try {
            for (Tblarticle article : listGetArticle) {
                JSONObject jsonArticle = new JSONObject();
                jsonArticle.put("ArticleId", article.getArticleId());
                jsonArticle.put("ArticleTitle", article.getArticleTitle());
                jsonArticle.put("ArticleSummary", article.getArticleSummary());
                jsonArticle.put("ArticleContent", article.getArticleContent());
                jsonArticle.put("ArticleImage", article.getArticleImage());
                arrArticle.put(jsonArticle);
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        jsonReturn.put("errorCode", "SUCCESS");
        jsonReturn.put("errorMessages", "Thanh Cong");
        jsonReturn.put("ListArticleBySection", arrArticle);
        jsonReturn.put("SectionName", jsonSectionName);
        return ServiceUtils.Encoder(jsonReturn.toString());

    }

    
    //Search
    @Path("/Search")
    @POST
    @Consumes("application/json")
    @Produces("application/json;charset=UTF-8")
    public String Search(@Context HttpServletRequest requestContext, String strdata) throws JSONException, UnsupportedEncodingException, IOException {
        requestContext.setCharacterEncoding("UTF-8");
        JSONObject jsonReturn = new JSONObject();
        sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");
        String Sqlalbum = "SELECT * FROM "+Tblalbum.class.getName()+" where UPPER(album_title) like concat(concat('%',UPPER('"+strdata+"')),'%') or UPPER('"+strdata+"') like concat(concat('%',UPPER(album_title)),'%')";
        Query query_tblAlbum = session.createQuery(Sqlalbum);
        List<Tblalbum> listAlbum = query_tblAlbum.list();
        JSONArray arrAlbum = new JSONArray();
        try {
            for (Tblalbum al : listAlbum) {
                JSONObject jsonAlbum = new JSONObject();
                jsonAlbum.put("ResultId", al.getAlbumId());
                jsonAlbum.put("ResultTitle", al.getAlbumTitle());
                arrAlbum.put(jsonAlbum);
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        String SqlImage = "select image from " + Tblimage.class.getName() + " image where imageAlbumId = " + strdata + "";
        Query query_tblImage = session.createQuery(SqlImage);
        List<Tblimage> listImage = query_tblImage.list();
        JSONArray arrImage = new JSONArray();
        try {
            for (Tblimage image : listImage) {
                JSONObject jsonImage = new JSONObject();
                jsonImage.put("ImageUrl", image.getImageUrl());
                arrImage.put(jsonImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        jsonReturn.put("errorCode", "SUCCESS");
        jsonReturn.put("errorMessages", "Thanh Cong");
        jsonReturn.put("TitleAlbum", arrAlbum);
        jsonReturn.put("ListImage", arrImage);
        return ServiceUtils.Encoder(jsonReturn.toString());

    }

    /**
     * Retrieves representation of an instance of GuestService.IndexResource
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
     * PUT method for updating or creating an instance of IndexResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
