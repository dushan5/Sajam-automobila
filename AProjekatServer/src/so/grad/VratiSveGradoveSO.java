/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.grad;

import domain.Grad;
import domain.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Nikola
 */
public class VratiSveGradoveSO extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Grad)) {
            throw new Exception("Invalid object!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = databaseBroker.select((Grad) entity);
    }

    public List<OpstiDomenskiObjekat> getList() {
        return list;
    }

}
