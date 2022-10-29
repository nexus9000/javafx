package edu.itstep.albums.model;

import edu.itstep.sql.SqlOps;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDB {
    private static ConnectionDB connectionDB;
    private Connection connection;

    private ConnectionDB() {

    }

    public static ConnectionDB getInstance() {
        if (connectionDB == null) {
            return new ConnectionDB();
        } else {
            return connectionDB;
        }
    }

    public  Connection getConnectionDB() throws SQLException, ClassNotFoundException {
        return SqlOps.getConn();//get and init connection to DB
    }

    public void closeConnectionToDB() throws SQLException {
        SqlOps.closeConn();
    }
}
