package edu.itstep.albums.model;

import edu.itstep.sql.SqlOps;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

//POJO class
public class User implements Serializable {
    private long id;
    private String userName;
    private String password;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserAuthenticated(Connection conn)throws SQLException {
        boolean result = SqlOps.checkUserName(conn, userName, password);
        return result;
    }
}
