/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.proizvodjac.model;

import domain.Proizvodjac;
import exception.ServerDownException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class ModelTabelaProizvodjac extends AbstractTableModel {

    private List<Proizvodjac> proizvodjaci = null;
    private List<Proizvodjac> kopija;

    private String[] header = new String[]{"Naziv", "Osnivac", "Rukovodilac", "Telefon", "Grad"};

    public ModelTabelaProizvodjac(List<Proizvodjac> p) {
        proizvodjaci = p;
        kopija = p;
    }

    public ModelTabelaProizvodjac() throws ServerDownException {
        try {
            proizvodjaci = kontroler.Kontroler.getInstance().vratiProizvodjace();
            kopija = proizvodjaci;
        } catch (ServerDownException se) {
            throw se;
        } catch (Exception ex) {
            Logger.getLogger(ModelTabelaProizvodjac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        if (proizvodjaci == null) {
            return 0;
        }
        return proizvodjaci.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proizvodjac p = proizvodjaci.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getNaziv();
            case 1:
                return p.getOsnivac();
            case 2:
                return p.getRukovodilac();
            case 3:
                return p.getKontakt();
            case 4:
                return p.getGrad();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    public Proizvodjac vratiUmetnikaURedu(int red) {
        return proizvodjaci.get(red);
    }

    public void osvezi() {

        proizvodjaci.sort(Comparator.comparing(Proizvodjac::getNaziv).thenComparing(Proizvodjac::getOsnivac));
        fireTableDataChanged();
    }

    public boolean prikaziUmetnikeNaOsnovuPretrage(String vrednost, String polje) {

        try {
            proizvodjaci = kopija;
//            umetnici = kontroler.Kontroler.getInstance().vratiUmetnike();
            List<Proizvodjac> pomocna = new LinkedList<>();

            switch (polje) {
                case "Sifra":
                    for (Proizvodjac pr : proizvodjaci) {
                        if (pr.getSifraProizvodjaca().toString().contains(vrednost)) {
                            pomocna.add(pr);
                        }
                    }
                    break;
                case "Naziv":
                    for (Proizvodjac pr : proizvodjaci) {
                        if (pr.getNaziv().contains(vrednost)) {
                            pomocna.add(pr);
                        }
                    }
                    break;
                case "Osnivač":
                    for (Proizvodjac pr : proizvodjaci) {
                        if (pr.getOsnivac().contains(vrednost)) {
                            pomocna.add(pr);
                        }
                    }
                    break;
                case "Rukovodilac":
                    for (Proizvodjac pr : proizvodjaci) {
                        if (pr.getRukovodilac().contains(vrednost)) {
                            pomocna.add(pr);
                        }
                    }
                    break;
                case "Telefon":
                    for (Proizvodjac pr : proizvodjaci) {
                        if (pr.getKontakt().contains(vrednost)) {
                            pomocna.add(pr);
                        }
                    }
                    break;
                case "Grad":
                    for (Proizvodjac pr : proizvodjaci) {
                        if (pr.getGrad().getNazivGrada().contains(vrednost)) {
                            pomocna.add(pr);
                        }
                    }
                    break;
            }

            proizvodjaci = pomocna;
            fireTableDataChanged();
            if (proizvodjaci.isEmpty()) {
                return false;
            }
            return true;

        } catch (Exception ex) {
            Logger.getLogger(ModelTabelaProizvodjac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Proizvodjac> getUmetnici() {
        return proizvodjaci;
    }

    public void setUmetnici(List<Proizvodjac> umetnici) {
        this.proizvodjaci = proizvodjaci;
        this.kopija = proizvodjaci;
        fireTableDataChanged();
    }

    public boolean prikaziProizvodjaceNaOsnovuPretrage(String vrednost, String polje) {
        try {
            proizvodjaci = kopija;
//            umetnici = kontroler.Kontroler.getInstance().vratiUmetnike();
            List<Proizvodjac> pomocna = new LinkedList<>();

            switch (polje) {
                case "Sifra":
                    for (Proizvodjac p : proizvodjaci) {
                        if (p.getSifraProizvodjaca().toString().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Naziv":
                    for (Proizvodjac p : proizvodjaci) {
                        if (p.getNaziv().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Osnivač":
                    for (Proizvodjac p : proizvodjaci) {
                        if (p.getOsnivac().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Rukovodilac":
                    for (Proizvodjac p : proizvodjaci) {
                        if (p.getRukovodilac().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Telefon":
                    for (Proizvodjac p : proizvodjaci) {
                        if (p.getKontakt().contains(vrednost)) {
                            pomocna.add(p);
                        }
                    }
                    break;
                case "Grad":
                    for (Proizvodjac umetnik : proizvodjaci) {
                        if (umetnik.getGrad().getNazivGrada().contains(vrednost)) {
                            pomocna.add(umetnik);
                        }
                    }
                    break;
            }

            proizvodjaci = pomocna;
            fireTableDataChanged();
            if (proizvodjaci.isEmpty()) {
                return false;
            }
            return true;

        } catch (Exception ex) {
            Logger.getLogger(ModelTabelaProizvodjac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Proizvodjac vratiProizvodjacaURedu(int red) {
        return proizvodjaci.get(red);
    }

    public void setProizvodjaci(List<Proizvodjac> vratiProizvodjace) {
        this.proizvodjaci = proizvodjaci;
        this.kopija = proizvodjaci;
        fireTableDataChanged();
    }

}
