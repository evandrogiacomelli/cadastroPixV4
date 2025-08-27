package domain.model.validador;

import domain.model.chavePix.ChaveValor;
import domain.model.validador.exception.ValidadorException;

import java.sql.Timestamp;

public interface ChavePixValidador {


    static Timestamp validar(String valor) throws ValidadorException {
        return null;
    }

}
