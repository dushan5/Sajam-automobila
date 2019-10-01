/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.modelautomobila;

import domain.ModelAutomobila;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Nikola
 */
public class UnosModelaAutomobilaSO extends OpstaSistemskaOperacija {

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof ModelAutomobila)) {
            throw new Exception("Invalid object!");
        }

    }

    @Override
    protected void execute(Object entity) throws Exception {
        try {
            databaseBroker.insert((ModelAutomobila) entity);
        } catch (Exception ex) {
            throw new Exception("Model nije uspešno dodat!");
        }
    }
}
