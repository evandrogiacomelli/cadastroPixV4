package domain.model.validador;

import domain.model.chavePix.ChavePix;
import domain.model.chavePix.ChaveValor;
import domain.model.chavePix.TipoChave;
import domain.model.dadosBancarios.DadosBancarios;
import domain.model.dadosBancarios.TipoConta;
import domain.model.validador.exception.TimeStampException;
import domain.model.validador.impl.*;

import java.sql.Timestamp;
import java.util.UUID;

public class ChavePixFactory {

    private static final String SEPARADOR = ";";

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

    public static ChavePix reCriarCSV(String linhaCSV) throws Exception {
        String[] campos = linhaCSV.split(SEPARADOR);

        try {
            TipoChave tipo = TipoChave.valueOf(campos[0]);
            DadosBancarios dados = new DadosBancarios(
                campos[1], campos[2], campos[3], TipoConta.valueOf(campos[4])
            );
            ChaveValor valor = new ChaveValor(campos[5], tipo);
            Timestamp ts = Timestamp.valueOf(campos[6]);
            return new ChavePix(tipo, dados, valor, ts);
        } catch (Exception e) {
            throw new Exception("RecriarDeCSV: Parametros inválidos de CSV.");
        }
    }
}
