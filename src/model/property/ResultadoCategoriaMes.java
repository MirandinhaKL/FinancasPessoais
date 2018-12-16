package model.property;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class ResultadoCategoriaMes {

    private StringProperty categoria;
    private DoubleProperty valorSomado;
    
    public ResultadoCategoriaMes(String nomeCategoria, double somatorio) {
        this.categoria = new SimpleStringProperty(nomeCategoria);
        this.valorSomado = new SimpleDoubleProperty(somatorio);
    }

    public StringProperty getCategoria() {
        return categoria;
    }

    public void setCategoria(StringProperty categoria) {
        this.categoria = categoria;
    }

    public DoubleProperty getValorSomado() {
        return valorSomado;
    }

    public void setValorSomado(DoubleProperty valorSomado) {
        this.valorSomado = valorSomado;
    }
    
    @Override
    public String toString() {
        return "ResultadoCategoriaMes{" + "categoria=" + categoria + ", valorSomado=" + valorSomado + '}';
    }
}
