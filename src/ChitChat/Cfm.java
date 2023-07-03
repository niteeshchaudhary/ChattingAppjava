package ChitChat;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.*;

/**
 *
 * @author NKC
 */

public class Cfm extends JFrame implements Runnable{

    // ss2 current user name
    int h= Toolkit.getDefaultToolkit().getScreenSize().height;
    int w= Toolkit.getDefaultToolkit().getScreenSize().width;
    String drv="com.mysql.cj.jdbc.Driver",conurl="jdbc:mysql://localhost:3306/"+LogiN.dbnm;
    String mspass=LogiN.mspass;;
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    FrLst frndarr[]=new FrLst[20];
    Jlabel jl[]=new Jlabel[1];
    int cr=0;
    int cnfrn=0;
    int cfreq;
    int error=0,exitc=0;
    public static int kl=0;
    Thread th;
    public Cfm(String st) {
        initComponents();
        hiddenitems.setVisible(false);
        recon.setVisible(false);
        this.setBounds(0, 0, w, h);
        frndls.setVisible(false);
        freqls.setVisible(false);
        act.setVisible(false);
        chnls.setVisible(false);
        frls.setVisible(false);
        chnlsholder.setVisible(false);
        frlsholder.setVisible(false);
        grls.setVisible(false);
        this.setBackground(new Color(255,255,255,250));
        int n=1;
        kl=0;
        ss1=ou.getText();
        ss2=st;
        cu.setText(ss2);
        ou1.setText(ss2);
        freqls.add(new Jmb(), 0);
        iniup();

        try{getActv();}catch(Exception e){System.out.println(e+" "+"iniac"); error++;errhandler();}
        try{frlsList();}catch(Exception e){System.out.println(e+" "+"inifrls");error++;errhandler();}
        try{frndList();}catch(Exception e){System.out.println(e+" "+"inifrnd");error++;errhandler();}
        try{grpList();}catch(Exception e){System.out.println(e+" "+"inigrplist");error++;errhandler();}
        try{loadFreq();}catch(Exception e){System.out.println(e+" "+"inilfreq");error++;errhandler();}
        try{loadSuggestions();}catch(Exception e){System.out.println(e+" "+"inisugg");error++;errhandler();}
        ou1.setText(cu.getText());
        frls.setSelectedIndex(0);
        loadMsg();
        for(int i=0;i<n;i++)
        {
         jl[i]=new Jlabel();
         jl[i].setText("");
         jl[i].setEditable(false);
         chboard.add(jl[i],0);
        }
        frlsholder.setVisible(false);
        frls.setVisible(false);
        msb.setText("");
        th= new Thread(this);
        th.start();
        System.out.println("at last");
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lsts = new javax.swing.ButtonGroup();
        outerframe = new javax.swing.JTabbedPane();
        innerframe = new javax.swing.JTabbedPane();
        chatpane = new javax.swing.JPanel();
        chatscreenholder = new javax.swing.JPanel();
        holder = new javax.swing.JScrollPane();
        chboard = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        ou = new javax.swing.JLabel();
        ou1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        snb = new javax.swing.JButton();
        clr = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        msb = new javax.swing.JTextArea();
        emojiscroller = new javax.swing.JScrollPane();
        emojiholder = new javax.swing.JPanel();
        a$$$$$1 = new javax.swing.JButton();
        a$$$$$2 = new javax.swing.JButton();
        a$$$$$3 = new javax.swing.JButton();
        a$$$$$4 = new javax.swing.JButton();
        a$$$$$5 = new javax.swing.JButton();
        a$$$$$6 = new javax.swing.JButton();
        a$$$$$7 = new javax.swing.JButton();
        a$$$$$8 = new javax.swing.JButton();
        a$$$$$9 = new javax.swing.JButton();
        a$$$$$10 = new javax.swing.JButton();
        a$$$$$11 = new javax.swing.JButton();
        a$$$$$12 = new javax.swing.JButton();
        a$$$$$13 = new javax.swing.JButton();
        a$$$$$14 = new javax.swing.JButton();
        a$$$$$15 = new javax.swing.JButton();
        a$$$$$16 = new javax.swing.JButton();
        a$$$$$17 = new javax.swing.JButton();
        a$$$$$18 = new javax.swing.JButton();
        mor = new javax.swing.JButton();
        friendrequestpane = new javax.swing.JPanel();
        sreqholder = new javax.swing.JScrollPane();
        sreq = new javax.swing.JPanel();
        areqholder = new javax.swing.JScrollPane();
        areq = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        windowbuttonholder = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        refrl = new javax.swing.JButton();
        showingfriendlistholder = new javax.swing.JScrollPane();
        lfl = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        showingfriendlistholder1 = new javax.swing.JScrollPane();
        gfl = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        closebutton1 = new javax.swing.JButton();
        closebutton = new javax.swing.JButton();
        hiddenitems = new javax.swing.JPanel();
        frndls = new javax.swing.JComboBox();
        chnlsholder = new javax.swing.JScrollPane();
        chnls = new javax.swing.JList();
        frlsholder = new javax.swing.JScrollPane();
        frls = new javax.swing.JList(dlm);
        frlsholder1 = new javax.swing.JScrollPane();
        grls = new javax.swing.JList(dlm);
        freqls = new javax.swing.JComboBox();
        act = new javax.swing.JComboBox();
        recon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        outerframe.setBackground(new java.awt.Color(255, 255, 255));
        outerframe.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        outerframe.setMaximumSize(new java.awt.Dimension(767, 32767));
        outerframe.setPreferredSize(new java.awt.Dimension(735, 1506));

        innerframe.setBackground(new java.awt.Color(0, 0, 153));

        chatpane.setBackground(new java.awt.Color(0, 51, 51));
        chatpane.setLayout(new java.awt.BorderLayout());

        chatscreenholder.setBackground(new java.awt.Color(255, 255, 255));
        chatscreenholder.setLayout(new java.awt.BorderLayout());

        holder.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        holder.setAutoscrolls(true);
        holder.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                holderAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        holder.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                holderMouseDragged(evt);
            }
        });
        holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                holderMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                holderMouseReleased(evt);
            }
        });
        holder.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                holderCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        holder.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                holderPropertyChange(evt);
            }
        });
        holder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                holderKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                holderKeyReleased(evt);
            }
        });

        chboard.setBackground(new java.awt.Color(255, 255, 255));
        chboard.setAutoscrolls(true);
        chboard.setLayout(new java.awt.GridLayout(0, 1, 2, 5));
        holder.setViewportView(chboard);

        chatscreenholder.add(holder, java.awt.BorderLayout.CENTER);

        ou.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N

        ou1.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(ou1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
                .addComponent(ou, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ou1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ou, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        chatscreenholder.add(jPanel8, java.awt.BorderLayout.NORTH);

        chatpane.add(chatscreenholder, java.awt.BorderLayout.CENTER);

        snb.setBackground(new java.awt.Color(0, 204, 0));
        snb.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        snb.setText("<-");
        snb.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        snb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snbActionPerformed(evt);
            }
        });

        clr.setBackground(new java.awt.Color(0, 204, 51));
        clr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clr.setForeground(new java.awt.Color(255, 0, 0));
        clr.setText("Clear Chat");
        clr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(snb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clr))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(snb)
                .addComponent(clr))
        );

        msb.setColumns(20);
        msb.setRows(5);
        msb.setPreferredSize(new java.awt.Dimension(165, 94));
        msb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                msbKeyTyped(evt);
            }
        });

        emojiholder.setBackground(new java.awt.Color(255, 255, 255));

        a$$$$$1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$1.png"))); // NOI18N
        a$$$$$1.setActionCommand("a$$$$$1");
        a$$$$$1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$1ActionPerformed(evt);
            }
        });

        a$$$$$2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$2.png"))); // NOI18N
        a$$$$$2.setActionCommand("a$$$$$2");
        a$$$$$2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$2ActionPerformed(evt);
            }
        });

        a$$$$$3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$3.png"))); // NOI18N
        a$$$$$3.setActionCommand("a$$$$$3");
        a$$$$$3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$3ActionPerformed(evt);
            }
        });

        a$$$$$4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$4.png"))); // NOI18N
        a$$$$$4.setActionCommand("a$$$$$4");
        a$$$$$4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$4ActionPerformed(evt);
            }
        });

        a$$$$$5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$5.png"))); // NOI18N
        a$$$$$5.setActionCommand("a$$$$$5");
        a$$$$$5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$5ActionPerformed(evt);
            }
        });

        a$$$$$6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$6.png"))); // NOI18N
        a$$$$$6.setActionCommand("a$$$$$6");
        a$$$$$6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$6ActionPerformed(evt);
            }
        });

        a$$$$$7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$7.png"))); // NOI18N
        a$$$$$7.setActionCommand("a$$$$$7");
        a$$$$$7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$7ActionPerformed(evt);
            }
        });

        a$$$$$8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$8.png"))); // NOI18N
        a$$$$$8.setActionCommand("a$$$$$8");
        a$$$$$8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$8ActionPerformed(evt);
            }
        });

        a$$$$$9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$9.png"))); // NOI18N
        a$$$$$9.setActionCommand("a$$$$$9");
        a$$$$$9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$9ActionPerformed(evt);
            }
        });

        a$$$$$10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$10.png"))); // NOI18N
        a$$$$$10.setActionCommand("a$$$$$10");
        a$$$$$10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$10ActionPerformed(evt);
            }
        });

        a$$$$$11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$11.png"))); // NOI18N
        a$$$$$11.setActionCommand("a$$$$$11");
        a$$$$$11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$11ActionPerformed(evt);
            }
        });

        a$$$$$12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$12.png"))); // NOI18N
        a$$$$$12.setActionCommand("a$$$$$12");
        a$$$$$12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$12ActionPerformed(evt);
            }
        });

        a$$$$$13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$13.png"))); // NOI18N
        a$$$$$13.setActionCommand("a$$$$$13");
        a$$$$$13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$13ActionPerformed(evt);
            }
        });

        a$$$$$14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$14.png"))); // NOI18N
        a$$$$$14.setActionCommand("a$$$$$14");
        a$$$$$14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$14ActionPerformed(evt);
            }
        });

        a$$$$$15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$15.png"))); // NOI18N
        a$$$$$15.setActionCommand("a$$$$$15");
        a$$$$$15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$15ActionPerformed(evt);
            }
        });

        a$$$$$16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$17.png"))); // NOI18N
        a$$$$$16.setActionCommand("a$$$$$17");
        a$$$$$16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$16ActionPerformed(evt);
            }
        });

        a$$$$$17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$16.png"))); // NOI18N
        a$$$$$17.setActionCommand("a$$$$$16");
        a$$$$$17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$17ActionPerformed(evt);
            }
        });

        a$$$$$18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$18.png"))); // NOI18N
        a$$$$$18.setActionCommand("a$$$$$18");
        a$$$$$18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a$$$$$18ActionPerformed(evt);
            }
        });

        mor.setBackground(new java.awt.Color(255, 255, 255));
        mor.setText("..");
        mor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                morActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout emojiholderLayout = new javax.swing.GroupLayout(emojiholder);
        emojiholder.setLayout(emojiholderLayout);
        emojiholderLayout.setHorizontalGroup(
            emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emojiholderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emojiholderLayout.createSequentialGroup()
                        .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(a$$$$$4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(a$$$$$7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emojiholderLayout.createSequentialGroup()
                        .addComponent(a$$$$$18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emojiholderLayout.createSequentialGroup()
                        .addComponent(a$$$$$2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a$$$$$3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(emojiholderLayout.createSequentialGroup()
                        .addComponent(a$$$$$5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a$$$$$6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emojiholderLayout.createSequentialGroup()
                        .addComponent(a$$$$$8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a$$$$$9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emojiholderLayout.createSequentialGroup()
                        .addComponent(a$$$$$12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a$$$$$11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a$$$$$10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(emojiholderLayout.createSequentialGroup()
                        .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(emojiholderLayout.createSequentialGroup()
                                .addComponent(a$$$$$1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(a$$$$$15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(a$$$$$14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(emojiholderLayout.createSequentialGroup()
                                .addComponent(a$$$$$16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(a$$$$$17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(a$$$$$13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        emojiholderLayout.setVerticalGroup(
            emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emojiholderLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(emojiholderLayout.createSequentialGroup()
                        .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(emojiholderLayout.createSequentialGroup()
                                .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(emojiholderLayout.createSequentialGroup()
                                        .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(a$$$$$17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a$$$$$3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a$$$$$2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a$$$$$18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a$$$$$16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a$$$$$13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(a$$$$$6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a$$$$$5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a$$$$$4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a$$$$$1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a$$$$$15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(a$$$$$14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, emojiholderLayout.createSequentialGroup()
                                .addComponent(mor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(emojiholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(a$$$$$9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(a$$$$$7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(a$$$$$8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(a$$$$$11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(a$$$$$10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(a$$$$$12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        emojiscroller.setViewportView(emojiholder);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(msb, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emojiscroller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emojiscroller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msb, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chatpane.add(jPanel7, java.awt.BorderLayout.SOUTH);

        innerframe.addTab("CHATS", chatpane);

        friendrequestpane.setBackground(new java.awt.Color(255, 255, 255));

        sreqholder.setAutoscrolls(true);

        sreq.setBackground(new java.awt.Color(204, 204, 255));
        sreq.setAutoscrolls(true);
        sreq.setLayout(new java.awt.GridLayout(10, 1));
        sreqholder.setViewportView(sreq);

        areqholder.setAutoscrolls(true);

        areq.setBackground(new java.awt.Color(0, 51, 51));
        areq.setAutoscrolls(true);
        areq.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                areqMouseMoved(evt);
            }
        });
        areq.setLayout(new java.awt.GridLayout(0, 1, 0, 2));
        areqholder.setViewportView(areq);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/r3.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/r3.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout friendrequestpaneLayout = new javax.swing.GroupLayout(friendrequestpane);
        friendrequestpane.setLayout(friendrequestpaneLayout);
        friendrequestpaneLayout.setHorizontalGroup(
            friendrequestpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendrequestpaneLayout.createSequentialGroup()
                .addGroup(friendrequestpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sreqholder, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                    .addComponent(areqholder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(friendrequestpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        friendrequestpaneLayout.setVerticalGroup(
            friendrequestpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendrequestpaneLayout.createSequentialGroup()
                .addGroup(friendrequestpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(areqholder, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(friendrequestpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sreqholder, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
                    .addGroup(friendrequestpaneLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        innerframe.addTab("Friend Request", friendrequestpane);

        outerframe.addTab("", null, innerframe, "");

        getContentPane().add(outerframe, java.awt.BorderLayout.CENTER);

        windowbuttonholder.setBackground(new java.awt.Color(255, 255, 255));
        windowbuttonholder.setMaximumSize(new java.awt.Dimension(21, 21));
        windowbuttonholder.setMinimumSize(new java.awt.Dimension(27, 67));
        windowbuttonholder.setOpaque(false);
        windowbuttonholder.setPreferredSize(new java.awt.Dimension(200, 673));
        windowbuttonholder.setLayout(new java.awt.BorderLayout());

        jPanel2.setMaximumSize(new java.awt.Dimension(214, 214));
        jPanel2.setPreferredSize(new java.awt.Dimension(176, 58));

        logoutButton.setBackground(new java.awt.Color(255, 0, 51));
        logoutButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log Out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/r3.png"))); // NOI18N
        jButton4.setText("refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cu.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        cu.setText("nkc");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Challenge");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 14, 0, 14);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/imagig/zx.png"))); // NOI18N
        jLabel4.setText("Zero-Cross");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setName("a$$$$$95"); // NOI18N
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 14, 0, 14);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/imagig/turntt.png"))); // NOI18N
        jLabel6.setText("Turn-Tiles");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setName("a$$$$$96"); // NOI18N
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 14, 16, 14);
        jPanel1.add(jLabel6, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(cu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(logoutButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(cu)
                .addGap(7, 7, 7)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        windowbuttonholder.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(windowbuttonholder, java.awt.BorderLayout.EAST);

        jPanel3.setMaximumSize(new java.awt.Dimension(324, 214));
        jPanel3.setMinimumSize(new java.awt.Dimension(300, 713));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 667));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Friends List :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 161;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 21, 0, 0);
        jPanel3.add(jLabel1, gridBagConstraints);

        refrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/r3.png"))); // NOI18N
        refrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrlActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -34;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 5, 0, 12);
        jPanel3.add(refrl, gridBagConstraints);

        lfl.setBackground(new java.awt.Color(255, 255, 255));
        lfl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        lfl.setAutoscrolls(true);
        lfl.setLayout(new java.awt.GridLayout(5, 1));
        showingfriendlistholder.setViewportView(lfl);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 268;
        gridBagConstraints.ipady = 286;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 12);
        jPanel3.add(showingfriendlistholder, gridBagConstraints);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/r3.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = -34;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 5, 0, 12);
        jPanel3.add(jButton6, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 106, 0, 0);
        jPanel3.add(jButton1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("Groups :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 12, 0, 0);
        jPanel3.add(jLabel2, gridBagConstraints);

        gfl.setBackground(new java.awt.Color(255, 255, 255));
        gfl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        gfl.setAutoscrolls(true);
        gfl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gflMouseEntered(evt);
            }
        });
        gfl.setLayout(new java.awt.GridLayout(3, 1));
        showingfriendlistholder1.setViewportView(gfl);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 268;
        gridBagConstraints.ipady = 264;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 7, 12);
        jPanel3.add(showingfriendlistholder1, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ms2.png"))); // NOI18N
        jLabel5.setText("    Chit Chat");

        closebutton1.setBackground(new java.awt.Color(0, 0, 255));
        closebutton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        closebutton1.setForeground(new java.awt.Color(255, 255, 255));
        closebutton1.setText("-");
        closebutton1.setMaximumSize(new java.awt.Dimension(37, 25));
        closebutton1.setMinimumSize(new java.awt.Dimension(37, 25));
        closebutton1.setPreferredSize(new java.awt.Dimension(37, 25));
        closebutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebutton1ActionPerformed(evt);
            }
        });

        closebutton.setBackground(new java.awt.Color(255, 0, 51));
        closebutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        closebutton.setForeground(new java.awt.Color(255, 255, 255));
        closebutton.setText("X");
        closebutton.setMaximumSize(new java.awt.Dimension(37, 25));
        closebutton.setMinimumSize(new java.awt.Dimension(37, 25));
        closebutton.setPreferredSize(new java.awt.Dimension(37, 25));
        closebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebuttonActionPerformed(evt);
            }
        });

        frndls.setBackground(new java.awt.Color(153, 255, 102));
        frndls.setFocusable(false);
        frndls.setVerifyInputWhenFocusTarget(false);

        chnlsholder.setFocusable(false);
        chnlsholder.setMaximumSize(new java.awt.Dimension(0, 0));
        chnlsholder.setMinimumSize(new java.awt.Dimension(0, 0));
        chnlsholder.setOpaque(false);
        chnlsholder.setPreferredSize(new java.awt.Dimension(0, 0));
        chnlsholder.setRequestFocusEnabled(false);
        chnlsholder.setVerifyInputWhenFocusTarget(false);

        chnls.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "off", "on" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        chnls.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                chnlsValueChanged(evt);
            }
        });
        chnlsholder.setViewportView(chnls);

        frlsholder.setOpaque(false);

        frls.setBackground(new java.awt.Color(153, 204, 0));
        frls.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        frls.setModel(dlm);
        frls.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        frls.setEnabled(false);
        frls.setOpaque(false);
        frls.setRequestFocusEnabled(false);
        frls.setVerifyInputWhenFocusTarget(false);
        frls.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                frlsValueChanged(evt);
            }
        });
        frlsholder.setViewportView(frls);

        frlsholder1.setOpaque(false);

        grls.setBackground(new java.awt.Color(204, 51, 0));
        grls.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        grls.setModel(dlm);
        grls.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        grls.setOpaque(false);
        grls.setRequestFocusEnabled(false);
        grls.setVerifyInputWhenFocusTarget(false);
        grls.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                grlsValueChanged(evt);
            }
        });
        frlsholder1.setViewportView(grls);

        freqls.setBackground(new java.awt.Color(102, 255, 153));
        freqls.setFocusable(false);
        freqls.setLightWeightPopupEnabled(false);
        freqls.setOpaque(false);
        freqls.setRequestFocusEnabled(false);
        freqls.setVerifyInputWhenFocusTarget(false);

        act.setFocusable(false);
        act.setLightWeightPopupEnabled(false);
        act.setOpaque(false);
        act.setRequestFocusEnabled(false);
        act.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout hiddenitemsLayout = new javax.swing.GroupLayout(hiddenitems);
        hiddenitems.setLayout(hiddenitemsLayout);
        hiddenitemsLayout.setHorizontalGroup(
            hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(frndls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 21, Short.MAX_VALUE)
                    .addComponent(chnlsholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 22, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 17, Short.MAX_VALUE)
                    .addComponent(frlsholder, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 17, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(frlsholder1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(freqls, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 9, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 8, Short.MAX_VALUE)
                    .addComponent(act, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );
        hiddenitemsLayout.setVerticalGroup(
            hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(frndls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(chnlsholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(frlsholder, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(frlsholder1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(freqls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(hiddenitemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenitemsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        recon.setBackground(new java.awt.Color(255, 255, 0));
        recon.setText("Connecting...(try Refresh)");
        recon.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hiddenitems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recon, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closebutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(hiddenitems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closebutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recon)))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
int cnt=0;
    private void frlsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_frlsValueChanged
     ou.setText(frls.getSelectedValue().toString());
     chboard.removeAll();
     loadMsg();
    }//GEN-LAST:event_frlsValueChanged

    private void closebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebuttonActionPerformed
 try
{
Class.forName(drv);
st=con.createStatement();
String qry="update actv set state = 0 where usname='"+cu.getText()+"';";
int ini=st.executeUpdate(qry); 
rs.close();
th.stop();
con.close();
}   
catch(Exception ex)
{
    System.out.println(ex + "error jbutton-3");
    error++;
    errhandler();
}
        System.exit(0);
    }//GEN-LAST:event_closebuttonActionPerformed

    private void areqMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areqMouseMoved

    }//GEN-LAST:event_areqMouseMoved

    private void msbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msbKeyTyped
        snb.setFocusable(true);
    }//GEN-LAST:event_msbKeyTyped

    private void snbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snbActionPerformed
snb.setEnabled(false);
try{
th.resume();
}catch(Exception ex){
    
}
 if((!ou.getText().equals("")))
{
        cr++;
        cnt++;
        jl[0].setVisible(false);
        if(cnt==2)
        {
            //chboard.remove(jl[0]);
        }
        
        adDb();
        Jmb jl=new Jmb();
        jl.setMsg(msb.getText(),ss2);
        msb.setText("");
        chboard.add(jl);
        snb.setFocusable(false);
        msb.setFocusable(true);
    try {
        Thread.sleep(3);
    } catch (InterruptedException ex) {
        Logger.getLogger(Cfm.class.getName()).log(Level.SEVERE, null, ex);
    }
        holder.getVerticalScrollBar().setValue((holder.getVerticalScrollBar()).getMaximum());
}
 snb.setEnabled(true);
    }//GEN-LAST:event_snbActionPerformed

    private void holderAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_holderAncestorAdded

    }//GEN-LAST:event_holderAncestorAdded

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
 try
{
    Class.forName(drv);
    st=con.createStatement();
    String qry="update actv set state = 0 where usname='"+cu.getText()+"';";
    int ini=st.executeUpdate(qry);
    System.out.println(" j5");
    rs.close();
    kl=1;
    con.close();
    System.out.println(" j6");
    new LogiN().setVisible(true);
    this.setVisible(false);
    this.dispose();
}   
catch(Exception ex)
{
    System.out.println(ex+" error in jbutton-5");
    error++;
    errhandler();
}     
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void chnlsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_chnlsValueChanged
       if(chnls.getSelectedIndex()==1)
{  
    chkUpdates();    
    chnls.setSelectedIndex(0);  
}
    }//GEN-LAST:event_chnlsValueChanged

    private void a$$$$$1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$1ActionPerformed
        enterEmoj(evt);
    }//GEN-LAST:event_a$$$$$1ActionPerformed

    private void a$$$$$2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$2ActionPerformed
       enterEmoj(evt);
    }//GEN-LAST:event_a$$$$$2ActionPerformed

    private void a$$$$$3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$3ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$3ActionPerformed

    private void a$$$$$4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$4ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$4ActionPerformed

    private void a$$$$$5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$5ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$5ActionPerformed

    private void a$$$$$6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$6ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$6ActionPerformed

    private void a$$$$$7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$7ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$7ActionPerformed

    private void a$$$$$8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$8ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$8ActionPerformed

    private void a$$$$$9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$9ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$9ActionPerformed

    private void a$$$$$10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$10ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$10ActionPerformed

    private void a$$$$$11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$11ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$11ActionPerformed

    private void a$$$$$12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$12ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$12ActionPerformed

    private void a$$$$$13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$13ActionPerformed
enterEmoj(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_a$$$$$13ActionPerformed

    private void a$$$$$14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$14ActionPerformed
enterEmoj(evt);        
    }//GEN-LAST:event_a$$$$$14ActionPerformed

    private void a$$$$$15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$15ActionPerformed
enterEmoj(evt);        
    }//GEN-LAST:event_a$$$$$15ActionPerformed

    private void a$$$$$17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$17ActionPerformed
enterEmoj(evt);      
    }//GEN-LAST:event_a$$$$$17ActionPerformed

    private void a$$$$$16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$16ActionPerformed
enterEmoj(evt);       
    }//GEN-LAST:event_a$$$$$16ActionPerformed

    private void a$$$$$18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a$$$$$18ActionPerformed
enterEmoj(evt);        
    }//GEN-LAST:event_a$$$$$18ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
AddGroup adgp=new AddGroup(ss2,this);
adgp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void grlsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_grlsValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_grlsValueChanged

    private void gflMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gflMouseEntered
    synchronized(this)
    {
    Connection conn=null;
    Statement stt=null;
    ResultSet rst=null;
    try{
    Class.forName(drv);
    conn=DriverManager.getConnection(conurl, "root", mspass);
    stt=conn.createStatement();
    String qry="select count(*) from "+cu.getText()+"grp ;";
    rst=stt.executeQuery(qry);
    rst.next();
    int totalgrp2=rst.getInt(1);
    rst.close();
    stt.close();
    conn.close();
    if(totalgrp2!=totalgrp)
    {
    grpList();
    }
    }
    catch(Exception ex)
    {
    System.out.println(ex+"error in count group");
    error++;
    }
    }
    }//GEN-LAST:event_gflMouseEntered

    private void refrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrlActionPerformed
    notification(); 
    }//GEN-LAST:event_refrlActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      kl=1;
      grpList();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    error=0;
    kl=0;
    rrefresh();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    kl=1;
    loadFreq();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    kl=1;
    loadSuggestions();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void holderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holderMouseDragged
 th.suspend();
    }//GEN-LAST:event_holderMouseDragged

    private void holderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_holderKeyPressed

    }//GEN-LAST:event_holderKeyPressed

    private void holderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_holderKeyReleased
     // TODO add your handling code here:
    }//GEN-LAST:event_holderKeyReleased

    private void holderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holderMouseClicked
     th.suspend(); // TODO add your handling code here:
    }//GEN-LAST:event_holderMouseClicked

    private void holderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holderMouseReleased
     th.suspend();   // TODO add your handling code here:
    }//GEN-LAST:event_holderMouseReleased

    private void clrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrActionPerformed
clr.setEnabled(false);
        try{
    Class.forName(drv);
    st=con.createStatement();    
    String qry="";
    ss1=ou.getText();
    ss2=ou1.getText();
    int cnn=0;
    if(ss1.compareTo(ss2)>0 && !ss2.isEmpty())
    {
      qry="truncate "+ss2+ss1 +";";
      //System.out.println(ss2+ss1);
    }
    else if(ss1.compareTo(ss2)<0 && !ss2.isEmpty())
    {
      qry="truncate "+ss1+ss2 +";";
    }
     else 
    {
      qry="truncate "+ss1+ss2 +";";
    }
    int ii=st.executeUpdate(qry);
    ss1=ou.getText();
    ss2=cu.getText();
    st.close();
    rrefresh();
}
catch(Exception ex)
{
    System.out.println(ex+" error in clear chat");
          error++;
          errhandler();
}
    clr.setEnabled(true);
    }//GEN-LAST:event_clrActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
     
      //ss1=ou1.getText();
        String tb="";
     if(ou1.getText().isEmpty()||ou1.getText().equals(""))
      {
    //qry="insert into "+ou.getText()+" values('"+ss2+"','"+msb.getText()+"',1,1,0,0);";//no noti
      }
     else
      {
         sndM(evt);
         try{
            Class.forName(drv);
            con=DriverManager.getConnection(conurl, "root", mspass);
            st=con.createStatement();    
            String qry="";
            System.out.println("zx 1");
            if(ss1.compareTo(ss2)>0)
            {
                qry="update "+ss2+ss1 +" set "+cu.getText()+"pl=1;";
                tb=ss2+ss1 ;
            }
            else
            {
                qry="update "+ss1+ss2 +" set "+cu.getText()+"pl=1;";
                tb=ss1+ss2; 
            }
      //th.wait(5);
            synchronized(this)
            {
                System.out.println("zx 2");          
                int iii=st.executeUpdate(qry);
                new ZeroCross(tb,cu.getText(),ou.getText(),"X",1).setVisible(true);
                st.close();
                System.out.println("zx 5");
             }
     }
     catch(Exception ex)
     {
         System.out.println(ex+" zx");
         //msb.append(" "+ex+" zx 1 "+tb+" "+cu.getText()+" "+ou.getText());
     }
    }
    }//GEN-LAST:event_jLabel4MouseClicked
int chnemo=1;
    private void morActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_morActionPerformed
    if(chnemo==1)
    {
    a$$$$$1.setActionCommand("a$$$$$19");
    a$$$$$1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$19.png")));
    a$$$$$2.setActionCommand("a$$$$$20");
    a$$$$$2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$20.png")));
    a$$$$$3.setActionCommand("a$$$$$21");
    a$$$$$3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$21.png")));
    a$$$$$4.setActionCommand("a$$$$$22");
    a$$$$$4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$22.png")));
    a$$$$$5.setActionCommand("a$$$$$23");
    a$$$$$5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$23.png")));
    a$$$$$6.setActionCommand("a$$$$$24");
    a$$$$$6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$24.png")));
    a$$$$$7.setActionCommand("a$$$$$25");
    a$$$$$7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$25.png")));
    a$$$$$8.setActionCommand("a$$$$$26");
    a$$$$$8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$26.png")));
    chnemo=2;
    }
    else
    {
    a$$$$$1.setActionCommand("a$$$$$1");
    a$$$$$1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$1.png")));
    a$$$$$2.setActionCommand("a$$$$$2");
    a$$$$$2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$2.png")));
    a$$$$$3.setActionCommand("a$$$$$3");
    a$$$$$3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$3.png")));
    a$$$$$4.setActionCommand("a$$$$$4");
    a$$$$$4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$4.png")));
    a$$$$$5.setActionCommand("a$$$$$5");
    a$$$$$5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$5.png")));
    a$$$$$6.setActionCommand("a$$$$$6");
    a$$$$$6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$6.png")));
    a$$$$$7.setActionCommand("a$$$$$7");
    a$$$$$7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$7.png")));
    a$$$$$8.setActionCommand("a$$$$$8");
    a$$$$$8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChitChat/ico/a$$$$$8.png")));
    chnemo=1;
    }
    }//GEN-LAST:event_morActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    //ss1=ou1.getText();
     if(ou1.getText().isEmpty()||ou1.getText().equals(""))
      {
    //qry="insert into "+ou.getText()+" values('"+ss2+"','"+msb.getText()+"',1,1,0,0);";//no noti
      }
     else
      {
         sndM(evt);
         try{
            Class.forName(drv);
            con=DriverManager.getConnection(conurl, "root", mspass);
            st=con.createStatement();    
            String qry="";
            System.out.println("tt 1");
            String tb="";
            if(ss1.compareTo(ss2)>0)
            {
                qry="update "+ss2+ss1 +" set "+cu.getText()+"pl=2;";
                tb=ss2+ss1 ;
            }
            else
            {
                qry="update "+ss1+ss2 +" set "+cu.getText()+"pl=2;";
                tb=ss1+ss2; 
            }
      //th.wait(5);
            synchronized(this)
            {
                System.out.println("tt 2");          
                int iii=st.executeUpdate(qry);
                new Level1(tb,cu.getText(),ou.getText(),1).setVisible(true);
                st.close();
                System.out.println("5");
          
             }
     }
     catch(Exception ex)
     {
         System.out.println(ex+" tt");
     }
    }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void closebutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebutton1ActionPerformed
 this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_closebutton1ActionPerformed

    private void holderPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_holderPropertyChange
        
    }//GEN-LAST:event_holderPropertyChange

    private void holderCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_holderCaretPositionChanged

    }//GEN-LAST:event_holderCaretPositionChanged
public void sndM(MouseEvent evt)
{
    if((!ou.getText().equals("")))
    {
    cr++;
        cnt++;
        jl[0].setVisible(false);
        if(!(msb.getText().equals("")))
        {adDb();
        Jmb jl=new Jmb();
        jl.setMsg(msb.getText(),cu.getText());
        chboard.add(jl);
        }
        msb.setText(((JLabel)evt.getSource()).getName());
        adDb();
        msb.setText("");
        Emoj jll=new Emoj();
        jll.setMsg(((JLabel)evt.getSource()).getName(),cu.getText());
        chboard.add(jll);
        snb.setFocusable(false);
        msb.setFocusable(true);  
        holder.getVerticalScrollBar().setValue((holder.getVerticalScrollBar()).getMaximum());
    }
}
public void enterEmoj(ActionEvent evt)
{
    if((!ou.getText().equals("")))
    {
    cr++;
        cnt++;
        jl[0].setVisible(false);
        if(!(msb.getText().equals("")))
        {adDb();
        Jmb jl=new Jmb();
        jl.setMsg(msb.getText(),cu.getText());
        chboard.add(jl);
        }
        msb.setText(((JButton)evt.getSource()).getActionCommand());
        adDb();
        msb.setText("");
        Emoj jll=new Emoj();
        jll.setMsg(((JButton)evt.getSource()).getActionCommand(),cu.getText());
        chboard.add(jll);
        snb.setFocusable(false);
        msb.setFocusable(true);  
        holder.getVerticalScrollBar().setValue((holder.getVerticalScrollBar()).getMaximum());
    }
}

String ss1,ss2;
private void adDb() {
try
{
Class.forName(drv);
con=DriverManager.getConnection(conurl, "root", mspass);
st=con.createStatement();
String qry="";
ss1=ou.getText();
ss2=cu.getText();
if(ou1.getText().isEmpty()||ou1.getText().equals(""))
{
    qry="insert into "+ou.getText()+" values('"+ss2+"','"+msb.getText()+"',1,1,0,0);";//no noti
}
else
{
if(ss1.compareTo(ss2)>0)
    {
qry="insert into "+ss2+ss1 +" values('"+ss2+"','"+msb.getText()+"',1,0,0,0);";
    }
    else
    {
  qry="insert into "+ss1+ss2 +" values('"+ss2+"','"+msb.getText()+"',0,1,0,0);";
    }
}
int ii=st.executeUpdate(qry);

rs.close();
 
}   
catch(Exception ex)
{
    System.out.println(ex+" error in adDb");
    error++;
    errhandler();
}
        }
    
private void loadMsg() {
    chboard.removeAll();
    if(ou.getText().equals("")||ou.getText().equals(" "))
    {    
    }
/*    else if(ou1.getText().equals("")||ou1.getText().equals(" "))
    {    
        loadMsgGrp();
    }*/
    else{
        
  try{
    Class.forName(drv);
    con=DriverManager.getConnection(conurl, "root", mspass);
    st=con.createStatement();    
    String qry="",qry2="",qgt="";
    ss1=ou.getText();
    ss2=ou1.getText();
    int cnn=0;
    if(ss1.compareTo(ss2)>0 && !ss2.isEmpty())
    {
      qry="select * from "+ss2+ss1 +";";
      qry2="select count(*) from "+ss2+ss1 +";";
      qgt="update "+ss2+ss1+" set "+cu.getText()+"rd=1";
      //System.out.println(ss2+ss1);
    }
    else if(ss1.compareTo(ss2)<0 && !ss2.isEmpty())
    {
      qry="select * from "+ss1+ss2 +";";
      qry2="select count(*) from "+ss1+ss2 +";";
      qgt="update "+ss1+ss2+" set "+cu.getText()+"rd=1";
      //System.out.println(ss1+ss2);
    }
     else 
    {
      qry="select * from "+ss1+ss2 +";";
      qry2="select count(*) from "+ss1+ss2 +";";
      qgt="update "+ss1+ss2+" set othrd=1";
    }
    
    ss2=cu.getText();
    synchronized(this)
    {
    int io=st.executeUpdate(qgt);
    rs=st.executeQuery(qry2);
    rs.next();
    cnn=rs.getInt(1);
    cr=cnn;
    }
    rs=st.executeQuery(qry);
    rs.next();
    for(int j=1;j<=cnn;j++)
    {
       // System.out.println(j+" ");
        if(ss2.equalsIgnoreCase(rs.getString(1)))
        {
        if((!rs.getString(2).equals(""))&&(
          rs.getString(2).substring(0,rs.getString(2).length()-1).equals("a$$$$$")
          ||rs.getString(2).substring(0,rs.getString(2).length()-2).equals("a$$$$$")))
        {
            Emoj jl=new Emoj();
            //System.out.println(rs.getString(2)+"  jkllkjlkkljkj");
            jl.setMsg(rs.getString(2),rs.getString(1));
            chboard.add(jl);
        }
        else
            {
             Jmb jl=new Jmb();
             jl.setMsg(rs.getString(2),rs.getString(1));
             chboard.add(jl);
            }
        }
        else
        {
            if((!rs.getString(2).equals(""))&&(
             (rs.getString(2).substring(0,rs.getString(2).length()-1)).equals("a$$$$$")
               ||rs.getString(2).substring(0,rs.getString(2).length()-2).equals("a$$$$$")))
             {
                Emoj2 jl=new Emoj2();
                jl.setMsg(rs.getString(2),rs.getString(1));
                chboard.add(jl);
             }
        else
          {
           Jmb1 jl=new Jmb1();
           jl.setMsg(rs.getString(2),rs.getString(1));
           chboard.add(jl);
          }
        }
        rs.next();
    }
    holder.getVerticalScrollBar().setValue((holder.getVerticalScrollBar()).getMaximum());
    rs.close();
     
  }
  catch(Exception ex)
  {
      
      ss2=cu.getText();
          System.out.println(ex+" error in LoadMsg");
          error++;
          errhandler();
  }
    }
    
    }
String grp="";
private void loadMsgGrp() {
    chboard.removeAll();
    if(ou.getText().equals("")||ou.getText().equals(" "))
    {    
    }
    else{
  try{
    Class.forName(drv);
    con=DriverManager.getConnection(conurl, "root", mspass);
    st=con.createStatement();    
    String qry="",qry2="";
grp=ou.getText();
//ss2=cu.getText();
int cnn=0;

qry="select * from "+grp +";";
qry2="select count(*) from "+grp +";";


rs=st.executeQuery(qry2);
rs.next();
cnn=rs.getInt(1);
cr=cnn;
rs=st.executeQuery(qry);
    rs.next();
    for(int j=1;j<=cnn;j++)
    {
       // System.out.println(j+" ");
        if(grp.equalsIgnoreCase(rs.getString(1)))
        {
        if((!rs.getString(2).equals(""))&&(
          rs.getString(2).substring(0,rs.getString(2).length()-1).equals("a$$$$$")
          ||rs.getString(2).substring(0,rs.getString(2).length()-2).equals("a$$$$$")))
        {
            Emoj jl=new Emoj();
            //System.out.println(rs.getString(2)+"  jkllkjlkkljkj");
            jl.setMsg(rs.getString(2),rs.getString(1));
            chboard.add(jl);
        }
        else
            {
             Jmb jl=new Jmb();
             jl.setMsg(rs.getString(2),rs.getString(1));
             chboard.add(jl);
            }
        }
        else
        {
            if((!rs.getString(2).equals(""))&&(
             (rs.getString(2).substring(0,rs.getString(2).length()-1)).equals("a$$$$$")
               ||rs.getString(2).substring(0,rs.getString(2).length()-2).equals("a$$$$$")))
             {
                Emoj2 jl=new Emoj2();
                jl.setMsg(rs.getString(2),rs.getString(1));
                chboard.add(jl);
             }
        else
          {
           Jmb1 jl=new Jmb1();
           jl.setMsg(rs.getString(2),rs.getString(1));
           chboard.add(jl);
          }
        }
        rs.next();
    }
    holder.getVerticalScrollBar().setValue((holder.getVerticalScrollBar()).getMaximum());
    rs.close();
     
    
  }
  catch(Exception ex)
  {
      
      System.out.println(ex+" error in LoadMsgGrp");
      error++;
      errhandler();
  }
    }
    }
DefaultListModel dlm=new DefaultListModel();
int totalfrnd=0;
int nm=0;
private void frlsList() {
    lfl.removeAll();
    frls.removeAll();
    try{
    Class.forName(drv);
    st=con.createStatement();
    String qry="select * from "+cu.getText()+"ufr;",
    qry2="select count(*) from "+cu.getText()+"ufr ;";
    System.out.println("ok 1");
    rs=st.executeQuery(qry2);
    rs.next();
    System.out.println("ok 2");
    int cnn=rs.getInt(1);
    totalfrnd=rs.getInt(1);
    rs=st.executeQuery(qry);
    rs.next();
    System.out.println("ok 3");
    //JList frls=new JList(dlm); 
    //dlm.removeAllElements();
    for(int j=1,ind=0,nm=0;j<=cnn;j++,nm++)
    {        
        if(!ss2.equalsIgnoreCase(rs.getString(1)))
        {
         dlm.add(ind,rs.getString(1));
         FrLst f=new FrLst();
         int ac=0;
         for(int k=0;k<=act.getItemCount()-1;k++)
         {
             if(rs.getString(1).equalsIgnoreCase(act.getItemAt(k).toString()))
             {
                 ac=1;
                 break;
             }
         }
         System.out.println("ok 4");
         f.setNm(rs.getString(1),ss2, ac,ind);
         frndarr[nm]=f;
         System.out.println("ok 4.5");
         f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              chboard.removeAll();
              ou1.setText(cu.getText());
              ou.setText(((FrLst)evt.getSource()).getNm());
              ou1.setText(cu.getText());
              grls.setSelectedIndex(-1);
              ou1.setText(cu.getText());
              System.out.println("ok 4.8");
              frls.setSelectedIndex(((FrLst)evt.getSource()).getPs());
              ou1.setText(cu.getText());
              System.out.println("ok 4.9");
              loadMsg();
              System.out.println("ok 5");
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
             ((FrLst)evt.getSource()).chk();
             System.out.println("ok 6");
            }
            
        });
         lfl.add(f);
         ind++;
        }
        rs.next();
    }
    frls.setSelectedIndex(0); 
    grls.setSelectedIndex(-1); 
    rs.close();
    }
    catch(Exception ex)
    {
        if(!ex.getMessage().equals("java.sql.SQLException: Operation not allowed after ResultSet closed"))
        {
        System.out.println(ex+" error in frls");
        error++;
        errhandler();
        }
    }
}


