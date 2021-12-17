package restaurante;
public class Main {
    public static void main(String[] args) throws Exception {
                /// CRIANDO LOJA ///
                Loja loja = new Loja("Restaurante do Jaborandy", "Na Rua dos scripts, 0");
                Cliente carlos = new Cliente("Jaborandy", 27, "Homem");

                
                /// CRIANDO PRODUTOS ///
                loja.getCardapio().addProduto(new Produto("Água mineral", "H2O - Água importada, porque no Brasil não tem", 2.5));
                loja.getCardapio().addProduto(new Produto("Suco de frutas", "Frutas de final de feira", 4));
                loja.getCardapio().addProduto(new Produto("Refrigerante", "Produtos químicos perigosos para seu corpo com corante", 3));
                loja.getCardapio().addProduto(new Produto("SandWich", "Lanche com areia", 5));
                loja.getCardapio().addProduto(new Produto("Omelete", "Feito com ovos que talvez não sejam de galinha", 4));
                loja.getCardapio().addProduto(new Produto("Pizza de ontem", "Levemente requentada", 3));
                loja.getCardapio().addProduto(new Produto("Feijão amantegado", "MUITA MANTEIGA", 30));
                loja.getCardapio().addProduto(new Produto("HotCat", "Comida com carne de origens duvidosas", 10));
                carlos.clienteMenu(loja);

    }
}