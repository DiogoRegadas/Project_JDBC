import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
    private final Connection CONEXAO_DB;

    // Construtor para receber a conexão com o banco de dados
    public ProdutoDAO(Connection conexaoDb) {
        this.CONEXAO_DB = conexaoDb;
    }
    // Método para inserir um novo produto no banco de dados
    public void inserirProduto(Produto produto) {
        String sql = "INSERT INTO produtos (nome, quantidade, preco, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = CONEXAO_DB.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setString(4, produto.getStatus());
            pstmt.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    // Método para remover todos os produtos do banco de dados
    public void removerTodosProdutos() {
        String sql = "DELETE FROM produtos";
        try (PreparedStatement pstmt = CONEXAO_DB.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("Todos os produtos foram removidos com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao remover produtos: " + e.getMessage());
        }
    }   

    // Método para listar todos os produtos do banco de dados
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id_produto, nome, quantidade, preco, status FROM produtos";
        try (PreparedStatement pstmt = CONEXAO_DB.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setStatus(rs.getString("status"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos; 
    }

    //Método para consultar um produto pelo ID
    public Produto consultarProdutoPorId(int idProduto) {
        Produto produto = null;
        String sql = "SELECT id_produto, nome, quantidade, preco, status FROM produtos WHERE id_produto = ?";
        try (PreparedStatement pstmt = CONEXAO_DB.prepareStatement(sql)) {
            pstmt.setInt(1, idProduto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    produto = new Produto();
                    produto.setIdProduto(rs.getInt("id_produto"));
                    produto.setNome(rs.getString("nome"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar produto por ID: " + e.getMessage());
        }
        return produto;
    }

        // Método para atualizar um produto existente no banco de dados por ID
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, quantidade = ?, preco = ?, status = ? WHERE id_produto = ?";
        try (PreparedStatement pstmt = CONEXAO_DB.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setString(4, produto.getStatus());
            pstmt.setInt(5, produto.getIdProduto());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Nenhum produto encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

        // Método para remover um produto do banco de dados por ID
    public void removerProdutoPorId(int idProduto) {
        String sql = "DELETE FROM produtos WHERE id_produto = ?";
        try (PreparedStatement pstmt = CONEXAO_DB.prepareStatement(sql)) {
            pstmt.setInt(1, idProduto);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Nenhum produto encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover produto: " + e.getMessage());
        }
    }

}
