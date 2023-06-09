package projeto.ufpb.dcx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CarroSwingMenu extends JFrame {
    JButton btnCadastrar, btnPesquisar, btnRemover, btnAlugel;
    ImageIcon adicionar = new ImageIcon("C:\\Users\\wasny\\ProjetosAyla\\ProjetosAyla\\imgs\\adicionar.png");
    ImageIcon pesquisar = new ImageIcon("C:\\Users\\wasny\\ProjetosAyla\\ProjetosAyla\\imgs\\lupa.png");
    ImageIcon remover = new ImageIcon("C:\\Users\\wasny\\ProjetosAyla\\ProjetosAyla\\imgs\\remover.png");
    ImageIcon aluguel = new ImageIcon("C:\\Users\\wasny\\ProjetosAyla\\ProjetosAyla\\imgs\\chaves.png");
    CarroInterface sistema = new CarroSistema();
    ImageIcon imagemFundo = new ImageIcon("C:\\Users\\wasny\\ProjetosAyla\\ProjetosAyla\\imgs\\R12.png");
    class PainelComImagem extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagemFundo.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public CarroSwingMenu() {
        ImageIcon img = new ImageIcon("C:\\Users\\wasny\\ProjetosAyla\\ProjetosAyla\\imgs\\pneu.png");

        setIconImage(img.getImage());
        setTitle("CARRINHOS JJ");
        setFont(new Font("Arial", Font.BOLD, 20));
        setSize(600, 400);

        btnCadastrar = new JButton("Cadastrar", adicionar);
        btnCadastrar.addActionListener(new CarroAddController(sistema, this));
        btnPesquisar = new JButton("Pesquisar", pesquisar);
        btnPesquisar.addActionListener(new CarroSearchController(sistema, this));
        btnRemover = new JButton("Remover", remover);
        btnRemover.addActionListener(new CarroRemoveController(sistema, this));
        btnAlugel = new JButton("Aluguel", aluguel);
        btnAlugel.addActionListener(new CarroAluguelController(sistema, this));

        JPanel btnPanel = new JPanel();
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        btnPanel.setBackground(Color.gray);
        btnPanel.add(btnCadastrar);
        btnPanel.add(btnPesquisar);
        btnPanel.add(btnRemover);
        btnPanel.add(btnAlugel);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
        getContentPane().add(new PainelComImagem());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sistema.sairDoSistema(); // Salvar os dados ao fechar a janela
                System.exit(0); // Terminar a execução do programa
            }
        });
    }

    public static void main(String[] args) {
        CarroSwingMenu janela = new CarroSwingMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
