package lista02.view;

import lista02.model.Banco;

import javax.swing.*;

public class Principal {
    private JButton sairButton;
    private JPanel panel1;
    private JLabel txt_user;
    private JMenuItem Cadastrar;
    String name;

    public Principal(String user) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(panel1);
        frame.setResizable(false);
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setVisible(true);

        Banco db = Banco.getInstance();
        txt_user.setText("Usuário: " + db.user_name(user));



        sairButton.addActionListener(e->{
            new Login();
            frame.dispose();
        });

        Cadastrar.addActionListener((e->{
            new Projetos();
            frame.dispose();
        }));


    }


}
