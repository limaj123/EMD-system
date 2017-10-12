package emd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jamil Francisco
 */
public class project_class {
private int id_num;
private String ProjectID;
private String MSK_ProjectCode;

private String location;
private String Project_Name;
public project_class(int id_num,
String ProjectID,
String MSK_Project,
String location,
String Project_Name){
    this.id_num=id_num;
  this.ProjectID=ProjectID;
this.MSK_ProjectCode=MSK_Project;
this.location=location;
this.Project_Name=Project_Name;
}

    /**
     * @return the id_num
     */
    public int getId_num() {
        return id_num;
    }

    /**
     * @return the ProjectID
     */
    public String getProjectID() {
        return ProjectID;
    }

    /**
     * @return the MSK_Project
     */
    public String getMSK_ProjectCode() {
        return MSK_ProjectCode;
    }

    /**
     * @return the Code
     */
 
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the Project_Name
     */
    public String getProject_Name() {
        return Project_Name;
    }
}
