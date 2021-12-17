package restaurante;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
public class Cliente extends Funcionario {

    /// CONSTRUTORES ///
    public Cliente(String nome, int idade, String sexo) {
        super(nome, idade, sexo);
    }

    /// MENU ///
    public void clienteMenu(Loja loja) {
        System.out.println();
        System.out.println("=> CLIENTE <=");
        System.out.println("1 - Fazer Pedido");
        System.out.println("2 - Voltar");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;

        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }
        switch (resposta) {
            case 1: {
                if (!loja.getCardapio().getProdutos().isEmpty()) {
                    ArrayList<Pedido> escolhidos = new ArrayList();
                    ConjuntoDePedidos novo = new ConjuntoDePedidos();

                    novo.setPedidos(escolherPedidos(loja, novo, escolhidos));

                    confirmacaoFinal(novo, loja, escolhidos);
                    clienteMenu(loja);
                } else {
                    MensagensPadrao.erro("Cardapio Vazio !");
                }

                //loja.abrirLoja(loja);

                break;
            }
            case 2: {
                //loja.abrirLoja(loja);

                break;
            }
            default: {
                MensagensPadrao.erro("");
                clienteMenu(loja);
            }
        }
    }

    /// METODOS OPTION 1 ///
    public boolean confirmarCompra(ConjuntoDePedidos novo) {
        System.out.println();
        System.out.println("=> CONCLUIR PEDIDOS <=");
        System.out.println("Pedidos:");
        System.out.println(novo.impressao());
        System.out.println("\n\n>>>>> Total a pagar: R$ " + novo.getValorTotal() + " <<<<<\n");
        System.out.println(">>>>> Deseja confirmar a compra (S/N)? <<<<<<");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        String resposta = "";

        try {
            resposta = in.next();
        } catch (Exception er0) {
        }
        switch (resposta.toUpperCase()) {
            case "S": {
                MensagensPadrao.notice("Pedido feito com sucesso! Por favor aguarde,\nlogo ele estará pronto! Volte sempre!");

                return true;
            }
            case "N": {
                MensagensPadrao.notice("Conclusão de pedido cancelado!");

                return false;
            }
            default: {
                MensagensPadrao.erro("");

                return confirmarCompra(novo);
            }
        }
    }

    public void confirmacaoFinal(ConjuntoDePedidos novo, Loja loja, ArrayList<Pedido> escolhidos) {
        if (confirmarCompra(novo)) {
            novo.setData(new Date());
            loja.getPedidosNaFila().add(novo);
        } else {
            escolherPedidos(loja, novo, escolhidos);
            confirmacaoFinal(novo, loja, escolhidos);
        }
    }

    /// MENU 2 ///
    public ArrayList<Pedido> escolherPedidos(Loja loja, ConjuntoDePedidos novo, ArrayList<Pedido> escolhidos) {
        System.out.println();
        System.out.println("=> ESCOLHER PEDIDOS <=");
        System.out.println("1 - Adicionar um pedido");
        System.out.println("2 - Remover último pedido");
        System.out.println("3 - Remover todos pedidos");
        System.out.println("4 - Ver pedidos");
        System.out.println("5 - Concluir pedido");
        System.out.println("6 - Voltar/Cancelar");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;
        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }
        
        switch (resposta) {
            case 1: {
                System.out.println();
                Produto escolhido = escolherUmProduto(loja.getCardapio());
                int quantidade = escolherQuantidade();
                escolhidos.add(new Pedido(escolhido, quantidade));
                MensagensPadrao.notice("Pedido adicionado com sucesso!");
                escolherPedidos(loja, novo, escolhidos);

                break;
            }
            case 2: {
                System.out.println();
                System.out.println("=> EXCLUIR ÚLTIMO PEDIDO <= ");

                if (!escolhidos.isEmpty()) {
                    String excluido = escolhidos.get(escolhidos.size() - 1).toString();
                    escolhidos.remove(escolhidos.size() - 1);
                    MensagensPadrao.notice("O pedido: \n" + excluido + "\nfoi excluído com sucesso!");
                } else {
                    MensagensPadrao.erroLista();
                }

                escolherPedidos(loja, novo, escolhidos);

                break;
            }
            case 3: {
                System.out.println();
                System.out.println("=> EXCLUIR TODOS PEDIDOS <=");

                if (!escolhidos.isEmpty()) {
                    escolhidos.clear();
                    MensagensPadrao.notice("Todos os pedidos foram cancelados!");
                } else {
                    MensagensPadrao.erroLista();
                }

                escolherPedidos(loja, novo, escolhidos);

                break;
            }
            case 4: {
                System.out.println();
                System.out.println("=> VER PEDIDOS <=");

                if (!escolhidos.isEmpty()) {
                    System.out.println(verPedidos(escolhidos));
                    System.out.println(">>>>> Total a pagar: R$ " + precoTotal(escolhidos) + " <<<<<");
                } else {
                    MensagensPadrao.erroLista();
                }

                escolherPedidos(loja, novo, escolhidos);

                break;
            }

            case 5: {
                if (!escolhidos.isEmpty()) {
                    return escolhidos;
                } else {
                    System.out.println();
                    System.out.println("=> CONCLUIR PEDIDO <=");
                    MensagensPadrao.erroLista();
                    escolherPedidos(loja, novo, escolhidos);
                }

                break;
            }
            case 6: {
                escolhidos.clear();
                //loja.abrirLoja(loja);

                break;
            }
            default: {
                MensagensPadrao.erro("");
                return escolherPedidos(loja, novo, escolhidos);
            }
        }
        return escolhidos;
    }
    

    /// METODO OPTION 1 ///
    public Produto escolherUmProduto(Cardapio cardapio) {
        System.out.print("=> ADICIONAR UM PEDIDO <=");
        System.out.println(cardapio.toString());
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;

        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }
        if (cardapio.procurarProduto(resposta) != null) {
            return cardapio.procurarProduto(resposta);
        } else {
            MensagensPadrao.erro("");
            return escolherUmProduto(cardapio);
        }
    }

    public int escolherQuantidade() {
        System.out.println();
        System.out.println("=> QUANTIDADE <=");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;

        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }
        if (resposta > 0) {
            return resposta;
        } else {
            MensagensPadrao.erro("");
            return escolherQuantidade();
        }
    }

    /// METODO OPTION 4 ///
    public String verPedidos(ArrayList<Pedido> escolhidos) {
        String tudo = "";

        for (Pedido produto : escolhidos) {
            tudo += produto.toString() + "\n";
        }

        return tudo;
    }

    public double precoTotal(ArrayList<Pedido> escolhidos) {
        double total = 0;

        for (Pedido pedido : escolhidos) {
            total += pedido.getSubtotal();
        }

        return total;
    }

}