package restaurante;

public class MensagensPadrao {
    public static void bye(){
        System.out.println("Adeus.");
    }

    public static void erro(String mensagem){
        if(mensagem == ""){
            System.out.println("Algo deu errado, tente novamente!");
        }
        else{
            System.out.println(mensagem);
        }
    }

    public static void erroLista(){
        System.out.println("Sua lista de pedidos está vazia.");
    }

    public static void notice(String mensagem){
        System.out.println(mensagem);
    }
}