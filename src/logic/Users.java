/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

/**
 *
 * @author Usuario
 */
public class Users {

    /**
     * Username attribute
     */
    private long userCC;

    /**
     * Type of user
     */
    private int userType;

    /**
     * User password
     */
    private String password;
    /**
     *email user 
     */
    private String email;

    /**
     * Default Constructor
     */
    public Users() {

    }

    /**
     *
     * @param userCC User name
     * @param userType User Type
     * @param password User password
     * @param email User email
     */
    public Users(long userCC, int userType, String password, String email) {
        this.userCC = userCC;
        this.userType = userType;
        this.setPassword(password);
        this.email = email;

    }

    /**
     * Get User CC
     *
     * @return UserCC
     */
    public long getUserCC() {
        return userCC;
    }

    /**
     * Chane UserCC
     *
     * @param userCC
     */
    public void setUserCC(long userCC) {
        this.userCC = userCC;
    }

    /**
     * get user type
     *
     * @return user type
     */
    public int getUserType() {
        return userType;
    }

    /**
     * set user type
     *
     * @param userType user type
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * get user password
     *
     * @return user password
     */
    public String getPassword() {
        return password;
    }
    

    /**
     * set user password
     *
     * @param password user password
     */
    public void setPassword(String password) {
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes(), 0, password.length());
            this.password = new BigInteger(1, md.digest()).toString(16);

        } catch (NoSuchAlgorithmException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }
    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    

}
