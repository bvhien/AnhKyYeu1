package Entities;
// Generated Feb 27, 2017 11:51:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tblparameter generated by hbm2java
 */
public class Tblparameter  implements java.io.Serializable {


     private Integer paraId;
     private String paraValue;
     private String paraContent;
     private String paraStatus;
     private String paraCode;
     private Date paraCreatDate;
     private Date paraEditDate;
     private String paraIsdelete;

    public Tblparameter() {
    }

    public Tblparameter(String paraValue, String paraContent, String paraStatus, String paraCode, Date paraCreatDate, Date paraEditDate, String paraIsdelete) {
       this.paraValue = paraValue;
       this.paraContent = paraContent;
       this.paraStatus = paraStatus;
       this.paraCode = paraCode;
       this.paraCreatDate = paraCreatDate;
       this.paraEditDate = paraEditDate;
       this.paraIsdelete = paraIsdelete;
    }
   
    public Integer getParaId() {
        return this.paraId;
    }
    
    public void setParaId(Integer paraId) {
        this.paraId = paraId;
    }
    public String getParaValue() {
        return this.paraValue;
    }
    
    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }
    public String getParaContent() {
        return this.paraContent;
    }
    
    public void setParaContent(String paraContent) {
        this.paraContent = paraContent;
    }
    public String getParaStatus() {
        return this.paraStatus;
    }
    
    public void setParaStatus(String paraStatus) {
        this.paraStatus = paraStatus;
    }
    public String getParaCode() {
        return this.paraCode;
    }
    
    public void setParaCode(String paraCode) {
        this.paraCode = paraCode;
    }
    public Date getParaCreatDate() {
        return this.paraCreatDate;
    }
    
    public void setParaCreatDate(Date paraCreatDate) {
        this.paraCreatDate = paraCreatDate;
    }
    public Date getParaEditDate() {
        return this.paraEditDate;
    }
    
    public void setParaEditDate(Date paraEditDate) {
        this.paraEditDate = paraEditDate;
    }
    public String getParaIsdelete() {
        return this.paraIsdelete;
    }
    
    public void setParaIsdelete(String paraIsdelete) {
        this.paraIsdelete = paraIsdelete;
    }




}


