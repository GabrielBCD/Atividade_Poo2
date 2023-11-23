package lista02.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProjetoDB {
    static final String url = "jdbc:mysql://localhost:3306/poo2_lista2";
    static final String user = "root";
    static final String pass = "";
    static ProjetoDB instance;
    private Connection con;

    public static ProjetoDB getInstance() {
        if (instance == null) {
            instance = new ProjetoDB();
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }

    private ProjetoDB() {
        try {
            this.con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("n foi");
            e.printStackTrace();
        }
    }

    public void addProjeto(){

    }

}
