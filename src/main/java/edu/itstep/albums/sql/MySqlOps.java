package edu.itstep.albums.sql;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MySqlOps {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/albums";
    private static Connection conn;
    private static String user = "root";
    private static String password = "cisco";
    private static PreparedStatement ps;
    private static ResultSet rs;//cursor database
    private Statement st;
    private HashMap<String, String> users;
    public static Long userId;
    public static Connection getConn() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL, user, password);
        return conn;
    }

    public static String getPassword(@NotNull Connection conn, String userName) throws SQLException {
        String sql = "select id, password from albums.users where albums.users.user_name = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        rs = ps.executeQuery();
        String password  = "";
        if(rs.next()){
            userId = rs.getLong(1);
            password = rs.getString(2) ;
        }
        return password;
    }

    public static boolean checkUserName(@NotNull Connection conn, String userName, String password) throws SQLException {
        String sql = "select user_name,password from users where user_name=? and password=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, password);
        rs = ps.executeQuery();
        if (rs.next()) return true;
        else return false;
    }

    public static HashMap<Long, String> getAlbumsList(@NotNull Connection conn) throws SQLException {
        HashMap<Long, String> albums = new HashMap<>();
        String sql = "select id,album_name from albums limit 5";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            long id = rs.getLong(1);
            String album = rs.getString(2);
            albums.put(id, album);
        }
        return albums;
    }

    public static void writeToAlbums(@NotNull Connection conn, ArrayList<Long> list) throws SQLException {
        Statement st = conn.createStatement();
        for (Long albumId : list) {
            String sql = "insert into user_colections (user_id, album_id) values (" + userId + "," + albumId + ")";
            st.addBatch(sql);
        }
        st.executeBatch();
        st.close();
    }

    public static void closeConn() throws SQLException {
        ps.close();
        rs.close();
        conn.close();
    }
}
