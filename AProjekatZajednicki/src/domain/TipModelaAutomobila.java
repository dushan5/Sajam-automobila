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
 * @author Andjela
 */
public class TipModelaAutomobila implements OpstiDomenskiObjekat {

    private Long sifraTipaModela;
    private String nazivTipaModela;

    public TipModelaAutomobila() {
    }

    public TipModelaAutomobila(Long sifraTipaModela, String nazivTipaModela) {
        this.sifraTipaModela = sifraTipaModela;
        this.nazivTipaModela = nazivTipaModela;
    }

    

    

    @Override
    public String toString() {
        return nazivTipaModela;
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
        final TipModelaAutomobila other = (TipModelaAutomobila) obj;
        if (!Objects.equals(this.sifraTipaModela, other.sifraTipaModela)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String vratiNazivTabele() {
        return "tipmodelaautomobila";
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
        return "tip";
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
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet resultSet) throws SQLException {

        List<OpstiDomenskiObjekat> list = new LinkedList<>();
        while (resultSet.next()) {

            Long id = resultSet.getLong("sifraTipaModela");
            String ime = resultSet.getString("nazivTipaModela");

            TipModelaAutomobila tip = new TipModelaAutomobila(id, ime);
            list.add(tip);
        }
        return list;

    }

    @Override
    public String vratiOrderUslov() {
        return "";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "";
    }

    public Long getSifraTipaModela() {
        return sifraTipaModela;
    }

    public void setSifraTipaModela(Long sifraTipaModela) {
        this.sifraTipaModela = sifraTipaModela;
    }

    public String getNazivTipaModela() {
        return nazivTipaModela;
    }

    public void setNazivTipaModela(String nazivTipaModela) {
        this.nazivTipaModela = nazivTipaModela;
    }
}
