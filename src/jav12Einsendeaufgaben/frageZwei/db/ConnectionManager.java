package jav12Einsendeaufgaben.frageZwei.db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectionManager {

    private static Connection conn = null;
    private static String mysqlJdbcDriverClass = "org.gjt.mm.mysql.Driver";
    private static String mysqlJdbcConnectionProtocol = "jdbc:mysql://";
    private static String database = "/dbdemo2";

    private static boolean logger = true;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    public static synchronized Connection getConnection(String host, String user, String passwort) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            String mysqlJdbcConnectionUrl = mysqlJdbcConnectionProtocol + host + database;
            conn = DriverManager.getConnection(mysqlJdbcConnectionUrl, user, passwort);
            System.out.println("New connection for " + user + " created " + sdf.format(new Date()));

        } catch (Exception ie) {
            System.out.println("Baglanti kurulamadi " + ie.getMessage());
        }
        return conn;
    }

    /**
     * TODO: Get Connection needs improvements
     * TODO: Close Connection method
     * TODO: Release Connection Methods
     * @param args
     */
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionManager.getConnection("localhost", "demo-user", "");
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
}
