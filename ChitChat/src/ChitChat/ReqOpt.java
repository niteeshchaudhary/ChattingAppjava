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
public class ReqOpt extends javax.swing.JPanel {

    String drv="com.mysql.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
    String mspass=LogiN.mspass;;
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    String curru="";
    public ReqOpt() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        u1 = new javax.swing.JLabel();
        acpt = new javax.swing.JButton();
        del = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        u1.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        u1.setForeground(new java.awt.Color(0, 0, 153));
        u1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/r2.png"))); // NOI18N
        u1.setText("NK");
        u1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(u1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, 184, 47));

        acpt.setBackground(new java.awt.Color(0, 102, 0));
        acpt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acpt.setText("Accept Request");
        acpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acptActionPerformed(evt);
            }
        });
        add(acpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 194, 47));

        del.setBackground(new java.awt.Color(255, 0, 51));
        del.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        del.setText("Delete");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        add(del, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 121, 47));
    }// </editor-fold>//GEN-END:initComponents

    private void acptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acptActionPerformed
acpt.setEnabled(false);
del.setEnabled(false);
   try{
      Class.forName(drv);
      con=DriverManager.getConnection(conurl, "root", mspass);
      st=con.createStatement();
      String qry="Insert into "+curru+"ufr"+" values('"+u1.getText()+"',"+Math.random()*100000+");";
      String qry2="delete from "+curru+"rfr"+" where name='"+u1.getText()+"';";
      String qry3="Insert into "+u1.getText()+"ufr"+" values('"+curru+"',"+Math.random()*100000+");";
      String qry4="Insert into "+u1.getText()+"ufr"+" values('$$@!!',"+Math.random()*100000+");";
      String qry5="Insert into "+curru+"ufr"+" values('$$@!!',"+Math.random()*100000+");";
      synchronized(this)
      {
      int ii=st.executeUpdate(qry);
      int iiit=st.executeUpdate(qry3);
      int iii=st.executeUpdate(qry2);
      iii=st.executeUpdate(qry4);
      iii=st.executeUpdate(qry5);
      Cfm.chnls.setSelectedIndex(1);
      st.close();
      con.close();
      }
      this.setVisible(false);
     }
     catch(Exception ex)
     {
         System.out.println(ex+" acpt error");
     }             
 acpt.setEnabled(true);  
 del.setEnabled(true);
    }//GEN-LAST:event_acptActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
acpt.setEnabled(false);
del.setEnabled(false);
      try{
      Class.forName(drv);
      con=DriverManager.getConnection(conurl, "root", mspass);
      st=con.createStatement();
      String qry1="delete from "+curru+"rfr"+" where name='"+u1.getText()+"';";
      String qry2="Insert into "+u1.getText()+"ufr"+" values('$$@!!',"+Math.random()*100000+");";
      synchronized(this)
      {
      int iii=st.executeUpdate(qry1);
          iii=st.executeUpdate(qry2);
      this.setVisible(false);
      Cfm.chnls.setSelectedIndex(1);
      rs.close();
      con.close();
      }
     }
     catch(Exception ex)
     {
         System.out.println(ex);
     }
 acpt.setEnabled(true);  
 del.setEnabled(true);
    }//GEN-LAST:event_delActionPerformed
  void setNm(String rn, String curu) {
     u1.setText(rn);
     curru=curu;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acpt;
    private javax.swing.JButton del;
    private javax.swing.JLabel u1;
    // End of variables declaration//GEN-END:variables
}
