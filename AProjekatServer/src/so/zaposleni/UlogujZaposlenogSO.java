/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

import domain.Zaposleni;
import javax.security.auth.login.LoginException;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Dusan
 */
public class UlogujZaposlenogSO extends OpstaSistemskaOperacija {

    private Zaposleni zaposleni;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Zaposleni)) {
            throw new Exception("Invalid object!");
        }
    }

    @Override
    protected void execute(Object entity) throws LoginException,Exception {
        zaposleni = (Zaposleni) databaseBroker.uloguj((Zaposleni) entity);
    }

    public Zaposleni vratiZaposlenog() {
        return zaposleni;
    }
}
