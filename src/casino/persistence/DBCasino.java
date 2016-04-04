/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino.persistence;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Machine;
import logic.Users;

/**
 *
 * @author Usuario
 */
public class DBCasino {

    private Connection connection;  // Database connection
    private Statement statment;     // SQL statement
    private ResultSet resultSet;    // Rsult set

//    private final String dbFilename = "C:\\Users\\johnleandro\\Documents\\NetBeansProjects\\14-03-16--1,58amCasino DB\\src\\Casino\\persistence\\CasinoDB.accdb";

    /**
     * Default constructor
     */
    public DBCasino() {
        
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatment() {
        return statment;
    }

    public void setStatment(Statement statment) {
        this.statment = statment;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * connected = true, not connected = false
     *
     * @param dbFilename
     * @return
     */
    public boolean connectMSAcces(String dbFilename) {
        boolean connected = false;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            this.setConnection(DriverManager.getConnection("jdbc:ucanaccess://" + dbFilename));
            connected = true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBCasino.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connected;
    }

    
    
  
    /**
     * Query data
     *
     * @param query
     * @return true =succesfull
     */
    public boolean execute(String query) {
        boolean result = false;
        try {
            this.setStatment(this.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            this.getStatment().execute(query);
            this.setResultSet(this.getStatment().getResultSet());
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBCasino.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return result;
    }
    
    
    
}
