package model.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class Categoria {

    private IntegerProperty idCategoria;
    private StringProperty descricao;

    
    public Categoria(){
        this.idCategoria = new SimpleIntegerProperty();
        this.descricao = new SimpleStringProperty();
    }

    public int getIdCategoria() {
        return idCategoria.get();
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria.set(idCategoria);
    }
    
    public IntegerProperty getIdCategoriaProperty(){
        return idCategoria;
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

    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", descricao=" + descricao + '}';
    }
     
     

}
