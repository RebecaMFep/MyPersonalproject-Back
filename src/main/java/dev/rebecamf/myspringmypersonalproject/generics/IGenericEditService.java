package dev.rebecamf.myspringmypersonalproject.generics;

public interface IGenericEditService<T,R> {
    
    R save(T type) throws Exception;
    R update(T type, Long id);

}