int totalgrp=0;
public void grpList() {
    DefaultListModel dlg=new DefaultListModel();
    grls.removeAll();;
    gfl.removeAll();
    try{
    Class.forName(drv);
    con=DriverManager.getConnection(conurl, "root", mspass);
    st=con.createStatement();
    String qry="select * from "+ss2+"grp;",
    qry2="select count(*) from "+cu.getText()+"grp ;";
    rs=st.executeQuery(qry2);
    rs.next();
    //int cnn=rs.getInt(1);
    totalgrp=rs.getInt(1);
    rs=st.executeQuery(qry);
    rs.next();
    ou1.setText("");
    //JList frls=new JList(dlm); 
    //dlm.removeAllElements();
    for(int j=1,ind=0;j<=totalgrp;j++)
    {        
        if(!ss2.equalsIgnoreCase(rs.getString(1)))
        {
         dlg.add(ind,rs.getString(1));
         GrPls gp=new GrPls();
         /*int ac=0;
         for(int k=0;k<=act.getItemCount()-1;k++)
         {
             if(rs.getString(1).equalsIgnoreCase(act.getItemAt(k).toString()))
             {
                 ac=1;
                 break;
             }
         }*/
         gp.setNm(rs.getString(1), ind);
         gp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              chboard.removeAll();
              ou1.setText("");
              ou.setText(((GrPls)evt.getSource()).getNm());
              ou1.setText("");
              frls.setSelectedIndex(-1);
              grls.setSelectedIndex(((GrPls)evt.getSource()).getPs());
              ou1.setText("");
              loadMsg();
            }
            
        });
         gfl.add(gp);
         ind++;
        }
        rs.next();
    }
    rs.close();
     
    }
    catch(Exception ex)
    {
        System.out.println(ex+" error in grpList");
        error++;
        errhandler();
    }
}

