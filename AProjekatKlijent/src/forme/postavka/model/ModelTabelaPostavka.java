/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.postavka.model;

import domain.ModelAutomobila;
import domain.Postavka;
import exception.ServerDownException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andjela
 */
public class ModelTabelaPostavka extends AbstractTableModel {

    private List<Postavka> postavke;
    private List<Postavka> kopija;

    private String[] header = new String[]{"Redni broj", "Sifra", "Naziv", "Datum pocetka", "Datum zavrsetka", "Grad", "Status"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabelaPostavka() throws ServerDownException {
        try {
            postavke = kontroler.Kontroler.getInstance().vratiPostavke();
            kopija = postavke;
        } catch (ServerDownException se) {
            throw se;
        } catch (Exception ex) {
            Logger.getLogger(ModelTabelaPostavka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        if (postavke == null) {
            return 0;
        }
        return postavke.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Postavka p = postavke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return p.getSifraPostavke();
            case 2:
                return p.getNaziv();
            case 3:
                return sdf.format(p.getDatumOd());
            case 4:
                return sdf.format(p.getDatumDo());
            case 5:
                return p.getGrad().toString();
            case 6:
                return p.getStatus();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    public boolean prikaziIzlozbeNaOsnovuPretrage(String vrednost, String polje) {

        List<Postavka> pomocna = new LinkedList<>();
        try {
            postavke = kopija;

            switch (polje) {
                case "Sifra":
                    for (Postavka p : postavke) {
                        if (p.getSifraPostavke().toString().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Naziv":
                    for (Postavka p : postavke) {
                        if (p.getNaziv().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Status":
                    for (Postavka p : postavke) {
                        if (String.valueOf(p.getStatus()).contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Grad":
                    for (Postavka p : postavke) {
                        if (p.getGrad().toString().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Model automobila":
                    for (Postavka p : postavke) {
                        for (ModelAutomobila j : p.getListaModela()) {
                            if (j.getNaziv().contains(vrednost)) {
                                pomocna.add(p);

                            }
                        }

                    }
                    break;
            }

        } catch (Exception ex) {
            Logger.getLogger(ModelTabelaPostavka.class.getName()).log(Level.SEVERE, null, ex);
        }
        postavke = pomocna;
        fireTableDataChanged();
        if (postavke.isEmpty()) {
            return false;
        }
        return true;
    }

    public Postavka vratiIzlozbuZaRed(int red) {

        return postavke.get(red);
    }

    public void osvezi() {
        fireTableDataChanged();
    }

    public void dodaj(Postavka postavka) {
        postavke.add(postavka);
        fireTableDataChanged();
    }

    public boolean prikaziPostavkeNaOsnovuPretrage(String vrednost, String polje) {
        List<Postavka> pomocna = new LinkedList<>();
        try {
            postavke = kopija;

            switch (polje) {
                case "Sifra":
                    for (Postavka p : postavke) {
                        if (p.getSifraPostavke().toString().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Naziv":
                    for (Postavka p : postavke) {
                        if (p.getNaziv().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Status":
                    for (Postavka p : postavke) {
                        if (String.valueOf(p.getStatus()).contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Grad":
                    for (Postavka p : postavke) {
                        if (p.getGrad().toString().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Model automobila":
                    for (Postavka p : postavke) {
                        for (ModelAutomobila m : p.getListaModela()) {
                            if (m.getNaziv().contains(vrednost)) {
                                pomocna.add(p);

                            }
                        }

                    }
                    break;
            }

        } catch (Exception ex) {
            Logger.getLogger(ModelTabelaPostavka.class.getName()).log(Level.SEVERE, null, ex);
        }
        postavke = pomocna;
        fireTableDataChanged();
        if (postavke.isEmpty()) {
            return false;
        }
        return true;
    }

}
