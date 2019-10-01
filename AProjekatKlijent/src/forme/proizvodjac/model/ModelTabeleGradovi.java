/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.proizvodjac.model;

import domain.Grad;
import exception.ServerDownException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andjela
 */
public class ModelTabeleGradovi extends AbstractTableModel {

    private List<Grad> gradovi = null;
    List<Grad> kopija;

    private String[] header = new String[]{"Naziv grada"};

    public ModelTabeleGradovi() throws ServerDownException {

        try {
            gradovi = kontroler.Kontroler.getInstance().vratiGradove();
            kopija = gradovi;
        } catch (ServerDownException se) {
            throw se;
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleGradovi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int getRowCount() {
        if (gradovi == null) {
            return 0;
        }
        return gradovi.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Grad g = gradovi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return g.getNazivGrada();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    public Grad vratiGradURedu(int red) {
        return gradovi.get(red);
    }

    public void prikaziGradoveNaOsnovuPretrage(String text) {

        try {
            gradovi = kopija;
//            gradovi = kontroler.Kontroler.getInstance().vratiGradove();
            List<Grad> pomocna = new LinkedList<>();

            for (Grad g : gradovi) {
                if (g.getNazivGrada().contains(text)) {
                    pomocna.add(g);
                }
            }
            gradovi = pomocna;
            fireTableDataChanged();

        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleGradovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
