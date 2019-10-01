/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.modelautomobila;

import domain.ModelAutomobila;
import domain.Proizvodjac;
import domain.TipModelaAutomobila;
import exception.ServerDownException;
import forme.FormMode;
import forme.GlavnaForma;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sesija.Sesija;

/**
 *
 * @author Nikola
 */
public class FormaModelAutomobila extends javax.swing.JDialog {

    /**
     * Creates new form FormaModelAutomobila
     */
    public FormaModelAutomobila(java.awt.Frame parent, boolean modal, FormMode fm) throws ServerDownException {
        super(parent, modal);
        initComponents();
        try {
            popuniTrenutnoUlogovanog();
            popuniKomboProizvodjaci();
            popuniKomboTipovi();
            prilagodiFormu(fm);
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

        lblZaposleni = new javax.swing.JLabel();
        lblTrenutnoUlogovan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblSifra = new javax.swing.JLabel();
        txtSifra = new javax.swing.JTextField();
        lblProizvodjac = new javax.swing.JLabel();
        comboProizvodjac = new javax.swing.JComboBox();
        lblNazivUD = new javax.swing.JLabel();
        txtNazivMA = new javax.swing.JTextField();
        lblGodinaNastanka = new javax.swing.JLabel();
        txtGodinaNastanka = new javax.swing.JTextField();
        lblOpis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        lblVrednost = new javax.swing.JLabel();
        txtVrednost = new javax.swing.JTextField();
        comboTip = new javax.swing.JComboBox();
        lblTipUD = new javax.swing.JLabel();
        txtSifraProizvodjaca = new javax.swing.JTextField();
        lblSifraProizvodjaca = new javax.swing.JLabel();
        btnIzadji = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblZaposleni.setText("Trenutno ulogovan:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Model automobila"));

        lblSifra.setText("Šifra:");

        txtSifra.setEditable(false);

        lblProizvodjac.setText("Proizvođač:");

        lblNazivUD.setText("Naziv:");

        lblGodinaNastanka.setText("Godina nastanka:");

        lblOpis.setText("Opis:");

        txtOpis.setColumns(20);
        txtOpis.setRows(5);
        jScrollPane1.setViewportView(txtOpis);

        lblVrednost.setText("Vrednost (RSD):");

        lblTipUD.setText("Tip modela:");

        txtSifraProizvodjaca.setEditable(false);

        lblSifraProizvodjaca.setText("Šifra proizvođača:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSifra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblNazivUD)
                        .addComponent(lblProizvodjac)
                        .addComponent(lblGodinaNastanka)
                        .addComponent(lblOpis)
                        .addComponent(lblVrednost)
                        .addComponent(lblTipUD)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSifraProizvodjaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSifraProizvodjaca))
                    .addComponent(txtSifra, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboProizvodjac, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNazivMA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboTip, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGodinaNastanka, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(txtVrednost, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSifra)
                    .addComponent(txtSifra))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProizvodjac)
                    .addComponent(comboProizvodjac))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSifraProizvodjaca)
                    .addComponent(txtSifraProizvodjaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNazivUD)
                    .addComponent(txtNazivMA))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipUD)
                    .addComponent(comboTip))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGodinaNastanka)
                    .addComponent(txtGodinaNastanka))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOpis)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVrednost)
                    .addComponent(lblVrednost))
                .addGap(43, 43, 43))
        );

        btnIzadji.setText("Izađi");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblZaposleni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrenutnoUlogovan, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTrenutnoUlogovan, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblZaposleni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        Proizvodjac proizvodjac = (Proizvodjac) comboProizvodjac.getSelectedItem();
        String naziv = txtNazivMA.getText();
        TipModelaAutomobila tipMA = (TipModelaAutomobila) comboTip.getSelectedItem();
        String godinaNastanka = txtGodinaNastanka.getText();
        String opis = txtOpis.getText();
        String vrednost = txtVrednost.getText();

        boolean validno = proveraValidnosti(proizvodjac, naziv, tipMA, godinaNastanka, opis, vrednost);
        if (validno == false) {
            return;
        }

        ModelAutomobila ma = new ModelAutomobila(proizvodjac, naziv, Integer.parseInt(godinaNastanka), opis, Double.parseDouble(vrednost), tipMA);
        try {
            String poruka = kontroler.Kontroler.getInstance().sacuvajModelAutomobila(ma);
            JOptionPane.showMessageDialog(this, poruka, "Uspešan unos", JOptionPane.INFORMATION_MESSAGE);

            // 0=yes, 1=no
            int result = JOptionPane.showConfirmDialog(this, "Novi model?", "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                clearFields();
            } else {
                dispose();
            }
        } catch (ServerDownException se) {
            JOptionPane.showMessageDialog(this, se.getMessage(), "Kraj rada", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            GlavnaForma fr = (GlavnaForma) this.getParent();
            fr.serverZaustavljen();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Neuspešan unos", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox comboProizvodjac;
    private javax.swing.JComboBox comboTip;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGodinaNastanka;
    private javax.swing.JLabel lblNazivUD;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JLabel lblProizvodjac;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JLabel lblSifraProizvodjaca;
    private javax.swing.JLabel lblTipUD;
    private javax.swing.JLabel lblTrenutnoUlogovan;
    private javax.swing.JLabel lblVrednost;
    private javax.swing.JLabel lblZaposleni;
    private javax.swing.JTextField txtGodinaNastanka;
    private javax.swing.JTextField txtNazivMA;
    private javax.swing.JTextArea txtOpis;
    private javax.swing.JTextField txtSifra;
    private javax.swing.JTextField txtSifraProizvodjaca;
    private javax.swing.JTextField txtVrednost;
    // End of variables declaration//GEN-END:variables

    private void popuniTrenutnoUlogovanog() {
        lblTrenutnoUlogovan.setText(Sesija.getInstance().getTrenutniZaposleni().getIme() + " " + Sesija.getInstance().getTrenutniZaposleni().getPrezime());
    }

    private void popuniKomboProizvodjaci() throws ServerDownException {
        try {
            List<Proizvodjac> proizvodjaci = kontroler.Kontroler.getInstance().vratiProizvodjace();

            comboProizvodjac.removeAllItems();
            for (Proizvodjac p : proizvodjaci) {
                comboProizvodjac.addItem(p);
            }
        } catch (ServerDownException se) {
            throw se;
        } catch (Exception ex) {
            Logger.getLogger(FormaModelAutomobila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniKomboTipovi() throws ServerDownException {
        try {
            List<TipModelaAutomobila> tipovi = kontroler.Kontroler.getInstance().vratiTipove();

            comboTip.removeAllItems();
            for (TipModelaAutomobila t : tipovi) {
                comboTip.addItem(t);
            }
        } catch (ServerDownException se) {
            throw se;
        } catch (Exception ex) {
            Logger.getLogger(FormaModelAutomobila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prilagodiFormu(FormMode fm) {
        switch (fm) {
            case NEW:
                lblZaposleni.setVisible(true);
                lblTrenutnoUlogovan.setVisible(true);

                lblSifra.setVisible(false);
                txtSifra.setVisible(false);
                lblSifraProizvodjaca.setVisible(false);
                txtSifraProizvodjaca.setVisible(false);

                btnSacuvaj.setVisible(true);
                btnIzadji.setVisible(true);

                comboTip.setEnabled(true);
                comboProizvodjac.setEnabled(true);

                comboProizvodjac.setSelectedItem(null);
                comboTip.setSelectedItem(null);

                setTitle("Novi model automobila");
                break;
            case VIEW:
                lblZaposleni.setVisible(true);
                lblTrenutnoUlogovan.setVisible(true);

                lblSifra.setVisible(true);
                txtSifra.setVisible(true);
                lblSifraProizvodjaca.setVisible(true);
                txtSifraProizvodjaca.setVisible(true);

                txtGodinaNastanka.setEditable(false);
                txtOpis.setEditable(false);
                txtVrednost.setEditable(false);
                txtNazivMA.setEditable(false);

                btnSacuvaj.setVisible(false);
                btnIzadji.setVisible(true);

                comboTip.setEnabled(false);
                comboProizvodjac.setEnabled(false);
                setTitle("Prikaz modela automobila");
                setMA();
                break;
        }
    }

    private void setMA() {
        ModelAutomobila ma = (ModelAutomobila) Sesija.getInstance().getUseCaseParams().get("izabraniMA");

        txtSifraProizvodjaca.setText(String.format("%d", ma.getProizvodjac().getSifraProizvodjaca()));
        txtNazivMA.setText(ma.getNaziv());
        txtGodinaNastanka.setText(String.format("%d", ma.getGodinaNastanka()));
        txtOpis.setText(ma.getOpis());
        txtSifra.setText(String.format("%d", ma.getSifraModelaAutomobila()));

        txtSifraProizvodjaca.setText(String.format("%d", ma.getProizvodjac().getSifraProizvodjaca()));
        txtVrednost.setText(String.format("%.2f", ma.getVrednostModela()));
        comboProizvodjac.setSelectedItem(ma.getProizvodjac() == null ? null : ma.getProizvodjac());
        comboTip.setSelectedItem(ma.getTipModela() == null ? null : ma.getTipModela());
    }

    private boolean proveraValidnosti(Proizvodjac proizvodjac, String naziv, TipModelaAutomobila tipMA, String godinaNastanka, String opis, String vrednost) {
        if (proizvodjac == null || naziv.isEmpty() || tipMA == null || godinaNastanka.isEmpty() || opis.isEmpty() || vrednost.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna!");
            return false;
        }

        try {
            int godina = Integer.parseInt(godinaNastanka);

            int length = String.valueOf(godina).length();
            if (length != 4) {
                JOptionPane.showMessageDialog(this, "Godina nastanka mora biti četvorocifreni broj!");
                return false;
            }

            int trenutnaGodina = Calendar.getInstance().get(Calendar.YEAR);
            if (godina > trenutnaGodina) {
                JOptionPane.showMessageDialog(this, "Godina nastanka mora biti u prošlosti!");
                return false;
            }
            if (godina <= 0) {
                JOptionPane.showMessageDialog(this, "Godina nastanka nije validna!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Godina nastanka mora biti četvorocifreni broj!");
            return false;
        }
        try {
            double vred = Double.parseDouble(vrednost);
            if (vred < 0) {
                JOptionPane.showMessageDialog(this, "Vrednost ne može biti negativna!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vrednost mora biti broj!");
            return false;
        }
        return true;
    }

    private void clearFields() {
        comboTip.setSelectedItem(null);
        comboProizvodjac.setSelectedItem(null);
        txtNazivMA.setText("");
        txtOpis.setText("");
        txtVrednost.setText("");
        txtSifra.setText("");
        txtGodinaNastanka.setText("");
    }
}
