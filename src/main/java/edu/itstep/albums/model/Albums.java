package edu.itstep.albums.model;

import edu.itstep.sql.SqlOps;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Albums implements Serializable {

    private Long id;
    private String albumName;

    public Albums(Long id, String albumName){
       this.id = id;
       this.albumName = albumName;
    }

    public static  HashMap<Long,String> listAlbums(Connection conn)throws SQLException{
        HashMap<Long,String> albums = SqlOps.getAlbumsList(conn);
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

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
