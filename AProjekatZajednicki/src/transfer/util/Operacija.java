/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Dusan
 */
public interface Operacija {

    public static final int LOGIN = 1;
    public static final int VRATI_GRADOVE = 2;
    public static final int VRATI_PROIZVODJACE = 3;
    public static final int SACUVAJ_PROIZVODJACA = 4;
    public static final int IZMENI_PROIZVODJACA = 5;
    public static final int OBRISI_PROIZVODJACA = 6;
    public static final int VRATI_POSTAVKE = 7;
    public static int SACUVAJ_MODEL_AUTOMOBILA = 8;
    public static final int VRATI_TIPOVE_MA = 9;
    public static final int VRATI_MODELE_AUTOMOBILA = 10;
    public static final int OBRISI_MODEL_AUTOMOBILA = 11;
    public static int SACUVAJ_POSTAVKU = 12;
    public static final int LOGOUT = 13;

}
