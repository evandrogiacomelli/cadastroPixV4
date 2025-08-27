package domain.model.validador;

import domain.model.chavePix.TipoChave;
import domain.model.validador.impl.CNPJValidador;

import java.sql.Timestamp;

public class ChavePixFactory {

    public ChavePixFactory() {
    }

    public static Timestamp validateAndStamp(String valor, TipoChave tipo) {
        if (TipoChave.CNPJ == tipo)
            return CNPJValidador.validar(valor);
        return null;
    }
}
