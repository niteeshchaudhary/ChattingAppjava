/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChitChat;


import com.sun.javafx.tk.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Niteesh
 */
public class Level1 extends javax.swing.JFrame implements Runnable{
int ev=0;
//static int xn;
static int xn=16; /* xn  = no. of tiles required in even no.*/
int ct=xn;
Btn tT1;
int tn=10;/* tn  = no. of types of tiles required + 1  */
String drv="com.mysql.cj.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
String mspass=LogiN.mspass;
Connection conp=null;
Statement stp=null,st;
ResultSet rsp=null,rs=null;
Thread tth;
public Level1(String ss,String cu,String op,int tr) {
        initComponents();
      jPanel3.setVisible(false);
      chnce.setVisible(false);
      rname.setVisible(false);
      tc.setVisible(false);
      trn.setVisible(false);
       cplayer.setText((cu.charAt(0)+"").toUpperCase());
        oplayer.setText((op.charAt(0)+"").toUpperCase());
        oo.setText(op);
        cc.setText(cu);
        ul.setVisible(false);
        ul.setVisible(true);
        trn.setText(tr+"");
       iniup();
       addb();
       if(tr==1)
       {rand();}
       else
       {takeDb();
       enabeledF();}
       ifTb(); 
       tth=new Thread(this);
       tth.start();
    }
int ssru=0,ssro=0;
public void check(int ev,Btn tN) 
    {
        if(ev==1)
        { 
           tT1=tN;
        }
      
        ImageIcon im= (ImageIcon) tT1.getIcon();
         if(ev==2 && tN==tT1)
            {
              ev=0;   
              tT1.setIcon(null);
              insDb("","");
              enabeledF();
              tT1.setBackground(Color.BLUE);
              tN.setBackground(Color.BLUE);
            }
        // tT1.setVisible(false);
        if(ev==2)
        {
           ImageIcon im2= (ImageIcon) tN.getIcon();
               if(im.getImage()==im2.getImage() && tN!=tT1)
               {
                   try
         {
             Thread.sleep(500);
         }
         catch(Exception ex)
         {
             
         }
                   tT1.setVisible(false);
                   tN.setVisible(false);
                   ssru+=20;
                   scoru.setText(ssru+"");
                   insDb(tT1.getActionCommand(),tN.getActionCommand());
                   enabeledF();//remove for 2 chance
                   ct=ct-2;
                   llb5.setText(ct+"");
               }
               else
               {
                     try
         {
             Thread.sleep(800);
         }
         catch(Exception ex)
         {
             
         }
                   tT1.setIcon(null);
                   tN.setIcon(null);
                   insDb("","");
                   enabeledF();
                   tT1.setBackground(Color.BLUE);
                   tN.setBackground(Color.BLUE);
               }
               
        }      
    }

void act1(ActionEvent evt) {
     Btn tm=(Btn) evt.getSource();
      ev++;
      if(ev==1)
      {
          tm.setIcon(tm.getPressedIcon());
          tm.setBackground(Color.LIGHT_GRAY);
      }
      if(ev==2)
      {
          tm.setIcon(tm.getPressedIcon());
          tm.setBackground(Color.LIGHT_GRAY);
      }
      if(ev>2)
      {
          ev=1;
          for(int i=0;i<xn;i++)
    {
        T[i].setIcon(null);
       tm.setBackground(Color.lightGray);
    }
          tm.setBackground(Color.LIGHT_GRAY);
          tm.setIcon(tm.getPressedIcon());
      }
      check(ev,tm);
 }

private void insDb(String str1,String str2)
{
    // if(((JLabel)evt.getSource()).getText().isEmpty())
    //{
     try{
      Class.forName(drv);
      st=conp.createStatement();
      String qry="";
      String qryy="Select turn from turntl where name='"+rname.getText()+"';";
      rs=st.executeQuery(qryy);
      rs.next();
      int ct=rs.getInt(1);
      System.out.println("1");
      if(!str1.isEmpty()&& !str2.isEmpty())
      {
        if(Integer.parseInt(trn.getText())>1)
        {
            qry="update turntl set s"+str1+" = 0,s"+str2+"=0 , turn="+1+",scr2="+ssru+" where name='"+rname.getText()+"';"; //remove turn for 2 chance
        }
        else
        {
            qry="update turntl set s"+str1+" = 0,s"+str2+"=0 , turn="+2+",scr1="+ssru+" where name='"+rname.getText()+"';"; //remove turn for 2 chance
        }
      }
      else
      {
        if(Integer.parseInt(trn.getText())>1)
        {
            qry="update turntl set  turn="+1+" where name='"+rname.getText()+"';"; 
        }
        else
        {
            qry="update turntl set  turn="+2+" where name='"+rname.getText()+"';"; 
        }  
      }
      synchronized(this)
      {
          System.out.println("2");
          if(ct==Integer.parseInt(trn.getText()))
          {
              System.out.println("3");
      //int ii=st.executeUpdate(qr);
      int iii=st.executeUpdate(qry);
              System.out.println("4");
     // ((JLabel)evt.getSource()).setText(symbl.getText());
      ul.setVisible(false);
      ol.setVisible(true);
          }
          System.out.println("5");
          rs.close();
          st.close();
      }
     }
     catch(Exception ex)
     {
         System.out.println(ex+" insDb");
     }
    //}
}      
    Btn T[]=new Btn[xn];
    //int chance=0;
public void addb()
{
    int j=0,ti=0,lm=30,tm=30;
     
    for(int i=0;i<xn;i++)
    {
    T[i]=new Btn();
    T[i].setSize(85, 80);
    T[i].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                act1(evt);
            }
        });
    Br1.add(T[i]);
    }
}
int ij[]=new int[xn];
      Date dt= new Date();
       long ln=0;
