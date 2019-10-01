/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forma.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import kontroler.Kontroler;

/**
 *
 * @author Dusan
 */
public class PokretanjeServera extends Thread {

    ServerskaForma sf;
    LinkedList<NitKlijent> klijentskeNiti;

    public PokretanjeServera(ServerskaForma sf) {
        this.sf = sf;
        klijentskeNiti = new LinkedList<>();
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut");
            sf.pokrenutServer();
          
            while (!isInterrupted()) {
                Socket soket = ss.accept();
                System.out.println("Klijent se povezao");
                Kontroler.getInstance().dodajSocket(soket);
//                System.out.println("Broj soketa: " + Kontroler.getInstance().getSoketi().size());
                NitKlijent nk = new NitKlijent(soket);
                nk.start();
                klijentskeNiti.add(nk);
            }
        } catch (IOException ex) {
            System.out.println("Server je zaustavljen");
            sf.nijePokrenutServer();
        }
    }

}
