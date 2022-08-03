/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LECTURER;

import ADMIN.MysqlConnect;
import com.sun.media.jfxmedia.logging.Logger;
import gnu.io.SerialPort;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.zu.ardulink.*;
import net.proteanit.sql.*;

/**
 *
 * @author STAR
 */
public class TakeAttendance extends javax.swing.JFrame implements RawDataListener{
    SerialPort serialPort;
    public Link link;
    public boolean isSuccessfullyScanned = false;
    private final String SCAN_COMMAND = "2";
    
    public String arduinoID;
    
    
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    /**
     * Creates new form TakeAttendance
     */
    public TakeAttendance() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelMinimize = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonScan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAttendance = new javax.swing.JTable();
        jButtonRefresh = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldRegNo = new javax.swing.JTextField();
        jTextFieldLast = new javax.swing.JTextField();
        jTextFieldFirst = new javax.swing.JTextField();

        jButton4.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(145, 61, 136));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTER");

        jLabelMinimize.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimize.setText("minimize(-)");
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jLabelMinimize)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(58, 83, 155));

        jButtonScan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonScan.setForeground(new java.awt.Color(255, 0, 0));
        jButtonScan.setText("SCAN");
        jButtonScan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonScanActionPerformed(evt);
            }
        });

        jTableAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg.No.", "First Name", "Last Name"
            }
        ));
        jScrollPane1.setViewportView(jTableAttendance);

        jButtonRefresh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonRefresh.setText("REFRESH");
        jButtonRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jButtonBack.setBackground(new java.awt.Color(255, 102, 102));
        jButtonBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonBack.setText("BACK");
        jButtonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reg. No.:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonScan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLast, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonScan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLast, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jTextFieldFirst, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    public void showStudentData(){
             String sql="SELECT  `id`,`reg.no.`,`first_name`,`last_name` FROM `student_details` WHERE `id` LIKE '%"+ arduinoID +"%'";
             try {
                    ps = MysqlConnect.ConnectDB().prepareStatement(sql);
                    rs = ps.executeQuery();
                    if(rs.next()){
                           String RegNo=rs.getString("reg.no.");
                           jTextFieldRegNo.setText(RegNo);
                           String Fname=rs.getString("first_name");
                           jTextFieldFirst.setText(Fname);
                           String Lname=rs.getString("last_name");
                           jTextFieldLast.setText(Lname);
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
    }
    public void showScanData(){
        try{
             String sql="SELECT `reg.no.`, `firstname`, `lastname` FROM `student_records`";
             ps = MysqlConnect.ConnectDB().prepareStatement(sql);
             rs = ps.executeQuery();
             jTableAttendance.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void jButtonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseClicked
        LecturerPanel lp=new LecturerPanel();// TODO add your handling code here:
        lp.setVisible(true);
        lp.pack();
        this.dispose();
    }//GEN-LAST:event_jButtonBackMouseClicked

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        this.setState(JFrame.ICONIFIED);// TODO add your handling code here:
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jButtonScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonScanActionPerformed
        // TODO add your handling code here:
        String fprint="custom message";
        try{
            link = Link.getDefaultInstance();
            link.addRawDataListener(this);
            //1)GET PORT LIST AND TEST IF IT IS EMPTY
            List<String> portList = Link.getDefaultInstance().getPortList(); 
            if (portList != null && portList.size() > 0) {
                String port = portList.get(0);
                System.out.println("Connecting on port: " + port);
                boolean connected = link.connect(port);
                System.out.println("Connected:" + connected);
                Thread.sleep(2000);
                //writeSerial - sends data to serial port. In this case, it will send value 1. To select the enroll process in arduino code.
                link.writeSerial(SCAN_COMMAND);
                //WAIT A SECOND
                Thread.sleep(1000);
                //sendCustomMessage - Ardulink asks arduino to do something. In this case, store the fingerprint with the label is given in the reg.no. field
                link.sendCustomMessage(fprint);
                //DISCONNECT FROM ARDUINO AFTER 10 SECONDS
                Thread.sleep(10000);
                link.disconnect();
                if(isSuccessfullyScanned){
                    JOptionPane.showMessageDialog(null,"Fingerprint Successfully Matched ");
                    showStudentData();
                }else{
                    JOptionPane.showMessageDialog(null,"Error!!Please Scan again ");
                }
            } else {
                System.out.println("No port found!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonScanActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        String ID= arduinoID;// TODO add your handling code here:
        String regno=jTextFieldRegNo.getText();
        String fname=jTextFieldFirst.getText();
        String lname=jTextFieldLast.getText();
        long current_date = System.currentTimeMillis() / 1000L;
        if (ID.equals("")){
                JOptionPane.showMessageDialog(null,"UniqueID not given","Incomplete form",JOptionPane.ERROR_MESSAGE);
            }else if(regno.equals("")){
                JOptionPane.showMessageDialog(null,"Registration Number not given","Incomplete form",JOptionPane.ERROR_MESSAGE);
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"First Name not given","Incomplete form",JOptionPane.ERROR_MESSAGE);
            }else if(lname.equals("")){
                JOptionPane.showMessageDialog(null,"Last Name not given","Incomplete form",JOptionPane.ERROR_MESSAGE);
            }else{
                String sql="INSERT INTO `student_records`(`id`, `reg.no.`, `firstname`, `lastname`, `date`)  VALUES (?,?,?,?,?)";
                try {
                    ps = MysqlConnect.ConnectDB().prepareStatement(sql);
                    ps.setString(1, ID);
                    ps.setString(2, regno);
                    ps.setString(3, fname);
                    ps.setString(4, lname);
                    ps.setString(5, String.valueOf(current_date));
             
                    if (ps.executeUpdate()>0){
                        JOptionPane.showMessageDialog(null, "Student Attendance Stored Successfully");
                    } 
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "error!!");
                }
                showScanData();
            }
    }//GEN-LAST:event_jButtonRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(TakeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonScan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAttendance;
    private javax.swing.JTextField jTextFieldFirst;
    private javax.swing.JTextField jTextFieldLast;
    private javax.swing.JTextField jTextFieldRegNo;
    // End of variables declaration//GEN-END:variables
 @Override
    public void parseInput(String id, int numBytes, int[] message) {
        StringBuilder build = new StringBuilder(numBytes + 1);
        for (int i = 0; i < numBytes; i++) {
            build.append((char) message[i]);
        }
        String msgString = build.toString();
        if (msgString.contains("FINGER-ID")) {
            //success
            isSuccessfullyScanned = true;
            msgString = msgString.substring("FINGER-ID".length());
            arduinoID = msgString;
            
        } else {
            //failure
            isSuccessfullyScanned = false;
        }
    }
}
