package lista02.view;

import lista02.model.Banco;

import javax.swing.*;

public class Login {
    private JPanel panel1;
    private JTextField tf_user;
    private JPasswordField tf_pass;
    private JButton entrarButton;
    private JButton limparButton;
    private JButton btn_register;

    public Login() {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(panel1);
        frame.setResizable(false);
        frame.setSize(640, 480);
        frame.setLocation(650, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btn_register.addActionListener(e -> {
            new Cadastro();
            frame.dispose();
        });

        entrarButton.addActionListener(e ->{
            Banco db = Banco.getInstance();

            if (db.autentic(tf_user.getText(), new String (tf_pass.getPassword()))){
                new Principal(tf_user.getText());
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais Inválidas");
            }
        });

        limparButton.addActionListener(e ->{
            tf_user.setText(null);
            tf_pass.setText(null);
        });
    }


}
