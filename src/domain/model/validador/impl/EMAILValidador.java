package domain.model.validador.impl;

import domain.model.validador.ChavePixValidador;
import domain.model.validador.exception.ValidadorException;

import java.sql.Timestamp;

public class EMAILValidador implements ChavePixValidador {

    private static final String REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    public static Timestamp validar(String valor) throws ValidadorException {
        if (valor.matches(REGEX)) return new Timestamp(System.currentTimeMillis());
        else throw new  ValidadorException("EMAIL invalido " + valor);
    }
}
