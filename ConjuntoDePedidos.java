package restaurante;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConjuntoDePedidos {
    
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private Date data;

    public String getData() {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        return dataFormatada.format(this.data);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getValorTotal() {
        float total = 0;
        
        for (Pedido pedido : pedidos) {
            total += pedido.getSubtotal();
        }
        
        return total;
    }
    public String impressao() {
        String resposta ="";
        for (Pedido pedido : pedidos) {
            resposta += " Produto: "+pedido.getProduto() +" Quantidade: "+pedido.getQuantidade() + "\n";
        }
        
        return resposta;
    }
}