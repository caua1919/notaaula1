package questão2;

public class Produto {
    private String codigo;
    private String nome;
    private String tamanhoOuPeso;
    private String cor;
    private double valor;
    private int quantidade;

    public Produto(String codigo, String nome, String tamanhoOuPeso, String cor, double valor, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanhoOuPeso = tamanhoOuPeso;
        this.cor = cor;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               ", Nome: " + nome +
               ", Tamanho/Peso: " + tamanhoOuPeso +
               ", Cor: " + cor +
               ", Valor: " + valor +
               ", Quantidade em Estoque: " + quantidade;
    }
}
