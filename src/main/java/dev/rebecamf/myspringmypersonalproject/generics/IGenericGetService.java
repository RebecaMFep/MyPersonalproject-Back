package dev.rebecamf.myspringmypersonalproject.generics;

public interface IGenericGetService<T> {

    T getById(Long id) throws Exception;
    
}

