package model.property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class TipoDeMovimentacao {
    
    private int idTipoMovimentacao;
    private StringProperty descricao;
    private String descricaoBD;

    public TipoDeMovimentacao(int idMovimentacao, String descricao) {
        this.idTipoMovimentacao = idMovimentacao;
       // this.descricao = new SimpleStringProperty(descricao);
        this.descricaoBD = descricao;
    }
    
    public TipoDeMovimentacao(){
        
    }
    
     public TipoDeMovimentacao(int idMovimentacao){
        this.idTipoMovimentacao = idMovimentacao;
    }
    
    public TipoDeMovimentacao(String descricao){
        this.descricao = new SimpleStringProperty(descricao);
        this.descricaoBD = descricao;
    }
    
    public int getIdTipoMovimentacao() {
        return idTipoMovimentacao;
    }

    public void setIdTipoMovimentacao(int idMovimentacao) {
        this.idTipoMovimentacao = idMovimentacao;
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

    public String getDescricaoBD() {
        return descricaoBD;
    }

    public void setDescricaoBD(String descricaoBD) {
        this.descricaoBD = descricaoBD;
    }
    
    
     public void exibeTiposDeMovimetacoes(){
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdTipoMovimentacao());
        System.out.println("Descrição= " + getDescricaoBD());
    }

//    @Override
//    public String toString() {
//        return "TipoDeMovimentacao{" + "idTipoMovimentacao=" + idTipoMovimentacao + ", descricao=" + descricao + ", descricaoBD=" + descricaoBD + '}';
//    }
    
    @Override
    public String toString() {
        return getDescricaoBD();
    }
     
     
}
