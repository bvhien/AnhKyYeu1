package Entities;
// Generated Feb 10, 2017 12:03:07 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tbluser generated by hbm2java
 */
public class Tbluser  implements java.io.Serializable {


     private Integer userId;
     private String userName;
     private String userPass;
     private String userFullname;
     private String userBirthday;
     private String userMobilephone;
     private String userHomephone;
     private String userOfficephone;
     private String userEmail;
     private String userAddress;
     private String userJobarea;
     private String userJob;
     private String userPosition;
     private Short userApplyyear;
     private Short userPermission;
     private String userNotes;
     private String userRoles;
     private Integer userLogined;
     private Date userCreatedDate;
     private Date userEditedDate;

    public Tbluser() {
    }

	
    public Tbluser(String userName, String userPass, String userEmail) {
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
    }
    public Tbluser(String userName, String userPass, String userFullname, String userBirthday, String userMobilephone, String userHomephone, String userOfficephone, String userEmail, String userAddress, String userJobarea, String userJob, String userPosition, Short userApplyyear, Short userPermission, String userNotes, String userRoles, Integer userLogined, Date userCreatedDate, Date userEditedDate) {
       this.userName = userName;
       this.userPass = userPass;
       this.userFullname = userFullname;
       this.userBirthday = userBirthday;
       this.userMobilephone = userMobilephone;
       this.userHomephone = userHomephone;
       this.userOfficephone = userOfficephone;
       this.userEmail = userEmail;
       this.userAddress = userAddress;
       this.userJobarea = userJobarea;
       this.userJob = userJob;
       this.userPosition = userPosition;
       this.userApplyyear = userApplyyear;
       this.userPermission = userPermission;
       this.userNotes = userNotes;
       this.userRoles = userRoles;
       this.userLogined = userLogined;
       this.userCreatedDate = userCreatedDate;
       this.userEditedDate = userEditedDate;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPass() {
        return this.userPass;
    }
    
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    public String getUserFullname() {
        return this.userFullname;
    }
    
    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }
    public String getUserBirthday() {
        return this.userBirthday;
    }
    
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }
    public String getUserMobilephone() {
        return this.userMobilephone;
    }
    
    public void setUserMobilephone(String userMobilephone) {
        this.userMobilephone = userMobilephone;
    }
    public String getUserHomephone() {
        return this.userHomephone;
    }
    
    public void setUserHomephone(String userHomephone) {
        this.userHomephone = userHomephone;
    }
    public String getUserOfficephone() {
        return this.userOfficephone;
    }
    
    public void setUserOfficephone(String userOfficephone) {
        this.userOfficephone = userOfficephone;
    }
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserAddress() {
        return this.userAddress;
    }
    
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public String getUserJobarea() {
        return this.userJobarea;
    }
    
    public void setUserJobarea(String userJobarea) {
        this.userJobarea = userJobarea;
    }
    public String getUserJob() {
        return this.userJob;
    }
    
    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }
    public String getUserPosition() {
        return this.userPosition;
    }
    
    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }
    public Short getUserApplyyear() {
        return this.userApplyyear;
    }
    
    public void setUserApplyyear(Short userApplyyear) {
        this.userApplyyear = userApplyyear;
    }
    public Short getUserPermission() {
        return this.userPermission;
    }
    
    public void setUserPermission(Short userPermission) {
        this.userPermission = userPermission;
    }
    public String getUserNotes() {
        return this.userNotes;
    }
    
    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }
    public String getUserRoles() {
        return this.userRoles;
    }
    
    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }
    public Integer getUserLogined() {
        return this.userLogined;
    }
    
    public void setUserLogined(Integer userLogined) {
        this.userLogined = userLogined;
    }
    public Date getUserCreatedDate() {
        return this.userCreatedDate;
    }
    
    public void setUserCreatedDate(Date userCreatedDate) {
        this.userCreatedDate = userCreatedDate;
    }
    public Date getUserEditedDate() {
        return this.userEditedDate;
    }
    
    public void setUserEditedDate(Date userEditedDate) {
        this.userEditedDate = userEditedDate;
    }




}


