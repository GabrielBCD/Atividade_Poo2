package lista02;

import javax.swing.*;

public class Login {

    private JPanel panel1;
    private JTextField tf_user;
    private JTextField tf_pass;
    private JButton entrarButton;
    private JButton limparButton;
    private JButton btn_register;

    public Login() {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(panel1);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        btn_register.addActionListener(e -> {
            new Cadastro();
            frame.dispose();
        });

        entrarButton.addActionListener(e ->{
            Banco db = Banco.getInstance();

            if (db.autentic(tf_user.getText(), tf_pass.getText())){
                new Principal();
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
