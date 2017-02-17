package GuestService;

import Entities.*;
import Model.HibernateUtil;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("Index")
public class IndexResource {

    private static SessionFactory sf = HibernateUtil.getSessionFactory();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of IndexResource
     */
    public IndexResource() {
    }

    //----------------------------------------------
    @GET
    @Produces("application/json")
    @Path("/LayThongTin")
    public byte[] getInitData(@Context HttpServletRequest requestContext) throws JSONException {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("errorCode", "ERROR");
        jsonReturn.put("errorMessages", "L\u1ED7i h\u1EC7 th\u1ED1ng");

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
        String sqlArticle = "select article from " + Tblarticle.class.getName() + " article where article.articleCategoryId = :arcategory order by article.articleId";
        Query query_Article = session.createQuery(sqlArticle);
        query_Article.setParameter("arcategory", 5);
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
        //--------------------
        String sqlHandbook = "select article from " + Tblarticle.class.getName() + " article where article.articleCategoryId = :arhandbook order by article.articleId";
        Query query_Handbook = session.createQuery(sqlHandbook);
        query_Handbook.setParameter("arhandbook", 4);
        query_Handbook.setMaxResults(5);
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
        jsonReturn.put("AlbumCntt", arrAlbumCntt);
        jsonReturn.put("AlbumCk", arrAlbumCk);
        jsonReturn.put("AlbumKt", arrAlbumKT);
        jsonReturn.put("Artile", arrAriticle);
        jsonReturn.put("Handbook", arrHandbook);
        transaction.commit();
        return Base64.base64Encode(jsonReturn.toString().getBytes());
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
