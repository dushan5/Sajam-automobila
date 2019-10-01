/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.postavka;

import domain.Grad;
import domain.ModelAutomobila;
import domain.Postavka;
import domain.StatusModela;
import domain.StatusPostavke;
import domain.Zaposleni;
import exception.ServerDownException;
import forme.GlavnaForma;
import forme.postavka.model.ModelTabeleMA2;
import forme.postavka.model.ModelTabeleMAUPostavci;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import sesija.Sesija;

/**
 *
 * @author Nikola
 */
public class FormaPostavka extends javax.swing.JDialog {

    /**
     * Creates new form FormaPostavka
     */
    public FormaPostavka(java.awt.Frame parent, boolean modal) throws ServerDownException {
        super(parent, modal);
        initComponents();
        try {
            popuniKomboGrad();
            postaviZaposlenog();
            postaviDugmeSacuvajNaEnabledFalse();
            srediTabele();
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

        txtNaziv = new javax.swing.JTextField();
        comboGrad = new javax.swing.JComboBox();
        lblGrad = new javax.swing.JLabel();
        lblNaziv = new javax.swing.JLabel();
        lblDatumOd = new javax.swing.JLabel();
        txtKreirao = new javax.swing.JTextField();
        lblDatumDo = new javax.swing.JLabel();
        lblKreirao = new javax.swing.JLabel();
        txtDatumOD = new com.toedter.calendar.JDateChooser();
        txtDatumDo = new com.toedter.calendar.JDateChooser();
        panelUDnaIzlozbi = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblmodelinaPostavci = new javax.swing.JTable();
        btnUkloni = new javax.swing.JButton();
        btnProveraStatusa = new javax.swing.JButton();
        btnIzadji = new javax.swing.JButton();
        btnSacuvajPostavku = new javax.swing.JButton();
        panelUD = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModeliAutomobila = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblGrad.setText("Grad:");

        lblNaziv.setText("Naziv:");

        lblDatumOd.setText("Datum početka:");

        txtKreirao.setEditable(false);

        lblDatumDo.setText("Datum završetka:");

        lblKreirao.setText("Kreirao:");

        panelUDnaIzlozbi.setBorder(javax.swing.BorderFactory.createTitledBorder("Modeli automobila na postavci"));

        tblmodelinaPostavci.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblmodelinaPostavci);

        btnUkloni.setText("Ukloni");
        btnUkloni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUDnaIzlozbiLayout = new javax.swing.GroupLayout(panelUDnaIzlozbi);
        panelUDnaIzlozbi.setLayout(panelUDnaIzlozbiLayout);
        panelUDnaIzlozbiLayout.setHorizontalGroup(
            panelUDnaIzlozbiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUDnaIzlozbiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUkloni, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelUDnaIzlozbiLayout.setVerticalGroup(
            panelUDnaIzlozbiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUDnaIzlozbiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUDnaIzlozbiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUkloni, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnProveraStatusa.setText("Proveri statuse");
        btnProveraStatusa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveraStatusaActionPerformed(evt);
            }
        });

