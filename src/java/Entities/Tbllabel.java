package Entities;
// Generated Feb 27, 2017 11:51:07 PM by Hibernate Tools 4.3.1



/**
 * Tbllabel generated by hbm2java
 */
public class Tbllabel  implements java.io.Serializable {


     private Integer labelId;
     private String labelTitle;
     private String labelInfors;
     private String labelInforsEn;
     private String labelNotes;

    public Tbllabel() {
    }

    public Tbllabel(String labelTitle, String labelInfors, String labelInforsEn, String labelNotes) {
       this.labelTitle = labelTitle;
       this.labelInfors = labelInfors;
       this.labelInforsEn = labelInforsEn;
       this.labelNotes = labelNotes;
    }
   
    public Integer getLabelId() {
        return this.labelId;
    }
    
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }
    public String getLabelTitle() {
        return this.labelTitle;
    }
    
    public void setLabelTitle(String labelTitle) {
        this.labelTitle = labelTitle;
    }
    public String getLabelInfors() {
        return this.labelInfors;
    }
    
    public void setLabelInfors(String labelInfors) {
        this.labelInfors = labelInfors;
    }
    public String getLabelInforsEn() {
        return this.labelInforsEn;
    }
    
    public void setLabelInforsEn(String labelInforsEn) {
        this.labelInforsEn = labelInforsEn;
    }
    public String getLabelNotes() {
        return this.labelNotes;
    }
    
    public void setLabelNotes(String labelNotes) {
        this.labelNotes = labelNotes;
    }




}


