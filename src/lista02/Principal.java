package lista02;

import javax.swing.*;

public class Principal {
    private JButton sairButton;
    private JPanel panel1;
    private JLabel txt_user;

    public Principal(String user) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(panel1);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setVisible(true);
        txt_user.setText("Usuário: " + user);

        sairButton.addActionListener(e->{
            new Login();
            frame.dispose();
        });


    }


}