int acactv=0;
private void getActv() {
    try
{
Class.forName(drv);
st=con.createStatement();
String qry="select * from actv where state = 1;";
String qry2="select count(*) from actv where state = 1;";
rs=st.executeQuery(qry2);
rs.next();
int counted=rs.getInt(1);
acactv=rs.getInt(1);
rs3=st.executeQuery(qry);
rs3.next();
for(int j=1;j<=counted;j++)
{
if(!rs3.getString(1).equalsIgnoreCase(cu.getText()))
{
    act.addItem(rs3.getString(1));
    System.out.println(rs3.getString(1)+ " ok");
}
rs3.next();
}
rs.close();
}   
catch(Exception ex)
{
    System.out.println(ex+ "error in actv");
    error++;
    errhandler();
}
    }

Statement st3=null;
ResultSet rs3=null;

private void loadLast() {
       String tbnm="";
       String qrypl="";
       ss2=ou1.getText();
       chboard.findComponentAt(chboard.getWidth(), chboard.getHeight());
       if((!ou.getText().equals(""))||(!ou.getText().equals(" ")))
       {
         try{
            Class.forName(drv);
            st=con.createStatement();
            st3=con.createStatement();
      synchronized(this)
       {
            String qry2="";
            ss2=ou1.getText();
            if(ss1.compareTo(ss2)>0)
              {
              tbnm=ss2+ss1;
              }
            else
              {
               tbnm=ss1+ss2; 
              }
            if(tbnm.equals(ss2))
            {return;}
            ss2=cu.getText();
            qry2="select count(*) from "+tbnm +";";
            String qry="select * from "+tbnm +";"; 
            rs=st.executeQuery(qry2);
            rs.next();
            int cnn=0;
            cnn=rs.getInt(1);
            if(cr!=cnn)
            {
               
               rs3=st3.executeQuery(qry);
               rs3.next();
               for(int i=1;i<=cr;i++)
               {
                   rs3.next();
               }
               for(int j=cr+1;j<=cnn;j++)
              {
                if(ss2.equalsIgnoreCase(rs3.getString(1)))
        {
        if((!rs3.getString(2).equals(""))&&(
          rs3.getString(2).substring(0,rs3.getString(2).length()-1).equals("a$$$$$")
          ||rs3.getString(2).substring(0,rs3.getString(2).length()-2).equals("a$$$$$")))
        {
            Emoj jl=new Emoj();
            //System.out.println(rs3.getString(2)+"  jkllkjlkkljkj");
            jl.setMsg(rs3.getString(2),rs3.getString(1));
            chboard.add(jl);
        }
        else
            {
             Jmb jl=new Jmb();
             jl.setMsg(rs3.getString(2),rs3.getString(1));
             chboard.add(jl);
            }
        }
        else
        {
            if((!rs3.getString(2).equals(""))&&(
             (rs3.getString(2).substring(0,rs3.getString(2).length()-1)).equals("a$$$$$")
               ||rs3.getString(2).substring(0,rs3.getString(2).length()-2).equals("a$$$$$")))
             {
                Emoj2 jl=new Emoj2();
                jl.setMsg(rs3.getString(2),rs3.getString(1));
                chboard.add(jl);
             }
        else
          {
           Jmb1 jl=new Jmb1();
           jl.setMsg(rs3.getString(2),rs3.getString(1));
           chboard.add(jl);
          }
        }
               rs3.next();
              }               
            }
            cr=cnn;
            holder.getVerticalScrollBar().setValue((holder.getVerticalScrollBar()).getMaximum());
            rs.close();
            rs3.close();
       }
         }
       catch(Exception ex)
       {
           System.out.println(ex+" error in LoadLast "+qrypl);
           ss2=cu.getText();
           error++;
           errhandler();
       }
       }
        if(lpd>3)
          {
              notification();
              lpd=0;
          }    
    }

