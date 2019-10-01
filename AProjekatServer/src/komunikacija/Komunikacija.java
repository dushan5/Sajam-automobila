/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Dusan
 */
public class Komunikacija {

    private static Komunikacija instance;

    private Komunikacija() {

    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void posalji(ServerskiOdgovor sto, Socket soket) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
        oos.writeObject(sto);

    }

    public KlijentskiZahtev primiZahtev(Socket soket) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
        return (KlijentskiZahtev) ois.readObject();

    }

    public void posaljiSvima(ServerskiOdgovor so) throws IOException {
        for (Socket s : kontroler.Kontroler.getInstance().getSoketi()) {
            posalji(so, s);
        }
    }
}
