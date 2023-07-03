/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChitChat;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Pooja~Priya
 */
public class ZeroCross extends javax.swing.JFrame implements Runnable {

    String drv = "com.mysql.cj.jdbc.Driver", conurl = "jdbc:mysql://localhost:3306/" + LogiN.dbnm;
    String mspass = LogiN.mspass;
    Thread thre;
    int errhandler = 0;

    public ZeroCross(String ss, String cu, String op, String symb, int tr) {
        initComponents();
        symbl.setText(symb);
        cplayer.setText((cu.charAt(0) + "").toUpperCase());
        oplayer.setText((op.charAt(0) + "").toUpperCase());
        oo.setText(op);
        cc.setText(cu);
        ul.setVisible(false);
        ul.setVisible(true);
        trn.setText(tr + "");
        switch (symb.toUpperCase()) {
            case "X":
                symbl1.setText("O");
                try {
                    oplayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/O2.png")));
                    cplayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/x1.png")));
                } catch (Exception eex) {
                }
                break;
            case "O":
                symbl1.setText("x");
                try {
                    oplayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/x2.png")));
                    cplayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/O1.png")));
                } catch (Exception eex) {
                }
                break;
        }

        clrLb();
        enabeledT();
        errhandler = 0;
        rname.setText(ss);
        if (tr == 1) {
        }
        iniup();
        iftb();
        // thre2=new TimeW(Integer.parseInt(tc.getText()),ss);
        thre = new Thread(this);
        thre.start();
        // thre2.start();
    }

    private void iftb() {
        Connection con1 = null;
        ResultSet rs1 = null;
        Statement st1 = null;
        try {
            Class.forName(drv);
            con1 = DriverManager.getConnection(conurl, "root", mspass);
            st1 = con1.createStatement();
            // String qry="Insert into
            // zcxz(name,turn,tu2,st1,st2,sym1,sym2"+((JLabel)evt.getSource()).getText()
            // +") values("+u1.getText()+"',"+Math.random()*100000+");";
            String qry1 = "select count(*) from zcxz where name='" + rname.getText() + "';";
            String qry = "";
            String qr = "";
            rs1 = st1.executeQuery(qry1);
            rs1.next();
            if (rs1.getInt(1) > 0 && Integer.parseInt(trn.getText()) == 1) {
                qr = "update zcxz set c1='',c2='',c3='',c4='',c5='',c6='',c7='',c8='',c9='',turn=1,st1=1,st2=2 where name='"
                        + rname.getText() + "';";
                int ii = st1.executeUpdate(qr);
            } else if (rs1.getInt(1) == 0 && Integer.parseInt(trn.getText()) == 1) {
                qr = "insert into zcxz values('" + rname.getText() + "','','','','','','','','','',1,0,1,1,'x','o')";
                int ii = st1.executeUpdate(qr);
            }
            qry = "update zcxz set st" + trn.getText() + "=1 where name='" + rname.getText() + "';";
            int iii = st1.executeUpdate(qry);
            rs1.close();
            st1.close();
            con1.close();
        } catch (Exception ex) {
            System.out.println(ex + " iftb");
        }

    }

    private void chk() {
        // Rows..................................................................
        if (lb1.getText().equals(lb2.getText()) && lb1.getText().equals(lb3.getText()) && !lb1.getText().isEmpty()) {
            if (lb1.getText().equals(symbl.getText())) {
                wWon();
            } else {
                lLost();
            }
        } else if (lb4.getText().equals(lb5.getText()) && lb4.getText().equals(lb6.getText())
                && !lb4.getText().isEmpty()) {
            if (lb4.getText().equals(symbl.getText())) {
                wWon();
            } else {
                lLost();
            }
        } else if (lb7.getText().equals(lb8.getText()) && lb7.getText().equals(lb9.getText())
                && !lb7.getText().isEmpty()) {
            if (lb7.getText().equals(symbl.getText())) {
                wWon();
            } else {
                lLost();
            }
        }
        // coloumn......................................................................
        else if (lb1.getText().equals(lb4.getText()) && lb1.getText().equals(lb7.getText())
                && !lb1.getText().isEmpty()) {
            if (lb1.getText().equals(symbl.getText())) {
                wWon();
            } else {
                lLost();
            }
        } else if (lb2.getText().equals(lb5.getText()) && lb2.getText().equals(lb8.getText())
                && !lb2.getText().isEmpty()) {
            if (lb2.getText().equals(symbl.getText())) {
                wWon();
            } else {
                lLost();
            }
        } else if (lb3.getText().equals(lb6.getText()) && lb3.getText().equals(lb9.getText())
                && !lb3.getText().isEmpty()) {
            if (lb3.getText().equals(symbl.getText())) {
                wWon();
            } else {
                lLost();
            }
        }
        // diagonal ....................................................................
        else if (lb1.getText().equals(lb5.getText()) && lb1.getText().equals(lb9.getText())
                && !lb1.getText().isEmpty()) {
            if (lb1.getText().equals(symbl.getText())) {
                wWon();
            } else {
                lLost();
            }
        } else if (lb7.getText().equals(lb5.getText()) && lb7.getText().equals(lb3.getText())
                && !lb7.getText().isEmpty()) {
            if (lb7.getText().equals(symbl.getText())) {
                wWon();
            } else {
                lLost();
            }
        } else if (!lb1.getText().equals("") && !lb2.getText().equals("") && !lb3.getText().equals("") &&
                !lb4.getText().equals("") && !lb5.getText().equals("") && !lb6.getText().equals("") &&
                !lb7.getText().equals("") && !lb8.getText().equals("") && !lb9.getText().equals("")) {
            tTie();
        }
    }

