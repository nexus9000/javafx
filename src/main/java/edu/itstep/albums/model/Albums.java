package edu.itstep.albums.model;

import java.io.Serializable;
public class Albums implements Serializable {

    private long id;
    private String albumName;

    public Albums(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
