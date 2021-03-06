/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jamil Francisco
 */
public class Rates extends javax.swing.JFrame {

    /**
     * Creates new form Rates
     */
    public Rates() {
        initComponents();
        findUsers();
        jButton1.setVisible(false);
    }
        public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/emd","root","");
            return con; 
        } catch (SQLException ex) {
            Logger.getLogger(equipment_btn.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Not Connected to Datebase");
            return null;
        }
    }
public void add(){
String des=des_txt.getText();
String ratekind = rate_kind.getSelectedItem().toString();
String rate = Rate_txt.getText();

   
      Connection con = getConnection();
          
             try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO `rate` (`description`, `kind_rate`, `rate`) "+"VALUES (?,?,?)");
                ps.setString(1,des);
                ps.setString(2,ratekind);
                ps.setString(3,rate);
              ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "SAVE");
             
            } catch (SQLException ex) {
                Logger.getLogger(equipment_btn.class.getName()).log(Level.SEVERE, null, ex);
                }     
              }
ArrayList<rates_class>Listrate(String ValToSearch){
       ArrayList<rates_class> ratetlist = new ArrayList<>();
       
       Statement st;
       ResultSet rs;
       
       try{
           Connection con = getConnection();
           st = con.createStatement();
           String searchQueary = "SELECT * FROM rate WHERE CONCAT(`id_num`, `description`, `kind_rate`, `rate`)LIKE'%"+ValToSearch+"%'";
           rs = st.executeQuery(searchQueary);
          rates_class user;
           while(rs.next()){
               user = new rates_class(
                       rs.getInt("id_num"),
                       rs.getString("description"),
                       rs.getString("kind_rate"),                      
                       rs.getString("rate")
               );
               ratetlist.add(user);
           }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return ratetlist;   
   }
public void findUsers(){
       ArrayList<rates_class> users = Listrate(jTextField1.getText());  
      DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       model.setRowCount(0);
    Object[] row = new Object[9];
    for(int i =0; i<users.size();i++){
        row[0]=users.get(i).getId_num();
        row[1]=users.get(i).getDescription();
        row[2]=users.get(i).getKind_rate();
        row[3]=users.get(i).getRate();
        model.addRow(row);
    }}
     public void ShowItem(int index){
 IDnum.setText(Integer.toString(Listrate("").get(index).getId_num()));
  des_txt.setText(Listrate("").get(index).getDescription());
  rate_kind.setSelectedItem(Listrate("").get(index).getKind_rate());
  Rate_txt.setText(Listrate("").get(index).getRate());
}
      public void update(){
 String des=des_txt.getText();
String ratekind = rate_kind.getSelectedItem().toString();
String rate = Rate_txt.getText();
int num = Integer.parseInt(IDnum.getText());
             Connection con = getConnection();
              String UpdateQuery =null;
            PreparedStatement ps1 = null;
           
              try {
                    UpdateQuery= "UPDATE `rate` SET `description`=?, `kind_rate`=?, `rate`=? WHERE `rate`.`id_num` = ?;";
                    ps1 = con.prepareStatement(UpdateQuery);                    
                
                    ps1.setString(1,des);
                    ps1.setString(2,ratekind);
                    ps1.setString(3,rate);
                    ps1.setInt(4,num);
                    ps1.executeUpdate();
                JOptionPane.showMessageDialog(null,"Update Complete");
                  
                } catch (SQLException ex) {
                    Logger.getLogger(equipment_btn.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        des_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rate_kind = new javax.swing.JComboBox();
        Rate_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        IDnum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Description:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, 30));

        des_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                des_txtActionPerformed(evt);
            }
        });
        getContentPane().add(des_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 200, 30));

        jLabel2.setText("Rate:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 40, 30));

        rate_kind.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pc", "Km", "Load", "hour", "other" }));
        getContentPane().add(rate_kind, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 200, 30));
        getContentPane().add(Rate_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, 30));

        jLabel3.setText("kind rate:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 173, -1, 30));

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 173, -1, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID no.", "Description", "Kind's of  Rate", "Rate"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 400, 170));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Rate Form"));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 210));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 350, 30));

        jLabel5.setText("Search:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 50, 30));
        getContentPane().add(IDnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 110, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void des_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_des_txtActionPerformed

    }//GEN-LAST:event_des_txtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        add();
         findUsers();
   des_txt.setText("");
rate_kind.setSelectedItem("");
Rate_txt.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      int index = jTable1.getSelectedRow();
        ShowItem(index);
        jButton2.setVisible(false);
        jButton1.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        findUsers();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      update();
          findUsers();
            jButton2.setVisible(true);
            jButton1.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Rates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDnum;
    private javax.swing.JTextField Rate_txt;
    private javax.swing.JTextField des_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox rate_kind;
    // End of variables declaration//GEN-END:variables
}
