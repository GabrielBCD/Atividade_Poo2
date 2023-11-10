package lista02.view;

import lista02.model.Banco;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Cadastro {
    private JPanel panel1;
    private JTextField tf_name;
    private JTextField tf_username;
    private JPasswordField tf_pass;
    private JPasswordField tf_rpass;
    private JButton cadastrarButton;
    private JButton limparButton;
    private JButton voltarButton;

    public Cadastro() {
        JFrame frame = new JFrame("Cadastro");
        frame.setContentPane(panel1);
        frame.setResizable(false);
        frame.setSize(640, 480);
        frame.setLocation(650, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        cadastrarButton.addActionListener(e -> {
            Banco db = Banco.getInstance();

            ArrayList<String> usuario = new ArrayList<String>();
            String name = tf_name.getText();
            String username = tf_username.getText();
            String pass = new String(tf_pass.getPassword());
            String rpass = new String(tf_rpass.getPassword());

            usuario.add(name);
            usuario.add(username);
            usuario.add(pass);
            usuario.add(rpass);

            boolean valid_empty = true;
            boolean valid_pass = false;
            boolean valid_user = db.validUsername(username);
            System.out.println(valid_user);

            for (String u : usuario) {
                if (Objects.equals(u, "")) {
                    valid_empty = false;
                    break;
                }
            }

            if (Objects.equals(pass, rpass) && valid_empty) {
                valid_pass = true;
            }

            if (valid_user & valid_pass & valid_empty) {
                db.Cadastro(name, username, pass);
                tf_name.setText(null);
                tf_username.setText(null);
                tf_pass.setText(null);
                tf_rpass.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente");
                if (!valid_user) {
                    JOptionPane.showMessageDialog(null, "Nome de Usuáio já existente");
                }
                if (!valid_pass & valid_empty) {
                    JOptionPane.showMessageDialog(null, "Senhas não Correspondem");
                }
            }
        });

        limparButton.addActionListener(e -> {
            tf_name.setText(null);
            tf_username.setText(null);
            tf_pass.setText(null);
            tf_rpass.setText(null);
        });

        voltarButton.addActionListener(e -> {
            new Login();
            frame.dispose();
        });
    }
}