private void loadFreq() {
        areq.removeAll();
        try{
            Class.forName(drv);
            con=DriverManager.getConnection(conurl, "root", mspass);
            st=con.createStatement();
            st3=con.createStatement();
            String qry2="select count(*) from "+cu.getText()+"rfr ;";
            String qry="select * from "+cu.getText()+"rfr ;"; 
            rs=st.executeQuery(qry2);
            rs.next();
            int cnn=rs.getInt(1);
            rs3=st3.executeQuery(qry);
            rs3.next();
            cfreq=cnn;
            for(int j=1;j<=cnn;j++)
              {
                  ReqOpt ReqO=new ReqOpt();
                  ReqO.setNm(rs3.getString(1),cu.getText());
                  freqls.addItem(rs3.getString(1));
                  areq.add(ReqO, 0);
                  rs3.next();
              }
            rs.close();
            rs3.close();
             
         }
       catch(Exception ex)
       {
           System.out.println(ex+" error in freq");
           error++;
    errhandler();
       }
    }

private void loadSuggestions() {
        sreq.removeAll();
        try{
            Class.forName(drv);
            con=DriverManager.getConnection(conurl, "root", mspass);
            st=con.createStatement();
            st3=con.createStatement();
            String qry2="select count(*) from uspa;";
            String qry="select * from uspa;"; 
            rs=st.executeQuery(qry2);
            rs.next();
            int cnn=rs.getInt(1);
            rs3=st3.executeQuery(qry);
            rs3.next();
            Boolean bl=true;
            for(int j=1;j<=cnn;j++)
              {
                  //System.out.println(dlm.getSize());
                  for (int jj=0;jj<=(dlm.getSize()-1);jj++)
                  {
                     // System.out.println(dlm.getElementAt(jj).toString());
                  if(rs3.getString(1).equalsIgnoreCase(dlm.getElementAt(jj).toString()))
                  {
                      bl=false;
                      break;
                  }
                  else
                  {
                      bl=true;
                  }
                  }
                  for(int k=0;k<=freqls.getItemCount()-1;k++)
                  {
                  if(rs3.getString(1).equalsIgnoreCase(freqls.getItemAt(k).toString()))   
                  {
                     bl=false;
                      break;
                  }
                  else
                  {
                      bl=true;
                  }
                  }
                 
                  if((!rs3.getString(1).equalsIgnoreCase(cu.getText())) && bl)
                  {                  
                  ReqSuggest ReqS=new ReqSuggest();
                  ReqS.setNm(rs3.getString(1),cu.getText());
                  sreq.add(ReqS, 0);
                  }
                  rs3.next();
                  }
               st.close();
               st3.close();
               rs.close();
               rs3.close();
                   
              }                       
       catch(Exception ex)
       {
           System.out.println(ex+" error in loadSuggestions");
           error++;
    errhandler();
       }
     }

