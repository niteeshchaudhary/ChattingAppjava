package ChitChat;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author NKC
 */
public class ReqSuggest extends javax.swing.JPanel {
    
    String drv="com.mysql.cj.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
    String mspass=LogiN.mspass;;
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    String currentu="";
    public ReqSuggest() 
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        u1 = new javax.swing.JLabel();
        sr = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 153));

        u1.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        u1.setForeground(new java.awt.Color(0, 0, 204));
        u1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/r2.png"))); // NOI18N
        u1.setText("NK");
        u1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        sr.setBackground(new java.awt.Color(0, 102, 0));
        sr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sr.setText("Send Request");
        sr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(u1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(sr, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(u1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
int cntd=0;
    private void srActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srActionPerformed
     cntd++;
     if(cntd%2!=0)
     {
      addReq();
     }
     else
     {
      clsReq();
     }        
    }//GEN-LAST:event_srActionPerformed
    public void setNm(String st,String curu) {
        u1.setText(st);
        currentu=curu;
        opLoad();
    }
    private void clsReq() {
     sr.setBackground(new java.awt.Color(0, 102, 0));
     sr.setText("Send Request");  
     try{
      Class.forName(drv);
      con=DriverManager.getConnection(conurl, "root", mspass);
      st=con.createStatement();
      String qry="delete from "+u1.getText()+"rfr"+" where name='"+currentu+"';";
      int ii=st.executeUpdate(qry);
      rs.close();
      con.close();
     }
     catch(Exception ex)
     {
         System.out.println(ex+" clsreq");
     }
    }
    private void addReq() {
      
      sr.setBackground(Color.ORANGE);
      sr.setText("Cancel Request");
      try{
      Class.forName(drv);
      con=DriverManager.getConnection(conurl, "root", mspass);
      st=con.createStatement();
      String qry="Insert into "+u1.getText()+"rfr"+" values('"+currentu+"',"+Math.random()*100000+");";
      int ii=st.executeUpdate(qry);
      rs.close();
      con.close();
     }
     catch(Exception ex)
     {
         System.out.println(ex+" addreq");
     }
    }
    
    public void opLoad() 
    {
     try{
      Class.forName(drv);
      con=DriverManager.getConnection(conurl, "root", mspass);
      st=con.createStatement();
      String qry="select * from "+u1.getText()
                  +"rfr where name ='"+currentu+"';";
      rs=st.executeQuery(qry);
      rs.next();
      if(!rs.getString(1).equals(null))
      {
      cntd=1;
      sr.setBackground(Color.ORANGE);
      sr.setText("Cancel Request");
      }
      rs.close();
      con.close();
     }
     catch(Exception ex)
     {
         
       if(!ex.toString().equalsIgnoreCase("java.sql.SQLException:"
               + " Illegal operation on empty result set."))
         {
             System.out.println(ex+ " opload");
         }
     }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton sr;
    private javax.swing.JLabel u1;
    // End of variables declaration//GEN-END:variables
}
