/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipMA;

import domain.OpstiDomenskiObjekat;
import domain.TipModelaAutomobila;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Nikola
 */
public class VratiSveTipoveMASO extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof TipModelaAutomobila)) {
            throw new Exception("Invalid object!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {

        list = databaseBroker.select((TipModelaAutomobila) entity);
    }

    public List<OpstiDomenskiObjekat> getList() {
        return list;
    }
}
