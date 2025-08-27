package infrastructure.repository;

import domain.model.chavePix.ChavePix;
import domain.model.chavePix.ChaveValor;
import domain.model.chavePix.TipoChave;
import domain.model.validador.ChavePixRepository;
import infrastructure.util.ArquivoLocalOperacoes;

import java.io.IOException;
import java.util.List;

public class ArquivoLocalRepository implements ChavePixRepository {

    private ArquivoLocalOperacoes util;

    public ArquivoLocalRepository(String diretorio) throws IOException {
        this.util = new ArquivoLocalOperacoes(diretorio, ".chaves.txt");
    }

    @Override
    public void save(ChavePix chavePix) {
        util.escreverLinhas(chavePix);
    }

    @Override
    public void delete(ChavePix chavePix) {

    }

    @Override
    public String find(String valor) {
        return util.buscarLinhaPorValor(valor);
    }
}
