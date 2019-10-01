/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.modelautomobila.model;

import domain.ModelAutomobila;
import exception.ServerDownException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class ModelTabeleMA extends AbstractTableModel {

    private List<ModelAutomobila> modeli = null;
    private List<ModelAutomobila> kopija = null;

    private String[] header = new String[]{"Proizvođač", "Naziv modela", "Godina nastanka", "Vrednost modela", "Tip modela", "Status"};

    public ModelTabeleMA() throws ServerDownException {

        try {
            modeli = kontroler.Kontroler.getInstance().vratiModeleAutomobila();
            kopija = modeli;

        } catch (ServerDownException se) {
            throw se;
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleMA.class.getName()).log(Level.SEVERE, null, ex);
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
                return ma.getProizvodjac().getNaziv();
            case 1:
                return ma.getNaziv();
            case 2:
                return ma.getGodinaNastanka();
            case 3:
                return ma.getVrednostModela();
            case 4:
                return ma.getTipModela();
            case 5:
                return ma.getStatus();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    public boolean prikaziModeleAutomobilaNaOsnovuPretrage(String vrednost, String polje) {
        List<ModelAutomobila> pomocna = new LinkedList<>();

        try {
            modeli = kopija;
            switch (polje) {
                case "Proizvođač":
                    for (ModelAutomobila ma : modeli) {
                        if (ma.getProizvodjac().toString().contains(vrednost)) {
                            pomocna.add(ma);
                        }
                    }
                    break;
                case "Naziv":
                    for (ModelAutomobila ma : modeli) {
                        if (ma.getNaziv().contains(vrednost)) {
                            pomocna.add(ma);
                        }
                    }
                    break;
                case "Godina nastanka":
                    for (ModelAutomobila ma : modeli) {
                        int god = ma.getGodinaNastanka();
                        if (String.format("%d", god).contains(vrednost)) {
                            pomocna.add(ma);
                        }
                    }
                    break;

                case "Tip modela":
                    for (ModelAutomobila ma : modeli) {
                        if (ma.getTipModela().getNazivTipaModela().contains(vrednost)) {
                            pomocna.add(ma);
                        }
                    }
                    break;

            }

        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleMA.class.getName()).log(Level.SEVERE, null, ex);
        }

        modeli = pomocna;
        fireTableDataChanged();
        if (modeli.isEmpty()) {
            return false;
        }
        return true;

    }

    public ModelAutomobila vratimodelURedu(int red) {
        return modeli.get(red);
    }

    public void setUmetnickaDela(List<ModelAutomobila> vratiModele) {
        modeli = vratiModele;
        fireTableDataChanged();
    }

    public void skloniUD(ModelAutomobila model) {
        modeli.remove(model);
        fireTableDataChanged();
    }

    public void dodajUD(ModelAutomobila model) {
        modeli.add(model);
        fireTableDataChanged();

    }

    public ModelAutomobila vratiModelAutomobilaURedu(int red) {
        return modeli.get(red);
    }

    public void setModeleAutomobila(List<ModelAutomobila> vratiModeleAutomobila) {
        modeli = vratiModeleAutomobila;
        fireTableDataChanged();
    }

    

}
