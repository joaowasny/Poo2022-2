package projeto.ufpb.dcx;

import java.io.IOException;
import java.util.*;
public class CarroSistema implements CarroInterface {

    private Map<String, Carro> carros;
    private List<Carro> carrosGr;
    private GravarCarros gravador = new GravarCarros();

    public CarroSistema() {
        this.carros = new HashMap<>();
        try {
            this.carrosGr = gravador.leCarros();
            for (Carro carro : carrosGr) {
                this.carros.put(carro.getNumeroCrv(), carro);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            this.carrosGr = new ArrayList<>();
        }
    }

    @Override
    public boolean cadastraCarro(String marca, String numeroCrv, String modelo, float precoFixo) {
        if (!carros.containsKey(numeroCrv)) {
            Carro novoCarro = new Carro(marca, numeroCrv, modelo, precoFixo);
            this.carros.put(numeroCrv, novoCarro);
            this.carrosGr.add(novoCarro);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<Carro> pesquisaCarro(String numeroCrv) {
        Collection<Carro> carrosEncontrados = new ArrayList<>();
        for (Carro carro : carros.values()) {
            if (carro.getNumeroCrv().equals(numeroCrv)) {
                carrosEncontrados.add(carro);
            }
        }
        return carrosEncontrados;
    }

    @Override
    public boolean removeCarro(String numeroCrv) {
        Carro carroRemovido = null;
        for (Carro carro : carros.values()) {
            if (carro.getNumeroCrv().equals(numeroCrv)) {
                carroRemovido = carro;
                break;
            }
        }
        if (carroRemovido != null) {
            carros.remove(carroRemovido.getNumeroCrv());
            carrosGr.remove(carroRemovido);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void sairDoSistema() {
        try {
            gravador.gravaCarro(this.carrosGr);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void atualizarCarros(List<Carro> carros) {
        this.carrosGr = carros;
        this.carros.clear();
        for (Carro carro : carros) {
            this.carros.put(carro.getNumeroCrv(), carro);
        }
    }
}
