package model;

public abstract class MaterialFerramenta {
    private String nome;
    private String tipo;
    private double valorUnitario;
    private double qtdEstoque;
    private String unidade;

    public MaterialFerramenta(){}

    public MaterialFerramenta( String nome, String tipo, double valorUnitario, double qtdEstoque, String unidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.valorUnitario = valorUnitario;
        this.qtdEstoque = qtdEstoque;
        this.unidade = unidade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
