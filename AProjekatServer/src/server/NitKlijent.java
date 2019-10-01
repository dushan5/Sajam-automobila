/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domain.ModelAutomobila;
import domain.OpstiDomenskiObjekat;
import domain.Postavka;
import domain.Proizvodjac;

import domain.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import komunikacija.Komunikacija;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer.util.Operacija;
import transfer.util.StatusServerskogOdgovora;

/**
 *
 * @author Dusan
 */
public class NitKlijent extends Thread {

    Socket soket;
    boolean kraj = false;
    Zaposleni zaposleni;

    public NitKlijent(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {
        try {

            while (!kraj && !isInterrupted()) {
                KlijentskiZahtev kz = Komunikacija.getInstance().primiZahtev(soket);

                ServerskiOdgovor so = new ServerskiOdgovor();
                switch (kz.getOperacija()) {

                    case Operacija.LOGIN:
                        Zaposleni zaposleniZahtev = (Zaposleni) kz.getPodaci();
                         {
                            try {

                                zaposleni = Kontroler.getInstance().logIn(zaposleniZahtev.getUsername(), zaposleniZahtev.getPassword());

                                Kontroler.getInstance().dodajUlogovanog(zaposleni);
                                System.out.println("Uspesno prijavljen: " + zaposleni.getUsername());
                                so.setStatus(StatusServerskogOdgovora.OK);
                                so.setPodaci(zaposleni);
                                so.setPoruka("Prijavljivanje je uspešno izvršeno!");
                            } catch (LoginException le) {
                                System.out.println("neuspesno logovanje");
                                so.setStatus(StatusServerskogOdgovora.ERROR);
                                so.setError(le);
                            } catch (Exception ex) {
                                System.out.println("neuspesno logovanje");
                                so.setStatus(StatusServerskogOdgovora.ERROR);
                                so.setError(ex);
                            }
                        }
                        break;
                    case Operacija.VRATI_GRADOVE:
                        try {
                            List<OpstiDomenskiObjekat> gradovi = Kontroler.getInstance().vratiGradove();

                            so.setPodaci(gradovi);
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("nije moguce vratiti gradove iz baze");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.SACUVAJ_PROIZVODJACA:
                        Proizvodjac pr = (Proizvodjac) kz.getPodaci();
                        try {
                            Kontroler.getInstance().sacuvajProizvodjaca(pr);
                            System.out.println("Proizvođač je uspešno dodat");
                            so.setPoruka("Proizvođač je uspešno dodat!");
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("greska pri unosu proizvođača u bazu");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.OBRISI_PROIZVODJACA:
                        Proizvodjac pr2 = (Proizvodjac) kz.getPodaci();
                        try {
                            Kontroler.getInstance().obrisiProizvodjaca(pr2);
                            System.out.println("Proizvođač je uspesno obrisan");
                            so.setPoruka("Proizvođač je uspešno obrisan!");
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("greska pri brisanju proizvođača");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.IZMENI_PROIZVODJACA:
                        Proizvodjac pr3 = (Proizvodjac) kz.getPodaci();
                        try {
                            Kontroler.getInstance().izmeniProizvodjaca(pr3);
                            System.out.println("Proizvođač je uspesno izmenjen");
                            so.setPoruka("Proizvođač je uspešno izmenjen!");
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("greska pri izmeni proizvođača");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.VRATI_PROIZVODJACE:
                        try {
                            List<OpstiDomenskiObjekat> umetnici = Kontroler.getInstance().vratiProizvodjace();

                            so.setPodaci(umetnici);
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("nije moguce vratiti proizvođače iz baze");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.SACUVAJ_MODEL_AUTOMOBILA:
                        ModelAutomobila ma = (ModelAutomobila) kz.getPodaci();
                        try {
                            Kontroler.getInstance().sacuvajModelAutomobila(ma);
                            System.out.println("model je uspesno dodat");
                            so.setPoruka("Model je uspešno dodat!");
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("greska pri unosu modela u bazu");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.VRATI_TIPOVE_MA:
                        try {
                            List<OpstiDomenskiObjekat> tipovi = Kontroler.getInstance().vratiTipoveMA();

                            so.setPodaci(tipovi);
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("nije moguce vratiti TIPOVE MA iz baze");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.OBRISI_MODEL_AUTOMOBILA:
                        ModelAutomobila ma2 = (ModelAutomobila) kz.getPodaci();
                        try {
                            Kontroler.getInstance().obrisiModelAutomobila(ma2);
                            System.out.println("model je uspesno obrisan");
                            so.setPoruka("Model je uspešno obrisan!");
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("greska kod brisanja modela");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.VRATI_MODELE_AUTOMOBILA:
                        try {
                            List<OpstiDomenskiObjekat> mas = Kontroler.getInstance().vratiModeleAutomobila();

                            so.setPodaci(mas);
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("Nije moguce vratiti modele iz baze");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.VRATI_POSTAVKE:
                        try {
                            List<OpstiDomenskiObjekat> postavke = Kontroler.getInstance().vratiPostavke();
                            so.setPodaci(postavke);
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("Nije moguce vratiti postavke iz baze");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.SACUVAJ_POSTAVKU:
                        Postavka p = (Postavka) kz.getPodaci();
                        try {
                            Kontroler.getInstance().sacuvajPostavku(p);
                            System.out.println("Postavka je uspešno dodata!");

                            so.setPoruka("Postavka je uspešno dodata!");
                            so.setPodaci(p.getSifraPostavke());
                            so.setStatus(StatusServerskogOdgovora.OK);
                        } catch (Exception ex) {
                            System.out.println("greska pri unosu postavke u bazu");
                            so.setStatus(StatusServerskogOdgovora.ERROR);
                            so.setError(ex);
                        }
                        break;
                    case Operacija.LOGOUT:
                        Zaposleni zap = (Zaposleni) kz.getPodaci();
                         {
                            try {

                                Kontroler.getInstance().izbrisiUlogovanog(zap);
                                Kontroler.getInstance().izbrisiSocket(soket);
                                so.setStatus(StatusServerskogOdgovora.OK);
                                System.out.println("odjavljen korisnik: " + zap.getUsername());
                                kraj = true;
                            } catch (Exception ex) {
                                System.out.println("neuspesno logoutovanje " + zap.getUsername());
                                so.setStatus(StatusServerskogOdgovora.ERROR);
                                so.setError(new Exception("Neuspešan pokušaj odjave"));
                            }
                        }
                        break;

                }
                Komunikacija.getInstance().posalji(so, soket);
                if (kraj == true) {
                    try {
                        soket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } catch (Exception e) {
            try {
                soket.close();
                Kontroler.getInstance().izbrisiSocket(soket);
                Kontroler.getInstance().izbrisiUlogovanog(zaposleni);
                if (zaposleni != null) {
                    System.out.println("odjavljen korisnik: " + zaposleni.getUsername());
                }
            } catch (IOException ex) {
                Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
