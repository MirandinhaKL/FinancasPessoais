package model.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class Categoria {

    private IntegerProperty idCategoria;
    private StringProperty descricao;

    public Categoria() {
       
    }
    
    public Categoria(String descricao){
        this.descricao = new SimpleStringProperty(descricao);
    }
    
    public Categoria(int idCategoria){
        this.idCategoria = idCategoria;
    }

    public Categoria(int idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = new SimpleStringProperty(descricao);
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }
    
    public StringProperty getDescricaoProperty(){
        return descricao;
    }

     public void exibeDadosCategoria(){
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdCategoria());
        System.out.println("Descrição= " + getDescricao());
    }

}
