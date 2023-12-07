package lista02.view;

import lista02.controller.Controller;
import lista02.model.Projeto;
import lista02.model.ProjetoDB;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Projetos {
    int id_selecionado;
    public boolean ativo = false;
    public boolean tipo_pesq = true;
    public String Titulo_selec;
    private JPanel panel1;
    private JTextField tf_evento;
    private JTextField tf_cpf;
    private JTextField tf_coodenador;
    private JTextField tf_campus;
    private JTextField tf_titulo;
    private JTextField tf_estudante;
    private JTextField tf_matricula;
    private JTextField tf_n_banco;
    private JTextField tf_conta_corrente;
    private JTextField tf_agencia;
    private JTextField tf_celular;
    private JTextField tf_email;
    private JList<String> jlist;
    private JButton novoButton;
    private JButton editarButton;
    private JButton excluirButton;
    private JButton limparButton;
    private JTextField tf_pesquisa;
    private JButton pesquisaButton;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JButton gerarRelatorioButton;
    private JButton limpaPesquisaButton;

    public List<JTextComponent> getCampos() {
        return List.of(tf_evento, tf_coodenador, tf_campus, tf_titulo, tf_estudante, tf_matricula, tf_cpf, tf_n_banco, tf_conta_corrente, tf_agencia, tf_celular, tf_email);
    }

    public void ativarCampos() {
        List<JTextComponent> lista = getCampos();
        lista.forEach(campo -> campo.setEnabled(true));
    }

    public void desativarCampos() {
        List<JTextComponent> lista = getCampos();
        lista.forEach(campo -> campo.setEnabled(false));
    }

    public void Limpar() {
        List<JTextComponent> lista = getCampos();
        lista.forEach(campo -> campo.setText(null));
    }

    public void atualizaJlist(List<String> projetos) {
        DefaultListModel<String> tituloN = new DefaultListModel<>();
        for (String x : projetos) {
            tituloN.addElement(x);
        }
        jlist.setModel(tituloN);
    }

    public List<String> obterValoresDaJList() {
        ListModel<String> model = jlist.getModel();
        int size = model.getSize();
        List<String> titulos = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String valor = model.getElementAt(i);
            titulos.add(valor);
        }

        return titulos;
    }

    public Projetos() {
        JFrame frame = new JFrame("Projetos");
        frame.setContentPane(panel1);
        frame.setResizable(false);
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setVisible(true);
        Controller controller = new Controller();
        ProjetoDB projetoDB = new ProjetoDB();

        atualizaJlist(projetoDB.getTitulosProjetos());

        novoButton.addActionListener(e -> {
            ativarCampos();
            Limpar();
            id_selecionado = 0;
        });

        editarButton.addActionListener(e -> {
            String projetoSelecionado = jlist.getSelectedValue();
            System.out.println(jlist.getSelectedValue());
            if (projetoSelecionado == null) {
                JOptionPane.showMessageDialog(null, "Não é possivel editar sem selecionar\num projeto");
            } else {
                Projeto p = projetoDB.getProjeto(projetoSelecionado);
                ativarCampos();

                tf_evento.setText(p.getEvento());
                tf_coodenador.setText(p.getCoordenador());
                tf_campus.setText(p.getCampus());
                tf_titulo.setText(p.getTitulo());
                tf_estudante.setText(p.getEstudante());
                tf_matricula.setText(p.getN_matricula());
                tf_cpf.setText(p.getCpf());
                tf_n_banco.setText(p.getN_banco());
                tf_conta_corrente.setText(p.getConta_corrente());
                tf_agencia.setText(p.getTitulo());
                tf_celular.setText(p.getCelular());
                tf_email.setText(p.getMail());

                id_selecionado = projetoDB.getProjeto(tf_titulo.getText()).getId();
            }
        });

        excluirButton.addActionListener(e -> {
            int opt = JOptionPane.showConfirmDialog(null, "Deseja Excluir o Projeto?");
            if (opt == JOptionPane.YES_NO_OPTION) {
                String projetoSelecionado = jlist.getSelectedValue();
                id_selecionado = projetoDB.getProjeto(projetoSelecionado).getId();
                projetoDB.deletarProjeto(id_selecionado);
                id_selecionado = 0;
                atualizaJlist(projetoDB.getTitulosProjetos());
            } else {
                JOptionPane.showMessageDialog(null, "Projeto não foi excluido");
            }
        });

        limparButton.addActionListener(e -> {
            Limpar();
        });

        salvarButton.addActionListener(e -> {
            if (!controller.statusCamposProjetos(tf_evento.getText(), tf_coodenador.getText(), tf_campus.getText(), tf_titulo.getText(),
                    tf_estudante.getText(), tf_matricula.getText(), tf_cpf.getText(), tf_n_banco.getText(), tf_conta_corrente.getText(),
                    tf_agencia.getText(), tf_celular.getText(), tf_email.getText())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");

            } else {
                boolean editar = false;
                if (projetoDB.vericarId(id_selecionado)) {
                    editar = true;
                }

                if (editar) {
                    //editar
                    Projeto edit = new Projeto(tf_evento.getText(), tf_coodenador.getText(), tf_campus.getText(), tf_titulo.getText(),
                            tf_estudante.getText(), tf_matricula.getText(), tf_cpf.getText(), tf_n_banco.getText(), tf_conta_corrente.getText(),
                            tf_agencia.getText(), tf_celular.getText(), tf_email.getText());
                    projetoDB.atualizarProjeto(edit, id_selecionado);
                    desativarCampos();

                } else {
                    //novo
                    projetoDB.addProjeto(tf_evento.getText(), tf_coodenador.getText(), tf_campus.getText(), tf_titulo.getText(),
                            tf_estudante.getText(), tf_matricula.getText(), tf_cpf.getText(), tf_n_banco.getText(), tf_conta_corrente.getText(),
                            tf_agencia.getText(), tf_celular.getText(), tf_email.getText());
                    desativarCampos();
                }
                Limpar();
                id_selecionado = 0;
            }

            atualizaJlist(projetoDB.getTitulosProjetos());

        });

        cancelarButton.addActionListener(e -> {
            Limpar();
            desativarCampos();
            id_selecionado = 0;
        });

        pesquisaButton.addActionListener(e -> {
            if (Objects.equals(tf_pesquisa.getText(), "")) {
                JOptionPane.showMessageDialog(null, "Nenhuma Pesquisa foi feita.");
            } else {
                atualizaJlist(projetoDB.getTitulosProjetosPesquisa(tf_pesquisa.getText()));
                Titulo_selec =tf_pesquisa.getText();
                tipo_pesq = false;
            }

        });

        limpaPesquisaButton.addActionListener(e -> {
            atualizaJlist(projetoDB.getTitulosProjetos());
            Titulo_selec = null;
            tipo_pesq = true;
            tf_pesquisa.setText(null);
        });

        gerarRelatorioButton.addActionListener(e -> {
            projetoDB.gerarPDF(obterValoresDaJList(), tipo_pesq, Titulo_selec);
        });
    }
}
