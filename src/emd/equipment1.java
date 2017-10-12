package emd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jamil Francisco
 */
public class equipment1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form equipment1
     */
    public equipment1() {
        initComponents();
         getConnection();
        findUsers();
        jButton1.setVisible(false);
    }
     equipment_btn btn = new equipment_btn();
 public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/emd","root","");
         
            return con; 
        } catch (SQLException ex) {
            Logger.getLogger(equipment1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Not Connected to Datebase");
            return null;
        }
    }
  public void add(){

  String description= description_txt.getText();
   String model =model_txt.getText();
   String kind =kind_cbox.getSelectedItem().toString();
  String code= code_txt.getText();
  int year= Integer.parseInt(year_txt.getText());
  String plateno= Plateno_txt.getText();
  String engine = engine_txt.getText();
  String chassis = chassis_txt.getText();
           btn.saveadd(description,model,kind,code,year,plateno,engine,chassis);
          
description_txt.setText("");
  model_txt.setText("");
   kind_cbox.setSelectedItem(null);
  code_txt.setText("");
 year_txt.setText("");
  Plateno_txt.setText("");
 engine_txt.setText("");
 chassis_txt.setText("");
}
 public void update(){
     
     System.out.println(id_num.getText());
     int id = Integer.parseInt(id_num.getText());

     String description= description_txt.getText();
   String model =model_txt.getText();
   String kind =kind_cbox.getSelectedItem().toString();
  String code= code_txt.getText();
  int year= Integer.parseInt(year_txt.getText());
  String plateno= Plateno_txt.getText();
  String engine = engine_txt.getText();
  String chassis = chassis_txt.getText();
      btn.update(id,description,model,kind,code,year,plateno,engine,chassis);
      description_txt.setText("");
  model_txt.setText("");
 
  code_txt.setText("");
 year_txt.setText("");
  Plateno_txt.setText("");
 engine_txt.setText("");
 chassis_txt.setText("");
  }
   ArrayList<Equipment_class>ListUsers(String ValToSearch){
       ArrayList<Equipment_class> equipmentList = new ArrayList<>();
       
       Statement st;
       ResultSet rs;
       
       try{
           Connection con = getConnection();
           st = con.createStatement();
           String searchQueary = "SELECT * FROM equipment WHERE CONCAT(`id_num`, `description`, `model`, `Equipment_kind`, `Code`, `Year`, `Plate no.`, `Engine No.`, `Chassis`)LIKE'%"+ValToSearch+"%'";
           rs = st.executeQuery(searchQueary);
          Equipment_class user;
           while(rs.next()){
               user = new Equipment_class(
                       rs.getInt("id_num"),
                       rs.getString("description"),
                       rs.getString("model"), 
                       rs.getString("Equipment_kind"),
                        rs.getString("Code"),
                        rs.getInt("Year"), 
                        rs.getString("Plate no."), 
                        rs.getString("Engine No."), 
                        rs.getString("Chassis")
               );
               equipmentList.add(user);
           }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return equipmentList;   
   }
   public void findUsers(){
       ArrayList<Equipment_class> users = ListUsers(jTextField2.getText());  
      DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       model.setRowCount(0);
    Object[] row = new Object[9];
    for(int i =0; i<users.size();i++){
        row[0]=users.get(i).getId_num();
        row[1]=users.get(i).getDescription();
        row[2]=users.get(i).getModel();
        row[3]=users.get(i).getEquipment_kind();
        row[4]=users.get(i).getCode();
        row[5]=users.get(i).getYear();
        row[6]=users.get(i).getPlate_no();
        row[7]=users.get(i).getEngine_No();
        row[8]=users.get(i).getChassis();
       
        model.addRow(row);
    }}
    public void ShowItem(int index){
   id_num.setText(Integer.toString(ListUsers("").get(index).getId_num()));
   description_txt.setText(ListUsers("").get(index).getDescription());
   model_txt.setText(ListUsers("").get(index).getModel());
   code_txt.setText(ListUsers("").get(index).getCode());
   year_txt.setText(Integer.toString(ListUsers("").get(index).getYear()));
   Plateno_txt.setText(ListUsers("").get(index).getPlate_no());
   engine_txt.setText(ListUsers("").get(index).getEngine_No());
   chassis_txt.setText(ListUsers("").get(index).getChassis());
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        model_txt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        year_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        kind_cbox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        description_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chassis_txt = new javax.swing.JTextField();
        Plateno_txt = new javax.swing.JTextField();
        code_txt = new javax.swing.JTextField();
        engine_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        id_num = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 120, 40));
        getContentPane().add(model_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 170, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1180, 10));

        jLabel5.setText("Code:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, 20));

        jLabel11.setText("Model:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, 20));

        jLabel10.setText("Search:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 50, 40));
        getContentPane().add(year_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 170, 40));

        jLabel8.setText("Engine no. :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 70, 20));

        jLabel2.setText("Description:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        jLabel6.setText("Year:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, 20));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 460, 40));

        jLabel4.setText("Kind of Equipment:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 130, 20));

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 120, 40));

        jLabel7.setText("Plate no. :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 60, 20));

        kind_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Heavy", "Light", "Support" }));
        getContentPane().add(kind_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 170, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID no.", "Description", "Model", "Kind of Equipment", "Code", "Year", "Plate no. ", "Engine", "Chassis no."
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1200, 530));
        getContentPane().add(description_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, 40));

        jLabel9.setText("Chassis no. :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 20));
        getContentPane().add(chassis_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 170, 40));
        getContentPane().add(Plateno_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 170, 40));

        code_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                code_txtActionPerformed(evt);
            }
        });
        getContentPane().add(code_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 170, 40));
        getContentPane().add(engine_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 170, 40));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EQUIPMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baskerville Old Face", 1, 14))); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 210));
        getContentPane().add(id_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 30, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(description_txt.getText().isEmpty()||
  model_txt.getText().isEmpty()||
  code_txt.getText().isEmpty()||
 year_txt.getText().isEmpty()||
  Plateno_txt.getText().isEmpty()||
 engine_txt.getText().isEmpty()||
 chassis_txt.getText().isEmpty()
  ){
           JOptionPane.showMessageDialog(null,"Invalid inputs");
       }else{
          add();
            findUsers();
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        findUsers();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(description_txt.getText().isEmpty()||
  model_txt.getText().isEmpty()||
  code_txt.getText().isEmpty()||
 year_txt.getText().isEmpty()||
  Plateno_txt.getText().isEmpty()||
 engine_txt.getText().isEmpty()||
 chassis_txt.getText().isEmpty()
  ){
           JOptionPane.showMessageDialog(null,"Invalid inputs");
       }else{
             update();
        findUsers();
       }
        jButton1.setVisible(false);
        jButton2.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void code_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_code_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_code_txtActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        ShowItem(index);
          jButton1.setVisible(true);
          jButton2.setVisible(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Plateno_txt;
    private javax.swing.JTextField chassis_txt;
    private javax.swing.JTextField code_txt;
    private javax.swing.JTextField description_txt;
    private javax.swing.JTextField engine_txt;
    private javax.swing.JLabel id_num;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox kind_cbox;
    private javax.swing.JTextField model_txt;
    private javax.swing.JTextField year_txt;
    // End of variables declaration//GEN-END:variables
}
