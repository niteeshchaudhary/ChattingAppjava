/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChitChat;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NKC
 */
public class FrLst extends javax.swing.JPanel{

   String drv="com.mysql.cj.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
   String mspass=LogiN.mspass;;
   Connection con=null;
   Statement st=null;
   ResultSet rs=null;
   String sn2="";
   Thread tt;
    public FrLst() {
        initComponents();
        nms.setVisible(false);
        ps.setVisible(false);
       // iniup();
    }
private void iniup() {
      try{
       Class.forName(drv);
      con=DriverManager.getConnection(conurl, "root", mspass);
      }
      catch(Exception ex)
      {
          System.out.println("iniup");
      }
  }
     public void setNm(String s1,String s2,int tr,int pp)
     {
         ps.setText(pp+"");
         fn.setText(s1);
         fc.setText((s1.charAt(0)+"").toUpperCase());
         if(tr==0)
         {
             //of.setBackground(Color.ORANGE);
             of.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 6, true));
         }
         else
         {
          //of.setBackground(Color.GREEN);   
          of.setBorder(new javax.swing.border.LineBorder(Color.green, 6, true));
         }
         sn2=s2;
         noti(s2);
     }
     public String getNm()
     {
         return   fn.getText();
     }
     public int getPs()
     {
         return   Integer.parseInt(ps.getText());
     }
     public void activ(int tr)
     {
         if(tr==0)
         {
            // of.setBackground(Color.ORANGE);
             of.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 6, true));
         }
         else
         {
          //of.setBackground(Color.GREEN);
          of.setBorder(new javax.swing.border.LineBorder(Color.green, 6, true));
         }
        noti(sn2); 
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fn = new javax.swing.JLabel();
        fc = new javax.swing.JLabel();
        of = new javax.swing.JLabel();
        ps = new javax.swing.JLabel();
        nms = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 153));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {1};
        layout.rowHeights = new int[] {1};
        layout.columnWeights = new double[] {0.3, 0.5, 0.1, 0.1};
        layout.rowWeights = new double[] {0.1};
        setLayout(layout);

        fn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        fn.setForeground(new java.awt.Color(255, 255, 255));
        fn.setText("frnd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.ipady = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        add(fn, gridBagConstraints);

        fc.setBackground(new java.awt.Color(255, 51, 0));
        fc.setFont(new java.awt.Font("Blackadder ITC", 1, 30)); // NOI18N
        fc.setForeground(new java.awt.Color(0, 0, 102));
        fc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/r2.png"))); // NOI18N
        fc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = -6;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        add(fc, gridBagConstraints);

        of.setBackground(new java.awt.Color(204, 153, 0));
        of.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 6, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -2;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 15, 0, 0);
        add(of, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 38);
        add(ps, gridBagConstraints);

        nms.setBackground(new java.awt.Color(0, 153, 255));
        nms.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/mss2.png"))); // NOI18N
        nms.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 0);
        add(nms, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        chk();   
    }//GEN-LAST:event_formMouseMoved

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
  //chk();      // TODO add your handling code here:
    }//GEN-LAST:event_formComponentMoved
public void chk()
{
       try
{
Class.forName(drv);
con=DriverManager.getConnection(conurl, "root", mspass);
st=con.createStatement();
String qry="select * from actv where usname = '"+fn.getText()+"';";
rs=st.executeQuery(qry);
rs.next();
if(rs.getInt(2)==1)
{
    rs.close();
    con.close();
    activ(1);
}
else
{
rs.close();
con.close();    
activ(0);
}
}
catch(Exception ex)
{
           try {
               con.close();
           } catch (SQLException ex1) {
               Logger.getLogger(FrLst.class.getName()).log(Level.SEVERE, null, ex1);
           }
  System.out.println(ex+" Frlst class chk");
  
}
}
public void noti(String s2)
{
    String s1=fn.getText();
   try
{
    Class.forName(drv);
    con=DriverManager.getConnection(conurl, "root", mspass);
    st=con.createStatement();
    String tbnm="";
    if(s1.compareTo(s2)>0)
    {
              tbnm=s2+s1;
    }
    else
    {
              tbnm=s1+s2; 
    }
    String qry="select count("+s2+"rd) from "+tbnm+" where "+s2+"rd = 0;";
synchronized(this)
{
    rs=st.executeQuery(qry);
    rs.next();
    if(rs.getInt(1)>0)
    {
    nms.setText(rs.getInt(1)+"");
    nms.setVisible(true);
    System.out.println(nms.getText());
    }
    else
    {
    nms.setText(rs.getInt(1)+"");
    nms.setVisible(false);
    }
            String qrypl="select count(*) from "+tbnm +" where "+s1+"pl=1;";
            rs=st.executeQuery(qrypl);
            System.out.println("ll   1");
            rs.next();
            System.out.println("ll   2");
            if(rs.getInt(1)>0)
            {
                String qrypl2="update "+tbnm +" set "+s1+"pl=0;";
                System.out.println("ll   3");
                int ikl=st.executeUpdate(qrypl2);
                //recon1.setVisible(true);
                new ReqZxc(tbnm,s2,s1,"O",2).setVisible(true);
                //new ZeroCross(tbnm,s2,s1,"O",2).setVisible(true);
                //this.dispose();
                //th.stop();
            }
            String qryplt="select count(*) from "+tbnm +" where "+s1+"pl=2;";
            rs=st.executeQuery(qryplt);
            System.out.println("ll   1");
            rs.next();
            System.out.println("ll   2");
            if(rs.getInt(1)>0)
            {
                String qrypl2="update "+tbnm +" set "+s1+"pl=0;";
                System.out.println("ll   3");
                int ikl=st.executeUpdate(qrypl2);
                //recon1.setVisible(true);
                new ReqFlst(tbnm,s2,s1,2).setVisible(true);
            }
            System.out.println("ll   4");
    rs.close();
    con.close();
    }
    try{
    con.close();
    }catch(Exception ex){System.out.println(ex+" Frlst class noTif");}
}
catch(Exception ex)
{
  System.out.println(ex+" Frlst class noTif");
}
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fc;
    private javax.swing.JLabel fn;
    private javax.swing.JLabel nms;
    private javax.swing.JLabel of;
    private javax.swing.JLabel ps;
    // End of variables declaration//GEN-END:variables
}