    private void enabeledT() {
        lb1.setEnabled(true);
        lb2.setEnabled(true);
        lb3.setEnabled(true);
        lb4.setEnabled(true);
        lb5.setEnabled(true);
        lb6.setEnabled(true);
        lb7.setEnabled(true);
        lb8.setEnabled(true);
        lb9.setEnabled(true);
    }

    private void enabeledF() {
        lb1.setEnabled(false);
        lb2.setEnabled(false);
        lb3.setEnabled(false);
        lb4.setEnabled(false);
        lb5.setEnabled(false);
        lb6.setEnabled(false);
        lb7.setEnabled(false);
        lb8.setEnabled(false);
        lb9.setEnabled(false);
    }

    private void clrLb() {
        lb1.setText("");
        lb2.setText("");
        lb3.setText("");
        lb4.setText("");
        lb5.setText("");
        lb6.setText("");
        lb7.setText("");
        lb8.setText("");
        lb9.setText("");
    }

    private void iniup() {
        try {
            Class.forName(drv);
            conp = DriverManager.getConnection(conurl, "root", mspass);
            stp = conp.createStatement();
        } catch (Exception ex) {
            System.out.println("iniup");
        }
    }

    private void showMN() {

    }

    private void showMNL() {

    }

    private void wWon() {
        enabeledF();
        showMN();
        try {
            rsp.close();
            stp.close();
            conp.close();
        } catch (Exception ex) {
        }

        new MsWon().setVisible(true);
        this.dispose();
        thre.stop();
    }

    private void lLost() {
        enabeledF();
        showMNL();
        try {
            rsp.close();
            stp.close();
            conp.close();
        } catch (Exception ex) {
        }
        new MsLost().setVisible(true);
        this.dispose();
        thre.stop();
    }

    private void tTie() {
        enabeledF();
        // showMNL();
        try {
            rsp.close();
            stp.close();
            conp.close();
        } catch (Exception ex) {
        }
        new MsTie().setVisible(true);
        this.dispose();
        thre.stop();
    }

    Connection conp = null;
    ResultSet rsp = null;
    Statement stp = null;

    private void updateState() {
        try {
            String qry = "Select c1,c2,c3,c4,c5,c6,c7,c8,c9,turn,st1,st2 from zcxz where name='" + rname.getText()
                    + "';";
            rsp = stp.executeQuery(qry);
            rsp.next();
            String c1 = rsp.getString(1), c2 = rsp.getString(2), c3 = rsp.getString(3), c4 = rsp.getString(4),
                    c5 = rsp.getString(5), c6 = rsp.getString(6), c7 = rsp.getString(7), c8 = rsp.getString(8),
                    c9 = rsp.getString(9);
            int state = 1;
            // thre2.tt=rs.getInt(10);
            tc.setText(rsp.getInt(10) + "");
            /*
             * if(uprog.getValue()==0)
             * {
             * trn.setText("2");
             * }
             */
            if (Integer.parseInt(trn.getText()) == 1) {
                state = rsp.getInt(12);// other's state
            } else if (Integer.parseInt(trn.getText()) == 2) {
                state = rsp.getInt(11);
            }
            if (state == 0) {
                JOptionPane.showMessageDialog(this, "your opponient left the game!!");
                wWon();
            }
            if (rsp.getInt(10) == Integer.parseInt(trn.getText())) {
                ul.setVisible(true);
                ol.setVisible(false);
            } else {
                ol.setVisible(true);
                ul.setVisible(false);
            }
            if (!c1.isEmpty()) {
                lb1.setText(c1);
            }
            if (!c2.isEmpty()) {
                lb2.setText(c2);
            }
            if (!c3.isEmpty()) {
                lb3.setText(c3);
            }
            if (!c4.isEmpty()) {
                lb4.setText(c4);
            }
            if (!c5.isEmpty()) {
                lb5.setText(c5);
            }
            if (!c6.isEmpty()) {
                lb6.setText(c6);
            }
            if (!c7.isEmpty()) {
                lb7.setText(c7);
            }
            if (!c8.isEmpty()) {
                lb8.setText(c8);
            }
            if (!c9.isEmpty()) {
                lb9.setText(c9);
            }
            System.out.println("update 1" + trn.getText());
            chk();
        } catch (Exception ex) {
            if (errhandler > 8 || ex.getMessage().equals(
                    "com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException: Data source rejected establishment of connection,  message from server: \"Too many connections\"")) {
                JOptionPane.showMessageDialog(this, "Oop! Connection Lost");
                wWon();
            }
            errhandler++;
            System.out.println(ex + "update");
        }
    }

