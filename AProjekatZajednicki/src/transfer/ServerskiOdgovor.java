package transfer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import transfer.util.StatusServerskogOdgovora;

/**
 *
 * @author Dusan
 */
public class ServerskiOdgovor implements Serializable {

    private StatusServerskogOdgovora status;
    private Object podaci;
    private Object error;
    private String poruka;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(StatusServerskogOdgovora status, Object podaci, Object error, String poruka) {
        this.status = status;
        this.podaci = podaci;
        this.error = error;
        this.poruka = poruka;
    }


    public StatusServerskogOdgovora getStatus() {
        return status;
    }

    public void setStatus(StatusServerskogOdgovora status) {
        this.status = status;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    

}
