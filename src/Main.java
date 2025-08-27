import domain.model.chavePix.ChavePix;
import domain.model.chavePix.TipoChave;
import domain.model.dadosBancarios.TipoConta;
import domain.model.services.impl.ChavePixService;
import infrastructure.repository.ArquivoLocalRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String cnpj = "12.345.678/0001-95";

        String ag = "12345";
        String conta = "234567";
        String codigoBanco = "23456";
        String valor = "TEST4@TEST.COM";
        TipoConta tipoConta = TipoConta.CORRENTE;
        TipoChave tipoChave = TipoChave.EMAIL;

        ChavePix chavePix = ChavePixService.service(ag, conta, codigoBanco, valor, tipoConta, tipoChave);
        System.out.println(chavePix);

        ArquivoLocalRepository local = new ArquivoLocalRepository("data");
        local.save(chavePix);
        String reCreate = local.find(valor);
        System.out.println(ChavePixService.serviceCSV(reCreate));

        local.delete("TEST3@TEST.COM");

    }
}