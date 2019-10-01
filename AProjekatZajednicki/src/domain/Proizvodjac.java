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
public class Proizvodjac implements OpstiDomenskiObjekat {

    private Long sifraProizvodjaca;
    private String nazivP;
    private String osnivac;
    private String rukovodilac;
    private String info;
    private String kontakt;
    private Grad grad;
    private List<ModelAutomobila> listaModela;

    public Proizvodjac() {
        listaModela = new LinkedList<ModelAutomobila>();
    }

    public Proizvodjac(Long sifraProizvodjaca, String nazivP, String osnivac, String rukovodilac, String info, String kontakt, Grad grad, List<ModelAutomobila> listaModela) {
        this.sifraProizvodjaca = sifraProizvodjaca;
        this.nazivP = nazivP;
        this.osnivac = osnivac;
        this.rukovodilac = rukovodilac;
        this.info = info;
        this.kontakt = kontakt;
        this.grad = grad;
        this.listaModela = listaModela;
    }

    public Proizvodjac(String nazivP, String osnivac, String rukovodilac, String info, String kontakt, Grad grad, List<ModelAutomobila> listaModela) {
        this.nazivP = nazivP;
        this.osnivac = osnivac;
        this.rukovodilac = rukovodilac;
        this.info = info;
        this.kontakt = kontakt;
        this.grad = grad;
        this.listaModela = listaModela;
    }

    @Override
    public String toString() {

        return nazivP;

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
        final Proizvodjac other = (Proizvodjac) obj;
        if (!Objects.equals(this.sifraProizvodjaca, other.sifraProizvodjaca)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "proizvodjac";
    }

    @Override
    public String vratiNaziveKolona() {
        return "naziv, osnivac, rukovodilac, info, kontakt, sifraGrada";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "'" + nazivP + "','" + osnivac + "','" + rukovodilac + "','" + info + "','" + kontakt + "'," + grad.getSifraGrada();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " naziv='" + nazivP + "',osnivac='" + osnivac + "',rukovodilac='" + rukovodilac + "',info='" + info + "',kontakt='" + kontakt + "',sifraGrada=" + grad.getSifraGrada();
    }

    @Override
    public String vratiWhereUslov() {
        return " sifraProizvodjaca=" + sifraProizvodjaca;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return " * ";
    }

    @Override
    public String vratiAlijas() {
        return "p";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join grad as g on p.sifraGrada=g.sifraGrada";
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
        return " order by naziv";

    }

    @Override
    public String vratiPrimarniKljuc() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet resultSet) throws SQLException {
        List<OpstiDomenskiObjekat> list = new LinkedList<>();
        while (resultSet.next()) {
            Long sifra = resultSet.getLong("sifraProizvodjaca");

            String naziv = resultSet.getString("naziv");
            String osnivac = resultSet.getString("osnivac");
            String rukovodilac = resultSet.getString("rukovodilac");
            String info = resultSet.getString("info");
            String kontakt = resultSet.getString("kontakt");

            Long id = resultSet.getLong("g.sifraGrada");
            String imeG = resultSet.getString("g.nazivGrada");

            Grad g = new Grad(id, imeG);
            Proizvodjac proizvodjac = new Proizvodjac(sifra, naziv, osnivac, rukovodilac, info, kontakt, g, null);
            list.add(proizvodjac);
        }
        return list;
    }

    public Long getSifraProizvodjaca() {
        return sifraProizvodjaca;
    }

    public void setSifraProizvodjaca(Long sifraProizvodjaca) {
        this.sifraProizvodjaca = sifraProizvodjaca;
    }

    public String getNaziv() {
        return nazivP;
    }

    public void setNaziv(String naziv) {
        this.nazivP = naziv;
    }

    public String getOsnivac() {
        return osnivac;
    }

    public void setOsnivac(String osnivac) {
        this.osnivac = osnivac;
    }

    public String getRukovodilac() {
        return rukovodilac;
    }

    public void setRukovodilac(String rukovodilac) {
        this.rukovodilac = rukovodilac;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public List<ModelAutomobila> getListaModela() {
        return listaModela;
    }

    public void setListaModela(List<ModelAutomobila> listaModela) {
        this.listaModela = listaModela;
    }

}
