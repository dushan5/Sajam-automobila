/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.postavka;

import domain.ModelNaSajmu;
import domain.OpstiDomenskiObjekat;
import domain.Postavka;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Nikola
 */
public class VratiSvePostavkeSO extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Postavka)) {
            throw new Exception("Invalid object!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {

        list = databaseBroker.select((Postavka) entity);
        for (OpstiDomenskiObjekat odo : list) {
            Postavka p = (Postavka) odo;
            ModelNaSajmu mns = new ModelNaSajmu(null, p, 0);
            databaseBroker.select(mns);
        }

    }

    public List<OpstiDomenskiObjekat> getList() {
        return list;
    }

}
