/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChitChat;

import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NKC
 */
public class LogiN extends javax.swing.JFrame {
    // ss1 current user name
    static final String dbnm="chatdb",mspass="";
    String drv="com.mysql.cj.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+dbnm;
    String coninurl="jdbc:mysql://localhost:3306/";
    int h= Toolkit.getDefaultToolkit().getScreenSize().height;
    int w= Toolkit.getDefaultToolkit().getScreenSize().width;
    public LogiN() {
        initComponents();
        this.setBounds(0, 0, w, h);
        iniup();
        if((int)(Math.random()*12)<=4)
        {
        chatimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/imagig/nn"+1+".gif")));
        }else
        {
        chatimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/imagig/nn"+2+".jpg")));
        }
        ifTb();
    }
 
 Connection con=null;
 
    private void iniup() {
      try{
      Class.forName(drv);
      con=DriverManager.getConnection(conurl, "root", mspass);
      }
      catch(Exception ex )
      {
          System.out.println("iniup");
      }
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        signincolumn = new javax.swing.JPanel();
        apptitle = new javax.swing.JPanel();
        chitchatimage = new javax.swing.JLabel();
        signinholder = new javax.swing.JPanel();
        username_signin = new javax.swing.JLabel();
        unf = new javax.swing.JTextField();
        pass_signin = new javax.swing.JLabel();
        passf = new javax.swing.JPasswordField();
        signinb = new javax.swing.JButton();
        erdp = new javax.swing.JLabel();
        signupcolumn = new javax.swing.JPanel();
        visiboard = new javax.swing.JPanel();
        chatimgholder = new javax.swing.JPanel();
        chatimage = new javax.swing.JLabel();
        snpboard = new javax.swing.JPanel();
        signuptitle = new javax.swing.JButton();
        user_name = new javax.swing.JLabel();
        sun = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        spa = new javax.swing.JPasswordField();
        sup = new javax.swing.JButton();
        dspdu = new javax.swing.JLabel();
        conditins = new javax.swing.JCheckBox();
        ageee = new javax.swing.JLabel();
        agee = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        signincolumn.setBackground(new java.awt.Color(26, 117, 188));

        apptitle.setLayout(new java.awt.GridLayout(1, 1));

        chitchatimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/imagig/down.png"))); // NOI18N
        apptitle.add(chitchatimage);

        signinholder.setOpaque(false);

        username_signin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username_signin.setForeground(new java.awt.Color(255, 255, 255));
        username_signin.setText("User Name ");

        pass_signin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pass_signin.setForeground(new java.awt.Color(255, 255, 255));
        pass_signin.setText("Password");

        signinb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        signinb.setText("Sign In");
        signinb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinbActionPerformed(evt);
            }
        });

        erdp.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        erdp.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout signinholderLayout = new javax.swing.GroupLayout(signinholder);
        signinholder.setLayout(signinholderLayout);
        signinholderLayout.setHorizontalGroup(
            signinholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signinholderLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(username_signin)
                .addGap(10, 10, 10)
                .addGroup(signinholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signinholderLayout.createSequentialGroup()
                        .addComponent(unf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(pass_signin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(signinb, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(erdp, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signinholderLayout.setVerticalGroup(
            signinholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signinholderLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(signinholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_signin)
                    .addComponent(unf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass_signin)
                    .addComponent(passf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signinb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erdp, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout signincolumnLayout = new javax.swing.GroupLayout(signincolumn);
        signincolumn.setLayout(signincolumnLayout);
        signincolumnLayout.setHorizontalGroup(
            signincolumnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signincolumnLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(apptitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signinholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        signincolumnLayout.setVerticalGroup(
            signincolumnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signincolumnLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(apptitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(signincolumnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signinholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        signupcolumn.setBackground(new java.awt.Color(255, 255, 255));
        signupcolumn.setLayout(new java.awt.GridBagLayout());

        visiboard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        visiboard.setLayout(new java.awt.BorderLayout(1, 1));
        signupcolumn.add(visiboard, new java.awt.GridBagConstraints());

        chatimgholder.setOpaque(false);
        chatimgholder.setLayout(new java.awt.GridBagLayout());

        chatimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/imagig/nn2.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 46, 12);
        chatimgholder.add(chatimage, gridBagConstraints);

        snpboard.setBackground(new java.awt.Color(255, 255, 255));

        signuptitle.setBackground(new java.awt.Color(0, 51, 51));
        signuptitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        signuptitle.setForeground(new java.awt.Color(255, 255, 255));
        signuptitle.setText("Sign Up");
        signuptitle.setBorder(null);
        signuptitle.setBorderPainted(false);
        signuptitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        signuptitle.setDefaultCapable(false);
        signuptitle.setFocusPainted(false);
        signuptitle.setFocusable(false);
        signuptitle.setRequestFocusEnabled(false);
        signuptitle.setRolloverEnabled(false);

        user_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_name.setText("User Name ");

        sun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunActionPerformed(evt);
            }
        });

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setText("Password");

        sup.setText("Sign Up");
        sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supActionPerformed(evt);
            }
        });

        dspdu.setForeground(new java.awt.Color(255, 0, 0));
        dspdu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        conditins.setText("I agree all terms and conditions .");

        ageee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ageee.setText("Age       ");

        agee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout snpboardLayout = new javax.swing.GroupLayout(snpboard);
        snpboard.setLayout(snpboardLayout);
        snpboardLayout.setHorizontalGroup(
            snpboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signuptitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(snpboardLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(snpboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(snpboardLayout.createSequentialGroup()
                        .addComponent(sup, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, snpboardLayout.createSequentialGroup()
                        .addGroup(snpboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, snpboardLayout.createSequentialGroup()
                                .addGroup(snpboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(password)
                                    .addComponent(ageee))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(snpboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(snpboardLayout.createSequentialGroup()
                                .addComponent(user_name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                                .addComponent(sun, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60))
                    .addGroup(snpboardLayout.createSequentialGroup()
                        .addComponent(conditins)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(dspdu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        snpboardLayout.setVerticalGroup(
            snpboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(snpboardLayout.createSequentialGroup()
                .addComponent(signuptitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(snpboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user_name))
                .addGap(18, 18, 18)
                .addGroup(snpboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password))
                .addGap(18, 18, 18)
                .addGroup(snpboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dspdu, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(conditins)
                .addGap(26, 26, 26)
                .addComponent(sup)
                .addGap(73, 73, 73))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        chatimgholder.add(snpboard, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(138, 7, 0, 0);
        chatimgholder.add(filler2, gridBagConstraints);

        signupcolumn.add(chatimgholder, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signincolumn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(signupcolumn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(signincolumn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupcolumn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supActionPerformed
ResultSet rs=null;
Statement st=null,st2=null;
String pa=new String(spa.getPassword());
if(conditins.isSelected()&&(!sun.getText().equals(""))&&(!pa.equals("")))
{
        try
{
Class.forName(drv);
st=con.createStatement();
ss1=sun.getText();
String qry="insert into uspa values('"+sun.getText()+"','"+pa+"');";
String qry2="insert into actv values('"+sun.getText()+"',"+"0"+");";
int ii=st.executeUpdate(qry);
int iiit=st.executeUpdate(qry2);
sun.setText("");
spa.setText("");
agee.setText("");
conditins.setSelected(false);
crReqTable();
usFrndTable();
crtTb();
usGrpTable();
dspdu.setText("");
JOptionPane.showMessageDialog(this, "!!You are successfully resistered!!","Sign Up",1);
}   
catch(Exception ex )
{
    System.out.println(ex +"sign up");
    dspdu.setText("user name already resistered");
}
}
else
{
    JOptionPane.showMessageDialog(this, "enter the necessary fields"
            + " and accept the tems and conditions before proceeding");
}
    }//GEN-LAST:event_supActionPerformed
String ss1,ss2;
    private void signinbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinbActionPerformed
ResultSet rs=null;
Statement st=null,st2=null;
String pa=new String(passf.getPassword());
//unf,passf
try
{
Class.forName(drv);
st=con.createStatement();
String qry="select * from uspa where usname='"+unf.getText()+"';";
String qry2="update actv set state = 1 where usname='"+unf.getText()+"';";
System.out.println("*");
rs=st.executeQuery(qry);
System.out.println("**");
passf.setText("");
//
System.out.println("__");
if(rs.next() && (rs.getString(2)).equals(pa))//&& (rs.getString(2)).equals(pa))
{
    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+pa);
    System.out.println("|||");
    new Cfm(rs.getString(1)).setVisible(true);
    int ini=st.executeUpdate(qry2);
    rs.close();
    con.close();
    this.setVisible(false);
}
else
{
    System.out.println("%");
    erdp.setText("* Incorrect Password !");
     rs.close();
     System.out.println("&&");
}
}   
catch(Exception ex )
{
    System.out.println(ex+" sign in");
    erdp.setText("* No User Found !");
}
    }//GEN-LAST:event_signinbActionPerformed

    private void sunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sunActionPerformed

    private void ageeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageeActionPerformed
private void ifTb(){
ResultSet rs=null;
Statement st=null,st2=null;
try
{
Class.forName(drv);
st=con.createStatement();
String qry="select * from uspa";
rs=st.executeQuery(qry);
}   
catch(Exception ex)
{
    //System.out.println(ex);
    try{
    Class.forName(drv);
    con=DriverManager.getConnection(coninurl, "root", mspass);
    st=con.createStatement();
    String qry="create database "+dbnm;
    int izxi=st.executeUpdate(qry);
    con.close();
    con=DriverManager.getConnection(conurl, "root", mspass);
    st=con.createStatement();
    String qry2="create table uspa (usname varchar(20) unique,pass varchar(15));";
    String qryz="create table zcxz (name varchar(20) unique,c1 varchar(1),c2 varchar(1),c3 varchar(1),"
            + "c4 varchar(1),c5 varchar(1),c6 varchar(1),c7 varchar(1),c8 varchar(1),c9 varchar(1),"
            + "turn int,tu2 int,st1 int ,st2 int,sym1 char(1),sym2 char(1));";
    String qry3="create table actv (usname varchar(20) unique,state varchar(15));";
    String qryt="create table turntl (name varchar(20) unique,c1 varchar(15),c2 varchar(15),c3 varchar(15),"
            + "c4 varchar(15),c5 varchar(15),c6 varchar(15),c7 varchar(15),c8 varchar(15),c9 varchar(15),"
            + "c10 varchar(15),c11 varchar(15),c12 varchar(15),c13 varchar(15),c14 varchar(15),c15 varchar(15),c16 varchar(16),"
            + "turn int,tu2 int,st1 int ,st2 int,scr1 int,scr2 int,s1 int,s2 int,s3 int,s4 int,s5 int,s6 int,"
            + "s7 int,s8 int,s9 int,s10 int,s11 int,s12 int,s13 int,s14 int,s15 int,s16 int);";
    int iii=st.executeUpdate(qry2);
    int ivi=st.executeUpdate(qry3);
    int ivvi=st.executeUpdate(qryz);
    int ivvvi=st.executeUpdate(qryt);
    }
    catch(Exception ee)
    {
        System.out.println(ee+" iftb");
    }
  }
}
private void crtTb() {
ResultSet rs=null;
Statement st=null,st2=null;
try
{
Class.forName(drv);
st=con.createStatement();
st2=con.createStatement();
String qry1="select * from uspa;";
String qr2="select Count(*) from uspa;";
rs=st.executeQuery(qr2);
rs.next();
int nr=rs.getInt(1);
rs=st.executeQuery(qry1);
rs.next();
for(int in=1;nr>=in;in++)
{
    ss2=rs.getString(1);
    String qry="";
    if(ss1.compareTo(ss2)>0)
    {
       qry="create table "+ss2+ss1+" (name varchar(20) ,msg varchar(200),"+
               ss2+"rd int,"+ss1+"rd int,"+
               ss2+"pl int,"+ss1+"pl int);";
    }
    else if(ss1.equals(ss2))
    {
        continue;
    }
    else
    {
        qry="create table "+ss1+ss2+" (name varchar(20) ,msg varchar(200),"+
               ss1+"rd int,"+ss2+"rd int,"+
               ss1+"pl int,"+ss2+"pl int);";
    }
           int ii=st2.executeUpdate(qry);
    rs.next();
}
    rs.close();

}   
catch(Exception ex)
{
    System.out.println(ex+" crtb");
    try {
        rs.close();
         st.close();
    } catch (SQLException ex1) {
        Logger.getLogger(LogiN.class.getName()).log(Level.SEVERE, null, ex1);
    }
}
    }
    
private void crReqTable() {
ResultSet rs=null;
Statement st=null,st2=null;
        try{
      Class.forName(drv);
      st=con.createStatement();
      String qry="create table "+ss1+"rfr"+" ( name varchar(20) unique,garbage int);";
      int ii=st.executeUpdate(qry);
     }
     catch(Exception ex)
     {
         System.out.println(ex +" creq");
     }
    }
    private void usFrndTable() {
        ResultSet rs=null;
        Statement st=null,st2=null;
      try{
      Class.forName(drv);
      st=con.createStatement();
      String qry="create table "+ss1+"ufr"+" (name varchar(20) unique,garbage int);";
      int ii=st.executeUpdate(qry);
     }
     catch(Exception ex)
     {
         System.out.println(ex+"usfriend");
     }
    }
    private void usGrpTable() {
        ResultSet rs=null;
        Statement st=null,st2=null;
     try{
      Class.forName(drv);
      st=con.createStatement();
      String qry="create table "+ss1+"grp"+" (name varchar(20) unique,garbage int);";
      int ii=st.executeUpdate(qry);
     }
     catch(Exception ex)
     {
         System.out.println(ex+"usgroup");
     }
    }
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
            java.util.logging.Logger.getLogger(LogiN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogiN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogiN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogiN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogiN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agee;
    private javax.swing.JLabel ageee;
    private javax.swing.JPanel apptitle;
    private javax.swing.JLabel chatimage;
    private javax.swing.JPanel chatimgholder;
    private javax.swing.JLabel chitchatimage;
    private javax.swing.JCheckBox conditins;
    private javax.swing.JLabel dspdu;
    private javax.swing.JLabel erdp;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel pass_signin;
    private javax.swing.JPasswordField passf;
    private javax.swing.JLabel password;
    private javax.swing.JButton signinb;
    private javax.swing.JPanel signincolumn;
    private javax.swing.JPanel signinholder;
    private javax.swing.JPanel signupcolumn;
    private javax.swing.JButton signuptitle;
    private javax.swing.JPanel snpboard;
    private javax.swing.JPasswordField spa;
    private javax.swing.JTextField sun;
    private javax.swing.JButton sup;
    private javax.swing.JTextField unf;
    private javax.swing.JLabel user_name;
    private javax.swing.JLabel username_signin;
    private javax.swing.JPanel visiboard;
    // End of variables declaration//GEN-END:variables
}