private void frndList() {
        frndls.removeAllItems();
        try{
            Class.forName(drv);
            st=con.createStatement();
            st3=con.createStatement();
            String qry2="select count(*) from"+cu.getText()+"ufr"+";";
            String qry="select * from "+cu.getText()+"ufr"+";"; 
            rs=st.executeQuery(qry2);
            rs.next();
            int cnn=rs.getInt(1);
            //System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[ "+rs.getInt(1));
            nosugg=rs.getInt(1);
            rs3=st3.executeQuery(qry);
            rs3.next();
            for(int j=1;j<=cnn;j++)
              {
                  frndls.addItem(rs3.getString(1));
                  rs3.next();
              }   
            rs.close();
            rs3.close();
         }
       catch(Exception ex)
       {
           System.out.println(ex+" frndList");
           error++;
           errhandler();
       }
    }

    int erravoid=0;

private void loadLfr()  {
       try{
            Class.forName(drv);
            st=con.createStatement();
            st3=con.createStatement();
            String qry2="";
            qry2="select count(*) from "+cu.getText()+"rfr;";
            String qry="select * from "+cu.getText()+"rfr;"; 
            rs=st.executeQuery(qry2);
            rs.next();
            int cnn=0;
            cnn=rs.getInt(1);
            erravoid=cnn;
            if(cfreq>cnn)
            {
               rs3=st3.executeQuery(qry);
               rs3.next();
               for(int i=1;i<=cfreq;i++)
               {
                   rs3.next();
               }
               for(int j=cfreq+1;j<=cnn;j++)
              {
               if(ss2.equalsIgnoreCase(rs3.getString(1)))
                {
                  ReqOpt reo=new ReqOpt();
                  reo.setNm(rs3.getString(1),cu.getText());
                  areq.add(reo, 0);
                }
               rs3.next();
              }
               cfreq=cnn;
            }
            else if(cfreq<cnn)
            {
                loadFreq();
                loadSuggestions();
            }
            rs.close();
            rs3.close();
             
         }
       catch(Exception ex)
       {
           System.out.println(ex+" error in lfr");
           cfreq=erravoid;
           error++;
    errhandler();
       }
  }

