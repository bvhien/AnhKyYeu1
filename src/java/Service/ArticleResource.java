/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.*;
import static Service.ThamSoResource.sdf;
import java.text.SimpleDateFormat;
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
            String SqlArticle = "select article.articleId,article.articleTitle,article.articleSummary,\n"
                    + "(select se.sectionName from "+Tblsection.class.getName()+" as se where se.sectionId = article.articleSectionId ) as sectionName,\n"
                    + "(select para.paraContent from "+Tblparameter.class.getName()+" as para where para.paraCode = article.articleStatus and para.paraValue ='TRANG_THAI' and para.paraStatus ='1') as articleStatus \n"
                    + "from "+Tblarticle.class.getName()+" as article";
            Query query_tblArticle = session.createQuery(SqlArticle);
//            Query query = getEntityManager().createNativeQuery("select * from XXXX where login like :login COLLATE latin1_general_cs;", Authentication.class);
            List<Object[]> listArticle = query_tblArticle.list();
            JSONArray arrArticle = new JSONArray();
            try {
                for (Object[] article : listArticle) {
                    JSONObject jsonArticle = new JSONObject();
                    jsonArticle.put("articleId", article[0]);
                    jsonArticle.put("articleTitle", article[1]);
                    jsonArticle.put("articleSummary", article[2]);
                    jsonArticle.put("sectionName", article[3]);
                    jsonArticle.put("articleStatus", article[4]);
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
}
