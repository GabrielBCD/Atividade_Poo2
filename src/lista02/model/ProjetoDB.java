package lista02.model;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDB {

    public void addProjeto(String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9, String p10, String p11, String p12) {
        Banco db = Banco.getInstance();
        Connection connection = db.getCon();

        try {
            String sql = "INSERT INTO projetos (evento,coordenador,campus,titulo,estudante,n_matricula,cpf,n_banco,conta_corrente,agencia,celular,email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p1);
            statement.setString(2, p2);
            statement.setString(3, p3);
            statement.setString(4, p4);
            statement.setString(5, p5);
            statement.setString(6, p6);
            statement.setString(7, p7);
            statement.setString(8, p8);
            statement.setString(9, p9);
            statement.setString(10, p10);
            statement.setString(11, p11);
            statement.setString(12, p12);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Projeto Cadastrado Com Sucesso!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente");
        }
    }

    public List<String> getTitulosProjetos() {
        List<String> projetos = new ArrayList<>();
        Banco db = Banco.getInstance();
        Connection connection = db.getCon();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM projetos");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String projeto = rs.getString("titulo");
                projetos.add(projeto);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao obter projetos do banco de dados");
            e.printStackTrace();
        }
        return projetos;
    }

    public Projeto getProjeto(String t) {
        Banco db = Banco.getInstance();
        Connection connection = db.getCon();

        try {
            String sql = "SELECT * FROM projetos WHERE titulo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, t);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String evento = rs.getString("evento");
                String coordenador = rs.getString("coordenador");
                String campus = rs.getString("campus");
                String titulo = rs.getString("titulo");
                String estudante = rs.getString("estudante");
                String matricula = rs.getString("n_matricula");
                String cpf = rs.getString("cpf");
                String banco = rs.getString("n_banco");
                String contacorrente = rs.getString("conta_corrente");
                String agencia = rs.getString("agencia");
                String celular = rs.getString("celular");
                String email = rs.getString("email");

                return new Projeto(evento, coordenador, campus, titulo, estudante, matricula, cpf, banco, contacorrente, agencia, celular, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarProjeto(Projeto projeto) {
        Banco db = Banco.getInstance();
        Connection connection = db.getCon();

        try {
            String sql = "UPDATE projetos SET evento = ?, coordenador = ?, campus = ?, titulo = ?, estudante = ?, n_matricula = ?," +
                    "cpf = ?, n_banco = ?, conta_corrente = ?, agencia = ?, celular = ?, email = ? WHERE titulo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, projeto.getEvento());
            statement.setString(2, projeto.getCoordenador());
            statement.setString(3, projeto.getCampus());
            statement.setString(4, projeto.getTitulo());
            statement.setString(5, projeto.getEstudante());
            statement.setString(6, projeto.getN_matricula());
            statement.setString(7, projeto.getCpf());
            statement.setString(8, projeto.getN_banco());
            statement.setString(9, projeto.getConta_corrente());
            statement.setString(10, projeto.getAgencia());
            statement.setString(11, projeto.getCelular());
            statement.setString(12, projeto.getMail());
            statement.setString(13, projeto.getTitulo());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

