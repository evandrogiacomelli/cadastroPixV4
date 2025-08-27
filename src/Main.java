import domain.model.chavePix.ChavePix;
import domain.model.chavePix.TipoChave;
import domain.model.dadosBancarios.TipoConta;
import domain.model.services.impl.ChavePixService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String cnpj = "12.345.678/0001-95";

        String ag = null;
        String conta = null;
        String codigoBanco = null;
        String valor = null;
        TipoConta tipoConta = null;
        TipoChave tipoChave = null;

        ChavePix chavePix = ChavePixService.service(ag, conta, codigoBanco, valor, tipoConta, tipoChave);
        System.out.println(chavePix.toString());
    }
}