/* for n - tiles*/
int[] temp=new int[tn-1];
public void rand()
    {  
       ln=dt.getTime();
       Tim1.setText(ln+"");
        for(int j=0;j<xn;j++)
        {
          ij[j]=0;
        }
        int j=0;
        
        while(j<xn)
        {
        double ran=(10*Math.random()-1);
        int ra=(int)(ran);
       
        ra++;
        try
        {
        ij[j]=ra;
        }
        catch(Exception ex)
        {
            System.out.print(" ex1 ");
            break;
        }
        j++;
        }
        int[] cont=new int[tn];
        int[] con=new int[tn];
        int cci;
        
       for(int jk=0;jk<xn;jk++)
        {
               for(cci=tn+1;cci>0;cci--)
               {
                     if(ij[jk]%cci==0 && ij[jk]/cci==1)
                    {
                        cont[cci]++;
                        con[cci]=jk;  
                     }
                }
        }
               for(cci=tn-1;cci>1;cci--)
               {
                   for(int t=1;t<cci;t++)
                   {
                   if(cont[cci]%2==1 && cont[cci-t]%2==1)
                     {
                         ij[con[cci-t]]=cci;
                         cont[cci-t]--;
                         cont[cci]++;
                      }
                   }
               }
        for(int i=0;i<xn;i++)
        {
          //T[i].setText(ij[i]+""); 
           try
            {
                T[i].setPressedIcon(new ImageIcon(getClass().getResource("/ChitChat/bigemoj/a$$$$$1"+ij[i]+".png")));
                T[i].setActionCommand(ij[i]+"");//"a$$$$$1"+ij[i]+".png");
            }
           catch(Exception ex)
            {
                System.out.print("  ex2 "); 
                break;       
            }
       
        }    
  
    }
