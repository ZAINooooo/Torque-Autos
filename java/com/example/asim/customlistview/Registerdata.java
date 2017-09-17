package com.example.asim.customlistview;

/**
 * Created by zain on 7/9/2017.
 */



public class Registerdata
{
    String change_password;
    int _id;

    String first_name;
    String email_id;
    String password;
    String confirm_password;


    // Empty constructor
    public Registerdata()
    {

    }

    // constructor
    public Registerdata(int id , String first_name, String password ,  String email_id, String confirm_password , String change_password )
    {

        this._id = id;
        this.first_name = first_name;
        this.password = password;
        this.email_id=email_id;
        this.confirm_password=confirm_password;
        this.change_password = change_password;
    }


    // getting ID
    public int getID()
    {
        return this._id;
    }



    // setting id
    public void setID(int id){
        this._id = id;
    }



    public String getfirstName() {
        // TODO Auto-generated method stub
        return first_name;
    }

    // setting  first name
    public void setfirstName(String first_name)
    {
        this.first_name =first_name;
    }



    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getEmailId()
    {
        // TODO Auto-generated method stub
        return email_id;
    }

    public void setEmailId(String email_id)
    {
        this.email_id =email_id;
    }



    public void setChangePassword(String change_password)
    {
        this.change_password = change_password;
    }

    public String getChangePassword()
    {
        return  change_password;
    }




    public String getConfirm_password()
    {
        // TODO Auto-generated method stub
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password)
    {
        this.confirm_password =confirm_password;
    }






//    public String getPassword(String password)
//    {
//        // TODO Auto-generated method stub
//        return password;
//    }
//
//    public void setPassword(String password){
//        this.password=password;
//    }
}
