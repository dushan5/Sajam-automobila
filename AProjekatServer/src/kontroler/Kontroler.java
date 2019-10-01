/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import so.proizvodjac.IzmenaProizvodjacaSO;
import so.proizvodjac.UnosProizvodjacaSO;
import so.proizvodjac.VratiSveProizvodjaceSO;
import so.proizvodjac.BrisanjeProizvodjacaSO;
import so.grad.VratiSveGradoveSO;
import so.postavka.VratiSvePostavkeSO;
import so.postavka.UnosPostavkeSO;
import so.modelautomobila.VratiSveMASO;
import so.modelautomobila.BrisanjeModelaAutomobilaSO;
import so.modelautomobila.UnosModelaAutomobilaSO;
import so.tipMA.VratiSveTipoveMASO;
import domain.Grad;
import domain.ModelAutomobila;
import domain.OpstiDomenskiObjekat;
import domain.Postavka;
import domain.Proizvodjac;
import domain.TipModelaAutomobila;
import domain.Zaposleni;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import javax.security.auth.login.LoginException;
import so.OpstaSistemskaOperacija;
import so.zaposleni.UlogujZaposlenogSO;

/**
 *
 * @author Dusan
 */
public class Kontroler {

    private static Kontroler instance;
    LinkedList<Zaposleni> ulogovaniZaposleni;
    LinkedList<Socket> soketi;

    private Kontroler() {
        ulogovaniZaposleni = new LinkedList<>();
        soketi = new LinkedList<>();

    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public LinkedList<Zaposleni> getUlogovaniZaposleni() {
        return ulogovaniZaposleni;
    }

    public LinkedList<Socket> getSoketi() {
        return soketi;
    }

    public void dodajUlogovanog(Zaposleni z) {
        ulogovaniZaposleni.add(z);
    }

    public void izbrisiUlogovanog(Zaposleni z) {
        ulogovaniZaposleni.remove(z);
    }

    public void dodajSocket(Socket s) {
        soketi.add(s);
    }

    public void izbrisiSocket(Socket s) {
        soketi.remove(s);
    }

    public Zaposleni logIn(String username, String password) throws Exception {
        Zaposleni z = new Zaposleni(-1l, "", "", "", "", username, password);
        UlogujZaposlenogSO so = new UlogujZaposlenogSO();
        try {
            so.templateExecute(z);
        } catch (LoginException le) {
            throw le;
        } catch (Exception e) {
            throw new Exception("Neuspešna konekcija");
        }

        if (ulogovaniZaposleni.contains(so.vratiZaposlenog())) {
            throw new LoginException("Zaposleni je već ulogovan!");
        }
        return so.vratiZaposlenog();
    }

    public List<OpstiDomenskiObjekat> vratiGradove() throws Exception {
        OpstaSistemskaOperacija so = new VratiSveGradoveSO();
        so.templateExecute(new Grad());
        return ((VratiSveGradoveSO) so).getList();
    }

    public void sacuvajProizvodjaca(Proizvodjac pr) throws Exception {
        OpstaSistemskaOperacija so = new UnosProizvodjacaSO();
        so.templateExecute(pr);
    }

    public void obrisiProizvodjaca(Proizvodjac pr2) throws Exception {
        OpstaSistemskaOperacija so = new BrisanjeProizvodjacaSO();
        so.templateExecute(pr2);
    }

    public void izmeniProizvodjaca(Proizvodjac pr3) throws Exception {
        OpstaSistemskaOperacija so = new IzmenaProizvodjacaSO();
        so.templateExecute(pr3);
    }

    public List<OpstiDomenskiObjekat> vratiProizvodjace() throws Exception {
        OpstaSistemskaOperacija so = new VratiSveProizvodjaceSO();
        so.templateExecute(new Proizvodjac());
        return ((VratiSveProizvodjaceSO) so).getList();
    }

    public void sacuvajModelAutomobila(ModelAutomobila ma) throws Exception {
        OpstaSistemskaOperacija so = new UnosModelaAutomobilaSO();
        so.templateExecute(ma);
    }

    public List<OpstiDomenskiObjekat> vratiTipoveMA() throws Exception {
        OpstaSistemskaOperacija so = new VratiSveTipoveMASO();
        so.templateExecute(new TipModelaAutomobila());
        return ((VratiSveTipoveMASO) so).getList();
    }

    public void obrisiModelAutomobila(ModelAutomobila ma2) throws Exception {
        OpstaSistemskaOperacija so = new BrisanjeModelaAutomobilaSO();
        so.templateExecute(ma2);
    }

    public List<OpstiDomenskiObjekat> vratiModeleAutomobila() throws Exception {
        OpstaSistemskaOperacija so = new VratiSveMASO();
        so.templateExecute(new ModelAutomobila());
        return ((VratiSveMASO) so).getList();
    }

    public List<OpstiDomenskiObjekat> vratiPostavke() throws Exception {
        OpstaSistemskaOperacija so = new VratiSvePostavkeSO();
        so.templateExecute(new Postavka());
        return ((VratiSvePostavkeSO) so).getList();
    }

    public void sacuvajPostavku(Postavka p) throws Exception {
        OpstaSistemskaOperacija so = new UnosPostavkeSO();
        so.templateExecute(p);
    }

}
