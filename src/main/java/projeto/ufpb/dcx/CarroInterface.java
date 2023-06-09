package projeto.ufpb.dcx;

import java.util.Collection;
import java.util.List;

public interface CarroInterface {
    boolean cadastraCarro(String marca, String numeroCrv, String modelo, float precoFixo);
    Collection<Carro> pesquisaCarro(String numeroCrv);
    boolean removeCarro(String numeroCrv);

    void sairDoSistema();
    void atualizarCarros(List<Carro> carros);

}


