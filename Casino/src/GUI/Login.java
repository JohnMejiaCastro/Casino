/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Casino.persistence.DBCasino;
import Casino.persistence.XMLUsers;
import java.awt.Image;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logic.Machine;
import logic.Users;

/**
 *
 * @author johnleandro
 */
public class Login extends javax.swing.JFrame {

    private DBCasino datafile;

    public boolean show = true;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);

        this.datafile = new DBCasino();
        this.datafile.connectMSAcces("C:\\Users\\johnleandro\\Documents\\NetBeansProjects\\14-03-16--1,58amCasino DB\\src\\Casino\\persistence\\CasinoDB.accdb");
//        this.setUserList(dataFile.selectUser());
        this.selectUser();
    }

    public DBCasino getDataFile() {
        return this.datafile;
    }

    private void setDataFile(DBCasino dataFile) {
        this.datafile = dataFile;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panLogin = new javax.swing.JPanel();
        labUser = new javax.swing.JLabel();
        labPassword = new javax.swing.JLabel();
        butLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        butForgetPassword = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtViewPassword = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokerland");

        panLogin.setBackground(new java.awt.Color(0, 102, 102));
        panLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        labUser.setBackground(new java.awt.Color(255, 255, 255));
        labUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labUser.setForeground(new java.awt.Color(255, 255, 255));
        labUser.setText("User");

        labPassword.setBackground(new java.awt.Color(255, 255, 255));
        labPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labPassword.setForeground(new java.awt.Color(255, 255, 255));
        labPassword.setText("Password");

        butLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butLogin.setText("Log In");
        butLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLoginActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/casinoLogo.PNG"))); // NOI18N

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/viewPassword.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        butForgetPassword.setText("¿Olvidaste tu contraseña?");
        butForgetPassword.setBorder(null);
        butForgetPassword.setBorderPainted(false);
        butForgetPassword.setContentAreaFilled(false);
        butForgetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butForgetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butForgetPasswordActionPerformed(evt);
            }
        });

        txtUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtViewPassword.setAlignmentX(0.0F);
        txtViewPassword.setAlignmentY(0.0F);
        txtViewPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtViewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewPasswordActionPerformed(evt);
            }
        });

        txtPassword.setAlignmentX(0.0F);
        txtPassword.setAlignmentY(0.0F);
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout panLoginLayout = new javax.swing.GroupLayout(panLogin);
        panLogin.setLayout(panLoginLayout);
        panLoginLayout.setHorizontalGroup(
            panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLoginLayout.createSequentialGroup()
                .addGroup(panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panLoginLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panLoginLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(butLogin))
                            .addComponent(labPassword)
                            .addGroup(panLoginLayout.createSequentialGroup()
                                .addGroup(panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtViewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(butForgetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labUser))
                    .addGroup(panLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panLoginLayout.setVerticalGroup(
            panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLoginLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labPassword)
                .addGap(1, 1, 1)
                .addGroup(panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(txtViewPassword)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butLogin)
                .addGap(18, 18, 18)
                .addComponent(butForgetPassword)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * you can see or hide the password
     */
    public void viewPass() {
        if (show) {
            txtViewPassword.setVisible(true);
            txtPassword.setVisible(false);
            txtViewPassword.setText(txtPassword.getText());
            show = false;
        } else {
            txtViewPassword.setVisible(false);
            txtPassword.setVisible(true);
            //txtPassword.setText(txtViewPassword.getText());
            show = true;
        }
    }
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        viewPass();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtViewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewPasswordActionPerformed

    private void butLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLoginActionPerformed
        
            //        if ((this.txtViewPassword.getText().equalsIgnoreCase("13579zk")
//                && this.txtUser.getText().equalsIgnoreCase("1049650471"))
//                || (this.txtPassword.getText().equalsIgnoreCase("13579zk")
//                && this.txtUser.getText().equalsIgnoreCase("1049650471"))) {
//
//            MenuManager Wconnect = new MenuManager();
//            Wconnect.setVisible(true);
//            dispose();
//        } else {
//        Users();
//        }
if (this.isPassword(txtUser.getText(), new String(txtPassword.getPassword()))) {
      
            try {
                int level = this.getDataFile().getResultSet().getInt("userType");
                MenuManager mdiForm = new MenuManager(this.getDataFile(),level);
                if (level == 0){
                    MenuManager form = new MenuManager();
                    form.setVisible(true);
                    dispose();
                }else {
                    if (level == 1 ){
                        EmployeeIU form = new EmployeeIU();
                        form.setVisible(true);
                        dispose();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this,
                    "Sorry, Username and password do not match!", "Login",
                    JOptionPane.ERROR_MESSAGE);


        }

    }//GEN-LAST:event_butLoginActionPerformed

    private void butForgetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butForgetPasswordActionPerformed
        JOptionPane.showMessageDialog(this, "Please contact the administrator", "Warning",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_butForgetPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butForgetPassword;
    private javax.swing.JButton butLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labUser;
    private javax.swing.JPanel panLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtViewPassword;
    // End of variables declaration//GEN-END:variables

    /**
     * You get the Users
     */
    public void Users() throws SQLException {

      
//        if ((this.txtViewPassword.getText().equalsIgnoreCase("13579zk")
//                && this.txtUser.getText().equalsIgnoreCase("1049645412"))
//                || (this.txtPassword.getText().equalsIgnoreCase("13579zk")
//                && this.txtUser.getText().equalsIgnoreCase("1049645412"))) {
//            MenuManager Wconnect = new MenuManager();
//            Wconnect.setVisible(true);
//            dispose();
//        } else {
//            
//        }

        
    }

    private void selectUser() {

        String query = "SELECT * FROM user";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    private boolean isPassword(String username, String password)  {
        boolean correct = false;
        
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes(), 0, password.length());
            password = new BigInteger(1, md.digest()).toString(16);
       
            
            if (this.getDataFile().getResultSet() !=null){
                this.getDataFile().getResultSet().beforeFirst();
                while(this.getDataFile().getResultSet().next()){
                    if(this.getDataFile().getResultSet().getString("userCC")
                        .equals(username)){
                        if(this.getDataFile().getResultSet()
                                .getString("password").equals(password)){
                            correct = true;
                        }
                        break;
                    }
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correct;
    }
}