public  void los()
    {
        ls();
    }
    public void ls()
    {
        for(int i=0;i<xn;i++)
           {
               T[i].setEnabled(false);
           }
    }
   
    public void null2()
    {
          for(int i=0;i<xn;i++)
           {
               T[i].setIcon(null);
           }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cplayer = new javax.swing.JLabel();
        symbl = new javax.swing.JLabel();
        ul = new javax.swing.JLabel();
        uprog = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        cc = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        scoru = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        oplayer = new javax.swing.JLabel();
        ol = new javax.swing.JLabel();
        oprog = new javax.swing.JProgressBar();
        oo = new javax.swing.JLabel();
        scoro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        llb5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        chnce = new javax.swing.JLabel();
        trn = new javax.swing.JLabel();
        rname = new javax.swing.JLabel();
        tc = new javax.swing.JLabel();
        symbl1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Br1 = new javax.swing.JPanel();
        Tim1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(260, 662));
        java.awt.GridBagLayout jPanel5Layout = new java.awt.GridBagLayout();
        jPanel5Layout.rowWeights = new double[] {0.4, 0.2, 0.1, 0.1, 0.1, 0.1};
        jPanel5.setLayout(jPanel5Layout);

        cplayer.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        cplayer.setForeground(new java.awt.Color(255, 255, 255));
        cplayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cplayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ttu.png"))); // NOI18N
        cplayer.setText("ap");
        cplayer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 17, 0, 0);
        jPanel5.add(cplayer, gridBagConstraints);

        symbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        symbl.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = -16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 77, 0);
        jPanel5.add(symbl, gridBagConstraints);

        ul.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/TTRN.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 20, 0, 0);
        jPanel5.add(ul, gridBagConstraints);

        uprog.setMaximum(200);
        uprog.setValue(200);
        uprog.setMaximumSize(new java.awt.Dimension(327, 14));
        uprog.setPreferredSize(new java.awt.Dimension(18, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel5.add(uprog, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Leave/Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(62, 50, 0, 0);
        jPanel5.add(jButton1, gridBagConstraints);

        cc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cc.setForeground(new java.awt.Color(255, 255, 255));
        cc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cc.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 20, 0, 0);
        jPanel5.add(cc, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Score :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jPanel5.add(jLabel4, gridBagConstraints);

        scoru.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        scoru.setForeground(new java.awt.Color(255, 255, 255));
        scoru.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        scoru.setText("0000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 0, 0);
        jPanel5.add(scoru, gridBagConstraints);

        jPanel4.add(jPanel5, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        oplayer.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        oplayer.setForeground(new java.awt.Color(255, 255, 255));
        oplayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oplayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/tto.png"))); // NOI18N
        oplayer.setText("nk");
        oplayer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 51, 0, 0);
        jPanel2.add(oplayer, gridBagConstraints);

        ol.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/optrn.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(48, 12, 0, 0);
        jPanel2.add(ol, gridBagConstraints);

        oprog.setMaximum(200);
        oprog.setValue(200);
        oprog.setPreferredSize(new java.awt.Dimension(18, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 43, 0, 0);
        jPanel2.add(oprog, gridBagConstraints);

        oo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        oo.setForeground(new java.awt.Color(255, 255, 255));
        oo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oo.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 104, 0, 0);
        jPanel2.add(oo, gridBagConstraints);

        scoro.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        scoro.setForeground(new java.awt.Color(255, 255, 255));
        scoro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        scoro.setText("0000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(52, 23, 0, 0);
        jPanel2.add(scoro, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Score :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(52, 62, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setOpaque(false);

        jToggleButton1.setText("Replay");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        llb5.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(llb5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(llb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(170, 170, 170))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = -287;
        gridBagConstraints.ipady = -182;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 7, 0, 12);
        jPanel2.add(jPanel3, gridBagConstraints);

        chnce.setText("0");

        trn.setText("1");

        rname.setText("appp");

        tc.setText("1");

        symbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        symbl1.setText("X");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chnce)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(symbl1)
                .addGap(18, 18, 18)
                .addComponent(rname)
                .addGap(12, 12, 12)
                .addComponent(tc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rname)
                    .addComponent(trn)
                    .addComponent(chnce)
                    .addComponent(tc)
                    .addComponent(symbl1))
                .addGap(0, 0, 0))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(78, 62, 83, 0);
        jPanel2.add(jPanel6, gridBagConstraints);

        jPanel4.add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Snap ITC", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Turn-Tiles");
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);

        Br1.setBackground(new java.awt.Color(255, 255, 255));
        Br1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Br1.setPreferredSize(new java.awt.Dimension(500, 400));
        Br1.setLayout(new java.awt.GridLayout(1, 0, 1, 1));
        jPanel1.add(Br1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel1, java.awt.BorderLayout.CENTER);

        Tim1.setBackground(new java.awt.Color(102, 102, 102));
        Tim1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        Tim1.setForeground(new java.awt.Color(255, 255, 255));
        Tim1.setText("3600");
        Tim1.setOpaque(true);
        Tim1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Tim1MouseMoved(evt);
            }
        });
        Tim1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Tim1FocusLost(evt);
            }
        });
        Tim1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Tim1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Tim1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Tim1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try{
            Class.forName(drv);
            // conp=DriverManager.getConnection(conurl, "root", mspass);
            st=conp.createStatement();
            String qry="";
            System.out.println("lv 1");
            if(Integer.parseInt(trn.getText())>1)
            {
                qry="update turntl set st"+2+"=0 where name='"+rname.getText()+"';";
            }
            else
            {
                qry="update turntl set st"+1+"=0 where name='"+rname.getText()+"';";
            }
            synchronized(this)
            {
                System.out.println("lv 2");
                int iii=st.executeUpdate(qry);
                System.out.println("5");
                st.close();
                conp.close();
                kl=1;
                lLost();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex+" leave");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.setVisible(true);
        this.dispose();
        //    thr.rst();
        new Level1("ppnk","cu","op",2).setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void Tim1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Tim1PropertyChange
        /*   if(thr.isAlive() && )
        {

        }
        */   //    else

        if (Double.parseDouble(Tim1.getText())<0)
        {
            ls();

            //           thr.suspend();

            Tim1.setText("0");
        }
        // for(int i=0;i<xn;i++)
        {
            /* if( T[i].isVisible() )
            {
                ct++;
            }*/
        }
        if(ct!=0)
        {
            llb5.setText(ct+"");
        }
        else
        {
            //            thr.suspend();
            Tim1.setText("you won");

        }
    }//GEN-LAST:event_Tim1PropertyChange

    private void Tim1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tim1FocusLost

        /*        if(Tim1.getText()!="" && thr.isAlive()==false)
        {
            Tim1.setText("");
            Tim1.setText("you won");

        }*/
    }//GEN-LAST:event_Tim1FocusLost

    private void Tim1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tim1MouseMoved

    }//GEN-LAST:event_Tim1MouseMoved
  
