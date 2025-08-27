package domain.model.validador;

import domain.model.chavePix.ChavePix;
import domain.model.chavePix.ChaveValor;
import domain.model.chavePix.TipoChave;
import domain.model.dadosBancarios.DadosBancarios;
import domain.model.validador.exception.TimeStampException;
import domain.model.validador.impl.*;

import java.sql.Timestamp;
import java.util.UUID;

public class ChavePixFactory {

    public ChavePixFactory() {
    }

    public static Timestamp validateAndStamp(String valor, TipoChave tipo) throws TimeStampException {

        switch (tipo){
            case TipoChave.CNPJ -> { return new CNPJValidador().validar(valor); }
            case TipoChave.CPF -> { return new CPFValidador().validar(valor); }
            case TipoChave.EMAIL -> { return new EMAILValidador().validar(valor); }
            case TipoChave.TELEFONE -> { return new TELEFONEValidador().validar(valor); }
            case TipoChave.ALEATORIO -> {return new Timestamp(System.currentTimeMillis()); }
        }
        throw  new TimeStampException("FACTORY ERROR: não foi possivel gerar um TimeStamp, verifique o tipo da chave. ");
    }

    public static ChavePix create(TipoChave tipoChave, DadosBancarios dados,
                                  ChaveValor chaveValor, Timestamp timeStamp) {
        return new ChavePix(tipoChave, dados, chaveValor, timeStamp);
    }
}
