import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {
    private static final String URL_PADRAO = "jdbc:sqlite:meu_banco";

    public static Connection conectar() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL_PADRAO);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return connection;
    }

    public static Connection conectarGenerico(String url, String usuario, String senha) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return connection;
    }

}
