package Entities;
// Generated Feb 27, 2017 11:51:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tbllog generated by hbm2java
 */
public class Tbllog  implements java.io.Serializable {


     private Integer logId;
     private String logName;
     private Short logUserPermission;
     private Date logDate;
     private String logUserName;
     private Short logAction;
     private Short logPosition;

    public Tbllog() {
    }

	
    public Tbllog(String logName) {
        this.logName = logName;
    }
    public Tbllog(String logName, Short logUserPermission, Date logDate, String logUserName, Short logAction, Short logPosition) {
       this.logName = logName;
       this.logUserPermission = logUserPermission;
       this.logDate = logDate;
       this.logUserName = logUserName;
       this.logAction = logAction;
       this.logPosition = logPosition;
    }
   
    public Integer getLogId() {
        return this.logId;
    }
    
    public void setLogId(Integer logId) {
        this.logId = logId;
    }
    public String getLogName() {
        return this.logName;
    }
    
    public void setLogName(String logName) {
        this.logName = logName;
    }
    public Short getLogUserPermission() {
        return this.logUserPermission;
    }
    
    public void setLogUserPermission(Short logUserPermission) {
        this.logUserPermission = logUserPermission;
    }
    public Date getLogDate() {
        return this.logDate;
    }
    
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    public String getLogUserName() {
        return this.logUserName;
    }
    
    public void setLogUserName(String logUserName) {
        this.logUserName = logUserName;
    }
    public Short getLogAction() {
        return this.logAction;
    }
    
    public void setLogAction(Short logAction) {
        this.logAction = logAction;
    }
    public Short getLogPosition() {
        return this.logPosition;
    }
    
    public void setLogPosition(Short logPosition) {
        this.logPosition = logPosition;
    }




}


