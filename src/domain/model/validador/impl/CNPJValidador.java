package domain.model.validador.impl;

import domain.model.chavePix.ChaveValor;
import domain.model.validador.ChavePixValidador;
import domain.model.validador.exception.ValidadorException;

import java.sql.Timestamp;

public abstract class CNPJValidador implements ChavePixValidador {

    private static final String regex = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}";
    private static final Timestamp timeStamp = new Timestamp(System.currentTimeMillis());


    public static Timestamp validar(String valor) throws ValidadorException {
        if (regex.matches(valor)) return timeStamp;
        throw new ValidadorException("Valor de CNPJ invalido.");
    }
}
