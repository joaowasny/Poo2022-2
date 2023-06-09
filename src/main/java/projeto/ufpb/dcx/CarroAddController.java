package projeto.ufpb.dcx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarroAddController implements ActionListener {

    private CarroInterface sistema;
    private JFrame janelaPrincipal;

    public CarroAddController( CarroInterface sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String marca = JOptionPane.showInputDialog(janelaPrincipal,"Marca do carro: ");
        String numeroCrv = JOptionPane.showInputDialog(janelaPrincipal,"Número CRV: ");
        String modelo = JOptionPane.showInputDialog(janelaPrincipal,"Modelo do carro: ");
        float precoFixo = Float.parseFloat(JOptionPane.showInputDialog(janelaPrincipal,"Preço do carro: "));

        boolean adicionado = sistema.cadastraCarro(marca,numeroCrv,modelo,precoFixo);
        if(adicionado) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Carro cadastrado: ");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,"Não foi possivel cadastrar o veiculo");
        }
    }
}