    private void insDb(MouseEvent evt) {
        ResultSet rs = null;
        Statement st = null;
        if (((JLabel) evt.getSource()).getText().isEmpty()) {
            try {
                Class.forName(drv);
                st = conp.createStatement();
                // String qry="Insert into
                // zcxz(name,turn,tu2,st1,st2,sym1,sym2"+((JLabel)evt.getSource()).getText()
                // +") values("+u1.getText()+"',"+Math.random()*100000+");";
                String qry = "";
                String qryy = "Select turn from zcxz where name='" + rname.getText() + "';";
                rs = st.executeQuery(qryy);
                rs.next();
                int ct = rs.getInt(1);
                System.out.println("1");
                if (Integer.parseInt(trn.getText()) > 1) {
                    qry = "update zcxz set " + ((JLabel) evt.getSource()).getName() + " = '" + symbl.getText()
                            + "' , turn=" + 1 + " where name='" + rname.getText() + "';";
                } else {
                    qry = "update zcxz set " + ((JLabel) evt.getSource()).getName() + " = '" + symbl.getText()
                            + "' ,turn=" + 2 + " where name='" + rname.getText() + "';";
                }
                // String qr="update zcxz turn = "+trn.getText()
                // + " where name = '"+rname.getText()+"';";
                synchronized (this) {
                    System.out.println("2");
                    if (ct == Integer.parseInt(trn.getText())) {
                        System.out.println("3");
                        // int ii=st.executeUpdate(qr);
                        int iii = st.executeUpdate(qry);
                        System.out.println("4");
                        ((JLabel) evt.getSource()).setText(symbl.getText());
                        ul.setVisible(false);
                        ol.setVisible(true);
                    }
                    System.out.println("5");
                    rs.close();
                    st.close();
                    chk();
                }

            } catch (Exception ex) {
                System.out.println(ex + " insDb");
            }
        }
    }

