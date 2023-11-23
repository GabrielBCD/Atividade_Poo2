package lista02.view;

import javax.swing.*;

public class Projetos {

    public boolean ativo = false;
    private JPanel panel1;
    private JTextField tf_evento;
    private JTextField textField2;
    private JTextField tf_coodenador;
    private JTextField tf_campus;
    private JTextField tf_titulo;
    private JTextField tf_estudante;
    private JTextField tf_matricula;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JList list1;
    private JButton novoButton;
    private JButton editarButton;
    private JButton excluirButton;
    private JButton limparButton;
    private JTextField textField13;
    private JButton pesquisaButton;
    private JButton salvarButton;
    private JButton cancelarButton;

    public Projetos() {
        JFrame frame = new JFrame("Projetos");
        frame.setContentPane(panel1);
        frame.setResizable(false);
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setVisible(true);

        novoButton.addActionListener(e -> {

        });
        editarButton.addActionListener(e -> {

        });
        excluirButton.addActionListener(e -> {

        });
        limparButton.addActionListener(e -> {

        });
        salvarButton.addActionListener(e -> {

        });
        cancelarButton.addActionListener(e -> {

        });

    }
}
