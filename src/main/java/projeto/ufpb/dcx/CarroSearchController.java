package projeto.ufpb.dcx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class CarroSearchController implements ActionListener {

    private CarroInterface sistema;
    private JFrame janelaPrincipal;

    public CarroSearchController(CarroInterface sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numeroCrv = JOptionPane.showInputDialog(janelaPrincipal, "Qual o número do CRV: ");
        Collection<Carro> ListaCarros = sistema.pesquisaCarro(numeroCrv);
        if (ListaCarros.size() > 0) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Carro encontrado.");
            for (Carro c : ListaCarros) {
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Carro não encontrado.");
        }
    }
}
