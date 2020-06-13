/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.user;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class HomePage extends JFrame {

    static JButton[] butonlar = new JButton[6];
    userManager loginManager;
    static int dk = 20;
    static int sn = 60;
    Timer myTimer = new Timer();
    TimerTask gorev;
    private boolean started;
    static int programSuresi;
    static String toplamIzlenmeSuresi;
    static int proID;

    public HomePage(userManager manage) {

        initComponents();
        this.loginManager = manage;

        butonlar[0] = f1;
        butonlar[1] = f2;
        butonlar[2] = f3;
        butonlar[3] = f4;
        butonlar[4] = f5;
        butonlar[5] = f6;

        int c = 0;

        try {
            for (int k = 0; k < 3; k++) {

                ResultSet rs = (new dataThings()).onerilenGetir(manage.getKullanici().getTur(k));

                for (int y = 0; y < 2; y++) {
                    butonlar[c].setText(rs.getString("proName").toString());
                    rs.next();
                    butonlar[c + 1].setText(rs.getString("proName").toString());
                }
                c += 2;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs2 = (new dataThings()).tumFilmGetir();
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();

        try {
            model.addRow(new Object[]{rs2.getString("proName"), rs2.getInt("proUzunlugu"), rs2.getString("proTip"), rs2.getInt("proBolumSayisi"), rs2.getInt("proPuani")});
            while (rs2.next()) {

                model.addRow(new Object[]{rs2.getString("proName"), rs2.getInt("proUzunlugu"), rs2.getString("proTip"), rs2.getInt("proBolumSayisi"), rs2.getInt("proPuani")
                });

            }
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

        search.getDocument()
                .addDocumentListener(new DocumentListener() {
                    @Override
                    public void changedUpdate(DocumentEvent e
                    ) {

                    }

                    @Override
                    public void removeUpdate(DocumentEvent e
                    ) {

                    }

                    @Override
                    public void insertUpdate(DocumentEvent e
                    ) {

                        String text = search.getText();

                        ResultSet rs2 = new dataThings().searchFilm(text);

                        DefaultTableModel model = (DefaultTableModel) tablo.getModel();

                        model.setRowCount(0);

                        try {
                            if (rs2 != null) {
                                model.addRow(new Object[]{rs2.getString("proName"), rs2.getInt("proUzunlugu"), rs2.getString("proTip"), rs2.getInt("proBolumSayisi"), rs2.getInt("proPuani")});

                                while (rs2.next()) {

                                    model.addRow(new Object[]{rs2.getString("proName"), rs2.getInt("proUzunlugu"), rs2.getString("proTip"), rs2.getInt("proBolumSayisi"), rs2.getInt("proPuani")
                                    });

                                }
                            }

                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        model.fireTableDataChanged();
                        tablo.setModel(model);
                    }

                }
                );

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        f3 = new javax.swing.JButton();
        f1 = new javax.swing.JButton();
        f4 = new javax.swing.JButton();
        f5 = new javax.swing.JButton();
        f6 = new javax.swing.JButton();
        f2 = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo = new javax.swing.JTable();
        filmiGoruntule = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        L_adi = new javax.swing.JLabel();
        L_puani = new javax.swing.JLabel();
        L_Tur = new javax.swing.JLabel();
        L_bolumS = new javax.swing.JLabel();
        L_sure = new javax.swing.JLabel();
        textPuan = new javax.swing.JTextField();
        Kaydet = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablo2 = new javax.swing.JTable();
        izlemeyeBasla = new javax.swing.JButton();
        durdur = new javax.swing.JButton();
        L_izlenilenSure = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        f3.setBackground(new java.awt.Color(0, 0, 0));
        f3.setForeground(new java.awt.Color(255, 255, 255));

        f1.setBackground(new java.awt.Color(0, 0, 0));
        f1.setForeground(new java.awt.Color(255, 255, 255));

        f4.setBackground(new java.awt.Color(0, 0, 0));
        f4.setForeground(new java.awt.Color(255, 255, 255));

        f5.setBackground(new java.awt.Color(0, 0, 0));
        f5.setForeground(new java.awt.Color(255, 255, 255));

        f6.setBackground(new java.awt.Color(0, 0, 0));
        f6.setForeground(new java.awt.Color(255, 255, 255));

        f2.setBackground(new java.awt.Color(0, 0, 0));
        f2.setForeground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setText("icerik ara:");

        tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProgramAdi", "Suresi", "Turu", "BolumSayisi", "Puani"
            }
        ));
        tablo.setRowHeight(25);
        jScrollPane1.setViewportView(tablo);

        filmiGoruntule.setText("filmi goruntule");
        filmiGoruntule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmiGoruntuleActionPerformed(evt);
            }
        });

        jLabel1.setText("film adi:");

        jLabel2.setText("puani:");

        jLabel3.setText("suresi:");

        jLabel4.setText("bolumSayisi:");

        jLabel5.setText("turu:");

        L_adi.setBackground(new java.awt.Color(204, 204, 204));
        L_adi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L_adi.setForeground(new java.awt.Color(255, 255, 255));

        L_puani.setBackground(new java.awt.Color(153, 0, 0));
        L_puani.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L_puani.setForeground(new java.awt.Color(255, 255, 255));

        L_Tur.setBackground(new java.awt.Color(204, 204, 204));
        L_Tur.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L_Tur.setForeground(new java.awt.Color(255, 255, 255));

        L_bolumS.setBackground(new java.awt.Color(204, 204, 204));
        L_bolumS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L_bolumS.setForeground(new java.awt.Color(255, 255, 255));

        L_sure.setBackground(new java.awt.Color(204, 204, 204));
        L_sure.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L_sure.setForeground(new java.awt.Color(255, 255, 255));

        textPuan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        Kaydet.setText("kaydet");
        Kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KaydetActionPerformed(evt);
            }
        });

        tablo2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "bolumAdi"
            }
        ));
        jScrollPane2.setViewportView(tablo2);

        izlemeyeBasla.setText("izlemeye basla");
        izlemeyeBasla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izlemeyeBaslaActionPerformed(evt);
            }
        });

        durdur.setText("durdur");
        durdur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durdurActionPerformed(evt);
            }
        });

        L_izlenilenSure.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        L_izlenilenSure.setForeground(new java.awt.Color(255, 255, 255));
        L_izlenilenSure.setText("sure");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sizin Icin Onerdiklerimiz");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NETFLIX'I SECTİGİNİZ İCİN TESEKKURLER...");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Puan Ver:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(izlemeyeBasla)
                                .addGap(45, 45, 45)
                                .addComponent(L_izlenilenSure, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(durdur)
                                .addGap(55, 55, 55))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(70, 70, 70)
                                    .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60)
                                    .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60)
                                    .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(58, 58, 58)
                                    .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filmiGoruntule)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56)
                                        .addComponent(L_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(L_Tur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L_bolumS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L_puani, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L_sure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(321, 321, 321)))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPuan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Kaydet)
                            .addComponent(jLabel8))
                        .addGap(559, 559, 559))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filmiGoruntule)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(L_adi))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(L_puani))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_bolumS))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(L_Tur))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(L_sure)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(izlemeyeBasla)
                                .addComponent(L_izlenilenSure)
                                .addComponent(durdur))
                            .addGap(56, 56, 56)
                            .addComponent(jLabel8)
                            .addGap(26, 26, 26)
                            .addComponent(textPuan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(Kaydet))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(106, 106, 106))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filmiGoruntuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmiGoruntuleActionPerformed

        if (this.started == true) {
            L_izlenilenSure.setText("");
            myTimer.cancel();
        }

        int row = tablo.getSelectedRow();
        String str = tablo.getValueAt(row, 0).toString();
        ResultSet rs = (new dataThings()).filmBilgisiGetir(str);

        try {
            this.dk = rs.getInt("proUzunlugu") - 1;
            this.programSuresi = rs.getInt("proUzunlugu") - 1;
            L_adi.setText(rs.getString("proName"));
            L_Tur.setText(rs.getString("proTip"));
            L_bolumS.setText(rs.getString("proBolumSayisi"));
            L_puani.setText(rs.getString("proPuani"));
            L_sure.setText(rs.getString("proUzunlugu"));

            proID = rs.getInt("programID");

        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            DefaultTableModel model = (DefaultTableModel) tablo2.getModel();
            model.setRowCount(0);
            for (int i = 0; i < rs.getInt("proBolumSayisi"); i++) {
                model.addRow(new Object[]{"bolum " + (i + 1)});

            }
            tablo2.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_filmiGoruntuleActionPerformed

    private void izlemeyeBaslaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izlemeyeBaslaActionPerformed

        ResultSet rs = (new dataThings()).izlenmeBilgisiGetir(loginManager.getKullanici().getKullaniciID(), proID);

        try {
            if (rs != null) {

                String[] str = rs.getString("KacinciDkKaldi").split(":");
                dk = programSuresi - Integer.parseInt(str[0].trim());
                sn = 60 - Integer.parseInt(str[1].trim());

            } else {

                dk = programSuresi;
                sn = 60;

            }

        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

        myTimer = new Timer();
        gorev = new TimerTask() {

            @Override
            public void run() {

                started = true;

                if (dk == 0 && sn == 0) {
                    L_izlenilenSure.setText("bolum bitti");
                    started = false;
                    myTimer.cancel();
                } else {
                    if (sn == 0) {
                        sn = 60;
                        dk--;
                    }
                    L_izlenilenSure.setText(dk + " : " + sn + "");
                    sn--;
                }
            }

        };

        myTimer.schedule(gorev, 0, 100);


    }//GEN-LAST:event_izlemeyeBaslaActionPerformed

    private void durdurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durdurActionPerformed

        if (this.started == true) {

            myTimer.cancel();
            toplamIzlenmeSuresi = (programSuresi - dk) + " : " + (60 - sn); // toplam izlenme süresi

        }


    }//GEN-LAST:event_durdurActionPerformed

    private void KaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KaydetActionPerformed

        ResultSet rs = (new dataThings()).izlenmeBilgisiGetir(loginManager.getKullanici().getKullaniciID(), proID);

        try {
            if (rs != null) {

                if (!textPuan.getText().equals("")) {

                    String[] str = rs.getString("KacinciDkKaldi").split(":");
                    int dkx = programSuresi - Integer.parseInt(str[0].trim());
                    int sny = 60 - Integer.parseInt(str[1].trim());
                    toplamIzlenmeSuresi = (-1 * (dk + dkx - (2 * programSuresi))) + " : " + (30);
                    (new dataThings()).izlenmeBilgisiUpdate(loginManager.getKullanici().getKullaniciID(), proID, toplamIzlenmeSuresi, Integer.parseInt(textPuan.getText()));
                    JOptionPane.showMessageDialog(null, "Program ile Islemleriniz Kaydedildi..");

                } else {
                    JOptionPane.showMessageDialog(null, "Lutfen Puan Veriniz..");
                }

            } else {

                if (!textPuan.getText().equals("")) {

                    int row = tablo2.getSelectedRow();

                    (new dataThings()).kullaniciProTabloyaEkle(loginManager.getKullanici().getKullaniciID(), proID, toplamIzlenmeSuresi, row + 1, Integer.parseInt(textPuan.getText()));

                    JOptionPane.showMessageDialog(null, "Program ile Islemleriniz Kaydedildi..");
                } else {
                    JOptionPane.showMessageDialog(null, "Lutfen Puan Veriniz..");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_KaydetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kaydet;
    private javax.swing.JLabel L_Tur;
    private javax.swing.JLabel L_adi;
    private javax.swing.JLabel L_bolumS;
    private javax.swing.JLabel L_izlenilenSure;
    private javax.swing.JLabel L_puani;
    private javax.swing.JLabel L_sure;
    private javax.swing.JButton durdur;
    private javax.swing.JButton f1;
    private javax.swing.JButton f2;
    private javax.swing.JButton f3;
    private javax.swing.JButton f4;
    private javax.swing.JButton f5;
    private javax.swing.JButton f6;
    private javax.swing.JButton filmiGoruntule;
    private javax.swing.JButton izlemeyeBasla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField search;
    private javax.swing.JTable tablo;
    private javax.swing.JTable tablo2;
    private javax.swing.JTextField textPuan;
    // End of variables declaration//GEN-END:variables

}
