import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CriarTabela {
    public static void main(String[] args) {
        try (Connection conn = ConexaoDB.conectar();
             Statement stmt = conn.createStatement()) {
            String comandoSql = "CREATE TABLE IF NOT EXISTS produtos (" +
                         "id_produto INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "nome TEXT NOT NULL," +
                         "quantidade INTEGER," +
                         "preco REAL," +
                         "status TEXT" +
                         ");";

            stmt.execute(comandoSql);
            System.out.println("Tabela 'produtos' criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
