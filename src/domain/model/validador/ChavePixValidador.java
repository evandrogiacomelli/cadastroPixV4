package domain.model.validador;

import domain.model.chavePix.ChaveValor;
import domain.model.validador.exception.ValidadorException;

import java.sql.Timestamp;

public interface ChavePixValidador {


    Timestamp validar(ChaveValor valor) throws ValidadorException;

}