int nosugg=0;
ResultSet rs2=null;
Statement st2=null;


private void lastAdd() {
     try{
            Class.forName(drv);
            st2=con.createStatement();
            st3=con.createStatement();
            String qry2="select count(*) from "+cu.getText()+"ufr"+";";
            String qry="select * from "+cu.getText()+"ufr"+";"; 
         synchronized(this)
         {
            rs=st3.executeQuery(qry2);
            rs.next();
            int cnn=rs.getInt(1);
            System.out.println(cnn+" "+totalfrnd);
            rs.close();
            rs2=st2.executeQuery(qry);
            if(totalfrnd<cnn)
            {
                System.out.println("oko thik-1 ");
            rs2.next();
            for(int j=1;j<=totalfrnd;j++)
              {
                  rs2.next();
              }   
              System.out.println("oko thik-2");
            for(int j=totalfrnd+1,ind=dlm.getSize();j<=cnn;j++)
            {        
                System.out.println("oko thik-3");
              if(!ss2.equalsIgnoreCase(rs2.getString(1)))
              {
                  System.out.println("oko thik-4"+" "+ind);
                dlm.add(ind,rs2.getString(1));
                 System.out.println("oko thik-4.1");
                FrLst f=new FrLst();
                int ac=0;
                for(int k=0;k<=act.getItemCount()-1;k++)
                  {
                      System.out.println("oko thik-5");
                     if(rs2.getString(1).equalsIgnoreCase(act.getItemAt(k).toString()))
                     {
                         ac=1;
                         break;
                     }
                   }
                System.out.println("oko thik-6");
               f.setNm(rs2.getString(1),ss2, ac,ind);
               frndarr[nm]=f;
               f.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                chboard.removeAll();
              ou1.setText(cu.getText());
              ou.setText(((FrLst)evt.getSource()).getNm());
              ou1.setText(cu.getText());
              grls.setSelectedIndex(-1);
              ou1.setText(cu.getText());
              frls.setSelectedIndex(((FrLst)evt.getSource()).getPs());
              ou1.setText(cu.getText());
              loadMsg();
                
               }
               public void mouseMoved(java.awt.event.MouseEvent evt) {
                ((FrLst)evt.getSource()).chk();
               }});
               lfl.add(f);
               ind++;
               System.out.println("oko thik-7");
               }
              System.out.println("oko thik-8");
               rs2.next();
            }
            totalfrnd=cnn;
            rs2.close();
            }
            else
            {
            rs3.close();
            }
         }
         }
       catch(Exception ex)
       {
           System.out.println(ex+" last add");
           error++;
           errhandler();
       }
 }
 
 private void chkSuggestions() /*error*/{
      try{
            Class.forName(drv);
            st=con.createStatement();
            String qry2="";
            qry2="select count(*) from "+cu.getText()+"ufr;";// where name='$$@!!';";
            rs=st.executeQuery(qry2);
            rs.next();
            int ccn=rs.getInt(1);
            if(nosugg!=ccn)
            {
                rs.close();
                changed();
            }
            rs.close();
             
      }
      catch(Exception ex)
      {
          System.out.println(ex+" chkSuggestions");
          error++;
    errhandler();
      }
 }
  
  ResultSet  rsup=null;
  Statement  stup=null;
 
  private void chkUpdates() {
        try{
            Class.forName(drv);
            stup=con.createStatement();
            String qry2="";
            qry2="select count(*) from "+cu.getText()+"ufr where name='$$@!!';";
            rsup=stup.executeQuery(qry2);
            rsup.next();
            int ccn=rsup.getInt(1);
            if(ccn!=0)
            {
                //System.out.println("----------------------------------------------");
                qry2="delete from "+cu.getText()+"ufr where name='$$@!!';";
                int vi=stup.executeUpdate(qry2);
                rsup.close();
                changed();
            }
            rsup.close();
        }
        catch(Exception ex)
        {
          System.out.println(ex+" updates");
          error++;
          errhandler();
        }
    }
   
 static int  chng=0; 
 
    public void changed()
{
        loadFreq();    
        getActv();
        lastAdd();    
        loadSuggestions();       
        //frndList();
        //frlsList();
         //
}   
    private void rrefresh() 
    {
    kl=1;
    th.stop();
    Cfm cf=new Cfm(cu.getText());
    cf.setVisible(true);
    this.dispose();
    }

 
