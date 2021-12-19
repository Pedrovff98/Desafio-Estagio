package Gui;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    /*
    Construtor(TelaPrincipal) inicializa com os componentes para o JFrame
     */

    TelaPrincipal() {
        setSize(250, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Cadastro");
        componentes();
        setResizable(false);
        SwingUtilities.invokeLater(() -> {
            repaint();
            validate();
        });
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }

    /*
    Método (componentes) adiciona as interfaces gráfica da primeira tela (TelaPrincipal).
     */

    void componentes() {
        JLabel layout = new JLabel("DIGITE SEU NOME:");
        layout.setBounds(50, 25, 250, 20);
        layout.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(layout);

        JTextField textField = new JTextField();
        textField.setBounds(20, 60, 200, 25);
        add(textField);

        JButton botao1 = new JButton("Cadastrar");
        botao1.setBounds(65, 100, 100, 40);
        botao1.addActionListener(x -> {
            if(textField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "Digite seu nome para o cadastro!");
            }else{
                dispose();
                new Produtos(textField.getText());
            }

        });
        add(botao1);
    }
}


