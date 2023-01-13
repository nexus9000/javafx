package edu.itstep.albums.model;

import edu.itstep.sql.MySqlOps;

import java.sql.Connection;
import java.sql.SQLException;

//Singleton
public class ConnectionMySqlDb {
    private static ConnectionMySqlDb connectionDB;
    private Connection connection;

    private ConnectionMySqlDb() {

    }

    public static ConnectionMySqlDb getInstance() {
        if (connectionDB == null) {
            return new ConnectionMySqlDb();
        } else {
            return connectionDB;
        }
    }

    public Connection getConnectionDB() throws SQLException,ClassNotFoundException {
        return MySqlOps.getConn();//get and init connection to DB
    }

    public void closeConnectionToDB() throws SQLException {
        MySqlOps.closeConn();
    }
}
