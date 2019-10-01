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
 * @author Dusan
 */
public class Grad implements OpstiDomenskiObjekat {

    private Long sifraGrada;
    private String nazivGrada;

    public Grad() {
    }

    public Grad(Long sifraGrada, String nazivGrada) {
        this.sifraGrada = sifraGrada;
        this.nazivGrada = nazivGrada;
    }

    public String getNazivGrada() {
        return nazivGrada;
    }

    public void setNazivGrada(String nazivGrada) {
        this.nazivGrada = nazivGrada;
    }

    public Long getSifraGrada() {
        return sifraGrada;
    }

    public void setSifraGrada(Long sifraGrada) {
        this.sifraGrada = sifraGrada;
    }

    @Override
    public String toString() {

        return this.nazivGrada;
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
        final Grad other = (Grad) obj;
        if (!Objects.equals(this.nazivGrada, other.nazivGrada)) {
            return false;
        }
        if (!Objects.equals(this.sifraGrada, other.sifraGrada)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "grad";
    }

    @Override
    public String vratiNaziveKolona() {
        return "";

    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "";
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
        return "g";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
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
        return " order by nazivGrada asc";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet resultSet) throws SQLException {
        List<OpstiDomenskiObjekat> list = new LinkedList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("sifraGrada");
            String ime = resultSet.getString("nazivGrada");

            list.add(new Grad(id, ime));
        }
        return list;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "";
    }

}
