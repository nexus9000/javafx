package edu.itstep.albums.model;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Albums implements Serializable {

    private Long id;
    private String albumName;
    private String years;
    private Boolean isChecked = true;
    private String user;
    private String albums;
    public String getUser() {
        return user;
    }

    public String getAlbums() {
        return albums;
    }



    public Albums(Long id, String albumName, String years, Boolean isChecked){
       this.id = id;
       this.albumName = albumName;
       this.years = years;
       this.isChecked = isChecked;
    }
   public Albums(String albums, String user){
       this.albums = albums;
       this.user = user;
   }
    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        this.isChecked = checked;
    }
    public static ArrayList<Albums> listUser(Connection conn)throws SQLException {
        ArrayList<Albums> albums = new ArrayList<>();
        String sql = "select user_name," +
                "album_name from users_collections join" +
                " users on users.id = users_collections.user_id join" +
                " albums on albums.id = users_collections.album_id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String user = rs.getString(1);
            String album = rs.getString(2);
            Albums album1 = new Albums(album,user);
            albums.add(album1);
        }
        ps.close();
        rs.close();
        return albums;
    }

    public static @NotNull ArrayList<Albums> listAlbums(@NotNull Connection conn)throws SQLException{
        ArrayList<Albums> albums = new ArrayList<>();
        String sql = "select id,album_name,years from albums limit 20";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Long id = rs.getLong(1);
            String album = rs.getString(2);
            String years = rs.getString(3);
            Albums album1 = new Albums(id,album,years,false);
            albums.add(album1);
        }
        ps.close();
        rs.close();
        return albums;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }



}
