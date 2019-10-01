package transfer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

/**
 *
 * @author Dusan
 */
public class KlijentskiZahtev implements Serializable {

    private int operacija;
    private Object podaci;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, Object podaci) {
        this.operacija = operacija;
        this.podaci = podaci;
    }
    
    

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public Object getPodaci() {
        return podaci;
    }

    

}
