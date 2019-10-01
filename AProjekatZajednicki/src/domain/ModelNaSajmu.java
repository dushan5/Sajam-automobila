/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class ModelNaSajmu implements OpstiDomenskiObjekat {

    private ModelAutomobila modelAutomobila;
    private Postavka postavka;
    private int oznakaModela;

    public ModelNaSajmu() {
    }

    public ModelNaSajmu(ModelAutomobila modelAutomobila, Postavka postavka, int oznakaModela) {
        this.modelAutomobila = modelAutomobila;
        this.postavka = postavka;
        this.oznakaModela = oznakaModela;
    }

    @Override
    public String vratiNazivTabele() {
        return "modelnasajmu";
    }

    @Override
    public String vratiNaziveKolona() {
        return "sifraProizvodjaca, sifraModelaAutomobila, sifraPostavke, oznakaModela";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return modelAutomobila.getProizvodjac().getSifraProizvodjaca() + "," + modelAutomobila.getSifraModelaAutomobila() + "," + postavka.getSifraPostavke() + "," + oznakaModela;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiWhereUslov() {
        return "";
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return "*";
    }

    @Override
    public String vratiAlijas() {
        return "mns";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " JOIN modelautomobila ma ON mns.siframodelaautomobila=ma.siframodelaautomobila JOIN tipmodelaautomobila tip ON ma.sifratipamodela=tip.sifratipamodela JOIN proizvodjac p ON mns.sifraproizvodjaca=p.sifraproizvodjaca JOIN grad g ON p.sifragrada=g.sifragrada  ";
    }

    @Override
    public String vratiWhereUslovSelect() {
        return "where mns.sifraPostavke=" + postavka.getSifraPostavke();
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public String vratiOrderUslov() {
        return "";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet resultSet) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new LinkedList<>();
        List<ModelAutomobila> lista2 = new LinkedList<>();
        while (resultSet.next()) {
            Long sifra = resultSet.getLong("ma.sifraModelaAutomobila");
            Long sifraP = resultSet.getLong("ma.sifraProizvodjaca");
            String naziv = resultSet.getString("ma.naziv");
            String opis = resultSet.getString("ma.opis");
            int godNastanka = resultSet.getInt("ma.godinaNastanka");
            double vrednost = resultSet.getDouble("ma.vrednostModela");

            Long sifraTipa = resultSet.getLong("tip.sifraTipaModela");
            String nazivTipa = resultSet.getString("tip.nazivTipaModela");

            TipModelaAutomobila tip = new TipModelaAutomobila(sifraTipa, nazivTipa);

            String ime = resultSet.getString("p.naziv");
            String osnivac = resultSet.getString("p.osnivac");
            String ruko = resultSet.getString("p.rukovodilac");
            String info = resultSet.getString("p.info");
            String kontaktTel = resultSet.getString("p.kontakt");

            Long id = resultSet.getLong("g.sifraGrada");
            String imeG = resultSet.getString("g.nazivGrada");

            Grad gu = new Grad(id, imeG);

            Proizvodjac proiz = new Proizvodjac(sifraP, ime, osnivac, ruko, info, kontaktTel, gu, null);

            ModelAutomobila model = new ModelAutomobila(sifra, proiz, naziv, godNastanka, opis, vrednost, tip);

            lista.add(model);
            lista2.add(model);
        }
        postavka.setListaModela(lista2);
        return lista;
    }

    public ModelAutomobila getModelAutomobila() {
        return modelAutomobila;
    }

    public void setModelAutomobila(ModelAutomobila modelAutomobila) {
        this.modelAutomobila = modelAutomobila;
    }

    public Postavka getPostavka() {
        return postavka;
    }

    public void setPostavka(Postavka postavka) {
        this.postavka = postavka;
    }

    public int getOznakaModela() {
        return oznakaModela;
    }

    public void setOznakaModela(int oznakaModela) {
        this.oznakaModela = oznakaModela;
    }

}