public void notification()
{
    Statement sst=null;
    ResultSet rrs=null;
    //int listsz=dlm.size();
    try{
    sst=con.createStatement();
    try{
    for(int iit=0;lfl.getComponentCount()>iit;iit++)
    {
    frndarr[iit].chk();
    }
    }
    catch(NullPointerException ex){
        System.out.println(ex+" error in notification");
    }
    }
    catch(Exception ex)
    {
        System.out.println(ex+" error in notification");
        error++;
        errhandler();
    }  
}

   int lpd=0;
public void run() {
      for(;true;)
      {
         if(kl==0){
          holder.getVerticalScrollBar().setValue((holder.getVerticalScrollBar()).getMaximum());
          lpd++;
          if(error>=4)
           {
               kl=1;   
               recon.setVisible(false);
               break;   
           }
          else
          {
          if(ou.getText().equals("")||ou.getText().equals(" ")){}
          else{
                   try {Thread.sleep(1490);} 
                   catch (InterruptedException ex) 
                   {
                      System.out.println(ex+" in run");
                   }
                loadLfr();
                loadLast();
                
                //error in chkSuggestions();
               }
          chkUpdates();
          }
          
       } 
     }
  }
  private void errhandler()  {
      if(exitc>=2)
      {
          System.exit(0);
      }
      else if(error>=10)
     {
        JOptionPane.showMessageDialog(this, " Oops! Communcation failure \n "+
                "your request can not be proceed "
                 + "wait for network to be available(20-60 sec) "
                + "Or try restating your application"+error);
        recon.setVisible(true);
        try{
             try {
                 kl=1;
                 exitc++;
                 Thread.sleep(8000);
                 error=0;
                 rrefresh();
             } 
                   catch (InterruptedException ex) 
                   {
                      System.out.println(ex+" in run");
                   }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            System.exit(0);
        }
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
            java.util.logging.Logger.getLogger(Cfm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cfm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cfm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cfm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cfm("nkc").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a$$$$$1;
    private javax.swing.JButton a$$$$$10;
    private javax.swing.JButton a$$$$$11;
    private javax.swing.JButton a$$$$$12;
    private javax.swing.JButton a$$$$$13;
    private javax.swing.JButton a$$$$$14;
    private javax.swing.JButton a$$$$$15;
    private javax.swing.JButton a$$$$$16;
    private javax.swing.JButton a$$$$$17;
    private javax.swing.JButton a$$$$$18;
    private javax.swing.JButton a$$$$$2;
    private javax.swing.JButton a$$$$$3;
    private javax.swing.JButton a$$$$$4;
    private javax.swing.JButton a$$$$$5;
    private javax.swing.JButton a$$$$$6;
    private javax.swing.JButton a$$$$$7;
    private javax.swing.JButton a$$$$$8;
    private javax.swing.JButton a$$$$$9;
    private javax.swing.JComboBox act;
    private javax.swing.JPanel areq;
    private javax.swing.JScrollPane areqholder;
    private javax.swing.JPanel chatpane;
    private javax.swing.JPanel chatscreenholder;
    private javax.swing.JPanel chboard;
    public static javax.swing.JList chnls;
    private javax.swing.JScrollPane chnlsholder;
    private javax.swing.JButton closebutton;
    private javax.swing.JButton closebutton1;
    private javax.swing.JButton clr;
    private javax.swing.JLabel cu;
    private javax.swing.JPanel emojiholder;
    private javax.swing.JScrollPane emojiscroller;
    private javax.swing.JComboBox freqls;
    private javax.swing.JPanel friendrequestpane;
    public javax.swing.JList frls;
    private javax.swing.JScrollPane frlsholder;
    private javax.swing.JScrollPane frlsholder1;
    private javax.swing.JComboBox frndls;
    private javax.swing.JPanel gfl;
    public javax.swing.JList grls;
    private javax.swing.JPanel hiddenitems;
    private javax.swing.JScrollPane holder;
    private javax.swing.JTabbedPane innerframe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel lfl;
    private javax.swing.JButton logoutButton;
    private javax.swing.ButtonGroup lsts;
    private javax.swing.JButton mor;
    private javax.swing.JTextArea msb;
    private javax.swing.JLabel ou;
    private javax.swing.JLabel ou1;
    private javax.swing.JTabbedPane outerframe;
    private javax.swing.JLabel recon;
    private javax.swing.JButton refrl;
    private javax.swing.JScrollPane showingfriendlistholder;
    private javax.swing.JScrollPane showingfriendlistholder1;
    private javax.swing.JButton snb;
    private javax.swing.JPanel sreq;
    private javax.swing.JScrollPane sreqholder;
    private javax.swing.JPanel windowbuttonholder;
    // End of variables declaration//GEN-END:variables
}
