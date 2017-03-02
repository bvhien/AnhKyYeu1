package Entities;
// Generated Feb 27, 2017 11:51:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tblalbum generated by hbm2java
 */
public class Tblalbum  implements java.io.Serializable {


     private Integer albumId;
     private String albumTitle;
     private String albumImage;
     private Integer albumCategoryId;
     private Integer albumSectionId;
     private Integer albumVisited;
     private Integer albumOrderNo;
     private String albumStatus;
     private Date albumCreatDate;
     private Date albumEditDate;
     private String albumNotes;

    public Tblalbum() {
    }

    public Tblalbum(String albumTitle, String albumImage, Integer albumCategoryId, Integer albumSectionId, Integer albumVisited, Integer albumOrderNo, String albumStatus, Date albumCreatDate, Date albumEditDate, String albumNotes) {
       this.albumTitle = albumTitle;
       this.albumImage = albumImage;
       this.albumCategoryId = albumCategoryId;
       this.albumSectionId = albumSectionId;
       this.albumVisited = albumVisited;
       this.albumOrderNo = albumOrderNo;
       this.albumStatus = albumStatus;
       this.albumCreatDate = albumCreatDate;
       this.albumEditDate = albumEditDate;
       this.albumNotes = albumNotes;
    }
   
    public Integer getAlbumId() {
        return this.albumId;
    }
    
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }
    public String getAlbumTitle() {
        return this.albumTitle;
    }
    
    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
    public String getAlbumImage() {
        return this.albumImage;
    }
    
    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }
    public Integer getAlbumCategoryId() {
        return this.albumCategoryId;
    }
    
    public void setAlbumCategoryId(Integer albumCategoryId) {
        this.albumCategoryId = albumCategoryId;
    }
    public Integer getAlbumSectionId() {
        return this.albumSectionId;
    }
    
    public void setAlbumSectionId(Integer albumSectionId) {
        this.albumSectionId = albumSectionId;
    }
    public Integer getAlbumVisited() {
        return this.albumVisited;
    }
    
    public void setAlbumVisited(Integer albumVisited) {
        this.albumVisited = albumVisited;
    }
    public Integer getAlbumOrderNo() {
        return this.albumOrderNo;
    }
    
    public void setAlbumOrderNo(Integer albumOrderNo) {
        this.albumOrderNo = albumOrderNo;
    }
    public String getAlbumStatus() {
        return this.albumStatus;
    }
    
    public void setAlbumStatus(String albumStatus) {
        this.albumStatus = albumStatus;
    }
    public Date getAlbumCreatDate() {
        return this.albumCreatDate;
    }
    
    public void setAlbumCreatDate(Date albumCreatDate) {
        this.albumCreatDate = albumCreatDate;
    }
    public Date getAlbumEditDate() {
        return this.albumEditDate;
    }
    
    public void setAlbumEditDate(Date albumEditDate) {
        this.albumEditDate = albumEditDate;
    }
    public String getAlbumNotes() {
        return this.albumNotes;
    }
    
    public void setAlbumNotes(String albumNotes) {
        this.albumNotes = albumNotes;
    }




}


