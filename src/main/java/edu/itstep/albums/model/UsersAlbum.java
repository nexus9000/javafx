package edu.itstep.albums.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersAlbum implements Serializable {
     private String userData;
     private String albumData;
    public UsersAlbum(String userData, String albumData){
        this.userData = userData;
        this.albumData = albumData ;
    }
    @Override
    public String toString(){
        return userData + " "+albumData;
    }
    public static ArrayList<UsersAlbum> listAlbums(Connection conn)throws SQLException {
        ArrayList<UsersAlbum> albums = new ArrayList<>();
        String sql = "select user_name," +
                "album_name from users_collections join" +
                " users on users.id = users_collections.user_id join" +
                " albums on albums.id = users_collections.album_id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String user = rs.getString(1);
            String album = rs.getString(2);
            UsersAlbum album1 = new UsersAlbum(user,album);
            albums.add(album1);
        }
        ps.close();
        rs.close();
        return albums;
    }
 public void setUser(String userData){

        this.userData = userData;
 }
 public void setAlbum(String albumData){
        this.albumData = albumData;
 }
    public String getUserData() {
        return userData;
    }

    public String getAlbumData() {
        return albumData;
    }
}
