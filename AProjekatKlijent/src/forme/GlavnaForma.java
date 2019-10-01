/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domain.Postavka;
import domain.Zaposleni;
import exception.ServerDownException;
import forme.modelautomobila.FormaModelAutomobila;
import forme.modelautomobila.FormaPretragaModelaAutomobila;
import forme.postavka.FormaPostavka;
import forme.postavka.FormaPretragaPostavki;
import forme.postavka.model.ModelTabelaPostavka;
import forme.proizvodjac.FormaPretragaProizvodjaca;
import forme.proizvodjac.FormaProizvodjac;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import sesija.Sesija;

/**
 *
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() throws ServerDownException {
        initComponents();
        populateCurrentUser();
        try {
            srediTabelu();
        } catch (ServerDownException se) {
            this.dispose();
            throw se;
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

        panelUser = new javax.swing.JPanel();
        lblCurrent = new javax.swing.JLabel();
        labelCurrentUser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPostavke = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmProizvodjac = new javax.swing.JMenu();
        jmiUnosProizvodjaca = new javax.swing.JMenuItem();
        jmiPretragaProizvodjaca = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiUnosAutomobila = new javax.swing.JMenuItem();
        jmiPretragaAutomobila = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiUnosPostavke = new javax.swing.JMenuItem();
        jmiPretragaPostavki = new javax.swing.JMenuItem();
        jmiOdjava = new javax.swing.JMenu();
        jmiOdjaviSe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelUser.setBorder(javax.swing.BorderFactory.createTitledBorder("Zaposleni"));

        lblCurrent.setText("Trenutno ulogovan:");

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCurrentUser)
                    .addComponent(lblCurrent))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Trenutne postavke"));

        tblPostavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPostavke);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jmProizvodjac.setText("         Proizvođač");
        jmProizvodjac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmProizvodjac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmProizvodjac.setMaximumSize(new java.awt.Dimension(120, 32767));
        jmProizvodjac.setPreferredSize(new java.awt.Dimension(120, 30));

        jmiUnosProizvodjaca.setText("Unos");
        jmiUnosProizvodjaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosProizvodjacaActionPerformed(evt);
            }
        });
        jmProizvodjac.add(jmiUnosProizvodjaca);

        jmiPretragaProizvodjaca.setText("Pretraga");
        jmiPretragaProizvodjaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaProizvodjacaActionPerformed(evt);
            }
        });
        jmProizvodjac.add(jmiPretragaProizvodjaca);

        jMenuBar1.add(jmProizvodjac);

        jMenu2.setText("         Automobil");
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu2.setMaximumSize(new java.awt.Dimension(120, 32767));
        jMenu2.setPreferredSize(new java.awt.Dimension(120, 30));

        jmiUnosAutomobila.setText("Unos");
        jmiUnosAutomobila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosAutomobilaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiUnosAutomobila);

        jmiPretragaAutomobila.setText("Pretraga");
        jmiPretragaAutomobila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaAutomobilaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiPretragaAutomobila);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("           Postavka");
        jMenu3.setFocusTraversalPolicyProvider(true);
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setMaximumSize(new java.awt.Dimension(120, 32767));
        jMenu3.setPreferredSize(new java.awt.Dimension(120, 30));

        jmiUnosPostavke.setText("Unos");
        jmiUnosPostavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosPostavkeActionPerformed(evt);
            }
        });
        jMenu3.add(jmiUnosPostavke);

        jmiPretragaPostavki.setText("Pretraga");
        jmiPretragaPostavki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaPostavkiActionPerformed(evt);
            }
        });
        jMenu3.add(jmiPretragaPostavki);

        jMenuBar1.add(jMenu3);

        jmiOdjava.setText("            Odjava");
        jmiOdjava.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmiOdjava.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmiOdjava.setPreferredSize(new java.awt.Dimension(120, 30));

        jmiOdjaviSe.setText("Odjavi se");
        jmiOdjaviSe.setPreferredSize(new java.awt.Dimension(120, 30));
        jmiOdjaviSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOdjaviSeActionPerformed(evt);
            }
        });
        jmiOdjava.add(jmiOdjaviSe);

        jMenuBar1.add(jmiOdjava);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiUnosProizvodjacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosProizvodjacaActionPerformed

        try {
            JDialog formaNovi = new FormaProizvodjac(this, true, FormMode.NEW);
            formaNovi.setLocationRelativeTo(null);
            formaNovi.setVisible(true);
        } catch (ServerDownException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            Kontroler.getInstance().krajJe();
            LoginForma login = new LoginForma();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }
    }//GEN-LAST:event_jmiUnosProizvodjacaActionPerformed

    private void jmiPretragaProizvodjacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaProizvodjacaActionPerformed
        try {
            JDialog formaPretraga = new FormaPretragaProizvodjaca(this, true);
            formaPretraga.setLocationRelativeTo(null);
            formaPretraga.pack();
            formaPretraga.setVisible(true);
        } catch (ServerDownException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            Kontroler.getInstance().krajJe();
            LoginForma login = new LoginForma();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }
    }//GEN-LAST:event_jmiPretragaProizvodjacaActionPerformed

    private void jmiUnosAutomobilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosAutomobilaActionPerformed
        try {
            JDialog unosUD = new FormaModelAutomobila(this, true, FormMode.NEW);
            unosUD.setLocationRelativeTo(null);
            unosUD.pack();
            unosUD.setVisible(true);
        } catch (ServerDownException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            Kontroler.getInstance().krajJe();
            LoginForma login = new LoginForma();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }
    }//GEN-LAST:event_jmiUnosAutomobilaActionPerformed

    private void jmiPretragaAutomobilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaAutomobilaActionPerformed
        try {
            JDialog formaPretragaUD = new FormaPretragaModelaAutomobila(this, true);
            formaPretragaUD.setLocationRelativeTo(null);
            formaPretragaUD.pack();
            formaPretragaUD.setVisible(true);
        } catch (ServerDownException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            Kontroler.getInstance().krajJe();
            LoginForma login = new LoginForma();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }    }//GEN-LAST:event_jmiPretragaAutomobilaActionPerformed

    private void jmiUnosPostavkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosPostavkeActionPerformed
        try {
            JDialog formaUnosPostavke = new FormaPostavka(this, true);
            formaUnosPostavke.setLocationRelativeTo(null);
            formaUnosPostavke.pack();
            formaUnosPostavke.setVisible(true);
        } catch (ServerDownException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            Kontroler.getInstance().krajJe();
            LoginForma login = new LoginForma();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }    }//GEN-LAST:event_jmiUnosPostavkeActionPerformed

    private void jmiPretragaPostavkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaPostavkiActionPerformed

        try {
            JDialog formaPretragaPostavki = new FormaPretragaPostavki(this, true);
            formaPretragaPostavki.setLocationRelativeTo(null);
            formaPretragaPostavki.pack();
            formaPretragaPostavki.setVisible(true);
        } catch (ServerDownException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            Kontroler.getInstance().krajJe();
            LoginForma login = new LoginForma();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }
    }//GEN-LAST:event_jmiPretragaPostavkiActionPerformed

    private void jmiOdjaviSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOdjaviSeActionPerformed

        try {
            kontroler.Kontroler.getInstance().odjaviSe();
            this.dispose();
            LoginForma login = new LoginForma();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        } catch (ServerDownException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            Kontroler.getInstance().krajJe();
            LoginForma login = new LoginForma();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmiOdjaviSeActionPerformed

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
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GlavnaForma().setVisible(true);
                } catch (ServerDownException ex) {
                    Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmProizvodjac;
    private javax.swing.JMenu jmiOdjava;
    private javax.swing.JMenuItem jmiOdjaviSe;
    private javax.swing.JMenuItem jmiPretragaAutomobila;
    private javax.swing.JMenuItem jmiPretragaPostavki;
    private javax.swing.JMenuItem jmiPretragaProizvodjaca;
    private javax.swing.JMenuItem jmiUnosAutomobila;
    private javax.swing.JMenuItem jmiUnosPostavke;
    private javax.swing.JMenuItem jmiUnosProizvodjaca;
    private javax.swing.JLabel labelCurrentUser;
    private javax.swing.JLabel lblCurrent;
    private javax.swing.JPanel panelUser;
    private javax.swing.JTable tblPostavke;
    // End of variables declaration//GEN-END:variables

    private void populateCurrentUser() {
        Zaposleni zaposleni = Sesija.getInstance().getTrenutniZaposleni();
        labelCurrentUser.setText(zaposleni.getIme() + " " + zaposleni.getPrezime());
    }

    private void srediTabelu() throws ServerDownException {
        ModelTabelaPostavka mtp = new ModelTabelaPostavka();
        mtp.prikaziPostavkeNaOsnovuPretrage("U_TOKU", "Status");
        tblPostavke.setModel(mtp);

        tblPostavke.getColumnModel().removeColumn(tblPostavke.getColumnModel().getColumn(6));
    }

    public void serverZaustavljen() {
        this.dispose();
        Kontroler.getInstance().krajJe();
        LoginForma login = new LoginForma();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    public void dodajPostavku(Postavka postavka) {
        ModelTabelaPostavka mtp = (ModelTabelaPostavka) tblPostavke.getModel();
        mtp.dodaj(postavka);
    }
}