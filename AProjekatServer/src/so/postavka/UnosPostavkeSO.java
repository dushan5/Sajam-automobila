/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.postavka;

import domain.ModelAutomobila;
import domain.ModelNaSajmu;
import domain.Postavka;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Nikola
 */
public class UnosPostavkeSO extends OpstaSistemskaOperacija {

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Postavka)) {
            throw new Exception("Invalid object!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        int rb = 1;
        try {
            Postavka postavka = (Postavka) entity;
            databaseBroker.insert(postavka);
            Long sifra = databaseBroker.vratiNoviID(postavka);
            postavka.setSifraPostavke(sifra);
            for (ModelAutomobila ma : postavka.getListaModela()) {
                ModelNaSajmu mns = new ModelNaSajmu(ma, postavka, rb);
                databaseBroker.insert(mns);
                rb++;
            }
        } catch (Exception ex) {
            throw new Exception("Postavka nije uspešno dodata!");
        }
    }
}
