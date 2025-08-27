import domain.model.chavePix.ChavePix;
import domain.model.chavePix.TipoChave;
import domain.model.dadosBancarios.TipoConta;
import domain.model.services.impl.ChavePixService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String cnpj = "12.345.678/0001-95";

        String ag = "12345";
        String conta = "234567";
        String codigoBanco = "23456";
        String valor = "12345678000195";
        TipoConta tipoConta = TipoConta.CORRENTE;
        TipoChave tipoChave = TipoChave.CNPJ;

        ChavePix chavePix = ChavePixService.service(ag, conta, codigoBanco, valor, tipoConta, tipoChave);
        System.out.println(chavePix);
    }
}