package projeto.ufpb.dcx;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class SistemaCarroTest {

    @Test
    public void testCarroSistema() {
        CarroInterface sistema = new CarroSistema();

        // Cadastrar carros
        boolean cadastrouCarro1 = sistema.cadastraCarro("Ferrari", "321", "Fiesta", 100.0f);
        boolean cadastrouCarro2 = sistema.cadastraCarro("Chevrolet", "654", "Onix", 150.0f);
        boolean cadastrouCarro3 = sistema.cadastraCarro("Volkswagen", "402", "Golf", 200.0f);

        Assert.assertTrue(cadastrouCarro1);
        Assert.assertTrue(cadastrouCarro2);
        Assert.assertTrue(cadastrouCarro3);

        // Pesquisar carros
        String numeroCrv1 = "321";
        String numeroCrv2 = "654";
        String numeroCrv3 = "999"; // Carro inexistente

        Collection<Carro> carrosEncontrados1 = sistema.pesquisaCarro(numeroCrv1);
        Collection<Carro> carrosEncontrados2 = sistema.pesquisaCarro(numeroCrv2);
        Collection<Carro> carrosEncontrados3 = sistema.pesquisaCarro(numeroCrv3);

        Assert.assertEquals(1, carrosEncontrados1.size());
        Assert.assertEquals(1, carrosEncontrados2.size());
        Assert.assertTrue(carrosEncontrados3.isEmpty());

        // Remover carros
        String CRV1 = "321";
        String CRV2 = "654";
        String CRV3 = "402";
        String CRV4 = "999"; // Carro inexistente

        boolean removeuCarro1 = sistema.removeCarro(CRV1);
        boolean removeuCarro2 = sistema.removeCarro(CRV2);
        boolean removeuCarro3 = sistema.removeCarro(CRV3);
        boolean removeuCarro4 = sistema.removeCarro(CRV4);

        Assert.assertTrue(removeuCarro1);
        Assert.assertTrue(removeuCarro2);
        Assert.assertTrue(removeuCarro3);
        Assert.assertFalse(removeuCarro4); // Carro inexistente

        // Verificar que os carros foram removidos
        Collection<Carro> carrosEncontrados1Novamente = sistema.pesquisaCarro(numeroCrv1);
        Collection<Carro> carrosEncontrados2Novamente = sistema.pesquisaCarro(numeroCrv2);

        Assert.assertTrue(carrosEncontrados1Novamente.isEmpty());
        Assert.assertTrue(carrosEncontrados2Novamente.isEmpty());

        // Encerrar o sistema
        sistema.sairDoSistema();
    }
}