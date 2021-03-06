package GUI;

import Casino.persistence.DBCasino;
import Casino.persistence.XMLMachineFile;
import Casino.persistence.XMLReportDay;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import logic.DataDayReport;
import logic.Machine;
import GUI.AddDeleteMachines;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import logic.Users;

/**
 *
 * @author USUARIO
 */
public class EmployeeIU extends javax.swing.JFrame {

    private DBCasino dataFile;
    private int[] machineIndexes;

    
    /**
     * Creates new form EmployeeIU
     */
    public EmployeeIU() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("EMPLOYEE");
        JacquiDate.setVisible(false);
        butInfo.setOpaque(false);
        butInfo.setContentAreaFilled(false);
        butInfo.setBorderPainted(false);
        loadMachineCombo();
        selectMachine();
        this.newInterface();

    }

    public EmployeeIU(DBCasino dataFile) {

        initComponents();
        butInfo.setOpaque(false);
        butInfo.setContentAreaFilled(false);
        butInfo.setBorderPainted(false);
        this.setLocationRelativeTo(null);
        this.setTitle("EMPLOYEE");
        this.dataFile = dataFile;
        JacquiDate.setVisible(false);
        loadMachineCombo();
        selectMachine();

        this.newInterface();
    }
    
    /**
     * get DataFile 
     * @return  dataFile
     */
    public DBCasino getDataFile() {
        return dataFile;
    }
/**
 * set DBCasino
 * @param dataFile DBCasino 
 */
    public void setDataFile(DBCasino dataFile) {
        this.dataFile = dataFile;
    }
/**
 * get the position of the machine
 * @return  machineIndex
 */
    public int[] getMachineIndexes() {
        return machineIndexes;
    }

    /**
     * set the position of the machine
     * @param machineIndexes 
     */
    public void setMachineIndexes(int[] machineIndexes) {
        this.machineIndexes = machineIndexes;
    }

    /**
     * get the position of the machine
     * @param index int 
     * @return  machineIndexs
     */
    public long getMachineIndexes(int index) {
        return this.machineIndexes[index];
    }
