/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChitChat;

import java.awt.Color;
import java.sql.*;

/**
 *
 * @author NKC
 */
public class GrPls extends javax.swing.JPanel {

   String drv="com.mysql.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
   String mspass=LogiN.mspass;;
   Connection con=null;
   Statement st=null;
   ResultSet rs=null;
   
    public GrPls() {
        initComponents();
        ps.setVisible(false);
    }
     public void setNm(String s1/*,int tr*/,int pp)
     {
         ps.setText(pp+"");
         fn.setText(s1);
         fc.setText((s1.charAt(0)+"").toUpperCase());
     }
     public String getNm()
     {
         return   fn.getText();
     }
     public int getPs()
     {
         return   Integer.parseInt(ps.getText());
     }
    /* public void activ(int tr)
     {
         if(tr==0)
         {
             of.setBackground(Color.ORANGE);
         }
         else
         {
          of.setBackground(Color.GREEN);   
         }
     }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fn = new javax.swing.JLabel();
        fc = new javax.swing.JLabel();
        of = new javax.swing.JLabel();
        ps = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 153));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        fn.setForeground(new java.awt.Color(255, 255, 255));
        fn.setText("frnd names");
        add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 11, 131, 35));

        fc.setBackground(new java.awt.Color(51, 0, 51));
        fc.setFont(new java.awt.Font("Blackadder ITC", 1, 30)); // NOI18N
        fc.setForeground(new java.awt.Color(255, 255, 255));
        fc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fc.setOpaque(true);
        add(fc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 43, 35));

        of.setBackground(new java.awt.Color(204, 153, 0));
        of.setOpaque(true);
        add(of, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 21, 0, -1));
        add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 57, 15, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
  //chk();
    }//GEN-LAST:event_formMouseMoved
/*public void chk()
{
       try
{
Class.forName(drv);
con=DriverManager.getConnection(conurl, "root", mspass);
st=con.createStatement();
String qry="select * from actv where usname = '"+fn.getText()+"';";
rs=st.executeQuery(qry);
rs.first();
if(rs.getInt(2)==1)
{
    rs.close();
    con.close();
    //activ(1);
}
else
{
rs.close();
con.close();    
//activ(0);
}
}
catch(Exception ex)
{
  System.out.println(ex+" grpls class");
}
}*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fc;
    private javax.swing.JLabel fn;
    private javax.swing.JLabel of;
    private javax.swing.JLabel ps;
    // End of variables declaration//GEN-END:variables
}
