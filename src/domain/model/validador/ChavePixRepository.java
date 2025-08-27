package domain.model.validador;

import domain.model.chavePix.ChavePix;
import domain.model.chavePix.ChaveValor;
import domain.model.chavePix.TipoChave;

public interface ChavePixRepository {
    void save(ChavePix chavePix);
    void delete(String valor);
    String find(String valor);
}
