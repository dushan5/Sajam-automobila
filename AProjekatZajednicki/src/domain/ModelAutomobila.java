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
import java.util.Objects;

/**
 *
 * @author Nikola
 */
public class ModelAutomobila implements OpstiDomenskiObjekat {

    private Long sifraModelaAutomobila;
    private Proizvodjac proizvodjac;
    private String naziv;
    private int godinaNastanka;
    private String opis;
    private double vrednostModela;
    private TipModelaAutomobila tipModela;
    private StatusModela status;

    public ModelAutomobila() {
    }

    public ModelAutomobila(Long sifraModelaAutomobila, Proizvodjac proizvodjac, String naziv, int godinaNastanka, String opis, double vrednostModela, TipModelaAutomobila tipModela) {
        this.sifraModelaAutomobila = sifraModelaAutomobila;
        this.proizvodjac = proizvodjac;
        this.naziv = naziv;
        this.godinaNastanka = godinaNastanka;
        this.opis = opis;
        this.vrednostModela = vrednostModela;
        this.tipModela = tipModela;
    }

    public ModelAutomobila(Proizvodjac proizvodjac, String naziv, int godinaNastanka, String opis, double vrednostModela, TipModelaAutomobila tipModela) {
        this.proizvodjac = proizvodjac;
        this.naziv = naziv;
        this.godinaNastanka = godinaNastanka;
        this.opis = opis;
        this.vrednostModela = vrednostModela;
        this.tipModela = tipModela;
    }

    @Override
    public String toString() {

        return naziv + " (" + proizvodjac.toString() + ")";

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModelAutomobila other = (ModelAutomobila) obj;
        if (!Objects.equals(this.sifraModelaAutomobila, other.sifraModelaAutomobila)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "modelautomobila";
    }

    @Override
    public String vratiNaziveKolona() {
        return " sifraProizvodjaca, naziv, godinaNastanka, opis, vrednostModela, sifraTipaModela";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return proizvodjac.getSifraProizvodjaca() + ",'" + naziv + "'," + godinaNastanka + ",'" + opis + "'," + vrednostModela + "," + tipModela.getSifraTipaModela();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiWhereUslov() {
        return " sifraModelaAutomobila=" + sifraModelaAutomobila;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return "*";
    }

    @Override
    public String vratiAlijas() {
        return "ma";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join proizvodjac p on ma.sifraProizvodjaca=p.sifraProizvodjaca join grad g on p.sifraGrada=g.sifraGrada join tipmodelaautomobila tip on ma.sifraTipaModela=tip.sifraTipaModela";
    }

    @Override
    public String vratiWhereUslovSelect() {
        return "";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public String vratiOrderUslov() {
        return " order by p.naziv,p.osnivac,ma.naziv";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet resultSet) throws SQLException {
        List<OpstiDomenskiObjekat> list = new LinkedList<>();
        while (resultSet.next()) {
            Long sifraMA = resultSet.getLong("sifraModelaAutomobila");
            Long sifraP = resultSet.getLong("sifraProizvodjaca");

            String naziv = resultSet.getString("p.naziv");
            String osnivac = resultSet.getString("osnivac");
            String rukovodilac = resultSet.getString("rukovodilac");
            String info = resultSet.getString("info");
            String kontakt = resultSet.getString("kontakt");

            Long id = resultSet.getLong("g.sifraGrada");
            String imeG = resultSet.getString("g.nazivGrada");

            String nazivModela = resultSet.getString("ma.naziv");
            String opisModela = resultSet.getString("ma.opis");
            int godNastanka = resultSet.getInt("ma.godinaNastanka");
            double vrednost = resultSet.getDouble("ma.vrednostModela");

            Long sifraTipa = resultSet.getLong("tip.sifraTipaModela");
            String nazivTipa = resultSet.getString("tip.nazivTipaModela");

            TipModelaAutomobila tip = new TipModelaAutomobila(sifraTipa, nazivTipa);

            Grad g = new Grad(id, imeG);
            Proizvodjac proizvodjac = new Proizvodjac(sifraP, naziv, osnivac, rukovodilac, info, kontakt, g, null);

            ModelAutomobila ud = new ModelAutomobila(sifraMA, proizvodjac, nazivModela, godNastanka, opisModela, vrednost, tip);
            list.add(ud);
        }
        return list;
    }

    public Long getSifraModelaAutomobila() {
        return sifraModelaAutomobila;
    }

    public void setSifraModelaAutomobila(Long sifraModelaAutomobila) {
        this.sifraModelaAutomobila = sifraModelaAutomobila;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodinaNastanka() {
        return godinaNastanka;
    }

    public void setGodinaNastanka(int godinaNastanka) {
        this.godinaNastanka = godinaNastanka;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getVrednostModela() {
        return vrednostModela;
    }

    public void setVrednostModela(double vrednostModela) {
        this.vrednostModela = vrednostModela;
    }

    public TipModelaAutomobila getTipModela() {
        return tipModela;
    }

    public void setTipModela(TipModelaAutomobila tipModela) {
        this.tipModela = tipModela;
    }

    public StatusModela getStatus() {
        return status;
    }

    public void setStatus(StatusModela status) {
        this.status = status;
    }

}
