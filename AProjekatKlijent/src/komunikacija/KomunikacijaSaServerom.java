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
 */
public class KomunikacijaSaServerom {
    private static KomunikacijaSaServerom instance;
    private Socket socket;
    boolean povezan = false;

    private KomunikacijaSaServerom() {

    }

    public static KomunikacijaSaServerom getInstance() {
        if (instance == null) {
            instance = new KomunikacijaSaServerom();
        }
        return instance;
    }

    public boolean isPovezan() {
        return povezan;
    }

    public Socket getSocket() {
        return socket;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);
    }

    public ServerskiOdgovor primiOdgovor() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return (ServerskiOdgovor) ois.readObject();
    }

    public void poveziSe() throws IOException {
        if (!povezan) {
            socket = new Socket("localhost", 9000);
            povezan = true;
        }
    }

    public void zatvoriVezu() throws Exception {
        try {

            socket.close();
            povezan = false;
        } catch (IOException e) {
            throw new Exception("Greska kod zatvaranja soketa!");
        }
    }
}
