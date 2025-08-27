package domain.model.chavePix;

import java.sql.Timestamp;

public class ChaveValor {
    private final String valor;

    public ChaveValor(String valor, Timestamp timeStamp) {
        this.valor = valor;
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
