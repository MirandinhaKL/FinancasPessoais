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
    private StringProperty descricaoTipo;

    public TipoDeMovimentacao() {
        this.idTipoMovimentacao = new SimpleIntegerProperty();
        this.descricaoTipo = new SimpleStringProperty();
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

    public String getDescricaoTipo() {
        return descricaoTipo.get();
    }

    public void setDescricaoTipo(String descricao) {
        this.descricaoTipo.set(descricao);
    }
    
    public StringProperty getDescricaoProperty(){
        return descricaoTipo;
    }

     public void exibeTiposDeMovimetacoes(){
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdTipoMovimentacao());
        System.out.println("Descrição= " + getDescricaoTipo());
    }

    @Override
    public String toString() {
        return getDescricaoTipo();
    }
    
//     @Override
//    public String toString() {
//        return "TipoDeMovimentacao{" + "idTipoMovimentacao=" + idTipoMovimentacao + ", descricaoTipo=" + descricaoTipo + '}';
//    }
}
