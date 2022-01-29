/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChitChat;

import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author NKC
 */

public class AddGroup extends javax.swing.JFrame {

    String drv="com.mysql.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
    String mspass=LogiN.mspass;;
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    DefaultListModel dlm=new DefaultListModel();
    String cu;
    public static String frnd[]={"0","0","0","0","0","0","0","0","0","0"
                                 ,"0","0","0","0","0","0","0","0","0","0"};
    public static int cnt=0;
    Cfm frm;
    public AddGroup(String user,Cfm cf) {
        cu=user;
        frm=cf;
        initComponents();
        username.setText(cu);
        loadSuggestions();
    }
    
    public AddGroup() {
        initComponents();
        loadSuggestions();
    }

    private void loadSuggestions() {
        uslist.removeAll();
        try{
            Class.forName(drv);
            con=DriverManager.getConnection(conurl, "root", mspass);
            st=con.createStatement();
            String qry="select * from uspa;";
            rs=st.executeQuery(qry);
            rs.first();
            do{
                if((!rs.getString(1).equalsIgnoreCase(cu)))
                  {                 
                     AddInGrp adigp=new AddInGrp();
                     adigp.setNm(rs.getString(1),cu);
                     uslist.add(adigp,0);
                  }
                  if(rs.isLast())
                  {
                     break;
                  }
            }while(rs.next());
               st.close();
               rs.close();
               con.close(); 
               
              }                       
       catch(Exception ex)
       {
           System.out.println(ex+" error in loadSugg Group(GP)");
       }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gpname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        holder = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        uslist = new javax.swing.JPanel();
        crtbutton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Group Name :");
        jLabel1.setToolTipText("");

        holder.setBackground(new java.awt.Color(255, 255, 255));
        holder.setLayout(new java.awt.GridLayout(1, 1));

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        uslist.setLayout(new java.awt.GridLayout(0, 1, 0, 2));
        jScrollPane1.setViewportView(uslist);

        holder.add(jScrollPane1);

        crtbutton.setBackground(new java.awt.Color(51, 51, 255));
        crtbutton.setText("Create");
        crtbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crtbuttonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Admin            :");
        jLabel2.setToolTipText("");

        username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(holder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gpname, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(crtbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gpname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(crtbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(holder, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crtbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crtbuttonActionPerformed
 crtbutton.setEnabled(false);
 if(!gpname.getText().equals(""))
 {
    try{
      Class.forName(drv);
      con=DriverManager.getConnection(conurl, "root", mspass);
      st=con.createStatement();
      synchronized(this){
      System.out.println("in add  1");
      String qry="create table "+gpname.getText()+" (name varchar(20) ,msg varchar(200),"+
              username.getText()+"rd int,othrd int);";
      int iii=st.executeUpdate(qry);
      System.out.println("in add  2");
      this.wait(2);
      String qry3="Insert into "+cu+"grp"+" values('"+gpname.getText()+"',"+Math.random()*100000+");";
      int iit=st.executeUpdate(qry3);
      System.out.println("in add  3");
      this.wait(2);
      System.out.println("in add  4");
      for(int i=0;i<=cnt;i++)
      {
          System.out.println("in add  5");
          if(!(frnd[i].equals("0")||frnd[i].equals("null")||frnd[i].equals("")))
          {
              String qry2="Insert into "+frnd[i]+"grp"+" values('"+gpname.getText()+"',"+Math.random()*100000+");";
              int ii=st.executeUpdate(qry2);
              System.out.println("in add  6");
              this.wait(2);
          }
      }
      }
      System.out.println("in add  7");
      frm.grpList();
      con.close();
      st.close();
      this.setVisible(false);
     }
     catch(Exception ex)
     {
         System.out.println(ex+"error in add");
         JOptionPane.showMessageDialog(this, "Group name isn't available. give another");
     }
 }
 else
 {
     JOptionPane.showMessageDialog(this, "Please name your Group");
 }
 crtbutton.setEnabled(true);
    }//GEN-LAST:event_crtbuttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGroup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crtbutton;
    private javax.swing.JTextField gpname;
    private javax.swing.JPanel holder;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel username;
    private javax.swing.JPanel uslist;
    // End of variables declaration//GEN-END:variables
}
