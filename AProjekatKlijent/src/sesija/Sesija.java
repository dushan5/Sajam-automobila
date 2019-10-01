/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domain.Zaposleni;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Sesija {

    private static Sesija instance;
    private Zaposleni trenutniZaposleni;
    private final Map<String, Object> useCaseParams;

    private Sesija() {
        useCaseParams = new HashMap<>();
    }

    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }

    public Zaposleni getTrenutniZaposleni() {
        return trenutniZaposleni;
    }

    public void setTrenutniZaposleni(Zaposleni trenutniZaposleni) {
        this.trenutniZaposleni = trenutniZaposleni;
    }


    public Map<String, Object> getUseCaseParams() {
        return useCaseParams;
    }

}
