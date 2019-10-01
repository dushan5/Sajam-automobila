/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dusan
 */
public class SettingsLoader {

    private static SettingsLoader instance;
    private Properties props;

    private SettingsLoader() {
        try {
            props = new Properties();
            props.load(new FileInputStream("settings.properties"));

        } catch (Exception ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static SettingsLoader getInstance() {
        if (instance == null) {
            instance = new SettingsLoader();
        }
        return instance;
    }

    public String vratiVrednost(String kljuc) {
        return props.getProperty(kljuc, "n/a");
    }

    public void postaviVrednost(String kljuc, String vrednost) throws FileNotFoundException, IOException {

        props.setProperty(kljuc, vrednost);
        props.store(new FileOutputStream("settings.properties"), null);

    }

}
