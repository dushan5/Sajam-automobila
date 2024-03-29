/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.proizvodjac;

import domain.Proizvodjac;
import exception.ServerDownException;
import forme.FormMode;
import forme.GlavnaForma;
import forme.proizvodjac.model.ModelTabelaProizvodjac;
import javax.swing.JOptionPane;
import sesija.Sesija;

/**
 *
 * @author Nikola
 */
public class FormaPretragaProizvodjaca extends javax.swing.JDialog {

    /**
     * Creates new form FormaPretragaProizvodjaca
     */
    public FormaPretragaProizvodjaca(java.awt.Frame parent, boolean modal) throws ServerDownException {
        super(parent, modal);
        initComponents();
        popuniKombo();
        srediTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProiyvodjacii = new javax.swing.JTable();
        panelPretraga = new javax.swing.JPanel();
        komboPolje = new javax.swing.JComboBox();
        txtVrednostPretrage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPretraziUmetnike = new javax.swing.JButton();
        btnObrisiFilter = new javax.swing.JButton();
        btnPrikaziProizvodjaca = new javax.swing.JButton();
        btnIzadji = new javax.swing.JButton();
        btnIzbrisiProizvodjaca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblProiyvodjacii.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProiyvodjacii.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProiyvodjaciiMouseReleased(evt);
            }
        });
        tblProiyvodjacii.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblProiyvodjaciiPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblProiyvodjacii);

        panelPretraga.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga"));

        txtVrednostPretrage.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtVrednostPretrageInputMethodTextChanged(evt);
            }
        });
        txtVrednostPretrage.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtVrednostPretragePropertyChange(evt);
            }
        });
        txtVrednostPretrage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVrednostPretrageKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVrednostPretrageKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVrednostPretrageKeyTyped(evt);
            }
        });

        jLabel1.setText("Izaberite polje:");

        jLabel2.setText("Unesite vrednost:");

        btnPretraziUmetnike.setText("Pretraži");
        btnPretraziUmetnike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziUmetnikeActionPerformed(evt);
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
                .addGap(27, 27, 27)
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVrednostPretrage, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPretragaLayout.createSequentialGroup()
                        .addComponent(btnObrisiFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPretraziUmetnike, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(komboPolje, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        panelPretragaLayout.setVerticalGroup(
            panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretragaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(komboPolje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15)
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVrednostPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisiFilter)
                    .addComponent(btnPretraziUmetnike))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPrikaziProizvodjaca.setText("Detaljnije");
        btnPrikaziProizvodjaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziProizvodjacaActionPerformed(evt);
            }
        });

        btnIzadji.setText("Izađi");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        btnIzbrisiProizvodjaca.setText("Izbriši proizvođača");
        btnIzbrisiProizvodjaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiProizvodjacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnIzbrisiProizvodjaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPrikaziProizvodjaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIzbrisiProizvodjaca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrikaziProizvodjaca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProiyvodjaciiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProiyvodjaciiMouseReleased

        int red = tblProiyvodjacii.getSelectedRow();
        if (red == -1) {
            return;
        }
        ModelTabelaProizvodjac mtp = (ModelTabelaProizvodjac) tblProiyvodjacii.getModel();

        Proizvodjac p = mtp.vratiProizvodjacaURedu(red);
        Sesija.getInstance().getUseCaseParams().put("izabraniProizvođač", p);
    }//GEN-LAST:event_tblProiyvodjaciiMouseReleased

    private void tblProiyvodjaciiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblProiyvodjaciiPropertyChange

    }//GEN-LAST:event_tblProiyvodjaciiPropertyChange

    private void txtVrednostPretrageInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtVrednostPretrageInputMethodTextChanged

    }//GEN-LAST:event_txtVrednostPretrageInputMethodTextChanged

    private void txtVrednostPretragePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtVrednostPretragePropertyChange

    }//GEN-LAST:event_txtVrednostPretragePropertyChange

    private void txtVrednostPretrageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVrednostPretrageKeyPressed

    }//GEN-LAST:event_txtVrednostPretrageKeyPressed

    private void txtVrednostPretrageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVrednostPretrageKeyReleased
        //najbolji
    }//GEN-LAST:event_txtVrednostPretrageKeyReleased

    private void txtVrednostPretrageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVrednostPretrageKeyTyped

    }//GEN-LAST:event_txtVrednostPretrageKeyTyped

    private void btnPretraziUmetnikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziUmetnikeActionPerformed
        ModelTabelaProizvodjac mtp = (ModelTabelaProizvodjac) tblProiyvodjacii.getModel();

        boolean uspesno = mtp.prikaziProizvodjaceNaOsnovuPretrage(txtVrednostPretrage.getText(), (String) komboPolje.getSelectedItem());
        if (uspesno) {
            JOptionPane.showMessageDialog(this, "Pretraga je završena!", "Uspešna pretraga", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe proizvođače po zadatoj vrednosti!", "Neuspešna pretraga", JOptionPane.ERROR_MESSAGE);
            obrisiFilter();
        }
    }//GEN-LAST:event_btnPretraziUmetnikeActionPerformed

    private void btnObrisiFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiFilterActionPerformed
        obrisiFilter();
    }//GEN-LAST:event_btnObrisiFilterActionPerformed

    private void btnPrikaziProizvodjacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziProizvodjacaActionPerformed
        try {
            if (postojiIzabraniProizvodjac()) {
                FormaProizvodjac formaPrikaz = new FormaProizvodjac(null, true, FormMode.VIEW);
                formaPrikaz.setDialogPretraga(this);
                JOptionPane.showMessageDialog(this, "Odabrani proizvođač je pronađen!");
                formaPrikaz.setAlwaysOnTop(true);
                formaPrikaz.setLocationRelativeTo(null);
                formaPrikaz.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Sistem ne može da nađe podatke o proizvođaču!",
                        "Neuspešna pretraga", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ServerDownException se) {
            JOptionPane.showMessageDialog(this, se.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            serverZaustavljen();
        }
    }//GEN-LAST:event_btnPrikaziProizvodjacaActionPerformed
    private boolean postojiIzabraniProizvodjac() {
        if (tblProiyvodjacii.getSelectedRow() == -1) {
            return false;
        }
        return true;
    }
    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void btnIzbrisiProizvodjacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiProizvodjacaActionPerformed
        int red = tblProiyvodjacii.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Niste izabrali nijednog proizvođača!");
            return;
        }
        ModelTabelaProizvodjac mtp = (ModelTabelaProizvodjac) tblProiyvodjacii.getModel();

        Proizvodjac p = mtp.vratiProizvodjacaURedu(red);
        try {
            String poruka = kontroler.Kontroler.getInstance().izbrisiProizvodjaca(p);
            mtp.setProizvodjaci(kontroler.Kontroler.getInstance().vratiProizvodjace());
            JOptionPane.showMessageDialog(this, poruka, "Uspešno brisanje", JOptionPane.INFORMATION_MESSAGE);
        } catch (ServerDownException se) {
            JOptionPane.showMessageDialog(this, se.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            GlavnaForma fr = (GlavnaForma) this.getParent();
            fr.serverZaustavljen();
            return;
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Neuspešno brisanje", JOptionPane.ERROR_MESSAGE);
            exception.getMessage();
        }
        Sesija.getInstance().getUseCaseParams().put("izabraniUmetnik", null);
    }//GEN-LAST:event_btnIzbrisiProizvodjacaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnIzbrisiProizvodjaca;
    private javax.swing.JButton btnObrisiFilter;
    private javax.swing.JButton btnPretraziUmetnike;
    private javax.swing.JButton btnPrikaziProizvodjaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox komboPolje;
    private javax.swing.JPanel panelPretraga;
    private javax.swing.JTable tblProiyvodjacii;
    private javax.swing.JTextField txtVrednostPretrage;
    // End of variables declaration//GEN-END:variables

    void serverZaustavljen() {
        this.dispose();
        GlavnaForma fr = (GlavnaForma) this.getParent();
        fr.serverZaustavljen();
    }

    private void popuniKombo() {
        komboPolje.removeAllItems();
        komboPolje.addItem("Naziv");
        komboPolje.addItem("Osnivač");
        komboPolje.addItem("Rukovodilac");
        komboPolje.addItem("Telefon");
        komboPolje.addItem("Grad");
    }

    private void srediTabelu() throws ServerDownException {
        ModelTabelaProizvodjac mtp = new ModelTabelaProizvodjac();
        tblProiyvodjacii.setModel(mtp);
    }

    private void obrisiFilter() {
        ModelTabelaProizvodjac mtp = (ModelTabelaProizvodjac) tblProiyvodjacii.getModel();

        komboPolje.getModel().setSelectedItem("Sifra");
        txtVrednostPretrage.setText("");
        mtp.prikaziUmetnikeNaOsnovuPretrage("", (String) komboPolje.getSelectedItem());
    }
}
