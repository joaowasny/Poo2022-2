package projeto.ufpb.dcx;

import java.io.*;
import java.util.List;
public class GravarCarros {

    private final String pasta = "Dados";
    private final String nomeArquivo = "DadosDosCarros.dat";
    private final String caminhoArquivo;

    public GravarCarros() {
        String diretorioAtual = System.getProperty("user.dir");
        this.caminhoArquivo = diretorioAtual + File.separator + pasta + File.separator + nomeArquivo;
        criarDiretorioSeNaoExistir();
    }

    public void gravaCarro(List<Carro> carros) throws IOException {
        try (ObjectOutputStream gravarCarros = new ObjectOutputStream(new FileOutputStream(this.caminhoArquivo))) {
            gravarCarros.writeObject(carros);
        }
    }

    public List<Carro> leCarros() throws IOException {
        try (ObjectInputStream lerCarros = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            List<Carro> carros = (List<Carro>) lerCarros.readObject();
            return carros;
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    private void criarDiretorioSeNaoExistir() {
        File diretorio = new File(this.pasta);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }
    }
}
