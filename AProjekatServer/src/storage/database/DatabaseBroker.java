/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.security.auth.login.LoginException;
import storage.IDatabaseBroker;
import storage.database.connection.DatabaseConnection;

/**
 *
 * @author Dusan
 */
public class DatabaseBroker implements IDatabaseBroker {

    @Override
    public OpstiDomenskiObjekat uloguj(OpstiDomenskiObjekat entity) throws LoginException, Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
//            System.out.println("Uspostavljena je konekcija na bazu");
            String query = "select * from " + entity.vratiNazivTabele() + entity.vratiWhereUslovSelect();
//            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<OpstiDomenskiObjekat> lista = entity.ucitajListu(resultSet);
            if (lista.isEmpty()) {
                throw new LoginException("Uneli ste pogrešno korisničko ime ili šifru!");
            } else {
                Zaposleni z = (Zaposleni) lista.get(0);
                statement.close();
                return z;
            }
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Override
    public List<OpstiDomenskiObjekat> select(OpstiDomenskiObjekat odo) throws Exception {
        List<OpstiDomenskiObjekat> list = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
//            System.out.println("Uspostavljena je konekcija na bazu");
            String sql = "select " + odo.vratiKoloneZaSelektovanje() + " from " + odo.vratiNazivTabele() + " as " + odo.vratiAlijas()
                    + odo.vratiUslovZaJoin() + odo.vratiWhereUslovSelect() + odo.vratiGrupisanje() + odo.vratiOrderUslov();
//            System.out.println(sql);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            list = odo.ucitajListu(resultSet);
            resultSet.close();
            statement.close();
            return list;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void insert(OpstiDomenskiObjekat odo) throws Exception {

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
//            System.out.println("Uspostavljena je konekcija na bazu");
            String sql = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiNaziveKolona() + ")" + " VALUES (" + odo.vratiVrednostiZaUnos() + ")";
//            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();


        } catch (Exception ex) {
            throw ex;
        }

    }

    @Override
    public void delete(OpstiDomenskiObjekat odo) throws Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
//            System.out.println("Uspostavljena je konekcija na bazu");
            String sql = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiWhereUslov();
//            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();

        } catch (Exception ex) {
            throw ex;

        }
    }

    @Override
    public void update(OpstiDomenskiObjekat odo) throws Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
//            System.out.println("Uspostavljena je konekcija na bazu");
            String sql = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiWhereUslov();
//            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();

        } catch (Exception ex) {
            throw new Exception("Sistem ne može da zapamti izmene!");
        }
    }

    public Long vratiNoviID(OpstiDomenskiObjekat odo) throws Exception {
        Long max = 0l;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
//            System.out.println("Uspostavljena je konekcija na bazu");
            String sql = "SELECT max(" + odo.vratiPrimarniKljuc() + ") as maxKljuc" + " FROM " + odo.vratiNazivTabele();
//            System.out.println(sql);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                max = rs.getLong("maxKljuc");
            }

            return max;

        } catch (Exception ex) {
            throw new Exception("Sistem ne može da vrati primarni kljuc!");
        }
    }

}
