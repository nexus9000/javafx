package edu.itstep.albums.model;

import edu.itstep.sql.SqlOps;

import java.sql.SQLException;

public class AlbumActivities {

   public boolean isUserAuthenticated()throws SQLException{
       boolean result = false;
       SqlOps.checkUserName(null, null, null);

       return result;
   }
}
