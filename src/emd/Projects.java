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
public class Projects extends javax.swing.JFrame {

    /**
     * Creates new form Projects
     */
    public Projects() {
        initComponents();
        findUsers();
        Update.setVisible(false);
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
 String id = projectID_txt.getText();
 String code = code_txt.getText();
 String location = location1_txt.getText();
 String name = name_txt.getText();
   
      Connection con = getConnection();
          
             try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO `projects` (`Project ID`, `MSK Project Code`, `location`, `Project Name`) "+"VALUES (?,?,?,?)");
               ps.setString(1, id);
                ps.setString(2,code);
                ps.setString(3,location);
                ps.setString(4,name);
              ps.executeUpdate();
                

                JOptionPane.showMessageDialog(null, "SAVE");
             
            } catch (SQLException ex) {
                Logger.getLogger(equipment_btn.class.getName()).log(Level.SEVERE, null, ex);
                }     
              }
ArrayList<project_class>Listproject(String ValToSearch){
       ArrayList<project_class> projectlist = new ArrayList<>();
       
       Statement st;
       ResultSet rs;
       
       try{
           Connection con = getConnection();
           st = con.createStatement();
           String searchQueary = "SELECT * FROM projects WHERE CONCAT(`id_num`, `Project ID`, `MSK Project Code`, `location`, `Project Name`)LIKE'%"+ValToSearch+"%'";
           rs = st.executeQuery(searchQueary);
          project_class user;
           while(rs.next()){
               user = new project_class(
                       rs.getInt("id_num"),
                       rs.getString("Project ID"),
                       rs.getString("MSK Project Code"),                      
                       rs.getString("location"),
                       rs.getString("Project Name")
               );
                projectlist.add(user);
           }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return projectlist;   
   }
   public void findUsers(){
       ArrayList<project_class> users = Listproject(jTextField1.getText());  
      DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       model.setRowCount(0);
    Object[] row = new Object[9];
    for(int i =0; i<users.size();i++){
        row[0]=users.get(i).getId_num();
        row[1]=users.get(i).getProjectID();
        row[2]=users.get(i).getMSK_ProjectCode();
        row[3]=users.get(i).getLocation();
        row[4]=users.get(i).getProject_Name();
        model.addRow(row);
    }}
     public void ShowItem(int index){
  ID_txt.setText(Integer.toString(Listproject("").get(index).getId_num()));
  projectID_txt.setText(Listproject("").get(index).getProjectID());
  code_txt.setText(Listproject("").get(index).getMSK_ProjectCode());
  location1_txt.setText(Listproject("").get(index).getLocation());
  name_txt.setText(Listproject("").get(index).getProject_Name());
}
     public void update(){
         String id = projectID_txt.getText();
 String code = code_txt.getText();
 String location = location1_txt.getText();
 String name = name_txt.getText();
 int num = Integer.parseInt(ID_txt.getText());
             Connection con = getConnection();
              String UpdateQuery =null;
            PreparedStatement ps1 = null;
           
              try {
                    UpdateQuery= "UPDATE `projects` SET  `Project ID`=?, `MSK Project Code`=?, `location`=?, `Project Name`=? WHERE `projects`.`id_num` = ?;";
                    ps1 = con.prepareStatement(UpdateQuery);                    
                
                    ps1.setString(1,id);
                    ps1.setString(2,code);
                    ps1.setString(3,location);
                    ps1.setString(4,name);
                    ps1.setInt(5,num);
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

        jButton1 = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        code_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        location1_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        projectID_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ID_txt = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 40));

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 100, 40));

        jLabel6.setText("Project Name:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 80, 30));
        getContentPane().add(name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 30));

        jLabel2.setText("MSK Project Code:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));
        getContentPane().add(code_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 140, 30));

        jLabel3.setText("Location");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 30));
        getContentPane().add(location1_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 140, 30));

        jLabel7.setText("Project ID:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 30));
        getContentPane().add(projectID_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, 30));

        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Project"));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 270));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID no.", "Project ID", "MSK Project", "Location", "Project Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 590, 200));
        getContentPane().add(ID_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 110, 40));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 400, 40));

        jLabel1.setText("Search:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 50, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     add();
     findUsers();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
update();
   findUsers();
     Update.setVisible(false);
       jButton1.setVisible(true);
    }//GEN-LAST:event_UpdateActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        findUsers();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
           int index = jTable1.getSelectedRow();
        ShowItem(index);
          jButton1.setVisible(true);
           Update.setVisible(true);
           jButton1.setVisible(false);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Projects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Projects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Projects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Projects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Projects().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID_txt;
    private javax.swing.JButton Update;
    private javax.swing.JTextField code_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField location1_txt;
    private javax.swing.JTextField name_txt;
    private javax.swing.JTextField projectID_txt;
    // End of variables declaration//GEN-END:variables
}
