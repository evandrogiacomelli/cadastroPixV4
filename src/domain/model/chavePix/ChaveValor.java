package domain.model.chavePix;

import java.sql.Time;
import java.sql.Timestamp;

public class ChaveValor {
    private final String valor;
    private final Timestamp timeStamp;

    public ChaveValor(String valor, Timestamp timeStamp) {
        this.valor = valor;
        this.timeStamp = timeStamp;
    }

    public String getValor() {
        return this.valor;
    }
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

}