private void ifTb() {
    ResultSet rs1=null;
    Statement st1=null;
      try{
      Class.forName(drv);
      st1=conp.createStatement();
      //String qry="Insert into zcxz(name,turn,tu2,st1,st2,sym1,sym2"+((JLabel)evt.getSource()).getText()
        //      +") values("+u1.getText()+"',"+Math.random()*100000+");";
      String qry1="select count(*) from turntl where name='"+rname.getText()+"';";
      String qry="";
      String qr=""; 
      rs1=st1.executeQuery(qry1);
      rs1.next();
      System.out.println("if 1");
      if(rs1.getInt(1)>0 && Integer.parseInt(trn.getText())==1)
      {
          System.out.println("if 2");
      qr="update turntl set c1='"+T[0].getActionCommand()+"',"
              + "c2='"+T[1].getActionCommand()+"',"
              + "c3='"+T[2].getActionCommand()+"',"
              + "c4='"+T[3].getActionCommand()+"',"
              + "c5='"+T[4].getActionCommand()+"',"
              + "c6='"+T[5].getActionCommand()+"',"
              + "c7='"+T[6].getActionCommand()+"',"
              + "c8='"+T[7].getActionCommand()+"',"
              + "c9='"+T[8].getActionCommand()+"',"
              + "c10='"+T[9].getActionCommand()+"',"
              + "c11='"+T[10].getActionCommand()+"',"
              + "c12='"+T[11].getActionCommand()+"',"
              + "c13='"+T[12].getActionCommand()+"',"
              + "c14='"+T[13].getActionCommand()+"',"
              + "c15='"+T[14].getActionCommand()+"',"
              + "c16='"+T[15].getActionCommand()+"',"
              + "turn=1,st1=1,st2=2,scr1=0,scr2=0,"
              +"s1=1,s2=1,s3=1,s4=1,s5=1,s6=1,s7=1,s8=1,s9=1,s10=1,s11=1,s12=1,s13=1,s14=1,s15=1,s16=1"
              + " where name='"+rname.getText()+"';";
      int ii=st1.executeUpdate(qr);
      System.out.println("if 3");
      for(int i=0;i<xn;i++)
      {
      T[i].setActionCommand(i+1+"");
      }
      System.out.println("if 4");
      }
      else if(rs1.getInt(1)==0 && Integer.parseInt(trn.getText())==1)
      {
          System.out.println("if 5");
       qr="insert into turntl values('"+rname.getText()+"','"+
               T[0].getActionCommand()+"','"+
               T[1].getActionCommand()+"','"+
               T[2].getActionCommand()+"','"+
               T[3].getActionCommand()+"','"+
               T[4].getActionCommand()+"','"+
               T[5].getActionCommand()+"','"+
               T[6].getActionCommand()+"','"+
               T[7].getActionCommand()+"','"+
               T[8].getActionCommand()+"','"+
               T[9].getActionCommand()+"','"+
               T[10].getActionCommand()+"','"+
               T[11].getActionCommand()+"','"+
               T[12].getActionCommand()+"','"+
               T[13].getActionCommand()+"','"+
               T[14].getActionCommand()+"','"+
               T[15].getActionCommand()+"',1,1,1,1,0,0,1,1,1,1,1,1,"
               + "1,1,1,1,1,1,1,1,1,1);";   
      int ii=st1.executeUpdate(qr);
      System.out.println("if 6");
      for(int i=0;i<xn;i++)
      {
      T[i].setActionCommand(i+1+"");
      }
      }
      
      if(Integer.parseInt(trn.getText())==2)
      {
          for(int i=0;i<xn;i++)
      {
      T[i].setActionCommand(i+1+"");
      }
      }
      qry="update turntl set st"+trn.getText()+"=1 where name='"+rname.getText()+"';"; 
      int iii=st1.executeUpdate(qry);
      rs1.close();
      st1.close();
     }
     catch(Exception ex)
     {
         System.out.println(ex+" iftb");
     }
      
  }



