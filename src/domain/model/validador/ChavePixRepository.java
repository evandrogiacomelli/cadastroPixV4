package domain.model.validador;

import domain.model.chavePix.ChavePix;
import domain.model.chavePix.ChaveValor;
import domain.model.chavePix.TipoChave;

public interface ChavePixRepository {
    void save(ChavePix chavePix);
    void delete(ChavePix chavePix);
    String find(String valor);
}
