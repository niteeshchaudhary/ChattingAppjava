/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChitChat;

//import sun.util.calendar.LocalGregorianCalendar.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


//import sun.util.calendar.BaseCalendar.Date;


/**
 *
 * @author Pooja~Priya
 */

public class TimeW extends Thread{
    String drv="com.mysql.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
    String mspass=LogiN.mspass;
    Date pd=new Date();
    long ln=pd.getTime();
    long tme=0;
    public  int tt=0;
    String rname="";
    public TimeW(int st,String rnm)
    {
       tt=st;
       pd=new Date();
       ln=pd.getTime();
       tme=0;
       rnm=rname;
    }
    public void orst(int st)
    {
       tt=st;
       pd=new Date();
       ln=pd.getTime();
       tme=0;
    }
    public void rst()
    {
       pd=new Date();
       ln=pd.getTime();
       tme=0;
    }
    public void upds()
    {
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
     try{
      Class.forName(drv);
      con=DriverManager.getConnection(conurl, "root", mspass);
      st=con.createStatement();
      String qry="";
        if(tt>1)
      {
         qry="update zcxz set st"+2+"=0 where name='"+rname+"';"; 
      }
      else
      {
          qry="update zcxz set st"+1+"=0 where name='"+rname+"';"; 
      }
      int yui=st.executeUpdate(qry);
     }catch(Exception ex)
     {
         System.out.println(ex);
     }
    }
public void run()
{
    while(true)
    {
    Date dd=new Date();    
    tme=(dd.getTime()-ln)/60;
    //tme=tme-ln;
   /* if(tt==1){
    ZeroCross.uprog.setValue((int)(1*200-tme));
    if(ZeroCross.oprog.getValue()!=200||ZeroCross.oprog.getValue()!=0)
    {
         ZeroCross.oprog.setValue(0);
    }
    }
    else if(tt==2){
    ZeroCross.oprog.setValue((int)(1*200-tme));  
     if(ZeroCross.uprog.getValue()!=200||ZeroCross.uprog.getValue()!=0)
    {
         ZeroCross.uprog.setValue(0);
    }
    }
     
    if (ZeroCross.uprog.getValue()==0 && tt==1){
        ZeroCross.oprog.setValue(200);
        upds();
        try{
        this.wait(10);
        }catch(Exception ex)
        {   
        }
        rst();
        tt=2;
     }
     else if(ZeroCross.oprog.getValue()==0 && tt==2){
        ZeroCross.uprog.setValue(200);
        upds();
        try{
        this.wait(10);
        }catch(Exception ex)
        {
        }
        rst();
        tt=1;
     }*/
  }
}      
}
