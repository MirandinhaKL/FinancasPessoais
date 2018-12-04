package model.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class TipoDeMovimentacao {
    
    private IntegerProperty idTipoMovimentacao;
    private StringProperty descricao;

    public TipoDeMovimentacao() {
        this.idTipoMovimentacao = new SimpleIntegerProperty();
        this.descricao = new SimpleStringProperty();
    }
    
    
    public int getIdTipoMovimentacao() {
        return idTipoMovimentacao.get();
    }

    public void setIdTipoMovimentacao(int idMovimentacao) {
        this.idTipoMovimentacao.set(idMovimentacao);
    }
    
    public IntegerProperty getIdTipoMovimentacaoProperty(){
        return idTipoMovimentacao;
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }
    
    public StringProperty descricaoProperty(){
        return descricao;
    }

     public void exibeTiposDeMovimetacoes(){
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdTipoMovimentacao());
        System.out.println("Descrição= " + getDescricao());
    }

    @Override
    public String toString() {
        return "TipoDeMovimentacao{" + "idTipoMovimentacao=" + idTipoMovimentacao + ", descricao=" + descricao + '}';
    }
}
