/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.postavka.model;

import domain.ModelAutomobila;
import exception.ServerDownException;
import forme.proizvodjac.model.ModelTabelaProizvodjac;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class ModelTabeleMA2 extends AbstractTableModel {

    private List<ModelAutomobila> modeli;
    private List<ModelAutomobila> kopija;

    private String[] header = new String[]{"Proizvđač", "Naziv modela", "Godina nastanka", "Vrednost modela", "Tip modela"};

    public ModelTabeleMA2() throws ServerDownException {
        try {
            modeli = kontroler.Kontroler.getInstance().vratiModeleAutomobila();
            kopija = modeli;
        } catch (ServerDownException se) {
            throw se;
        } catch (Exception ex) {
            Logger.getLogger(ModelTabelaProizvodjac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        if (modeli == null) {
            return 0;
        }
        return modeli.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelAutomobila ma = modeli.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ma.getProizvodjac();
            case 1:
                return ma.getNaziv();
            case 2:
                return ma.getGodinaNastanka();
            case 3:
                return ma.getVrednostModela();
            case 4:
                return ma.getTipModela();

            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    public boolean prikaziUmetnickaDelaNaOsnovuPretrage(String vrednost, String polje) {
        List<ModelAutomobila> pomocna = new LinkedList<>();
        try {
//            umetnickaDela = kontroler.Kontroler.getInstance().vratiUmetnickaDela();
            modeli = kopija;

            switch (polje) {
                case "Proizvođač":
                    for (ModelAutomobila m : modeli) {
                        if (m.getProizvodjac().toString().contains(vrednost)) {
                            pomocna.add(m);
                        }
                    }
                    break;
                case "Naziv":
                    for (ModelAutomobila m : modeli) {
                        if (m.getNaziv().contains(vrednost)) {
                            pomocna.add(m);
                        }
                    }
                    break;
                case "Godina nastanka":
                    for (ModelAutomobila m : modeli) {
                        int god = m.getGodinaNastanka();
                        if (String.format("%d", god).contains(vrednost)) {
                            pomocna.add(m);
                        }
                    }
                    break;

                case "Tip modela":
                    for (ModelAutomobila m : modeli) {
                        if (m.getTipModela().getNazivTipaModela().contains(vrednost)) {
                            pomocna.add(m);
                        }
                    }
                    break;

            }

        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleMA2.class.getName()).log(Level.SEVERE, null, ex);
        }
        modeli = pomocna;
        fireTableDataChanged();
        if (modeli.isEmpty()) {
            return false;
        }
        return true;
    }

    public ModelAutomobila vratiUmetnickoDeloURedu(int red) {
        return modeli.get(red);
    }

    public void setUmetnickaDela(List<ModelAutomobila> vratiUmetnike) {
        modeli = vratiUmetnike;
        fireTableDataChanged();
    }

    public void skloniUD(ModelAutomobila delo) {
        modeli.remove(delo);
        fireTableDataChanged();
    }

    public void dodajUD(ModelAutomobila delo) {
        modeli.add(delo);
        fireTableDataChanged();

    }

    public void dodajMA(ModelAutomobila model) {
        modeli.add(model);
        fireTableDataChanged();
    }

    public ModelAutomobila vratiModelAutomobilaURedu(int red) {
        return modeli.get(red);
    }
}
