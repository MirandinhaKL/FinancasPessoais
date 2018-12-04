package model.property;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
    private BooleanProperty paraOfuturo;
    private ObjectProperty<TipoDeMovimentacao> tipo;
    private ObjectProperty<Categoria> categoria;

    public Movimentacao() {
        this.idMovimentacao = new SimpleIntegerProperty();
        this.data = new SimpleObjectProperty<LocalDate>();
        this.valor = new SimpleDoubleProperty();
        this.descricao = new SimpleStringProperty();
        this.paraOfuturo = new SimpleBooleanProperty();
        this.tipo = new SimpleObjectProperty<TipoDeMovimentacao>();
        this.categoria = new SimpleObjectProperty<Categoria>();
    }

    public Movimentacao(int idMovimentacao, LocalDate data, double valor, String descricao, boolean pago, TipoDeMovimentacao tipo, Categoria categoria) {
        this.idMovimentacao = new SimpleIntegerProperty();
        this.data = new SimpleObjectProperty<LocalDate>(data);
        this.valor = new SimpleDoubleProperty(valor);
        this.descricao = new SimpleStringProperty(descricao);
        this.paraOfuturo = new SimpleBooleanProperty(pago);
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
    
    public DoubleProperty getValorProperty(){
        return valor;
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

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public boolean getParaOfuturo() {
        return paraOfuturo.get();
    }

    public void setParaOfuturo(boolean paraOfuturo) {
        this.paraOfuturo.set(paraOfuturo);
    }
    
    public BooleanProperty getParaOfuturoProperty(){
        return paraOfuturo;
    }

    public ObjectProperty<TipoDeMovimentacao> getTipoProperty() {
        return tipo;
    }

    public void setTipo(TipoDeMovimentacao tipo) {
        this.tipo.set(tipo);
    }
    
    public TipoDeMovimentacao getTipo(){
        return tipo.get();
    }

    public ObjectProperty<Categoria> getCategoriaProperty() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria.set(categoria);
    }
    
    public Categoria getCategoria(){
        return categoria.get();
    }

    public void exibeTodasMovimentacoes() {
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdMovimentacao());
        System.out.println("Data = " + getData());
        System.out.println("Descrição = " + getDescricao());
        System.out.println("Valor = R$ " + getValor());
        System.out.println("Tipo = " + getTipo().getDescricao());
        System.out.println("Categoria = " + getCategoria().getDescricao());
    }
}
