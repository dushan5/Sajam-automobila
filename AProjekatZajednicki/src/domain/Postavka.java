/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Nikola
 */
public class Postavka implements OpstiDomenskiObjekat {

    private Long sifraPostavke;
    private String naziv;
    private Date datumOd;
    private Date datumDo;
    private StatusPostavke status;
    private Zaposleni kreiraoZaposleni;
    private Grad grad;
    private List<ModelAutomobila> listaModela;

    public Postavka() {
        listaModela = new LinkedList<>();

    }

    public Postavka(Long sifraPostavke, String naziv, Date datumOd, Date datumDo, Zaposleni kreiraoZaposleni, Grad grad, List<ModelAutomobila> listaModela) {
        this.sifraPostavke = sifraPostavke;
        this.naziv = naziv;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.status = vratiStatus();
        this.kreiraoZaposleni = kreiraoZaposleni;
        this.grad = grad;
        this.listaModela = listaModela;
    }

    public Postavka(String naziv, Date datumOd, Date datumDo, Zaposleni kreiraoZaposleni, Grad grad, List<ModelAutomobila> listaModela) {
        this.naziv = naziv;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.status = vratiStatus();
        this.kreiraoZaposleni = kreiraoZaposleni;
        this.grad = grad;
        this.listaModela = listaModela;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return naziv + "  (" + sdf.format(datumOd) + " - " + sdf.format(datumDo) + ")";

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
        final Postavka other = (Postavka) obj;
        if (!Objects.equals(this.sifraPostavke, other.sifraPostavke)) {
            return false;
        }
        return true;
    }

    public StatusPostavke vratiStatus() {

        Date danas = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        if (danas.before(datumOd) && danas.before(datumDo)) {
            return StatusPostavke.PLANIRANA;
        }
        if (danas.after(datumOd) && danas.before(datumDo)) {
            return StatusPostavke.U_TOKU;
        }
        if (danas.after(datumOd) && danas.after(datumDo)) {
            return StatusPostavke.ZAVRSENA;
        }
        return StatusPostavke.NEDEFINISAN;
    }

    @Override
    public String vratiNazivTabele() {
        return "postavka";
    }

    @Override
    public String vratiNaziveKolona() {
        return "naziv,datumOd,datumDo,sifraGrada,sifraZaposlenog";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "'" + naziv + "','" + new java.sql.Date(datumOd.getTime()) + "','" + new java.sql.Date(datumDo.getTime()) + "'," + grad.getSifraGrada() + "," + kreiraoZaposleni.getSifraZaposlenog();
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
        return "pos";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join grad g on pos.sifragrada=g.sifragrada join zaposleni z on pos.sifrazaposlenog=z.sifrazaposlenog";
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
        return "";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "sifrapostavke";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet resultSet) throws SQLException {
        List<OpstiDomenskiObjekat> list = new LinkedList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("pos.sifraPostavke");
            String naziv = resultSet.getString("pos.naziv");
            Date dOd = resultSet.getDate("pos.datumOd");
            Date dDo = resultSet.getDate("pos.datumDo");

            Long sifraG = resultSet.getLong("g.sifraGrada");
            String nazivG = resultSet.getString("g.nazivGrada");
            Grad g = new Grad(sifraG, nazivG);

            Long sifraZ = resultSet.getLong("z.sifraZaposlenog");
            String imeZ = resultSet.getString("z.ime");
            String prezimeZ = resultSet.getString("z.prezime");
            String jmbgZ = resultSet.getString("z.jmbg");
            String emailZ = resultSet.getString("z.email");
            String usernameZ = resultSet.getString("z.username");
            String passwordZ = resultSet.getString("z.password");
            Zaposleni z = new Zaposleni(sifraZ, imeZ, prezimeZ, jmbgZ, emailZ, usernameZ, passwordZ);

            Postavka p = new Postavka(id, naziv, dOd, dDo, z, g, null);
            list.add(p);

        }
        return list;

    }

    public Long getSifraPostavke() {
        return sifraPostavke;
    }

    public void setSifraPostavke(Long sifraPostavke) {
        this.sifraPostavke = sifraPostavke;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public StatusPostavke getStatus() {
        return status;
    }

    public void setStatus(StatusPostavke status) {
        this.status = status;
    }

    public Zaposleni getKreiraoZaposleni() {
        return kreiraoZaposleni;
    }

    public void setKreiraoZaposleni(Zaposleni kreiraoZaposleni) {
        this.kreiraoZaposleni = kreiraoZaposleni;
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
