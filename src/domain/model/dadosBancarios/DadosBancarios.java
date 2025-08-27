package domain.model.dadosBancarios;

import java.util.Objects;

public record DadosBancarios(
    String ag,
    String conta,
    String codigoBanco,
    TipoConta tipoConta
) {
   public DadosBancarios{
       Objects.requireNonNull(ag, "Agencia não pode ser nula.");
       Objects.requireNonNull(conta, "Conta não pode ser nula.");
       Objects.requireNonNull(codigoBanco, "Codigo do Banco não pode ser nulo.");
       Objects.requireNonNull(tipoConta, "Tipo da Conta não pode ser nula.");
   }

    @Override
    public String toString() {
        return "{" +
                "ag='" + ag + '\'' +
                ", conta='" + conta + '\'' +
                ", codigoBanco='" + codigoBanco + '\'' +
                ", tipoConta=" + tipoConta +
                '}';
    }
}
