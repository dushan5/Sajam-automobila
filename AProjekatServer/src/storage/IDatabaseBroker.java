/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author Dusan
 */
public interface IDatabaseBroker {

    public OpstiDomenskiObjekat uloguj(OpstiDomenskiObjekat odo) throws Exception;

    public List<OpstiDomenskiObjekat> select(OpstiDomenskiObjekat odo) throws Exception;

    public void insert(OpstiDomenskiObjekat odo) throws Exception;

    public void delete(OpstiDomenskiObjekat odo) throws Exception;

    public void update(OpstiDomenskiObjekat odo) throws Exception;

    public Long vratiNoviID(OpstiDomenskiObjekat odo) throws Exception;

}
