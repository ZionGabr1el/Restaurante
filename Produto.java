package restaurante;

public class Produto {
   
    private int ID;
    private String nome;
    private double presso;
    private String descricao;

    public Produto(String nome, String descricao, double presso) {
        this.nome = nome;
        this.descricao = descricao;
        this.presso = presso;
    }

    public Produto(String nome, String descricao, double presso, int ID) {
        this.nome = nome;
        this.descricao = descricao;
        this.presso = presso;
        this.ID = ID;
    }

    /*public Produto() {

    }*/
  
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPresso() {
        return presso;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPresso(double presso) {
        this.presso = presso;
    }

    @Override
    public String toString() {
        return ID + " - " +  nome + " | R$ " + presso + "\n    (" + descricao + ")";
    }
}