    @Override
    public void run() {
        for (; true;) {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZeroCross.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateState();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        lb9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cplayer = new javax.swing.JLabel();
        symbl = new javax.swing.JLabel();
        ul = new javax.swing.JLabel();
        uprog = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        cc = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        oplayer = new javax.swing.JLabel();
        symbl1 = new javax.swing.JLabel();
        ol = new javax.swing.JLabel();
        oprog = new javax.swing.JProgressBar();
        oo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        trn = new javax.swing.JLabel();
        rname = new javax.swing.JLabel();
        tc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lb1.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("X");
        lb1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 51)));
        lb1.setName("c1"); // NOI18N
        lb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb1MouseClicked(evt);
            }
        });

        lb2.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setText("O");
        lb2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 51)));
        lb2.setName("c2"); // NOI18N
        lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2MouseClicked(evt);
            }
        });

        lb3.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("X");
        lb3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 51)));
        lb3.setName("c3"); // NOI18N
        lb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb3MouseClicked(evt);
            }
        });

        lb4.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4.setText("O");
        lb4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 51)));
        lb4.setName("c4"); // NOI18N
        lb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb4MouseClicked(evt);
            }
        });

        lb5.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb5.setText("X");
        lb5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 51)));
        lb5.setName("c5"); // NOI18N
        lb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb5MouseClicked(evt);
            }
        });

        lb6.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
        lb6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb6.setText("O");
        lb6.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 51)));
        lb6.setName("c6"); // NOI18N
        lb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb6MouseClicked(evt);
            }
        });

        lb7.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
        lb7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb7.setText("X");
        lb7.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 51)));
        lb7.setName("c7"); // NOI18N
        lb7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb7MouseClicked(evt);
            }
        });

        lb8.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
        lb8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb8.setText("O");
        lb8.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 51)));
        lb8.setName("c8"); // NOI18N
        lb8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb8MouseClicked(evt);
            }
        });

        lb9.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
        lb9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb9.setText("X");
        lb9.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 51)));
        lb9.setName("c9"); // NOI18N
        lb9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lb8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lb9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        cplayer.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        cplayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cplayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/O1.png"))); // NOI18N
        cplayer.setText("ap");
        cplayer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 0, 0);
        jPanel3.add(cplayer, gridBagConstraints);

        symbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        symbl.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = -16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 19, 0);
        jPanel3.add(symbl, gridBagConstraints);

        ul.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/TTRN.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 20, 0, 20);
        jPanel3.add(ul, gridBagConstraints);

        uprog.setMaximum(200);
        uprog.setValue(200);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jPanel3.add(uprog, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Leave/Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 50, 0, 0);
        jPanel3.add(jButton1, gridBagConstraints);

        cc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cc.setForeground(new java.awt.Color(255, 255, 255));
        cc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cc.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 20, 0, 0);
        jPanel3.add(cc, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        oplayer.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        oplayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oplayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/x2.png"))); // NOI18N
        oplayer.setText("nk");
        oplayer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 0, 0);
        jPanel2.add(oplayer, gridBagConstraints);

        symbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        symbl1.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = -16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 19, 0);
        jPanel2.add(symbl1, gridBagConstraints);

        ol.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/optrn.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 41;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 10, 0, 0);
        jPanel2.add(ol, gridBagConstraints);

        oprog.setMaximum(200);
        oprog.setValue(200);
        oprog.setPreferredSize(new java.awt.Dimension(14, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 53, 0, 0);
        jPanel2.add(oprog, gridBagConstraints);

        oo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        oo.setForeground(new java.awt.Color(255, 255, 255));
        oo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oo.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 50, 0, 0);
        jPanel2.add(oo, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Snap ITC", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Zero-Cross");

        trn.setText("1");

        rname.setText("appp");

        tc.setText("1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tc)
                        .addGap(169, 169, 169)
                        .addComponent(rname, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(trn, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(trn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rname, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 24, 13, 12);
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb1MouseClicked
        insDb(evt);
    }// GEN-LAST:event_lb1MouseClicked

    private void lb2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb2MouseClicked
        insDb(evt);
    }// GEN-LAST:event_lb2MouseClicked

    private void lb3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb3MouseClicked
        insDb(evt);
    }// GEN-LAST:event_lb3MouseClicked

    private void lb4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb4MouseClicked
        insDb(evt);
    }// GEN-LAST:event_lb4MouseClicked

    private void lb5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb5MouseClicked
        insDb(evt);
    }// GEN-LAST:event_lb5MouseClicked

    private void lb6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb6MouseClicked
        insDb(evt);
    }// GEN-LAST:event_lb6MouseClicked

    private void lb7MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb7MouseClicked
        insDb(evt);
    }// GEN-LAST:event_lb7MouseClicked

    private void lb8MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb8MouseClicked
        insDb(evt);
    }// GEN-LAST:event_lb8MouseClicked

    private void lb9MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb9MouseClicked
        insDb(evt);
    }// GEN-LAST:event_lb9MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        ResultSet rs = null;
        Statement st = null;
        try {
            Class.forName(drv);
            st = conp.createStatement();
            String qry = "";
            System.out.println("lv 1");
            if (Integer.parseInt(trn.getText()) > 1) {
                qry = "update zcxz set st" + 2 + "=0 where name='" + rname.getText() + "';";
            } else {
                qry = "update zcxz set st1=0 where name='" + rname.getText() + "';";
            }
            synchronized (this) {
                System.out.println("lv 2");
                int iii = st.executeUpdate(qry);
                System.out.println("5");
                st.close();
                conp.close();
                lLost();
            }
        } catch (Exception ex) {
            System.out.println(ex + " leave");
        }
    }// GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ZeroCross.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZeroCross.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZeroCross.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZeroCross.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZeroCross("ppnk", "cu", "op", "X", 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cc;
    private javax.swing.JLabel cplayer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    private javax.swing.JLabel ol;
    private javax.swing.JLabel oo;
    private javax.swing.JLabel oplayer;
    public static javax.swing.JProgressBar oprog;
    private javax.swing.JLabel rname;
    private javax.swing.JLabel symbl;
    private javax.swing.JLabel symbl1;
    private javax.swing.JLabel tc;
    private javax.swing.JLabel trn;
    private javax.swing.JLabel ul;
    public static javax.swing.JProgressBar uprog;
    // End of variables declaration//GEN-END:variables
}
