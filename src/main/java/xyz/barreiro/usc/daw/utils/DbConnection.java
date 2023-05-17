package xyz.barreiro.usc.daw.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class DbConnection {
    private static Connection CONN;

    private static Connection getConn() {
        if (DbConnection.CONN == null) {
            try {
                String path = System.getenv("DB_PATH");
                if (path == null) {
                    throw new SQLException("Missing DB_PATH");
                }

                Class.forName("org.sqlite.JDBC");
                DbConnection.CONN = DriverManager.getConnection("jdbc:sqlite:" + path);
            } catch (SQLException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }

        return DbConnection.CONN;
    }

    public static PreparedStatement prepareStatement(String stmt) {
        Connection conn = DbConnection.getConn();

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(stmt);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return ps;
    }
}
