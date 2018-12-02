package model;

import java.time.LocalDate;

/**
 *
 * @author Mirandinha
 */
public class Movimentacao {
    
    private int idMovimentacao;
    private LocalDate data;
    private double valor;
    private String descricao;
    private boolean paraOfuturo;
    private TipoDeMovimentacao tipo;
    private Categoria categoria;

    public Movimentacao(TipoDeMovimentacao tipo, Categoria categoria, LocalDate data, double valor, String descricao, boolean pago) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.paraOfuturo = pago;
    }

    public Movimentacao(int idMovimentacao, TipoDeMovimentacao tipo, Categoria categoria, LocalDate data, double valor, String descricao, boolean pago) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.paraOfuturo = pago;
    }

    public Movimentacao() {
        super();
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getParaOfuturo() {
        return paraOfuturo;
    }

    public void setParaOfuturo(boolean paraOfuturo) {
        this.paraOfuturo = paraOfuturo;
    }

    public TipoDeMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeMovimentacao tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    public void exibeTodasMovimentacoes() {
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdMovimentacao());
        System.out.println("Data = " + getData());
        System.out.println("Descrição = " + getDescricao());
        System.out.println("Valor = R$ " + getValor());
        System.out.println("Tipo = " + getTipo().getDescricao());
        System.out.println("ID Tipo = " + getTipo().getIdTipoMovimentacao());
        System.out.println("Categoria = " + getCategoria().getDescricao());
        System.out.println("ID Categoria = " + getCategoria().getIdCategoria());
        System.out.println("Status da operação = " + getParaOfuturo());
    }

    public String exibeTipoDeMovimentacao() {
        return getTipo().getDescricao();
    }

    public String exibeValorDaMovimentacao() {
        return "R$ " + String.valueOf(getValor());
    }
}

