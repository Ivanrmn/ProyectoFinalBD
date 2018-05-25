package org.mvpigs.proyectoFinalBD.service;

public interface ProductService {
    String getTransformedModelo(String firstWord, String secondWord) throws RookieProjectException;
    Modelo createModel(String firstWord, String secondWord);
    String getTransformed(Modelo modelo) throws RookieProjectException;
}

