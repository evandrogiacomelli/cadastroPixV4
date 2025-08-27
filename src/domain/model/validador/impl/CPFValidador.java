package domain.model.validador.impl;

import domain.model.validador.ChavePixValidador;
import domain.model.validador.exception.ValidadorException;

import java.sql.Timestamp;

public class CPFValidador implements ChavePixValidador {

    private static final String REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

    public Timestamp validar(String valor) throws ValidadorException {
        if (valor.matches(REGEX)) return new Timestamp(System.currentTimeMillis());
        else throw new ValidadorException("CPF invalido: " + valor);
    }
}
