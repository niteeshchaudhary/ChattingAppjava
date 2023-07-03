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

   String drv="com.mysql.cj.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
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
        java.awt.GridBagConstraints gridBagConstraints;

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
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWeights = new double[] {0.3, 0.7};
        layout.rowWeights = new double[] {1.0};
        setLayout(layout);

        fn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        fn.setForeground(new java.awt.Color(255, 255, 255));
        fn.setText("frnd names");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        add(fn, gridBagConstraints);

        fc.setBackground(new java.awt.Color(51, 0, 51));
        fc.setFont(new java.awt.Font("Blackadder ITC", 1, 30)); // NOI18N
        fc.setForeground(new java.awt.Color(255, 255, 255));
        fc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fc.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.ipady = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        add(fc, gridBagConstraints);

        of.setBackground(new java.awt.Color(204, 153, 0));
        of.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(of, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 29);
        add(ps, gridBagConstraints);
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
rs.next();
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
