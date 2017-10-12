/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamil Francisco
 */
public class equipment_btn {
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
    public void saveadd(String description,String model,String Equipment_kind,String Code,int Year, String Plate_no,String Engine_No,String Chassis){
             Connection con = getConnection();
          
             try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO `equipment` (`id_num`, `description`, `model`, `Equipment_kind`, `Code`, `Year`, `Plate no.`, `Engine No.`, `Chassis`)"+" VALUES (NULL,?,?,?,?,?,?,?,?)");
               
                ps.setString(1,description);
                ps.setString(2,model);
                ps.setString(3,Equipment_kind);
                ps.setString(4,Code);
                ps.setInt(5,Year);
                ps.setString(6, Plate_no);
                ps.setString(7, Engine_No);
                ps.setString(8,Chassis);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "SAVE");
             
            } catch (SQLException ex) {
                Logger.getLogger(equipment_btn.class.getName()).log(Level.SEVERE, null, ex);
                }     
              }
      public void update(int id_num, String description, String model,String Equipment_kind,String Code,int Year,String Plate_no,String Engine_No,String Chassis){
             Connection con = getConnection();
              String UpdateQuery =null;
            PreparedStatement ps1 = null;
           
              try {
                    UpdateQuery= "UPDATE `equipment` SET  `description`=?, `model`=?, `Equipment_kind`=?, `Code`=?, `Year`=?, `Plate no.`=?, `Engine No.`=?, `Chassis`=? WHERE `equipment`.`id_num` = ?;";
                    ps1 = con.prepareStatement(UpdateQuery);                    
                
                ps1.setString(1, description);
                ps1.setString(2,model);
                ps1.setString(3, Equipment_kind);
                ps1.setString(4, Code);
                ps1.setInt(5, Year);
                 ps1.setString(6, Plate_no);
                ps1.setString(7, Engine_No);
                ps1.setString(8, Chassis);
                ps1.setInt(9, id_num);
                ps1.executeUpdate();
                JOptionPane.showMessageDialog(null,"Update Complete");
                  
                } catch (SQLException ex) {
                    Logger.getLogger(equipment_btn.class.getName()).log(Level.SEVERE, null, ex);
                
            }
 }
    
    
}
