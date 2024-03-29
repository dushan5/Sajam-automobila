/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.postavka;

import domain.Postavka;
import exception.ServerDownException;
import forme.postavka.model.ModelTabelaPostavka;
import forme.postavka.model.ModelTabeleMAUPostavci;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikola
 */
public class FormaPretragaPostavki extends javax.swing.JDialog {

    /**
     * Creates new form FormaPretragaPostavki
     */
    public FormaPretragaPostavki(java.awt.Frame parent, boolean modal) throws ServerDownException {
        super(parent, modal);
        initComponents();
        try {
            popuniKombo();
            srediTabeluPostavke();
            srediTabeluModeliA();
        } catch (ServerDownException ex) {
            this.dispose();
            throw ex;
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

        panelPretraga = new javax.swing.JPanel();
        lblPolje = new javax.swing.JLabel();
        lblVrednostPretrage = new javax.swing.JLabel();
        comboPolje = new javax.swing.JComboBox();
        btnPretraziIzlozbe = new javax.swing.JButton();
        btnObrisiFilter = new javax.swing.JButton();
        txtVrednostPretrage = new javax.swing.JTextField();
        btnIzadji = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPostavke = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblModeliAutomobila = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelPretraga.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga"));

        lblPolje.setText("Izaberite polje:");

        lblVrednostPretrage.setText("Unesite vrednost:");

        btnPretraziIzlozbe.setText("Pretraži");
        btnPretraziIzlozbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziIzlozbeActionPerformed(evt);
            }
        });

        btnObrisiFilter.setText("Obriši filter");
        btnObrisiFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPretragaLayout = new javax.swing.GroupLayout(panelPretraga);
        panelPretraga.setLayout(panelPretragaLayout);
        panelPretragaLayout.setHorizontalGroup(
            panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretragaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPretragaLayout.createSequentialGroup()
                        .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblVrednostPretrage)
                            .addComponent(lblPolje))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPolje, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVrednostPretrage)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPretragaLayout.createSequentialGroup()
                        .addGap(0, 97, Short.MAX_VALUE)
                        .addComponent(btnObrisiFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPretraziIzlozbe, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelPretragaLayout.setVerticalGroup(
            panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretragaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPolje)
                    .addComponent(comboPolje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVrednostPretrage)
                    .addComponent(txtVrednostPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisiFilter)
                    .addComponent(btnPretraziIzlozbe))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIzadji.setText("Izadji");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Postavke"));

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
        tblPostavke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPostavkeMouseReleased(evt);
            }
        });
        tblPostavke.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPostavkeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPostavke);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Modeli automobila na postavci"));

        tblModeliAutomobila.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblModeliAutomobila);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziIzlozbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziIzlozbeActionPerformed
        ModelTabelaPostavka mtp = (ModelTabelaPostavka) tblPostavke.getModel();

        boolean uspesno = mtp.prikaziPostavkeNaOsnovuPretrage(txtVrednostPretrage.getText(), (String) comboPolje.getSelectedItem());
        tblModeliAutomobila.setModel(new ModelTabeleMAUPostavci());
        if (uspesno) {
            JOptionPane.showMessageDialog(this, "Pretraga je završena!");
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe postavke po zadatoj vrednosti!", "Neuspešna pretraga", JOptionPane.ERROR_MESSAGE);
            obrisiFilter();
        }
    }//GEN-LAST:event_btnPretraziIzlozbeActionPerformed

    private void btnObrisiFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiFilterActionPerformed
        obrisiFilter();
    }//GEN-LAST:event_btnObrisiFilterActionPerformed

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void tblPostavkeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPostavkeMouseReleased

        int red = tblPostavke.getSelectedRow();
        ModelTabelaPostavka mtp = (ModelTabelaPostavka) tblPostavke.getModel();
        ModelTabeleMAUPostavci mtu = (ModelTabeleMAUPostavci) tblModeliAutomobila.getModel();
        Postavka postavka = mtp.vratiIzlozbuZaRed(red);
        if (red > -1) {
            mtu.postaviListu(postavka.getListaModela());
        } else {
            JOptionPane.showMessageDialog(this, "Niste izabrali model automobila koji želite da prikažete!");
    }//GEN-LAST:event_tblPostavkeMouseReleased
    }
    private void tblPostavkeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPostavkeKeyReleased
    }//GEN-LAST:event_tblPostavkeKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnObrisiFilter;
    private javax.swing.JButton btnPretraziIzlozbe;
    private javax.swing.JComboBox comboPolje;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPolje;
    private javax.swing.JLabel lblVrednostPretrage;
    private javax.swing.JPanel panelPretraga;
    private javax.swing.JTable tblModeliAutomobila;
    private javax.swing.JTable tblPostavke;
    private javax.swing.JTextField txtVrednostPretrage;
    // End of variables declaration//GEN-END:variables

    private void popuniKombo() {
        comboPolje.removeAllItems();
        comboPolje.addItem("Sifra");
        comboPolje.addItem("Naziv");
        comboPolje.addItem("Status");
        comboPolje.addItem("Grad");
        comboPolje.addItem("Model automobila");
    }

    private void srediTabeluPostavke() throws ServerDownException {
        ModelTabelaPostavka mtp = new ModelTabelaPostavka();
        tblPostavke.setModel(mtp);
    }

    private void srediTabeluModeliA() {
        ModelTabeleMAUPostavci mtu = new ModelTabeleMAUPostavci();
        tblModeliAutomobila.setModel(mtu);
        tblModeliAutomobila.getColumnModel().removeColumn(tblModeliAutomobila.getColumnModel().getColumn(6));
    }

    private void obrisiFilter() {
        ModelTabelaPostavka mtp = (ModelTabelaPostavka) tblPostavke.getModel();
        tblModeliAutomobila.setModel(new ModelTabeleMAUPostavci());
        comboPolje.getModel().setSelectedItem("Sifra");
        txtVrednostPretrage.setText("");
        mtp.prikaziPostavkeNaOsnovuPretrage("", (String) comboPolje.getSelectedItem());
    }
}
