/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.SettingsLoader;

/**
 *
 * @author Dusan
 */
public class DatabaseConnection {

    private static Connection connection;
    private static DatabaseConnection instance;
    boolean testiran = false;

    private DatabaseConnection() throws SQLException {
        try {
            String url = SettingsLoader.getInstance().vratiVrednost("url");
            String dbuser = SettingsLoader.getInstance().vratiVrednost("user");
            String dbpassword = SettingsLoader.getInstance().vratiVrednost("password");
            connection = DriverManager.getConnection(url, dbuser, dbpassword);
            connection.setAutoCommit(false);
            System.out.println("povezan sa bazom");
        } catch (SQLException s) {
            connection = null;
            System.out.println("neuspesna konekcija sa bazom");
            throw s;
        }
    }

    public void testirajKonekciju(String s1, String s2, String s3) throws SQLException {
        try {
            connection = DriverManager.getConnection(s1, s2, s3);
            connection.setAutoCommit(false);
        } catch (SQLException s) {
            connection = null;
            System.out.println("neuspesna konekcija sa bazom");
            throw s;
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

}
