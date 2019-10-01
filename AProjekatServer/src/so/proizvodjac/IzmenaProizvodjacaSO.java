/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proizvodjac;

import domain.Proizvodjac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Nikola
 */
public class IzmenaProizvodjacaSO extends OpstaSistemskaOperacija {

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Proizvodjac)) {
            throw new Exception("Invalid object!");
        }

    }

    @Override
    protected void execute(Object entity) throws Exception {
        databaseBroker.update((Proizvodjac) entity);
    }
}
