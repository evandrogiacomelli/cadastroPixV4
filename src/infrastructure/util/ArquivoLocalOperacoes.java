package infrastructure.util;

import domain.model.chavePix.ChavePix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ArquivoLocalOperacoes {

    private final Path arquivo;
    private final String nomeArquivo;

    public ArquivoLocalOperacoes(String diretorio, String nomeArquivo) throws IOException {
        Path pathDiretorio = Paths.get(diretorio);
        try {
            Files.createDirectories(pathDiretorio);
        } catch (IOException e) {
            throw new IOException("Erro ao criar arquivo local para armazenamento: " + e);
        }
        this.nomeArquivo = nomeArquivo;
        this.arquivo = pathDiretorio.resolve(nomeArquivo);
    }

    public List<String> lerLinhas() {
        if (!Files.exists(arquivo)) return new ArrayList<>();
        try {
            return Files.readAllLines(arquivo);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível ler o arquivo. ");
        }
    }

    public void escreverLinhas(ChavePix chavePix) {

        String linha = chavePix + System.lineSeparator();

        try {
            Files.write(arquivo, linha.getBytes(), StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível escrever no arquivo. ");
        }
    }


}
