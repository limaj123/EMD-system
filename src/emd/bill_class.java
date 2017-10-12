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
public class bill_class {
  private int id_num;
  private String date_from;
  private String date_to;
  private String description;
  
     public  bill_class(int id_num,String date_from,String date_to,String description){
       this.id_num=id_num;
 this.date_from=date_from;
 this.date_to=date_to;
this.description=description;
   }

    /**
     * @return the id_num
     */
    public int getId_num() {
        return id_num;
    }

    /**
     * @return the date_from
     */
    public String getDate_from() {
        return date_from;
    }

    /**
     * @return the date_to
     */
    public String getDate_to() {
        return date_to;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
     
}
