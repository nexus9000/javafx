package edu.itstep.albums.tools;

import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;

public final class Security {
    private  static final String SALT = BCrypt.gensalt();

    private Security() {
    }

    public static @NotNull String hashPassword(String plainPassword) {
        return BCrypt.hashpw(SALT, plainPassword);
    }
    public static  boolean comparePassword(String plainPassword, String hashPassword){
        if(hashPassword == null) return false;
        else return BCrypt.checkpw(plainPassword,hashPassword);
    }
}
