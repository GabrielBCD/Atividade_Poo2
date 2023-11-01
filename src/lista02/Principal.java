package lista02;

import javax.swing.*;

public class Principal {

    private JButton sairButton;
    private JPanel panel1;

    public Principal() {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(panel1);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);

        sairButton.addActionListener(e->{
            new Login();
            frame.dispose();
        });
    }


}
