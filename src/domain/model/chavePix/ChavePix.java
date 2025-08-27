package domain.model.chavePix;

import domain.model.dadosBancarios.DadosBancarios;

import java.sql.Timestamp;

public class ChavePix {
    private final TipoChave tipo;
    private final DadosBancarios dadosBancarios;
    private final ChaveValor valor;
    private final Timestamp timeStamp;

    public ChavePix(TipoChave tipo, DadosBancarios dadosBancarios, ChaveValor valor, Timestamp timeStamp) {
        this.tipo = tipo;
        this.dadosBancarios = dadosBancarios;
        this.valor = valor;
        this.timeStamp = timeStamp;
    }

    public ChaveValor getValor() {
        return valor;
    }

    public TipoChave getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "ChavePix{" +
                "tipo='" + tipo +
                "', dadosBancarios=" + dadosBancarios.toString() +
                ", valor='" + valor.getValor() +
                "', timeStamp='" + timeStamp +
                "'}";
    }
}
