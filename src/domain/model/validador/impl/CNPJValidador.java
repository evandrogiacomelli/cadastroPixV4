package domain.model.validador.impl;

import domain.model.chavePix.ChaveValor;
import domain.model.validador.ChavePixValidador;
import domain.model.validador.exception.ValidadorException;

import java.sql.Timestamp;

public abstract class CNPJValidador implements ChavePixValidador {

    private static final String REGEX = "(\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})|(\\d{14})";


    public static Timestamp validar(String valor) throws ValidadorException {
        if (valor.matches(REGEX)) return new Timestamp(System.currentTimeMillis());
        else throw new ValidadorException("Valor de CNPJ invalido: " + " " + valor);
    }
}
