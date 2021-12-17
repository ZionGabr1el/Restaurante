package restaurante;

public class Pedido {
    /// CARACTERISTICAS ///
    private Produto produto;
    private int quantidade = 0;

    /// CONSTRUTORES ///
    public Pedido(Produto p, int quantidade) {
        this.quantidade = quantidade;
        this.produto = p;
    }

    public Pedido() {
    }

    /// METODOS GET ///
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return produto.getPresso() * quantidade;
    }

    /// METODOS SET ///
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /// OUTROS METODOS ///
    @Override
    public String toString() {
        return "-------------------------------------------------------------\n"
                + quantidade + "x |  " + produto.getNome() + " | R$ " + produto.getPresso() + "\n    (" + produto.getDescricao() + ")";
    }
}