/**
 * set the position of the machine
 * @param index int 
 * @param value  machineIndexes
 */
    public void setMachineIndexes(int index, int value) {
        this.machineIndexes[index] = value;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panDataEmployee = new javax.swing.JPanel();
        labPhoto = new javax.swing.JLabel();
        labPokerland = new javax.swing.JLabel();
        butLogOut = new javax.swing.JButton();
        panDataReport = new javax.swing.JPanel();
        labNumberMachine = new javax.swing.JLabel();
        labInCounter = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        labOutCounter = new javax.swing.JLabel();
        txtOut = new javax.swing.JTextField();
        butNew = new javax.swing.JButton();
        JacquiDate = new com.toedter.calendar.JDateChooser();
        jcbNumberMachine = new javax.swing.JComboBox();
        butInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panDataEmployee.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee"));

        labPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/admon.png"))); // NOI18N

        labPokerland.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/LETRAS.PNG"))); // NOI18N

        butLogOut.setBackground(new java.awt.Color(204, 0, 0));
        butLogOut.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        butLogOut.setText("Sign out ");
        butLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panDataEmployeeLayout = new javax.swing.GroupLayout(panDataEmployee);
        panDataEmployee.setLayout(panDataEmployeeLayout);
        panDataEmployeeLayout.setHorizontalGroup(
            panDataEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDataEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labPokerland)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(butLogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labPhoto)
                .addGap(19, 19, 19))
        );
        panDataEmployeeLayout.setVerticalGroup(
            panDataEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDataEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labPhoto)
                    .addComponent(butLogOut))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panDataEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labPokerland, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panDataReport.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labNumberMachine.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labNumberMachine.setText("Number Machine:");

        labInCounter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labInCounter.setText("In Counter:");

        txtInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labOutCounter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labOutCounter.setText("Out Counter:");

        txtOut.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        butNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butNew.setText("New");
        butNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNewActionPerformed(evt);
            }
        });

        jcbNumberMachine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        jcbNumberMachine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbNumberMachineMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panDataReportLayout = new javax.swing.GroupLayout(panDataReport);
        panDataReport.setLayout(panDataReportLayout);
        panDataReportLayout.setHorizontalGroup(
            panDataReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataReportLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panDataReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labInCounter)
                    .addComponent(labOutCounter)
                    .addComponent(labNumberMachine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(panDataReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOut, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(txtInput, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jcbNumberMachine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDataReportLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JacquiDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(butNew)
                .addGap(166, 166, 166))
        );
        panDataReportLayout.setVerticalGroup(
            panDataReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataReportLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panDataReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNumberMachine)
                    .addComponent(jcbNumberMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labInCounter)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labOutCounter)
                    .addComponent(txtOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panDataReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butNew)
                    .addComponent(JacquiDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        butInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/info-16.png"))); // NOI18N
        butInfo.setText("Help");
        butInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(butInfo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panDataReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panDataEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panDataEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panDataReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLogOutActionPerformed
        // TODO add your handling code here:
        Login Wconnect = new Login();
        Wconnect.setVisible(true);
        dispose();
    }//GEN-LAST:event_butLogOutActionPerformed

    private void butNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNewActionPerformed
        if (butNew.getText().equals("New")) {
            this.newView();
        } else if (butNew.getText().equals("Save")) {
            if (this.validateView()) {
                this.insertReportDay();
                butNew.setText("New");
            } else {
                JOptionPane.showMessageDialog(this, "Please, fill the requeried fields",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_butNewActionPerformed

    private void jcbNumberMachineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbNumberMachineMouseClicked

    }//GEN-LAST:event_jcbNumberMachineMouseClicked

    private void butInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butInfoActionPerformed
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\johnleandro\\Documents\\NetBeansProjects\\fullCasino\\Casino\\src\\Docs\\Employee.pdf");
        } catch (IOException ex) {
            Logger.getLogger(EmployeeIU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butInfoActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeIU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JacquiDate;
    private javax.swing.JButton butInfo;
    private javax.swing.JButton butLogOut;
    private javax.swing.JButton butNew;
    private javax.swing.JComboBox jcbNumberMachine;
    private javax.swing.JLabel labInCounter;
    private javax.swing.JLabel labNumberMachine;
    private javax.swing.JLabel labOutCounter;
    private javax.swing.JLabel labPhoto;
    private javax.swing.JLabel labPokerland;
    private javax.swing.JPanel panDataEmployee;
    private javax.swing.JPanel panDataReport;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtOut;
    // End of variables declaration//GEN-END:variables

    /**
     * You prepare the interface to enter a new a item
     */
    private void newInterface() {

        txtInput.setText("");
        txtOut.setText("");
        JacquiDate.setDate(new Date());
        butNew.setText("Save");

    }
    /**
     * obtain the view data and tranfer it to the object 
     * @return  rep
     */
    private DataDayReport view2Object() {

        DataDayReport rep = new DataDayReport();

        rep.setNumberMachine(Integer.parseInt("" + jcbNumberMachine.getSelectedItem()));
        rep.setDayDate(JacquiDate.getDate());
        rep.setMachineInputDayCurrent(Long.parseLong(txtInput.getText()));
        rep.setMachineOutDayCurrent(Long.parseLong(txtOut.getText()));

        return rep;
    }

//    private void object2View(DataDayReport rep) {
//         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//
//        jcbNumberMachine.setSelectedIndex(this.searchMahineIndex(rep.getNumberMachine()));
//
//        txtInput.setText("" + rep.getMachineInputDayCurrent());
//        txtOut.setText("" + rep.getMachineOutDayCurrent());
//        dateFormat.format(rep.getDayDate());
//        JacquiDate.setDate(rep.getDayDate());
//
//    }
//    
    /**
     * You obtain the Number Machine in Jcombobox
     *
     */
    private void newView() {
        jcbNumberMachine.setSelectedIndex(1);
        txtInput.setText("");
        txtOut.setText("");

        butNew.setText("Save");
    }

    /**
 * validate UI
 * @return  validate
 */
    private boolean validateView() {

        boolean validate = !(jcbNumberMachine.getSelectedItem().equals("")
                || txtInput.getText().equals("")
                || txtOut.getText().equals("")
                || (JacquiDate.getDate() == null));
        return validate;
    }

    /**
     * Obtain the view data and tranfer it to the object
     */
    private void selectReport() {
        String query = "SELECT * FROM dateDayReport";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
                this.updateView();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeIU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Select machine from DB
     */
    private void selectMachine() {
        String query = "SELECT * FROM machine";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
                this.updateView();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeIU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * load machine 
     */
    private void loadMachineCombo() {
        jcbNumberMachine.removeAllItems();
        this.setMachineIndexes(new int[this.selectCountMachine()]);

        String query = "SELECT numberMachine FROM machine";
        if (this.getDataFile().execute(query)) {

            try {
                int index = 0;
                while (this.getDataFile().getResultSet().next()) {
                    this.setMachineIndexes(index++, this.getDataFile().getResultSet().getInt("numberMachine"));
                    jcbNumberMachine.addItem(
                            this.getDataFile().getResultSet().getInt("numberMachine"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeIU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
/**
 * select count machine
 * @return count 
 */
    private int selectCountMachine() {
        int count = 0;
        String query = "SELECT count(*) FROM machine";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
                count = this.getDataFile().getResultSet().getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeIU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

//    private void updateView() {
//        
//    }
    /**
     * You obtain data from an object and pass it to the view
     */
    private void updateView() {
        if ((this.getDataFile().getResultSet() == null)
                || (this.selectCountMachine() <= 0)) {
            this.newView();
        } else {
//            this.object2View();
        }
    }

    /**
     * select report day
     */
    private void selectReportDay() {
        String query = "SELECT * FROM dateReportDay";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
                this.updateView();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeIU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
/**
 * serach machine 
 * @param numberMachine int 
 * @return  index 
 */
    private int searchMahineIndex(int numberMachine) {
        int index = 0;
        for (int i = 0; i < this.getMachineIndexes().length; i++) {
            if (numberMachine == this.getMachineIndexes(i)) {
                index = i;
                break;
            }
        }
        return index;
    }
/**
 * insert report day 
 */
    private void insertReportDay() {

        DataDayReport rep = this.view2Object();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String query = "INSERT INTO dateDayReport"
                + "(numberMachine, dayDate, machineInputDayCurrent, machineOutDayCurrent) "
                + "VALUES ("
                + rep.getNumberMachine() + ",#"
                + dateFormat.format(rep.getDayDate()) + "#,"
                + rep.getMachineInputDayCurrent() + ","
                + rep.getMachineOutDayCurrent() + ")";
        if (this.getDataFile().execute(query)) {
            this.selectMachine();
            JOptionPane.showMessageDialog(this, "CORRECT INSERT",
                    "CORREECT", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "ERROR INSERT",
                    "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

}
