package model.property;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class Movimentacao {

    private IntegerProperty idMovimentacao;
    private ObjectProperty<LocalDate> data;
    private DoubleProperty valor;
    private StringProperty descricao;
    private StringProperty paraOfuturo;
    private ObjectProperty<TipoDeMovimentacao> tipo;
    private ObjectProperty<Categoria> categoria;

    public Movimentacao() {
        this.idMovimentacao = new SimpleIntegerProperty();
        this.data = new SimpleObjectProperty<LocalDate>();
        this.valor = new SimpleDoubleProperty();
        this.descricao = new SimpleStringProperty();
        this.paraOfuturo = new SimpleStringProperty();
        this.tipo = new SimpleObjectProperty<TipoDeMovimentacao>();
        this.categoria = new SimpleObjectProperty<Categoria>();
    }

    public Movimentacao(int idMovimentacao, LocalDate data, double valor, String descricao, String pago, TipoDeMovimentacao tipo, Categoria categoria) {
        this.idMovimentacao = new SimpleIntegerProperty();
        this.data = new SimpleObjectProperty<LocalDate>(data);
        this.valor = new SimpleDoubleProperty(valor);
        this.descricao = new SimpleStringProperty(descricao);
        this.paraOfuturo = new SimpleStringProperty(pago);
        this.tipo = new SimpleObjectProperty<TipoDeMovimentacao>(tipo);
        this.categoria = new SimpleObjectProperty<Categoria>(categoria);
    }

    public int getIdMovimentacao() {
        return idMovimentacao.get();
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao.set(idMovimentacao);
    }

    public IntegerProperty getIdMovimentacaoProperty() {
        return idMovimentacao;
    }

    public LocalDate getData() {
        return data.get();
    }

    public void setData(LocalDate data) {
        this.data.set(data);
    }

    public ObjectProperty<LocalDate> getDataProperty() {
        return data;
    }

    public double getValor() {
        return valor.get();
    }

    public void setValor(double valor) {
        this.valor.set(valor);
    }
    
      public DoubleProperty valorProperty() {
        return valor;
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }
    Fz\
    public char getParaOfuturo() {
        return paraOfuturo;
    }

    public void setParaOfuturo(char paraOfuturo) {
        this.paraOfuturo = paraOfuturo;
    }

//
//    public double getValor() {
//        return valor.get();
//    }
//
//    public void setValor(double valor) {
//        this.valor.set(valor);
//    }
//
//    public DoubleProperty valorProperty() {
//        return valor;
//    }
//
//    public String getDescricao() {
//        return descricao.get();
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao.set(descricao);
//    }
//
//    public StringProperty descricaoProperty() {
//        return descricao;
//    }
//
//    public char getPago() {
//        return pago;
//    }
//
//    public void setPago(char pago) {
//        this.pago = pago;
//    }
//
//    public ObjectProperty<TipoDeMovimentacao> getTipoProperty() {
//        return tipo;
//    }
//
//    public void setTipo(TipoDeMovimentacao tipo) {
//        this.tipo.set(tipo);
//    }
//    
//    public TipoDeMovimentacao getTipo(){
//        return tipo.get();
//    }
//
//    public ObjectProperty<Categoria> getCategoriaProperty() {
//        return categoria;
//    }
//
//    public void setCategoria(Categoria categoria) {
//        this.categoria.set(categoria);
//    }
//    
//    public Categoria getCategoria(){
//        return categoria.get();
//    }
    public TipoDeMovimentacao getTipoBD() {
        return tipoBD;
    }

    public void setTipoBD(TipoDeMovimentacao tipoBD) {
        this.tipoBD = tipoBD;
    }

    public Categoria getCategoriaBD() {
        return categoriaBD;
    }

    public void setCategoriaBD(Categoria categoriaBD) {
        this.categoriaBD = categoriaBD;
    }

    public void exibeTodasMovimentacoes() {
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdMovimentacao());
        System.out.println("Data = " + getData());
        System.out.println("Descrição = " + getDescricao());
        System.out.println("Valor = R$ " + getValor());
        System.out.println("Tipo = " + getTipoBD().getDescricaoBD());
        System.out.println("Categoria = " + getCategoriaBD().getDescricaoBD());
    }

    public String exibeTipoDeMovimentacao() {
        return getTipoBD().getDescricaoBD();
    }

    public String exibeValorDaMovimentacao() {
        return "R$ " + String.valueOf(getValor());
    }
}
