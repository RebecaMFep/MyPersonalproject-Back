package dev.rebecamf.myspringmypersonalproject.encryptations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import dev.rebecamf.myspringmypersonalproject.encryptations.base64facade.Base64Encoder;
import dev.rebecamf.myspringmypersonalproject.encryptations.bcrypEncoder.BcryptEncoder;
import dev.rebecamf.myspringmypersonalproject.encryptations.IEncryptFacade;

@SuppressWarnings("unused")
@Component
public class EncoderFacade implements IEncryptFacade {
    
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public EncoderFacade() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public String encode(String type, String data) {

        String dataEncrypted = "";

        if (type == "base64") dataEncrypted = new Base64Encoder().encode(data);
        if (type == "bcrypt") dataEncrypted = new BcryptEncoder(bCryptPasswordEncoder).encode(data);
        
        return dataEncrypted;
    }

    public String decode(String type, String data) {

        String dataDecoded = "";

        if (type == "base64") dataDecoded = new Base64Encoder().decode(data);

        return dataDecoded;
    }

}