        btnIzadji.setText("Izadji");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        btnSacuvajPostavku.setText("Sačuvaj postavku");
        btnSacuvajPostavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajPostavkuActionPerformed(evt);
            }
        });

        panelUD.setBorder(javax.swing.BorderFactory.createTitledBorder("Raspoloživi modeli automobila"));

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
        jScrollPane1.setViewportView(tblModeliAutomobila);

        btnDodaj.setText("Dodaj na postavku");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUDLayout = new javax.swing.GroupLayout(panelUD);
        panelUD.setLayout(panelUDLayout);
        panelUDLayout.setHorizontalGroup(
            panelUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDodaj)
                .addContainerGap())
        );
        panelUDLayout.setVerticalGroup(
            panelUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblGrad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNaziv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDatumDo)
                    .addComponent(lblDatumOd)
                    .addComponent(lblKreirao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKreirao)
                    .addComponent(txtDatumOD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDatumDo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
            .addComponent(panelUDnaIzlozbi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(btnProveraStatusa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvajPostavku, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKreirao)
                            .addComponent(txtKreirao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatumOd)
                            .addComponent(txtDatumOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatumDo)
                            .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNaziv)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGrad)
                            .addComponent(comboGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(panelUDnaIzlozbi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProveraStatusa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSacuvajPostavku, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUkloniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniActionPerformed

        ModelTabeleMAUPostavci mtu = (ModelTabeleMAUPostavci) tblmodelinaPostavci.getModel();
        ModelTabeleMA2 mtu2 = (ModelTabeleMA2) tblModeliAutomobila.getModel();
        if (mtu.getUmetnickaDela().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ne postoji nijedan model na postavci!");
            return;
        }
        int red = tblmodelinaPostavci.getSelectedRow();
        if (red > -1) {
            ModelAutomobila model = mtu.vratiModelAutomobilaURedu(red);
            mtu2.dodajMA(model);
            mtu.skloniMA(model);
        } else {
            JOptionPane.showMessageDialog(this, "Niste izabrali model koji želite da uklonite!");
        }
    }//GEN-LAST:event_btnUkloniActionPerformed

    private void btnProveraStatusaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveraStatusaActionPerformed

        Date datumOd = txtDatumOD.getDate();
        Date datumDo = txtDatumDo.getDate();

        if (datumDo == null || datumOd == null) {
            JOptionPane.showMessageDialog(this, "Morate uneti datum kako biste proverili raspoloživost umetničkih dela!");
            return;
        }

        if (datumOd.after(datumDo)) {
            JOptionPane.showMessageDialog(this, "Datum početka mora biti pre datuma završetka izložbe!");
            return;
        }

        ModelTabeleMAUPostavci mtu = (ModelTabeleMAUPostavci) tblmodelinaPostavci.getModel();
        List<ModelAutomobila> listaMA = mtu.getUmetnickaDela();

        try {
            kontroler.Kontroler.getInstance().postaviStatuseModelimaAutomobila(listaMA, datumOd, datumDo);
            mtu.postaviListu(listaMA);
            btnSacuvajPostavku.setEnabled(true);
        } catch (ServerDownException se) {
            JOptionPane.showMessageDialog(this, se.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            GlavnaForma fr = (GlavnaForma) this.getParent();
            fr.serverZaustavljen();
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, String.format("%s", ex.getMessage()), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProveraStatusaActionPerformed

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed

    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void btnSacuvajPostavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajPostavkuActionPerformed

        String naziv = txtNaziv.getText();
        Date datumOd = txtDatumOD.getDate();
        Date datumDo = txtDatumDo.getDate();
        Zaposleni kreirao = Sesija.getInstance().getTrenutniZaposleni();
        Grad grad = (Grad) comboGrad.getSelectedItem();

        if (naziv.isEmpty() || datumDo == null || datumOd == null || kreirao == null || grad == null) {
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna!");
            return;
        }

        if (datumOd.after(datumDo)) {
            JOptionPane.showMessageDialog(this, "Datum početka mora biti pre datuma završetka postavke!");
            return;
        }

        ModelTabeleMAUPostavci mtu = (ModelTabeleMAUPostavci) tblmodelinaPostavci.getModel();
        List<ModelAutomobila> listaMA = mtu.getModeleAutomobila();
        if (listaMA.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ne možete kreirati postavku bez modela automobila!");
            return;
        }

        try {
            kontroler.Kontroler.getInstance().postaviStatuseModelimaAutomobila(listaMA, datumOd, datumDo);
            mtu.postaviListu(listaMA);

            for (ModelAutomobila modelautomobila : listaMA) {
                if (modelautomobila.getStatus() == StatusModela.IZLOZEN) {
                    JOptionPane.showMessageDialog(this, "Ne možete sačuvati postavku jer postoji model koji je izložen u tom periodu!");
                    return;
                }
            }
        } catch (ServerDownException se) {
            JOptionPane.showMessageDialog(this, se.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            GlavnaForma fr = (GlavnaForma) this.getParent();
            fr.serverZaustavljen();
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, String.format("%s", ex.getMessage()), "Greška", JOptionPane.ERROR_MESSAGE);
        }

        Postavka postavka = new Postavka(-1l, naziv, datumOd, datumDo, kreirao, grad, listaMA);
        try {

            String poruka = kontroler.Kontroler.getInstance().sacuvajPostavku(postavka);

            GlavnaForma g = (GlavnaForma) SwingUtilities.getWindowAncestor(this);
            if (postavka.getStatus() == StatusPostavke.U_TOKU) {
                g.dodajPostavku(postavka);
            }
            JOptionPane.showMessageDialog(this, poruka, "Uspešan unos", JOptionPane.INFORMATION_MESSAGE);
        } catch (ServerDownException se) {
            JOptionPane.showMessageDialog(this, se.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            GlavnaForma fr = (GlavnaForma) this.getParent();
            fr.serverZaustavljen();
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Neuspešan unos", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btnSacuvajPostavkuActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        int red = tblModeliAutomobila.getSelectedRow();
        if (red > -1) {
            ModelTabeleMA2 mt2 = (ModelTabeleMA2) tblModeliAutomobila.getModel();
            ModelAutomobila model = mt2.vratiModelAutomobilaURedu(red);
            ModelTabeleMAUPostavci mtu2 = (ModelTabeleMAUPostavci) tblmodelinaPostavci.getModel();
            mtu2.dodajUD(model);
            mt2.skloniUD(model);
        } else {
            JOptionPane.showMessageDialog(this, "Niste izabrali model automobila!");
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnProveraStatusa;
    private javax.swing.JButton btnSacuvajPostavku;
    private javax.swing.JButton btnUkloni;
    private javax.swing.JComboBox comboGrad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDatumDo;
    private javax.swing.JLabel lblDatumOd;
    private javax.swing.JLabel lblGrad;
    private javax.swing.JLabel lblKreirao;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JPanel panelUD;
    private javax.swing.JPanel panelUDnaIzlozbi;
    private javax.swing.JTable tblModeliAutomobila;
    private javax.swing.JTable tblmodelinaPostavci;
    private com.toedter.calendar.JDateChooser txtDatumDo;
    private com.toedter.calendar.JDateChooser txtDatumOD;
    private javax.swing.JTextField txtKreirao;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void popuniKomboGrad() throws ServerDownException {
        try {
            List<Grad> gradovi = kontroler.Kontroler.getInstance().vratiGradove();

            comboGrad.removeAllItems();
            for (Grad grad : gradovi) {
                comboGrad.addItem(grad);
            }
            comboGrad.setSelectedItem(null);
        } catch (ServerDownException se) {
            throw se;
        } catch (Exception e) {
            Logger.getLogger(FormaPostavka.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void postaviZaposlenog() {
        txtKreirao.setText(Sesija.getInstance().getTrenutniZaposleni().toString());
    }

    private void postaviDugmeSacuvajNaEnabledFalse() {
        btnSacuvajPostavku.setEnabled(false);
    }

    private void srediTabele() throws ServerDownException {
        srediTabeluMA();
        srediTabeluMAUPostavci();
    }

    private void srediTabeluMA() throws ServerDownException {
        ModelTabeleMA2 mt2 = new ModelTabeleMA2();
        tblModeliAutomobila.setModel(mt2);
    }

    private void srediTabeluMAUPostavci() {
        ModelTabeleMAUPostavci mt = new ModelTabeleMAUPostavci();
        tblmodelinaPostavci.setModel(mt);
    }
}
