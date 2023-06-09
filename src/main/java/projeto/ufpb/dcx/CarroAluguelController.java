package projeto.ufpb.dcx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class CarroAluguelController implements ActionListener {

    private CarroInterface sistema;
    private JFrame janelaPrincipal;

    public CarroAluguelController(CarroInterface sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String numeroCrv = JOptionPane.showInputDialog("Digite o CRV do carro: ");
        Collection<Carro> ListaCarros = sistema.pesquisaCarro(numeroCrv);
        if(ListaCarros.size()>0) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Carro encontrado.");
            for(Carro c:ListaCarros) {
                JOptionPane.showMessageDialog(janelaPrincipal,c.toString());
                JOptionPane.showMessageDialog(janelaPrincipal, "O preço da diaria deste carro é de "+c.getPrecoFixo());
                int quantoDiaria = Integer.parseInt(JOptionPane.showInputDialog("Deseja alugar o carro por quantos dias?"));
                JOptionPane.showMessageDialog(janelaPrincipal, "O valor total a pagar é: "+c.getPrecoFixo()*quantoDiaria);
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Carro não enconrtado.");
        }
    }
}