private void enabeledT()
 {
     for(int i=0;i<xn;i++)
           {
               T[i].setEnabled(true);
           }
 }
 private void enabeledF()
 {
     for(int i=0;i<xn;i++)
           {
               T[i].setEnabled(false);
           }
 }
 
  private void iniup() {
      try{
   Class.forName(drv);
      conp=DriverManager.getConnection(conurl, "root", mspass);
      stp=conp.createStatement();
      }
      catch(Exception ex)
      {
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
      kl=1;
      try{
      rsp.close();
      stp.close();
      conp.close();}catch(Exception ex){}
      
      new MsWon().setVisible(true);
     this.dispose();
//      tth.stop();
    }

    private void lLost()  {
      enabeledF();
      showMNL();
      kl=1;
      try{
      rsp.close();
      stp.close();
      conp.close();}catch(Exception ex){}
      new MsLost().setVisible(true);
      this.dispose();
     // tth.stop();
    }
    
    private void tTie() {
       enabeledF();
      //showMNL();
       kl=1;
       try{
      rsp.close();
      stp.close();
      conp.close();}catch(Exception ex){}
      new MsTie().setVisible(true);
      this.dispose();
     //  tth.stop();
    }

 private void takeDb() {
    ResultSet rs1=null;
    Statement st1=null;
      try{
      Class.forName(drv);
      st1=conp.createStatement();
      //String qry1="select count(*) from turntl where name='"+rname.getText()+"';";
      String qry="Select c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,"
              + "c11,c12,c13,c14,c15,c16 from turntl where name='"+rname.getText()+"';";
      System.out.println("tbdb x0");
      rs1=st1.executeQuery(qry);
      rs1.next();
      String sty=rs1.getString(2);
      //System.out.println("tbdb x1");
       for(int i=0;i<xn;i++)
      {
          //System.out.println("tbdb x2 "+i);
          T[i].setPressedIcon(new ImageIcon(getClass().getResource("/ChitChat/bigemoj/a$$$$$1"+rs1.getString(i+1)+".png")));
          T[i].setActionCommand(i+1+"");
          //System.out.println("tbdb x3 "+i);
      }  
       //System.out.println("tbdb x5");
      qry="update turntl set st"+trn.getText()+"=1 where name='"+rname.getText()+"';"; 
      int iii=st1.executeUpdate(qry);
      System.out.println("tbdb x6");
      rs1.close();
      st1.close();
     }
     catch(Exception ex)
     {
         System.out.println(ex+" takeDb");
     }    
 }
@SuppressWarnings("empty-statement")

    private void updateState() {
     try{
      String qry="Select s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,"
              + "s11,s12,s13,s14,s15,s16,turn,st1,st2,scr1,scr2 from turntl where name='"+rname.getText()+"';";
      rsp=stp.executeQuery(qry);
      rsp.next();
      int s1[]={rsp.getInt(1),rsp.getInt(2),rsp.getInt(3),rsp.getInt(4),rsp.getInt(5),
             rsp.getInt(6),rsp.getInt(7),rsp.getInt(8),rsp.getInt(9),rsp.getInt(10),
             rsp.getInt(11),rsp.getInt(12),rsp.getInt(13),rsp.getInt(14),rsp.getInt(15),rsp.getInt(16)};
      int state=1;
     // tth2.tt=rs.getInt(10);
      tc.setText(rsp.getInt(17)+"");
      /*if(uprog.getValue()==0)
      {
        trn.setText("2");
      }*/
      if(Integer.parseInt(trn.getText())==1)
      {
          state=rsp.getInt(19);//other's state
          ssro=rsp.getInt(21);//other's score
      }
      else if(Integer.parseInt(trn.getText())==2)
      {
          state=rsp.getInt(18);
          ssro=rsp.getInt(20);
      }
      scoro.setText(ssro+"");
      if(state==0)
      {
          JOptionPane.showMessageDialog(this, "your opponient left the game!!");
          conp.close();
          wWon();
          kl=1;
      }
      if(rsp.getInt(17)==Integer.parseInt(trn.getText()))
      {
          ul.setVisible(true);
          enabeledT();
          ol.setVisible(false);
      }
      else
      {
          ol.setVisible(true);
          //enabeledF();
          ul.setVisible(false);
      }
      
      for(int i=0;i<xn;i++)
      {
      if(s1[i]==0)
      {
          T[i].setVisible(false);
      }
      }
      System.out.println("update 1"+trn.getText());
      chk();
     }
     catch(Exception ex)
     {
         
         if(errhandler>8)
         {
             JOptionPane.showMessageDialog(this, "Oop! Connection Lost");
             try{conp.close();}catch(Exception exx){}
             wWon();
             errhandler=0;
             kl=1;
         }
         errhandler++;
             System.out.println(ex+"update");
     }
    }
     private void chk() {
        int w=0;
    for(int i=0;i<xn;i++)
    {
     if(T[i].isVisible())
     {
         w=1;
         break;
     }
     w=0;
    }
    if(w==0){
        if(ssru>ssro){
            kl=1;
            wWon();
        }else if(ssru==ssro){
            kl=1;
            tTie();
        }else if(ssru<ssro){
            kl=1;
            lLost();
        }
    }
 }
 int kl=0;
 int errhandler=0;
public void run() {
       for(;kl==0;)
       {
           try {
               Thread.sleep(1200);
           } catch (InterruptedException ex) {
               Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
           }
           updateState();
       }
    }
//static TimeW thr=new TimeW();
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
            java.util.logging.Logger.getLogger(Level1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Level1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Level1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Level1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Level1("ppnk","cu","op",1).setVisible(true);
                //thr.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Br1;
    private javax.swing.JLabel Tim1;
    private javax.swing.JLabel cc;
    private javax.swing.JLabel chnce;
    private javax.swing.JLabel cplayer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel llb5;
    private javax.swing.JLabel ol;
    private javax.swing.JLabel oo;
    private javax.swing.JLabel oplayer;
    private javax.swing.JProgressBar oprog;
    private javax.swing.JLabel rname;
    private javax.swing.JLabel scoro;
    private javax.swing.JLabel scoru;
    private javax.swing.JLabel symbl;
    private javax.swing.JLabel symbl1;
    private javax.swing.JLabel tc;
    private javax.swing.JLabel trn;
    private javax.swing.JLabel ul;
    private javax.swing.JProgressBar uprog;
    // End of variables declaration//GEN-END:variables

}
