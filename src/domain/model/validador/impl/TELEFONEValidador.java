package domain.model.validador.impl;

import domain.model.validador.ChavePixValidador;
import domain.model.validador.exception.ValidadorException;

import java.sql.Timestamp;

public class TELEFONEValidador implements ChavePixValidador {

    private static final String REGEX = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$";

    @Override
    public Timestamp validar(String valor) throws ValidadorException {
        if (valor.matches(REGEX)) return new Timestamp(System.currentTimeMillis());
        else throw new ValidadorException("Valor do TELEFONE incorreto: " + valor);
    }
}
