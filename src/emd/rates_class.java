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
public class rates_class {
    private int id_num; 
   private String description;
   private String kind_rate;
   private String rate;
    
   public rates_class(int id_num,String description,String kind_rate,String rate){
       this.id_num=id_num;
       this.description=description;
       this.kind_rate = kind_rate;
       this.rate=rate;
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
     * @return the kind_rate
     */
    public String getKind_rate() {
        return kind_rate;
    }

    /**
     * @return the rate
     */
    public String getRate() {
        return rate;
    }
   
}
