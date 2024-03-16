package dev.rebecamf.myspringmypersonalproject.files;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
    
    void store(MultipartFile file);

}
