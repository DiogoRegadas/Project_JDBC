import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Aqui você pode testar a classe ProdutoDAO
        try (Connection conexao = ConexaoDB.conectar()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
            
            /*  Criar um novo produto
            Produto novoProduto = new Produto("Camiseta", 10, 29.99, "Disponível");
            produtoDAO.inserirProduto(novoProduto);
            Produto outroProduto = new Produto("Calça Jeans", 5, 79.99, "Disponível");
            produtoDAO.inserirProduto(outroProduto);
                */
            
            // Listar todos os produtos
            mostrarProdutos(produtoDAO);

            /* 
            //ATUALIZAR
            Produto produtoAtualizado = new Produto("Calções", 15, 39.99, "Disponível");
            produtoAtualizado.setIdProduto(16);
            produtoDAO.atualizarProduto(produtoAtualizado);
            */
            // Remover todos os produtos
            //produtoDAO.removerTodosProdutos();
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void mostrarProdutos(ProdutoDAO produtoDAO) {
        List<Produto> produtos = produtoDAO.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getIdProduto() +
                               ", Nome: " + produto.getNome() +
                               ", Quantidade: " + produto.getQuantidade() +
                               ", Preço: " + produto.getPreco() +
                               ", Status: " + produto.getStatus());
        }
    }

}
