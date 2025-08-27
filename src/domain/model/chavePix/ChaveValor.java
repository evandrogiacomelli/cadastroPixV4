package domain.model.chavePix;

import java.util.UUID;

public class ChaveValor {
    private final String valor;

    public ChaveValor(String valor, TipoChave tipoChave) {
        if (tipoChave == TipoChave.ALEATORIO) this.valor = UUID.randomUUID().toString();
        else this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return "ChaveValor{" +
                "valor='" + valor + '\'' +
                '}';
    }
}
