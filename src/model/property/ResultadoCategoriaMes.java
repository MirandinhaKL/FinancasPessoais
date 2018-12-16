package model.property;

/**
 * @author Mirandinha
 */
public class ResultadoCategoriaMes {

    private String categoria;
    private double valorSomado;
    
    public ResultadoCategoriaMes(String nomeCategoria, double somatorio) {
        this.categoria = nomeCategoria;
        this.valorSomado = somatorio;
    }
    
//    public ResultadoCategoriaMes(String nomeCategoria, double somatorio) {
//        this.categoria = nomeCategoria;
//        this.valorSomado = somatorio;
//    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValorSomado() {
        return valorSomado;
    }

    public void setValorSomado(double valorSomado) {
        this.valorSomado = valorSomado;
    }
}
