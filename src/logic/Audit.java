
package logic;

import java.util.Date;

/**
 *
 * @author johnleandro
 */
public class Audit {
    private  long idProcess;
    private int operation;
    private Date dateAudit;
    private String userName;

    public Audit() {
    }

    /**
     * 
     * @param idProcess
     * @param operation
     * @param dateAudit
     * @param userName 
     */
    public Audit(long idProcess, int operation, Date dateAudit, String userName) {
        this.idProcess = idProcess;
        this.operation = operation;
        this.dateAudit = dateAudit;
        this.userName = userName;
    }

    public long getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(long idProcess) {
        this.idProcess = idProcess;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Date getDateAudit() {
        return dateAudit;
    }

    public void setDateAudit(Date dateAudit) {
        this.dateAudit = dateAudit;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
    
    
}
