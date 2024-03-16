package dev.rebecamf.myspringmypersonalproject.encryptations.bcrypEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import dev.rebecamf.myspringmypersonalproject.encryptations.IEncoder;

public class BcryptEncoder implements IEncoder {
    
    BCryptPasswordEncoder encoder;

    public BcryptEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String data) {
        String dataEncoded = encoder.encode(data);
        return dataEncoded;
    }

}
