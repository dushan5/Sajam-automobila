/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domain.Grad;
import domain.ModelAutomobila;
import domain.OpstiDomenskiObjekat;
import domain.Postavka;
import domain.Proizvodjac;
import domain.StatusModela;
import domain.TipModelaAutomobila;
import domain.Zaposleni;
import exception.ServerDownException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer.util.Operacija;
import transfer.util.StatusServerskogOdgovora;

/**
 *
 */
public class Kontroler {

    private static Kontroler instance;

    private Kontroler() {

    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Zaposleni logIn(String username, String password) throws Exception {
        Zaposleni z = new Zaposleni();
        z.setUsername(username);
        z.setPassword(password);
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacija.LOGIN, z);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == StatusServerskogOdgovora.OK) {
            JOptionPane.showMessageDialog(null, so.getPoruka());
            return (Zaposleni) so.getPodaci();
        }
        Exception ex = (Exception) so.getError();
        throw ex;

    }

    public void krajJe() {
        try {
            KomunikacijaSaServerom.getInstance().zatvoriVezu();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Postavka> vratiPostavke() throws ServerDownException, Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            OpstiDomenskiObjekat ido = new Postavka();
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setPodaci(ido);
            kz.setOperacija(Operacija.VRATI_POSTAVKE);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return (List<Postavka>) so.getPodaci();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public List<Grad> vratiGradove() throws ServerDownException, Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            OpstiDomenskiObjekat ido = new Postavka();
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setPodaci(ido);
            kz.setOperacija(Operacija.VRATI_GRADOVE);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return (List<Grad>) so.getPodaci();
            }
        } catch (Exception ex) {

            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public String azurirajProizvodjaca(Proizvodjac p) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacija.IZMENI_PROIZVODJACA);
            kz.setPodaci(p);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return so.getPoruka();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public String sacuvajProizvodjaca(Proizvodjac a) throws ServerDownException, Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacija.SACUVAJ_PROIZVODJACA);
            kz.setPodaci(a);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return so.getPoruka();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }

        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public List<Proizvodjac> vratiProizvodjace() throws ServerDownException, Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            OpstiDomenskiObjekat ido = new Proizvodjac();
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setPodaci(ido);
            kz.setOperacija(Operacija.VRATI_PROIZVODJACE);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return (List<Proizvodjac>) so.getPodaci();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public String izbrisiProizvodjaca(Proizvodjac p) throws ServerDownException, Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacija.OBRISI_PROIZVODJACA);
            kz.setPodaci(p);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return so.getPoruka();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public List<TipModelaAutomobila> vratiTipove() throws ServerDownException, Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            OpstiDomenskiObjekat ido = new TipModelaAutomobila();
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setPodaci(ido);
            kz.setOperacija(Operacija.VRATI_TIPOVE_MA);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return (List<TipModelaAutomobila>) so.getPodaci();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public String sacuvajModelAutomobila(ModelAutomobila ma) throws ServerDownException, Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacija.SACUVAJ_MODEL_AUTOMOBILA);
            kz.setPodaci(ma);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return so.getPoruka();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }

        Exception ex = (Exception) so.getError();
        System.out.println("obican exception bacen");
        throw ex;
    }

    public List<ModelAutomobila> vratiModeleAutomobila() throws ServerDownException, Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            OpstiDomenskiObjekat ido = new ModelAutomobila();
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setPodaci(ido);
            kz.setOperacija(Operacija.VRATI_MODELE_AUTOMOBILA);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return (List<ModelAutomobila>) so.getPodaci();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public String izbrisiModelAutomobila(ModelAutomobila model) throws ServerDownException, Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacija.OBRISI_MODEL_AUTOMOBILA);
            kz.setPodaci(model);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                return so.getPoruka();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public void postaviStatuseModelimaAutomobila(List<ModelAutomobila> listaMA, Date datumOd, Date datumDo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            OpstiDomenskiObjekat ido = new Postavka();

            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacija.VRATI_POSTAVKE);
            kz.setPodaci(ido);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                List<Postavka> postavke = (List<Postavka>) so.getPodaci();

                for (ModelAutomobila ma : listaMA) {
                    StatusModela status = StatusModela.NIJE_IZLOZEN;

                    for (Postavka p : postavke) {
                        if (p.getListaModela() != null) {
                            if (p.getListaModela().contains(ma)) {
                                Date dOd = p.getDatumOd();
                                Date dDo = p.getDatumDo();
                                if (dOd.after(datumOd) && dOd.before(datumDo)) {
                                    status = StatusModela.IZLOZEN;
                                }
                                if (dDo.after(datumOd) && dDo.before(datumDo)) {
                                    status = StatusModela.IZLOZEN;
                                }
                            }
                        }
                    }
                    ma.setStatus(status);
                }
                return;
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }

        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public String sacuvajPostavku(Postavka postavka) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacija.SACUVAJ_POSTAVKU);
            kz.setPodaci(postavka);
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                postavka.setSifraPostavke((Long) so.getPodaci());

                return so.getPoruka();
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }

    public void odjaviSe() throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacija.LOGOUT);
            kz.setPodaci(sesija.Sesija.getInstance().getTrenutniZaposleni());
            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
            so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            if (so.getStatus() == StatusServerskogOdgovora.OK) {
                KomunikacijaSaServerom.getInstance().zatvoriVezu();
                return;
            }
        } catch (Exception ex) {
            System.out.println("server je prestao sa radom");
            throw new ServerDownException("Server je prestao sa radom");
        }
        Exception ex = (Exception) so.getError();
        throw ex;
    }
}
