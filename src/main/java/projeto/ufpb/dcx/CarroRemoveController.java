package projeto.ufpb.dcx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarroRemoveController implements ActionListener {

    private CarroInterface sistema;
    private JFrame janelaPrincipal;

    public CarroRemoveController(CarroInterface sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numeroCrv = JOptionPane.showInputDialog(janelaPrincipal,"Modelo de veiculo para remover: ");
        boolean removeu = sistema.removeCarro(numeroCrv);
        if(removeu) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Carro removido.");
        } else {
            JOptionPane.showInputDialog(janelaPrincipal,"Carro não encontrado.");
        }
    }
}
