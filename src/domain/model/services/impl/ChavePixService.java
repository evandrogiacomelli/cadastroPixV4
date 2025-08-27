package domain.model.services.impl;

import domain.model.chavePix.ChavePix;
import domain.model.chavePix.ChaveValor;
import domain.model.chavePix.TipoChave;
import domain.model.dadosBancarios.DadosBancarios;
import domain.model.dadosBancarios.TipoConta;
import domain.model.validador.ChavePixFactory;
import domain.model.validador.exception.ServiceException;

import java.sql.Timestamp;


public class ChavePixService {

    public ChavePixService() {};

    public static ChavePix service(String ag, String conta, String codigoBanco, String valor,
                            TipoConta tipoConta, TipoChave tipoChave) throws ServiceException {
        try {
            Timestamp timeStamp = ChavePixFactory.validateAndStamp(valor, tipoChave);
            DadosBancarios dados = new DadosBancarios(ag, conta, codigoBanco, tipoConta);
            ChaveValor chaveValor = new ChaveValor(valor, timeStamp);
            return ChavePixFactory.create(tipoChave, dados, chaveValor, timeStamp);
        }
        catch (ServiceException e) {
            throw new ServiceException("Service exception, ChavePix não pode ser criada.");
        }
    }
}
