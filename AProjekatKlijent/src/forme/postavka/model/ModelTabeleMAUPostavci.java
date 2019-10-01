/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.postavka.model;

import domain.ModelAutomobila;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class ModelTabeleMAUPostavci extends AbstractTableModel {

    private List<ModelAutomobila> modeliA = null;

    private String[] header = new String[]{"Redni broj", "Proizvođač", "Naziv modela", "Godina nastanka", "Vrednost modela", "Tip modela", "Status"};

    public ModelTabeleMAUPostavci() {
        modeliA = new LinkedList<>();
    }

    @Override
    public int getRowCount() {
        if (modeliA == null) {
            return 0;
        }
        return modeliA.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelAutomobila ma = modeliA.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return ma.getProizvodjac();
            case 2:
                return ma.getNaziv();
            case 3:
                return ma.getGodinaNastanka();
            case 4:
                return ma.getVrednostModela();
            case 5:
                return ma.getTipModela();
            case 6:
                return ma.getStatus();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    public void dodajUD(ModelAutomobila model) {
        modeliA.add(model);
        fireTableDataChanged();
    }

    public void skloniUD(ModelAutomobila model) {
        modeliA.remove(model);
        fireTableDataChanged();
    }

    public ModelAutomobila vratiUmetnickoDeloURedu(int red) {
        return modeliA.get(red);
    }

    public List<ModelAutomobila> getUmetnickaDela() {
        return modeliA;
    }

    public void postaviListu(List<ModelAutomobila> listaUD) {

        modeliA = listaUD;
        fireTableDataChanged();
    }

    public ModelAutomobila vratiModelAutomobilaURedu(int red) {
        return modeliA.get(red);
    }

    public void skloniMA(ModelAutomobila model) {
        modeliA.remove(model);
        fireTableDataChanged();
    }

    public List<ModelAutomobila> getModeleAutomobila() {
        return modeliA;
    }

   

    
}
