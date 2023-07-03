package ChitChat;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author NKC
 */
public class AddInGrp extends javax.swing.JPanel {
    
    String drv="com.mysql.cj.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
    String mspass=LogiN.mspass;;
    String currentu="";
    
    public AddInGrp() 
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        u1 = new javax.swing.JLabel();
        sr = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 153));
        setLayout(new java.awt.GridBagLayout());

        u1.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        u1.setForeground(new java.awt.Color(255, 255, 255));
        u1.setText("NK");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 158;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 24, 13, 0);
        add(u1, gridBagConstraints);

        sr.setBackground(new java.awt.Color(0, 102, 0));
        sr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sr.setText("ADD");
        sr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 276, 13, 28);
        add(sr, gridBagConstraints);
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
    }
    private void clsReq() {
     sr.setBackground(new java.awt.Color(0, 102, 0));
     sr.setText("ADD");
     int i=0,j=0;
     while(!AddGroup.frnd[i].equalsIgnoreCase(u1.getText())){i++;}
     for(j=i;j<AddGroup.cnt;j++)
     {
         AddGroup.frnd[j]=AddGroup.frnd[j+1];
     }
     AddGroup.frnd[j]="0";
     AddGroup.cnt--;
    }
    private void addReq() {
      AddGroup.frnd[AddGroup.cnt]=u1.getText();
      AddGroup.cnt++;
      sr.setBackground(Color.ORANGE);
      sr.setText("REMOVE");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton sr;
    private javax.swing.JLabel u1;
    // End of variables declaration//GEN-END:variables
}
