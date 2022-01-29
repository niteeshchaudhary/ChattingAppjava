/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChitChat;

import java.awt.Color;

/**
 *
 * @author NKC
 */
public class Jmb1 extends javax.swing.JPanel {

    /**
     * Creates new form Msd
     */
    public Jmb1() {
        initComponents();
        msb.setBackground(Color.orange);
    }
 public void setMsg(String msg,String us)
 {
     msb.setText(msg);
     cuss.setText(us);
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        msb = new javax.swing.JTextArea();
        cuss = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);

        jScrollPane1.setBackground(new java.awt.Color(0, 255, 0));

        msb.setEditable(false);
        msb.setBackground(new java.awt.Color(255, 199, 49));
        msb.setColumns(20);
        msb.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        msb.setRows(5);
        msb.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(msb);

        cuss.setBackground(new java.awt.Color(255, 51, 0));
        cuss.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cuss.setForeground(new java.awt.Color(255, 51, 0));
        cuss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/r4.png"))); // NOI18N
        cuss.setText("cu");
        cuss.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cuss)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(cuss)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cuss;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msb;
    // End of variables declaration//GEN-END:variables
}
