package restaurante;

public class Funcionario {
    /// Iriamos usar essa classe, porém com o desenvolvimento do programa não achamos necessário. ///
    /// CARACTERISTICAS ///
    private double salario;
    private String nome;
    private String sexo;
    private int idade;

    /// CONSTRUTORES ///
    public Funcionario(String nome, int idade, String sexo) {
        this.salario = 0;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Funcionario(double salario, String nome, int idade, String sexo) {
        this.salario = salario;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    /// METODOS SET ///
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /// METODOS GET ///
    public double getSalario() {
        return salario;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getSexo() {
        return this.sexo;
    }

    /// OUTROS METODOS ///
    @Override
    public String toString() {
        return "Nome: " + nome + "\nSexo: " + sexo + "\nIdade: " + idade + "\nSalario: " + salario;
    }
}