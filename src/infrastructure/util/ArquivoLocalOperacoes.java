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

    private static final String SEPARADOR = ";";
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

    public String buscarLinhaPorValor(String valorBuscado) {
        try {
            return Files.lines(arquivo)                      // stream lazy, eficiente
                    .filter(linha -> linha.split(SEPARADOR)[5].equals(valorBuscado))
                    .findFirst()
                    .orElse(null);                       // retorna null se não encontrou
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível ler o arquivo", e);
        }
    }

    public void escreverLinhas(ChavePix chavePix) {
        String linha = String.join(SEPARADOR,
                chavePix.getTipo().toString(),
                chavePix.getDadosBancarios().ag(),
                chavePix.getDadosBancarios().conta(),
                chavePix.getDadosBancarios().codigoBanco(),
                chavePix.getDadosBancarios().tipoConta().toString(),
                chavePix.getValor().getValor(),
                chavePix.getTimeStamp().toString()
        ) + System.lineSeparator();

        try {
            Files.write(arquivo, linha.getBytes(), StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível escrever no arquivo. ");
        }
    }


}
