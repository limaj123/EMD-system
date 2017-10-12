/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emd;

/**
 *
 * @author Jamil Francisco
 */
public class Equipment_class {
    private int id_num;
    private String description;
    private String model;
    private String Equipment_kind;
    private String Code; 
    private int Year;
    private String Plate_no;
    private String Engine_No;
    private String Chassis;  

    
    public Equipment_class( int id_num,String description,String model,String Equipment_kind,String Code,int Year, String Plate_no,String Engine_No,String Chassis
){
  this.id_num=id_num;
   this.description=description;
   this.model= model;
   this.Equipment_kind=Equipment_kind;
   this.Code= Code;
   this.Year= Year;
   this.Plate_no =Plate_no;
   this.Engine_No=Engine_No;
   this.Chassis=Chassis;
    }

    /**
     * @return the id_num
     */
    public int getId_num() {
        return id_num;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return the Equipment_kind
     */
    public String getEquipment_kind() {
        return Equipment_kind;
    }

    /**
     * @return the Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * @return the Year
     */
    public int getYear() {
        return Year;
    }

    /**
     * @return the Plate_no
     */
    public String getPlate_no() {
        return Plate_no;
    }

    /**
     * @return the Engine_No
     */
    public String getEngine_No() {
        return Engine_No;
    }

    /**
     * @return the Chassis
     */
    public String getChassis() {
        return Chassis;
    }
    
    
    
    
}
