public class Produto {
    private int idProduto;
    private String nome;
    private int quantidade;
    private double preco;
    private String status;

    public Produto() {
    }

    public Produto(String nome, int quantidade, double preco, String status) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.status = status;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
