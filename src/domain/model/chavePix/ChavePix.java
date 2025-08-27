package domain.model.chavePix;

import domain.model.dadosBancarios.DadosBancarios;

public class ChavePix {
    private final TipoChave tipo;
    private final DadosBancarios dadosBancarios;
    private final ChaveValor valor;

    public ChavePix(TipoChave tipo, DadosBancarios dadosBancarios, ChaveValor valor) {
        this.tipo = tipo;
        this.dadosBancarios = dadosBancarios;
        this.valor = valor;
    }

    public ChaveValor getValor() {
        return valor;
    }

    public TipoChave getTipo() {
        return tipo;
    }
}
